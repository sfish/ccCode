package Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Title: SumM.java
 * @Package Array
 * @Description: 题目描述：
 *               小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
 *               他在想究竟有多少种连续的正数序列的和为100
 *               (至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20
 *               ,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck! 输入： 输入有多组数据。
 *               每组数据仅包括1个整数S(S<=1,000,000)。如果S为负数时,则结束输入。 输出：
 *               对应每组数据,若不存在和为S的连续正数序列
 *               ,则输出“Pity!”;否则,按照开始数字从小到大的顺序,输出所有和为S的连续正数序列。每组数据末尾以“#”号结束。
 *               样例输入： 4 5 100 -1 样例输出： Pity! # 2 3 # 9 10 11 12 13 14 15 16 18
 *               19 20 21 22 # 答疑：
 *               解题遇到问题?分享解题心得?讨论本题请访问：http://t.jobdu.com/thread-8077-1-1.html
 * @author nutc
 * @date 2013-8-17 下午9:50:44
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

		while (sc.hasNext()) { // 输入改成这样就通过了.....
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
	// System.out.println(a[i] + " " + a[j]); // 输出写错了....
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
			count = getCount(small - 1, big); // small要算进去，所以要-1！！！！
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
		return (big * big + big - small * small - small) >> 1; // 错写成 <<了！！！
	}
}
