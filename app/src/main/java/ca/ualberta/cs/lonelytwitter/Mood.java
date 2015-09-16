package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bq on 9/15/15.
 */
public abstract class Mood {
    private String currentmood;
    private Date data;
    public abstract String representMood();

    public Mood(String currentmood, Date data) {
        this.currentmood = currentmood;
        this.data = data;
    }
    //getter and setter

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCurrentmood() {
        return currentmood;
    }

    public void setCurrentmood(String currentmood) {
        this.currentmood = currentmood;
    }

    public Mood(String currentmood) {
        this.currentmood = currentmood;
        this.data=new Date();
    }

}
