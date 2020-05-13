package in.himtech.java.functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomClassOperation {

	public static void main(String[] args) {
		List<Student> listStudent = Arrays.asList(new Student(101, "Hrishik", "Lucknow", "10-May-2014",4570.0),
				new Student(245, "Hritika", "Noida", "10-Nov-2012", 5450.0),
				new Student(360, "Himanshu", "Gopalganj", "27-Mar-1980", 6543.0),
				new Student(720, "Anushka", "Deoria", "01-Mar-1990", 5432.0),
				new Student(359, "", "Deoria", "01-Mar-1990", 2346.0));

		/*
		 * AllMatch: This will return true when all the predicates returns true.
		 * 
		 * noneMatch: This will return true when none of the predicate returns true.
		 * 
		 * AnyMatch: This will return true when any of the predicate return true.
		 */
		
		System.out.println(listStudent.stream().allMatch(student -> student.getId() > 200));
		System.out.println(listStudent.stream().noneMatch(student -> student.getId() > 800));
		System.out.println(listStudent.stream().anyMatch(student -> student.getId() < 300));
		
		/*
		 * takeWhile: This will return the records until the predicate condition matched. (jdk 9)
		 * 
		 * dropWhile: This will skips the records until the predicate condition matched. (jdk 9)
		 */
		
		Function<Student, String> function = x -> x.getName();
		Comparator<Student> byName = Comparator.comparing(function);
		listStudent.stream().sorted(byName).forEach(student -> System.out.println(student));
		Comparator<Student> byNameReversed = Comparator.comparing(function).reversed();
		listStudent.stream().sorted(byNameReversed).forEach(student -> System.out.println(student)); 
		
		// when the name of student is same then comparing on basis of date of joining.
		Function<Student, String> functionDate = x -> x.getDateOfJoining();
		Comparator<Student> byNameDateReversed = Comparator.comparing(function).thenComparing(functionDate).reversed();
		listStudent.stream().sorted(byNameDateReversed).forEach(student -> System.out.println(student)); 
		
		/*
		 * skip: skip the given number of elements form the stream 
		 * 
		 * limit: discard the all elements after given number of elements
		 */
		System.out.println(listStudent.stream().sorted(Comparator.comparing(stu -> stu.getFees())).skip(3).collect(Collectors.toList()));
		System.out.println(listStudent.stream().sorted(Comparator.comparing(stu -> stu.getFees())).limit(3).collect(Collectors.toList()));
		System.out.println(listStudent.stream().sorted(Comparator.comparing(stu -> stu.getFees())).skip(2).limit(1).collect(Collectors.toList()));

	
		/*
		 * min:determine the min element based on given comparator. It return optional value use orElse to send default value.
		 * max: determine the max element based on the given comparator. Optional value is returned, use get/orElse to get value.
		 * findFirst:It will return the first element of the stream.
		 * findAny: It could return any element of the stream.
		 */
		System.out.println(listStudent.stream().min(Comparator.comparing(stu -> stu.getFees())).get());
		System.out.println(listStudent.stream().min(Comparator.comparing(stu -> stu.getFees())).orElse(new Student(100, "default", "default", "default",0.0)));
		System.out.println(listStudent.stream().max(Comparator.comparing(stu -> stu.getFees())).get());
		System.out.println(listStudent.stream().filter(stu -> stu.getFees() >  5000).findFirst().get());
		System.out.println(listStudent.stream().filter(stu -> stu.getFees() >  5000).findAny().get());
		
		/*
		 * Sum:return the sum of IntegerStream, doubleStream.
		 * Average:return the average ofIntegerStream, doubleStream.
		 * Count:return the nunbers of IntegerStream, doubleStream.
		 */
		System.out.println(listStudent.stream().filter(stu -> stu.getFees() >  5000).mapToDouble(stu -> stu.getFees()).sum());
		System.out.println(listStudent.stream().filter(stu -> stu.getFees() >  5000).mapToDouble(stu -> stu.getFees()).average().orElse(0.0));
		System.out.println(listStudent.stream().filter(stu -> stu.getFees() >  5000).mapToDouble(stu -> stu.getFees()).count());
	
		/*
		 * Groupingby: GroupBy based on certain keyValue.
		 */
		System.out.println(listStudent.stream().filter(stu -> stu.getFees() >  2000).collect(Collectors.groupingBy(stu -> stu.getLocation())));
		System.out.println(listStudent.stream().filter(stu -> stu.getFees() >  2000).collect(Collectors.groupingBy(stu -> stu.getLocation(), Collectors.counting())));
		System.out.println(listStudent.stream().filter(stu -> stu.getFees() >  2000).collect(Collectors.groupingBy(stu -> stu.getLocation(), Collectors.mapping(stu -> stu.getName(), Collectors.toList()))));
	}

}
