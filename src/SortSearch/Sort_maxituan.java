//package SortSearch;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
///**
// * @Title: Sort_��Ϸ������.java
// * @Package SortSearch
// * @Description: TODO
// * @author nutc
// * @date 2013-8-6 ����2:08:10
// * @version V1.0
// */
//public class Sort_maxituan {
//	static weightComparator wc = new weightComparator();
//	static int i = new Integer(9);
//
//	public static void sort(ArrayList<Person> persons) {
//		Collections.sort(persons, wc);                  
//
//	}
//
//	class Person {
//		int weight;
//		int height;
//
//		Person(int weight, int height) {
//			this.weight = weight;
//			this.height = height;
//		}
//	}
//
//	public class weightComparator implements Comparator<Person> { // ���������interface������
//
//		public int compare(Person p1, Person p2) {
//			return p1.weight - p2.weight;
//		}
//	}
//
//}
