package com.company;


import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class WordLengthCounterTest {

    WordLengthCounter wordLengthCounter;
    Scanner scan;
    InputStream in;

    @Test
    void getAverage() {
        in = new ByteArrayInputStream("Hello world & good morning. The date is 18/05/2016".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals("Average word length = 4.556", wordLengthCounter.getAverage());

        in = new ByteArrayInputStream("a a a a a a a a a a a a a a a a a a a a a a".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals("Average word length = 1", wordLengthCounter.getAverage());

        in = new ByteArrayInputStream("aaaaaaaaaaaaaaaaaaaaaaa".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals("Average word length = 23", wordLengthCounter.getAverage());

        in = new ByteArrayInputStream("7777777 666666 55555 4444 333 22 1".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals("Average word length = 4", wordLengthCounter.getAverage());
    }

    @Test
    void getWordCount() {
        in = new ByteArrayInputStream("Hello world & good morning. The date is 18/05/2016".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals("Word count = 9", wordLengthCounter.getWordCount());

        in = new ByteArrayInputStream("a a a a a a a a a a a a a a a a a a a a a a".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals("Word count = 22", wordLengthCounter.getWordCount());

        in = new ByteArrayInputStream("aaaaaaaaaaaaaaaaaaaaaaa".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals("Word count = 1", wordLengthCounter.getWordCount());

        in = new ByteArrayInputStream("7777777 666666 55555 4444 333 22 1".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals("Word count = 7", wordLengthCounter.getWordCount());
    }

    @Test
    void getMaxCounts() {
        in = new ByteArrayInputStream("Hello world & good morning. The date is 18/05/2016".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals("The most frequently occurring word length is 2, for word lengths of 4 & 5", wordLengthCounter.getMaxCounts());

        in = new ByteArrayInputStream("a a a a a a a a a a a a a a a a a a a a a a".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals("The most frequently occurring word length is 22, for word lengths of 1", wordLengthCounter.getMaxCounts());

        in = new ByteArrayInputStream("aaaaaaaaaaaaaaaaaaaaaaa".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals("The most frequently occurring word length is 1, for word lengths of 23", wordLengthCounter.getMaxCounts());

        in = new ByteArrayInputStream("7777777 666666 55555 4444 333 22 1".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals("The most frequently occurring word length is 1, for word lengths of 1, 2, 3, 4, 5, 6 & 7", wordLengthCounter.getMaxCounts());
    }

    @Test
    void getWordLengthCountDisplay() {
        in = new ByteArrayInputStream("Hello world & good morning. The date is 18/05/2016".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals(
                "Number of words of length 1 is 1\n" +
                        "Number of words of length 2 is 1\n" +
                        "Number of words of length 3 is 1\n" +
                        "Number of words of length 4 is 2\n" +
                        "Number of words of length 5 is 2\n" +
                        "Number of words of length 7 is 1\n" +
                        "Number of words of length 10 is 1\n"
                , wordLengthCounter.getWordLengthCountDisplay());

        in = new ByteArrayInputStream("a a a a a a a a a a a a a a a a a a a a a a".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals(
                "Number of words of length 1 is 22\n"
                , wordLengthCounter.getWordLengthCountDisplay());

        in = new ByteArrayInputStream("aaaaaaaaaaaaaaaaaaaaaaa".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals(
                "Number of words of length 23 is 1\n"
                , wordLengthCounter.getWordLengthCountDisplay());

        in = new ByteArrayInputStream("7777777 666666 55555 4444 333 22 1".getBytes());
        scan = new Scanner(in);
        wordLengthCounter = new WordLengthCounter(scan);
        assertEquals(
                "Number of words of length 1 is 1\n" +
                        "Number of words of length 2 is 1\n" +
                        "Number of words of length 3 is 1\n" +
                        "Number of words of length 4 is 1\n" +
                        "Number of words of length 5 is 1\n" +
                        "Number of words of length 6 is 1\n" +
                        "Number of words of length 7 is 1\n"
                , wordLengthCounter.getWordLengthCountDisplay());
    }
}