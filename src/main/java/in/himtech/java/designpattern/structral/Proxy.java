package in.himtech.java.designpattern.structral;

/**
 * The proxy design pattern is very simple and mostly used in modern a framework such as Spring, Hibernate.  There are various types of proxies:
 * 
 * Local Proxy
 * Remote Proxy
 * Virtual Proxy (Mock)
 * 
 * In a single line, we can say proxy is the object which is used in place of a real object and it propagates the request to the real object by performing some operation on request.
 *
 * @author Himanshu 
 * 
 */
public class Proxy {
	public static void main(String[] args) {
		ArithmeticProxy proxy = new ArithmeticProxy();
		System.out.println("Add: " + proxy.add(5, 9));
		System.out.println("Substract: " + proxy.substract(9, 5));
		System.out.println("Multiply: " + proxy.multiply(5, 9));
		System.out.println("Division: " + proxy.division(15, 6));
		
	}
}

class ArithmeticProxy{
	
	private ArithmeticCalculator calculator;
	
	public ArithmeticProxy() {
		calculator = new ArithmeticCalculator();
	}
	
	public int add(int a, int b) {
		System.out.println("Call add method on actual object");
		return calculator.add(a, b);
	}
	
	public int substract(int a, int b) {
		System.out.println("Call substract method on actual object");
		return calculator.substract(a, b);
	}
	
	public int multiply(int a, int b) {
		System.out.println("Call multiply method on actual object");
		return calculator.multiply(a, b);
	}
	
	public int division(int a, int b) {
		System.out.println("Call division method on actual object");
		return calculator.division(a, b);
	}
}

class ArithmeticCalculator{
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public int substract(int a, int b) {
		return a-b;
	}
	
	public int multiply(int a, int b) {
		return a*b;
	}
	
	public int division(int a, int b) {
		return a/b;
	}
}
