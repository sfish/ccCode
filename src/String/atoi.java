package String;  
/** 
 * @Title: atoi.java 
 * @Package String 
 * @Description: TODO
 * @author nutc
 * @date 2013-8-28 上午10:33:33 
 * @version V1.0 
 */
public class atoi {

	public static void main(String args[]) {
		atoi l = new atoi();
		String s = "345e980";
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);

		System.out.println(" "+l.atoi(s));// PINALSIGYAHRPI
		System.out.println(" "+l.atoi2(s));// PINALSIGYAHRPI
	}
	
	public int atoi(String str) {
        int len = str.length();
        if (len == 0) return 0;
        int ret = 0;
        boolean signal = true;
        int i = 0;
        while (i < len && str.charAt(i) == ' ') {  //空格
            i++;    
        }
        if (i < len && str.charAt(i) == '-') { 
            signal = false;
            i++;
        } else if (i < len && str.charAt(i) == '+') {  //注意还有+号！
            i++;
        } else if (str.charAt(i) < '0' || str.charAt(i) > '9') return 0;
        int count = 0;
        while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (signal) {//MAX 2147483647  MIN -2147483648
                if (count == 10 || ret>214748364  || (ret == 214748364 && str.charAt(i) >= '7')) return Integer.MAX_VALUE;
                ret = ret * 10 + (str.charAt(i) - '0');
            } else {
                if (count == 10 || (ret<-214748364 ) || ( (ret == -214748364 && str.charAt(i) >= '8') )) return Integer.MIN_VALUE;
                ret = ret * 10 - (str.charAt(i) - '0');
            }
//            System.out.println(ret);
            i++;
            count++;
        }
        return ret;
    }
	
	public int atoi2(String s) {    //取巧的方式
        s = s.trim();  
        long value = 0;    //用long！！
        boolean isPositive = true;  
          
        for (int i = 0; i < s.length(); i++) {  
            if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-')) {  
                if (s.charAt(i) == '-') {  
                    isPositive = false;  
                }  
                continue;  
            }  
            if (s.charAt(i) < '0' || s.charAt(i) > '9') break;  
            value = 10 * value + s.charAt(i) - '0';  
        }  
        value = isPositive == true ? value : value * -1;  
        if (value < -2147483648) {  
            return -2147483648;  
        } else if (value > 2147483647) {  
            return 2147483647;  
        } else {  
            return (int) value;  
        }  
    } 
}
 

