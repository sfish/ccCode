package Array;

import java.util.Scanner;

/**
 * @Title: Max_SubSum.java
 * @Package Array
 * @Description: TODO
 * @author nutc
 * @date 2013-8-10 上午9:01:23
 * @version V1.0 拓展： 题目描述：
 *          给定一个由N个整数元素组成的数组arr，数组中有正数也有负数，这个数组不是一般的数组，其首尾是相连的。数组中一个或多个连续元素可以组成一个子数组
 *          ，其中存在这样的子数组arr[i],…arr[n-1],arr[0],…,arr[j]，
 *          现在请你这个ACM_Lover用一个最高效的方法帮忙找出所有连续子数组和的最大值
 *          （如果数组中的元素全部为负数，则最大和为0，即一个也没有选）。 输入：
 *          输入包含多个测试用例，每个测试用例共有两行，第一行是一个整数n（1
 *          =<n<=100000），表示数组的长度，第二行依次输入n个整数（整数绝对值不大于1000）。 输出：
 *          对于每个测试用例，请输出子数组和的最大值。 样例输入： 6 1 -2 3 5 -1 2 5 6 -1 5 4 -7 样例输出： 10
 *          14
 */
public class Max_SubSum {

	public static void main(String args[]) {
		int n;
		Scanner s = new Scanner(System.in);

		while (s.hasNext()) {
			n = s.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = s.nextInt();
			}
			// subsum(a);
			a = null;
			findMax(a);
		}
	}

	public static void findMax(int[] a) {
		assert(a!=null);
		int[] da = new int[a.length * 2]; // 忘记*2了。。
		System.arraycopy(a, 0, da, 0, a.length);
		System.arraycopy(a, 0, da, a.length, a.length);
		System.out.println(subSumCircle(da));
	}

	public static int subSumCircle(int[] a) {
		if (a == null)
			return 0;
		int max = a[0]; // 不用负无穷，因为有可能不会进入循环，这样就会出错了
		int nowmax = a[0];
		int maxstart = 0, nowstart = 0;
		for (int i = 1; i < a.length; i++) {
			System.out.println(i + " " + nowstart + "  " + nowmax + "  max="
					+ max);
			if (nowmax > 0)
				nowmax += a[i];
			else {
				nowmax = a[i];
				nowstart = i;
			}
			if (i - nowstart + 1 > a.length / 2) {
				nowmax -= a[nowstart];
				nowstart++;
			}
			if (nowmax > max) {
				max = nowmax;
				maxstart = nowstart;
			}
		}
		if (max < 0)
			max = 0;
		System.out.println("st=" + maxstart);
		return max;
	}

	public static void subsum(int a[]) {
		if (a == null || a.length == 0) // 长度这个忘记了啊白痴
			return;

		int maxstart = 0, maxend = 0, max = a[0];
		int now = a[0], nowstart = 0, nowend;
		for (int i = 1; i < a.length; i++) {
			if (now < 0) { // 如果是求最长长度的话 那么应该要这么弄啊 不要出现等号的！！！ 这样才可以是最长滴
				now = a[i];
				nowstart = i;
				nowend = i;
			} else {
				now += a[i];
				nowend = i;
			}
			if (now > max) {
				max = now;
				maxstart = nowstart;
				maxend = nowend;
			}
		}
		System.out.println(max + " " + maxstart + " " + maxend);
	}
}
