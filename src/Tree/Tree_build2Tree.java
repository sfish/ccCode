package Tree;  
/** 
 * @Title: Tree_build2Tree.java 
 * @Package Tree 
 * @Description: TODO
 * @author nutc
 * @date 2013-7-22 ÏÂÎç8:20:29 
 * @version V1.0 
 */
public class Tree_build2Tree {

	
	public static void main(String args[]){
		int[] a = {1,2,3,4,5};
		Node root = buildTree(a,0,a.length-1);
		root.display();
	}
	
	public static Node buildTree(int[] arrays,int start,int end){
		if(start>end||arrays==null||end>=arrays.length)
			return null;
		
		int index = (start+end)/2;
		Node node = new Node(arrays[index]);
		
		node.left = buildTree(arrays,start,index-1);
		node.right = buildTree(arrays,index+1,end);
		
		return node;
	}
}
 

