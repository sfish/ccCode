package Tree;

/**
 * @Title: Tree_toDoublyLinkedList.java
 * @Package Tree
 * @Description: �������������Ϊ�����˫������
 * 
 *               Ҫ���ܴ����½ڵ㣬ֻ����ָ�롣 �ݹ�ⷨ��
 *               ��1�����������������Ϊ�գ�����Ҫת������Ӧ˫������ĵ�һ���ڵ���NULL�����һ���ڵ���NULL
 *               ��2����������������Ϊ�գ�
 * 
 *               ���������Ϊ�գ���Ӧ˫����������ĵ�һ���ڵ��Ǹ��ڵ㣬��߲���Ҫ����������
 *               �����������Ϊ�գ�ת���������������������Ӧ˫����������ĵ�һ���ڵ����������ת����˫����������ĵ�һ���ڵ�
 *               ��ͬʱ�����ڵ��������ת�����˫�������� ������һ���ڵ����ӣ�
 *               ���������Ϊ�գ���Ӧ˫��������������һ���ڵ��Ǹ��ڵ㣬�ұ߲���Ҫ����������
 *               �����������Ϊ�գ���Ӧ˫��������������һ���ڵ����������ת����˫��������������һ���ڵ�
 *               ��ͬʱ�����ڵ��������ת�����˫����������ĵ�һ���ڵ��� �ӡ�
 * @author nutc
 * @date 2013-7-23 ����2:19:37
 * @version V1.0
 * ��ס�� ����������ָ��a��a���ұ߾��Զ�ָ�����ˣ���������
 * �侲��������Ļ�����ʵ����~~~~
 * �Ѹ������´��������д���ķ�ʽ��
 */
public class Tree_toDoublyLinkedList {

	public static Node head;

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

		node3.display();
		ToLinked(node3, null, null); // �����д���ˡ���д��node1��...

		Node now = head;
		while (now != null) {
			System.out.print("now=" + now.value);
			if (now.left != null)
				System.out.print("  left=" + now.left.value);
			if (now.right != null)
				System.out.print("  right=" + now.right.value);
			System.out.println();
			now = now.right;
		}
	}

	// 2:33
	public static void ToLinked(Node now, Node leftfather, Node rightfather) {
		if (now == null)
			return;
//		System.out.print("��ʼǰ");
//		now.showLR();
		if (now.left == null) {
			if (leftfather == null) {
				head = now;
				now.left = null;
			} else {
				leftfather.right = now;
				now.left = leftfather;// ��������ˣ��ǳ���Ҫ
			}
		} else {
			ToLinked(now.left, leftfather, now);
		}

		if (now.right == null) {
			if (rightfather != null) {
				rightfather.left = now;
				now.right = rightfather;// ��������ˣ��ǳ���Ҫ
			} else
				now.right = null;
		} else {
			ToLinked(now.right, now, rightfather);
		}
//		System.out.print("������");
//		now.showLR();
	}
}
