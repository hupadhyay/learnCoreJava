package in.himtech.java.hackerrank;

public class ReverseInteger {
	public static void main(String[] args) {
		int reverseValue = getReverseValue(3456327);
		System.out.println(reverseValue);
	}

	private static int getReverseValue(int value) {
		int reVal = 0;
		while(value > 0) {
			reVal *=10;
			reVal += value%10;
			value /= 10;
		}
		return reVal;
	}
}
