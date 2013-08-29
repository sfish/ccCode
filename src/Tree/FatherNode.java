package Tree;

/**
 * @Title: FatherNode.java
 * @Package Tree
 * @Description: TODO
 * @author nutc
 * @date 2013-7-22 ����9:31:54
 * @version V1.0
 */
public class FatherNode {
	FatherNode left;
	FatherNode right;
	FatherNode father;
	int value;

	public FatherNode(int v) {
		value = v;
		father = null;
		left = right = null;
	}

	public void display() {
		System.out.print("��ǰ" + value);
		if (left != null) {
			System.out.print("  ���" + left.value);
		}
		if (right != null) {
			System.out.print("   �ұ�" + right.value);
		}
		System.out.println();
		if (left != null)
			left.display();
		if (right != null)
			right.display();

	}
	
	public void addLeft(FatherNode n){
		left = n;
		n.father = this;
	}
	
	public void addRight(FatherNode n){
		right = n;
		n.father = this;
	}
}
