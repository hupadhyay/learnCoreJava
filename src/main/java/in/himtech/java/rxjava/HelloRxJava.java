package in.himtech.java.rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class HelloRxJava {
	public static void main(String[] args) {
		Observable<String> subject = Observable.just("item1", "item2", "item3", "item4", "item5", "item6", "item7",
				"item8", "item9");
		
		Consumer<String> consumer1 = c -> {
			System.out.println("Output: " + c);
		};
		
		Consumer<Integer> consumer2 = c -> {
			System.out.println("Value : " + c);
		};
		
		subject.subscribe(consumer1);
		subject.map(f -> f.toUpperCase().hashCode()).subscribe(consumer2);
	}
}
