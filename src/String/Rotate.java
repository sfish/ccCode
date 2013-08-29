package String;  

import java.util.Arrays;

/** 
 * @Title: Rotate.java 
 * @Package String 
 * @Description: TODO
 * @author nutc
 * @date 2013-8-7 обнГ7:39:32 
 * @version V1.0 
 */
public class Rotate {

	
	public static void main(String args[]){
		char[] a = {'a','b','c','d','e'};
		rotate(a,5);
	}
	
	public static void rotate(char[] c,int k){
		if(k<=0||c==null) return;
		if(k>=c.length)  k = k%c.length;
		
		change(c,0,k-1);
		change(c,k,c.length-1);
		change(c,0,c.length-1);
		
		System.out.println(Arrays.toString(c));
	}
	
	public static void change(char[] c,int start,int end){
		while(start<end){
			char temp = c[start];
			c[start] = c[end];
			c[end] = temp;
			start++;
			end--;
		}
	}
}
 

