package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bq on 9/15/15.
 */
public class Happy extends Mood{
    public Happy(String currentmood, Date data) {
        super(currentmood, data);
    }

    public Happy(String currentmood) {
        super(currentmood);
    }


    @Override
    public String representMood() {
        return "Yes happy";
    }

    @Override
    public String getCurrentmood() {
        return "Happy" + super.getCurrentmood();
    }
}
