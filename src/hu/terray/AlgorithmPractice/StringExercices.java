package hu.terray.AlgorithmPractice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class with static methods for algorithmical problems.
 */
public class StringExercices {
    public static Character getCharAtIndex(String input, int index) {
        return input.charAt(index);
    }

    public static void compareLexicographicallyIngoreCase(String first, String second) {
        System.out.println("First string: " + first);
        System.out.println("Second string: " + second);
        int compareFirstToSecond = first.compareToIgnoreCase(second);
        if (compareFirstToSecond < 0) {
            System.out.println("First string is bigger than second");
        } else if (compareFirstToSecond == 0) {
            System.out.println("First and second strings are equal");
        } else {
            System.out.println("First string is less than second");
        }
    }

    public static boolean contains(String searchIn, String searchFor) {
        return searchIn.contains(searchFor);
    }

    public static void printDuplicatedCharacters(String inputToSearchIn) {
        Set<Character> charSet = new HashSet<>();
        Set<Character> foundDuplicates = new HashSet<>();
        for (Character actualChar : inputToSearchIn.toCharArray()) {
            if (charSet.contains(actualChar)) {
                foundDuplicates.add(actualChar);
            } else {
                charSet.add(actualChar);
            }
        }
        System.out.println(foundDuplicates);
    }

