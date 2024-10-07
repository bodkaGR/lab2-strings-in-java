package com.bodkasoft;

import java.util.List;

/* TODO
* C3 = 1 (String)
* C17 = 7 (Відсортувати слова заданого тексту, що починаються з голосних літер, за другою літерою.)
* */

public class Main {
    public static void main(String[] args) {
        String text = "In the quiet of early morning, the world seemed to hold its breath. " +
                "The sky, tinged with soft shades of pink and gold, hinted at the day’s promise. " +
                "A gentle breeze rustled the leaves, carrying with it the scent of fresh dew. " +
                "As the first rays of sunlight stretched across the horizon, they illuminated the path ahead, " +
                "reminding everyone that each new day holds the potential for growth, hope, and endless possibilities." +
                " All it takes is a single step forward to begin the journey.";

        try{
            System.out.println("<---Text--->");
            System.out.println(text);
            System.out.println();

            StringProcessor processor = new StringProcessor(text);

            List<String> wordsInText = processor.splitIntoWords();

            List<String> wordsWithVowel = processor.findVowel(wordsInText);

            System.out.println("<---Words with Vowels--->");
            System.out.println(wordsWithVowel);
            System.out.println();

            System.out.println("<---Sorted Words--->");
            System.out.println(processor.sortBySecondLetter(wordsWithVowel));

        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}