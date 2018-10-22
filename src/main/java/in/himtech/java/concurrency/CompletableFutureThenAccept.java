package in.himtech.java.concurrency;

import java.util.concurrent.CompletableFuture;

/**
 * The difference between thenAccept and ThenRun is that ThenAccept take the
 * output of previous operation where as thenRun doesn't take any argument.
 * 
 * @author Himanshu
 */
public class CompletableFutureThenAccept {

	public static void main(String[] args) {
		CompletableFuture.supplyAsync(() -> {
			return "Good Morning Himanshu!";
		}).thenApply(greet -> {
			return "Greeting to Himanshu. " + greet;
		}).thenAccept(moreGreet -> {
			System.out.println("Himanshu Received Greeting. " + moreGreet);
		});

		CompletableFuture.supplyAsync(() -> {
			return "Good Morning Himanshu!";
		}).thenApply(greet -> {
			return "Greeting to Himanshu. " + greet;
		}).thenRun(() -> {
			System.out.println("Himanshu Received Greeting. ");
		});
	}
}
