import java.util.HashMap;

/**
 * @Title: Probility.java
 * @Package
 * @Description: 一个小岛，表示为一个N×N的方格，从(0,0)到(N-1, N-1)，一个人站在位置(x, y)，可以上下左右走，一步一格子，选择上下左右的可能性是一样的。当他走出小岛，就意味着死亡。假设他要走n步，请问死亡的概率有多大？请写出代码
 * @author nutc
 * @date 2013-8-8 下午1:11:13
 * @version V1.0
 */
public class Probability {

	public static void main(String agrs[]) {

		HashMap<String, Double> map = new HashMap<String, Double>();
		System.out.print(getPro(3, 1, 1, 2, map) + " ");
	}

	public static Double getPro(int n, int x, int y, int step,
			HashMap<String, Double> map) {

		assert (n > 0 && step > 0);  //错误输入的处理

		if (x < 0 || x >= n || y < 0 || y >= n)
			return 1.0; // 不能直接写1！
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
