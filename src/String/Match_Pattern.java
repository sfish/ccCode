package String;  
/** 
 * @Title: Match_Pattern.java 
 * @Package String 
 * @Description: TODO
 * @author nutc
 * @date 2013-8-28 ÏÂÎç1:56:00 
 * @version V1.0 
 */
public class Match_Pattern {
	

	public static void main(String args[]) {
		System.out.println(isMatch("aa","a*"));
//		System.out.println(isMatch(-44));
//		System.out.println(isMatch(898));
//		System.out.println(isMatch(-93938));
	}
	
	 public static  boolean isMatch(String s, String p) {

	        if(p==null) return false;
	        if(s==null){
	            if (p.charAt(0)=='.'||p.charAt(0)=='*' )
	                return true;
	            else 
	                return false;
	        }
	        int i=0,j=0;
	        if(j+1<p.length() && p.charAt(j+1)!='*'){
	            if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')
	                return isMatch(s.substring(1),p.substring(1));
	            else
	                return false;
	        }else{
	            /*
	            while(*p == *s || ((*p) == '.' && (*s) != 0))  
	            {  
	                if(isMatch(s, p + 2))  
	                {  
	                    return true;  
	                }  
	                s++;  
	            }  
	            return isMatch(s, p + 2);  */
	            while(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.'){
	                if(isMatch(s,p.substring(2))){
	                    return true;
	                }
	                i++;
	            }
	            return isMatch(s,p.substring(2));
	        }
	    }
}
 

