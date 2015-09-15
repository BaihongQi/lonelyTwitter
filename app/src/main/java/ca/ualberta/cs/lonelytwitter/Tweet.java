package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.IllegalFormatCodePointException;

/**
 * Created by bq on 9/15/15.
 */
public abstract class Tweet extends Object implements Tweetable{
    private String text;
    private Date date;
    ArrayList<Mood> moodlist;
    public Tweet(String tweet, Date date) {
        text = tweet;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text){
        if (text.length()<=140) {
            this.text = text;
        }else{
            throw new IllegalArgumentException("Tweets cannot be that long");
        }

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Tweet(String text) {
        this.text = text;
        this.date=new Date();
    }
    public abstract Boolean isImportant();
}
