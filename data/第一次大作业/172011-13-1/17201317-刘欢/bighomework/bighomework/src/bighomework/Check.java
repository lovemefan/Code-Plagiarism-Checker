package bighomework;

import java.util.regex.*;

//Check����޲ι��췽��
public class Check {
	public Check() {

	}

	// ��ȥ�ַ����еĿո�
	public String cleanBlank(String s1) {
		int x1 = s1.length();
		String s = "";
		for (int i = 0; i < x1; i++) {
			if (s1.charAt(i) == ' ') {
				continue;
			} else {
				s = s + s1.charAt(i);
			}
		}
		return s;
	}

	// ��ÿһ������ǰ����Ͽո�
	public String addBlank(String s) {
		String s1 = "";
		for (int i = 0; i < s.length(); i++) {
			String s2 = "";
			s2 = s2 + s.charAt(i);
			if (s2.matches("[\\+\\-\\*\\/\\(\\)]")) {
				s1 = s1 + " " + s2 + " ";
			} else {
				s1 = s1 + s2;
			}
		}
		return s1;
	}

	// �����ַ������ж�
	public String Judge(String s) {
		Stack stack2 = new Stack();
		String s1 = "";
		if (JudgeBracket(s) != 0) {
			s1 = s1 + "s1";

		} else if (JudgeSymbol(s) == 0) {
			s1 = s1 + "s4";

		} else if (JudgeForm(s) == 0) {
			s1 = s1 + "s3";

		} else if (JudgeZero(s) == 1) {
			s1 = s1 + "s2";

		} else {
			s1 = s1 + stack2.startStack(s);
		}

		return s1;
	}

	// �ж������Ƿ�ƥ��,ƥ�䷵��0����ƥ�䷵��1
	public int JudgeBracket(String s) {

		int flag = 0;// �������ŵ�����
		int m = s.length();
		for (int i = 0; i < m; i++) {
			if (s.charAt(i) == '(') {
				flag = flag + 1;
			} else if (s.charAt(i) == ')') {
				flag = flag - 1;
			} else {
				continue;
			}
			if(flag == -1){
				break; 
			}
		}
		// System.out.println(flag +"����");
		return flag;
	}

	// �ж������Ƿ�ƥ��,ƥ�䷵��1����ƥ�䷵��0
	public int JudgeSymbol(String s) {
		int flag = 1;
		String example1 = "[^(\\ )^(\\d)\\^(\\+)\\^(\\-)\\^(\\*)\\^(\\/)\\^(\\()\\^(\\)]";
		Pattern p1 = Pattern.compile(example1);
		Matcher m1 = p1.matcher(s);// ����matcher��Ķ��� m1
		if (m1.find()) {
			flag = 0;
		} else {
			flag = 1;
		}
		// System.out.println(flag +"����");
		return flag;
	}

	// �ж�/���ź����Ƿ�Ϊ0
	public int JudgeZero(String s) {
		int flag = 0;
		String example = "[\\/][0]";
		Pattern p = Pattern.compile(example);
		Matcher m = p.matcher(s);// ����matcher��Ķ��� m2
		if (m.find()) {
			flag = 1;
		} else {
			flag = 0;
		}
		return flag;
	}

	// �жϸ�ʽ�Ƿ���󣬴��󷵻�0����ȷ����1
	public int JudgeForm(String s) {
		int flag = 1;
		
		String example2 = "[\\(][\\ ]{2}[\\*\\/\\+\\-]";
		String example3 = "[\\)][\\ ]{2}[\\d]";
		String example4 = "[\\d][\\ ]{2}[\\(]";
		String example5 = "[\\*\\/\\+\\-][\\ ]{2}[\\*\\/\\+\\-]";
		String example6 = "[\\(][\\ ]{2}[\\)]";//
		String example7 = "[\\+\\*\\/\\-][\\ ]{2}[\\)]";
		String example8 = "[^(\\+\\-\\*\\/)]";
		String example9 = "[$(\\+\\-\\*\\/)]";
		Pattern p2 = Pattern.compile(example2);
		Pattern p3 = Pattern.compile(example3);
		Pattern p4 = Pattern.compile(example4);
		Pattern p5 = Pattern.compile(example5);
		Pattern p6 = Pattern.compile(example6);
		Pattern p7 = Pattern.compile(example7);
		Pattern p8 = Pattern.compile(example8);
		Pattern p9 = Pattern.compile(example9);
		Matcher m2 = p2.matcher(s);// ����matcher��Ķ��� m2
		Matcher m3 = p3.matcher(s);// ����matcher��Ķ��� m3
		Matcher m4 = p4.matcher(s);// ����matcher��Ķ��� m4
		Matcher m5 = p5.matcher(s);// ����matcher��Ķ��� m5
		Matcher m6 = p6.matcher(s);// ����matcher��Ķ��� m6
		Matcher m7 = p7.matcher(s);// ����matcher��Ķ��� m7
		Matcher m8 = p8.matcher(s);// ����matcher��Ķ��� m7
		Matcher m9 = p9.matcher(s);// ����matcher��Ķ��� m7
		if (m2.find() || m3.find() || m4.find() || m5.find() || m6.find() || m9.find()|| m7.find()|| m8.find()) {
			flag = 0;
		} else {
			flag = 1;
		}
	    
	
		return flag;
	}

}
