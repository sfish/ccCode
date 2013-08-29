package Tree;

/**
 * @Title: Tree_ifSubTree.java
 * @Package Tree
 * @Description: You have two very large binary trees: T1, with millions of
 *               nodes, and T2, with hun- dreds of nodes Create an algorithm to
 *               decide if T2 is a subtree of T1 1)
 *              方法一 分别求出T1和T2的前序和中序遍历的字符串，判断T2是否为T1的子串（利用KMP或者后缀树），复杂度O(n)。 2)
 *              方法二 递归求解，复杂度O(m*n)
 * @author nutc
 * @date 2013-7-23 上午11:12:58
 * @version V1.0
 * 子树——必须一直到叶子节点吗？
 */
public class Tree_ifSubTree {

	public static void main(String args[]) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		node1.left = node2;
		node2.left = node3;
		node2.right = node4;
		node1.right = node5;
		node5.right = node6;

		Node node7 = new Node(1);

		Boolean ifsame = checkSub(node1, node1);
		System.out.println("是否是子树===" + ifsame);
	}

	public static boolean checkSub(Node father, Node child) {
		if (father == null)
			return false;
		if (child == null)
			return true; // 这个可以和面试官沟通

		System.out.println("checkSub" + father.value + "  " + child.value);
		Boolean ifsame = false;
		if (father.value == child.value) {
			ifsame = ifSame(father, child);
		}
		if (!ifsame)
			ifsame = checkSub(father.left, child)
					|| checkSub(father.right, child);
		return ifsame;
	}

	public static boolean ifSame(Node father, Node child) {
		if (child == null)
			return true;
		if (father == null)
			return false;
		System.out.println("ifSame" + father.value + "  " + child.value);

		if (father.value == child.value) {
			return ifSame(father.left, child.left)
					&& ifSame(father.right, child.right); // 妹的
															// 我在这里写成checksub了！！！！！！！！你敢再不认真点吗！！！
		} else
			return false;
	}
}
