package SortSearch;

/**
 * @Title: MergeSort.java
 * @Package SortSearch
 * @Description: 9.1  You are given two sorted arrays, A and B, and A has a large
 *               enough buffer at the end to hold B Write a method to merge B
 *               into A in sorted order
 * @author nutc
 * @date 2013-8-6 ����9:21:41
 * @version V1.0
 */
public class MergeSort {
	//Ҫע�⵽��ԭ�ش���
	public static void main(String args[]) {
		int[] a = new int[20]; // ע�����д�����׳գ� ���� int(20) Ҳ����int()[20]!
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

	// �������Ҫ���ǰѳ���Ҳ��Ϊ��������������Ȼa���ü��㳤��
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
		// if(i<0) ��仰�Ƕ����
		while (j >= 0)
			a[n--] = b[j--];

	}

}
