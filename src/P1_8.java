/**
 * @Title: P1_8.java
 * @Package
 * @Description: 1 8 Assume you have a method isSubstring which checks if one
 *               word is a substring of another Giventwostrings,s1ands2,
 *               writecodetocheckifs2isarotationofs1using only one call to
 *               isSubstring (i e , “waterbottle” is a rotation of
 *               “erbottlewat”) SOLUTION
 * @author nutc
 * @date 2013-7-7 下午2:37:37
 * @version V1.0
 * //忘记做输入的判断了 白痴！！！！！！！！！ 而且长度一定是一样的白痴！！！！！
 * rotation 是循环的意思！！！！  reverse 才是翻转的意思！！！
 */
public class P1_8 {

	public static void main(String args[]) {
		String s1 = "waterbottl1";
		String s2 = "erbottlewat";
		System.out.print(JudgeRotation(s1, s2) + " ");
	}

	public static boolean JudgeRotation(String s1, String s2) {
		//忘记做输入的判断了 白痴！！！！！！！！！ 而且长度一定是一样的白痴！！！！！
		if (s1 != null && s1.length() > 0 && s1.length() == s2.length()) {
			String s = s1 + s1;
			if (s.contains(s2))
				return true;

		}
		return false;
	}
}
