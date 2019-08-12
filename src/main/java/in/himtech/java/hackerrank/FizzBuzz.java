package in.himtech.java.hackerrank;

/**
 * @ProblmeStatement Write a simple program to print number from 1 to 100. For every multiple of 3 print "Fizz" 
 * and for every multiple of 5 print "Buzz" and if the number is multiple of 3 and 5 both, print "FizzBuzz".
 */
public class FizzBuzz {
	public static void main(String[] args) {
		int i = 1;
		while(i <= 100) {
			if ((i % 15 ==0)) {
				System.out.println("FizzBuzz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else if (i % 3 == 0){
				System.out.println("Fizz");
			} else {
				System.out.println(i);
			}
			i++;
		}
	}

}
