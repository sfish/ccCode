package SortSearch;

/**
 * @Title: SearchString_withBlank.java
 * @Package SortSearch
 * @Description: Given a sorted array of strings which is interspersed with
 *               empty strings, write a meth- od to find the location of a given
 *               string Example: find ��ball�� in [��at��, ����, ����, ����, ��ball��, ����,
 *               ����, ��car��, ����, ����, ��dad��, ����, ����] will return 4 Example: find
 *               ��ballcar�� in [��at��, ����, ����, ����, ����, ��ball��, ��car��, ����, ����,
 *               ��dad��, ����, ����] will return -1
 * @author nutc
 * @date 2013-8-6 ����10:42:20
 * @version V1.0
 */
// ���ǲ��� length�Ļ�Ҫ��һ�ˣ���
// �ܿ�˼ά���������ܰ���������
// ��©û���ǵ� Ҫ��ѯ���ǡ��������
// �ַ�������ֱ�ӱȽ�,Ҫ��compareTo���ǵ÷���������ĺ��尡�׳գ�
public class SearchString_withBlank {

	public static void main(String args[]) {
		String[] a = new String[] { "at", "", "", "", "ball", "", "", "car",
				"", "", "dad", "", "" };

		System.out.print(search(a, ""));
	}

	public static int search(String a[], String v) {
		if (a == null || v == null)
			return -1;
		if (v.equals("")) {
			for (int i = 0; i < a.length; i++) {
				if (a[i].equals(""))
					return i;
			}
			return -1;
		} else
			return Find(a, 0, a.length - 1, v);
	}

	public static int Find(String a[], int f, int l, String v) {
		System.out.println(f + " " + l);
		if (f >= 0 && f < a.length && l >= 0 && l < a.length && f <= l) {
			while (a[f].equals("")) {
				f++;
			}
			while (a[l].equals("")) {
				l--;
			}
			if (f <= l) {
				int mid = (f + l) >> 1;
				while (a[mid].equals("")) {
					mid++;
				}
				System.out.println("mid==" + mid);
				if (a[mid].equals(v))
					return mid;
				else if (a[mid].compareTo(v) > 0) // ����ֱ����< > ��
					return Find(a, f, mid - 1, v);
				else
					return Find(a, mid + 1, l, v);

			}
		}
		return -1;
	}
}
