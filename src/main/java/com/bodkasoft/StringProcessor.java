package com.bodkasoft;

import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringProcessor {

    private final String text;

    public StringProcessor(String text) {
        if (text == null || text.isEmpty()){
            throw new IllegalArgumentException("String cannot be null or empty");
        }

        this.text = text;
    }

    public String[] splitIntoWords() {
        String regex = "\\w+(-\\w+)*('\\w+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int wordCount = 0;
        while (matcher.find()) {
            wordCount++;
        }

        String[] words = new String[wordCount];

        matcher.reset();

        int index = 0;
        while (matcher.find()) {
            words[index++] = matcher.group();
        }

        return words;
    }

    public String[] findVowel(String[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException("Words array cannot be null or empty");
        }

        int count = countVowelWords(words);

        String[] result = new String[count];
        int index = 0;

        for (String word : words) {
            if (isValidVowelWord(word)) {
                result[index++] = word;
            }
        }

        return result;
    }

    private boolean isValidVowelWord(String word) {
        return word != null && word.length() >= 2 && "aeiouAEIOU".indexOf(word.charAt(0)) != -1;
    }

    private int countVowelWords(String[] words) {
        int count = 0;
        for (String word : words) {
            if (isValidVowelWord(word)) {
                count++;
            }
        }
        return count;
    }

    public String[] sortBySecondLetter(String[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException("Words array cannot be null or empty");
        }

        for (String word : words) {
            if (word.length() < 2) {
                throw new IllegalArgumentException("All words must have at least 2 characters");
            }
        }

        Arrays.sort(words, (word1, word2) -> Character.compare(word1.charAt(1), word2.charAt(1)));

        return words;
    }
}
