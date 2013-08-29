import java.util.Arrays;
import java.util.Scanner;

/** 
 * @Title: printN.java 
 * @Package  
 * @Description: TODO
 * @author nutc
 * @date 2013-8-12 ÏÂÎç9:10:01 
 * @version V1.0 
 */
public class printN {

	public static void main(String args[]){
		int n;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			n = sc.nextInt();
			printNN(n);
		}
	}
	
	public static void printNN(int n){
		char[] num = new char[n];
		addNN(num,0);
	}
	
	public static void addNN(char[] num,int index){
		if(index==num.length)
			print(num);
		else
			for(int i=0;i<10;i++){
				num[index] = (char)(i+'0');
				addNN(num,index+1);
			}
	}
	
	public static void printN(final int n){
		if(n<1) return;
		
		char[] num = new char[n];
		Arrays.fill(num, '0');
		while(!add(num)){
			print(num);
		}
	}
	
	
	public static boolean add(char[] v){
		boolean ifover = false;
		for(int i=v.length-1;i>=0;i--){
			int sum  = v[i]-'0'+1;
			if(sum>9){
				v[i]='0';
				if(i==0)
					ifover = true;
			}else{
				v[i]=(char) (sum+'0');
				break;
			}
		}
		return ifover;
	}
	
	public static void print(char[] v){
		boolean bl = true;
		for(int i=0;i<v.length;i++){
			if(v[i]!='0'){
				if(bl)
					bl = false;
				System.out.print(v[i]);
			}else{
				if(!bl)
					System.out.print(v[i]);
			}
		}
		System.out.println();
	}
}
 

