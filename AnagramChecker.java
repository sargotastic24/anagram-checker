import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @author Sarthak Goyal
 */

import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class AnagramChecker {
	String[] arrWord = new String[50];
	
	//This method returns the lexicographically-sorted version of the input string.  
	//The sorting must be accomplished using an insertion sort.
	@SuppressWarnings("unused")
	public static String sort(String word) {
		String isSorted = "";
		int wordSize = word.length();
		Character[] wordArr = new Character[wordSize];
		String stringLowerCase = word.toLowerCase();     //Converts the String to lower case.
	
		if(word == null) {
			throw new NullPointerException("Is null");
		}
			
		//Stores lower case indices in tempArr
		for (int i=0; i < wordSize; i++) {
			wordArr[i] = stringLowerCase.charAt(i);
		}
		
		 insertionSort(wordArr, (s1,s2)->(s1.compareTo(s2)));
		 
		 for (int i = 0; i<wordSize; i++) {
			 isSorted = isSorted + wordArr[i];
		 }
		
		return isSorted;
	}
	
	//Generic method sorts the input array using an insertion sort and the input Comparator object.
	public static <T> void insertionSort(T[] arr, Comparator<? super T> comptor) { 
		for (int i = 1; i<arr.length; i++) {
			T val;
			val = arr[i];
			int j = i-1; 
			while(j>=0 && comptor.compare(arr[j], val) > 0) {  
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = val;
			
		}
	}
	
	//This method returns true if the two input strings are anagrams of each other, otherwise returns false.  
	//This method must call your sort(String) method.
	public static boolean areAnagrams(String s1, String s2) {
		if(s1.length() == s2.length()) {
			String s1Sort = sort(s1);
			String s2Sort = sort(s2);
			
			/*char[] chars = s1.toCharArray();       //Java inbuilt sort for our timing code
	        Arrays.sort(chars);
	        String s1Sort = new String(chars);*/
	        
	       /* char[] chars2 = s2.toCharArray();     //Java inbuilt sort for our timing code
	        Arrays.sort(chars2);
	        String s2Sort = new String(chars2);*/
	        
		if(s1Sort.equals(s2Sort)){
			return true;
		}
	  }
		return false;
	}
	
	//Returns largest group of anagrams in input array of words, no particular order.
	//Returns empty array if no anagrams in the input array.
	public static String[] getLargestAnagramGroup(String[] s1) {
		int stringSize = s1.length;
		String[] tempArr = new String[stringSize];
		int tempArrSize = tempArr.length;
		ArrayList<String> largestGroup = new ArrayList<String>();
		
		if (stringSize == 0) {
			return s1;
		}
		
		for (int i = 0; i < tempArrSize; i++) {
			tempArr[i] = s1[i];
		}
		
		for(int i = 0; i < tempArrSize; i++) {
			ArrayList<String> largestGroup2 = new ArrayList<String>();
			for(int j = 0; j < tempArrSize; j++) {
				if(areAnagrams(tempArr[i], tempArr[j])) {
					largestGroup2.add(tempArr[j]);
				}
			}
			if(largestGroup.size() < largestGroup2.size()) {
				largestGroup = largestGroup2;
			}
			
			if(largestGroup.size() == 1) {
				largestGroup.clear();
			}
		}
		return largestGroup.toArray(new String[0]);
	}
	
	//Reads the anagrams from the file, and if the file does not exist returns empty array.
	//Calls getLargestAnagramGroup().
	@SuppressWarnings("resource")
	public static String[] getLargestAnagramGroup(String filename) {
		//String[] tempArr = new String[20];
		ArrayList<String> tempArr = new ArrayList<String>();
		File myFile = new File(filename); 
		Scanner sc;
		try {
			sc = new Scanner(myFile);
		} 
		catch (FileNotFoundException e) {
			return tempArr.toArray(new String[0]);
		}
		
		int i = 0;
		while(sc.hasNext()) {
			tempArr.add(sc.next());
			i++;
		}
		sc.close();
		return getLargestAnagramGroup(tempArr.toArray(new String[0]));
	}
	
	//Implementation of comparator for insertionSort().
	static class cmpLargestAnagramGroup implements Comparator<String> {
		public int compare(String s1, String s2) {
			return s1.compareTo(s2);
		}
	}
}
