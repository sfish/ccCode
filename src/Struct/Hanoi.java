package Struct;

import java.util.Stack;

/**
 * @Title: Hanoi.java
 * @Package Struct
 * @Description: TODO
 * @author nutc
 * @date 2013-7-13 ����2:13:00
 * @version V1.0
 */
public class Hanoi {
	//���Ȳ���
	//cc����д����̫һ����
	static Stack<Integer>[] stack ;
	static int count = 0;
	
	public static void main(String args[]){
		stack = new Stack[3];  //���ܼ���<Integer>
		for(int i= 0;i<3;i++){
			stack[i] = new Stack();
		}
		
		for(int i =0;i<8;i++){
			stack[0].push(i);
		}
		move(8,0,1,2);
		
		
		for(Integer i:stack[2]){
			System.out.print(i+" ");
		}
	}

	public static void move(int n, int a, int b, int c) {
		if (n == 1){
			count++;
			stack[c].push(stack[a].pop());
			System.out.print("step "+count+":"+a+"---->"+c+"  "+n+""+"\n");
		}
		else {
			count++;
			move(n - 1, a, c, b);
			stack[c].push(stack[a].pop());
			System.out.print("step "+count+":"+a+"---->"+c+"  "+n+"\n");
			move(n - 1, b, a, c);
		}
	}
}
