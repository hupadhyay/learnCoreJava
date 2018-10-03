package in.himtech.java.concurrency;

public class BasicRunnable {

	public static void main(String[] args) {

		new Thread(() -> {
			int count = 0;
			int number = 1;
			while (number < 10000) {
				if (isPrime(number++)) {
					count++;
				}
			}
			System.out.printf("Number of Prime in range of 1 to %d is %d%n", number, count);
		}).start();
	}

	private static boolean isPrime(int count) {
		if (count <= 2) {
			return true;
		} else {
			for(int i = 2; i <= count/2; i++) {
				if(count%i == 0) {
					return false;
				}
			}
			return true;
		}
	}
}
