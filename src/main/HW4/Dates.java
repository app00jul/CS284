package main.HW4;

public class Dates implements Comparable<Dates>{
    private int day;

    public int compareTo(Dates Other_Date){
        if (this.day > Other_Date.day){
            return 1;
        } else if (this.day < Other_Date.day){
            return -1;
        } else {
            return 0;
        }
    }
}
