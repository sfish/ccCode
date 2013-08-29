package probability;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Title: dice.java
 * @Package probability
 * @Description: TODO
 * @author nutc
 * @date 2013-8-17 ����9:49:46
 * @version V1.0
 */
public class dice {

	public static void main(String args[]) {
		int m, n;
		int[] result;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		while (n != 0) {
			m = sc.nextInt();
			result = find(n, m);
			double sum = Math.pow(m, n);
			for (int i = n - 1; i < m * n; i++) {
				DecimalFormat df = new DecimalFormat("0.00"); // TODO
				System.out.println((i + 1) + "  " + df.format(result[i] / sum));
			}
			n = sc.nextInt();
		}
	}

	public static int[] find(int n, int m) {
		int[][] sum = new int[2][n * m+1];  //��Ը�˷ѵ�ռ䣬��֤˼·Ҫ������
		Arrays.fill(sum[0], 0);
		Arrays.fill(sum[1], 0);
		Arrays.fill(sum[0], 1, m+1, 1);  //ʹ���ţ�
		System.out.println(Arrays.toString(sum[0]));

		for (int i = 2; i <= n; i++) {
			int index = 1- i % 2;
			Arrays.fill(sum[index], 0);   //�����������������д��ط��ˡ�����
			for (int j = i; j <= i * m; j++) {
				for (int k = 1; k <= m; k++) {
					if (j - k >= 0 && j - k < m * n) // TODO
						sum[index][j] += sum[1 - index][j - k];
				}
			}
			System.out.println(Arrays.toString(sum[index]));
		}
		return sum[1 - n % 2];
	}
}
