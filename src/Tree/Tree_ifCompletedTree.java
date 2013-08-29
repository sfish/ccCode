package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title: Tree_ifCompletedTree.java
 * @Package Tree
 * @Description: 判断是否是完全二叉树，注意判断条件！！！
 * @author nutc
 * @date 2013-7-23 下午3:45:15
 * @version V1.0
 */
public class Tree_ifCompletedTree {
	
	public static void main(String args[]) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		node3.addLeft(node1);
//		node3.addRight(node5);
//		node5.addLeft(node4);
		node1.addRight(node2);
//		node5.addRight(node6);
		
		Node node9 = new Node(9);
		node1.addLeft(node9);

		node3.display();
		System.out.print("是否完全二叉树=="+ifComplete(node3));
	}

	public static boolean ifComplete(Node node) {
		if (node == null)
			return true;
		Queue<Node> queue = new LinkedList<Node>();
		boolean ifboth = true;
		queue.offer(node);
		Node now;
		while ((now = queue.poll()) != null) {
			if (ifboth && (now.left == null || now.right == null))
				ifboth = false;
			else {
				if (!ifboth && (now.left != null || now.right != null))
					return false;
			}
			if (now.left != null)
				queue.offer(now.left);
			if (now.right != null)
				queue.offer(now.right);
		}
		return true;
	}
}
