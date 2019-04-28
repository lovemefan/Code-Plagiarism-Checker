package bighomework;

//栈类
public class Stack {
	public Node stackTop;// 栈顶
	public Node StackBottom;// 栈底

	public Stack(Node stackTop, Node stackBottom) {
		this.stackTop = stackTop;
		this.StackBottom = stackBottom;
	}

	public Stack() {

	}

	// 进栈
	// value 要进栈的元素
	public void pushStack(Stack stack, String value) {
		// 封装数据成节点
		Node newNode = new Node(value);
		// 栈顶本来指向的节点交由新节点来指向
		newNode.next = stack.stackTop;
		// 栈顶指针指向新节点
		stack.stackTop = newNode;
	}

	// 判断该栈是否为空
	public static int isEmpty(Stack stack) {
		if (stack.StackBottom == stack.stackTop) {
			return 1;
		} else {
			return 0;
		}
	}

	// 出栈
	public String popStack(Stack stack) {

		// 栈不为空才能出栈
		String s = "";

		if (isEmpty(stack) != 1) {
			// 提出栈顶元素
			s = s + stack.stackTop.data;
			// 栈顶指针指向下一个节点
			stack.stackTop = stackTop.next;

		}
		return s;
	}

	// 转换字符串的这一位
	public String thisChange(Stack stack, String s) {
		String s1 = "";
		if (s.matches("[\\d]")) {
			s1 = s1 + s + " ";
		} else if (s.matches("[\\+\\-]")) {
			s1 = s1 + addORslow(stack, s) + " ";
		} else if (s.matches("[\\*\\/]")) {
			s1 = s1 + multORdivsion(stack, s) + " ";
		} else if (s.matches("[\\(]")) {
			stack.pushStack(stack, "(");
		} else if (s.matches("[\\)]")) {
			s1 = s1 + rightBracket(stack, s);
		}
		return s1;
	}

	// 字符串的具体转换
	public String changeStack(Stack stack, String s) {
		String[] splited = s.split(" ");
		int m = splited.length;
		String s1 = "";
		for (int i = 0; i < m; i++) {
			if (splited[i].matches("[\\d]{10}")) {
				s1 = s1 + splited[i] + " ";
				i++;
			} else {
				s1 = s1 + thisChange(stack, splited[i]);
			}
		}

		return s1;
	}

	// 栈的进行
	public String startStack(String s) {
		Stack stack = new Stack();
		String s1 = "";
		s1 = s1 + changeStack(stack, s);
		while (stack.StackBottom != stack.stackTop) {
			if (!stack.stackTop.data.equals("(")) {
				s1 = s1 + stack.stackTop.data + " ";
				stack.stackTop = stack.stackTop.next;
			} else {
				stack.popStack(stack);
			}
		}
		return s1;
	}

	// 如果遇到+或-
	public String addORslow(Stack stack, String s) {
		String s1 = "";
		if (isEmpty(stack) == 1) {// 如果栈为空，直接入栈
			String s2 = s;
			stack.pushStack(stack, s2);
		} else if (stack.stackTop.data.equals("(")) {
			String s2 = s;
			stack.pushStack(stack, s2);

		} else if (stack.stackTop.data.matches("[\\+\\-\\/\\*]")) {// 如果栈顶为*或/，则弹出并释放栈顶
			s1 = s1 + stack.popStack(stack);// stack.stackTop.data;
			String s2 = s;
			stack.pushStack(stack, s2);
		}
		return s1;
	}

	// 遇到*或/
	public String multORdivsion(Stack stack, String s) {
		String s2 = "";
		if (isEmpty(stack) == 1) {// 如果栈为空，直接入栈
			String s3 = s;
			stack.pushStack(stack, s3);
		} else if (stack.stackTop.data.matches("[\\*\\/]")) {// 如果栈顶为*或/，则弹出并释放栈顶

			String s3 = s;
			s2 = s2 + stack.popStack(stack);
			stack.pushStack(stack, s3);
		} else if (stack.stackTop.data.matches("[\\+\\-\\(]")) {
			String s3 = s;
			stack.pushStack(stack, s3);
		}
		return s2;
	}

	// 遇到“）”
	public String rightBracket(Stack stack, String s) {
		String s3 = "";
		while (isEmpty(stack) != 1) {
			if (!stack.stackTop.data.equals("(")) {
				s3 = s3 + stack.popStack(stack) + " ";
			} else {
				stack.popStack(stack);
			}
		}
		return s3;
	}
}
