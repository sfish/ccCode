package String;

import java.util.Arrays;

/**
 * @Title: if_sub_String_rotate.java
 * @Package String
 * @Description: TODO
 * @author nutc
 * @date 2013-8-25 上午9:18:21
 * @version V1.0
 */
public class if_sub_String_rotate {
	
	public static void main(String args[]){
		String s1 = "aabcd";
		String s2   = "c";
		String s3 ="cdaabc";
		String s4  ="fwoei";
		System.out.println(judge(s1,s2));
		System.out.println(judge(s1,s3));
		System.out.println(judge(s1,s4));

	}

	public static boolean judge(String s1, String s2) {
		if (s2 == null)
			return true;
		if (s1 == null||s1.length()<s2.length())  //这种情况还需要判断s2的长度会不会比s1长！
			return false;
		
		
//		StringBuilder sb = new StringBuilder(s1);
//		sb.append(s1);
		String s  = s1.concat(s1);
//		String s = sb.toString();
		if(s.contains(s2)){
			return true;
		}
		else
			return false;
	}
	
	public static boolean judge1(String s1,String s2){
		if (s2 == null)
			return true;
		if (s1 == null||s1.length()<s2.length())  //这种情况还需要判断s2的长度会不会比s1长！
			return false;
		char[] c1 = s1.toCharArray();
		get_next(c1);
		char[] c2 = s2.toCharArray();
		int start = 0,now;
		int start2 = 0 ;
		while(start!=c1.length){
			while(start<c1.length && c1[start]!=c2[start2])//这里忘记判断start的范围了！！！
				start++;
			if(start<c1.length){
				now = start;
				while(start2!=c2.length&&c2[start2]==c1[start]){
					start++;
					start2++;
					if(start==c1.length){
						start = 0;
					}
				}
				if(start2==c2.length)
					return true;
				else{
					start2 = 0;
					start = now+1;
				}
			}
		}
		return false;
	}
	
	public static void get_next(char[] c){
		int[] next = new int[c.length];
		Arrays.fill(next, 0);
		int i=1,j=0;
		while(i<c[0]){
			System.out.println(Arrays.toString(next));
			if(j==0||c[i]==c[j]){
				i++;
				j++;
				if(c[i]==c[j])  next[i]=next[j];
				else next[i]=j;
				
			}else
				j=next[j];
		}
		System.out.println(Arrays.toString(next));

	}
}
