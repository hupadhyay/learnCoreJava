package in.himtech.java.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorsTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		// Executing task within the executors
		executorService.execute(() -> {
			System.out.println("This task is executin within the executors.");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException exp) {
				exp.printStackTrace();
			}
		});

		((ThreadPoolExecutor) executorService).setRejectedExecutionHandler(new MyRejectedExecutionHandler());

		executorService.shutdown();

		executorService.execute(() -> {
			System.out.println("This task will not executed but help to call rejectedExecutionHandler method.");
		});

	}

	static class MyRejectedExecutionHandler implements RejectedExecutionHandler {

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			System.out.println("This is rejected task handler.");
		}

	}
}
