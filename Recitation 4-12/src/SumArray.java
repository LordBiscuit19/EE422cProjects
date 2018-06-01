import java.util.ArrayList;
import java.util.Random;


public class SumArray {

	private int[] arr;
	private int numArrayEl;
	private int sum;
	
	
	public SumArray(int N, int numArrayEl) {
		Random r = new Random();
		this.numArrayEl = numArrayEl;
		/*
		arr = new int[numArrayEl];
		for (int i = 0; i < numArrayEl; i++) {
			arr[i] = r.nextInt();
		}
		*/
		ArrayList<int[]> arrOfArr = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			arrOfArr.add(new int[numArrayEl/N]);
			for (int j = 0; j < arrOfArr.get(i).length; j++) {
				arrOfArr.get(i)[j] = r.nextInt(100);
			}
		}
		
		ArrayList<Summer> summers = new ArrayList<Summer>();
		for (int i = 0; i < N; i++) {
			summers.add(new Summer(arrOfArr.get(i), numArrayEl/N));
		}
		
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for(int i = 0; i < N; i++) {
			threads.add(new Thread(summers.get(i)));
			threads.get(i).start();
		}
		
	    try {
	        for (Thread t : threads) {
	            t.join();
	        }
	    } catch (InterruptedException ie) {}

	    int total = 0;
	    for (Summer summer : summers) {
	        total += summer.getCounter();
	    }
	    sum =  total;
	}
	
	public int getSum() {
		return sum;
	}
	
	private class Summer implements Runnable{

		private int counter = 0;
		private int[] arr;
		private int arrLength;
		
		public Summer(int[] arr, int arrLength) {
			this.arr = arr;
			this.arrLength = arrLength;
		}
		
		public int getCounter() {
			return counter;
		}

		@Override
		public void run() {
			for (int i=0; i < arrLength; i++)
				synchronized (this) {
					counter = counter + arr[i]; //counter = counter + 1;
				}
		}

		
	}
	
}
