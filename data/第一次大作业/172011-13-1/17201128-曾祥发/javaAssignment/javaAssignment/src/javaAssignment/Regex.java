package javaAssignment;

public class Regex {
	Regex() {

	}

	public void regex(String[] expression, String[] result, boolean[] tf) {
		int i = 0;
		while (expression[i] != null) {
			if (!expression[i].matches("[\\+\\-\\*\\/\\(\\)\\d\\s]*")) {// �Ƿ��ַ�
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}
			if (par(expression[i])) {// ƥ������
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}
			// ��������
			if (expression[i]
					.matches(".*(\\+\\+|\\+-|\\+/|\\+\\*|--|-\\+|-\\*|-/|\\*\\+|\\*-|\\*/|\\*\\*|/-|//|/\\+|/\\*).*")) { // ����+++
																															// ---.
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}

			if (expression[i].matches(".*(\\)\\d|\\d\\().*")) { // ���ұ������ֵ���� ����
																// (��������ֵ����
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}

			if (expression[i].matches(".*(\\(\\)).*")) { // ƥ�������
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}

			if (expression[i].matches(".*(\\+\\)|\\*\\)|-\\)|/\\)).*")) { // ��������ߺ��������
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}

			if (expression[i].matches(".*(\\(\\+|\\(/|\\(\\*).*")) { // �������ұ��������
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}

			if (expression[i].matches("[\\+\\*\\/].*")) {// �ж��Է��ſ�ͷ
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}

			if (expression[i].matches(".*[\\+\\-\\*\\/]")) {// ���һ���ַ�Ϊ�����
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}
			tf[i] = true;
			i++;
		}

	}

	public Boolean par(String exp) {
		int i = 0;
		for (int k = 0; k < exp.length(); k++) {
			char ch = exp.charAt(k);
			if(i < 0)
				return true;
			if (ch == '(')
				i++;
			else if (ch == ')')
				i--;
		}
		if (i == 0)
			return false;
		else
			return true;
	}

}
