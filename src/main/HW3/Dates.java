package main.HW3;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class Dates implements Comparable<Dates>{
    private String date;

    public Dates() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
//        randomly generate a year, month and day
//        range of year: [1000, 2022]
//        range of month: [1, 12] ([0, 11] for calendar)
        //LocalDate start_date = LocalDate.of(1000,1,1);
        //long start = start_date.toEpochDay();
        //System.out.println(start);
        Random rand = new Random();
        int year = rand.nextInt((2022-1000)+1)+1000;
        int month = rand.nextInt((12-1)+1)+1;
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
