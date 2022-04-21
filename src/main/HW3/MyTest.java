package main.HW3;

import java.util.Arrays;

public class MyTest {
    public static void names_bubble(String[] args) {
        long start = System.nanoTime();
        System.out.println("Bubble sort: names");

        for (int i = 0; i != 100; i++) {
            Firstnames[] names = new Firstnames[10];
            for (int j = 0; j != names.length; j++){
                names[j] = new Firstnames();
            }

            Bubble.sort(names);
            System.out.println(Arrays.toString(names));
        }

        long end = System.nanoTime();
        long wallClockTime = end - start;

        System.out.println(Bubble.getSwap()/100);
        System.out.println((wallClockTime / Math.pow(10, 9))/100 + "seconds");
    }

    public static void names_insertion(String[] args) {
        long start = System.nanoTime();
        System.out.println("Insertion sort: names");

        for (int i = 0; i != 100; i++) {
            Firstnames[] names = new Firstnames[10];
            for (int j = 0; j != names.length; j++){
                names[j] = new Firstnames();
            }

            Insertion.sort(names);
            System.out.println(Arrays.toString(names));
        }

        long end = System.nanoTime();
        long wallClockTime = end - start;

        System.out.println(Insertion.getSwap()/100);
        System.out.println((wallClockTime / Math.pow(10, 9))/100 + "seconds");
    }

    public static void names_merge(String[] args) {
        long start = System.nanoTime();
        System.out.println("Merge sort: names");

        for (int i = 0; i != 100; i++) {
            Firstnames[] names = new Firstnames[10];
            for (int j = 0; j != names.length; j++){
                names[j] = new Firstnames();
            }

            Merge.sort(names);
            System.out.println(Arrays.toString(names));
        }

        long end = System.nanoTime();
        long wallClockTime = end - start;

        System.out.println(Merge.getSwap()/100);
        System.out.println((wallClockTime / Math.pow(10, 9))/100 + "seconds");
    }

    public static void names_quick(String[] args) {
        long start = System.nanoTime();
        System.out.println("Quick sort: names");

        for (int i = 0; i != 100; i++) {
            Firstnames[] names = new Firstnames[10];
            for (int j = 0; j != names.length; j++){
                names[j] = new Firstnames();
            }

            Quick.sort(names);
            System.out.println(Arrays.toString(names));
        }

        long end = System.nanoTime();
        long wallClockTime = end - start;

        System.out.println(Quick.getSwap()/100);
        System.out.println((wallClockTime / Math.pow(10, 9))/100 + "seconds");
    }

    public static void names_selection(String[] args) {
        long start = System.nanoTime();
        System.out.println("Selection sort: names");

        for (int i = 0; i != 100; i++) {
            Firstnames[] names = new Firstnames[10];
            for (int j = 0; j != names.length; j++){
                names[j] = new Firstnames();
            }

            Selection.sort(names);
            System.out.println(Arrays.toString(names));
        }

        long end = System.nanoTime();
        long wallClockTime = end - start;

        System.out.println(Selection.getSwap()/100);
        System.out.println((wallClockTime / Math.pow(10, 9))/100 + "seconds");
    }

    public static void names_shuffling(String[] args) {
        long start = System.nanoTime();
        System.out.println("Shuffling: names");

        for (int i = 0; i != 100; i++) {
            Firstnames[] names = new Firstnames[10];
            for (int j = 0; j != names.length; j++){
                names[j] = new Firstnames();
            }

            Shuffling.shuffle(names,1,10);
            System.out.println(Arrays.toString(names));
        }

        long end = System.nanoTime();
        long wallClockTime = end - start;

        System.out.println(Shuffling.getSwap()/100);
        System.out.println((wallClockTime / Math.pow(10, 9))/100 + "seconds");
    }

    public static void dates_bubble(String[] args) {
        long start = System.nanoTime();
        System.out.println("Bubble sort: dates");

        for (int i = 0; i != 100; i++) {
            Dates[] dates = new Dates[10];
            for (int j = 0; j != dates.length; j++){
                dates[j] = new Dates();
            }

            Bubble.sort(dates);
            System.out.println(Arrays.toString(dates));
        }

        long end = System.nanoTime();
        long wallClockTime = end - start;

        System.out.println(Bubble.getSwap()/100);
        System.out.println((wallClockTime / Math.pow(10, 9))/100 + "seconds");
    }

    public static void dates_insertion(String[] args) {
        long start = System.nanoTime();
        System.out.println("Insertion sort: dates");

        for (int i = 0; i != 100; i++) {
            Dates[] dates = new Dates[10];
            for (int j = 0; j != dates.length; j++){
                dates[j] = new Dates();
            }

            Insertion.sort(dates);
            System.out.println(Arrays.toString(dates));
        }

        long end = System.nanoTime();
        long wallClockTime = end - start;

        System.out.println(Insertion.getSwap()/100);
        System.out.println((wallClockTime / Math.pow(10, 9))/100 + "seconds");
    }

    public static void dates_merge(String[] args) {
        long start = System.nanoTime();
        System.out.println("Merge sort: dates");

        for (int i = 0; i != 100; i++) {
            Dates[] dates = new Dates[10];
            for (int j = 0; j != dates.length; j++){
                dates[j] = new Dates();
            }

            Merge.sort(dates);
            System.out.println(Arrays.toString(dates));
        }

        long end = System.nanoTime();
        long wallClockTime = end - start;

        System.out.println(Bubble.getSwap()/100);
        System.out.println((wallClockTime / Math.pow(10, 9))/100 + "seconds");
    }

    public static void dates_quick(String[] args) {
        long start = System.nanoTime();
        System.out.println("Quick sort: dates");

        for (int i = 0; i != 100; i++) {
            Dates[] dates = new Dates[10];
            for (int j = 0; j != dates.length; j++){
                dates[j] = new Dates();
            }

            Quick.sort(dates);
            System.out.println(Arrays.toString(dates));
        }

        long end = System.nanoTime();
        long wallClockTime = end - start;

        System.out.println(Quick.getSwap()/100);
        System.out.println((wallClockTime / Math.pow(10, 9))/100 + "seconds");
    }

    public static void dates_selection(String[] args) {
        long start = System.nanoTime();
        System.out.println("Selection sort: dates");

        for (int i = 0; i != 100; i++) {
            Dates[] dates = new Dates[10];
            for (int j = 0; j != dates.length; j++){
                dates[j] = new Dates();
            }

            Selection.sort(dates);
            System.out.println(Arrays.toString(dates));
        }

        long end = System.nanoTime();
        long wallClockTime = end - start;

        System.out.println(Selection.getSwap()/100);
        System.out.println((wallClockTime / Math.pow(10, 9))/100 + "seconds");
    }

    public static void dates_shuffling(String[] args) {
        long start = System.nanoTime();
        System.out.println("Shuffling: dates");

        for (int i = 0; i != 100; i++) {
            Dates[] dates = new Dates[10];
            for (int j = 0; j != dates.length; j++){
                dates[j] = new Dates();
            }

            Shuffling.shuffle(dates,1,10);
            System.out.println(Arrays.toString(dates));
        }

        long end = System.nanoTime();
        long wallClockTime = end - start;

        System.out.println(Shuffling.getSwap()/100);
        System.out.println((wallClockTime / Math.pow(10, 9))/100 + "seconds");
    }
}