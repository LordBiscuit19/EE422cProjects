/* 
 * This file is how you might test out your code.  Don't submit this, and don't 
 * have a main method in SortTools.java.
 */

package assignment1;
public class Main {
	public static void main(String [] args) {

		int testArr[] = {-100, 25, 87, -101, 1, 1, 1, 0, -100, 52, -1000, 5000, 37}, compareArray1[] = {-101, -100,-100, 0, 1, 1, 1, 2, 25, 52, 87, 100, 37};
		int n = 10;

		boolean pass1 = false, pass2 = false, pass3 = false, pass4 = false, pass5 = false, pass6 = false, pass7 = false, pass8 = false, pass9 = false;

		pass1 = !SortTools.isSorted(testArr,n);
		SortTools.insertSort(testArr,n);
		pass2 = SortTools.isSorted(testArr,n);
		pass6 = SortTools.insertInPlace(testArr,n,100) == n+1;
		n++;
		pass3 = SortTools.isSorted(testArr, n);
		pass4 = SortTools.find(testArr, n,100) == 10;
		pass5 = SortTools.insertInPlace(testArr, n, -101) == n;
		int newTestArr[] = SortTools.insertGeneral(testArr, n, -101);
		int anotherNewTestArr[] = SortTools.insertGeneral(newTestArr, n, 22);
		pass8 = SortTools.insertInPlace(testArr, n, 2) == n+1;
		n++;
		
		pass7 = SortTools.insertInPlace(testArr, n, 105) == n+1;



		if(pass1 && pass2 && pass3 && pass4 && pass5 && pass6 && pass7 && pass8){
			System.out.println("Passed");
		} else{
			System.out.println("Failed");
		}
	}
}
