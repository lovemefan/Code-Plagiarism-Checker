package FourOperation;

import java.util.ArrayList;
/**
 * 一个简单的堆栈类
 */
public class Stack {
	//创建列表用于存储栈中数据
	private ArrayList<Object> list = new ArrayList<>();
	/**
	 * 无参构造函数
	 */
	Stack(){}
	
	/**
	 * 确认栈是否为空
	 * @return boolean
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	/**
	 * 获取栈长度
	 * @return i
	 */
	public int getSize() {
		return list.size();
	}
	/**
	 * 获取栈顶元素而不删除它，列表末尾的元素作为栈顶元素
	 * @return Object
	 */
	public Object peek() {
		return list.get(getSize() - 1);
	}
	/**
	 * 删除栈顶元素并返回该元素
	 * @return Object
	 */
	public Object pop() {
		Object o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}
	/**
	 * 将指定元素添加到栈中
	 * @param o
	 */
	public void push(Object o) {
		list.add(o);
	}
	/**
	 * 用于显示栈中内容
	 */
	public String toString() {
		return "stack: " + list.toString();
	}
}
