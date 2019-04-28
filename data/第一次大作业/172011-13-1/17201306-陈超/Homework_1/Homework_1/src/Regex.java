
import java.util.regex.*;

//�жϲ����������ʽ��ʽ������������򷵻�true����֮����false
public class Regex {

	private String expression; // ��Ҫ��֤�ı��ʽ
	private boolean isTrue; // ���ʽ�Ƿ����
	private String eM; // ���ʽ������Ϣ

	// �չ��췽��
	public Regex() {

	}

	// ���ι��췽��,�����Ǳ��ʽ
	public Regex(String expression) {
		this.expression = expression;
		isTrue = true;
		eM = "";
	}

	// ���ʽ������
	public String getExpression() {
		return expression;
	}

	// isTrue�ķ�����
	public boolean getIsTrue() {
		return isTrue;
	}

	// ������Ϣ������
	public String getErrorMessage() {
		eM += judgeOtherChar();
		eM += judgeEmpty();
		eM += judgeTwoSymbol();
		eM += judgeStartSymbol();
		eM += judgeSymbolAfterLeft();
		eM += judgeSymbolBeforeRight();
		eM += judgeSymbolNotBeforeLeft();
		eM += judgeSymbolNotAfterRight();
		eM += judgeEndOfSymbol();
		eM += judgeParentheses();
		return eM;
	}

	// ��ȥ�ո��
	public String cancelSpace() {
		String string = "[^\\s]";
		// s1���ڼ�סȥ���ո��ı��ʽ
		String s1 = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		while (matcher.find()) {
			s1 += matcher.group();
		}
		expression = s1;
		return expression;
	}

	// ƥ���Ƿ���������+,-,*,/,(,)����ַ�
	public String judgeOtherChar() {
		String string = "[^0-9\\+\\-\\*\\/\\(\\)]";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#���ʽ�к��в��Ϸ��ַ�\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// ƥ�������
	public String judgeEmpty() {
		String string = ".*\\(\\).*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#���ʽ�к��п�����\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// ƥ�����������������һ��
	public String judgeTwoSymbol() {
		String string = ".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#���ʽ�������������������һ��\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// ƥ����ʽ���������ͷ��+,-���� �߽�ƥ����^:һ�еĿ�ͷ
	public String judgeStartSymbol() {
		String string = "^[\\*\\/\\)]";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#���ʽ��+��*��/�������ͷ\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// ƥ����ʽ�������ź��������
	public String judgeSymbolAfterLeft() {
		String string = ".*\\([\\+\\*\\/].*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#���ʽ�������ź��������\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// ƥ����ʽ��������ǰ�������
	public String judgeSymbolBeforeRight() {
		String string = ".*[\\+\\-\\*\\/]\\).*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#���ʽ��������ǰ�������\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// ƥ����ʽ��������ǰ���������
	public String judgeSymbolNotBeforeLeft() {
		String string = ".*[^\\+\\-\\*\\/\\(]\\(.*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#���ʽ��������ǰ���������\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// ƥ����ʽ�������ź��������
	public String judgeSymbolNotAfterRight() {
		String string = ".*\\)[^\\+\\-\\*\\/\\)].*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#���ʽ�������ź��������\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// ƥ����ʽ�����������
	public String judgeEndOfSymbol() {
		String string = "[\\+\\-\\*\\/]$";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#���ʽ�����������\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// ƥ�����Ÿ�����������򷵻�false����֮����true
	public String judgeParentheses() {
		String errorMessage = "";
		int num1 = 0; // ��¼(�ĸ���
		int num2 = 0; // ��¼)�ĸ���
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '(') {
				num1++;
			}
			if (c == ')') {
				num2++;
			}
		}
		if (num1 != num2) {
			errorMessage = "#���ʽ���ŶԲ�ƥ��\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// �����жϲ�������
	public boolean judgeAll() {
		cancelSpace();
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
		return isTrue;
	}
}
