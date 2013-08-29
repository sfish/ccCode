package Struct;

//
///**
// * @Title: Recursion_8queens.java
// * @Package Struct
// * @Description: Write an algorithm to print all ways of arranging eight queens
// *               on a chess board so that none of them share the same row,
// *               column or diagonal
// * @author nutc
// * @date 2013-7-14 上午11:24:04
// * @version V1.0
// */
////白痴。。没考虑对角线的！！！！！
class Recursion_8queens

{

	static final int QUEEN_MAX = 8; // 皇后的数量

	int[][] Queencount = new int[QUEEN_MAX][QUEEN_MAX];// 分配8X8的数组，充当棋盘，存放皇后

	int resultCount = 0;// 记录皇后的放置方法的总数

	int[] Queenplace = new int[QUEEN_MAX];// 存放每行的皇后位置即第column行的皇后放置位置是Queenplace[column]

	public void putQueen(int Rows) {

		int row = Rows;// 行标

		for (int column = 0; column < QUEEN_MAX; column++)// column表示列标
		{
			if (Queencount[row][column] == 0)// row行、column列可以放皇后
			{
				for (int rowi = row + 1; rowi < QUEEN_MAX; rowi++)// for循环的作用是使其斜下方和正下方不为0
				{
					Queencount[rowi][column]++;
					if (column - rowi + row >= 0) {
						Queencount[rowi][column - rowi + row]++;
					}
					if (column + rowi - row < QUEEN_MAX) {
						Queencount[rowi][column + rowi - row]++;
					}
				} //

				Queenplace[row] = column;// row行column列放了皇后
				if (row == QUEEN_MAX - 1)// 皇后已放满，打印出皇后布局
				{
					printQueen(++resultCount);
				} else // 否则继续排列下一行皇后
				{
					putQueen(row + 1);
				}
				for (int rows = row + 1; rows < QUEEN_MAX; rows++)// 回溯，在此行的皇后不放此列column
																	// ，恢复该位置的正下面/斜下面的count
				{
					Queencount[rows][column]--;
					if (column - rows + row >= 0) {
						Queencount[rows][column - rows + row]--;
					}
					if (column + rows - row < QUEEN_MAX) {
						Queencount[rows][column + rows - row]--;
					}
				}
			}
		}
		if (row == 0) {
			System.out.println(QUEEN_MAX + "皇后问题共有" + resultCount + "个解.");
		}
	}

	public void printQueen(int size)// 打印皇后布局

	{

		System.out.println(QUEEN_MAX + "皇后的第" + size + "个解是:");

		System.out.println();

		for (int row = 0; row < QUEEN_MAX; row++)
		{
			for (int column = 0; column < QUEEN_MAX; column++)
			{
				System.out.print(Queencount[row][column]+" ");
//				System.out.print(Queenplace[row] == column ? " * " : " - ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args)

	{

		Recursion_8queens Q = new Recursion_8queens();

		Q.putQueen(0);

	}

}

// public class Recursion_8queens {
//
// static boolean cols[] = new boolean[8];
// static int array[][] = new int[8][8];
// static int count = 0;
//
// public static void main(String args[]) {
//
// for (int i = 0; i < 8; i++) {
// cols[i] = false;
// }
// for (int i = 0; i < 8; i++)
// for (int j = 0; j < 8; j++)
// array[i][j] = 0;
//
// find(0);
// System.out.print("count==" + count);
// }
//
// public static void find(int row) {
// if (row == 8) {
// count++;
// for (int i = 0; i < 8; i++) {
// for (int j = 0; j < 8; j++)
// System.out.print(array[i][j] + " ");
// System.out.println();
// }
// System.out.println();
// }
//
// for (int i = 0; i < 8; i++) {
// if (!cols[i]) {
// array[row][i] = 1;
// cols[i] = true;
// find(row + 1);
//
// array[row][i] = 0;
// cols[i] = false;
// }
//
// }
// }
//
// }
