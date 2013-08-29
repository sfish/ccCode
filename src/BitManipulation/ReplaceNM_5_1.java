package BitManipulation;

import java.util.Stack;

/**
 * @Title: ReplaceNM_5_1.java
 * @Package BitManipulation
 * @Description: You are given two 32-bit numbers, N and M, and two bit
 *               positions, i and j Write a method to set all bits between i and
 *               j in N equal to M (e g , M becomes a substring of N located at
 *               i and starting at j)
 * @author nutc
 * @date 2013-7-18 下午2:08:25
 * @version V1.0
 * ms给的答案不太对
 * http://blog.csdn.net/zhanglei0107/article/details/8875904
 * 
 * 找时间试试上面这个
 */
public class ReplaceNM_5_1 {

	public static void main(String args[]) {
		int n = 518;
		int m = 25;
		showBits(n);
		showBits(m);
		n = updateBits(n, m, 1, 7);
		// System.out.print(n);
		showBits(n);
	}

	public static int updateBits(int n, int m, int i, int j) {
		int max = ~0; /* All 1’s */

		// 1’s through position j, then 0’s
		int left = max - ((1 << j) - 1);
		showBits(left);

		// 1’s after position i
		int right = ((1 << i) - 1);
		showBits(right);

		// 1’s, with 0s between i and j
		int mask = left | right;
		showBits(mask);

		showBits(n & mask);
		showBits(m << i);

		// Clear i through j, then put m in there
		return (n & mask) | (m << i);
	}

	public static void showBits(int n) {
		System.out.print(n + " = ");
		if (n < 0)
			n = -n;
		Stack<Integer> stack = new Stack();
		while (n != 0) {
			stack.push(n % 2);
			n = n / 2;
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		System.out.println();
	}
}
