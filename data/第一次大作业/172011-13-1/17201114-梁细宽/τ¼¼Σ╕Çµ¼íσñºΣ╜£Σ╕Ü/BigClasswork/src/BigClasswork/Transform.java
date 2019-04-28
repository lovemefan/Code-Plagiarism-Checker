package BigClasswork;

public class Transform {
	private String input;
	private String output = "";
	private Stack stack;

	public Transform(String input, Stack stack) {
		this.input = input;
		this.stack = stack;
	}

	public String getOutput() {
		return output.trim();
	}

	// ���ļ�����ȷ��ȡ�ı��ʽ���Ͽո�
	public String addBlank(String input) {
		String result = "";

		for (int i = 0; i < input.length() - 1; i++) {
			char ch1 = input.charAt(i);
			char ch2 = input.charAt(i + 1);

			if (ch1 >= '0' && ch1 <= '9' && ch2 >= '0' && ch2 <= '9') {// ���������������򲻼ӿո����ӿո�
				result += ch1;
			} else {
				result += ch1 + " ";
			}
		}
		result += input.charAt(input.length() - 1);// �����ʽ��ʣ����ַ�����
		return result;

	}

	public void transform() {
		String[] string = addBlank(input).split(" ");// �Կո�Ϊ�۵㽫���ֺ��ַ��ֿ���������

		for (int i = 0; i < string.length; i++) {
			String str = string[i];

			switch (str) {
			case "(":
				stack.PushStack(str);
				break;
			case ")":
				parent();
				break;
			case "+":
			case "-":
				operate(str, 1);
				break;
			case "*":
			case "/":
				operate(str, 2);
				break;
			default:
				output += " " + str;
				break;
			}
		}
		// ����ȫ���������Ҫ���ջ��ʣ��ķ���
		while (!stack.isEmpty()) {
			output += " " + stack.PopStack();
		}

	}

	// ����¸��ַ���+-*/����д˲���
	public void operate(String str, int pri1) {

		while (!stack.isEmpty()) {
			String top = stack.PopStack();

			if (top.equals("(")) {
				stack.PushStack(top);
				break;
			} else {
				int pri2 = 0;

				if (top.equals("+") || top.equals("-")) {
					pri2 = 1;
				} else {
					pri2 = 2;
				}

				if (pri2 < pri1) {
					stack.PushStack(top);// ���ջ��Ԫ�ص����ȼ�С��Ҫ����ջ��Ԫ�ص����ȼ��ͽ�top�Ż�ջ��
					break;
				} else {
					output += " " + top;// ���ջ��Ԫ�����ȼ������丳��output
				}
			}
		}
		stack.PushStack(str);// ���ջΪ����ֱ�ӽ�������ջ

	}

	// ����¸��ַ��ǣ���ǰ�棨��������ȫ�����������׺���ʽ
	public void parent() {
		while (!stack.isEmpty()) {
			String top = stack.PopStack();

			if (top.equals("(")) {
				break;
			} else {

				output += " " + top;
			}
		}
	}

}
