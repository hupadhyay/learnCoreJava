package in.himtech.java.hackerrank;

/**
 * @ProblemStatement Reverse the given string.
 * 		Write a java program to reverse the string. 
 * 
 */
public class ReverseString {
	public static void main(String[] args) {
		String givenString = "Hello World";
		
		System.out.println(reverseUsingStringBuilder(givenString));
		System.out.println(reverseUsingArrayBuilder(givenString));
		System.out.println(reverseUsingCharArray(givenString));
	}

	private static String reverseUsingCharArray(String givenString) {
		char []ctrArr = givenString.toCharArray();
		int length = ctrArr.length;
		char ctr = 0;
		for(int i=0; i< length/2; i++) {
			ctr = ctrArr[i];
			ctrArr[i]=ctrArr[length-i-1];
			ctrArr[length-1-i] = ctr;
		}
		return new String(ctrArr);
	}

	private static String reverseUsingArrayBuilder(String givenString) {
		StringBuilder sb = new StringBuilder();
		char []ctrArr = givenString.toCharArray();
		for(int i= ctrArr.length - 1; i >= 0; i--) {
			sb.append(ctrArr[i]);
		}
		return sb.toString();
	}

	private static String reverseUsingStringBuilder(String givenString) {
		return new StringBuilder(givenString).reverse().toString();
	}
}
