package Tree;

import java.util.Iterator;
import java.util.Stack;

/**
 * @Title: Tree_Sum_path.java
 * @Package Tree
 * @Description: You are given a binary tree in which each node contains a value
 *               Design an algorithm to print all paths which sum up to that
 *               value Note that it can be any path in the tree - it does not
 *               have to start at the root
 * @author nutc
 * @date 2013-7-23 ����10:18:33
 * @version V1.0 ���Ǹ��� ����׳գ��������� ��������д̫���ˣ�Ȼ���Լ���Ū���˰׳գ�������
 */
public class Tree_Sum_path {

	public static void main(String args[]) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(-1);

		node1.left = node2;
		node2.left = node3;
		node2.right = node4;
		node1.right = node5;
		node5.right = node6;

		node1.display();
		Stack<Integer> path = new Stack<Integer>();
		// findPath(node1,-1,path); //�����˸��ڵ㣡��������
		findSum(node1, 5, path);

	}

	public static void findSum(Node root, int sum, Stack<Integer> path) {
		if (root == null)
			return;
		// System.out.println("***"+root.value);
		// ����ط�ԭ���߼�д���ˡ�����������һ�Ž����������׳հ���������
		findPath(root, sum, path);

		findSum(root.left, sum, path);
		findSum(root.right, sum, path);

	}

	public static void findPath(Node root, int sum, Stack<Integer> path) {
		if (root == null)
			// if (root == null || root.value > sum) ��Ҫ���Ǹ�����������׳�
			return;
		path.push(root.value);
		// System.out.println(root.value+"  sum=="+sum);
		if (root.value == sum) {
			Iterator<Integer> i = path.iterator();
			while (i.hasNext()) {
				System.out.print(i.next() + " -> ");// д����������
			}
			System.out.println();
			path.pop();
			return;
		}

		findPath(root.left, sum - root.value, path);
		findPath(root.right, sum - root.value, path);
		path.pop();
	}
}
