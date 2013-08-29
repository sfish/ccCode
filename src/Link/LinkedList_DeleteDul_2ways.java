package Link;

import java.util.HashSet;

/**
 * @Title: LinkedList_DeleteDul_2ways.java
 * @Package Struct
 * @Description: Write code to remove duplicates from an unsorted linked list
 *               FOLLOW UP How would you solve this problem if a temporary
 *               buffer is not allowed?
 * @author nutc
 * @date 2013-7-15 上午10:11:56
 * @version V1.0
 * 
 *          有时候节约了空间，先想到浪费空间吧亲~~ 没有那么多完美的方法！！！ 思考有环路的去重呢？ 好奇怪。。
 */
public class LinkedList_DeleteDul_2ways {

	public static void main(String args[]) {
		LinkedList link = new LinkedList();

		link.addNode(1);
		link.addNode(2);
		link.addNode(3);
		Node node1 = new Node(4);
		link.addNode(node1);
		link.addNode(5);
		link.addNode(6);
		link.addNode(9);
		Node node2 = new Node(7);
		node2.addNode(node1);
		link.addNode(node2);
		// link.ifCircle();
		link.display();
		DeleteDul2(link.head);
		link.display();
	}

	// 删除链表里的重复节点 ——方法一
	public static void DeleteDul(Node n) {
		// cc里用的是hashtable，但是hashset应该就够用了~~
		// Hashtable hash = new Hashtable();
		HashSet set = new HashSet();

		Node pre = null;
		while (n != null) {
			// if (hash.containsKey(n.data)) {
			if (set.contains(n.data)) {
				// 删除该节点
				pre.next = n.next; // !!!!pre==null? 这个地方是因为第一个节点肯定不是重复的，
				// 所以才不会为null！！！
			} else {
				pre = n;
				set.add(n.data);
				// hash.put(n.data, n);
			}
			n = n.next;
		}
	}

	public static void DeleteDul2(Node n) {
		if (n == null || n.next == null)
			return;// 不用判断了！！！
		Node now = n.next;
		Node pre = n;
		while (now != null) {
			if (ifDul(n, now)) {
				pre.next = now.next;
			} else { // 这个地方原来没有else，就是错的！！！！！
				pre = now;
			}
			now = now.next;
			n.display();
		}
	}

	public static boolean ifDul(Node head, Node n) {
		Node now = head;
		while (now != null && now != n) {
			if (now.data == n.data)
				return true;
			now = now.next; // 忘记写了。。。太容易忘记循环条件了啊啊啊啊啊啊
		}
		return false;
	}

}
