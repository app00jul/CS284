package main.HW3;

import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        //    test names
        //    generate an array of first names
        Firstnames[] names = new Firstnames[10];

        for (int i = 0; i < names.length; i++) {
            names[i] = new Firstnames();
        }

        System.out.println("Bubble sort: names");
        System.out.println(Arrays.toString(names));
        long start = System.nanoTime();
        Bubble.sort(names);
        long end = System.nanoTime();
        long wallClockTime = end - start;
//      1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime / Math.pow(10, 9) + "seconds");
        System.out.println(Arrays.toString(names));
    }

    public static void names_insertion(String[] args) {
        //    test names
        //    generate an array of first names
        Firstnames[] names = new Firstnames[10];

        for (int i = 0; i < names.length; i++) {
            names[i] = new Firstnames();
        }

        System.out.println("Insertion sort: names");
        System.out.println(Arrays.toString(names));
        long start = System.nanoTime();
        Insertion.sort(names);
        long end = System.nanoTime();
        long wallClockTime = end - start;
//      1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime / Math.pow(10, 9) + "seconds");
        System.out.println(Arrays.toString(names));
    }

    public static void names_merge(String[] args) {
        //    test names
        //    generate an array of first names
        Firstnames[] names = new Firstnames[10];

        for (int i = 0; i < names.length; i++) {
            names[i] = new Firstnames();
        }

        System.out.println("Merge sort: names");
        System.out.println(Arrays.toString(names));
        long start = System.nanoTime();
        Merge.sort(names);
        long end = System.nanoTime();
        long wallClockTime = end - start;
//      1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime / Math.pow(10, 9) + "seconds");
        System.out.println(Arrays.toString(names));
    }

    public static void names_quick(String[] args) {
        //    test names
        //    generate an array of first names
        Firstnames[] names = new Firstnames[10];

        for (int i = 0; i < names.length; i++) {
            names[i] = new Firstnames();
        }

        System.out.println("Quick sort: names");
        System.out.println(Arrays.toString(names));
        long start = System.nanoTime();
        Quick.sort(names);
        long end = System.nanoTime();
        long wallClockTime = end - start;
//      1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime / Math.pow(10, 9) + "seconds");
        System.out.println(Arrays.toString(names));
    }

    public static void names_selection(String[] args) {
        //    test names
        //    generate an array of first names
        Firstnames[] names = new Firstnames[10];

        for (int i = 0; i < names.length; i++) {
            names[i] = new Firstnames();
        }

        System.out.println("Selection sort: names");
        System.out.println(Arrays.toString(names));
        long start = System.nanoTime();
        Selection.sort(names);
        long end = System.nanoTime();
        long wallClockTime = end - start;
//      1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime / Math.pow(10, 9) + "seconds");
        System.out.println(Arrays.toString(names));
    }

    public static void dates_bubble(String[] args) {
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
//      1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime/Math.pow(10, 9) + "seconds");
        System.out.println(Arrays.toString(dates));
        Shuffling.shuffle(dates,1,10);
        System.out.println(Arrays.toString(dates));
        Bubble.sort(dates);
        System.out.println(Arrays.toString(dates));
    }

    public static void dates_insertion(String[] args) {
        Dates[] dates = new Dates[10];
        for (int i = 0; i < dates.length; i++){
            dates[i] = new Dates();
        }
        System.out.println("Insertion sort: dates");
        System.out.println(Arrays.toString(dates));
        long start = System.nanoTime();
        Insertion.sort(dates);
        long end = System.nanoTime();
        long wallClockTime = end - start;
//      1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime/Math.pow(10, 9) + "seconds");
        System.out.println(Arrays.toString(dates));
        Shuffling.shuffle(dates,1,10);
        System.out.println(Arrays.toString(dates));
        Insertion.sort(dates);
        System.out.println(Arrays.toString(dates));
    }

    public static void dates_merge(String[] args) {
        Dates[] dates = new Dates[10];
        for (int i = 0; i < dates.length; i++){
            dates[i] = new Dates();
        }
        System.out.println("Merge sort: dates");
        System.out.println(Arrays.toString(dates));
        long start = System.nanoTime();
        Merge.sort(dates);
        long end = System.nanoTime();
        long wallClockTime = end - start;
//      1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime/Math.pow(10, 9) + "seconds");
        System.out.println(Arrays.toString(dates));
        Shuffling.shuffle(dates,1,10);
        System.out.println(Arrays.toString(dates));
        Merge.sort(dates);
        System.out.println(Arrays.toString(dates));
    }

    public static void dates_quick(String[] args) {
        Dates[] dates = new Dates[10];
        for (int i = 0; i < dates.length; i++){
            dates[i] = new Dates();
        }
        System.out.println("Quick sort: dates");
        System.out.println(Arrays.toString(dates));
        long start = System.nanoTime();
        Quick.sort(dates);
        long end = System.nanoTime();
        long wallClockTime = end - start;
//      1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime/Math.pow(10, 9) + "seconds");
        System.out.println(Arrays.toString(dates));
        Shuffling.shuffle(dates,1,10);
        System.out.println(Arrays.toString(dates));
        Quick.sort(dates);
        System.out.println(Arrays.toString(dates));
    }

    public static void dates_selection(String[] args) {
        Dates[] dates = new Dates[10];
        for (int i = 0; i < dates.length; i++){
            dates[i] = new Dates();
        }
        System.out.println("Selection sort: dates");
        System.out.println(Arrays.toString(dates));
        long start = System.nanoTime();
        Selection.sort(dates);
        long end = System.nanoTime();
        long wallClockTime = end - start;
//      1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime/Math.pow(10, 9) + "seconds");
        System.out.println(Arrays.toString(dates));
        Shuffling.shuffle(dates,1,10);
        System.out.println(Arrays.toString(dates));
        Selection.sort(dates);
        System.out.println(Arrays.toString(dates));
    }
}