// SortTools.java
/*
 * EE422C Project 1 submission by:
 * Cooper Shearer
 * cs54689 
 * 15465
 * Spring 2018
 * Slip days used:
 */

package assignment1;

/**
 * This class sorts arrays in non-decreasing order
 * @author Cooper Shearer
 */

public class SortTools {
    /**
     * This method tests to see if the given array is sorted.
     * @param nums is the array
     * @param n is the size of the input to be checked
     * @return true if array is sorted
     */
    public static boolean isSorted(int[] nums, int n) {
        if(n == 0 || nums.length == 0) return false;

        int lastNum = nums[0];
        for (int i = 0; i < n; i++) {
            if(lastNum > nums[i]) return false;
            lastNum = nums[i];
        }

        return true;
    }

    /**
     * This method tests to see if a given value is in the first n elements of given array
     * @param nums is the array
     * @param n is the size of the input to be checked
     * @param v is the value to search array for
     * @return index of given value if present, -1 if value is not present
     */
    public static int find(int[] nums, int n, int v){
        int left = 0, right = n - 1, mid;
        while(left <= right){
            mid = (right + left)/2;
            if(nums[mid] < v) {
                left = mid + 1;
            } else if(nums[mid] > v){
                right = mid - 1;
            } else{
                return mid;
            }
        }

        return -1;
    }

    /**
     * This method creates array of integers sorted in non-decreasing order
     * @param nums array of numbers to be copied into new array
     * @param n number of elements from nums to be copied
     * @param v value to be inserted into new array
     * @return if v is present in nums, returns a copy of nums. If v is not present in nums returns an array of size n + 1 containing v
     */
    public static int[] insertGeneral(int[] nums, int n, int v){
        int arraySize = find(nums, n, v) == -1 ? n + 1 : n;
        int[] newNums = new int[arraySize];
        for(int i = 0; i < n; i++) newNums[i] = nums[i];
        if(arraySize == n+1) insertInPlace(newNums, n, v);
        return newNums;

    }

    /**
     * This method modifies passed array to insert given value v into array in non decreasing order
     * @param nums array of numbers for value to be inserted
     * @param n number of elements in array to be evaluated
     * @param v number to be inserted into array
     * @return if value v exists in array, array is not modified and n is returned. If value v does not exist in array, v is inserted and n+1 is returned
     */
    public static int insertInPlace(int[] nums, int n, int v){
        if(find(nums, n, v) != -1) return n;

        int swap, numInsert = v;
        for(int i = 0; i < n; i++){
            if(numInsert < nums[i]){
                swap = nums[i];
                nums[i] = numInsert;
                numInsert = swap;
            }
        }
        nums[n] = numInsert;
        return n + 1;
    }

    /**
     * This method modifies passed array to sort it in non-decreasing order
     * @param nums array to be sorted
     * @param n number of elements to be sorted
     */
    public static void insertSort(int[] nums, int n){
        for(int i = 1; i < n; i++){
            for(int j = i; j >= 1 && nums[j] < nums[j-1]; j--){
                int temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;
            }
        }
    }

}
