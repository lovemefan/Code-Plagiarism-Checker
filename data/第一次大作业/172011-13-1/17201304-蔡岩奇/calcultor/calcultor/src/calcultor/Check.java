package calcultor;

import java.util.regex.*;

public class Check {
	private String str = ""; // ��Ҫ��֤���ַ���
	private boolean isTrue = true;
	// ���ι��췽��������Ҫ��֤���ַ���
	public Check(String newString){
		this.str = newString;
	    this.isTrue = true;
	}
	// ����ַ���str
	public String getStr(){
		return str;
	}
	// ��ȥ�ո��
	public void skipSpace(){
		String s = "[^\\s]";
		String s1 = "";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()){
			s1 += matcher.group();
		}
		str = s1;
	}
	// �ж��Ƿ��������ַ�
	public void checkOthers(){
		String s = "[^0-9\\+\\-\\*\\/\\(\\)]";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()){
			System.out.println(str);
			System.out.println("ERROR\n���ʽ�к��в��Ϸ��ַ�");
			isTrue = false;
			return;
		}
	}
	// �ж�������Ƿ�����������������������Ƿ���ȷ
	public void checkSymbol(){
		String[] s = {"[\\+\\-\\*\\/][\\+\\-\\*\\/]","[^0-9\\)][\\+\\-\\*\\/]","[\\+\\-\\*\\/][^0-9\\(]","[0-9][\\(]","[\\)][0-9]","[\\(][\\)]"};
		for (int i = 0;i < s.length;i ++){
		    Pattern pattern = Pattern.compile(s[i]);
		    Matcher matcher = pattern.matcher(str);
		    if (matcher.find()){
		    	System.out.println(str);
			    System.out.println("ERROR\n���ʽ�������������ʹ�ô���");
			    isTrue = false;
			    return;
		    }
		}
	}
	// �ж������Ƿ�ƥ��
	public void checkBracket(){
		int bracketNum = 0;
		for (int i = 0;i < str.length();i ++){
			if (str.charAt(i) == '(')
				bracketNum += 1;
			if (str.charAt(i) ==')')
				bracketNum += -1;
			if (bracketNum < 0){ //�����ű��������ȳ���
				System.out.println(str);
				System.out.println("ERROR\n���ʽ���������ô���");
				isTrue = false;
				return;
			}
		}
		if (bracketNum != 0){ // ����������������
			System.out.println(str);
			System.out.println("ERROR\n���ʽ���������ô���");
			isTrue = false;
			return;
		}
	}
	// �жϱ��ʽ��β���������������
	public void checkStartAndEnd(){
		if (str.charAt(0) == '-'||str.charAt(0) == '+')
			str = "0" + str;
		else if(str.charAt(0) == '*'||str.charAt(0) == '/'){
			System.out.println(str);
			System.out.println("ERROR\n���ʽ�������ʹ�ô���");
			isTrue = false;
			return;
		}
		if (str.charAt(str.length() -1) == '+'||str.charAt(str.length() - 1) == '-'||str.charAt(str.length() - 1 )== '*'||str.charAt(str.length() - 1) == '/'){
			System.out.println(str);
			System.out.println("ERROR\n���ʽβ�����ʹ�ô���");
			isTrue = false;
			return;
		}
	}
	// �жϲ�����������0��ͷ
	public void checkZero(){
		String s = "[\\+\\-\\*\\/\\(][0][0-9]";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()||(str.charAt(0) == '0' && Character.isDigit(str.charAt(1)))){
			System.out.println(str);
			System.out.println("ERROR\n���ʽ�к�����0��ͷ������");
			isTrue = false;
			return;
		}
	}
	// �����жϲ�������
	public boolean checkAll(){
		skipSpace(); // ��ȥ�ո��
		checkZero();// �жϲ�����������0��ͷ
		checkOthers(); // �ж��Ƿ��������ַ�
		checkSymbol(); // �ж�����������ŵ������Ƿ����
		checkStartAndEnd(); // �жϱ��ʽ��β���������������
		checkBracket(); // �ж����ŵ������Ƿ���ȷ
		return isTrue;
	}	
}
