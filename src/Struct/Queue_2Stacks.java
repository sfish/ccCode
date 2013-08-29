package Struct;

import java.util.Stack;

/**
 * @Title: Queue_2Stacks.java
 * @Package Struct
 * @Description: Implement a MyQueue class which implements a queue using two stacks
 * @author nutc
 * @date 2013-7-15 上午9:13:35
 * @version V1.0  实现比较的简单。
 */
public class Queue_2Stacks<E> {

	private Stack<E> stack1;
	private Stack<E> stack2;

	public Queue_2Stacks() {
		stack1 = new Stack<E>();
		stack2 = new Stack<E>();
	}

	public void push(E value) {
		stack1.push(value);
	}

	public E popFront() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty())
				stack2.push(stack1.pop());
		}
		if (stack2.isEmpty())
			return null;
		return stack2.pop();
	}

	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
	
	public int size(){
		return stack1.size()+stack2.size();
	}
}
