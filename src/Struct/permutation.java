package Struct;

//
//import java.util.ArrayList;
//
///**
// * @Title: permutation.java
// * @Package Struct
// * @Description: ����  ˼·˼·����������
// * @author nutc
// * @date 2013-7-14 ����10:04:11
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
//		c =new char[] {'a'};  //���ܽ���д {a}!!��ֻ�г�ʼ��ʱ��ſ��ԣ�����
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
////				for (int i = index+1; i < array.length; i++) {  +1��û�����ʼ����������棡��������
//				char temp = array[index];
//				array[index] = array[i];
//				array[i] = temp;
//				
//				per(array, index + 1);
//				//�ǵ�Ҫ��������������
//				temp = array[index];
//				array[index] = array[i];
//				array[i] = temp;
//			}
//		}
//	}
//
//	
//	//˼·���ԣ�����
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
//	// // ��ѭ���ˣ���������ش����� newlistԽ��Խ����ѭ��������
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
		if (start == end) {// ��ֻҪ���������һ����ĸ����ȫ����ʱ��ֻҪ�Ͱ��������������
			for (int i = 0; i <= end; i++) {
				System.out.print(buf[i]);
			}
			count++;
			System.out.println();
		} else {// �����ĸȫ����
			for (int i = start; i <= end; i++) {
				char temp = buf[start];// ���������һ��Ԫ���������Ԫ��
				buf[start] = buf[i];
				buf[i] = temp;

				perm(buf, start + 1, end);// ����Ԫ�صݹ�ȫ����

				temp = buf[start];// ������������黹ԭ
				buf[start] = buf[i];
				buf[i] = temp;
			}
		}
	}
}