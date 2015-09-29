package ca.ualberta.cs.lonelytwitter;

import com.google.gson.internal.bind.ArrayTypeAdapter;

import java.util.ArrayList;

/**
 * Created by bq on 9/29/15.
 */
public class TweetList {

    private Tweet mostRecentTweet;
    private ArrayList tweets = new ArrayList<Tweet>();
    private ArrayList chronlist = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        mostRecentTweet = tweet;
        tweets.add(tweet);
    }

    public Tweet getMostRecentTweet() {
        return mostRecentTweet;
    }

    public int count() {
        return tweets.size();
    }

    public void addTweet(Tweet tweet) {
        int i;
        for (i = 0; i < tweets.size(); i++){
            if( tweets.get(i)==tweet){
                throw new IllegalArgumentException();
            }else{
                tweets.add(tweet);
            }
        }


        }



    public ArrayList<Tweet> getTweets() {


        return tweets;
    }

    public Boolean hasTweet(Tweet tweet) {
        int i;
        Boolean ifhas=Boolean.TRUE;
        for (i = 0; i < tweets.size(); i++) {
             if( tweets.get(i)==tweet){
                 ifhas=Boolean.FALSE;
             }

        }
        return ifhas;

    }
    public void removeTweet(Tweet tweet){
        int i;
        for (i = 0; i < tweets.size(); i++){
            if (tweets.get(i)==tweet){
                tweets.remove(i);
            }
        }
    }
    public int getCount(){
        int num;
        num=tweets.size();
        return num;

    }
}
