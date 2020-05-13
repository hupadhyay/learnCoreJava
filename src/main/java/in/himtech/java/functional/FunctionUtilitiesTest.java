package in.himtech.java.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionUtilitiesTest {
	public static void main(String[] args) {
		// 
		Stream<Integer> strm = Stream.of(4,6,8,3,9,0,6,5);
		int sum = strm.reduce(0, (x,y) -> x+y);
		System.out.println(sum);
		IntStream intStrm = IntStream.of(4,6,8,3,9,0,6,5);
		System.out.println(intStrm.sum());
		IntStream stream = Arrays.stream(new int[] {4,6,8,3,9,0,6,5});
		System.out.println(stream.sum());
		
		// Creating stream of first 100 natural numbers
		IntStream range = IntStream.range(1, 10);
		System.out.println(range.sum());
		
		IntStream intGen = IntStream.iterate(1, e -> e + 1).limit(10);
		System.out.println(intGen.sum());
		
		List<String> courses = new ArrayList<>(Arrays.asList("AWS", "Azure", "Microservice", "Docker", "GCP", "Kubernates", "Ansible", "WebServices"));
		courses.replaceAll(c -> c.toUpperCase());
		System.out.println(courses);
		
		courses.removeIf(c -> c.length() < 6);
		System.out.println(courses);
	}
}
