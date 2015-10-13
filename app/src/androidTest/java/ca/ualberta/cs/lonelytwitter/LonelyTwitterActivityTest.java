package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private EditText bodyText;
    private Button saveButton;
    private Button editButton;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testEditATweet() {
        // starts lonelyTwitter
        LonelyTwitterActivity activity = (LonelyTwitterActivity)  getActivity();
        //reset the a[[
        activity.getTweets().clear();

        // user clicks on tweet they want to edit
        bodyText = activity.getBodyText();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                bodyText.setText("hamburgers");
            }
        });
        getInstrumentation().waitForIdleSync();
        saveButton = activity.getSaveButton();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                saveButton.performClick();

            }
        });

        getInstrumentation().waitForIdleSync();
        final ListView oldTweetList=activity.getOldTweetsList();
        Tweet tweet=(Tweet)oldTweetList.getItemAtPosition(0);
        assertEquals("hamburgers",tweet.getText());
        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetList.getChildAt(0);
                oldTweetList.performItemClick(v, 0, v.getId());

            }
        });
        // Set up an ActivityMonitor
        Instrumentation.ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(EditTweetActivity.class.getName(),
                        null, false);

    // Validate that ReceiverActivity is started
        //TouchUtils.clickView(this, sendToReceiverButton);
        EditTweetActivity receiverActivity = (EditTweetActivity)
                receiverActivityMonitor.waitForActivityWithTimeout(1000);
        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for ReceiverActivity has not been called",
                1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                EditTweetActivity.class, receiverActivity.getClass());

// Remove the ActivityMonitor
        getInstrumentation().removeMonitor(receiverActivityMonitor);


        //assert that the tweet being shown on the edit screen  is the tweet
        //we clicked on
        editButton = activity.getSaveButton();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                editButton.performClick();

            }
        });
        //edit the text of that tweet
        ArrayList<Tweet> tweets=oldTweetList;
        //save our edits
        getInstrumentation().waitForIdleSync();
        tweets.setTweets("new text");
        assertEquals("new text", tweets.getTweets());
        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetList.getChildAt(0);
                oldTweetList.performItemClick(v, 0, v.getId());

            }
        });
        //assert that out edits were saved into the tweet correctly
        getInstrumentation().waitForIdleSync();
        final ListView oldTweetList2=activity.getOldTweetsList();
        Tweet oldtweet=(Tweet)oldTweetList2.getItemAtPosition(0);
        assertEquals("new text", oldtweet.getText());


        //assert that our edits are shown on the screen to the user
        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetList2.getChildAt(0);
                oldTweetList2.performItemClick(v, 0, v.getId());


            }
        });
        // Set up an ActivityMonitor
        Instrumentation.ActivityMonitor receiverActivityMonitor2 =
                getInstrumentation().addMonitor(EditTweetActivity.class.getName(),
                        null, false);

        // Validate that ReceiverActivity is started
        //TouchUtils.clickView(this, sendToReceiverButton);
        EditTweetActivity receiverActivity2 = (EditTweetActivity)
                receiverActivityMonitor2.waitForActivityWithTimeout(1000);
        assertNotNull("ReceiverActivity is null", receiverActivity2);
        assertEquals("Monitor for ReceiverActivity has not been called",
                1, receiverActivityMonitor2.getHits());
        assertEquals("Activity is of wrong type",
                EditTweetActivity.class, receiverActivity2.getClass());

        // Remove the ActivityMonitor
        getInstrumentation().removeMonitor(receiverActivityMonitor);
        //back in the main activity

        //end of test
        //end of test: make sure the edit activity is closed
        receiverActivity.finish();

    }


}