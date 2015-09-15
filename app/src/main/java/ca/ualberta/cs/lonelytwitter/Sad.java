package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bq on 9/15/15.
 */
public class Sad extends Mood {
    public Sad(String currentmood, Date data) {
        super(currentmood, data);
    }

    public Sad(String currentmood) {
        super(currentmood);
    }



    @Override
    public String representMood() {
        return "Sad";
    }
}
