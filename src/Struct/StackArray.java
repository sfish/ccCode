package Struct;

import java.util.Arrays;

/**
 * @Title: StackArray.java
 * @Package Struct
 * @Description: TODO
 * @author nutc
 * @date 2013-7-13 ����10:33:59
 * @version V1.0
 */
public class StackArray<E> {

	private int DEFAULT = 100;
	private int size;
	private Object[] array; // ����E[]!

	// add
	private int capacity;
	private int top; // ��top ��ֱ����size�������±�=��=

	public StackArray() {
		size = 0;
		array = new Object[DEFAULT];
	}

	public StackArray(int capacity) {
		size = 0;
		array = new Object[capacity];
	}

	public E push(E value) {
		if (size <= array.length) { // ��length������size
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
		// ��θ��ƣ�
		System.arraycopy(array, 0, newarray, 0, array.length);
		Arrays.fill(array, null); // ���õĶ�����ʱ�ͷŰ�������ѧϰ������
		array = newarray;

		// array = Arrays.copyOf(array, array.length*3/2); //����2
	}

	public E pop() {
		if (size == 0)
			return null;
		else {
			array[size] = null; // ��ʱ�ͷſռ䰡�ף�����������
			return (E) array[--size];
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

}
