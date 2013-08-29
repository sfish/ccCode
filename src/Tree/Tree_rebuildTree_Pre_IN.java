package Tree;

/**
 * @Title: Tree_rebuildTree_Pre_IN.java
 * @Package Tree
 * @Description: TODO
 * @author nutc
 * @date 2013-7-24 ÏÂÎç7:22:21
 * @version V1.0
 */
public class Tree_rebuildTree_Pre_IN {
	
	public static void main(String args[]) {
		int[] pre = {1,2,3,4,5,6};
		int[] in = {3,2,4,1,5,6};
		Node root = build(pre,0,in,0,in.length);
		root.display();
	}
		

	//wrong!!!
	public static Node build(int[] pre, int pstart, int[] in, int istart,
			int iend) {
		if (istart > iend || pstart>=pre.length)
			return null;
		System.out.print(pre[pstart]+"  "+pstart+" "+istart+" "+iend+"\n");

		Node now = new Node(pre[pstart]);
		int index = 0;
		for (int i = istart; i < iend; i++) {
			if (in[i] == pre[pstart]) {
				index = i;
				break;
			}
		}
		now.left = build(pre, pstart + 1, in, istart, index - 1);
		now.right = build(pre, pstart + iend - istart + 1, in, index + 1, iend);
		return now;
	}
}
