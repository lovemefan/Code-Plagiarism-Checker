package BigHomeWork1;
// ����У���࣬�жϱ��ʽ�Ƿ���ȷ
import java.util.regex.*;

public class InputCheck {
	private String str = ""; // ��Ҫ��֤���ַ���
	private boolean isTrue = true;
	private int error = 0;// ��¼���������
	// ���ι��췽��������Ҫ��֤���ַ���
	public InputCheck(String newString){
		str = newString;
	    isTrue = true;
	}
	// ����ַ���str
	public String getStr(){
		return str;
	}
	// ����str��ֵ
	public void setStr(String newStr){
		str = newStr;
	}
	// ���error��ֵ
	public int getError(){
		return error;
	}
    // ���isTrue��ֵ
	public boolean getIsTrue(){
		return isTrue;
	}
	// ��ȥ�ո��
	public void cancelSpace(){
		String s = "[^\\s]";
		String s1 = "";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()){
			s1 += matcher.group();
		}
		str = s1;
	}
	// �ж��Ƿ��������ַ�����+��-��*��/���������⣩
	public void judgeOtherChar(){
		String s = "[^0-9\\+\\-\\*\\/\\(\\)]";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()){
			System.out.println("ERROR\n#���ʽ�к��в��Ϸ��ַ�");
			isTrue = false;
			error = 1;
		}
	}
	// �ж�������Ƿ�����������������������Ƿ���ȷ
	public void judgeSymbol(){
		String[] s = {"[\\+\\-\\*\\/][\\+\\-\\*\\/]","[\\(][\\+\\*\\/]","[\\+\\-\\*\\/][\\)]","[0-9][\\(]","[\\)][0-9]","[\\(][\\)]"};
		for (int i = 0;i < s.length;i ++){
		    Pattern pattern = Pattern.compile(s[i]);
		    Matcher matcher = pattern.matcher(str);
		    if (matcher.find()){
			    System.out.println("ERROR\n#���ʽ�������������ʹ�ô���");
			    isTrue = false;
			    error = 2;
			    return;
			    
		    }
		}
	}
	// �ж������Ƿ�ƥ��
	public void judgeBracketNumber(){
		int bracketNum = 0;
		for (int i = 0;i < str.length();i ++){
			if (str.charAt(i) == '(')
				bracketNum += 1;
			if (str.charAt(i) ==')')
				bracketNum += -1;
			if (bracketNum < 0){ //�����ű��������ȳ���
				System.out.println("ERROR\n#���ʽ������ƥ�����");
				isTrue = false;
				error = 3;
				return;
			}
		}
		if (bracketNum != 0){ // ����������������
			System.out.println("ERROR\n#���ʽ������ƥ�����");
			error = 3;
			isTrue = false;
		}
	}
	// �жϱ��ʽ��β���������,(-,������
	public void judgeStartAndEnd(){
		if (str.charAt(0) == '-'||str.charAt(0) == '+')
			str = "0" + str;
		else if(str.charAt(0) == '*'||str.charAt(0) == '/'){
			System.out.println("ERROR\n#���ʽ�������ʹ�ô���");
			error = 4;
			isTrue = false;
		}
		if (str.charAt(str.length() -1) == '+'||str.charAt(str.length() - 1) == '-'||str.charAt(str.length() - 1 )== '*'||str.charAt(str.length() - 1) == '/'){
			System.out.println("ERROR\n#���ʽβ�����ʹ�ô���");
			error = 5; 
			isTrue = false;
		}
		str = str.replace("(-", "(0-");
	}
	// �����жϲ�������
	public boolean judgeAll(){
		cancelSpace(); // ��ȥ�ո��
		if (str == ""){
			isTrue = false; 
			return isTrue;
		}
		judgeOtherChar(); // �ж��Ƿ��������ַ�
		judgeSymbol(); // �ж�����������ŵ������Ƿ����
		judgeStartAndEnd(); // �жϱ��ʽ��β���������������
		judgeBracketNumber(); // �ж����ŵ������Ƿ���ȷ
		return isTrue;
	}	
}
