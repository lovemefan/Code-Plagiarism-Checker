package simpleCalculator;

public class GetResult {
	private String temp; // ��׺���ʽת���õ��ĺ�׺���ʽ
	private StackInt stack; // ���ڵõ���������ջ

	public GetResult() {

	}
	//���캯��
	public GetResult(String post, StackInt stack) {
		this.temp = post;
		this.stack = stack;
	}

	public void operation() {
		String[] str = temp.split(" ");
		for (int i = 0; i < str.length; i++) {
			String temp1 = str[i];
			if (isDigital(temp1)) {
				stack.push(Integer.valueOf(temp1));
			} else {
				int result = compute(temp1);
				stack.push(result);
			}
		}
	}
	//������ʽ�Ľ��
	private int compute(String str) {
		int result = 0;
		int p = stack.pop();
		int q = stack.pop();
		switch (str) {
		case "+":
			result = q + p;
			break;
		case "-":
			result = q - p;
			break;
		case "*":
			result = q * p;
			break;
		case "/":
			result = q / p;
			break;
		default:
			break;
		}
		return result;
	}
	//�ж��ǲ�������
	private boolean isDigital(String str) {
		char[] ch = str.toCharArray();
		int sum = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= '0' && ch[i] <= '9')
				sum++;
		}
		return sum == ch.length;
	}

	public int getResult() {
		return stack.pop();
	}

}
