package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * import java.util.*;

 public class Main {
 public static void main(String args[]) {
 Scanner scanner = new Scanner(System.in);
 while(scanner.hasNext()){
 int n = scanner.nextInt();
 int a[]=new int[n];
 int sum =0;
 for (int i = 0; i < n; i++) {
 a[i]=scanner.nextInt();
 sum+=a[i];
 }
 boolean dp[] = new boolean[sum+2];
 dp[0]=true;
 for (int i = 0; i < n; i++) {
 for (int j = sum+1; j-a[i]>=0; j--) {
 dp[j]|=dp[j-a[i]];
 }
 }
 for (int i = 1; i < dp.length; i++) {
 if(!dp[i]){
 System.out.println(i);
 break;
 }
 }

 }
 }


 }
 */
/**
 * @Title: bag.java
 * @Package Array
 * @Description: TODO
 * @author nutc
 * @date 2013-8-19 上午8:39:45
 * @version V1.0
 */
public class bag {
	public static void main(String args[]) {

		int[] a = { 0, 0, 0, 0 };
		threeSum(a);
		// System.out.println(fourSum(a, 0).toString());
		int[] b = {};
		int[] c = {1,2};
		System.out.println(findMedianSortedArrays(b, c));
		// Scanner scanner = new Scanner(System.in);
		// while(scanner.hasNext()){
		// int n = scanner.nextInt();
		// int a[]=new int[n];
		// int sum =0;
		// for (int i = 0; i < n; i++) {
		// a[i]=scanner.nextInt();
		// sum+=a[i];
		// }
		// boolean dp[] = new boolean[sum+1]; //注意+1 免得被下标绕晕。。。
		// dp[0]=true;
		// for (int i = 0; i < n; i++) {
		// // for (int j = sum; j-a[i]>=0; j--) {
		// for(int j=sum;j>=a[i];j--){
		// dp[j]|=dp[j-a[i]];
		// }
		// // System.out.println("++++++"+a[i]);
		// // for(int k=1;k<26;k++){
		// // System.out.println(k+" "+dp[k]);
		// // }
		// }
		// for (int i = 1; i < dp.length; i++) {
		// if(!dp[i]){
		// System.out.println(i);
		// break;
		// }
		// }
		//
		// }
	}

	/*
	 * #include<iostream> #include<cstring> using namespace std; int main(){ int
	 * n,a[105],dp[10005]; while(cin>>n){ memset(dp,0,sizeof(dp)); dp[0]=1; int
	 * m=0; for(int i=0;i<n;i++){ cin>>a[i]; m+=a[i];//m记录所有数值的总和，用以优化后边的循环 }
	 * for(int i=0;i<n;i++) for(int j=m;j>=a[i];j--)//此循环一定要倒序遍历
	 * dp[j]|=dp[j-a[i]]; for(int i=1;i<10005;i++) if(!dp[i]){ cout<<i<<endl;
	 * break; } } }
	 */

