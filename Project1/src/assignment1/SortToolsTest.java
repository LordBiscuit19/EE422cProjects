package assignment1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SortToolsTest {
	
	@Test(timeout = 2000)
	public void testFindFoundFull(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(3, SortTools.find(x, 6, 1));
	}
	
	@Test(timeout = 2000)
	public void testInsertGeneralPartialEnd(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 20, 30, 35};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 3, 35));
	}
	
	@Test(timeout = 2000)
	public void testInsertGeneralMiddleInsert(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 20, 30, 35, 40, 50};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 5, 35));
	}
	
	@Test(timeout = 2000)
	public void testInsertGeneralBeginningInsert(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{5, 10, 20, 30, 40, 50};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 5, 5));
	}
	
	@Test(timeout = 2000)
	public void testInsertInPlaceMiddleInsert(){
		int[] x = new int[]{10, 20, 30, 40, 50, 60};
		int[] expected = new int[]{10, 20, 30, 35, 40, 50};
		int test = SortTools.insertInPlace(x, 5, 35);
		assertArrayEquals(expected, x);
		assertEquals(6, test);
	}
	
	@Test(timeout = 2000)
	public void testInsertInPlaceBeginningInsert(){
		int[] x = new int[]{10, 20, 30, 40, 50, 60};
		int[] expected = new int[]{5, 10, 20, 30, 40, 50};
		int test = SortTools.insertInPlace(x, 5, 5);
		assertArrayEquals(expected, x);
		assertEquals(6, test);
	}
	
	@Test(timeout = 2000)
	public void testInsertInPlaceEndInsert(){
		int[] x = new int[]{10, 20, 30, 40, 50, 60};
		int[] expected = new int[]{10, 20, 30, 40, 50, 55};
		int test = SortTools.insertInPlace(x, 5, 55);
		assertArrayEquals(expected, x);
		assertEquals(6, test);
	}
	
	@Test(timeout = 2000)
	public void testInsertSort1(){
		int[] x = new int[]{10,50,600,8,9,3};
		int[] expected = new int[]{3,8,9,10,50,600};
		SortTools.insertSort(x, 6);
		assertArrayEquals(expected, x);
	}
	
	@Test(timeout = 2000)
	public void testInsertSort2(){
		int[] x = new int[]{10,50,600,8,9,3};
		int[] expected = new int[]{8,9,10,50,600,3};
		SortTools.insertSort(x, 5);
		assertArrayEquals(expected, x);
	}
	
	@Test(timeout = 2000)
	public void testInsertSort3(){
		int[] x = new int[]{3,4,5,6,7,8,10,12};
		int[] expected = new int[]{3,4,5,6,7,8,10,12};
		SortTools.insertSort(x, 8);
		assertArrayEquals(expected, x);
	}
	
	@Test(timeout = 2000)
	public void testInsertSort4(){
		int[] x = new int[]{3,4,5,6,7,8,10,12};
		int[] expected = new int[]{3,4,5,6,7,8,10,12};
		SortTools.insertSort(x, 6);
		assertArrayEquals(expected, x);
	}
	
	@Test(timeout = 2000)
	public void testInsertSort5(){
		int[] x = new int[]{3,9,5};
		int[] expected = new int[]{3,9,5};
		SortTools.insertSort(x, 1);
		assertArrayEquals(expected, x);
	}
	
	@Test(timeout = 2000)
	public void testInsertSort6(){
		int[] x = new int[]{9,3,5};
		int[] expected = new int[]{3,9,5};
		SortTools.insertSort(x, 2);
		assertArrayEquals(expected, x);
	}
	
	@Test(timeout = 2000)
	public void testInsertSort7(){
		int[] x = new int[]{3,9,5};
		int[] expected = new int[]{3,5,9};
		SortTools.insertSort(x, 3);
		assertArrayEquals(expected, x);
	}
}
