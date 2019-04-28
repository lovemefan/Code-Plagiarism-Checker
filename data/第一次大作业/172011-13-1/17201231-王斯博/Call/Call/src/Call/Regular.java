package Call;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//��������������ʱ�жϱ��ʽ�Ƿ�Ϸ�
public class Regular {
	Regular() {

	}

	String RegularJudge(String s) {
		String i = null;
		// ����Ϊ��������ʽ�Ƿ�����
		i = i + regularJudge1(s);// �ж��Ƿ����error
		i = i + regularJudge2(s);// �ж��Ƿ��������ַ�����ʽ����
		i = i + regularJudge3(s);// �ж��Ƿ�������
		i = i + regularJudge4(s);// �жϱ��ʽ���Ƿ�����������
		i = i + regularJudge5(s);// �жϱ��ʽ��ͷ���߽�β�Ƿ�����������
		i = i + regularJudge6(s);// �жϱ��ʽ(�������������)ǰ�������
		i = i + regularJudge7(s);// �����˶����������磺1--1��8*-4��
		i = i + regularJudge8(s);// �жϱ��ʽ(ǰ�Ƿ������������)���Ƿ��������
		i = i + regularJudge9(s);// �жϱ��ʽ���������Ƿ�ƥ��
		return i;
	}

	// �ж��Ƿ����error
	String regularJudge1(String s) {
		boolean judge = false;
		if (!s.contains("(") || !s.contains(")")) {// �����ź�������Ϊ�����б𷽷�
			Pattern p = Pattern.compile("(\\d+)((\\+|\\-|\\*|\\/)(\\d+))*");
			Matcher m = p.matcher(s);
			judge = m.matches();
		} else {
			Pattern p = Pattern.compile(
					"((\\d*(\\+|\\-|\\*|\\/))*(\\(\\d+((\\+|\\-|\\/|\\*)(\\d+))*\\))*((\\+|\\-|\\*|\\/)\\d*)*)*");
			Matcher m = p.matcher(s);
			judge = m.matches();
		}
		String i = null;
		if (judge == false) {
			i = "\r\n#���ʽ�����Ϲ淶��";
			System.out.println("#���ʽ�����Ϲ淶��");
		}
		return i;
	}

	// �жϱ��ʽ���Ƿ�����������
	String regularJudge4(String s) {
		Pattern p = Pattern.compile("[\\uff08\\\uff09]+");
		Matcher m = p.matcher(s);
		String i = null;
		if (m.find()) {
			i = "\r\n#���ʽ�к�����������";
			System.out.println("#���ʽ�к�����������");
		}
		return i;
	}

	// �жϱ��ʽ���������Ƿ�ƥ��
	String regularJudge9(String s) {
		int bracketNum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				bracketNum += 1;
			if (s.charAt(i) == ')')
				bracketNum += -1;
		}
		String add = null;
		if (bracketNum != 0) { // ����������������
			add = "\r\n#���ʽ���������ô���";
			System.out.println("#���ʽ���������ô���");
		}
		return add;
	}

	// �жϱ��ʽ(ǰ�Ƿ������������)���Ƿ��������
	String regularJudge8(String s) {
		Pattern p = Pattern.compile(".*\\d+\\(.*|.*\\)\\d+.*");
		Matcher m = p.matcher(s);
		String i = null;
		if (m.find()) {
			System.out.println("#���ʽ(ǰû�����������)��û�������");
			i = "\r\n#���ʽ(ǰû�����������)��û�������";
		}
		return i;
	}

	// �����˶����������磺1--1��8*-4��
	String regularJudge7(String s) {
		Pattern p = Pattern.compile("(\\+|\\-|\\/|\\*){2,}");
		Matcher m = p.matcher(s);
		String i = null;
		if (m.find()) {
			System.out.println("#������ظ�����");
			i = "\r\n#������ظ�����";
		}
		return i;
	}

	// �жϱ��ʽ(�������������)ǰ�������
	String regularJudge6(String s) {
		Pattern p = Pattern.compile("\\((\\+|\\-|\\/|\\*).+|.+(\\+|\\-|\\/|\\*)\\)");
		Matcher m = p.matcher(s);
		String i = null;
		if (m.find()) {
			i = "\r\n#���ʽ(�������������)ǰ�������";
			System.out.println("#���ʽ(�������������)ǰ�������");
		}
		return i;
	}

	String regularJudge3(String s) {
		Pattern p = Pattern.compile("\\d+\\.\\d+");
		Matcher m = p.matcher(s);
		String i = null;
		if (m.find()) {
			i = "\r\n#���ʽ�г�����С���㣬Ӧ��������";
			System.out.println("#���ʽ�г�����С���㣬Ӧ��������");
		}
		return i;
	}

	// �жϱ��ʽ��ͷ���߽�β�Ƿ�����������
	String regularJudge5(String s) {
		Pattern p = Pattern.compile("^(\\+|\\-|\\/|\\*).+|.+(\\+|\\-|\\/|\\*)$");
		Matcher m = p.matcher(s);
		String i = null;
		if (m.matches()) {
			i = "\r\n#���ʽ��ͷ���߽�β�����������";
			System.out.println("#���ʽ��ͷ���߽�β�����������");
		}
		return i;
	}

	// �ж��Ƿ��������ַ�����ʽ����
	String regularJudge2(String s) {
		Pattern p = Pattern.compile("[^\\d\\(\\)\\-\\+\\*\\/]+");
		Matcher m = p.matcher(s);
		String i = null;
		if (m.find()) {
			i = "\r\n#���ʽ�к��в��Ϸ��ַ�";
			System.out.println("#���ʽ�к��в��Ϸ��ַ�");
		}
		return i;
	}
}