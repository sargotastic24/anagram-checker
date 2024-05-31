/*
 * @author Sarthak Goyal
 */

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

class AnagramCheckerTest {
	
	@Test
	public void sortTestOneLetterWord() {
		String word = "A";
		assertEquals(AnagramChecker.sort(word),"a");
	}
	
	@Test
	public void sortTest() {
		String word = "apricot";
		assertEquals(AnagramChecker.sort(word),"acioprt");
	}
	
	@Test
	public void sortTestCapital() {
		String word = "BUILDER";
		assertEquals(AnagramChecker.sort(word),"bdeilru");
	}
	
	@Test
	public void sortTestLongWord() {
		String word = "Antidisestablishmentarianism";
		assertEquals(AnagramChecker.sort(word),"aaaabdeehiiiiilmmnnnrssssttt");
	}
	
	@Test
	public void insertionSortTestMin() {
		String[] arr = new String[] {"mat", "ball", "rug"};
		String[] arr01 = new String[] {"ball", "mat", "rug"};
		insertionSortString cmp = new insertionSortString();
		AnagramChecker.insertionSort(arr,cmp);
		assertArrayEquals(arr,arr01);
	}
	
	@Test
	public void insertionSortTestMed() {
		String[] arr = new String[] {"assert","capital", "mat", "ball", "rug"};
		String[] arr01 = new String[] {"assert","ball","capital","mat", "rug"};
		insertionSortString cmp = new insertionSortString();
		AnagramChecker.insertionSort(arr,cmp);
		assertArrayEquals(arr,arr01);
	}
	
	@Test
	public void insertionSortTestLarge() {
		String[] arr = new String[] {"assert","capital", "mat", "ball", "rug","carets","caller","eat"};
		String[] arr01 = new String[] {"assert","ball","caller","capital","carets","eat","mat", "rug"};
		insertionSortString cmp = new insertionSortString();
		AnagramChecker.insertionSort(arr,cmp);
		assertArrayEquals(arr,arr01);
	}
	
	@Test
	public void areAnagramsTestMin() {
		String s1 = "bat";
		String s2 = "tab";
		assertTrue(AnagramChecker.areAnagrams(s1, s2));
	}
	
	@Test
	public void areAnagramsTestMed() {
		String s1 = "retards";
		String s2 = "starred";
		assertTrue(AnagramChecker.areAnagrams(s1, s2));
	}
	
	@Test
	public void areAnagramsTestMax() {
		String s1 = "Discriminator";
		String s2 = "Doctrinairism";
		assertTrue(AnagramChecker.areAnagrams(s1, s2));
	}
	
	@Test
	public void areAnagramsTestMinFail() {
		String s1 = "bat";
		String s2 = "bats";
		assertFalse(AnagramChecker.areAnagrams(s1, s2));
	}
	
	@Test
	public void areAnagramsTestMaxFail() {
		String s1 = "Protectional";
		String s2 = "Lactoproteins";
		assertFalse(AnagramChecker.areAnagrams(s1, s2));
	}
	
	@Test
	public void getLargestAnagramGroupTestMin() {
		String[] arr = new String[] {"cellar","caller","recall","ate"};
		String[] arr01 = new String[] {"cellar","caller","recall"};
		assertArrayEquals(AnagramChecker.getLargestAnagramGroup(arr), arr01);
	}
	
	@Test
	public void getLargestAnagramGroupTestMed() {
		String[] arr = new String[] {"cellar","caller","tale","late","elat","ate"};
		String[] arr01 = new String[] {"tale","late","elat"};
		assertArrayEquals(AnagramChecker.getLargestAnagramGroup(arr), arr01);
	}
	
	@Test
	public void getLargestAnagramGroupTestMax() {
		String[] arr = new String[] {"acts","cats","cast","scat","tale","late","elat","cellar","caller","ate"};
		String[] arr01 = new String[] {"acts","cats","cast","scat"};
		
		assertArrayEquals(AnagramChecker.getLargestAnagramGroup(arr), arr01);
	}
	
	@Test
	public void getLargestAnagramGroupFileNameTest() {
		String[] arr = new String[] {"carets","Caters","caster","crates","Reacts","recast","traces"}; //add the largest anagram group
		assertArrayEquals(AnagramChecker.getLargestAnagramGroup("C:\\Users\\Vignesh Iyer\\eclipse-workspace\\Assignments\\src\\assign04\\sample_word_list.txt"), arr);
	}
	
	
	
		//used to test our insertionSort.
		protected class insertionSortString implements Comparator<String> {
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		}

}
