package Struct;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Title: Stack_SetOfStack.java
 * @Package Struct
 * @Description: 33 Imagine a (literal) stack of plates If the stack gets too
 *               high, it might topple There- fore, in real life, we would
 *               likely start a new stack when the previous stack exceeds some
 *               threshold Implement a data structure SetOfStacks that mimics
 *               this SetOf- Stacks should be composed of several stacks, and
 *               should create a new stack once the previous one exceeds
 *               capacity SetOfStacks push() and SetOfStacks pop() should behave
 *               identically to a single stack (that is, pop() should return the
 *               same values as it would if there were just a single stack)
 *               FOLLOW UP Implement a function popAt(int index) which performs
 *               a pop operation on a specific sub-stack
 * @author nutc
 * @date 2013-7-13 下午12:44:22
 * @version V1.0
 */
public class Stack_SetOfStack<E> {

	public int capacity;// 替换常量！ 不应该是常量！ private static int DEFAULT = 50;

	// 没写构造函数啊你！
	public Stack_SetOfStack(int capacity) {
		this.capacity = capacity;
	}

	ArrayList<Stack<E>> stacks = new ArrayList<Stack<E>>();
	int size = 0;

	public void push(E v) {

		// if (stacks.size() == 0) {
		// Stack<E> stack = new Stack<E>();
		// stacks.add(stack);
		// size++;
		// }
		// Stack<E> now = getLastStack(); //额外用函数，意思会更清晰
		// if (now.size() == capacity) {
		// stacks.add(new Stack<E>());
		// now = stacks.get(stacks.size() - 1);
		// }
		// now.push(v);
		// 优化重复的代码啊,我写的太乱了....
		Stack<E> now = getLastStack(); // 额外用函数，意思会更清晰
		if (now == null || now.size() == capacity) {
			now = new Stack();
			stacks.add(now);
		}
		now.push(v);
	}

	public Stack getLastStack() {
		if (stacks.size() == 0)
			return null;
		return stacks.get(stacks.size() - 1);
	}

	public E pop() {
		if (stacks.size() == 0)
			return null;
		Stack<E> now = stacks.get(stacks.size() - 1);
		E value = now.pop();
		if (now.isEmpty()) {
			stacks.remove(stacks.size() - 1);
			size--;
			now = null;
		}
		return value;
	}

	public E popAt(int index) {
		if (index >= 0 && index < size) {
			return stacks.get(index).pop();
		} else
			return null;
	}
	
	//TODO
//	public E shift(int index){
//		E value = stacks.get(index).pop();
//		if(index<stacks.size()-1){
//		}
//	}
}
