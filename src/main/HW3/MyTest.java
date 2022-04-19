package main.HW3;

import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        //    test names
        //    generate an array of first names
        Firstnames[] names = new Firstnames[10];

        for (int i = 0; i < names.length; i++){
            names[i] = new Firstnames();
        }

        System.out.println("Bubble sort: names");
        System.out.println(Arrays.toString(names));
        long start = System.nanoTime();
        Bubble.sort(names);
        long end = System.nanoTime();
        long wallClockTime = end - start;
//        1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime/Math.pow(10, 9) + "seconds");
        System.out.println(Arrays.toString(names));

/*
        Dates[] dates = new Dates[10];
        for (int i = 0; i < dates.length; i++){
            dates[i] = new Dates();
        }
        System.out.println("Bubble sort: dates");
        System.out.println(Arrays.toString(dates));
        long start = System.nanoTime();
        Bubble.sort(dates);
        long end = System.nanoTime();
        long wallClockTime = end - start;
//        1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime/Math.pow(10, 9) + "seconds");
        System.out.println(Arrays.toString(dates));
        //Shuffling.shuffle(dates);
        System.out.println(Arrays.toString(dates));
        Bubble.sort(dates);
        System.out.println(Arrays.toString(dates));
 */
    }
}