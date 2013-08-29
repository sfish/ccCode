package Link;

/**
 * @Title: LinkedList_LastN.java
 * @Package Struct
 * @Description: Implement an algorithm to find the nth to last element of a
 *               singly linked list
 * @author nutc
 * @date 2013-7-15 上午10:39:20
 * @version V1.0
 * 我又忘记i++  可以去死了！！！！！
 */
public class LinkedList_LastN {
	
	
	public static void main(String args[]) {
		LinkedList link = new LinkedList();

		link.addNode(1);
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
		int index = 1;
		System.out.print("倒数第"+index+"个是："+findLastN(link.head,index));
	}
	
	public static int findLastN(Node n,int k){
		if(n==null || k<=0)  return Integer.MAX_VALUE;
		Node p1 = n;
		int i = 0;
		while(p1!=null && i<k){
			p1 = p1.next;
			i++;  //我居然又忘记写循环条件了！！！！！！！！！！！！！！！！！！！！
		}
		if(i!=k)  return Integer.MAX_VALUE;  //k值大于链表长度
		Node p2 = n;
		while(p1!=null){
			p1= p1.next;
			p2 = p2.next;
		}
//		System.out.print("倒数第"+k+"个是："+p2.data);
		return p2.data;
		
	}

}
