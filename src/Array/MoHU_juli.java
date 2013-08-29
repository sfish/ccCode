package Array;

import Tree.Node;

/**
 * @Title: MoHU_juli.java
 * @Package Array
 * @Description: X和Y都是只有0和1组成的字符串。D(X,Y)称为模糊距离，定义如下： 首先删除X和Y从头开始的公共子串
 *               然后将X和Y剩下部分的长度相加得到模糊距离
 *               例如D(1000,1111)，首先，删除子串“1”，然后剩下“000”和“111”长度都是3，相加为6，则
 *               D(1000,1111)=6。
 *               例如D(101,1100)，首先删除公共子串“1”，然后剩下"01"和"100"长度分别为2，3，相加为5，则
 *               D(101,1100)=5。
 * 
 *               问题是，给定n个只有0和1的字符串，如： 1111 1000 101 1100 ...
 *               请找到最大的模糊距离，字符串总数为n，字符串最长为m。
 * @author nutc
 * @date 2013-8-17 下午8:37:43
 * @version V1.0
 */
public class MoHU_juli {
	
	public static void main(String args[]){
		int [][] a = {{1,1,1,1},{1,1,0,0,1},{1,1,1,0,0,0}};
		System.out.println("模糊距离为"+findDis(a));
		int [][] b = {{1,1,1,1},{1,0,0,0}};
		System.out.println("模糊距离为"+findDis(b));
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
			int nowdis = left.height + right.height;  //注意模糊距离的概念！ 所以应该是相加！！！
			
			r.max = left.max>right.max?left.max:right.max;
			r.max = r.max>nowdis? r.max:nowdis;
		}
		return r;
	}

}
