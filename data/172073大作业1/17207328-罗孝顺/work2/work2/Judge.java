package work2;
import java.util.regex.*;

//�жϲ����������ʽ��ʽ������������򷵻�true����֮����false
public class Judge {

	private String str; // ��Ҫ��֤�ı��ʽ
	private boolean b; // ���ʽ�Ƿ����
	
	public Judge(String str) {
		this.str = str;
		this.b = true;
	}
	public String getExpression() {
		return str;
	}
	public boolean getb() {
		return b;
	}
	//�����ǰ��������
	public boolean error0() {
		String string = "^[+-/*].*|.*\\([+-/*].*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ���Ƿ��������ַ�
	public boolean error1() {
		String string = "[^0-9\\+\\-\\*\\/\\(\\)]";	
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ���Ƿ��п�����
	public boolean error2() {
		String string = ".*\\(\\).*";		
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {		
			b = false;
		}
		return b;
	}

	// ƥ���Ƿ�����������һ��������
	public boolean error3() {
		String string = ".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ����ʽ�Ƿ����������ͷ
	public boolean error4() {
		String string = "^[\\+\\-\\*\\/\\)]";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ����ʽ�������ź��������
	public boolean error5() {
		String string = ".*\\([\\+\\*\\/].*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ����ʽ��������ǰ�������
	public boolean error6() {
		String string = ".*[\\+\\-\\*\\/]\\).*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ����ʽ��������ǰ���������
	public boolean error7() {
		String string = ".*[^\\+\\-\\*\\/\\(]\\(.*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ����ʽ�������ź��������
	public boolean error8() {
		String string = ".*\\)[^\\+\\-\\*\\/\\)].*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}
	
	// ƥ����ʽ�����������
	public boolean error9() {
		String string = "[\\+\\-\\*\\/]$";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ�����Ÿ�����������򷵻�false����֮����true
	public boolean error10() {
		int num1 = 0; // ��¼(�ĸ���
		int num2 = 0; // ��¼)�ĸ���
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				num1++;
			}
			if (c == ')') {
				num2++;
			}
		}
		if (num1 != num2) {
			b = false;
		}
		return b;
	}		
	
}