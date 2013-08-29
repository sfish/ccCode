package String;  

import java.util.Arrays;

/** 
 * @Title: Longest_Substring_Without_Repeating_Characters.java 
 * @Package String 
 * @Description: TODO
 * @author nutc
 * @date 2013-8-27 下午10:32:10 
 * @version V1.0 
 */
public class Longest_Substring_Without_Repeating_Characters {
	public static void main(String args[]) {
		Longest_Substring_Without_Repeating_Characters l = new Longest_Substring_Without_Repeating_Characters();
		String s = "abcabcde";
		System.out.println(l.lengthOfLongestSubstring(s));
	}
	public int lengthOfLongestSubstring(String s) {
	    
        if(s==null||s.length()==0) return 0;
        if(s.length()==1) return 1;
        
        char[] c = s.toCharArray();
        
        int longest = 0,index = 0,now = 0;
        int [] map = new int[26];
        Arrays.fill(map,-1);  //下标有可能会出现 0！！ 所以不可以用0！！
        for(int i=0;i<c.length;i++){
            if(map[c[i]-'a']==-1||map[c[i]-'a']<index){
                now++;
                map[c[i]-'a']=i;
                if(now>longest){
                    longest = now;
                }
            }else{
                now-=(map[c[i]-'a']-index);
                index = map[c[i]-'a']+1;
                map[c[i]-'a'] = i;
            }
            System.out.println(i+" "+longest+" "+index+" "+now);
        }
        return longest;
    }
}
 

