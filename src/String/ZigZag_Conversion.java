package String;

/**
 * @Title: ZigZag_Conversion.java
 * @Package String
 * @Description: TODO
 * @author nutc
 * @date 2013-8-28 ÉÏÎç9:40:59
 * @version V1.0
 */
public class ZigZag_Conversion {

	public static void main(String args[]) {
		ZigZag_Conversion l = new ZigZag_Conversion();
		String s = "dskbrfmxkbfemuxrvmarsketqpelrcbxulyoqklcnqgbkdtirvb";
		System.out.println(l.convert(s, 10));// PINALSIGYAHRPI
	}

	public String convert(String s, int nRows) {

		if (s == null || nRows <= 0)
			return null;
		if (nRows == 1)
			return s;

		int key = (nRows - 1) * 2;

		StringBuilder sb = new StringBuilder();
		int x = key, y = 0;
		for (int i = 0; i < nRows && i < s.length(); i++) { // ¿¼ÂÇ'A' 2
			sb.append(s.charAt(i));
			int j = i;
			while (j < s.length()) {
				j += x; 
				if (x > 0 && j < s.length()) {
					// System.out.println(j + " x" + x + "  " + s.charAt(j));
					sb.append(s.charAt(j));
				}
				j += y;
				if (y > 0 && j < s.length()) {

					// System.out.println(j + " y" + y + "  " + s.charAt(j));
					sb.append(s.charAt(j));
				}
			}
			x -= 2;
			y += 2;
		}
		return sb.toString();
	}
}
