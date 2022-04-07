package main.HW4;

public class Quick{
    public static void shuffling(Comparable [] a){

    }

    public static void sort(Comparable [] a){
        //StdRandom.shuffle(a);
        //sort(a,0, a.length - 1);
    }

    public static int partition(int a[], int low, int high){
        int pivot = a[high];
        int i = (low - 1);
        for (int j = low; j < high; j++){
            if (a[j] < pivot) {
                i++;

                int temp = a[j];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i+1];
        a[i+1] = a[high];
        a[high] = temp;

        return i+1;
    }

    private static void sort(int a [], int low, int high){
        if (low < high){
            int pi = partition(a, low, high);
            sort(a, low, pi-1);
            sort(a, pi + 1, high);
        } else{
            return;
        }
    }
}
