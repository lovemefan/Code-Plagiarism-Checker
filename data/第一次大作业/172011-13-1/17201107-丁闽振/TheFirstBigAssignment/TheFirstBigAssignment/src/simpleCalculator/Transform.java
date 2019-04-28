package simpleCalculator;

public class Transform {
	private String post = "";//�����洢���ʽ�ͼ�����
	private Stack stack;
	private String infix;
//���캯��
	public Transform(Stack stack, String infix) {
		this.stack = stack;
		this.infix = infix;
	}
//����ʽ���ÿ���ַ������һ���ո�
	private String addspace(String infix) {
		String result = "";
		for (int i = 0; i < infix.length() - 1; i++) {
			char temp1 = infix.charAt(i);
			char temp2 = infix.charAt(i + 1);
			if (isDigital(temp1) && isDigital(temp2)) {
				result += temp1;
			} else {
				result += temp1 + " ";
			}
		}
		result += infix.charAt(infix.length() - 1);
		return result;
	}
//�ж��ַ��ǲ�������
	private boolean isDigital(char ch) {
		if (ch >= '0' && ch <= '9')
			return true;
		else
			return false;
	}
//����׺���ʽת���ɺ�׺���ʽ
	public void process() {
		String[] str1 = addspace(infix).split(" ");
		for (int i = 0; i < str1.length; i++) {
			String str2 = str1[i];
			switch (str2) {
			case "+":
			case "-":
				Operation1(str2, 1);
				break;
			case "*":
			case "/":
				Operation1(str2, 2);
				break;
			case "(":
				stack.push(str2);
				break;
			case ")":
				Operation2();
				break;
			default:
				post += " " + str2;
				break;
			}
		}
		while (!stack.empty()) {
			post += " " + stack.pop();
		}
	}
//�����洢+-*/
	private void Operation1(String str, int operation) {
		while (!stack.empty()) {
			String top1 = stack.pop();
			if (top1.equals("(")) {
				stack.push(top1);
				break;
			} else {
				int top2 = getPriority(top1);
				if (top2 < operation) {
					stack.push(top1);
					break;
				} else {
					post += " " + top1;
				}
			}
		}
		stack.push(str);
	}
//�����洢()
	private void Operation2() {
		while (!stack.empty()) {
			String top = stack.pop();
			if (top.equals("(")) {
				break;
			} else {
				post += " " + top;
			}
		}
	}
//��������+-��*/����
	private int getPriority(String str) {
		int temp = 0;
		if (str.equals("+") || str.equals("-")) {
			temp = 1;
		} else {
			temp = 2;
		}
		return temp;
	}
//���غ�׺���ʽ
	public String getPost() {
		return post.trim();
	}
}
