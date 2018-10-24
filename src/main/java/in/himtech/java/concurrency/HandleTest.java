package in.himtech.java.concurrency;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * The handler will be executed in both cases weather exception is thrown or
 * not.
 *
 */
public class HandleTest {
	public static void main(String[] args) {
		CompletableFuture.supplyAsync(() -> {
			System.out.println("This will throw exception on based of random number.");
			Random random = new Random();
			int value = random.nextInt(10);
			return 5 / (value % 2);
		}).thenAccept(val -> {
			System.out.println("This will execute when exception will not thrown.");
			System.out.println("The value of value : " + val);
		}).handle((value, exp) -> {
			System.out.println("This will execute in both cases wheather it will throw exception or not.");
			if (exp != null) {
				System.out.println("Exception occurs: " + exp.getMessage());
			} else {
				System.out.println("Exception doesn't occurs.");
			}
			return value;
		});
	}
}
