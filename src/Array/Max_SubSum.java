package Array;

import java.util.Scanner;

/**
 * @Title: Max_SubSum.java
 * @Package Array
 * @Description: TODO
 * @author nutc
 * @date 2013-8-10 ����9:01:23
 * @version V1.0 ��չ�� ��Ŀ������
 *          ����һ����N������Ԫ����ɵ�����arr��������������Ҳ�и�����������鲻��һ������飬����β�������ġ�������һ����������Ԫ�ؿ������һ��������
 *          �����д���������������arr[i],��arr[n-1],arr[0],��,arr[j]��
 *          �����������ACM_Lover��һ�����Ч�ķ�����æ�ҳ���������������͵����ֵ
 *          ����������е�Ԫ��ȫ��Ϊ������������Ϊ0����һ��Ҳû��ѡ���� ���룺
 *          ��������������������ÿ�����������������У���һ����һ������n��1
 *          =<n<=100000������ʾ����ĳ��ȣ��ڶ�����������n����������������ֵ������1000���� �����
 *          ����ÿ�����������������������͵����ֵ�� �������룺 6 1 -2 3 5 -1 2 5 6 -1 5 4 -7 ��������� 10
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
		int[] da = new int[a.length * 2]; // ����*2�ˡ���
		System.arraycopy(a, 0, da, 0, a.length);
		System.arraycopy(a, 0, da, a.length, a.length);
		System.out.println(subSumCircle(da));
	}

	public static int subSumCircle(int[] a) {
		if (a == null)
			return 0;
		int max = a[0]; // ���ø������Ϊ�п��ܲ������ѭ���������ͻ������
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
		if (a == null || a.length == 0) // ������������˰��׳�
			return;

		int maxstart = 0, maxend = 0, max = a[0];
		int now = a[0], nowstart = 0, nowend;
		for (int i = 1; i < a.length; i++) {
			if (now < 0) { // �����������ȵĻ� ��ôӦ��Ҫ��ôŪ�� ��Ҫ���ֵȺŵģ����� �����ſ��������
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
