package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        File input = new File("Input.txt");

        try (Scanner scan = new Scanner(input)) {
            String res_big = "";
            while (scan.hasNextLine()) {
                String buf = scan.nextLine();
                String[] sentences = buf.split("[\\!|\\.|\\?]\\s?");
                int p = 0;
                for (String sentence : sentences) {
                    String[] words = sentence.split("[\\s,.:!?()\"—]+");
                    String w1 = words[0];
                    String w2 = words[words.length - 1];
                    int pos = sentence.indexOf(w2);
                    String res = w2 + sentence.substring(w1.length(), pos) + w1;
                    p += res.length();
                    res_big += res + buf.charAt(p) + " ";
                    p += 2;
                }
            }
            System.out.println(res_big);
        }
        catch (FileNotFoundException exp) {
            System.out.println("I don't see file, bro :C");
        }
    }
}