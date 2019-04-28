
public class Transform {
	private Stack stack; // ��׺���ʽת��Ϊ��׺���ʽ����Ҫ��ջ
	private String infix; // �������׺���ʽ
	private String postfix = ""; // �洢�õ��ĺ�׺���ʽ

	// ��ʼ��������
	public Transform(Stack stack, String infix) {
		this.stack = stack;
		this.infix = infix;
	}

	private String addBlank(String infix) {// �������ַ���һ���ո�
		String process = "";
		for (int i = 0; i < infix.length() - 1; i++) {
			char c1 = infix.charAt(i);
			char c2 = infix.charAt(i + 1);
			if (isDigital(c1) && isDigital(c2)) {
				process += c1;
			} else {
				process += c1 + " ";
			}
		}
		process += infix.charAt(infix.length() - 1);
		return process;
	}

	private static boolean isDigital(char c) {// �ж��Ƿ�Ϊ����
		if (c >= '0' && c <= '9')
			return true;
		else
			return false;
	}

	private void outStack() {// ����Ҫ����������ջ
		while (!stack.empty()) {
			String up = stack.out();
			if (up.equals("(")) {
				break;
			} else {
				postfix += " " + up;
			}
		}
	}

	private void inStack(String str, int seque) {// ��������ջ
		while (!stack.empty()) {
			String up = stack.out();
			int seque1 = order(up);
			if (up.equals("(")) {
				stack.in(up);
				break;
			} else {
				if (seque1 < seque) {
					stack.in(up);
					break;
				} else {
					postfix += " " + up;
				}
			}
		}
		stack.in(str);
	}

	private int order(String str) {// �Ƚϲ���˳��
		int n = 0;
		if (str.equals("+") || str.equals("-")) {
			n = 1;
		} else {
			n = 2;
		}
		return n;
	}

	public String getPost() {// return����Ϊ��׺���ʽ�Ľ��
		String str = addBlank(infix);
		String[] strs = str.split(" ");
		for (int i = 0; i < strs.length; i++) {// �����������ַֿ�
			if (strs[i].equals("+") || strs[i].equals("-")) {
				inStack(strs[i], 1);
			} else if (strs[i].equals("*") || strs[i].equals("/")) {
				inStack(strs[i], 2);
			} else if (strs[i].equals("(")) {
				stack.in(strs[i]);
			} else if (strs[i].equals(")")) {
				outStack();
			} else {
				postfix += " " + strs[i];
			}
		}
		while (!stack.empty()) {
			postfix += " " + stack.out();
		}
		return postfix.trim();
	}
}
