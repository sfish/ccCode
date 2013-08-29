package Tree;

/**
 * @Title: Tree_toDoublyLinkedList.java
 * @Package Tree
 * @Description: 将二叉查找树变为有序的双向链表
 * 
 *               要求不能创建新节点，只调整指针。 递归解法：
 *               （1）如果二叉树查找树为空，不需要转换，对应双向链表的第一个节点是NULL，最后一个节点是NULL
 *               （2）如果二叉查找树不为空：
 * 
 *               如果左子树为空，对应双向有序链表的第一个节点是根节点，左边不需要其他操作；
 *               如果左子树不为空，转换左子树，二叉查找树对应双向有序链表的第一个节点就是左子树转换后双向有序链表的第一个节点
 *               ，同时将根节点和左子树转换后的双向有序链 表的最后一个节点连接；
 *               如果右子树为空，对应双向有序链表的最后一个节点是根节点，右边不需要其他操作；
 *               如果右子树不为空，对应双向有序链表的最后一个节点就是右子树转换后双向有序链表的最后一个节点
 *               ，同时将根节点和右子树转换后的双向有序链表的第一个节点连 接。
 * @author nutc
 * @date 2013-7-23 下午2:19:37
 * @version V1.0
 * 记住！ 不是你的左边指向a，a的右边就自动指向你了！！！！！
 * 冷静理清条理的话，其实不难~~~~
 * 把父亲往下传，来进行处理的方式。
 */
public class Tree_toDoublyLinkedList {

	public static Node head;

	public static void main(String args[]) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		node3.addLeft(node1);
		node3.addRight(node5);
		node5.addLeft(node4);
		node1.addRight(node2);
		node5.addRight(node6);

		node3.display();
		ToLinked(node3, null, null); // 把起点写错了。。写成node1了...

		Node now = head;
		while (now != null) {
			System.out.print("now=" + now.value);
			if (now.left != null)
				System.out.print("  left=" + now.left.value);
			if (now.right != null)
				System.out.print("  right=" + now.right.value);
			System.out.println();
			now = now.right;
		}
	}

	// 2:33
	public static void ToLinked(Node now, Node leftfather, Node rightfather) {
		if (now == null)
			return;
//		System.out.print("开始前");
//		now.showLR();
		if (now.left == null) {
			if (leftfather == null) {
				head = now;
				now.left = null;
			} else {
				leftfather.right = now;
				now.left = leftfather;// 忘了这句了，非常重要
			}
		} else {
			ToLinked(now.left, leftfather, now);
		}

		if (now.right == null) {
			if (rightfather != null) {
				rightfather.left = now;
				now.right = rightfather;// 忘了这句了，非常重要
			} else
				now.right = null;
		} else {
			ToLinked(now.right, now, rightfather);
		}
//		System.out.print("结束后");
//		now.showLR();
	}
}
