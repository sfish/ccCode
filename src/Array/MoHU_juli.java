package Array;

import Tree.Node;

/**
 * @Title: MoHU_juli.java
 * @Package Array
 * @Description: X��Y����ֻ��0��1��ɵ��ַ�����D(X,Y)��Ϊģ�����룬�������£� ����ɾ��X��Y��ͷ��ʼ�Ĺ����Ӵ�
 *               Ȼ��X��Yʣ�²��ֵĳ�����ӵõ�ģ������
 *               ����D(1000,1111)�����ȣ�ɾ���Ӵ���1����Ȼ��ʣ�¡�000���͡�111�����ȶ���3�����Ϊ6����
 *               D(1000,1111)=6��
 *               ����D(101,1100)������ɾ�������Ӵ���1����Ȼ��ʣ��"01"��"100"���ȷֱ�Ϊ2��3�����Ϊ5����
 *               D(101,1100)=5��
 * 
 *               �����ǣ�����n��ֻ��0��1���ַ������磺 1111 1000 101 1100 ...
 *               ���ҵ�����ģ�����룬�ַ�������Ϊn���ַ����Ϊm��
 * @author nutc
 * @date 2013-8-17 ����8:37:43
 * @version V1.0
 */
public class MoHU_juli {
	
	public static void main(String args[]){
		int [][] a = {{1,1,1,1},{1,1,0,0,1},{1,1,1,0,0,0}};
		System.out.println("ģ������Ϊ"+findDis(a));
		int [][] b = {{1,1,1,1},{1,0,0,0}};
		System.out.println("ģ������Ϊ"+findDis(b));
	}

	public static int findDis(int[][] val) {
		if (val == null)
			return 0;

		Node tree = new Node(-1);
		for (int i = 0; i < val.length; i++) {
			buildTree(tree, val[i]);
		}
//		tree.display();
		Result re = findMax(tree);
		return re.max;

	}

	public static void buildTree(Node root, int[] num) {
		if (num == null)
			return;
		Node now = root;
		for (int i = 0; i < num.length; i++) {
			int val = num[i];
			if (val == 1) {
				if (now.right == null) {
					Node n = new Node(1);
					now.right = n;
				}
				now = now.right;
			} else {
				if (now.left == null) {
					Node n = new Node(0);
					now.left = n;
				}
				now = now.left;
			}
		}
	}

	public static class Result {
		int max;
		int height;
	}

	public static Result findMax(Node n) {
		Result r = new Result();
		if (n == null) {
			r.height = 0;
			r.max = 0;
		}else{
			Result left = findMax(n.left);
			Result right = findMax(n.right);
			
			r.height = (left.height>right.height? left.height:right.height)  +1;
			int nowdis = left.height + right.height;  //ע��ģ������ĸ�� ����Ӧ������ӣ�����
			
			r.max = left.max>right.max?left.max:right.max;
			r.max = r.max>nowdis? r.max:nowdis;
		}
		return r;
	}

}
