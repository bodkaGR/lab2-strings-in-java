package com.bodkasoft;

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

    public List<String> splitIntoWords() {
        String regex = "\\w+(-\\w+)*('\\w+)?";

        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(text)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.toList());
    }

    public List<String> findVowel(List<String> words){
        if (words == null || words.isEmpty()){
            throw new IllegalArgumentException("Words array cannot be null or empty");
        }

        return words.stream()
                .filter(word -> !word.isEmpty() && "aeiouAEIOU".indexOf(word.charAt(0)) != -1 && word.length() >= 2)
                .collect(Collectors.toList());
    }

    public List<String> sortBySecondLetter(List<String> words){
        if (words == null || words.isEmpty()){
            throw new IllegalArgumentException("Words array cannot be null or empty");
        }

        return words.stream()
                .sorted((word1, word2) -> Character.compare(word1.charAt(1), word2.charAt(1)))
                .collect(Collectors.toList());
    }
}
