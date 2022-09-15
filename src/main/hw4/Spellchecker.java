package main.hw4;
//Name: Julian Noeske

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.lang.*;

public class Spellchecker{

    public static void main(String[] args) throws IOException {
        QuadraticProbingHashTable qHashTable = new QuadraticProbingHashTable();
        Scanner myReader = null;
        Scanner myReader1 = null;
        try {
            File myObj = new File("/home/app00jul/Desktop/classes/CS-284-codes/src/main/hw4/wordsEn.txt"); // please use your own file path
            File myObj1 = new File("/home/app00jul/Desktop/classes/CS-284-codes/src/main/hw4/document1_short.txt");
            myReader = new Scanner(myObj);
            myReader1 = new Scanner(myObj1);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                qHashTable.insert(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        wordLoop:
        while (myReader1.hasNext()) {
            String exact_word = myReader1.next();
            String word = exact_word.toLowerCase(Locale.ROOT);
            word = word.replaceAll("[^A-Za-z ]", "");
            if (qHashTable.contains(word)) {
                System.out.println(word);
            } else {
                String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "k", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
                String alpha = alphabet.toString();
                String n;
                for(int i = 0; i < alphabet.length; i++){
                    for(int j = 0; j < word.length(); j++){
                        StringBuilder newString = new StringBuilder(word);
                        newString.insert(j, alphabet[i]);
                        String a = newString.toString();
                        if(qHashTable.contains(a)){
                            System.out.println(a + " " + word);
                            continue wordLoop;
                        }
                    }
                }
                for(int j = 0; j < word.length()-1; j++) {
                    StringBuilder swapping = new StringBuilder(word);
                    swapping.setCharAt(j+1,word.charAt(j));
                    swapping.setCharAt(j,word.charAt(j+1));

                    String swapped = swapping.toString();

                    if (qHashTable.contains(swapped)) {
                        System.out.println(swapped + " " + word);
                        continue wordLoop;
                    }
                }
                for(int j = 0; j < word.length(); j++) {
                    StringBuilder newString = new StringBuilder(word);
                    newString.deleteCharAt(j);
                    String b = newString.toString();
                    if (qHashTable.contains(b)) {
                        System.out.println(b + " " + word);
                        continue wordLoop;
                    }
                }

            }
        }
    }

    private  static void exch(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
