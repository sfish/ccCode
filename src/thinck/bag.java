package thinck;

import java.util.Scanner;

/**
 * @Title: bag.java
 * @Package thinck
 * @Description: TODO
 * @author nutc
 * @date 2013-8-19 下午8:24:49
 * @version V1.0
 */
public class bag {

	public static void main(String args[]) {
		int sum, n;
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			sum = sc.nextInt();
			n = sc.nextInt();
			int[] count = new int[3500];
			int[] val = new int[3500];
			for (int i = 0; i < n; i++) {
				count[i] = sc.nextInt();
				val[i] = sc.nextInt();
			}
			System.out.println(find(sum, count, val));
		}
	}

	public static int find(int sum, int[] weight, int[] value) {
		int[] dp = new int[14000];
		// if(sum<0) return 0;
		//
		// int now,max = Integer.MIN_VALUE;
		// for(int i=0;i<count.length;i++){
		// if(count[i]>0){
		// count[i]--;
		// now = find(sum-val[i],count,val)+val[i];
		// count[i]++;
		// if(now>max)
		// max = now;
		// }
		// }
		// return max;

		for (int i = 1; i <= sum; i++) {
			// 因为使用了一维数组，所有j要按照递减顺序
			for (int j = value.length; j >= weight[i]; j--) {
				if (dp[j - weight[i]] + value[i] > dp[j])
					dp[j] = dp[j - weight[i]] + value[i];
			}
		}
		return dp[value.length];
	}
}
