package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WordLengthCounter {
    private HashMap<Integer,Integer> wordLengthCounts;

    public WordLengthCounter(Scanner input) {
        wordLengthCounts = getWordLengthCounts(input);
    }

    public HashMap<Integer, Integer> getWordLengthCounts(Scanner inputText) {
        HashMap<Integer, Integer> wordLenCounts = new HashMap();


        while (inputText.hasNextLine()) {
            String line = inputText.nextLine();
            String[] words = line.split("\\s+|\\. "); // Split by space or by full stop with space following

            for(String word: words) {
                if(wordLenCounts.containsKey(word.length())) {
                    wordLenCounts.put(word.length(), wordLenCounts.get(word.length()) + 1);
                } else {
                    wordLenCounts.put(word.length(), 1);
                }
            }
        }

        return wordLenCounts;
    }

    public String getAverage() {
        DecimalFormat df = new DecimalFormat("#.###"); // For formatting average
        int count = 0;
        int sum = 0;

        for(int wordLength : wordLengthCounts.keySet()) {
            count += wordLengthCounts.get(wordLength);
            sum += wordLength * wordLengthCounts.get(wordLength);
        }

        float average = (float) sum / (float) count;

        return "Average word length = " + df.format(average);
    }

    public String getWordCount() {
        int sum = 0;

        for(int count : wordLengthCounts.values()) {
            sum += count;
        }

        return "Word count = " + sum;
    }

    public String getMaxCounts() {
        ArrayList<Integer> maxKeys = new ArrayList<Integer>();
        int max = 0;

        for(int wordLength : wordLengthCounts.keySet()) {
            if(wordLengthCounts.get(wordLength) > max) {
                maxKeys.clear();
                maxKeys.add(wordLength);
                max = wordLengthCounts.get(wordLength);
            } else if(wordLengthCounts.get(wordLength) == max) {
                maxKeys.add(wordLength);
            }
        }

        String maxCounts = "The most frequently occurring word length is " + max + ", for word lengths of ";

        for(int i=0; i<maxKeys.size(); i++) {
            maxCounts += maxKeys.get(i);
            if(i + 2 == maxKeys.size()) {
                maxCounts += " & ";
            } else if(i + 2 < maxKeys.size()) {
                maxCounts += ", ";
            }
        }

        return maxCounts;
    }

    public String getWordLengthCountDisplay() {
        String wordLenCountFreq = "";

        for(int wordLength : wordLengthCounts.keySet()) {
            wordLenCountFreq += "Number of words of length " + wordLength + " is " + wordLengthCounts.get(wordLength) + "\n";
        }

        return wordLenCountFreq;
    }
}