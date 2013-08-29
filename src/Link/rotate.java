package Link;  
/** 
 * @Title: rotate.java 
 * @Package Link 
 * @Description: TODO
 * @author nutc
 * @date 2013-8-13 ÉÏÎç11:06:50 
 * @version V1.0 
 */
public class rotate {

	public static void main(String args[]) {
		LinkedList link = new LinkedList();

//		link.addNode(1);
//		link.addNode(2);
//		link.addNode(3);
//		Node node1 = new Node(4);
//		link.addNode(node1);
//		link.addNode(5);
//		link.addNode(6);
//		link.addNode(9);
//		Node node2 = new Node(7);
////		node2.addNode(node1);
//		link.addNode(node2);
//		// link.ifCircle();
		link.display();
		Node n = reverse(link.head);
		n.display();
	}
	
	public static Node reverse(Node n){
		if(n==null||n.next == null) return n;
		
		Node pre = null,now = n,next = now.next;
		while(next!=null){
			next = now .next;
			now.next = pre;
			pre = now;
			now = next;
		}
		return pre;
	}
}
 

