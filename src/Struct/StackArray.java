package Struct;

import java.util.Arrays;

/**
 * @Title: StackArray.java
 * @Package Struct
 * @Description: TODO
 * @author nutc
 * @date 2013-7-13 上午10:33:59
 * @version V1.0
 */
public class StackArray<E> {

	private int DEFAULT = 100;
	private int size;
	private Object[] array; // 不用E[]!

	// add
	private int capacity;
	private int top; // 用top 不直接用size来操作下标=，=

	public StackArray() {
		size = 0;
		array = new Object[DEFAULT];
	}

	public StackArray(int capacity) {
		size = 0;
		array = new Object[capacity];
	}

	public E push(E value) {
		if (size <= array.length) { // 是length而不是size
			array[size] = value;
			size++;
		} else {
			enlarge();
			push(value);
		}
		return value;
	}

	private void enlarge() {
		Object[] newarray = new Object[array.length * 3 / 2];
		// 如何复制？
		System.arraycopy(array, 0, newarray, 0, array.length);
		Arrays.fill(array, null); // 不用的东西及时释放啊！！！学习！！！
		array = newarray;

		// array = Arrays.copyOf(array, array.length*3/2); //方法2
	}

	public E pop() {
		if (size == 0)
			return null;
		else {
			array[size] = null; // 及时释放空间啊亲！！！！！！
			return (E) array[--size];
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

}
