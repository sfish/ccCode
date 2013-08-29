package Link;  
/** 
 * @Title: join2sortlist.java 
 * @Package Link 
 * @Description: TODO
 * @author nutc
 * @date 2013-8-13 ÉÏÎç11:34:14 
 * @version V1.0 
 */
public class join2sortlist {

	public static void main(String args[]) {
		LinkedList link = new LinkedList();

		link.addNode(1);
		link.addNode(9);
		link.addNode(12);
//		Node node1 = new Node(4);
//		link.addNode(node1);
//		link.addNode(5);
//		link.addNode(6);
//		link.addNode(9);
//		Node node2 = new Node(7);
////		node2.addNode(node1);
//		link.addNode(node2);
//		// link.ifCircle();
		
		LinkedList link2 = new LinkedList();

		link2.addNode(3);
		link2.addNode(7);
		link.display();
		link2.display();
		Node n = join(link.head,link2.head);
		n.display();
	}
	public static Node join(Node n1,Node n2){
		if(n1==null) return n2;
		if(n2 == null) return n1;
		
		Node now ;
		if(n1.data<n2.data){
			now = n1;
			now.next = join(n1.next,n2);
		}else{
			now = n2;
			now .next = join(n1,n2.next);
		}
		return now;
	}

}
 

