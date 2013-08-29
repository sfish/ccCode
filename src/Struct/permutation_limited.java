package Struct;

/** 
 * @Title: permutation_limited.java   �����뵽����������
 * @Package Struct 
 * @Description: 2. �Ե�һ�������Ѷȣ���1��2��2��3��4��5���������֣���javaдһ��main������
 * ��ӡ�����в�ͬ�����У��磺512234��412345�ȣ�Ҫ��"4"�����ڵ���λ��"3"��"5"���������� 

 ����˼·�� 
 2-1. ��������������Ϊͼ�ṹ�ı������⡣ͼ����˼�룺ʵ����6�����־���������㣬������������ӳ�������ͨͼ��
 ����ÿһ����������ͼ�εı���·�������н��ı���·������������6�����ֵ�������Ͻ������ ������

 2-2. ��Ȼ����������δ�ﵽ��Ŀ��Ҫ�󡣴����¼������濼�ǣ�                                                 

 2-2-1.   3��5����������ʵ��Ҫ�������ͨͼ�Ľ��3��5֮�䲻����ͨ, ���ڹ���ͼ�ṹʱ�������������
 Ȼ���ٱ���ͼ�� 
 2-2-2.   �������ظ�: ���������ǵ�������2�����Ի�����ظ���������԰ѽ��������TreeSet�й����ظ���������� 
 2-2-3.   4�����ڵ���λ: �Ծ��ڽ������ȥ������������Ľ���� 
 * @author nutc
 * @date 2013-7-14 ����11:06:43 
 * @version V1.0 
 */
import java.util.Iterator;
import java.util.TreeSet;

public class permutation_limited {

	private String[] b = new String[] { "1", "2", "2", "3", "4", "5" };
	private int n = b.length;
	int count = 0;
	private boolean[] visited = new boolean[n];
	private int[][] a = new int[n][n];
	private String result = "";
	private TreeSet set = new TreeSet();

	public static void main(String[] args) {
		new permutation_limited().start();
	}

	private void start() {

		// Initial the map a[][]
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					a[i][j] = 0;  //ȥ���Լ��ִ��Լ�
				} else {
					a[i][j] = 1;
				}
			}
		}

		// 3 and 5 can not be the neighbor.
		a[3][5] = 0;
		a[5][3] = 0;

		// Begin to depth��search.
		for (int i = 0; i < n; i++) {
			this.depthFirstSearch(i);
		}

		// Print result treeset.
		Iterator it = set.iterator();
		System.out.print("count==="+set.size()+"  "+count);
		while (it.hasNext()) {
			String string = (String) it.next();
			// "4" can not be the third position.
//			if (string.indexOf("4") != 2) {
				System.out.println(string);
//			}
		}
	}
	private void depthFirstSearch(int startIndex) {
		visited[startIndex] = true;
		result = result + b[startIndex];
		if (result.length() == n && result.indexOf("4")!=2) {
			// Filt the duplicate value.
			count++;
			set.add(result);
		}
		for (int j = 0; j < n; j++) {
			if (a[startIndex][j] == 1 && visited[j] == false) {
				depthFirstSearch(j);
			} else {
				continue;
			}
		}

		// restore the result value and visited value after listing a node.
		result = result.substring(0, result.length() - 1);
		visited[startIndex] = false;
	}
}
