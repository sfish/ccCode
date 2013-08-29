package Struct;

//
//import java.util.ArrayList;
//
///**
// * @Title: permutation.java
// * @Package Struct
// * @Description: 排列  思路思路！！！！！
// * @author nutc
// * @date 2013-7-14 上午10:04:11
// * @version V1.0
// */
//public class permutation {
//
//	public static void main(String args[]) {
//		ArrayList<Integer> a = new ArrayList<Integer>();
//		a.add(1);
//		a.add(2);
//		a.add(3);
//
////		ArrayList<ArrayList<Integer>> result = getPer(a, 0);
////		for (int i = 0; i < result.size(); i++) {
////			for (int j = 0; j < result.get(i).size(); j++)
////				System.out.print(result.get(i).get(j) + " ");
////			System.out.println();
////		}
//		char[] c = {'a','b','c'};
//		per(c,0);
//		c = null;
//		per(c,0);
//		c =new char[] {'a'};  //不能仅仅写 {a}!!，只有初始的时候才可以！！！
//		per(c,0);
//		c= new char[] {'a','a'};
//		per(c,0);
//	}
//
//	public static void per(char[] array, int index) {
//		if(array==null)
//			return;
//		if (index == array.length - 1) {
////			System.out.print(array.toString());
//			for(int i=0;i<array.length;i++)
//				System.out.print(array[i]+" ");
//			System.out.println();
//		} else {
//			for (int i = index; i < array.length; i++) {
////				for (int i = index+1; i < array.length; i++) {  +1则没算最初始的情况，认真！！！！！
//				char temp = array[index];
//				array[index] = array[i];
//				array[i] = temp;
//				
//				per(array, index + 1);
//				//记得要换回来啊！！！
//				temp = array[index];
//				array[index] = array[i];
//				array[i] = temp;
//			}
//		}
//	}
//
//	
//	//思路不对！！！
//	// public static ArrayList<ArrayList<Integer>> getPer(ArrayList<Integer>
//	// list,
//	// int index) {
//	// ArrayList<ArrayList<Integer>> newlist;
//	// if (index == list.size() - 1) {
//	// newlist = new ArrayList<ArrayList<Integer>>();
//	// ArrayList<Integer> temp = new ArrayList<Integer>();
//	// temp.add(list.get(index));
//	// newlist.add(temp);
//	// return newlist;
//	// } else {
//	// int value = list.get(index);
//	// newlist = getPer(list, index + 1);
//	// // 死循环了！！！大错特错！！！ newlist越来越大，死循环！！！
//	// // for(int j=0;j<newlist.size();j++){
//	// // for(int i=0;i<newlist.get(j).size();i++){
//	// // System.out.print(j+" "+i+"\n");
//	// // newlist.get(j).add(i,value);
//	// // }
//	// // }
//	//
//	// for()
//	// for (int i = 0; i < newlist.get(0).size(); i++) {
//	// ArrayList<Integer> temp = new ArrayList<Integer>();
//	// temp.addAll(newlist.get(0));
//	// newlist.add(temp);
//	// }
//	//
//	// int i = 0;
//	// for (int j = 0; j < newlist.size(); j++) {
//	// System.out.print(i+" "+j+"\n");
//	// newlist.get(j).add(i, value);
//	// i++;
//	// }
//	//
//	// return newlist;
//	// }
//	// }
//}

import java.util.*;

public class permutation {
	static int count = 0;
	static char[] buf = { '1', '2', '3', '4' };
	static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		select(buf, list, 2);

		for (String str : list) {
			char[] temp = str.toCharArray();
			// perm(temp,0,temp.length-1);
			System.out.println(str);
		}

		System.out.println("In total: " + count);
	}

	public static void select(char[] source, ArrayList<String> arrayList,
			int num) {
		int l = source.length;

		char[] temp = new char[num];

		System.arraycopy(source, 0, temp, 0, num);

		arrayList.add(new String(temp));

		for (int i = num; i < l; i++) {
			for (int j = 0; j < num; j++) {
				char tempChar = temp[j];
				temp[j] = source[i];

				arrayList.add(new String(temp));

				temp[j] = tempChar;
			}
		}
	}

	public static void perm(char[] buf, int start, int end) {
		if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
			for (int i = 0; i <= end; i++) {
				System.out.print(buf[i]);
			}
			count++;
			System.out.println();
		} else {// 多个字母全排列
			for (int i = start; i <= end; i++) {
				char temp = buf[start];// 交换数组第一个元素与后续的元素
				buf[start] = buf[i];
				buf[i] = temp;

				perm(buf, start + 1, end);// 后续元素递归全排列

				temp = buf[start];// 将交换后的数组还原
				buf[start] = buf[i];
				buf[i] = temp;
			}
		}
	}
}