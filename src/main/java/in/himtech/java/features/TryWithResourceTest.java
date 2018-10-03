package in.himtech.java.features;

import java.util.Scanner;

/**
 * Try with resouce can only be used with those resources/API which implements
 * Closable interface and override close method to release resource. With this
 * API, we do not need to use finally block to release resources.
 * 
 * @author Himanshu
 *
 */
public class TryWithResourceTest {
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			String value = "";
			while (!value.equals("quit")) {
				value  = scanner.nextLine();
				System.out.println("Sacnned Value is : " + value);
			}
		} catch (Exception exp) {
			System.out.println("Exception Occurs: " + exp.getMessage());
		} finally { // Not needed as resource is released close() method of Scanner.
			System.out.println("Finally Block is Here");
		}
		
		try(RealResource rr = new RealResource()){
			rr.testCall();
		}
	}
}

class RealResource implements AutoCloseable{

	@Override
	public void close() {
		System.out.println("Resource has been released.");
	}
	
	
	public void testCall() {
		System.out.println("this is a test call of auto resource.");
	}
}
