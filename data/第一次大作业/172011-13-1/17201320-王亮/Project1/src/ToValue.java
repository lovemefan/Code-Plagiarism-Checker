//�ɺ�׺���ʽ����������
public class ToValue {
	private String postfix; // ��׺���ʽת���õ��ĺ�׺���ʽ
	private LinkedStack<Double> stack; // ���ڵõ���������ջ

	public ToValue(String postfix, LinkedStack<Double> stack) {// ���캯��
		this.postfix = postfix;
		this.stack = stack;
	}

	public double process() {// �������
		int i = 0;
		double result = 0;
		while (i < postfix.length()) {
			char ch = postfix.charAt(i);
			if (ch >= '0' && ch <= '9') {// ���ch������
				result = 0;
				while (ch != ' ') {// �����ո񼴶���һ������ ����
					result = result * 10 + Double.parseDouble(ch + "");// ���ַ�ת��Ϊ����
					i++;
					ch = postfix.charAt(i);
				}
				i++;
				stack.push(new Double(result));// ��������ջ
			} else {
				double y = stack.pop().doubleValue();// ȡջ��Ԫ��
				if (stack.get() == null) {// ���ǵ����ʽ������"(-1)"�����ջ�л���һ�������
					result = y;
					return result;
				}
				double x = stack.pop().doubleValue();// ȡջ��Ԫ��
				switch (ch) {
				case '+':
					result = x + y;// �����+�����
					break;
				case '-':
					result = x - y;// �����-�����
					break;
				case '*':
					result = x * y;// �����*�����
					break;
				case '/':
					result = x / y;// �����/�����
					break;
				}
				stack.push(new Double(result));// �������ջ
				i++;
			}

		}
		result = stack.pop().doubleValue();// �����Ľ����ջ
		return result;
	}
}
