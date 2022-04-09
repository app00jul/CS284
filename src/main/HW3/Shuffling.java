package main.HW3;

public class Shuffling {
    //    random shuffling
//    Knuth shuffle
    private static int swaps = 0;

    public static void swap(Comparable[] arr, int i, int j) {
//        Comparable temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
    }

    public static void shuffle(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            //         min and max
            //         range = max - min + 1
            //        int rand = (int)(Math.random() * range) + min;

            // choose index uniformly in [0, i]
            // or choose index uniformly in [i, n-1]
//            swap(a, i, r);
//            count the number of swaps
        }
    }
}