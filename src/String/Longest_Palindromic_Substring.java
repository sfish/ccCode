package String;

import java.util.Arrays;

/**
 * @Title: Longest_Palindromic_Substring.java
 * @Package String
 * @Description: TODO
 * @author nutc
 * @date 2013-8-27 下午8:31:39
 * @version V1.0
 */
public class Longest_Palindromic_Substring {
//  1 2 1 2 3 2 1 2 1 2 1 4 1 2 1 2 1 2 1
	public static void main(String args[]) {
		Longest_Palindromic_Substring l = new Longest_Palindromic_Substring();
		String s = "$#w#a#a#b#w#s#w#f#d#$";//"&#a#b#b#&";
		System.out.println(l.longestPalindrome(s));
		l.rebuild("asdfg");
		l.pk(s);
	}

	public String longestPalindrome(String s) {

		if (s == null || s.length() <= 1)
			return s; // String 的长度有括号！
		int longest = 0;
		int index = 0;
		char[] c = s.toCharArray();
		for (int i = 1; i < c.length; i++) {

			int now = getLong(c, i - 1, i + 1) + 1;
			if (c[i] == c[i - 1])
				now = Math.max(now, getLong(c, i - 2, i + 1)+2);
			if (now > longest) {
				longest = now;
				index = i - now / 2;
			}
		}
		return s.substring(index,index+ longest); // substring 小写啊 白痴,是index+ longest而不是longest  !!!!
	}

	public int getLong(char[] s, int i, int j) {
		int count = 0;
		while (i >= 0 && j < s.length && s[i] == s[j]) {
			i--;
			j++;
			count++;
		}
		return count * 2;
	}
	
	public void rebuild(String s){
		if(s==null) return ;
		char[] c = new char[s.length()*2+3];
		c[0]='&';
		c[1]='#';
		int j=0;
		for(int i=2;i<c.length;i++){
			c[i]=s.charAt(j);
			j++; i++;
			c[i]='#';
		}
		c[c.length-1]='&';
		System.out.println(Arrays.toString(c));
	}
	
	public void pk(String s){
		char[] c = s.toCharArray();
		System.out.println(Arrays.toString(c));

		int[] p = new int[c.length];
		int i=0;
		int mx= 0;
		int id=0;
		int ans = 1;
		for(i=1;i<c.length-1;i++){  //去除最左和最右边
			if(mx>i)  //这一步是优化的关关关键
				p[i]=Math.min(p[2*id-i],mx-i);
			else
				p[i]=1;
			for(;c[i+p[i]]==c[i-p[i]];p[i]++)
				;
			if(p[i]+i>mx){ 
				mx=p[i]+i;
				id=i;
			}
			ans = Math.max(ans, p[i]);
			System.out.println(Arrays.toString(p));
			System.out.println("i="+i+" mx="+mx+" id="+id);
		}
		System.out.println(ans-1+"  ");
	}
	
	public class Solution {
	    public int lengthOfLongestSubstring(String s) {
	    
	        if(s==null||s.length()==0) return 0;
	        if(s.length()==1) return 1;
	        
	        char[] c = s.toCharArray();
	        
	        int longest = 0,index = 0,now = 0;
	        int [] map = new int[26];
	        Arrays.fill(map,0);
	        for(int i=0;i<s.length();i++){
	            if(map[c[i]-'a']==0){
	                now++;
	                map[c[i]-'a']=i;
	                if(now>longest){
	                    longest = now;
	                }
	            }else{
	                now-=(map[c[i]-'a']+index);
	                index = map[c[i]-'a']+1;
	                map[c[i]-'a'] = i;
	            }
	        }
	        return longest;
	    }
	}
}
