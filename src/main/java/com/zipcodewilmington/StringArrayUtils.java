package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        return new ArrayList<String>(Arrays.asList(array)).contains(value);
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - 1 - i];
        }
        return result;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            if (!array[i].equals(array[array.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        boolean result = true;
        boolean[] beenFound = new boolean[26];
        Arrays.fill(beenFound, false);

        // iterate through each string
        for (String s : array) {
            // iterate through each character of said string
            for (char c : s.toLowerCase().toCharArray()) {
                // ensure we are only accounting for letters of the alphabet
                if(c - 'a' >= 0) {
                    beenFound[c - 'a'] = true;
                }
            }
        }

        // all letters have to be true
        for (boolean b : beenFound) {
            result = result && b;
        }
        return result;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;

        for (String s : array) {
            if (s.equals(value)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        // previous code didn't work so I'm removing it and starting over again
        ArrayList<Integer> idxToRemove = new ArrayList<>();
        for(int i = 1; i < array.length; i++){
            // if the previous element and current are the same, then remove that idx
            if(array[i-1].equals(array[i])){
                idxToRemove.add(i);
            }
        }

        String[] result = new String[array.length - idxToRemove.size()];
        int resultIdx = 0;
        for(int i = 0; i < array.length; i++){
            if(!idxToRemove.contains(i)){
                result[resultIdx] = array[i];
                resultIdx++;
            }
        }
        return result;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        // previous code didn't work so I'm removing it and starting over again
        ArrayList<Integer> idxToRemove = new ArrayList<>();
        for(int i = 1; i < array.length; i++){
            // if the previous element and current are the same, then remove that idx
            if(array[i-1].equals(array[i])){
                idxToRemove.add(i);
            }
        }

        String[] result = new String[array.length - idxToRemove.size()];
        int resultIdx = 0;
        for(int i = 0; i < array.length; i++){
            if(!idxToRemove.contains(i)){
                result[resultIdx] = array[i];
                resultIdx++;
            }
        }
        return result;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        String[] result = removeConsecutiveDuplicates(array);
        int arrayIdx = 0;
        int startingIdx;

        for(int resultIdx = 0; resultIdx < result.length; resultIdx++){
            startingIdx = arrayIdx;
            // find out how many consecutive characters
            while(arrayIdx < array.length && array[arrayIdx].equals(result[resultIdx])){
                arrayIdx++;
            }
            StringBuilder sb = new StringBuilder();
            // use the number of consecutive characters to change the consecutive dupes
            for(int i = 0; i < arrayIdx - startingIdx; i++){
                sb.append(result[resultIdx]);
            }
            result[resultIdx] = sb.toString();
        }
        return result;
    }
}
