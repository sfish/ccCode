package Link;

/**
 * @Title: LinkedList_Delete_middle.java
 * @Package Link
 * @Description: Implement an algorithm to delete a node in the middle of a
 *               single linked list, given only access to that node
 * 
 *               Input: the node ‘c’ from the linked list a->b->c->d->e Result:
 *               nothing is returned, but the new linked list looks like
 *               a->b->d->e
 * @author nutc
 * @date 2013-7-15 下午1:03:00
 * @version V1.0 题目理解错了。。。看清楚 input！！！！！
 */
public class LinkedList_Delete_middle {
	public static void main(String args[]) {
		LinkedList link = new LinkedList();

		link.addNode(1);
		link.addNode(2);
		link.addNode(3);
		// Node node1 = new Node(4);
		// link.addNode(node1);
		// link.addNode(5);
		// link.addNode(6);
		// link.addNode(9);
		// Node node2 = new Node(7);
		// link.addNode(node2);
		// link.ifCircle();
		link.display();
//		DeleteMiddle(link.head);
//		delOne(link.head,link.head.next);
		delOne(link.head,link.head.next.next);

		link.display();
	}
	
	public static void delOne(Node n,Node del){
		if(del!=null && del.next!=null){
			del.data = del.next.data;
			del.next = del.next.next;
		}else{
			Node now = n;
			while(now.next!=null && now.next!=del)
				now = now .next;
			if(now.next!=null )
				now.next = now.next.next;
		}
	}

	// 用boolean告诉调用者 是否调用成功~ 当n为末尾节点的时候该方法是不可用的！！！
	public static boolean Delete(Node n) {
		if (n == null || n.next == null)
			return false;

		n.data = n.next.data;
		n.next = n.next.next;
		return true;

	}

	// 错误理解成删除给定链表的中间节点了。。
	public static void DeleteMiddle(Node n) {
		if (n == null || n.next == null)
			return;

		Node p1 = n, p2 = n, pre = null;
		while (p1.next != null) {
			p1 = p1.next;
			if (p1.next != null) {
				p1 = p1.next;
				pre = p2;
				p2 = p2.next;
			}
		}
		pre.next = p2.next;
	}
}
