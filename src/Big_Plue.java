import java.util.Arrays;
import java.util.Scanner;

/**
 * @Title: Big_Plue.java
 * @Package
 * @Description: TODO
 * @author nutc
 * @date 2013-8-19 下午10:02:50
 * @version V1.0
 */
public class Big_Plue {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			String[] now = s.split(" ");
			char[] a = now[0].toCharArray();
			char[] b = now[1].toCharArray();
			plus(a, b);
		}
	}

	//全部的--都写成++了。。。。！！！！！！！！！
	public static void plus(char[] a, char[] b) {
		if (a == null || b == null)
			return;
		int length =( a.length > b.length ? a.length : b.length )+ 1;  //这里括号不可缺少啊 白痴！

		char[] sum = new char[length];
		Arrays.fill(sum, '#');
		int ia = a.length - 1, ib = b.length - 1, is = sum.length - 1, add = 0;
		while (ia >= 0 && ib >= 0) {
			int now = (a[ia] - '0' + b[ib] - '0' + add) ;
			sum[is] = (char) (now % 10 + '0'); // cast？
			add = now / 10;
			ia--;
			ib--;
			is--;
		}
		while (ia >= 0) {
			int now = (a[ia] - '0' + add);
			sum[is] = (char) (now % 10 + '0'); // cast？
			add = now / 10;
			ia--;
			is--;
		}
		while (ib >= 0) {
			int now = (b[ib] - '0' + add) ;
			sum[is] = (char) (now % 10 + '0'); // cast？
			add = now / 10;
			ib--;
			is--;
		}
		if (add > 0) {
			sum[0] = '1';
		}
		int i = 0;
		if (sum[i] == '#')
			i++;
		while (i < sum.length){
			System.out.print(sum[i]);
			i++;
		}
		System.out.println();
	}
}
