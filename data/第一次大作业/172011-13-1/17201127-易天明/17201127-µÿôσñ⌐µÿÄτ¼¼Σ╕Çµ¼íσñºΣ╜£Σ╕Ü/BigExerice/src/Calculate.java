import java.util.Stack;

public class Calculate {
	public Calculate() {
		
	}
	
	public static double calculate(String s) {
		// ���ַ����ָ�ո�ת��Ϊ�ַ�������
		String strings[] = s.split(" ");

		for (int i = 0; i < strings.length; i++) {
			// ȥ���ַ�����β�Ŀո�
			strings[i].trim();
		}
		// ����ջ��������
		Stack<Double> stack = new Stack<Double>();

		for (int i = 0; i < strings.length; i++) {
			// ��������֣����ջ
			if (!isOperateationalCharacter(strings[i])) {
				stack.push(Double.parseDouble(strings[i]));
			}
			// ��������������������������������
			else {
				double y = stack.pop();
				double x = stack.pop();
				stack.push(cal(x, y, strings[i])); // ������������ѹ��ջ��
			}
		}
		return stack.pop(); // ����ջ��Ԫ�ؾ����������ս����
	}

	public static double cal(double num1, double num2, String operationalCharacter) {
		switch (operationalCharacter) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			return num1 / num2;
		default:
			return 0;
		}
	}

	public static boolean isOperateationalCharacter(String str) {
		if (str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*"))
			return true;
		return false;
	}
}
