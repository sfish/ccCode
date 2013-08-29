package Struct;

import java.util.Stack;

/**
 * @Title: Stack_ifstackok.java
 * @Package Struct
 * @Description: TODO
 * @author nutc
 * @date 2013-8-13 下午1:05:49
 * @version V1.0
 */
public class Stack_ifstackok {

	public static void main(String args[]) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 4, 5, 3, 2, 1 };
		int[] c = { 4, 3, 5, 1, 2 };
		int[] d = { 5,4,3,2,1};

		System.out.print(judge(a, a));
		System.out.print(judge(a, d));
	}

	public static boolean judge(int[] in, int[] out) {
		Stack<Integer> stack = new Stack<Integer>();
		int outstart = 0, instart = 0;
		while (outstart < out.length) {
			if (stack.size() != 0 && stack.peek() == out[outstart]) {
				stack.pop();
				outstart++;
			} else {  //妹的 就是少了这个括号....
				if (instart >= in.length)
					return false;
				stack.push(in[instart++]);
			}
		}
		return true;
	}
}
