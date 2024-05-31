# anagram-checker

AnagramChecker
Overview
This project involves constructing a program that determines if two words are anagrams and finds the largest group of anagrams in a list of words. Two words are anagrams if they contain the same letters in the same frequency. For example, "alert" and "later" are anagrams. The program uses sorting techniques to solve these problems efficiently.

Requirements

- AnagramChecker Class

The AnagramChecker class contains five public methods and additional private helper methods as needed. 

1) sort(String input):

Converts the input string to a character array.
Sorts the character array using an insertion sort.
Converts the sorted character array back to a string and returns it.

2) insertionSort(T[] array, Comparator<? super T> comparator):

Implements the insertion sort algorithm to sort the array based on the provided comparator.

3) areAnagrams(String word1, String word2):

Sorts both input strings using the sort(String) method.
Compares the sorted versions of the strings to check if they are anagrams.

4) getLargestAnagramGroup(String[] words):

Uses a custom comparator to sort the array of words based on their sorted character representations.
Iterates through the sorted array to find the largest group of adjacent anagrams.

5) getLargestAnagramGroup(String filename):

Reads words from the file into an array.
Calls the getLargestAnagramGroup(String[]) method to find the largest group of anagrams.


Testing

Created JUnit tests to verify the functionality of each method in the AnagramChecker class, covering various edge cases and ensuring compliance with the requirements.
