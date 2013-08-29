package String;

import java.util.Arrays;

/**
 * @Title: Com.java
 * @Package String
 * @Description: TODO
 * @author nutc
 * @date 2013-8-25 下午2:22:01
 * @version V1.0
 */
public class Com {

	public static int[][] temp;  //保存中间结果呀亲！！！！！

	public static void main(String args[]) {
		String s1 = "abbjoeirj";
		String s2 = "fwab";
		temp = new int[s1.length()][s2.length()];
		for (int i = 0; i < temp.length; i++)
			Arrays.fill(temp[i], -1);
		System.out.println(findCom(s1, s2, 0, 0));

	}

	public static int findCom(String s1, String s2, int index1, int index2) {
		if (index1 == s1.length())
			return s2.length() - index2;
		if (index2 == s2.length())
			return s1.length() - index1;
		if (temp[index1][index2] != -1){
			System.out.println("xx"+index1+" "+index2+"  "+temp[index1][index2]);
			return temp[index1][index2];
		}

		int count1 = findCom(s1, s2, index1 + 1, index2) + 1;
		int count2 = findCom(s1, s2, index1, index2 + 1) + 1;
		int count3 = findCom(s1, s2, index1 + 1, index2 + 1);
		if (s1.charAt(index1) != s2.charAt(index2))
			count3++;
		int max = Math.min(count1, count2);
		max = Math.min(max, count3);
		temp[index1][index2] = max;
		return max;
	}

}
