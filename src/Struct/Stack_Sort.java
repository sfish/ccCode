package Struct;

import java.util.Iterator;
import java.util.Stack;

/**
 * @Title: Stack_Sort.java
 * @Package Struct
 * @Description: Write a program to sort a stack in ascending order You should
 *               not make any assump- tions about how the stack is implemented
 *               The following are the only functions that should be used to
 *               write this program: push | pop | peek | isEmpty
 * @author nutc
 * @date 2013-7-13 ����1:51:50
 * @version V1.0
 *
 */
public class Stack_Sort {
	//����Ļ� ֱ�Ӿ���int�ͺ���~~ ��Ϊ�漰���Ƚ�����
	public static void main(String args[]){
		Stack<Integer> s = new Stack<Integer>();
		s.push(3);
		s.push(9);
		s.push(6);
		s.push(7);
		s.push(4);
		for(Integer i:s){
			System.out.print(i+" ");
		}
		s = sort(s);
		for(Integer i:s){
			System.out.print(i+" ");
		}
		System.out.println(); 
		Iterator i = s.iterator();
		while(i.hasNext()){
			System.out.print(i.next()+" ");
		}
	}
	
	public static Stack<Integer> sort(Stack<Integer> s) {   //��Ҫͨ��return������ʵ�����򰡣��� ��Ȼ���䰡�ף�
		if (s == null || s.size() == 1)
			return s;
		Stack<Integer> temp = new Stack<Integer>();
		while (!s.isEmpty()) {
			int value = s.pop();
			while(!temp.isEmpty() && temp.peek()>value)
				s.push(temp.pop());
			
			temp.push(value);
		}
		return s = temp;
	}
}
