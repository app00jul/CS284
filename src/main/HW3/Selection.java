package main.HW3;

public class Selection {
    public static void sort(Comparable [] a){
        int lth = a.length;

        for (int i = 0; i != lth; i++){
            int min = i;
            for (int j = i+1; j != lth; j++){
                if (a[j].compareTo(a[min]) > 0){
                    min = j;
                }
            exchange(a,i,min);
            }
        }
    }

    public static void exchange(Comparable [] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
