package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

/**
 * Created by bq on 9/29/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }
    public void setUp(){

    }
    public void tearDown(){

    }
    public void testHoldStuff(){
        TweetList list=new TweetList();
        Tweet tweet =new NormalTweet("test");
        list.add(tweet);
        assertSame(list.getMostRecentTweet(), tweet);
    }
    public void testHoldManyThings(){
        TweetList list=new TweetList();
        Tweet tweet =new NormalTweet("test");
        list.add(tweet);
        assertEquals(list.count(), 1);
        list.add(new NormalTweet("test"));
        assertEquals(list.count(), 2);
    }
}