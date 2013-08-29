/**
 * @Title: P1_5.java
 * @Package
 * @Description: Write a method to replace all spaces in a string with ¡®%20¡¯
 * @author nutc
 * @date 2013-7-8 ÏÂÎç8:47:04
 * @version V1.0
 */
public class P1_5 {
	public static void main(String args[]) {

	}

	
	public static void replaceSpace(char[] str) {
		if (str == null)
			return;

		int count = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == ' ')
				count++;
		}
		if (count > 0) {
			char[] newstr = new char[str.length + count];
			int i = 0,j=0;
			while (i >= 0) {
				if (str[i] != ' ')
					newstr[i] = str[j];
				else {
					newstr[i++]='0';
					newstr[i++]='2';
					newstr[i]='0';
				}
				i++;
				j++;
			}
		}

	}
}
