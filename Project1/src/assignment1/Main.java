/* 
 * This file is how you might test out your code.  Don't submit this, and don't 
 * have a main method in SortTools.java.
 */

package assignment1;

import java.util.Arrays;

public class Main {
	public static void main(String [] args) {
		int[] arr = {1,2,3,4,5};
		int[] notSorted = {1,4,3,5,6};
		boolean test = false;
		test = SortTools.isSorted(arr, 5);
		System.out.println("isSorted test is - " + test +" - should be true");
		test = SortTools.isSorted(notSorted, 5);
		System.out.println("isSorted test is - " + test + " - should be false");
		
		
		
		int findTest = -1;
		findTest = SortTools.find(arr, 5, 3);
		System.out.println("findTest is - " + findTest + " - should be 2");
		// call your test methods here
		// SortTools.isSorted() etc.
		findTest = SortTools.find(arr, 5, 1);
		System.out.println("findTest is - " + findTest + " - should be 0");
		findTest = SortTools.find(arr, 5, 5);
		System.out.println("findTest is - " + findTest + " - should be 4");
		findTest = SortTools.find(arr, 5, 7);
		System.out.println("findTest is - " + findTest + " - should be -1");
		int [] arr2 = {1,3,6,8,9};
		findTest = SortTools.find(arr2, 5, 4);
		System.out.println("findTest is - " + findTest + " - should be -1");

		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 20, 30, 35};
		System.out.println("insert general test end insert is - " + Arrays.toString(SortTools.insertGeneral(x, 3, 35)) + " - should be - " + Arrays.toString(expected));
		x = new int[]{10, 20, 30, 40, 50};
		expected = new int[]{10, 20, 30, 35, 40, 50};
		System.out.println("insert general test middle insert is - " + Arrays.toString(SortTools.insertGeneral(x, 5, 35)) + " - should be - " + Arrays.toString(expected));
		
		int test2 = SortTools.insertInPlace(x, 4, 35);
		
		int[] sortTest = new int[] {4,5,9,8,2,10,11};
		expected = new int[] {2,4,5,8,9,10,11};
		SortTools.insertSort(sortTest, 7);
		System.out.println("insert sort test 1 - " + Arrays.toString(sortTest) + " - should be - " + Arrays.toString(expected));
		
		int[] sortTest2 = new int[] {4,5,9,8,2,10,1};
		expected = new int[] {1,2,4,5,8,9,10};
		SortTools.insertSort(sortTest2, 7);
		System.out.println("insert sort test 2 - " + Arrays.toString(sortTest2) + " - should be - " + Arrays.toString(expected));
		
		int[] sortTest3 = new int[]{10,50,600,8,9,3};

	}
}
