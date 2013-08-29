package SortSearch;

/**
 * @Title: SearchRotated.java
 * @Package SortSearch
 * @Description: TODO
 * @author nutc
 * @date 2013-8-6 上午10:13:14
 * @version V1.0
 */
/*
 * 难点啊 如何解决重复的问题？ What about duplicates? You may observe that the above function
 * doesn’t give you an ef- ficient result in case of duplicate elements However,
 * if your array has duplicate entries then we can’t do better than O(n) which
 * is as good as linear search For example, if the array is
 * [2,2,2,2,2,2,2,2,3,2,2,2,2,2,2,2,2,2,2], there is no way to find element 3
 * until you do a linear search
 */

public class SearchRotated {

	public static void main(String args[]) {
		// int a[] = new int[] { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };//
		// 注意写法啊
		int a[] = { 2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
		System.out.print(search(a, 3));
	}

	public static int search(int a[], int value) {
		if (a == null)
			return -1;
		return searchBinary(a, value, 0, a.length - 1);
	}

	public static int searchBinary(int a[], int value, int start, int end) {
		System.out.print(start + " " + end + "\n");
		if (start > end)
			return -1;

		int middle = (start + end) / 2;
		if (a[middle] == value)
			return middle;

		if (a[start] == a[middle] && a[middle] == a[end]) {
			// 重复元素很多，进行线性查找？ TODO
		}

		if (a[start] <= a[middle]) {
			if (a[start] <= value && a[middle] > value)
				return searchBinary(a, value, start, middle - 1);
			else
				return searchBinary(a, value, middle + 1, end);
		} else {
			if (a[end] >= value && a[middle] < value)
				return searchBinary(a, value, middle + 1, end);
			else
				return searchBinary(a, value, start, middle - 1);
		}
	}
}
