package in.himtech.java.hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProblemStatement: <h3>Get the indices of two numbers of an array which sums are equals to given number.</h3><b>
 * Write a java program to return indices of numbers of an array which sum are equals to the given number.
 */
public class TwoNumberSum {
	public static void main(String[] args) {
		int [] arrNum = {3, 5, 7, 4, 2, 9, 6};
		int target = 10;
		
		int [] returnVals = sumOfTwo(arrNum, target);
		
		System.out.println("this indices of two number is: " + returnVals[0] + ", " + returnVals[1]);
	}

	private static int[] sumOfTwo(int[] arrNum, int target) {
		Map<Integer, Integer> mapNum = new HashMap<>();
		
		for(int i = 0; i < arrNum.length; i++) {
			int delta = target - arrNum[i];
			
			if(mapNum.containsKey(delta)) {
				return new int[]{mapNum.get(delta), i};
			} else {
				mapNum.put(arrNum[i], i);
			}
		}
		
		return new int[] {-1, -1};
	}
}
