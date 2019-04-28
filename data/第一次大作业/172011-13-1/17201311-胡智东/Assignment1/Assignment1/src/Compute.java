
public class Compute {
	String post; // ��׺���ʽת���õ��ĺ�׺���ʽ
	Stack stack = new Stack();// ���ڵõ���������ջ
	// ���췽��

	public Compute(String post) {
		this.post = post;
	}

	// ����׺���ʽ������������Ĳ���
	public void operate() {
		String[] strArr = post.split(" ");
		for (int i = 0; i < strArr.length; i++) {
			String temp = strArr[i];
			if (isDigital(temp)) {
				stack.push((temp));
			} else {
				double result = compute(temp);
				stack.push(String.valueOf(result));
			}
		}
	}

	// �Ӽ��˳���ʵ��
	public Double compute(String str) {
		double result = 0;
		Double m = Double.valueOf(stack.pop());
		Double n = Double.valueOf(stack.pop());
		switch (str) {
		case "+":
			result = n + m;
			break;
		case "-":
			result = n - m;
			break;
		case "*":
			result = n * m;
			break;
		case "/":
			result = n / m;
			break;
		default:
			break;
		}
		return result;
	}

	// �ж��Ƿ�Ϊ����
	public boolean isDigital(String str) {
		char[] chArr = str.toCharArray();
		int len = chArr.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (chArr[i] >= '0' && chArr[i] <= '9')
				count++;
		}
		return count == len;
	}

	// ����ĵ�ȡ
	public double getResult() {
		double res = Double.valueOf(stack.pop());
		return res;
	}

}
