import java.util.Arrays;

/**
 * @Title: P1_3.java
 * @Package
 * @Description: Design an algorithm and write code to remove the duplicate
 *               characters in a string without using any additional buffer
 *               NOTE: One or two additional variables are fine An extra copy of
 *               the array is not SOLUTION FOLLOW UP Write the test cases for
 *               this method
 * @author nutc
 * @date 2013-7-7 ÏÂÎç3:09:25
 * @version V1.0
 */
public class P1_3 {
	
	public static void main(String args[]){
		char[] a = "abcdaaaa".toCharArray();
		
		delDul(a);
		System.out.print(Arrays.toString(a));
	}
	
	
	public static void delDul(char[] str){
		if(str ==null || str.length<=1) return;
		
		int temp = 0;
		boolean[] check  = new boolean[256];
		for(int i=0;i<str.length;i++){
			if(!check[str[i]-'a']){
				str[temp]=str[i];
				temp ++;
				check[str[i]-'a']= true;
			}else{
				
			}
		}
		str[temp]=0;
	}

}
