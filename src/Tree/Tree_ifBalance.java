package Tree;

/**
 * @Title: Tree_ifBalance.java
 * @Package Tree
 * @Description: Implement a function to check if a tree is balanced For the
 *               purposes of this question, a balanced tree is defined to be a
 *               tree such that no two leaf nodes differ in distance from the
 *               root by more than one
 * @author nutc
 * @date 2013-7-22 下午8:04:19
 * @version V1.0
 */
public class Tree_ifBalance {

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

		System.out.println("是否是平衡二叉树呀" + findDepth(node1));
	}

	public static int findDepth(Node node) {
		if (node == null)
			return 0;

		int left = findDepth(node.left);
		int right = findDepth(node.right);
		System.out.println("当前值是" + node.value + " 左边" + left + " 右边" + right);

		if (left != -1 && right != -1 && left - right < 2 && left - right > -2) {
			return left > right ? left + 1 : right + 1;
		} else {
			return -1;
		}
	}

	/*
	 * SOLUTION The idea is very simple: the difference of min depth and max
	 * depth should not exceed 1, since the difference of the min and the max
	 * depth is the maximum distance difference pos- sible in the tree ￼1 2 3 4}
	 * 5 return 1 + Math.max(maxDepth(root.left), maxDepth(root.right)); 6} 7 8
	 * 9 10 11 12 13 14 15 16 17 public static int minDepth(TreeNode root) { if
	 * (root == null) { return 0; } return 1 + Math.min(minDepth(root.left),
	 * minDepth(root.right)); } public static boolean isBalanced(TreeNode root){
	 * return (maxDepth(root) - minDepth(root) <= 1); }
	 */
}
