package katas.exercises;

public class LongestCommonPrefix {

    /**
     * Finds the longest common prefix in an array of strings.
     *
     * @param strs the array of strings
     * @return the longest common prefix, or an empty string if none exists
     */
    public static String longestCommonPrefix(String[] strs) {


        return "";
    }

    public static void main(String[] args) {
        String[] test1 = {"flower", "flow", "flight"};
        String[] test2 = {"dog", "racecar", "car"};
        String[] test3 = {"interspecies", "interstellar", "interstate"};
        String[] test4 = {"apple", "apricot", "ape"};

        System.out.println("Longest Common Prefix: " + longestCommonPrefix(test1)); // Output: "fl"
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(test2)); // Output: ""
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(test3)); // Output: "inter"
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(test4)); // Output: "ap"
    }
}
