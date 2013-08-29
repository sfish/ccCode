package Struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Union_Find_Set {

	/**
��Ŀ������һ���ַ����ļ��ϣ���ʽ�磺{aaa bbb ccc}�� {bbb ddd}��{eee fff}��{ggg}��{ddd hhh}Ҫ�����н�����Ϊ�յļ��Ϻϲ���
Ҫ��ϲ���ɺ�ļ���֮���޽�������������Ӧ���{aaa bbb ccc ddd hhh}��{eee fff}�� {ggg}��
��1��������������������˼·��
��2���������Ҫ�Ĵ������̣��㷨���Լ��㷨�ĸ��Ӷ�
��3�����������ܵĸĽ���
���
1. �ٶ�ÿ�����ϱ��Ϊ0��1��2��3...
2. ����һ��hash_map��keyΪ�ַ�����valueΪһ����������ڵ�Ϊ�ַ������ڼ��ϵı�š��������еļ��ϣ����ַ����Ͷ�Ӧ�ļ��ϱ�Ų��뵽hash_map��ȥ��
3. ����һ�����ȵ��ڼ��ϸ�����int���飬��ʾ���ϼ�ĺϲ���ϵ�����磬�±�Ϊ5��Ԫ��ֵΪ3����ʾ���±�Ϊ5�ļ��Ϻϲ����±�Ϊ3�ļ�����ȥ����ʼʱ������ֵ����ʼ��Ϊ-1��
��ʾ���ϼ�û�л���ϲ����ڼ��Ϻϲ��Ĺ����У����ǽ����е��ַ������ϲ�����Ž�С�ļ�����ȥ��
    �����ڶ��������ɵ�hash_map������ÿ��value�е����������ҵ���С�ļ��ϱ�ţ���Щ�����Ѿ����ϲ�������Ҫ˳�źϲ���ϵ�����ҵ��ϲ���ļ��ϱ�ţ���
    Ȼ�����������б�ŵļ��϶��ϲ��������С�ļ����У�ͨ�����ĺϲ���ϵ���飩��
4.���ںϲ���ϵ������ֵΪ-1�ļ��ϼ�Ϊ���յļ��ϣ�����Ԫ����Դ������ֱ�ӻ���ָ�����ļ��ϡ�
0: {aaa bbb ccc}
1: {bbb ddd}
2: {eee fff}
3: {ggg}
4: {ddd hhh}
���ɵ�hash_map���ʹ�����ÿ��ֵ��ĺϲ���ϵ����ֱ�Ϊ
aaa: 0          [-1, -1, -1, -1, -1]
bbb: 0, 1       [-1, 0, -1, -1, -1]
ccc: 0          [-1, 0, -1, -1, -1]
ddd: 1, 4       [-1, 0, -1, -1, 0]
eee: 2          [-1, 0, -1, -1, 0]
fff: 2          [-1, 0, -1, -1, 0]
ggg: 3          [-1, 0, -1, -1, 0]
hhh: 4          [-1, 0, -1, -1, 0]
���Ժϲ�������������ϣ���0��1��4�����Ϻϲ�����һ��
��2��3������û�н��кϲ���
Use "Disjoin-set".But I use "HashSet" and "HashMap" of Java API.Does "Disjoin-set" have its own data structure?
see also [url]http://www.csie.ntnu.edu.tw/~u91029/DisjointSets.html[/url]
	 */
	private final int SIZE=7;
	private int[] father;//the root in disjion set.
	private static List<Set<String>> resultList=new ArrayList<Set<String>>();
	
	public static void main(String[] args) {
		String[] str0={
				"aaa",
				"bbb",
				"ccc",};
		String[] str1={
				"bbb",
				"ddd",};
		String[] str2={
				"eee",
				"fff",};
		String[] str3={
				"ggg",};
		String[] str4={
				"ddd",
				"hhh",};
		String[] str5={
				"xx",
				"yy",};
		String[] str6={
				"zz",
				"yy",};
		String[][] strs={str0,str1,str2,str3,str4,str5,str6};
		//change String[][] to List<Set>
		for(String[] str:strs){
			//when I write--"Arraylist list=Arrays.asList(strArray)","addAll()" is unsupported for such a arraylist.
			Set<String> set=new HashSet<String>();
			set.addAll(Arrays.asList(str));
			resultList.add(set);
		}
		Union_Find_Set disjointSet=new Union_Find_Set();
		disjointSet.disjoin(strs);
	}
	
	public void disjoin(String[][] strings){
		if(strings==null||strings.length<2)return;
		initial();
		Map<String,List<Integer>> map=storeInHashMap(strings);
		union(map);
	}
	
	//in the beginning,each element is in its own "group".
	public void initial(){
		father=new int[SIZE];
		for(int i=0;i<SIZE;i++){
			father[i]=i;
		}
	}
	
	/*Map<k,v>
	 * key:String
	 * value:List<Integer>-in which sets the string shows up.
	 */
	public Map<String,List<Integer>> storeInHashMap(String[][] strings){
		Map<String,List<Integer>> map=new HashMap<String,List<Integer>>();
		for(int i=0;i<SIZE;i++){
			for(String each:strings[i]){
				if(!map.containsKey(each)){
					List<Integer> list=new ArrayList<Integer>();
					list.add(i);
					map.put(each, list);
				}else{
					map.get(each).add(i);
				}
			}
		}
		//traverse the hashmap
		Iterator<Map.Entry<String, List<Integer>>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, List<Integer>> entry=it.next();
			String key=entry.getKey();
			List<Integer> value=entry.getValue();
			System.out.println(key+":"+value);
			
		}
		return map;
	}
	
	public void union(Map<String,List<Integer>> map){
		Iterator<Map.Entry<String, List<Integer>>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, List<Integer>> entry=it.next();
			List<Integer> value=entry.getValue();
			unionHelp(value);//the arrays whose indexes are in the same list should be merged to one set.
		}
		System.out.println("the father array is "+Arrays.toString(father));
		//merge two sets
		for(int i=0;i<SIZE;i++){
			if(i!=father[i]){
				Set<String> dest=resultList.get(father[i]);
				Set<String> source=resultList.get(i);
				dest.addAll(source);
			}
		}
		//clear a set which has been added.
		for(int i=0;i<SIZE;i++){
			if(i!=father[i]){
				resultList.get(i).clear();
			}
		}
		System.out.println("after merge:"+resultList);
	}
	
	public void unionHelp(List<Integer> list){
		int minFather=getFather(list.get(0));//list[0] is the smaller.
		for(int i=0,size=list.size();i<size;i++){
			father[list.get(i)]=minFather;
		}
	}
	
	//general union in disjoin set.But we overload it in this case.
	public void unionHelp(int x,int y){
		if(father[x]!=father[y]){
			int fx=getFather(x);
			int fy=getFather(y);
			//merge two arrays to the array that has a smaller index.
			if(fx<fy){
				father[y]=fx;
			}else{
				father[x]=fy;
			}
			
		}
	}
	
	public int getFather(int x){
		while(x!=father[x]){
			x=father[x];
		}
		return x;
	}
	
}

