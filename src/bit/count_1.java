package bit;  
/** 
 * @Title: count_1.java 
 * @Package bit 
 * @Description: TODO
 * @author nutc
 * @date 2013-8-20 上午10:12:34 
 * @version V1.0 
 */
public class count_1 {

	public static void main(String args[]){
		System.out.println(" "+find2(-9));
	}
	
	public static int find1(int n){
		System.out.println("值 "+Integer.toBinaryString(n));

		if(n<0) n = -n;
		int flag = 1,count=0,i=0;
		while(flag>0){
			i++;
			if((n & flag) == flag) //这里要有括号哟！！！！
				count++;
			flag<<=1;
			System.out.println(i+" "+Integer.toBinaryString(flag));
		}
		return count;
	}
	
	public static int find2(int n){
		System.out.println("值 "+Integer.toBinaryString(n));
		if(n<0) n= -n;
		int count=0;
		while(n>0){  //木有等号!!!
			System.out.println("值n "+Integer.toBinaryString(n));
			System.out.println("值n-1 "+Integer.toBinaryString(n-1));
			n&=(n-1);

			count++;
		}
		return count;
	}
}
 

