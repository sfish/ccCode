package Tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Title: Tree_findCommonAncestor.java
 * @Package Tree
 * @Description: Design an algorithm and write code to find the first common
 *               ancestor of two nodes in a binary tree Avoid storing additional
 *               nodes in a data structure NOTE: This is not necessarily a
 *               binary search tree
 * @author nutc
 * @date 2013-7-23 ����9:27:14
 * @version V1.0
 */
public class Tree_findCommonAncestor2 {

	
	public static void main(String args[]){
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine(); //�ǳ���Ҫ����ȡ������Ļس���
		while(n>0){
			String[] str = sc.nextLine().split(" ");
			int [] num = new int[str.length];
			for(int i=0;i<num.length;i++){
				num[i]=Integer.parseInt(str[i]);
			}
			FatherNode root = buildTree(num);
//			root.display();
			int n1,n2 ;
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			sc.nextLine();  //�ǳ���Ҫ����ȡ������Ļس���
			FatherNode com = findCom(root,n1,n2);
			if(com!=null)
				System.out.println(String.valueOf(com.value));
			else{
				System.out.println("My God");
			}
			n--;
		}
	}
	
	public static FatherNode buildTree(int[] num){
		if(num==null) return null;
		FatherNode root = new FatherNode(num[0]);
		FatherNode now = root;
		int index=1;
		while(index<num.length){
//			System.out.println(now.value);
			if(num[index]!=0){
				if(now.left==null){   //ȫ��д���ˡ�����д���� ��=
					now.left = new FatherNode(num[index]);
					now.left.father = now;  //���׺Ͷ��� ���ǿ���ģ�����
					now = now.left;
					index ++;
				}else if(now.right==null){
					now.right = new FatherNode(num[index]);
					now.right.father = now;   //���׺Ͷ��� ���ǿ���ģ�����
					now = now.right;
					index++;
				}else{
					now = now.father;
				}
			}else{
				now = now.father;
				index+=2;
			}
		}
		return root;
	}
	
	public static FatherNode findCom(FatherNode root,int n1,int n2){
		if(root==null) return null;
		LinkedList<FatherNode> list1 = new LinkedList<FatherNode>();
		LinkedList<FatherNode> list2 = new LinkedList<FatherNode>();
		findList(root,n1,list1);
		findList(root,n2,list2);
//		System.out.println(list1.toString());
		Iterator<FatherNode> it1 = list1.iterator();  //Ҫ�޶����Ͱ��ף��������ף�����
		Iterator<FatherNode> it2 = list2.iterator();
		FatherNode last = null;
		while(it1.hasNext() && it2.hasNext()){
			FatherNode f1 = it1.next();  //����   it2 = it2.next();
			FatherNode f2 = it2.next();  //�����nodeȡ�����Ƚϣ�����ֱ�ӱȽ� it1 �� it2!!!
//			System.out.println(f1+" -- "+f2);
			if(f1 == f2){
				last = f1;
			}else{
				break;
			}
		}
		return last;
	}
	
	public static boolean findList(FatherNode root,int n,LinkedList<FatherNode> list){
		if(root ==null) return false;
		list.add(root);
		if(root.value == n){
			return true;
		}
		boolean iffound = false;
		iffound = findList(root.left,n,list);
		if(!iffound)
			iffound = findList(root.right,n,list);
		
		if(!iffound)  list.removeLast();  //remove Ĭ��ɽ��һ��
		return iffound;
	}
	
	
	public static class FatherNode {
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
}
