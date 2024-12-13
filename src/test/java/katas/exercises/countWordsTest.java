package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class countWordsTest {

    @Test
    public void testCountWords_basicSentence() {
        String sentence = "This is a sample sentence for counting words.";
        int wordCount = WordCounter.countWords(sentence);
        assertEquals(8, wordCount);
    }

    @Test
    public void testCountWords_singleWord() {
        String sentence = "Hello";
        int wordCount = WordCounter.countWords(sentence);
        assertEquals(1, wordCount);
    }

    @Test
    public void testCountWords_emptyString() {
        String sentence = "";
        int wordCount = WordCounter.countWords(sentence);
        assertEquals(0, wordCount);
    }

    @Test
    public void testCountWords_multipleSpaces() {
        String sentence = "This  is   a    test";
        int wordCount = WordCounter.countWords(sentence);
        assertEquals(4, wordCount);
    }

    @Test
    public void testCountWords_sentenceWithLeadingSpace() {
        String sentence = "  Leading space";
        int wordCount = WordCounter.countWords(sentence);
        assertEquals(2, wordCount);
    }

    @Test
    public void testCountWords_sentenceWithTrailingSpace() {
        String sentence = "Trailing space   ";
        int wordCount = WordCounter.countWords(sentence);
        assertEquals(2, wordCount);
    }

    @Test
    public void testCountWords_sentenceWithOnlySpaces() {
        String sentence = "     ";
        int wordCount = WordCounter.countWords(sentence);
        assertEquals(0, wordCount);
    }

    @Test
    public void testCountWords_sentenceWithPunctuation() {
        String sentence = "Hello, world! This is a test.";
        int wordCount = WordCounter.countWords(sentence);
        assertEquals(6, wordCount);
    }
}