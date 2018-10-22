package in.himtech.java.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Demostration of Streams.
 * It contains various operations on java streams apis.
 * 
 * @author Himanshu
 *
 */
public class StreamAppln {

	public static void main(String[] args) {
		List<Employee> listEmp = Arrays.asList(new Employee(1, "Suresh", 4500.0), new Employee(2, "Mahesh", 5600.0),
				new Employee(3, "Ganesh", 45600), new Employee(4, "Rakesh", 6700), new Employee(5, "Mukesh", 8700));

		// Sort and pring on base of name
		System.out.println("Sort on base of employee name");
		listEmp.stream().sorted((emp1, emp2) -> emp1.getName().compareTo(emp2.getName())).forEach(System.out::println);

		// Sort and print on the base of salary
		System.out.println("\nSort on base salary of employee.");
		listEmp.stream().sorted((emp1, emp2) -> (int) emp1.getSalary() - (int) emp2.getSalary())
				.forEach(System.out::println);

		// Find out Employee getting minimum salary
		System.out.println("\nFind out the minimum salary of employee.");
		DoubleStream dblStream = listEmp.stream().mapToDouble(e -> e.getSalary());
		double salary = dblStream.min().getAsDouble();
		System.out.println(salary);
		// OR
		salary = listEmp.stream().min((e1, e2) -> (int) e1.getSalary() - (int) e2.getSalary()).get().getSalary();
		System.out.println(salary);

		// Find out Employee getting maximum salary
		salary = listEmp.stream().mapToDouble(e -> e.getSalary()).max().getAsDouble();
		System.out.println(salary);

		// Increase salary of each employee and calculate sum of all
		salary = listEmp.stream().peek(e -> e.setSalary(e.getSalary() * 1.1)).mapToDouble(e -> e.getSalary()).sum();
		System.out.println("Sum of salary: " + salary);

		// Find first match to collection
		Employee emp = listEmp.stream().filter(e -> (e.getSalary() > 5000.0)).findFirst().get();
		System.out.println("Employee: " + emp);

		// create a map of name and salary from list of object

		// Reduction Operation. (sum of all the salary)
		salary = listEmp.stream().map(e -> e.getSalary()).reduce(0.0, Double::sum).doubleValue();
		System.out.println(salary);

		listEmp.stream().filter(e -> e.getSalary() > 5000).map(e -> e.getSalary()).reduce(0.0, Double::sum)
				.doubleValue();
		System.out.println(salary);

		// Collect --> Joining
		String empNames = listEmp.stream().map(e -> e.getName()).collect(Collectors.joining(", "));
		System.out.println(empNames);

		// Collect --> partitioningBy
		Stream.of(3, 6, 9, 8, 12, 68, 75).collect(Collectors.partitioningBy(v -> v % 2 == 0))
				.forEach((k, v) -> System.out.println("Key: " + k + "  Value: " + v));

		// Collect --> grouping By
		listEmp.stream().collect(Collectors.groupingBy(e -> e.getName()))
				.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
		listEmp.stream().collect(Collectors.groupingBy(e -> e.getName().substring(0, 1)))
				.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));

		// Collect --> mapping
		listEmp.stream()
				.collect(Collectors.groupingBy(e -> e.getName().substring(0, 1),
						Collectors.mapping(Employee::getEmpId, Collectors.toList())))
				.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
	}
}

class Employee {
	private int empId;
	private String name;
	private double salary;

	public Employee(int empId, String name, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
	}

}