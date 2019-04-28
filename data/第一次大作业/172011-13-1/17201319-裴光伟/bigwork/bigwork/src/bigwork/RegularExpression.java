package bigwork;

import java.util.regex.*;

public class RegularExpression {
	public static void RegularExp(String[] exp, int s) {
		equal(exp, s);// �ж���ͬ������
		situation1(exp, s);// ���ʽ�ں��Ƿ��ַ�
		situation2(exp, s);// ������
		situation3(exp, s);// ���������
		situation4(exp, s);// ������ǰ�治�������
		situation5(exp, s);// �����ź��治�������
		situation6(exp, s);// �����ź������
		situation7(exp, s);// ������ǰ������
		situation8(exp, s);// �ԷǷ��ַ���ͷ
		situation9(exp, s);// ���Ų�ƥ��
		situation10(exp, s);// �������
		situation11(exp, s);// �ԷǷ��ַ���β
		situation12(exp, s);// ��ͷΪ���ж�Ϊ����
		minusPan(exp, s);// �жϸ���
	}

	// �жϸ���
	public static void minusPan(String[] exp, int s) {
		for (int i = 0; i < s; i++)
			exp[i] = exp[i].replaceAll("\\(-", "\\(0-");
	}

	// �ж���ͬ������
	public static void equal(String[] exp, int s) {
		String error = "\r\nERROR\r\n#�õ�ʽ��������ʽ�ظ�!!!";
		for (int i = 0; i < s - 1; i++)
			for (int j = i + 1; j < s; j++) {
				if (exp[i].equals(exp[j]) && !errorPan(exp[i]))
					exp[j] = exp[j] + error;
			}
	}

	// �ж��Ƿ�ERROR
	public static boolean errorPan(String exp) {
		Pattern p = Pattern.compile("ERROR");
		Matcher m = p.matcher(exp);
		return m.find();
	}

	// �ж��Ƿ�Ϊ���ַ���
	public static boolean blankPan(String exp) {
		Pattern p = Pattern.compile("^\\s*$");
		Matcher m = p.matcher(exp);
		return m.find();
	}

	// ���ʽ�ں��Ƿ��ַ�
	public static void situation1(String[] exp, int s) {
		Pattern p = Pattern.compile("[^\\(\\)\\*\\+-/\\d]");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (m.find() && !errorPan(exp[i]))
				exp[i] = errorPrint(exp[i], "#���ʽ�ں��Ƿ��ַ�");
		}
	}

	// ������
	public static void situation2(String[] exp, int s) {
		Pattern p = Pattern.compile("\\(\\)");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (m.find())
				exp[i] = errorPrint(exp[i], "#���ʽ�ڿ�����");
		}
	}

	// ���������
	public static void situation3(String[] exp, int s) {
		Pattern p = Pattern.compile("(\\+|-|\\*|/){2,}");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (m.find())
				exp[i] = errorPrint(exp[i], "#���ʽ�����������");
		}
	}

	// ������ǰ�治�������
	public static void situation4(String[] exp, int s) {
		Pattern p = Pattern.compile("\\d\\(");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (m.find())
				exp[i] = errorPrint(exp[i], "#���ʽ��������ǰ�治�������");
		}
	}

	// �����ź��治�������
	public static void situation5(String[] exp, int s) {
		Pattern p = Pattern.compile("\\)\\d");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (m.find())
				exp[i] = errorPrint(exp[i], "#���ʽ�������ź��治�������");
		}
	}

	// �����ź������
	public static void situation6(String[] exp, int s) {
		Pattern p = Pattern.compile("\\((\\+|\\*|/)");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (m.find())
				exp[i] = errorPrint(exp[i], "#���ʽ�������ź������");
		}
	}

	// ������ǰ������
	public static void situation7(String[] exp, int s) {
		Pattern p = Pattern.compile("(\\+|-|\\*|/|\\()\\)");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (m.find())
				exp[i] = errorPrint(exp[i], "#���ʽ��������ǰ������");
		}
	}

	// �ԷǷ��ַ���ͷ
	public static void situation8(String[] exp, int s) {
		for (int i = 0; i < s; i++) {
			if (exp[i].charAt(0) == '+' || exp[i].charAt(0) == ')' || exp[i].charAt(0) == '*'
					|| exp[i].charAt(0) == '/')
				exp[i] = errorPrint(exp[i], "#���ʽ���ԷǷ��ַ���ͷ");
		}
	}

	// ��ͷΪ���ж�Ϊ����
	public static void situation12(String[] exp, int s) {
		for (int i = 0; i < s; i++) {
			if (exp[i].charAt(0) == '-')
				exp[i] = "0" + exp[i];
		}
	}

	// �ԷǷ��ַ���β
	public static void situation11(String[] exp, int s) {
		for (int i = 0; i < s; i++) {
			int len = exp[i].length() - 1;
			if (exp[i].charAt(len) == '+' || exp[i].charAt(len) == '-' || exp[i].charAt(len) == '*'
					|| exp[i].charAt(len) == '/' || exp[i].charAt(len) == '(')
				exp[i] = errorPrint(exp[i], "#���ʽ���ԷǷ��ַ���β");
		}
	}

	// ���Ų�ƥ��
	public static void situation9(String[] exp, int s) {
		boolean t = false;
		for (int i = 0; i < s; i++) {
			t = bracketEqual(exp[i]);
			if (!t)
				exp[i] = errorPrint(exp[i], "#���ʽ�����Ų�ƥ��");
		}
	}

	// �������
	public static void situation10(String[] exp, int s) {
		Pattern p = Pattern.compile("(\\+|\\*|-|/)");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (!m.find())
				exp[i] = errorPrint(exp[i], "#���ʽ���������");
		}
	}

	// ���ַ��������������Ϣ
	public static String errorPrint(String exp, String error) {
		String e = "\r\nERROR\r\n";
		if (errorPan(exp))
			exp = exp + error;
		else
			exp = exp + e + error;
		return exp;
	}

	// �ж����������Ƿ����
	public static boolean bracketEqual(String exp) {
		int p = 0;
		char[] ch = exp.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '(')
				p++;
			if (ch[i] == ')')
				p--;
		}
		if (p == 0)
			return true;
		else
			return false;
	}
}
