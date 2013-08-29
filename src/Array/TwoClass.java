package Array;  

import java.util.Arrays;

/** 
 * @Title: TwoClass.java 
 * @Package Array 
 * @Description: TODO
 * @author nutc
 * @date 2013-8-28 ÏÂÎç8:38:03 
 * @version V1.0 
 */
public class TwoClass {
	
	public static void main(String args[]){
		int [][] a = {{0,0}};
		System.out.println(uniquePathsWithObstacles(a));
	}
	 public  static int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        if(obstacleGrid==null) return 0;
	       
	        
	        int m = obstacleGrid.length;
	        int n = obstacleGrid[0].length;
	        
	         if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1) return 0;
	        
	        int[][] path =new int [m][n];  
	        path[0][0]=1; 
	          
	        for(int i=0;i<m;i++){  
	            for(int j=0;j<n;j++){  
	                if(i-1>=0 && obstacleGrid[i-1][j]!=1)
	                    path[i][j]+=path[i-1][j];  
	                    
	                if(j-1>=0 && obstacleGrid[i][j-1]!=1)
	                    path[i][j]+=path[i][j-1];  
	                System.out.println(Arrays.deepToString(path));
	            }  
	        }  
	        return path[m-1][n-1];  
	    }
}
 

