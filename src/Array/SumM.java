package Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Title: SumM.java
 * @Package Array
 * @Description: ��Ŀ������
 *               С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100�����������������ڴ�,
 *               �����뾿���ж������������������еĺ�Ϊ100
 *               (���ٰ���������)��û���,���͵õ���һ������������Ϊ100������:18,19,20
 *               ,21,22�����ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck! ���룺 �����ж������ݡ�
 *               ÿ�����ݽ�����1������S(S<=1,000,000)�����SΪ����ʱ,��������롣 �����
 *               ��Ӧÿ������,�������ں�ΪS��������������
 *               ,�������Pity!��;����,���տ�ʼ���ִ�С�����˳��,������к�ΪS�������������С�ÿ������ĩβ�ԡ�#���Ž�����
 *               �������룺 4 5 100 -1 ��������� Pity! # 2 3 # 9 10 11 12 13 14 15 16 18
 *               19 20 21 22 # ���ɣ�
 *               ������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-8077-1-1.html
 * @author nutc
 * @date 2013-8-17 ����9:50:44
 * @version V1.0
 */
public class SumM {

	public static void main(String args[]) {
		// int n, m;
		// Scanner sc = new Scanner(System.in);
		// while (sc.hasNextLine()) {
		// n = sc.nextInt();
		// m = sc.nextInt();
		// int[] val = new int[n];
		// for (int i = 0; i < n; i++)
		// val[i] = sc.nextInt();
		//
		// findSum(val, m);
		// }

		int n;
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) { // ����ĳ�������ͨ����.....
			n = sc.nextInt();
			if (n >= 0)
				find(n);
			else
				break;
		}
	}

	// public static void findSum(int a[], int sum) {
	// if (a == null)
	// return;
	//
	// Arrays.sort(a);
	// int i = 0, j = a.length - 1;
	// while (i < j) {
	// if (a[i] + a[j] > sum)
	// j--;
	// else if (a[i] + a[j] < sum)
	// i++;
	// else {
	// System.out.println(a[i] + " " + a[j]); // ���д����....
	// return;
	// }
	// }
	// System.out.println("-1 -1");
	// return;
	//
	// }

	public static void find(int sum) {
		int small = 1, big = 2;
		int result = 0;
		int count;
		while (small << 1 < sum && big < sum) {
			count = getCount(small - 1, big); // smallҪ���ȥ������Ҫ-1��������
			// System.out.println(small+" "+big+" count=="+count);
			if (count < sum)
				big++;
			else if (count > sum)
				small++;
			else {
				result++;
				for (int i = small; i < big; i++) {
					System.out.print(i + " ");
				}
				System.out.print(big);
				System.out.println();
				small++;
			}
		}
		if (result == 0)
			System.out.println("Pity!");
		System.out.println("#");

	}

	public static int getCount(int small, int big) {
		return (big * big + big - small * small - small) >> 1; // ��д�� <<�ˣ�����
	}
}
