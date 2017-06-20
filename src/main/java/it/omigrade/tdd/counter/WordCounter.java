package it.omigrade.tdd.counter;

/**
 * <br><br>Created by Omi087 on 19/06/2017.
 */
public class WordCounter {

    public static int count(String word) {
        return word.split(" ").length;
    }
}
