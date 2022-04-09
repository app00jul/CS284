package main.HW3;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dates implements Comparable<Dates>{
    private String date;

    public Dates() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
//        randomly generate a year, month and day
//        range of year: [1000, 2022]
//        range of month: [1, 12] ([0, 11] for calendar)
    }

    public String toString() {
        return this.date;
    }


    public String getDate() {
        return this.date;
    }

    @Override
    public int compareTo(Dates that) {
        return this.getDate().compareTo(that.getDate());
    }
}
