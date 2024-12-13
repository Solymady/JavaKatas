package katas.exercises;

public class WordCounter {

    /**
     * Counts the number of words in a given sentence.
     *
     * @param sentence the input string (a sentence)
     * @return the number of words in the sentence
     */
    public static int countWords(String sentence) {

        int count = 0;

        if (sentence == null || sentence.isEmpty()) { return count; }
        if (sentence.matches("\\s+")) { return count; }

        sentence=sentence.trim();
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ' && Character.isLetter(sentence.charAt(i + 1))){
                count++;
            }
        }
        count++;;
        return count;
    }

    public static void main(String[] args) {
        String sentence = "This is a sample sentence for counting words.";
        int wordCount = countWords(sentence);
        System.out.println(wordCount);
    }
}

