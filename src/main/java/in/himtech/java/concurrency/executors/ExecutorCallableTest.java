package in.himtech.java.concurrency.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorCallableTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		// Executing task within the executors
		Future<Integer> futureValue = executorService.submit(() -> {
			System.out.println("This task is executin within the executors.");
			int sum = 1;
			int value = 5;
			while (value > 0) {
				sum *= value--;
			}
			TimeUnit.SECONDS.sleep(5);

			return sum;
		});

		try {
			System.out.println("The value of task is : " + futureValue.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorService.shutdown();
	}
}
