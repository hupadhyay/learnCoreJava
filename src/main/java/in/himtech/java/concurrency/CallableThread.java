package in.himtech.java.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThread {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Integer> futureTask = new FutureTask<>(() -> {
			System.out.println("Hello From Callable");
			return 1*2*3*4*5*6;
		});
		
		new Thread(futureTask).start();
		
		System.out.println("The value of future task is : " + futureTask.get());
	}

}
