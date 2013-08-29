import java.util.Scanner;

/**
 * @Title: findUgly.java
 * @Package
 * @Description: TODO
 * @author nutc
 * @date 2013-8-13 下午9:50:31
 * @version V1.0
 */
public class findUgly {
	public static void main(String args[]){
		int n;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			n = sc.nextInt();
			System.out.println(findUgly(n));
		}
	}

	public static int findUgly(int index) {
		if (index <= 0)
			return -1;
		int[] num = new int[index];
		num[0] = 1;
		int now = 1;

		int index2 = 0, index3 = 0, index5 = 0;
		while (now < index) {
			int min = Math.min(num[index2] * 2, num[index3] * 3);
			min = Math.min(num[index5] * 5, min);
			num[now] = min;
			while (num[index2] * 2 <= num[now])
				index2++;
			while (num[index3] * 3 <= num[now])
				index3++;
			while (num[index5] * 5 <= num[now])
				index5++;

			now++;
		}
		return num[now-1];  //边界又错了。。。
		
	}

}
