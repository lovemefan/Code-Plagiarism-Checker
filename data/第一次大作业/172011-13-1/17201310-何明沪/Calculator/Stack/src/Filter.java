import java.util.regex.Matcher;
import java.util.regex.Pattern;

// ɸѡ��,�����ʽ����ȷ��
public class Filter {
	private String errorString;// ������Ϣ

	private String finalString;// ��Ҫ�����ַ���

	private String regularString;// �淶�ı��ʽ

	private boolean isLegal;// ���ʽ�Ƿ�Ϸ�

	public boolean getIsLegal() {// ������isLegal
		return isLegal;
	}

	public String getFinalString() {// ������FinalString
		return finalString;
	}

	public Filter() {// �޲ι���
		finalString = "";
		setRegularString("");
		isLegal = true;
		errorString = "";
	}

	public Filter(String str) {// ����ΪҪ�����ַ������еĹ��췽��
		finalString = str;
		setRegularString("");
		isLegal = true;
	}

	private void checkIlegalCharacter() {// ����Ƿ����޹��ַ�
		if (isLegal == false) {// ����Ƿ�Ϸ�
			return;
		}
		if (finalString.length() == 0) {// ����Ϊ�մ�
			errorString = "ERROR\n#The expression is empty";
			isLegal = false;
			return;
		}

		// ������ʽƥ��հ׷��������Ʊ�����ո񣬷�ҳ���ȣ������֡��ӡ������ˡ���������ַ�
		String regexError = "[^0-9\\(\\)\\+\\-\\*\\/\\s]";
		Pattern pattern = Pattern.compile(regexError);
		Matcher matcher = pattern.matcher(finalString);

		if (matcher.find()) {// �����޹��ַ�
			errorString = "ERROR\n#The expression contains illegal characters";
			isLegal = false;
			return;
		}
	}

	private void filterSpace() {// ���˿հ׷�
		if (isLegal == false) {// ����Ƿ�Ϸ�
			return;
		}
		String s = "";// ��ʼ���ַ��������ַ�������������˺���ַ���

		// ������ʽƥ��հ׷�
		String regexSpace = "[^\\s]";
		Pattern pattern = Pattern.compile(regexSpace);
		Matcher matcher = pattern.matcher(finalString);

		while (matcher.find()) {// ������һ��ƥ���������
			s += matcher.group();
		}
		finalString = s;// ���ش������ַ���
	}

	private void checkBracket() {// ��������Ƿ�ƥ��
		if (isLegal == false) {// ����Ƿ�Ϸ�
			return;
		}
		int bracketCnt = 0;// ��¼��ƥ�������Ÿ���
		for (int i = 0; i < finalString.length(); ++i) {// ����ÿ������
			if (finalString.charAt(i) == '(') {// �����Ÿ�����1
				++bracketCnt;
			}
			if (finalString.charAt(i) == ')') {// �����Ÿ�����1
				--bracketCnt;
			}
			if (bracketCnt < 0) {// �����������Ŷ࣬���Ϸ�
				isLegal = false;
				errorString = "ERROR\n#Bracket mismatch";
				return;
			}
		}
		if (bracketCnt != 0) {// �����ű������Ŷ࣬���Ϸ�
			isLegal = false;
			errorString = "ERROR\n#Bracket mismatch";
		}
	}

	private void checkEmptyBracket() {// ����Ƿ��п�����
		if (isLegal == false) {// ����Ƿ�Ϸ�
			return;
		}
		// ������ʽƥ��һ�Կ�����
		String regexEmptySpace = "(\\(\\))";
		Pattern pattern = Pattern.compile(regexEmptySpace);
		Matcher matcher = pattern.matcher(finalString);
		if (matcher.find()) {// ��������
			isLegal = false;
			errorString = "ERROR\n#The expression contains a pair of empty bracket";
		}
	}

	private void checksSigns() {// ����������
		if (isLegal == false) {// ����Ƿ�Ϸ�
			return;
		}

		// ƥ��˺Ż�����Ƿ�Ϸ�
		String regex = "[\\+\\-\\*\\/]{2}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(finalString);

		if (matcher.find()) {// ����������
			errorString = "ERROR\n#The expression contains a continuous operational symbol";
			isLegal = false;
		}
	}

