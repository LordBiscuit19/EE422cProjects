// SortTools.java 
/*
 * EE422C Project 1 submission by
 * Replace <...> with your actual data.
 * Donald Maze-England
 * dsm2588
 * 15465
 * Spring 2018
 * Slip days used: 0
 */

package assignment1;
public class SortTools {
	/**
	  * This method tests to see if the given array is sorted.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @return true if array is sorted
	  */
	public static boolean isSorted(int[] x, int n) {
		// stub only, you write this!
		if (n == 0) return false;
		int previous = x[0];
		for (int i = 1; i < n; i++) {	//go through the whole array
			if (x[i] < previous) {		//if the next array element is smaller than the previous the array is not sorted
				return false;
			}
			previous = x[i];
		}
		return true;
	}
	
	/**
	  * This method searches a sorted array for a certain value.
	  * @param nums is the array
	  * @param n is the size of the input to be checked
	  * @param v is the value to be searched for
	  * @return the index of v if it is found. If v is not found return -1
	  */
	public static int find(int[] nums, int n, int v) {
		if (v > nums [n-1]) return -1;	//if v is larger than the largest element in the array then the array does not contain v
		int idxRight = n-1;
		int idxLeft = 0;
		while (idxLeft <= idxRight) {
			if (v == nums[(idxRight+idxLeft)/2]) return (idxRight+idxLeft)/2;	//if v is found return the index;
			else if (v > nums[(idxRight+idxLeft)/2]) idxLeft = (idxRight+idxLeft)/2+1;
			else if (v < nums[(idxRight+idxLeft)/2]) idxRight = (idxRight+idxLeft)/2-1;
		}
		return -1;
	}
	
	/**
	  * This method is passed an array and a value to insert. The method returns a new array with the same contents of the original array plus the new value
	  * v inserted so that the array is still in non descending order.
	  * @param nums is the array
	  * @param n is the size of the input array to be used
	  * @param v is the value to be inserted
	  * @return a new array with the same contents of the original array plus the new value v inserted so that the array is still in non descending order.
	  */
	public static int[] insertGeneral(int[] nums, int n, int v) {
		int noVFlag = 1;	//if v is already in the array this will be 0
		for (int i = 0; i<n; i++) {
			if (nums[i] == v) noVFlag = 0;
		}
		if (noVFlag == 0) {		//if v is already in the nums array just copy the first n elements and return an array
			int[] arr = new int[n];
			for (int i = 0; i<n; i++) {
				arr[i] = nums[i];
			}
			return arr;
		}
		else {
			int [] arr = new int[n+1];
			int jInMiddleFlag = 0;
			for (int i = 0, j = 0; i<n; i++, j++) {		//this for loop inserts v in the array such that the array is in non-descending order
				if (jInMiddleFlag == 0) {
					if (nums[i] > v) {
						arr[j] = v;
						j++;
						jInMiddleFlag = 1;
					}
				}
				arr[j] = nums[i];
			}
			if (jInMiddleFlag == 0) {	//if v was not inserted in the middle of the array insert it at the end.
				arr[n] = v;
			}
			return arr;
		}
	}
	
	/**
	  * This method is passed an array and a value to insert. The method inserts the new value into the original array so the the array is still
	  * in non decreasing order
	  * @param nums is the array
	  * @param n is the size of the input array to be used
	  * @param v is the value to be inserted
	  * @return n+1 if the value v was inserted. Return n if v is already in the array.
	  */
	public static int insertInPlace(int[] nums, int n, int v) {
		int noVFlag = 1;	//if v is already in the array this will be 0
		for (int i = 0; i<n; i++) {
			if (nums[i] == v) noVFlag = 0;
		}
		if (noVFlag == 0) {		//if v is already in the nums array just copy the first n elements and return an array
			return n;
		}
		else {
			int temp1, temp2;
			int i;
			for (i = 0; i < n && v > nums[i]; i++); //run until we find the index where v needs to be inserted.
			temp1 = nums[i];	//store the nums array element where v needs to be inserted and overwrite the
			nums[i] = v;		//proper location for v by storing v
			i++;
			for (; i < n + 1; i++) {
				temp2 = nums[i];
				nums[i] = temp1;
				temp1 = temp2;
			}
			return n+1;
		}
	}
		
	/**
	  * This method is passed an array and the length of the array to be sorted. The mehod sorts the array in non decreasing order
	  * @param nums is the array
	  * @param n is the size of the input array to be used
	  */
	public static void insertSort(int[] nums, int n) {
		for (int i = 1; i < n; i++) {
			SortTools.insertInPlace(nums, i, nums[i]);	//call insertInPlace with v as the next value of nums and with n set so that insert InPlace overrides 
		}												//previous position of v
	}
}

