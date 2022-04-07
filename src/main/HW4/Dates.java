package main.HW4;

public class Dates implements Comparable<Dates>{
    private int date;

    public int compareTo(Dates Other_Date){
        if (this.date > Other_Date.date){
            return -1;
        } else if (this.date < Other_Date.date){
            return 1;
        } else {
            return 0;
        }
    }
}
