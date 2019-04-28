package bighomework;

//ջ��
public class Stack {
	public Node stackTop;// ջ��
	public Node StackBottom;// ջ��

	public Stack(Node stackTop, Node stackBottom) {
		this.stackTop = stackTop;
		this.StackBottom = stackBottom;
	}

	public Stack() {

	}

	// ��ջ
	// value Ҫ��ջ��Ԫ��
	public void pushStack(Stack stack, String value) {
		// ��װ���ݳɽڵ�
		Node newNode = new Node(value);
		// ջ������ָ��Ľڵ㽻���½ڵ���ָ��
		newNode.next = stack.stackTop;
		// ջ��ָ��ָ���½ڵ�
		stack.stackTop = newNode;
	}

	// �жϸ�ջ�Ƿ�Ϊ��
	public static int isEmpty(Stack stack) {
		if (stack.StackBottom == stack.stackTop) {
			return 1;
		} else {
			return 0;
		}
	}

	// ��ջ
	public String popStack(Stack stack) {

		// ջ��Ϊ�ղ��ܳ�ջ
		String s = "";

		if (isEmpty(stack) != 1) {
			// ���ջ��Ԫ��
			s = s + stack.stackTop.data;
			// ջ��ָ��ָ����һ���ڵ�
			stack.stackTop = stackTop.next;

		}
		return s;
	}

	// ת���ַ�������һλ
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

	// �ַ����ľ���ת��
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

	// ջ�Ľ���
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

	// �������+��-
	public String addORslow(Stack stack, String s) {
		String s1 = "";
		if (isEmpty(stack) == 1) {// ���ջΪ�գ�ֱ����ջ
			String s2 = s;
			stack.pushStack(stack, s2);
		} else if (stack.stackTop.data.equals("(")) {
			String s2 = s;
			stack.pushStack(stack, s2);

		} else if (stack.stackTop.data.matches("[\\+\\-\\/\\*]")) {// ���ջ��Ϊ*��/���򵯳����ͷ�ջ��
			s1 = s1 + stack.popStack(stack);// stack.stackTop.data;
			String s2 = s;
			stack.pushStack(stack, s2);
		}
		return s1;
	}

	// ����*��/
	public String multORdivsion(Stack stack, String s) {
		String s2 = "";
		if (isEmpty(stack) == 1) {// ���ջΪ�գ�ֱ����ջ
			String s3 = s;
			stack.pushStack(stack, s3);
		} else if (stack.stackTop.data.matches("[\\*\\/]")) {// ���ջ��Ϊ*��/���򵯳����ͷ�ջ��

			String s3 = s;
			s2 = s2 + stack.popStack(stack);
			stack.pushStack(stack, s3);
		} else if (stack.stackTop.data.matches("[\\+\\-\\(]")) {
			String s3 = s;
			stack.pushStack(stack, s3);
		}
		return s2;
	}

	// ����������
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
