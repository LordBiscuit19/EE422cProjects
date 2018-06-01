import java.util.ArrayList;

public class ReverseGreeting {
	private static int threadNum = 0;
	private static ArrayList<Thread> threads = new ArrayList<Thread>();
	
	public ReverseGreeting() {
		if (threadNum < 50) {
			threadNum++;
			Greet greet = new Greet(threadNum);
			Thread thread = new Thread(greet);
			threads.add(thread);
			ReverseGreeting greeting = new ReverseGreeting();
		}
		else {
			for (int i = 49; i >= 0; i--) {
				threads.get(i).start();
			    try {
			        threads.get(i).join();
			    } catch (InterruptedException ie) {}
			}
		}
	}
	
	private class Greet implements Runnable{
		private int num;

		
		public Greet(int n) {
			num = n;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Hello from thread " + num);
		}
		
	}
}
