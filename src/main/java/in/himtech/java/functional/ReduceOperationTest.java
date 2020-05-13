package in.himtech.java.functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReduceOperationTest {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(12,9,13,4,6,2,4,12,15);
		
		int sum = numbers.stream().reduce(0, (a,b) -> a+b);
		System.out.println("SUM " + sum);
		
		int sumOfSquare = numbers.stream().reduce(0, (a,b) -> a + (b * b));
		System.out.println("Sum of Square " + sumOfSquare);
		
		int sumOfCubes = numbers.stream().reduce(0, (a,b) -> a + (b * b *b));
		System.out.println("Sum of Cubes " + sumOfCubes);
		
		int sumOfOdds = numbers.stream().filter(p -> p%2 != 0).reduce(0, (a,b) -> a + b);
		System.out.println("Sum of Odds " + sumOfOdds);
		
		// To remove duplicate
		numbers.stream().distinct().forEach(c -> System.out.println(c));
		
		// To sort elements
		numbers.stream().sorted().forEach(c -> System.out.println(c));
		
		//Sorting of distinct elements
		numbers.stream().distinct().sorted().forEach(c -> System.out.println(c)); 
		
		//Sorting in natural order
		numbers.stream().distinct().sorted(Comparator.naturalOrder()).forEach(c -> System.out.println(c)); 
				
		//Sorting in reverse order
		numbers.stream().distinct().sorted(Comparator.reverseOrder()).forEach(c -> System.out.println(c));
		
		//Sorting in given order
		List<Student>listStudent = Arrays.asList(new Student(101, "Hrishik", "Lucknow", "10-May-2014", 4590.0), new Student(245, "Hritika", "Varanasi", "10-Nov-2012", 7846.0), 
				new Student(360, "Himanshu", "Gopalganj", "27-Mar-1980", 6549.0), new Student(720, "Anushka", "Noida", "01-Mar-1990", 4567.0));
		listStudent.stream().distinct().sorted(Comparator.comparing(s -> s.getName())).forEach(c -> System.out.println(c)); 
	}

}