	public static int find(int[] a) {
		int[] count = new int[5051];
		Arrays.fill(count, 0);
		int sum = 0;
		// for (int i = 0; i < a.length; i++) {
		// count[a[i]] = 1;
		// sum += a[i];
		// }
		count[0] = 1;
		for (int i = 0; i < a.length; i++) {
			for (int j = sum; j >= a[i]; j--) {
				count[j] |= count[j - a[i]];
			}
			System.out.println("++++++" + a[i]);
			for (int k = 1; k < 26; k++) {
				System.out.println(k + " " + count[k]);
			}
			// System.out.println(Arrays.toString(count));
		}
		int index = 0;
		for (int i = 1; i < count.length; i++) { // 记得是从1开始！！！
			if (count[i] == 0) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null)
			return null;

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			if (i > 0 && num[i] != num[i - 1]) {

				int j = i + 1, k = num.length - 1;
				while (j < k) {
					if (num[j] + num[k] > -num[i]) {
						k--;
					} else if (num[j] + num[k] < -num[i]) {
						j++; // 写错成i了....
					} else {
						ArrayList<Integer> a = new ArrayList<Integer>();
						a.add(i);
						a.add(j);
						a.add(k);
						list.add(a);
					}
				}
			}
		}
		if (list.size() == 0)
			return null;
		else
			return list;
	}

	public static int threeSumClosest(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null)
			return -1;

		int goal = Integer.MAX_VALUE;

		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			int j = i + 1, k = num.length - 1;

			while (j < k) {
				int now = num[i] + num[j] + num[k];
				if (Math.abs(now - target) < Math.abs(goal - target))
					goal = now;
				if (now > target) {
					k--;
					while (j < k && num[k] == num[k + 1])
						k--; // 前提条件！！！
				} else {
					j++;
					while (j < k && num[j] == num[j - 1])
						j++;
				}

			}
		}
		return goal;
	}

	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		if (num == null)
			return null;

		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < num.length - 3; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;

			for (int j = i + 1; j < num.length - 2; j++) {
				if (j > i + 1 && num[j] == num[j - 1])
					continue; // 这里请注意j是从i+1开始的！！！

				int k = j + 1, m = num.length - 1;
				while (k < m) {
					if (num[i] + num[j] + num[k] + num[m] == target) {
						ArrayList<Integer> a = new ArrayList<Integer>();
						a.add(num[i]);
						a.add(num[j]);
						a.add(num[k]);
						a.add(num[m]);
						list.add(a);
						k++;
						m--;
						while (k < m && num[k] == num[k - 1])
							k++;
						while (k < m && num[m] == num[m + 1])
							m--;
					} else if (num[i] + num[j] + num[k] + num[m] > target) {
						m--;
					} else {
						k++;
					}
				}
			}
		}
		return list;
	}

