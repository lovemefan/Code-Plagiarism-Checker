import java.util.regex.Matcher;
import java.util.regex.Pattern;

//����У����
public class Check {
	private String s;// ���ʽ
	private String[] str;// ���ʽ����
	private String s1;
	
	public Check() {// ���캯��

	}

	public Check(String[] str) {// ���캯��
		this.str = str;
	}

	public String get(){//���ش�����Ϣ
		return s1;
	}
	
	public Check(String s) {// ���캯��
		this.s = s;
	}

	private boolean test1() {// ������ʽΪ��()��
		Pattern p = Pattern.compile("\\(\\)");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "������";
			return false;
		}
		return true;
	}

	private boolean test0() {// ������ʽΪ��
		Pattern p = Pattern.compile("^\\s*$");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "���ַ���";
			return false;
		}
		return true;
	}
	
	private boolean test2() {// ������ʽ�����������
		Pattern p = Pattern.compile("[\\+\\-\\*\\/]+[\\+\\-\\*\\/]+");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "���������";
			return false;
		}
		return true;
	}
    
	private boolean test3() {// ������ʽ�������ź�����������Ҳ���"(-1)"
		Pattern p = Pattern.compile("\\([\\-]\\d+[^\\)]");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "�����ź��������";
			return false;
		}
		return true;
	}
    
	private boolean test4() {// ������ʽ�������������������
		Pattern p = Pattern.compile("[\\+\\-\\*\\/]\\)");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "�����������������";
			return false;
		}
		return true;
	}
    
	private boolean test5() {// ������ʽ�������ǰ��������
		Pattern p = Pattern.compile("\\([\\+\\*\\/]");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "�����ź��������";
			return false;
		}
		return true;
	}
	
	private boolean test6() {// ������ʽ��������������ſ�ʼ
		Pattern p = Pattern.compile("^[\\+\\-\\*\\/\\)]");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "��ͷ���Ŵ���";
			return false;
		}
		return true;
	}
    
	private boolean test7() {// ��������������Ž���
		Pattern p = Pattern.compile("[\\+\\-\\*\\/\\(]$");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "��β���Ŵ���";
			return false;
		}
		return true;
	}
	private boolean test8() {// ������ʽ���Ų�ƥ��
		int count1 = 0;
		int count2 = 0;
		Pattern p = Pattern.compile("\\(", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(s);
		while (m.find()) {
			count1++;
		}
		Pattern p1 = Pattern.compile("\\)", Pattern.CASE_INSENSITIVE);
		Matcher m1 = p1.matcher(s);
		while (m1.find()) {
			count2++;
		}
		if (count1 != count2) {
			s1 = "���Ų�ƥ��";
			return false;
		}
			return true;
	}
    
	private boolean test9() {// ������ʽ����Сд��ĸ
		Pattern p = Pattern.compile("[A-Za-z]");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "���ʽ���Ƿ��ַ�";
			return false;
		}
		return true;
	}
    
	private boolean test10() {// ������ʽ������0
		Pattern p = Pattern.compile("[\\/]0");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "���ź��治��Ϊ��";
			return false;
		}
		return true;
	}
	
	private boolean test11() {// ������ʽ���ֺ�����������
		Pattern p = Pattern.compile("\\d+\\(");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "���ֺ�����������";
			return false;
		}
		return true;
	}
	
	private boolean test12() {// ������ʽ�����ź���������
		Pattern p = Pattern.compile("\\)\\d+");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "�����ź�������";
			return false;
		}
		return true;
	}

	public boolean testa() {// �жϱ��ʽ�Ƿ�Ϸ�
		if (!test0() || !test1() || !test2() || !test3() || !test4() || !test5()) {
			return false;
		}
		return true;
	}

	public boolean testb() {// �жϱ��ʽ�Ƿ�Ϸ�
		if (!test6() || !test7() || !test8() || !test9() || !test10() || !test11() || !test12()) {
			return false;
		}
		return true;
	}
	
	public boolean test() {// �жϱ��ʽ�Ƿ�Ϸ�
		if(testa() && testb()){
			return true;
		}
		return false;
	}
	
	public String[] test00() {// ɾ���ظ��ı��ʽ
		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (str[i].equals(str[j])) {
					str = delete(str, j);
					j--;
				}
			}
		}
		return str;
	}

	private String[] delete(String[] s, int x) {// ʵ��ɾ������Ԫ��
		String[] arrNew = new String[s.length - 1];
		for (int i = x; i < s.length - 1; i++) {
			arrNew[i] = s[i + 1];
		}
		for (int i = 0; i < x; i++) {
			arrNew[i] = s[i];
		}
		return arrNew;
	}
}
