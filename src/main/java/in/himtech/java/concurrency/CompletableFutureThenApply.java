package in.himtech.java.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * The output of one computable task become input of other computable task and
 * get the output of both.
 * 
 * @author Himanshu
 */
public class CompletableFutureThenApply {
	public static void main(String[] args) {
		CompletableFuture<String> futureCom = CompletableFuture.supplyAsync(() -> {
			return "Hello From supplyAsync method";
		}).thenApply(name -> {
			return "then apply + input: " + name;
		});

		try {
			System.out.println(futureCom.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