//	public static double findMedianSortedArrays(int A[], int B[]) {
//		if (A == null && B == null)
//			return -1;
//		if (A == null || A.length == 0)
//			return B[B.length / 2];
//		if (B == null || B.length == 0)
//			return A[A.length / 2];
//		boolean ifodd = false;
//		int count = (A.length + B.length) / 2;
//		if (((A.length + B.length) & 1) == 1) { // 前面还要加括号呀亲！
//			ifodd = true;
//		}
//		int starta = 0, enda = A.length - 1;
//		int startb = 0, endb = B.length - 1;
//
//		while (starta <= enda && startb <= endb) {
//			System.out.println(starta + " " + enda + " " + startb + " " + endb);
//			if ((enda - starta + 1 + endb - startb + 1) <= 4) {
//				// return A[enda] > B[endb] ? A[enda] : B[endb];
//				System.out.println("4!!!");
//				break;
//			}
//			// if (!ifodd && (enda - starta + 1 + endb - startb + 1) - count <=
//			// 1) { // 不能等于0
//			// ArrayList<Integer> res = new ArrayList<Integer>();
//			// res.add(A[enda]);
//			// res.add(B[endb]);
//			// if (enda - 1 > 0)
//			// res.add(A[enda]);
//			// if (endb - 1 > 0)
//			// res.add(B[endb]);
//			// Collections.sort(res);
//			// // int[] res = new int[]{A[enda],A[enda-1],B[endb],B[endb-1]};
//			// // Arrays.sort(res);
//			// return (double) (res.get(res.size() - 1) + res
//			// .get(res.size() - 2)) / 2;
//			// }
//
//			int mida = (starta + enda) / 2;
//			int midb = (startb + endb) / 2;
//			if (A[mida] > B[midb]) {
//				if (((enda - starta + 1) & 1) == 1)
//					enda = mida;
//				else
//					enda = mida + 1;
//				if (((endb - startb + 1) & 1) == 1)
//					startb = midb;
//				else
//					startb = midb - 1;
//			} else if (A[mida] <= B[midb]) {
//				if (((endb - startb + 1) & 1) == 1)
//					endb = midb;
//				else
//					endb = midb + 1;
//				if (((enda - starta + 1) & 1) == 1)
//					starta = mida;
//				else
//					starta = mida - 1;
//			} else {
//				return A[mida];
//			}
//		}
//		return 0;
//	}

	// public static double findMedianSortedArrays(int A[], int B[]) {
	// if (A == null && B == null)
	// return -1;
	// if (A == null || A.length == 0)
	// return B[B.length / 2];
	// if (B == null || B.length == 0)
	// return A[A.length / 2];
	// boolean ifodd = false;
	// int count = (A.length + B.length) / 2;
	// if (((A.length + B.length) & 1) == 1) { // 前面还要加括号呀亲！
	// ifodd = true;
	// }
	// int starta = 0, enda = A.length - 1;
	// int startb = 0, endb = B.length - 1;
	//
	// while (starta <= enda && startb <= endb) {
	// System.out.println(starta + " " + enda + " " + startb + " " + endb);
	// if (ifodd && (enda - starta + 1 + endb - startb + 1) - count <=1) {
	// return A[enda] > B[endb] ? A[enda] : B[endb];
	// }
	// if (!ifodd
	// && (enda - starta + 1 + endb - startb + 1) - count <= 1) { //不能等于0
	// ArrayList<Integer> res = new ArrayList<Integer>();
	// res.add(A[enda]);
	// res.add(B[endb]);
	// if (enda - 1 > 0)
	// res.add(A[enda]);
	// if (endb - 1 > 0)
	// res.add(B[endb]);
	// Collections.sort(res);
	// // int[] res = new int[]{A[enda],A[enda-1],B[endb],B[endb-1]};
	// // Arrays.sort(res);
	// return (double) (res.get(res.size() - 1) + res
	// .get(res.size() - 2)) / 2;
	// }
	//
	// int mida = (starta + enda) / 2;
	// int midb = (startb + endb) / 2;
	// if (A[mida] > B[midb]) {
	// enda = mida+1;
	// startb = midb-1;
	// } else if (A[mida] <= B[midb]) {
	// endb = midb+1;
	// starta = midb-1;
	// }
	// }
	// return 0;
	// }
	public static double findMedianSortedArrays(int[] A, int[] B) {
		if (A == null && B == null)
			return -1;
//		if (A == null || A.length == 0)  //不可，另一个 可能是偶数个
//			return B[B.length / 2];
//		if (B == null || B.length == 0)
//			return A[A.length / 2];

		int count = A.length + B.length;
		if ((count & 1) == 1)
			return getK(A, 0, A.length - 1, B, 0, B.length - 1, count / 2 + 1);
		else {
			double sum = getK(A, 0, A.length - 1, B, 0, B.length - 1,
					count / 2 + 1)
					+ getK(A, 0, A.length - 1, B, 0, B.length - 1, count / 2);
			return sum / 2;
		}
	}

	//这个函数的作用是找到两个数组中的第k个数
	public static int getK(int A[], int aBeg, int aEnd, int B[], int bBeg,
			int bEnd, int k) {
		System.out.println(aBeg+" "+aEnd+" "+bBeg+" "+bEnd+" "+k);
		if(aBeg>aEnd){  //A已经不用考虑了，直接在B中就可以求出第K个数
			return B[bBeg+k-1];
		}
		if(bBeg>bEnd){
			return A[aBeg+k-1];
		}
		//k==1的时候，表示当前所有数据里面，最小的那个数据 就是第k个值啦，所以以下：
		if(k==1) return Math.min(A[aBeg], B[bBeg]);  
		
		
		int aMid = (aBeg + aEnd) / 2;
		int bMid = (bBeg + bEnd) / 2;

		int count = aMid - aBeg + bMid - bBeg + 2;
//		if (count == k) // 注意k==count时  不代表 最大值就是那个k值  例子 {1 2 }{1 1}
//			return Math.max(A[aMid], B[bMid]);
		 if (count > k) {
			if (A[aMid] > B[bMid]) {
				return getK(A, aBeg, aMid-1 , B, bBeg, bEnd, k); // 忘记return了。。
			} else {
				return getK(A, aBeg, aEnd, B, bBeg, bMid-1 , k);
			}
		} else {
			if (A[aMid] < B[bMid]) {
				return getK(A, aMid+1 , aEnd, B, bBeg, bEnd, k - (aMid-aBeg+1) );  //这里的+1不可以省略，否则会死循环！！！
			} else {
				return getK(A, aBeg, aEnd, B, bMid+1 , bEnd, k - (bMid-bBeg+1) );
			}
		}
	}
}
