/**
 * @Title: P1_7.java
 * @PackageWrite an algorithm such that if an element in an MxN matrix is 0, its
 *               entire row and column is set to 0
 * @Description: 有错！ 思路
 * @author nutc
 * @date 2013-7-7 下午2:12:58
 * @version V1.0
 */
public class P1_7 {
	public static void main(String args[]) {

		int matrix[][] = new int[][] { { 1, 2 }, { 0, 2 } };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
		setZeros(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void setZeros(int matrix[][]) {
		if (matrix == null)
			return;
		boolean row[] = new boolean[matrix.length];
		boolean col[] = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) { // 错写成1了！！！！！
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] == true || col[j] == true) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < row.length; i++)
			System.out.print(row[i] + " ");
		System.out.println();

		for (int i = 0; i < col.length; i++)
			System.out.print(col[i] + " ");
		System.out.println();
	}
}
