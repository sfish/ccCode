/**
 * @Title: find_ReversePair.java
 * @Package
 * @Description: TODO
 * @author nutc
 * @date 2013-8-14 ÉÏÎç9:51:17
 * @version V1.0
 */
public class find_ReversePair {

	public static void main(String args[]) {
		int[] a = { 7, 5, 4, 6 };
		System.out.println(find_ReversePair(a, 0, a.length - 1));
	}

	public static int find_ReversePair(int[] a, int start, int end) {
		if (a == null || a.length == 1)
			return 0;
		int count = 0;
		int mid = (start + end) / 2;
		count += findPair(a, start, mid, mid + 1, end);
		return count;
	}

	public static int findPair(int[] a, int s1, int e1, int s2, int e2) {
		System.out.println(s1+" "+" "+e1+" "+s2+" "+e2);
		int count = 0;
		if (s1 <e1) {
			int mid1 = (s1 + e1) / 2;
			count += findPair(a, s1, mid1, mid1 + 1, e1);
		}
		if (s2 <e2) {
			int mid2 = (s2 + e2) / 2;
			count += findPair(a, s2, mid2, mid2 + 1, e2);
		}
		int[] now = new int[e2 - s1 + 1];
		int nowindex = e2 - s1;
		while (nowindex >= 0) {
			if (e2 < 0 || e1 >= 0 && a[e1] > a[e2]) {
				count += e2 - s2 + 1;
				now[nowindex--] = a[e1--];
			} else {
				now[nowindex--] = a[e2--];
			}
		}
		for (int i = 0; i < e2 - s1 + 1; i++) {
			a[s1 + i] = now[i];
		}
		System.out.println("---"+count);
		return count;
	}
}
