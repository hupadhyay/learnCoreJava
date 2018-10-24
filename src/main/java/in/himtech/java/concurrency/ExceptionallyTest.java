package in.himtech.java.concurrency;

import java.util.concurrent.CompletableFuture;

/**
 * The exceptionally block will be executed when exception will thrown from any
 * of its previous block. The rest of chain of block will be skipped.
 *
 */
public class ExceptionallyTest {

	public static void main(String[] args) {
		CompletableFuture.supplyAsync(() -> {
			System.out.println("This will throw Arithmethod exception");
			return 5 / 0;
		}).thenApply(val -> {
			System.out.println("The retured value is : " + val);
			return 0;
		}).exceptionally(exp -> {
			System.out.println("Exception occurs: " + exp.getMessage());
			return 5;
		});
	}
}
