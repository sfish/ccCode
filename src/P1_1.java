/**
 * @Title: P1_1.java
 * @Package
 * @Description: Implement an algorithm to determine if a string has all unique
 *               characters What if you can not use additional data structures?
 * @author nutc
 * @date 2013-7-7 ÏÂÎç2:48:03
 * @version V1.0 !!!!For simplicity, assume char set is ASCII (if not, we need
 *          to increase the storage size The rest of the logic would be the
 *          same) NOTE: This is a great thing to point out to your interviewer!
 */
public class P1_1 {

	public boolean JudgeUnique(String s) {
		if (s == null || s.length() == 1)
			return true;

		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i) - 'a'; // ÓÃvalÌæ»»a
			if (((1 << val) & count) > 0)
				return false;
			count |= (1 << val);
		}
		return true;
	}
}
