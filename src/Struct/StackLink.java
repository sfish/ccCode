package Struct;

/**
 * @Title: Stack.java
 * @Package Struct
 * @Description: TODO
 * @author nutc
 * @date 2013-7-13 上午10:16:09
 * @version V1.0
 */
public class StackLink<E> {

	private Node top = null;
	private int size = 0;

	public void push(E value) {
		Node node = new Node();
		node.value = value;
		node.pre = top;
		top = node;
		size++;
	}

	public E pop() {
		if (top != null) {
			Node<E> e = top; //这里一定要有<E>  不然 1 就需要变成  (E)e.value !!!
			top = top.pre;
			size--;
			return  e.value;  //1
		} else
			return null;
	}

	public class Node<E> {
		public E value;
		public Node<E> pre;
	}
	
}