	private void checkLine() {// ���������β�Ƿ��������
		if (isLegal == false) {// ����Ƿ�Ϸ�
			return;
		}

		// ƥ�����׺���β
		String regex = "^[\\*\\/]|[\\+\\-\\*\\/]$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(finalString);

		if (matcher.find()) {// ��������
			errorString = "ERROR\n#The first or last character of the expression is illegal";
			isLegal = false;
		}
	}

	private void checkTwoSides() {// �������������Ƿ�Ϸ�
		if (isLegal == false) {// ����Ƿ�Ϸ�
			return;
		}

		// ƥ�����������
		String regex = "\\([\\*\\/]|[\\*\\/\\+\\-]\\)|\\d\\(|\\)\\d";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(finalString);

		if (matcher.find()) {// ��������
			errorString = "ERROR\n#The operator is illegal";
			isLegal = false;
		}
	}

	private void completeNum() {// ����������һ��0��ǰ�棬�ñ��ʽ�����������
		if (isLegal == false)// ����Ƿ�Ϸ�
			return;
		String regex = "^[\\+\\-][\\d|\\(]";// ƥ������������
		Pattern pattern = Pattern.compile(regex);// ����Pattern ����
		Matcher matcher = pattern.matcher(finalString);// ����Matcher ����
		int i = 0;// ��¼�ַ�����λ��
		if (matcher.find()) {// �����һ���������������Ҳ������ž���ǰ�油һ��0
			for (; i < matcher.start(); ++i) {
				setRegularString(getRegularString() + finalString.charAt(i));
			}
			setRegularString(getRegularString() + "0");
		}
		regex = "\\([\\+\\-]";// ƥ��������֮���������
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(finalString);
		while (matcher.find()) {// ���ϲ���������
			for (; i < matcher.start() + 1; ++i) {// ��������֮ǰ���ַ����������ַ���
				setRegularString(getRegularString() + finalString.charAt(i));
			}
			setRegularString(getRegularString() + "0");// ������ǰ����һ��0
		}
		for (; i < finalString.length(); ++i) {// ��ʣ���ַ����������ַ���
			setRegularString(getRegularString() + finalString.charAt(i));
		}
	}

	/*
	 * private void checkZeros() {// �����0��ͷ����012��00 if (isLegal == false)//
	 * ����Ƿ�Ϸ� return; String regex = "0\\d+";// ƥ��������� Pattern pattern =
	 * Pattern.compile(regex);// ����Pattern ���� Matcher matcher =
	 * pattern.matcher(finalString);// ����Matcher ���� if (matcher.find()) {// ��������
	 * isLegal = false; errorString = "ERROR#\nInvalid token"; } }
	 */

	private void checkString() {// ����ַ����У��������Ӳ����ϲ�Ϊ��������
		filterSpace();// ���˿հ׷�

		checkIlegalCharacter();// ����Ƿ����޹��ַ�

		checkBracket();// ��������Ƿ�ƥ��

		checkEmptyBracket();// ����Ƿ��п�����

		checkLine();// ����ʽ����β�Ƿ�Ϸ�

		checksSigns();// ���������Ƿ�����

		checkTwoSides();// ���"("�������ֺ�")"�����֣�")"���������

		completeNum();// �淶���ʽ
	}

	public LinkStack linkedExp() {// ����Ϸ�����һ����׺���ʽ������Ϊ��
		checkString();// �ȼ�������Ƿ�Ϸ�
		LinkStack exp = new LinkStack();// ����һ�����������洢��׼����׺���ʽ
		if (isLegal == false)// ������ʽ������Ҫ���򷵻ؿ�
			return exp;

		// �����ʽ�е����ֺ��ַ���ֳ���
		String regex = "[\\+\\-\\*\\/\\(\\)]|\\d+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(regularString);
		while (matcher.find()) {// ���ϲ�������
			exp.addNode(new Node(matcher.group()));
		}

		return exp;// ������׺���ʽ
	}

	public String getRegularString() {
		return regularString;
	}

	public void setRegularString(String regularString) {
		this.regularString = regularString;
	}

	public void setLegal(boolean isLegal) {
		this.isLegal = isLegal;
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}
}