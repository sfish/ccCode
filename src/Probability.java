import java.util.HashMap;

/**
 * @Title: Probility.java
 * @Package
 * @Description: һ��С������ʾΪһ��N��N�ķ��񣬴�(0,0)��(N-1, N-1)��һ����վ��λ��(x, y)���������������ߣ�һ��һ���ӣ�ѡ���������ҵĿ�������һ���ġ������߳�С��������ζ��������������Ҫ��n�������������ĸ����ж����д������
 * @author nutc
 * @date 2013-8-8 ����1:11:13
 * @version V1.0
 */
public class Probability {

	public static void main(String agrs[]) {

		HashMap<String, Double> map = new HashMap<String, Double>();
		System.out.print(getPro(3, 1, 1, 2, map) + " ");
	}

	public static Double getPro(int n, int x, int y, int step,
			HashMap<String, Double> map) {

		assert (n > 0 && step > 0);  //��������Ĵ���

		if (x < 0 || x >= n || y < 0 || y >= n)
			return 1.0; // ����ֱ��д1��
		if (step == 0)
			return 0.0;

		String key = x + "-" + y + "-" + step;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		Double pro = 0.0;
		pro += 0.25 * getPro(n, x - 1, y, step - 1, map);
		pro += 0.25 * getPro(n, x + 1, y, step - 1, map);
		pro += 0.25 * getPro(n, x, y - 1, step - 1, map);
		pro += 0.25 * getPro(n, x, y + 1, step - 1, map);

		map.put(key, pro);
		return pro;

	}
}
