package Array;  

import java.util.Arrays;

/** 
 * @Title: LongestIncrease.java 
 * @Package Array 
 * @Description: TODO
 * @author nutc
 * @date 2013-8-28 下午2:28:11 
 * @version V1.0 
 */
public class LongestIncrease {
	
	public static void main(String args[]){
		int []  a = {1,-1,2,-3,4,-5,6,-7};
		System.out.println(find(a));
	}
	
	public static int find(int[] num){
		
		int longset [] = new int[num.length];
		Arrays.fill(longset, 1);
		
	    int max = 1;
	    
	    for(int i=1;i<num.length;i++){
	    	
	    	for(int j=i-1;j>=0;j--){
	    		if(num[j]<num[i]){
	    			num[i]+=num[j]+1;
	    			if(num[i]>max)
	    				max = num[i];
	    			break;  //要记得break！  不然全部都要循环下了...
	    		}
	    	}
	    }
	    return max;
	}

}
 

