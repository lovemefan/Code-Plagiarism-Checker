package Project;

import java.util.regex.*;
import java.util.regex.Pattern;
import java.util.regex.*;

public class JudgeValid {
	// ���췽��
	public JudgeValid() {

	}

	// �ж�
	public int judge(String infix) {
		int flag = 0;
		if (judge1(infix)) {
			flag = 1;
		} else if (!judge2(infix)) {
			flag = 2;
		} else if (judge3(infix)) {
			flag = 3;
		} else if (judge4(infix)) {
			flag = 4;
		} else if (judge5(infix)) {
		flag = 5;
		}else if (judge6(infix)) {
			flag = 6;
		}else if (judge7(infix)) {
			flag = 7;
		}else if (judge8(infix)) {
			flag = 8;
		}
		return flag;
	}

	// �ж�()���Ƿ��������ַ�
	public static boolean judge1(String s) {
		boolean f = false;
		String sub1 = "[^0-9\\*\\+\\-\\//\\(\\)\\.]";
		Pattern p1 = Pattern.compile(sub1);
		Matcher m1 = p1.matcher(s);// ����matcher��Ķ��� m

		if (m1.find())
			f = true;
		return f;
	}

	// �ж��Ƿ����Ų�ƥ��
	public static boolean judge2(String s) {
		int top = 0;// ������������ 1�������� -1������ܺ�0��ƥ��
		boolean end = true;// true ��ʾƥ��

		char[] biao = s.toCharArray();// ���ַ���ת�����ַ�����
		for (int i = 0; i < biao.length; i++) {
			// �����(���1����ջ
			if (biao[i] == '(') {
				top++;
			} else if (biao[i] == ')') {// �����)
				top--;
			}
			if (top < 0){
				end = false;
				break;
			}
		}
		if (top != 0)
			end = false;
		return end;
	}

	// �жϿ�����
	public static boolean judge3(String s) {
		boolean f = false;
		String sub = "[\\(][\\)]";
		// ����Pattern��Ķ���
		Pattern pat = Pattern.compile(sub);
		// ����matcher��Ķ���
		Matcher mat = pat.matcher(s);
		if ( mat.find()) {
			f = true;
		}
		return f;
	}
	
	// �ж��Ƿ���ʽ��β��û�������
	public static boolean judge4(String s) {
		boolean f = false;
		String sub = "^[\\+\\*\\/]|[\\+\\-\\*\\/]$";
		// ����Pattern��Ķ���
		Pattern pat = Pattern.compile(sub);
		// ����matcher��Ķ���
		Matcher mat = pat.matcher(s);
		if (mat.find()) {
			f = true;
		}
		return f;
	}
	
	// �ж��Ƿ���ʽ�������Ž�����
	public static boolean judge5(String s) {
		boolean f = false;
		String sub = "[\\d]{1,10}[\\(]|[\\)][\\d]{1,10}";
		// ����Pattern��Ķ���
		Pattern pat = Pattern.compile(sub);
		// ����matcher��Ķ���
		Matcher mat = pat.matcher(s);
		if ( mat.find() ) {
			f = true;
		}
		return f;
	}
	
	// �ж��Ƿ���ʽ�������Ž��������)(֮��û�������
		public static boolean judge6(String s) {
			boolean f = false;
			String sub = "[\\(][\\+\\*\\/]|[\\+\\-\\*\\/][\\)]|[\\)\\(]";
			// ����Pattern��Ķ���
			Pattern pat = Pattern.compile(sub);
			// ����matcher��Ķ���
			Matcher mat = pat.matcher(s);
			if ( mat.find() ) {
				f = true;
			}
			return f;
		}
		
		// �ж��Ƿ���ʽ�������������
		public static boolean judge7(String s) {
			boolean f = false;
			String sub = "[\\+\\-\\*\\/]{2}";
			// ����Pattern��Ķ���
			Pattern pat = Pattern.compile(sub);
			// ����matcher��Ķ���
			Matcher mat = pat.matcher(s);
			if ( mat.find() ) {
				f = true;
			}
			return f;
		}
		
		// �жϸ������ �淶
		public static boolean judge8(String s) {
			boolean f = false;
			String sub = "[\\(][\\-][\\d]{1,10}[\\+\\-\\*\\/]|[\\-][\\(][\\d]{1,10}[\\)]";
			// ����Pattern��Ķ���
			Pattern pat = Pattern.compile(sub);
		// ����matcher��Ķ���
			Matcher mat = pat.matcher(s);
			if ( mat.find() ) {
				f = true;
			}
			return f;
		}
}

