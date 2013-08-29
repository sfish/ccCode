package Tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @Title: Tree_getD_DepthList.java
 * @Package Tree
 * @Description: Given a binary search tree, design an algorithm which creates a
 *               linked list of all the nodes at each depth (eg, if you have a
 *               tree with depth D, you’ll have D linked lists)
 * @author nutc
 * @date 2013-7-22 下午8:43:16
 * @version V1.0
 */
public class Tree_getD_DepthList {

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

		node1.display();

		HashMap<Integer, LinkedList<Node>> map = new HashMap<Integer, LinkedList<Node>>();
		getList(node1, 1, map);
		// System.out.print(map.size()+"size");

		// 注意循环的写法....!!!!!!
		for (Entry<Integer, LinkedList<Node>> nowmap : map.entrySet()) {
			System.out.println("深度为:" + nowmap.getKey());
			for (int i = 0; i < nowmap.getValue().size(); i++) {
				System.out.print(nowmap.getValue().get(i).value + "--");
			}
			System.out.println();
		}
		// 另一种方式
		Iterator i = map.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry<Integer, LinkedList<Node>> entry = (Map.Entry) i.next();
			System.out.println("深度为:" + entry.getKey());
			for (int j = 0; j < entry.getValue().size(); j++) {
				System.out.print(entry.getValue().get(j).value + "--");
			}
			System.out.println();
		}

	}

	public static void getList(Node node, int depth,
			HashMap<Integer, LinkedList<Node>> map) {
		if (node == null || depth <= 0)
			return;

		LinkedList list = map.get(depth);
		if (list == null) {
			list = new LinkedList<Node>();
			list.add(node);
			map.put(depth, list); // 漏了这句话！！！！！ ！！
		} else
			list.add(node);

		getList(node.right, depth + 1, map);
		getList(node.left, depth + 1, map);

	}
}
