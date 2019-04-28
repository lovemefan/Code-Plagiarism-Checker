import java.io.IOException;

public class Check {
	public Check() {

	}

	// �жϲ����������ʽ��ʽ������������򷵻�true����֮����false
	public static boolean CheckingRegularExpression(String expression,int i) throws IOException {
		if (checkOne(expression,i) || checkTwo(expression,i)) {
			return true;
		}

		if (checkThree(expression,i) || checkFour(expression,i)) {
			return true;
		}

		if (checkFive(expression,i) || matchingParentheses(expression,i)) {
			return true;
		}

		return false;
	}

	private static boolean checkFive(String expression,int num) throws IOException {
		// ���һ���ַ�Ϊ�����
		if (expression.matches(".*[\\+\\-\\*\\/]")) {
			// System.out.println("���һ���ַ�Ϊ�����");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#���һ���ַ�Ϊ�����";
			WriteToFile.writeToFile(out);
			return true;
		}
		// ����ƥ��
		if (!expression.matches(".*(\\()?.*(\\))?.*")) {
			// System.out.println("����ƥ��");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#����ƥ��";
			WriteToFile.writeToFile(out);
			return true;
		}
		return false;
	}

	private static boolean checkFour(String expression,int num) throws IOException {
		// ������ǰ���������
		if (expression.matches(".*[^\\+\\-\\*\\/\\(\\s*]\\(.*")) {
			// System.out.println("������ǰ���������");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#������ǰ���������";
			WriteToFile.writeToFile(out);
			return true;
		}
		// �����ź��������
		if (expression.matches(".*\\)[^\\+\\-\\*\\/\\)\\s*].*")) {
			// System.out.println("�����ź��������");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#�����ź��������";
			WriteToFile.writeToFile(out);
			return true;
		}
		return false;
	}

	private static boolean checkThree(String expression,int num) throws IOException {
		// �����ź��������
		if (expression.matches(".*\\([\\+\\-\\*\\/].*")) {
			// System.out.println("�����ź��������");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#�����ź��������";
			WriteToFile.writeToFile(out);
			return true;
		}
		// ������ǰ�������
		if (expression.matches(".*[\\+\\-\\*\\/]\\).*")) {
			// System.out.println("������ǰ�������");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#������ǰ�������";
			WriteToFile.writeToFile(out);
			return true;
		}
		return false;
	}

	private static boolean checkTwo(String expression,int num) throws IOException {
		// �ж���������������һ��
		if (expression.matches(".*[\\+\\-\\*\\/]\\s*[\\+\\-\\*\\/].*")) {
			// System.out.println("�ж���������������һ��");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#��������������һ��";
			WriteToFile.writeToFile(out);
			return true;
		}
		// �ж��Է��ſ�ͷ
		if (expression.matches("[\\+\\-\\*\\/\\)\\s].*")) {
			// System.out.println("�ж��Է��ſ�ͷ");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#�Է��ſ�ͷ";
			WriteToFile.writeToFile(out);
			return true;
		}
		return false;
	}

	private static boolean checkOne(String expression,int num) throws IOException {
		// ���ʽ�ں��Ƿ��ַ�
		if (!expression.matches("[\\+\\-\\*\\/\\(\\)\\d\\s]*")) {
			// System.out.println("���ʽ�ں��Ƿ��ַ�");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#���ʽ�ں��Ƿ��ַ�";
			WriteToFile.writeToFile(out);
			return true;
		}
		// ƥ�������
		if (expression.matches(".*(\\(\\)).*")) {
			// System.out.println("ƥ�������");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#ƥ�������";
			WriteToFile.writeToFile(out);
			return true;
		}
		return false;
	}

	// ƥ�����ţ�������򷵻�false����֮����true
	public static boolean matchingParentheses(String expression,int num) throws IOException {
		int l1 = 0; // ��¼(�ĸ���
		int l2 = 0; // ��¼)�ĸ���
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '(') {
				l1++;
			}
			if (c == ')') {
				l2++;
			}
		}
		if (l1 == l2) {
			return false;
		}
		String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#����������ƥ��";
		WriteToFile.writeToFile(out);
		return true;
	}
}
