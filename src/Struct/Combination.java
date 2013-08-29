package Struct;  

import java.util.ArrayList;

/** 
 * @Title: Combination.java 
 * @Package Struct 
 * @Description: Write a method that returns all subsets of a set
 * @author nutc
 * @date 2013-7-14 上午9:26:22 
 * @version V1.0 
 */
public class Combination {
	
	public static void main(String args[]){
		ArrayList<String> a  = new ArrayList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		
		ArrayList<ArrayList<String>> result = getSub(a,0);
		
		
		for(int i=0;i<result.size();i++){
			for(int j=0;j<result.get(i).size();j++)
				System.out.print(result.get(i).get(j)+" ");
			System.out.println();
		}
	}
	
	
	//错了好多！！
	public static ArrayList<ArrayList<String>> getSub(ArrayList<String> list,int index){
		
		if(list.size()==index){
			ArrayList<ArrayList<String>> t =  new ArrayList<ArrayList<String>>();
			t.add(new ArrayList<String>());  //这一步非常重要！！
			return t;
		}		
		else{
			String temp = list.get(index);
			ArrayList<ArrayList<String>> newlist = getSub(list,index+1);
		
//			System.out.print(temp+" --"+newlist.toString());
			ArrayList<ArrayList<String>> morelist = new ArrayList<ArrayList<String>>();
			for(ArrayList<String> templist:newlist){
//				ArrayList<String> addlist = templist;
				ArrayList<String> addlist = new ArrayList<String>();
				addlist.addAll(templist);  //全部拷贝过来
				addlist.add(temp);
				morelist.add(addlist);//居然漏了这句话！！！去死吧！！！！！
			}
			newlist.addAll(morelist);
			
//			//java.util.ConcurrentModificationException异常，在循环里面不能对newlist进行改动啊白痴！！！
//			for(ArrayList<String> templist:newlist){
////				ArrayList<String> addlist = templist;
//				ArrayList<String> addlist = new ArrayList<String>();
//				addlist.addAll(templist);  //全部拷贝过来
//				addlist.add(temp);
//				newlist.add(addlist);
//			}
			return newlist;
		}
	}
	

}
 

