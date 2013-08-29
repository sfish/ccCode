package Array;

/**
 * @Title: Array_Fenge.java
 * @Package Array
 * @Description: TODO
 * @author nutc
 * @date 2013-8-25 下午7:51:08
 * @version V1.0
 */
public class Array_Fenge {

	public static void main(String args[]) {
		int[] v = { 0, 1, 5, 7, 8, 9, 6, 3, 11, 20, 17 };
		judge2(v);
	}

	public static void judge(int[] num) { // 背包的思想。。。好复杂。。。。3维数组
		int sum = 0;
		for (int i = 0; i < num.length; i++)
			sum += num[i];
		System.out.println(num.length);

		int[][][] f = new int[num.length][(num.length >> 1) + 1][sum / 2 + 1];// ！！！很重要！分别表示遍历到第i个数，
		// 选择了j个数（肯定不超过个数的一半啊白痴！）k表示当前总和 f的值表示在当前情况下 满足的最大值！！

		// 用来记录路径！
		boolean[][][] p = new boolean[num.length][(num.length >> 1) + 1][sum / 2 + 1];
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length >> 1; j++) {
				for (int k = 1; k < sum / 2 + 1; k++) {
					f[i][j][k] = 0;
				}
			}
		}

		for (int i = 1; i < num.length; i++) { // 注意起止！！
			for (int j = 1; j <= Math.min(i, num.length >> 1); j++) { // 注意起止！！！
				for (int k = 1; k <= sum / 2; k++) {   //注意起止！！
					f[i][j][k] = f[i - 1][j][k];
					if (k - num[i] >= 0
							&& (f[i - 1][j - 1][k - num[i]] + num[i] > f[i][j][k])) {
						f[i][j][k] = f[i - 1][j - 1][k - num[i]] + num[i];
						p[i][j][k] = true;
					}
				}
			}
		}
		System.out.println(f[num.length - 1][num.length >> 1][sum / 2]);

		int i = num.length - 1, j = num.length >> 1, k = sum / 2;
		while (i > 0 && j > 0 && k > 0) {
			if (p[i][j][k] == true) {
				System.out.print(num[i] + " ");
				k -= num[i];
				j--;
			}
			i--; // 直接i--表示这个数没有被选中 嗯对！
		}
	}

	public static void judge2(int[] num) { // 逆序的二维数组的思想啊！！！！

		int sum = 0;
		for (int i : num)
			sum += i;

		int[][] f = new int[(num.length >> 1) + 1][sum / 2 + 1]; // 注意<< +的 优先级！
		// for(int j=0;j<=num.length>>1;j++)
		// for(int k = 0;k<=sum/2;k++)
		// f[j][k]=0;
		/**
		 * for i ← 1 to 2*N nLimit ← min(i,N) do for j ← nLimit to 1 do for k ←
		 * A[i] to Sum/2 if (F[j][k] < F[j-1][k-A[i]]+A[i]) then F[j][k] ←
		 * F[j-1][k-A[i]]+A[i]
		 */
		for (int i = 1; i < num.length; i++) {
			for (int j = Math.min(i, num.length >> 1); j > 0; j--) {
				for (int k = 1; k <= sum / 2; k++) {
					 f[j][k] = f[j-1][k];
					if (k>=num[i]&& (f[j - 1][k - num[i]] + num[i]) > f[j][k])
						f[j][k] = f[j - 1][k - num[i]] + num[i]; // 忘记加上+num[i]了。。。太容易错了吧。。。
				}
			}
		}
		System.out.println(f[num.length >> 1][sum / 2]);

	}
}
