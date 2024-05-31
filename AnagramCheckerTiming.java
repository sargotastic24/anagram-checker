/*
 * @author Sarthak Goyal
 */

import java.util.Random;
import java.util.Scanner;

import assign04.AnagramChecker;

public class AnagramCheckerTiming {
	public static void main(String[] args) {
		int[] arr1 = new int[10000];
		  // Do 10000 lookups and use the average running time.
	    int timesToLoop = 100;
	    
	    // For each problem size n . . .
	    for (int n = 50; n <= 1000; n += 100) {
	      long startTime, midpointTime, stopTime;
	      startTime = System.nanoTime();
	      while (System.nanoTime() - startTime < 1000000000) { // empty block 
	      }

	      // Now, run the test.  
	      startTime = System.nanoTime();

	      /*for (int i = 0; i < timesToLoop; i++) {        //code for testing areAnagrams
	    	  String a = generateRandomWords(n);
	    	  String b = generateRandomWords(n);
	    	  AnagramChecker.areAnagrams(a, b);
	      }*/
	      
	      for(int i = 0; i < timesToLoop; i++) {           //code for testing getlargestAnagramGroup.
	    	  String[] a = generateRandomStringArray(n);
	    	  AnagramChecker.getLargestAnagramGroup(a);
	      }

	      midpointTime = System.nanoTime();

	      /*for (int i = 0; i < timesToLoop; i++) { 	 //code for subtracting areAnagram additional time.
	    	  String a = generateRandomWords(n);
	    	  String b = generateRandomWords(n);
	      }*/
	      
	      for (int i = 0; i < timesToLoop; i++) {        //code for subtracting generateRandomStringArray additional time
	    	  String[] a = generateRandomStringArray(n);
	      }

	      stopTime = System.nanoTime();

	      // Compute the time, subtract the cost of running the loop
	      // from the cost of running the loop and doing the lookups.
	      // Average it over the number of runs.
	      double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
	          / timesToLoop;

	      System.out.println(n + "\t" + averageTime);
	  }

	}
	
	//method to generate random Strings.
	public static String generateRandomWords(int numberOfWords)
	{
	    String randomStrings = null;
	    Random random = new Random();
	    for(int i = 0; i < numberOfWords; i++)
	    {
	        char[] word = new char[random.nextInt(8)+3]; 
	        for(int j = 0; j < word.length; j++)
	        {
	            word[j] = (char)('a' + random.nextInt(26));
	        }
	        randomStrings = new String(word);
	    }
	    return randomStrings;
	}
	
	//Method to randomly generate Arrays of type String.
	public static String[] generateRandomStringArray(int numberOfWords)
	{
	    String[] randomStrings = new String[numberOfWords];
	    Random random = new Random();
	    for(int i = 0; i < numberOfWords; i++)
	    {
	        char[] word = new char[random.nextInt(8)+5]; 
	        for(int j = 0; j < word.length; j++)
	        {
	            word[j] = (char)('a' + random.nextInt(26));
	        }
	        randomStrings[i] = new String(word);
	    }
	    return randomStrings;
	}

}

