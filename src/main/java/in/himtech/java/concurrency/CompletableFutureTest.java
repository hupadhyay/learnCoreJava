package in.himtech.java.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * The CompletableFuture is used to run the task asynchronously. It extends
 * interface like Future and CompletableStage. This class has various advantage over Future class.
 * 1. Manually break the waiting for completion by calling method "complete()" method.
 * 2. We can chain the output of one task to input of another task.
 * 3. Better error handle machanism.
 * 
 * @author Himanshu
 *
 */
public class CompletableFutureTest {

	public static void main(String[] args) {
		CompletableFuture<Integer> comFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello from run method of completable future.");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("I am executing in seperate thread.");
			return 5;
		});

		try {
			int value = comFuture.get(3, TimeUnit.SECONDS);
			System.out.println("Get value from thread: " + value);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
