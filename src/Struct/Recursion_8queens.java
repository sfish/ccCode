package Struct;

//
///**
// * @Title: Recursion_8queens.java
// * @Package Struct
// * @Description: Write an algorithm to print all ways of arranging eight queens
// *               on a chess board so that none of them share the same row,
// *               column or diagonal
// * @author nutc
// * @date 2013-7-14 ����11:24:04
// * @version V1.0
// */
////�׳ա���û���ǶԽ��ߵģ���������
class Recursion_8queens

{

	static final int QUEEN_MAX = 8; // �ʺ������

	int[][] Queencount = new int[QUEEN_MAX][QUEEN_MAX];// ����8X8�����飬�䵱���̣���Żʺ�

	int resultCount = 0;// ��¼�ʺ�ķ��÷���������

	int[] Queenplace = new int[QUEEN_MAX];// ���ÿ�еĻʺ�λ�ü���column�еĻʺ����λ����Queenplace[column]

	public void putQueen(int Rows) {

		int row = Rows;// �б�

		for (int column = 0; column < QUEEN_MAX; column++)// column��ʾ�б�
		{
			if (Queencount[row][column] == 0)// row�С�column�п��ԷŻʺ�
			{
				for (int rowi = row + 1; rowi < QUEEN_MAX; rowi++)// forѭ����������ʹ��б�·������·���Ϊ0
				{
					Queencount[rowi][column]++;
					if (column - rowi + row >= 0) {
						Queencount[rowi][column - rowi + row]++;
					}
					if (column + rowi - row < QUEEN_MAX) {
						Queencount[rowi][column + rowi - row]++;
					}
				} //

				Queenplace[row] = column;// row��column�з��˻ʺ�
				if (row == QUEEN_MAX - 1)// �ʺ��ѷ�������ӡ���ʺ󲼾�
				{
					printQueen(++resultCount);
				} else // �������������һ�лʺ�
				{
					putQueen(row + 1);
				}
				for (int rows = row + 1; rows < QUEEN_MAX; rows++)// ���ݣ��ڴ��еĻʺ󲻷Ŵ���column
																	// ���ָ���λ�õ�������/б�����count
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
			System.out.println(QUEEN_MAX + "�ʺ����⹲��" + resultCount + "����.");
		}
	}

	public void printQueen(int size)// ��ӡ�ʺ󲼾�

	{

		System.out.println(QUEEN_MAX + "�ʺ�ĵ�" + size + "������:");

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
