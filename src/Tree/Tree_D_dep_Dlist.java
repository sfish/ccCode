package Tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Title: Tree_D_dep_Dlist.java
 * @Package Tree
 * @Description: TODO
 * @author nutc
 * @date 2013-8-21 下午2:25:37
 * @version V1.0
 */
public class Tree_D_dep_Dlist {

	public static void main(String args[]) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		node3.addLeft(node1);
		 node3.addRight(node5);
		 node5.addLeft(node4);
		node1.addRight(node2);
		 node5.addRight(node6);

		Node node9 = new Node(9);
		node1.addLeft(node9);

		node3.display();
		ArrayList<LinkedList<Node>> map = find(node3);
		for (int i = 0; i < map.size(); i++) {
			System.out.println("当前层数" + i);
			for (int j = 0; j < map.get(i).size(); j++) {
				System.out.print(map.get(i).get(j).value + " ");
			}
			System.out.println();
		}
	}

	public static ArrayList<LinkedList<Node>> find(Node root) {
		if (root == null)
			return null;

		ArrayList<LinkedList<Node>> map = new ArrayList<LinkedList<Node>>();
		int level = 0;
		LinkedList<Node> nowlist = new LinkedList<Node>();
		nowlist.push(root);
		map.add(nowlist);

		while (map.size()>level ) {  //这里原来用map.get(level)是错误滴，超出下表了
			nowlist = map.get(level);
			LinkedList<Node> templist = new LinkedList<Node>();
			for (int i = 0; i < nowlist.size(); i++) {
				if (nowlist.get(i).left != null)
					templist.add(nowlist.get(i).left);
				if (nowlist.get(i).right != null)
					templist.add(nowlist.get(i).right);
			}
			level++;   //这个地方，忘记++了。。不过这些是因为使用的结构改动过造成的。。不过！ 还是要仔细检查！
			if (templist.size() > 0)
				map.add(templist);
		}

		return map;
	}
}
