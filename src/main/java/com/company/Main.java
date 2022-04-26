package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            //Scanner scn = new Scanner(args[0]);
            File file = new File(args[0]);
            Scanner scn = new Scanner(file);

            WordLengthCounter wordCounter = new WordLengthCounter(scn);

            System.out.println(wordCounter.getWordCount());
            System.out.println(wordCounter.getAverage());
            System.out.println(wordCounter.getWordLengthCountDisplay());
            System.out.println(wordCounter.getMaxCounts());
        } catch (IOException ioException){
            System.out.println("Error: filepath or name incorrect");
        }

    }
}
