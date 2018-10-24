package in.himtech.java.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * The main difference between "thenApply" and "thenApplyAsync" is that
 * "thenApply" execute in the same thread in which "suppyAsync" is executed
 * where as thenApplyAsync is executed in the new thread obtained from
 * frokjoinpool.
 * 
 * @author Himanshu
 *
 */
public class CompletableFutureThenApplyAsync {
	public static void main(String[] args) {
		// Using of thenApply after suppyAsync
		CompletableFuture<String> futureCmpt = CompletableFuture.supplyAsync(() -> {
			// It will execute in thread 1
			return "Hello from suppyAsync method ";
		}).thenApply(greet -> {
			// It will also execute in same thread. Thread 1
			return "Hello from thenApply method\n" + greet; 
		}).thenApplyAsync(againGreet ->{
			// It will execute in a seperate thread. Obtained from FrokJoinPool.
			return "Hello from ThenApplyAsync\n" + againGreet;
		});
		
		try {
			String str = futureCmpt.get(3, TimeUnit.SECONDS);
			System.out.println(str);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
