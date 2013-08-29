import String.atoi;

/**
 * @Title: huiwen_num.java
 * @Package
 * @Description: TODO
 * @author nutc
 * @date 2013-8-28 上午11:02:04
 * @version V1.0
 */
public class huiwen_num {
	
	public static void main(String args[]) {
		System.out.println(ifp(123));
		System.out.println(ifp(-44));
		System.out.println(ifp(898));
		System.out.println(ifp(-93938));
	}

	public static boolean ifp(int x) {
		
		if (x < 0) return false;//负数不算 
		
		if (x / 10 == 0)
			return true;
		

		int count = 1;
		int now = x;
		while ((now /= 10) != 0) {
			count++;
		}

		while (count > 1) {
			int a = x / (int) (Math.pow(10, count - 1));
			int b = x % 10;
			if (a != b)
				return false;
			x %= (int) (Math.pow(10, count - 1));
			x /= 10;
			count -= 2;
		}
		return true;
	}
}
