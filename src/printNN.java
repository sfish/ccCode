import java.util.Scanner;

/** 
 * @Title: printNN.java 
 * @Package  
 * @Description: TODO
 * @author nutc
 * @date 2013-8-13 ÏÂÎç12:32:28 
 * @version V1.0 
 */
public class printNN {
	
	public static void main(String args[]){

		int n,m;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			n = sc.nextInt();
			m = sc.nextInt();
			int[][] a = new int[n][m];
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					a[i][j] = sc.nextInt();
			print(a);
			System.out.println();
		}
	}

	public static void print(int [][]a){
		if(a==null) return;
		
		p(a,0,a.length,a[0].length);
	}
	
	public static void p(int[][] a,int start,int row,int col){
		if(row<=0||col<=0) return;
		
		for(int i=start;i<col+start;i++)   //×¢Òâ°¡ °×³Õ£¡£¡
			System.out.print(a[start][i]+" ");
		for(int i=start+1;i<row+start;i++)
			System.out.print(a[i][col-1+start]+" ");
		
		for(int i=start+col-2;i>=start;i--)
			System.out.print(a[start+row-1][i]+" ");
		
		for(int i=start+row-2;i>start;i--)
			System.out.print(a[i][start]+" ");
		
		p(a,start+1,row-2,col-2);
	}
}
 

