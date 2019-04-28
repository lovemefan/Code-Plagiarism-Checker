
public class Stack {// 数组实现栈
	private String[] str;// 定义一个栈
	private int up;// 栈顶

	public Stack(int num) {// 有参数构造栈
		str = new String[num];
		up = 0;
	}

	public Stack() {// 无参

	}

	public void in(String c) {// 入栈
		str[up] = c;
		up++;
	}

	public String out() {// 出栈
		up--;
		return str[up];
	}

	public boolean empty() {// 栈是否空
		return up == 0;
	}
}