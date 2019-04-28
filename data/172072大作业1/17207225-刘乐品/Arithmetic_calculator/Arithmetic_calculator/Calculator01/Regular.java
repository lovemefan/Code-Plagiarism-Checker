package Calculator01;
import java.util.regex.*;
public class Regular {

	private String exp; // ��Ҫ��֤�ı��ʽ
	private boolean sfTrue; // ���ʽ�Ƿ����
	private String eMe; // ���ʽ������Ϣ

	public  Regular(String exp) 
	{// ���ι��췽��,�����Ǳ��ʽ
		this.exp=exp;
		sfTrue=true;
		eMe= "";
	}

	
	public String getExpression() 
	{// ���ʽ����
		return exp;
	}

	
	public boolean getIsTrue() 
	{// �Ƿ���ȷ
		return sfTrue;
	}

	
	public String getErrorMessage() {
		// ������Ϣ����
		eMe+= judgeEmptyexp();
		eMe+= judgeOtherChar();
		eMe+= judgeEmpty();
		eMe+= judgeTwoSymbol();
		eMe+= judgeStartSymbol();
		eMe+= judgeSymbolAfterLeft();
		eMe+= judgeSymbolBeforeRight();
		eMe+= judgeSymbolNotBeforeLeft();
		eMe+= judgeSymbolNotAfterRight();
		eMe+= judgeEndOfSymbol();
		eMe+= judgeParentheses();
		return eMe;
	}

	
	public String cancelSpace() {// ��ȥ�ո��
		String string = "[^\\s]";
		// s1���ڼ�סȥ���ո��ı��ʽ
		String s1 = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		while (matcher.find()) {
			s1 += matcher.group();
		}
		exp=s1;
		return exp;
	}
	public String judgeEmptyexp() {//�ж��Ƿ�Ϊ�յı��ʽ
		/*String string ="\\s*|\t|\r|\n";
		String errorMessage="";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage="#���ʽΪ��\r\n";
			sfTrue = false;
		}*/
		String errorMessage="";
		if(exp.length()==0)
		{
			errorMessage="#���ʽΪ��\r\n";
			sfTrue = false;
		}
		return errorMessage;
		
		

	}
	
	
	public String judgeOtherChar() {// ƥ���Ƿ���������+,-,*,/,(,)����ַ�
		String string = "[^0-9\\+\\-\\*\\/\\(\\)]";
		String errorMessage="";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage="#���ʽ�к��зǷ��ַ�\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeEmpty() {// ƥ�������
		String string = ".*\\(\\).*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#���ʽ�к��п�����\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}


	public String judgeTwoSymbol() {	// ƥ�����������������һ��
		String string = ".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#���������\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeStartSymbol() {// ƥ����ʽ���������ͷ-���� 
		String string = "^[\\*\\/\\)]";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#�����ǰ��������\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeSymbolAfterLeft() {// ƥ����ʽ�������ź��������-����
		String string = ".*\\([\\+\\*\\/].*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#�����ǰ��������\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeSymbolBeforeRight() {// ƥ����ʽ��������ǰ�������
		String string = ".*[\\+\\-\\*\\/]\\).*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#���������������\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeSymbolNotBeforeLeft() {// ƥ����ʽ��������ǰ���������
		String string = ".*[^\\+\\-\\*\\/\\(]\\(.*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#���ŷǵ�һ���ַ���֮ǰ�������� \r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeSymbolNotAfterRight() {// ƥ����ʽ�������ź��������
		String string = ".*\\)[^\\+\\-\\*\\/\\)].*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#С���ź��������������ŷ����һ���ַ�\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeEndOfSymbol() {// ƥ����ʽ�����������
		String string = "[\\+\\-\\*\\/]$";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#���������������\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeParentheses() {// ƥ�����Ÿ�����������򷵻�false����֮����true
		String errorMessage = "";
		int num1 = 0; // ��¼(�ĸ���
		int num2 = 0; // ��¼)�ĸ���
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if (c == '(') {
				num1++;
			}
			if (c == ')') {
				num2++;
			}
		}
		if (num1 != num2) {
			errorMessage = "#���Ų�ƥ��\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	// �����жϲ�������
	public boolean judgeAll() {
		cancelSpace();
		judgeEmptyexp();
		judgeOtherChar();
		judgeEmpty();
		judgeTwoSymbol();
		judgeStartSymbol();
		judgeSymbolAfterLeft();
		judgeSymbolBeforeRight();
		judgeSymbolNotBeforeLeft();
		judgeSymbolNotAfterRight();
		judgeEndOfSymbol();
		judgeParentheses();
		return sfTrue;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
