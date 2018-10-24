package in.himtech.java.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * The anyOf method will execute all of the tasks given in the list or array of
 * completable future and return the result of the task which is executed very
 * first.
 *
 */
public class AnyOfTest {

	public static void main(String[] args) {

		CompletableFuture<String> comFuture1 = CompletableFuture.supplyAsync(() -> {

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "Return from first completable future";
		});

		CompletableFuture<String> comFuture2 = CompletableFuture.supplyAsync(() -> {

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "Return from second completable future";
		});

		CompletableFuture<String> comFuture3 = CompletableFuture.supplyAsync(() -> {

			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "Return from third completable future";
		});

		CompletableFuture resultFuture = CompletableFuture.anyOf(comFuture1, comFuture2, comFuture3);
		try {
			System.out.println(resultFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
