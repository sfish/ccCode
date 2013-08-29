package Tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @Title: Tree_FindNext.java
 * @Package Tree
 * @Description: 4 5 Write an algorithm to find the ‘next’ node (e g , in-order
 *               successor) of a given node in a binary search tree where each
 *               node has a link to its parent
 * @author nutc
 * @date 2013-7-22 下午9:28:39
 * @version V1.0
 */
public class Tree_FindNext {

	public static void main(String args[]) {
		FatherNode node1 = new FatherNode(1);
		FatherNode node2 = new FatherNode(2);
		FatherNode node3 = new FatherNode(3);
		FatherNode node4 = new FatherNode(4);
		FatherNode node5 = new FatherNode(5);
		FatherNode node6 = new FatherNode(6);

		node3.addLeft(node1);
		node3.addRight(node5);
		node5.addLeft(node4);
		node1.addRight(node2);
		node5.addRight(node6);

		node3.display();
		findFatherNode(node3, 1);
		findFatherNode(node3, 2);
		findFatherNode(node3, 3);
		findFatherNode(node3, 4);
		findFatherNode(node3, 5);
		findFatherNode(node3, 6);

	}

	public static void findFatherNode(FatherNode node, int value) {
		if (node == null)
			return;

		if (node.value == value) {
			FatherNode next = findNext(node);
			if (next == null)
				System.out.println(value + "——不存在next");
			else
				System.out.println(value + "——next==" + next.value);
		} else {
			findFatherNode(node.left, value);
			findFatherNode(node.right, value);
		}
	}

	public static FatherNode findNext(FatherNode node) {
		FatherNode next = null;
		if (node.right != null) {
			next = node.right;
			while (next.left != null) {
				next = next.left;
			}
			return next;
		}
		if (node.father != null) {
			next = node;
			while (next.father != null && next.father.left != next) {
				next = next.father;
			}
			if (next.father != null)
				return next.father;
			else
				return null;
		}
		return null;
	}
}
