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
 * @date 2013-7-13 下午1:51:50
 * @version V1.0
 *
 */
public class Stack_Sort {
	//排序的话 直接就用int就好了~~ 因为涉及到比较了嘛
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
	
	public static Stack<Integer> sort(Stack<Integer> s) {   //需要通过return才真正实现排序啊！！ 不然不变啊亲！
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
