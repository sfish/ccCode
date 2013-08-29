package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Title: Tree_3traverse.java
 * @Package Tree
 * @Description: 各种遍历啊遍历。。。。。。
 * @author nutc
 * @date 2013-7-23 下午1:44:06
 * @version V1.0 分清前后中序
 */
public class Tree_3traverse {

	public static void main(String args[]) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		node1.left = node2;
		node2.left = node3;
		node2.right = node4;
		node1.right = node5;
		node5.right = node6;

		System.out.print("pre");
		Preorder(node1);
		System.out.println();
		Preorder2(node1);
		System.out.println();
		
		System.out.print("in:");
		Inorder(node1);
		System.out.println();
		InOrder2(node1);
		System.out.println();
		
		System.out.print("post");
		Postorder(node1);
		System.out.println();
		Postorder2(node1);
		
		
		System.out.println();
		Levelorder(node1);

	}

	// 前序遍历
	public static void Preorder(Node root) {
		if (root == null)
			return;
		System.out.print(root.value + "  ");
		Preorder(root.left);
		Preorder(root.right);
	}

	// http://www.cnblogs.com/10jschen/archive/2012/08/14/2637930.html

	// 前序遍历
	public static void Preorder2(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		Node t = root;
		while (!s.isEmpty()) {
			t = s.pop();
			t.show();
			if (t.right != null)
				s.push(t.right);
			if (t.left != null)
				s.push(t.left);
		}
	}

	// 中序遍历
	public static void Inorder(Node root) {
		if (root == null)
			return;
		Inorder(root.left);
		System.out.print(root.value + "  ");
		Inorder(root.right);

	}

	// 中序遍历非递归 好难想到。。。。。　　关键在ｗｈｉｌｅ里判断是否ｔ为空　以及　ｔ　＝　ｔ．ｒｉｇｈｔ不加判断是否为空
	public static void InOrder2(Node t) {
		Stack<Node> s = new Stack<Node>();
		while (t != null || !s.empty()) {
			while (t != null) {
				s.push(t);
				t = t.left;
			}
			if (!s.empty()) {
				t = s.pop();
				t.show();
				t = t.right;
			}
		}
	}
	
	// 中序遍历非递归 好难想到。。。。。
	public static void InOrderCC(Node root) {
		Stack<Node> s = new Stack<Node>();
		
		s.push(root);
		Node t = root;
		while(!s.isEmpty()){
			while(t.left!=null){
				s.push(t.left);
				t = t.left;
			}
			t = s.pop();
			t.show();
			if(t.right!=null)
				s.push(t.right);
				
		}
	}

	public static void InorderByLoop(Node root) {
		Stack<Node> stack = new Stack<Node>();

		stack.push(root);
		while (stack.peek() != null) {
			System.out.print(stack.peek().value + "\n");
			if (stack.peek().left != null) {
				stack.push(stack.peek().left);
			} else {
				Node node = stack.pop();
				node.show();
				if (node.right != null)
					stack.push(node.right);
			}
		}

		// while(stack.peek()!=null){
		// while(stack.peek().left!=null)
		// }
	}

	// 后序遍历  
	public static void Postorder(Node root) {
		if (root == null)
			return;
		Postorder(root.left);
		Postorder(root.right);
		System.out.print(root.value + "  ");
	}
	
	// 后序遍历——非递归  更变态啊 。。。需要加入标示判断是否访问过
	public static void Postorder2(Node root) {
		Stack<Node> s = new Stack<Node>();
		Stack<Boolean> status = new Stack<Boolean>();
		Node t;
		s.push(root);
		status.push(false);
		while(!s.isEmpty()){
			t = s.peek();
			if(!status.peek()){
				status.pop();
				status.push(true);
				
				if(t.right!=null){
					s.push(t.right);
					status.push(false);
				}
				if(t.left!=null){
					s.push(t.left);
					status.push(false);
				}
					
			}else{
				t.show();
				s.pop();
				status.pop();
			}
		}
		
	}
	// 层次遍历
	public static void Levelorder(Node root) {
		// Queue<Node> queue = new Queue<Node>();
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<Node>(); // 注意下写法！！！
		queue.offer(root);

		Node now;
		while ((now = queue.poll()) != null) {
			now.show();
			if (now.left != null)
				queue.offer(now.left);
			if (now.right != null)
				queue.offer(now.right);
		}
	}
}
