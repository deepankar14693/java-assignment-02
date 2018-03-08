package edu.knoldus.TwitterApi;

import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * implementing twitter operations and analytics.
 */
class TwitterImplementation {
    /**
     * main method starts.
     *
     * @param args array of string
     * @throws InterruptedException thrown by twitter object
     */
    public static void main(final String[] args)
            throws InterruptedException {
        TwitterApplication tweets = new TwitterApplication();
        TwitterOperations tweetOperations = new TwitterOperations();
        int time = 10000;

        List<Status> useTweets = new ArrayList<>();
        CompletableFuture<List<Status>> fetchedTweets = tweets
                .fetchTweets("#KatrinaKaif", tweetOperations.twitter);
        fetchedTweets.thenAccept(x -> x.forEach(System.out::println));


        //fetchedTweets.thenApply (x -> x.stream ().map (useTweets::add));
        //System.out.println (useTweets.size ());
        CompletableFuture<Integer> tweetCount = tweets.countTweets(
                "#KatrinaKaif", tweetOperations.twitter);
        tweetCount.thenAccept(x -> System.out.println (
                "Number of tweets are : " + x));
        //System.out.println ("Number of tweets are : "+tweetCount);

        CompletableFuture<Double> averageTweetCount = tweets
                .findAverageTweetsPerDay(tweetOperations.twitter);
        averageTweetCount.thenAccept(x -> System.out.println(
                "average Number of tweets are : " + x));

        CompletableFuture<Double> averageLikes = tweets
                .getAverageNumOfLikes(tweetOperations.twitter, "#KatrinaKaif");
        averageLikes.thenAccept(x -> System.out.println(
                "average Number of likes are : " + x));

        CompletableFuture<Double> averageRetweets = tweets
                .getAverageReTweets(tweetOperations.twitter, "#KatrinaKaif");
        averageRetweets.thenAccept(x -> System.out.println(
                "average Number of retweets are : " + x));


        Thread.sleep(time);
    }

}


