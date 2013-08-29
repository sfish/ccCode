package Link;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Title: LinkedList_AddSum.java
 * @Package Link
 * @Description: You have two numbers represented by a linked list, where each
 *               node contains a sin- gle digit The digits are stored in reverse
 *               order, such that the 1’s digit is at the head of the list Write
 *               a function that adds the two numbers and returns the sum as a
 *               linked list
 * 
 *               Input: (3 -> 1 -> 5), (5 -> 9 -> 2) Output: 8 -> 0 -> 8
 * @author nutc
 * @date 2013-7-15 下午1:27:26 自己有改过哟
 * @version V1.0 Input: (3 -> 1 -> 5), (5 -> 9 -> 2) Output: 9 -> 0 -> 7
 *          (9->9->9->9->9),(1) (0),(0) (9->2->0),(8->9)
 * 
 *          抽自己一万遍！！无数次忘记循环了！！！！ s = s.replace()!!! 只能说指针太容易出错了.....
 */
public class LinkedList_AddSum_Reverse {

	public static ArrayList<LinkedList> alllist = new ArrayList<LinkedList>();

	public static void main(String args[]) {

		getInput();
	}

	public static void getInput() {

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] num = input.split(","); // 不能写‘,’!!!!
		for (int i = 0; i < num.length; i++) {
			String s = num[i];
			// @@@@@@@@@@@ 要写成 s = s.re... 只有返回结果才是改变后的！！！ 并不是在原来的str上做改变！！！！
			s = s.replace("(", "");
			s = s.replace(")", "");
			s = s.replace(" ", "");
			String[] strarray = s.split("->");
			LinkedList list = new LinkedList();
			for (int j = 0; j < strarray.length; j++) {
				list.addNode(Integer.parseInt(strarray[j]));
			}
			alllist.add(list);
		}
		addSum2(alllist.get(0).head, alllist.get(1).head).display();
		// getSum().display();
	}

	public static Node addSum2(Node n1, Node n2) {
		if (n1 == null)
			return n2;
		if (n2 == null)
			return n1;

		Node pre = null, nsum = null, sumnow = null;

		while (n1 != null && n2 != null) {  //还是不对》。。而且太多循环....

			int sum = n1.data + n2.data;
			if (sum > 10) {
				if (pre == null) {
					Node n = new Node(1);
					n.next = nsum;
					nsum = n;
					pre = nsum;
					while (pre.next != sumnow) {
						if (pre.data == 9)
							pre.data = 0;
						pre = pre.next;
					}
				} else {
					pre.data++;
					while (pre.next != sumnow) {
						pre.next.data = 0;
						pre = pre.next;
					}
				}

			}

			Node n = new Node(sum%10);
			if (nsum == null) {
				nsum = n;
				sumnow = n;
			} else {
				sumnow.next = n;
				if (sumnow.data != 9)
					pre = sumnow;
				sumnow = sumnow.next;
			}

			n1 = n1.next;
			n2 = n2.next;
		}
		if (n1 != null)
			n2 = n1;
		while (n2 != null) {
			Node n = new Node(n2.data);
			sumnow.next = n;
			sumnow = sumnow.next;
		}

		return nsum;
	}

	// public static public static void addSum3(LinkedList list1, LinkedList
	// list2) {
	// Node l1 = list1.head, l2 = list2.head;
	//
	// Node head = null, pre = null, p = null, q = null;
	// while (l1 != null && l2 != null) {
	// int sum = (l1.data + l2.data);
	// Node now = new Node(sum % 10);
	// q.next = now;
	// pre = q;
	// q = q.next;
	// if (sum >= 9) {
	// if (sum > 9) {
	// if (p != null) {
	// p.data++;
	// p = p.next;
	// while (p != q) {
	// p.data = 0;
	// }
	// p = null;
	// } else {
	// pre.data++;
	// }
	// Node now2 = new Node(sum - 10);
	// now2.next = q;
	// p = now2;
	// }
	// } else {
	// p = pre;
	// }
	// }
	// }

	public static LinkedList getSum() {
		for (int i = 0; i < alllist.size(); i++) {
			alllist.get(i).display();
			Reverse(alllist.get(i));
			System.out.print("旋转后:");
			alllist.get(i).display();
		}

		LinkedList sum = Join(alllist.get(0), alllist.get(1));
		Reverse(sum);
		return sum;

	}

	public static LinkedList Join(LinkedList list1, LinkedList list2) {
		Node n1 = list1.head, n2 = list2.head;
		LinkedList sum = new LinkedList();
		int add = 0, num;
		while (n1 != null && n2 != null) {
			num = n1.data + n2.data + add;
			if (num > 9) {
				add = 1;
				num = num - 10;
			} else {
				add = 0;
			}
			// 不要忘记循环！！
			n1 = n1.next;
			n2 = n2.next;
			sum.addNode(num);
		}
		if (n2 != null)
			n1 = n2;
		if (n1 != null) {
			while (n1 != null) {
				num = n1.data + add;
				if (num > 9) {
					add = 1;
					num = num - 10;
				} else {
					add = 0;
				}
				n1 = n1.next; // 我又再次。。。忘记循环了。。。。再次。。。我去
				sum.addNode(num);
			}
		}
		// 忘记了最后一个进位！！！
		if (add == 1) {
			sum.addNode(1);
		}
		return sum;
	}

	public static void Reverse(LinkedList list) {
		Node now = list.head;
		if (now == null || now.next == null)
			return;
		Node pre = null, next = null;
		while (now != null) {
			next = now.next;
			now.next = pre;
			pre = now;
			now = next;
			
		}
		pre.display();
		list.head = pre;

		// 错误代码。。。智障一般。。。 next都是null还判断个神马！！
		// Node pre = null, next = null;
		// while (next != null) {
		// next = now.next;
		// now.next = pre;
		//
		// pre = now;
		// now = next;
		// }
	}
}
