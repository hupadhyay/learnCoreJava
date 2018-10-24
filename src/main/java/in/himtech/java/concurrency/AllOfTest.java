package in.himtech.java.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * The allOf method will execute all of the tasks given in the list or array of
 * completable future tasks which are given as a parameter to the method.
 *
 */
public class AllOfTest {

	public static void main(String[] args) {

		CompletableFuture<Void> comFuture1 = CompletableFuture.runAsync(() -> {

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

			System.out.println("Return from first completable future");
		});

		CompletableFuture<Void> comFuture2 = CompletableFuture.runAsync(() -> {

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Return from second completable future");
		});

		CompletableFuture<Void> comFuture3 = CompletableFuture.runAsync(() -> {

			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Return from third completable future");
		});

		try {
			CompletableFuture.allOf(comFuture1, comFuture2, comFuture3).get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
