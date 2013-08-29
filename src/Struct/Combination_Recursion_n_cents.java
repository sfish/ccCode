package Struct;

import java.util.Scanner;

/**
 * @Title: Combination_Recursion_n_cents.java
 * @Package Struct
 * @Description: Given an infinite number of quarters (25 cents), dimes (10
 *               cents), nickels (5 cents) and pennies (1 cent), write code to
 *               calculate the number of ways of representing n cents
 * @author nutc
 * @date 2013-7-14 下午12:57:16
 * @version V1.0
 */
//思路！！！
public class Combination_Recursion_n_cents {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n != -1) {
			System.out.print(n+"===="+findway(n, 25));
			n = s.nextInt();
		}
	}

	public static int findway(int sum, int type) {

		int nexttype = 1;
		switch (type) {
		case 25:
			nexttype = 10;
			break;
		case 10:
			nexttype = 5;
			break;
		case 5:
			nexttype = 1;
			break;
		case 1:
//			return sum;  //错误！！ 只返回1，全部都是1只是一种解法！！
			return 1;
		}
		int way = 0;
		for (int i = 0; i * type <= sum; i++) {// i 0or 1?
			way += findway(sum - i * type, nexttype);
		}
		return way;
	}
}
