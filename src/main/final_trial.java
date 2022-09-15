package main;

import main.HW3.Comparable;

public class final_trial {
    public static void Array() {
        int[] first = new int[5];
        for (int i = 0; i != 5; i++) {
            System.out.println(first[i]);
        }
        String[] second = {"Hello", "Wub", "Yeet"};
        for (int i = 0; i != second.length; i++) {
            System.out.println(second[i]);
        }
    }

    public void bubble(int a[]){
        int lth = a.length;

        for (int i = 0; i != lth-1 ; i++){
            for (int j = 0; j < lth-i-1; j++){
                if (a[i] >a[j]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static void main(String args[]){
        Array();
    }
}
