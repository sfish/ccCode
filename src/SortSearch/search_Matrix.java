package SortSearch;

/**
 * @Title: search_Matrix.java
 * @Package SortSearch
 * @Description: Given a matrix in which each row and each column is sorted,
 *               write a method to find an element in it
 * @author nutc
 * @date 2013-8-6 下午1:25:53
 * @version V1.0
 */
// 代码的写法 写法很不好，循环里嵌套循环，判断结束条件的时候会比较麻烦啊 白痴。。。
public class search_Matrix {

	public static void main(String args[]) {

		int a[][] = new int[][] { { 1, 2, 3, 4, 5 }, { 3, 4, 9, 11, 12 },
				{ 7, 8, 13, 16, 17 } };

		Find(a, 11, 3, 5);
	}

	public static void Find(int a[][], int v, int row, int col) {
		if (a == null || row <= 0 || col <= 0)
			return;
		int i = row - 1, j = 0;

		// 写法很不好，循环里嵌套循环，判断结束条件的时候会比较麻烦啊 白痴。。。
		// while (i >= 0 && j < col) {
		// while (j<col && a[i][j] < v)
		// j++;
		// while (i>0 && a[i][j] > v)
		// i--;
		// if (a[i][j] == v) {
		// System.out.println("find " + v + " 在a" + i + " " + j);
		// break;
		// }
		//
		// }
		while (i >= 0 && j < col) {
			if (a[i][j] == v) {
				System.out.println("find " + v + " 在a" + i + " " + j);
				break;
			}
			if (a[i][j] > v)
				i--;
			else
				j++;
		}

		if (i < 0 || j >= col)
			System.out.println("not found");
	}
}
