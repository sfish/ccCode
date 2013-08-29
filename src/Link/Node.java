package Link;


/**
 * @Title: Node.java
 * @Package Link
 * @Description: TODO
 * @author nutc
 * @date 2013-7-15 上午10:46:32
 * @version V1.0
 */
public class Node {
	int data;
	Node next;

	public Node(int value) {
		data = value;
		next = null;
	}

	public void addNode(Node n) {
		next = n;
	}

	public void display() {
		int count = 0;
		Node now = this;
		while (now != null) {
			System.out.print(now.data + "-->");
			count++;
			now = now.next;
		}
		System.out.print("\n节点个数：" + count + "\n");
	}
}
