package SortSearch;

/**
 * @Title: MergeSort.java
 * @Package SortSearch
 * @Description: 9.1  You are given two sorted arrays, A and B, and A has a large
 *               enough buffer at the end to hold B Write a method to merge B
 *               into A in sorted order
 * @author nutc
 * @date 2013-8-6 上午9:21:41
 * @version V1.0
 */
public class MergeSort {
	//要注意到是原地处理
	public static void main(String args[]) {
		int[] a = new int[20]; // 注意这个写法啊白痴！ 不是 int(20) 也不是int()[20]!
		int[] b = { 3, 7, 10, 39, 99 };
		a[0] = 4;
		a[1] = 10;
		a[2] = 49;
		a[3] = 89;
		a[4] = 101;

		merge(a, 5, b, 5);

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}

	// 这里很重要的是把长度也作为参数传进来，不然a不好计算长度
	public static void merge(int a[], int alength, int b[], int blength) {
		if (b == null || blength <= 0)
			return;
		if (a == null && b != null) {
			return; // error
		}
		int i = alength - 1, j = blength - 1, n = alength + blength - 1;
		while (i >= 0 && j >= 0) {
			if (a[i] > b[j])
				a[n--] = a[i--];
			else
				a[n--] = b[j--];
		}
		// if(i<0) 这句话是多余的
		while (j >= 0)
			a[n--] = b[j--];

	}

}
