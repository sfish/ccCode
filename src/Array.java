import java.util.Arrays;

/**
 * @Title: Array.java
 * @Package
 * @Description: TODO
 * @author nutc
 * @date 2013-8-8 下午1:38:53
 * @version V1.0
 */
public class Array {

	public static void main(String args[]) {
		int n = 10;
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = i + 1;

//		change1(a);
		change2(a);
	}

	public static void change1(int a[]) {
		if (a == null)
			return;

		int n = a.length / 2;
		if (n > 1) {
			swap(a, n - 1, n);
			for (int i = n - 2; i > 1; i--) { // 是分号不是逗号啊亲
				swap(a, i, i - 1);
				swap(a, 2 * n - i, 2 * n - i - 1);
			}
		}
		System.out.println(Arrays.toString(a)); // 忘记print了！！！
	}
	
	//不断前移啊前移
	public static void change2(int a[]) {
		if (a == null)
			return;

		int n = a.length / 2;
		int j = n,k= n-1;
		
		while(j!=2*n-1){
			int temp = a[j];
			for(int i=j;i>j-k;i--){
				a[i]=a[i-1];
			}
			a[j-k]= temp;
			j++;
			k--;
			System.out.println(Arrays.toString(a));
		}
		System.out.println(Arrays.toString(a)); // 忘记print了！！！
	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
