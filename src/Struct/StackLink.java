package Struct;

/**
 * @Title: Stack.java
 * @Package Struct
 * @Description: TODO
 * @author nutc
 * @date 2013-7-13 ����10:16:09
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
			Node<E> e = top; //����һ��Ҫ��<E>  ��Ȼ 1 ����Ҫ���  (E)e.value !!!
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