    public static void printDuplicatedCharactersWithOccurances(String inputToSearchIn) {
        Map<Character, Integer> occuranceMap = new HashMap<>();
        for (Character actualChar : inputToSearchIn.toCharArray()) {
            if (occuranceMap.containsKey(actualChar)) {
                occuranceMap.put(actualChar, occuranceMap.get(actualChar) + 1);
            } else {
                occuranceMap.put(actualChar, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : occuranceMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }

    public static boolean isAnagram(String input) {
        boolean isStillAnagram = true;
        for (int actualCharNumber = 0; actualCharNumber < input.length() / 2 && isStillAnagram; actualCharNumber++) {
            System.out.print(input.charAt(actualCharNumber));
            System.out.print(input.charAt(input.length() - actualCharNumber - 1));
            System.out.println("");
            if (!areMirrorCharsEquals(input, actualCharNumber)) {
                isStillAnagram = false;
            }
        }
        return isStillAnagram;
    }

    private static boolean areMirrorCharsEquals(String input, int actualCharNumber) {
        return input.charAt(actualCharNumber) == input.charAt(input.length() - actualCharNumber - 1);
    }

    public static boolean areAnagrams(String first, String second) {
        boolean areAnagrams = true;
        if (first == null || second == null || first.length() != second.length()) {
            areAnagrams = false;
        } else {
            for (int actualChar = 0; actualChar < first.length() && areAnagrams; actualChar++) {
                System.out.println(first.charAt(actualChar) + "" + second.charAt(second.length() - actualChar - 1));
                if (first.charAt(actualChar) != second.charAt(second.length() - actualChar - 1)) {
                    areAnagrams = false;
                }
            }
        }
        return areAnagrams;
    }

    public static boolean areAnagramsWithReverse(String first, String second) {
        boolean areAnagrams = true;
        if (first == null || second == null || first.length() != second.length()) {
            areAnagrams = false;
        } else {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);
            StringBuilder firstStringReversed = new StringBuilder(first).reverse();
            System.out.println("First reversed: " + firstStringReversed);
            areAnagrams = firstStringReversed.toString().equals(second);
        }
        return areAnagrams;
    }

    public static StringBuilder reverseWithIterationAndRecursion(String stringToReverse) {
        if (stringToReverse.length() <= 1) {
            return new StringBuilder(stringToReverse);
        }
        return reverseWithIterationAndRecursion(stringToReverse.substring(1)).append(stringToReverse.charAt(0));
    }

    public static boolean containsOnlyDigits(String stringToCheck) {
        Pattern patternDigits = Pattern.compile("[0-9]*");
        return patternDigits.matcher(stringToCheck).matches();
    }

    public static int countVowels(String input) {
        Pattern patternVowel = Pattern.compile("[a,A,e,E,i,I,o,O,u,U]");
        Matcher matcherVowel = patternVowel.matcher(input);
        int numberOfVowels = 0;
        while (matcherVowel.find()) {
            numberOfVowels++;
        }
        return numberOfVowels;
    }

    public static int convertStringToInt(String intStr) {
        if (!containsOnlyDigits(intStr)) {
            throw new IllegalArgumentException("Input string should contain only numbers!");
        }
        //return Integer.valueOf(intStr);
        if (intStr.length() < 2) {
            return Integer.valueOf(String.valueOf(intStr));
        }
        return convertStringToInt(intStr.substring(1)) +
                Double.valueOf(Math.pow(10, intStr.length() - 1) * Integer.valueOf(String.valueOf(intStr.charAt(0)))).intValue();
    }

    public static String replaceCharacter(String strToChange, Character charToReplace, String strToReplaceIn) {
        return strToChange.replace(charToReplace.toString(), strToReplaceIn);
    }

    public static Set<String> getAllPermutation(String input) {
        if (input.length() < 2) {
            Set<String> oneElementStringList = new LinkedHashSet<>();
            oneElementStringList.add(input);
            return oneElementStringList;
        }
        Set<String> permutations = new LinkedHashSet<>();
        for (int i = 0; i < input.length(); i++) {
            StringBuilder deleteOneChar = new StringBuilder(input);
            deleteOneChar.deleteCharAt(i);
            for (String partialPermutation : getAllPermutation(deleteOneChar.toString())) {
                permutations.add(input.charAt(i) + partialPermutation);
            }
        }
        return permutations;

    }

    public static void reverseWordsInSentence(String sentence) {
        int firstSpaceInSentence = sentence.indexOf(' ');
        if (firstSpaceInSentence < 0) {
            System.out.print(sentence + " ");
            return;
        }
        reverseWordsInSentence(sentence.substring(firstSpaceInSentence + 1));
        System.out.print(sentence.substring(0, firstSpaceInSentence) + " ");
    }

    public static String getStringRemovedDuplicatedCharacters(String stringToRemoveDupl) {
        Character lastCharSaved = null;
        StringBuilder resultString = new StringBuilder(stringToRemoveDupl.length());
        for (Character actualChar : stringToRemoveDupl.toCharArray()) {
            if (!actualChar.equals(lastCharSaved)) {
                resultString.append(actualChar);
                lastCharSaved = actualChar;
            }
        }
        return resultString.toString();
    }

    public static boolean isShuffleOfStrings(String first, String second, String third) {
        boolean isShuffleOfString = true;

        List<Character> mergeOfFirstAndSecond = new ArrayList<>();
        for (Character actualChar : first.toCharArray()) {
            mergeOfFirstAndSecond.add(actualChar);
        }
        for (Character actualChar : second.toCharArray()) {
            mergeOfFirstAndSecond.add(actualChar);
        }

        List<Character> thirdAsList = new ArrayList<>();
        for (Character actualChar : third.toCharArray()) {
            thirdAsList.add(actualChar);
        }

        mergeOfFirstAndSecond.sort(Character::compareTo);
        thirdAsList.sort(Character::compareTo);

        return mergeOfFirstAndSecond.equals(thirdAsList);
    }

    /*
    This version unfortunately does not cover all the solution as it happens that both of the origin strings has the same letters and it matters which one is used
     */
    public static boolean isShuffleOfStringsPreservedOrder(String first, String second, String third) {
        boolean isValidShuffle = true;
        int actualCharInFirst = 0;
        int actualCharInSecond = 0;
        int actualCharInThird = 0;
        while (isValidShuffle && actualCharInThird < third.length()) {
            if (actualCharInFirst < first.length() && first.charAt(actualCharInFirst) == third.charAt(actualCharInThird)) {
                actualCharInFirst++;
                actualCharInThird++;
            } else if (actualCharInSecond < second.length() && second.charAt(actualCharInSecond) == third.charAt(actualCharInThird)) {
                actualCharInSecond++;
                actualCharInThird++;
            } else {
                isValidShuffle = false;
            }
        }
        return isValidShuffle && actualCharInSecond == second.length() && actualCharInFirst == first.length();
    }

    public static boolean isShuffleOfStringsPreservedOrderRecursive(String first, String second, String third) {
        boolean isSolutionFound = false;
        if (first.length() + second.length() != third.length() || first == null || second == null || third == null) {
            return false;
        }
        //solution found
        if (third.isEmpty() && second.isEmpty() && third.isEmpty()) {
            return true;
        }
        if (!isSolutionFound && first.length() > 0 && first.charAt(0) == third.charAt(0)) {
            if (isShuffleOfStringsPreservedOrderRecursive(first.substring(1), second, third.substring(1))) {
                isSolutionFound = true;
            }
        }
        if (!isSolutionFound && second.length() > 0 && second.charAt(0) == third.charAt(0)) {
            if (isShuffleOfStringsPreservedOrderRecursive(first, second.substring(1), third.substring(1))) {
                isSolutionFound = true;
            }
        }
        return isSolutionFound;
    }


}