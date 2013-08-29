package Link;

/**
 * @Title: LinkedList_FindBeginLoop.java
 * @Package Link
 * @Description: Given a circular linked list, implement an algorithm which
 *               returns node at the begin- ning of the loop
 * @author nutc
 * @date 2013-7-16 上午9:33:04
 * @version V1.0 很特别的想法！！！！ 要记住啊亲！！！！
 * 非常别致的一道题目
 */
public class LinkedList_FindBeginLoop {

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
		// link.display();

		System.out.print("循环起点是：" + ifLoop(link.head));
	}

	public static Node ifLoop(Node n) {
		if (n == null || n.next == null)
			return null;

		Node p1 = n, p2 = n; // P2 部分陷入死循环居然是因为这里把p2 = n.next......！！！！！！！
		while (p2.next != null) {  //非常简洁的判断是否是环的代码！
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2)
				break;
		}
		if (p2.next == null)
			return null;// 不是链表

		p1 = n;
		// P2
		while (p1 != p2) {
			System.out.print(p1.data + " --- " + p2.data + "\n");
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}
