package in.himtech.java.functional;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaceTest {
	
	public static void main(String[] args) {
		
		Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
		System.out.println("Predicate: " + isEvenPredicate.test(45));
		
		Function<Integer, Integer> squareFunction = x -> x * x;
		System.out.println("Function: " + squareFunction.apply(20));
		
		Consumer<Student> printConsumer = s -> System.out.println(s);
		printConsumer.accept(new Student(101, "Hrishik", "Lucknow", "10-May-2014", 456.90));
		
		UnaryOperator<Integer> thriceNumber = x -> 3*x;
		System.out.println("UnaryOperator: " + thriceNumber.apply(20));
		
		BinaryOperator<Integer> sumAllNums = (x,y) -> x+y;
		System.out.println("BinaryOperator: " + sumAllNums.apply(30, 45));
		
		Supplier<Integer> intSupplier = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};
		
		System.out.println("Supplier: " + intSupplier.get());
		
		BiPredicate<Integer, String> biPredicate = (num, str) -> num > 10 && str.length() > 5;
		System.out.println("BiPredicate: " + biPredicate.test(25, "Himanshu"));
		
		BiFunction<Integer, String , String> biFunction = (num, str) -> num + " " + str;
		System.out.println("BiFunction: " + biFunction.apply(15, "Balloons"));
		
		BiConsumer<Integer, String> biConsumer = (num, str) -> {
			System.out.println("Number: " + num);
			System.out.println("String: " + str);
		};
		biConsumer.accept(45, "Laddoo");
		
		/**
		 * This functional interfaces specially used for premitive datatypes. 
		 */
		IntBinaryOperator intBinaryOperator = (x, y) -> x+y;
		System.out.println("IntBinaryOperator: " + intBinaryOperator.applyAsInt(4, 5));
	}

}
