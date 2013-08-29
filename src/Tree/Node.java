package Tree;

/**
 * @Title: Node.java
 * @Package Tree
 * @Description: Given a sorted (increasing order) array, write an algorithm to
 *               create a binary tree with minimal height �ܼ�....well done~
 * @author nutc
 * @date 2013-7-22 ����8:03:28
 * @version V1.0
 */
public class Node {
	public  Node left;
	public Node right;
	int value;

	public Node(int v) {
		value = v;
	}

	public void show() {
		System.out.print(value + " ");
	}

	public void showLR() {
		System.out.print(value + " ");
		if (left != null)
			System.out.print("  left=" + left.value);
		if (right != null)
			System.out.print("  right=" + right.value);
		System.out.println();
	}

	public void display() {
		System.out.print("��ǰ" + value);
		if (left != null) {
			System.out.print("  ���" + left.value);
		}
		if (right != null) {
			System.out.print("   �ұ�" + right.value);
		}
		System.out.println();
		if (left != null)
			left.display();
		if (right != null)
			right.display();

	}

	public void addLeft(Node n) {
		left = n;
	}

	public void addRight(Node n) {
		right = n;
	}
}
