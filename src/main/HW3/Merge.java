package main.HW3;

public class Merge {
    private static int swaps = 0;

    public static void sort(Comparable [] a){
        Comparable [] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void sort(Comparable [] a, Comparable [] aux, int low, int high){
        if (high <= low){
            return;
        }
        int mid = low + (high - low)/2;
        sort(a, aux, low, mid);
        sort(a, aux, mid+1, high);
        merge(a, aux, low, mid, high);
    }

    public static void merge(Comparable [] a, Comparable [] aux, int low, int mid, int high){
        for (int k = low; k <= high; k++){
            aux[k] = a[k];
        }

        int i = low;
        int j = mid+1;
        for (int k = low; k <= high; k++){
            if (i > mid){
                a[k] = aux[j++];
                swaps++;
            } else if (j > high){
                a[k] = aux[i++];
                swaps++;
            } else if (a[i].compareTo(a[j]) > 0){
                a[k] = aux[j++];
                swaps++;
            } else{
                a[k] = aux[i++];
                swaps++;
            }
        }
        System.out.println(swaps + " swaps");
    }

    public static int getSwap() {
        return swaps;
    }
}
