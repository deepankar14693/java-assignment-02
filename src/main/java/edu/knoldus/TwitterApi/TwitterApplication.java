package edu.knoldus.TwitterApi;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class TwitterApplication {

    final long ConvertToDay = 1000 * 60 * 60 * 24;

    public CompletableFuture<List<Status>>
    fetchTweets(String input, Twitter twitter) {
        Query query = new Query(input);
        return supplyAsync(() ->
                {
                    List<Status> que = new ArrayList<>();
                    try {
                        que = twitter.search(query).getTweets();
                    } catch(TwitterException e) {
                        e.printStackTrace();
                    }
                    return que;
                }
        ).thenApply(x -> x);
    }

    public CompletableFuture<Integer>
    countTweets(String input, Twitter twitter) {
        Query query = new Query(input);
        return supplyAsync(() -> {
                    int count = 0;
                    try {
                        count = twitter.search(query).getTweets().size();
                    } catch(TwitterException e) {
                        e.printStackTrace();
                    }
                    return count;
                }
        );
    }

    public CompletableFuture<Double>
    findAverageTweetsPerDay(Twitter twitter) {
        return supplyAsync(
                () -> {
                    double avg = 0.0;
                    try {
                        Date createdAt = twitter.showUser("BCCI").getCreatedAt();
                        Date now = new Date();
                        long days = (now.getTime() - createdAt.getTime()) / ConvertToDay;
                        int tweetCount = twitter.showUser("BCCI").getStatusesCount ();
                        avg = tweetCount / days;
                    } catch(TwitterException e) {
                        e.printStackTrace();
                    }
                    return avg;
                }
        );
    }

    public CompletableFuture<Double>
    getAverageNumOfLikes(Twitter twitter, String input) {
        Query query = new Query(input);
        return CompletableFuture.supplyAsync(() -> {
            Double averageLikeTweetCount = 0.0;
            try {
                List<Status> twitterStatus = twitter.search(query).getTweets();
                Double tweetsCount = twitterStatus.size() + 0.0;
                averageLikeTweetCount = twitterStatus.parallelStream()
                        .map(tweets -> tweets.getFavoriteCount())
                        .reduce((t1, t2) -> t1 + t2).get() / tweetsCount;
            } catch(TwitterException msg) {
                msg.getMessage();
            }
            return averageLikeTweetCount;
        });
    }

// get Average Number Of ReTweets On the
//Basis of HashTags

    public CompletableFuture<Double>
    getAverageReTweets(Twitter twitter, String input) {
        Query query = new Query(input);
        return CompletableFuture.supplyAsync(() -> {
            Double countOfReTweet = 0.0;
            try {
                List<Status> twitterStatus = twitter.search(query).getTweets();
                Double twitterSize = twitterStatus.size() + 0.0;
                countOfReTweet = twitterStatus.parallelStream()
                        .map(tweets -> tweets.getRetweetCount())
                        .reduce((a, b) -> a + b).get() / twitterSize;
            } catch(TwitterException msg) {
                msg.getMessage();
            }
            return countOfReTweet;
        });

    }

}






