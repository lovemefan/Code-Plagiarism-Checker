import java.util.Stack;
import java.util.regex.Pattern;

// ����׺���ʽ�ַ���ת��Ϊ��׺���ʽ 
public class StringToArithmetic {

	public StringToArithmetic() {
	}

	// ����׺���ʽ�ַ�������õ����
	public static double stringToArithmetic(String string) {
		return suffixToArithmetic(infixToSuffix(string));
	}

	// ����׺���ʽת��Ϊ��׺���ʽ
	public static String infixToSuffix(String exp) {
		// ������������ջ
		Stack<Character> s = new Stack<Character>();
		String suffix = "";
		int length = exp.length(); // �������׺���ʽ�ĳ���
		for (int i = 0; i < length; i++) {
			char temp;
			// ��ȡ����׺���ʽ��ÿһ���ַ��������ж�
			char ch = exp.charAt(i);
			switch (ch) {
			// ���Կո�
			case ' ':
				break;
			// �����������ֱ��ѹ���ջ
			case '(':
				s.push(ch);
				break;

			// ����'+' '-'����ջ�е����������ȫ������ȥ��ֱ������������Ϊֹ�������������ȥ
			case '+':
			case '-':
				while (s.size() != 0) {
					temp = s.pop();
					if (temp == '(') {
						// ���½������ŷŻض�ջ����ֹѭ��
						s.push('(');
						break;
					}
					suffix += " " + temp;
				}
				s.push(ch);
				break;

			// ����ǳ˺Ż��߳��ţ��򵯳��������У�ֱ�������Ӻá����š�������Ϊֹ����󽫸ò�����ѹ���ջ
			case '*':
			case '/':
				while (s.size() != 0) {
					temp = s.pop();
					// ֻ�бȵ�ǰ���ȼ��ߵĻ�����ȵĲŻᵯ����������У������Ӽ������ţ�ֱ��ֹͣ��ǰѭ��
					if (temp == '+' || temp == '-' || temp == '(') {
						s.push(temp);
						break;
					} else {
						suffix += " " + temp;
					}
				}
				s.push(ch);
				break;

			// ����������������ţ������ջ���ĵ�һ��������������������������ջ������������
			case ')':
				while ((temp = s.pop()) != '(') {
					suffix += " " + temp;
				}
				while (!s.isEmpty()) {
					temp = s.pop();
					if (temp == '(') {
						break;
					} else {
						suffix += " " + temp;
					}
				}
				break;
			//�����ȡ���������֣���ֱ�������������
			default:
				suffix += " " + ch;
				break;
			}

		}
		// �����ջ��Ϊ�գ����ʣ�������һ�ε����������������
		while (s.size() != 0) {
			suffix += " " + s.pop();
		}
		return suffix;
	}

	public static double suffixToArithmetic(String exp) {
		// ʹ��������ʽƥ������
		Pattern pattern = Pattern.compile("\\d+||(\\d+\\.\\d+)");
		// ����׺���ʽ�ָ���ַ�������,�˴�ֱ��ʹ�ÿհ�Ҳ���Զ��ַ������зָ�
		String[] strings = exp.split(" ");
		Stack<Double> stack = new Stack<Double>();
		for (int i = 1; i < strings.length; i++) {
			if (strings[i].equals(" ")) {
				continue;
			}
			// ���������������ֱ�ӽ�ջ
			if (pattern.matcher(strings[i]).matches()) {
				stack.push(Double.parseDouble(strings[i]));
			}
			// �������������򵯳�ջ�������������м���
			else {
				double y = stack.pop();
				double x = stack.pop();
				// ������������ѹջ
				stack.push(calculate(x, y, strings[i]));
			}
		}
		// ����ջ��Ԫ�ؾ������ս��
		return stack.pop();
	}

	private static Double calculate(double x, double y, String string) {
		if (string.trim().equals("+")) {
			return x + y;
		}
		if (string.trim().equals("-")) {
			return x - y;
		}
		if (string.trim().equals("*")) {
			return x * y;
		}
		if (string.trim().equals("/")) {
			return x / y;
		}
		return (double) 0;
	}
}