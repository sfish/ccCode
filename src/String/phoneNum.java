package String;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title: phoneNum.java
 * @Package String
 * @Description: TODO
 * @author nutc
 * @date 2013-8-25 下午1:51:08
 * @version V1.0
 */
public class phoneNum {
	static String[] num = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
			"wxyz" };
	static char[][] map = new char[10][];

	public static void main(String args[]) {
		for (int i = 0; i < 10; i++) {
			map[i] = num[i].toCharArray();
		}
		char[] now = "234".toCharArray();
		LinkedList<Character> list = new LinkedList<Character>();
		num(now,0,list);
	}

	public static void num(char[] now, int index, LinkedList<Character> list) {  //Character!!!
		if(index==now.length){
			print(list);
			return;
		}
		char c = now[index];
		for(int i=0;i<map[(c-'0')].length;i++){
			list.add(map[(c-'0')][i]);
			num(now,index+1,list);
			list.removeLast();  //要说明是last！
		}
	}
	
	public static void print(List<Character> list){
		for(Character c :list){
			System.out.print(c);
		}
		System.out.println();
	}
}
