package in.himtech.java.hackerrank;

import java.util.Arrays;

/**
 * @ProblemStatement Write a java program to implements stack.
 * 
 */
public class CustomStack<T> {

	private T[] items;

	private Integer capacity;

	private Integer index;

	public CustomStack(int capacity) {
		items = (T[]) new Object[capacity];
		index = -1;
		this.capacity = capacity;
	}

	public T pop() {

		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return items[index--];

	}

	public T peek() {
		return items[index];
	}

	public void push(T t) {
		if (isFull()) {
			throw new RuntimeException("Stack is full");
		}
		items[++index] = t;
	}

	public boolean isEmpty() {
		return (index == -1);
	}

	public boolean isFull() {
		return (index == capacity - 1);
	}

	@Override
	public String toString() {
		return Arrays.toString(items);
	}
	
	
	public static void main(String[] args) {
		CustomStack<Integer> stack = new CustomStack<Integer>(5);
//		stack.pop();
		stack.push(2);
		stack.push(6);
		System.out.println(stack.peek());
		stack.push(7);
		stack.push(9);
		stack.push(3);
		stack.push(8);
		System.out.println(stack.toString());
	}
}
