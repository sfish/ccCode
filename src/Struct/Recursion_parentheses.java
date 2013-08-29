package Struct;

import java.util.Scanner;

/**
 * @Title: Recursion_parentheses.java
 * @Package Struct
 * @Description: Implement an algorithm to print all valid (e g , properly
 *               opened and closed) combi- nations of n-pairs of parentheses
 * 
 * @author nutc
 * @date 2013-7-13 ����8:02:08
 * @version V1.0
 */
public class Recursion_parentheses {

	static char array[];
	static int count = 0;  //count �Ĺ��ɣ�

	public static void main(String args[]) {

		System.out.print("input the num of pairs of parenthese:(-1 for end)");
		int n;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		while (n != -1) {
			count = 0;
			array = new char[n * 2];
			ShowParentheses(0, n * 2, n, n);
			System.out.print("count=="+count+"\n");
			n = s.nextInt();
		}
		return;
	}

	// Ҫϸ�İ��ף���Ҫ�뵱Ȼ���ף� ����Ҫ���������һ�鰡��
	public static void ShowParentheses(int index, int n, int left, int right) {
		if (index == n - 1) { //��ʵ����ȥ��n����left==0 && right==0���жϣ�����
			array[index] = ')';
			count++;
			for (int i = 0; i < n; i++)
				System.out.print(array[i]);
			System.out.println();
		} else {
			if (left > 0) {
				array[index] = '('; //
				ShowParentheses(index + 1, n, left - 1, right);
			}
			// else if (right>0 && left < right) {
			if (right > 0 && left < right) { // ���ﲻ�ܼ���else������
				array[index] = ')'; //
				ShowParentheses(index + 1, n, left, right - 1);
			}
		}
	}

	// //�뷨����ش�������
	// public static void ShowParentheses(int index,int n,int left,int right){
	// if(index == n-1){
	// array[index]=')';
	// for(int i=0;i<n;i++)
	// System.out.print(array[i]);
	// System.out.println();
	// }else{
	// array[index]='(';
	// ShowParentheses(index+1,n,left+1,right);
	// if(left>right){
	// array[index]=')';
	// ShowParentheses(index+1,n,left,right);
	// }
	// }
	// }
}
