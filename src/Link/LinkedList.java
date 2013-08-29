package Link;

import java.util.HashSet;

/**
 * @Title: LinkedList.java
 * @Package Struct
 * @Description: TODO
 * @author nutc
 * @date 2013-7-15 上午9:23:20
 * @version V1.0
 */
public class LinkedList {

	public static void main(String args[]) {
		LinkedList link = new LinkedList();
		link.addNode(1);
		// link.addNode(2);
		// link.addNode(3);
		link.addNode(1);
		link.addNode(1);

		link.display();
//		link.DeleteDul(link.head);

		link.display();
	}

	public Node head;

	public LinkedList() {
		head = null;
	}

	// 增加节点 多态1
	public void addNode(Node n) {
		if (head == null)
			head = n;
		else {
			Node now = head;
			while (now.next != null) {
				now = now.next;
			}
			now.next = n;
		}
	}

	// 增加节点 多态2
	public void addNode(int value) {
		Node n = new Node(value);
		if (head == null)
			head = n;
		else {
			Node now = head;
			while (now.next != null) {
				now = now.next;
			}
			now.next = n;
		}
	}

	// 删除节点
	public void DeleteNode(int value) {
		if (head == null)
			return;
		Node now = head;
		Node pre = null;
		while (now != null) {
			if (now.data == value) {
				pre.next = now.next;
			} else {
				pre = now;
				now = now.next;
			}
		}
	}

	// 呈现链表  并且判断是否有环路。
	public void display() {
		int count = 0;
		Node now = head;
		while (now != null ) {
			System.out.print(now.data + "-->");
			count++;
			now = now.next;
		}
		System.out.print("\n节点个数：" + count + "\n");
	}

	//判断环路，，，挺难写的。。。
	public boolean ifCircle(){
		Node n = head;
		if(n==null || n.next==null) return false;
		Node p1 = n;
		Node p2 = n;
		while(p1!=null && p2!=null){
			System.out.print("p1=="+p1.data+"\n");
			System.out.print("p2=="+p2.data+"\n");
			p1 = p1.next;
			p2 = p2.next;
			if(p2==null)
				return false;
			p2 = p2.next;
			if(p1==p2){
				System.out.print("\n存在环路"+p2.data+"-->"+p1.data+"\n");
				return true;
			}
		}
		return false;
	}



}
