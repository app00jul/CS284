package main.hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestFunctionForHashTable {
    public static void main(String[] args) throws IOException {
        QuadraticProbingHashTable HashTable= new QuadraticProbingHashTable<>();
        try {
            File myObj = new File("/home/app00jul/Desktop/classes/CS-284-codes/src/main/hw4/wordsEn.txt"); // please use your own file path
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                HashTable.insert(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Number of elements: " + HashTable.getNumElements());
        System.out.println("Size of the hash table: " + HashTable.getSize());
        System.out.println("Load factor: " + (HashTable.getNumElements() / (double)HashTable.getSize()));
        System.out.println("Total collisions: " + HashTable.getNumCollisions());
        System.out.println("Avg. number of collisions: " + (HashTable.getNumCollisions() / (double)(HashTable.getNumElements())));

    }
}