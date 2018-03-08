package edu.knoldus.TwitterApi;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * this class is basically for instantiating twitter object of class Twitter.
 */
public class TwitterOperations {
    /**
     * cb is an object of configuration builder used for
     * instantiating Twitter object.
     */
    private ConfigurationBuilder cb = new ConfigurationBuilder()
            .setDebugEnabled(true)
            .setOAuthConsumerKey("LdvmZfSCeZtBZAHFw22INxKHY")
            .setOAuthConsumerSecret("LxJtiwCGujG092n5smgM4mxAU1Hwe0Q48I4oZTA"
                    +
                    "vWDsEyr5PbY")
            .setOAuthAccessToken("958634620270010368-YilhL6ULWcn2V13QIsE2ou"
                    +
                    "7vbHR0orv")
            .setOAuthAccessTokenSecret("ykY7chhfe68qROCQKs9RK9Xq3o3X7uWu1"
                    +
                    "MmpbsCIKaZSy");
    /**
     * here Twitter object is created using configuration object.
     */
    protected Twitter twitter = new TwitterFactory(cb.build()).getInstance();
}

