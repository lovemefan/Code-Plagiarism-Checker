import java.util.regex.Matcher;
import java.util.regex.Pattern;

// ���ʽ�Ϸ���У����
public class CheckExpression {
	private String errorMessage;// ���صĴ�����Ϣ
	private String expression;// ��Ҫ�����ַ���

	// ������expression
	public String getExpression() {
		return expression;
	}

	// �޲ι��췽��
	public CheckExpression() {
		expression = "";
		errorMessage = "";
	}

	// �вι��췽��
	public CheckExpression(String str) {// ����ΪҪ�����ַ������еĹ��췽��
		expression = str;
	}

	// ����Ƿ����޹��ַ�
	private void checkIlegalChar() {
		if (expression.length() == 0) {// ���ʽΪ�մ�
			errorMessage = "ERROR"  + "\r\n" + "#���ʽΪ��!";
			return;
		}

		// ������ʽƥ��հ׷�\\s�����֡��ӡ������ˡ���������ַ�
		String regexError = "[^0-9\\(\\)\\+\\-\\*\\/\\s]";
		Pattern pattern = Pattern.compile(regexError);
		Matcher matcher = pattern.matcher(expression);

		if (matcher.find()) {// �����޹��ַ�
			errorMessage = "ERROR"  + "\r\n" + "#���ʽ�����Ƿ��ַ�!";
			return;
		}
	}

	// ���˿հ׷�
	public String trimSpace() {
		String str = null;
		str = expression.replaceAll("\\s", "");
		return str;
	}

	// ���Ӵ���son�����ַ�����father���г��ֵĴ���
	private static int extractCount(String father, String son) {
		int count = 0;
		Pattern p = Pattern.compile(son, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(father);

		while (m.find()) {
			count++;
		}
		return count;
	}

	// ������������Ƿ�ƥ��
	private void checkBracketMatch() {
		if (extractCount(expression, "\\(") != extractCount(expression, "\\)"))
			errorMessage = "ERROR"  + "\r\n" + "#���Ų�ƥ��!";
		return;

	}

	// ����Ƿ��п�����
	private void checkEmptyBracket() {
		if (extractCount(expression, "\\(\\)") > 0) {
			errorMessage = "ERROR"  + "\r\n" + "#���ʽ���п�����!";
		}
	}

	// ������������
	private void checkSymbolDuplicate() {
		String regex = "[\\+\\-\\*\\/]{2}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(expression);

		if (matcher.find()) {
			errorMessage = "ERROR"  + "\r\n" + "#�����������";
		}
	}

	// ���������β�Ƿ��������
	private void checkHeadAndTail() {
		String regex = "^[\\*\\/\\+]|[\\+\\-\\*\\/]$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(expression);

		if (matcher.find()) {
			errorMessage = "ERROR"  + "\r\n" + "#The head and the tail of the expression is illegal!";
		}
	}

	// ���������Ƿ�Ϸ�
	private void checkOperand() {
		String regex = "\\([\\*\\/]|[\\*\\/\\+\\-]\\)|\\d\\(|\\)\\d";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(expression);

		if (matcher.find()) {
			errorMessage = "ERROR"  + "\r\n" + "#�������Ч!";
		}
	}

	// �����0��ͷ������������0005��00000
	private void checkZerosStart() {
		String regex = "0\\d+";// ƥ���������
		Pattern pattern = Pattern.compile(regex);// ����Pattern ����
		Matcher matcher = pattern.matcher(expression);// ����Matcher ����
		if (matcher.find()) {
			errorMessage = "ERROR"  + "\r\n" + "#Invalid Operand��";
		}
	}

	// �����ʽ�ַ������������Ӳ����ϲ�Ϊһ������
	public void checkExpression() {
		trimSpace();			//ȥ�����пո�
		checkIlegalChar();		//��Ч�ַ����
		checkBracketMatch();	//��������ƥ����
		checkEmptyBracket();	//�����ż��
		checkSymbolDuplicate();	//������������
		checkHeadAndTail();		//���ʽͷβ������
		checkOperand();			//������������
		checkZerosStart();		//0��ͷ����ֵ���
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}