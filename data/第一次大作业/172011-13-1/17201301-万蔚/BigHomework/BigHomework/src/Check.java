import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// У���࣬�����ʽ�ĺϷ���
public class Check {
	// ���ʽ
	private String expression;
	// ������Ϣ
	private String error;
	// ���ʽ��ȷ��true��ȷ��false����
	private boolean legal;
	// ������ʽ
	private String[] regex = { "^$", "\\(\\)", "[\\+\\-\\*\\/]{2,}", "[^0-9\\+\\-\\*\\/\\(\\)]",
			"\\([\\*\\/]", "\\d\\(", "\\)\\d", "[\\+\\-\\*\\/]\\)", "[\\+\\-\\*\\/]$|^[\\*\\/]" };
	//������Ϣ
	private String[] errorInformation = { "����","������", "���������", "���зǷ��ַ�", "�����ź�˳������", 
			                              "������ǰ����", "�����ź�����", "������ǰ�����", "��β���ŷǷ�" };
	Pattern pattern;
	
	public Check(){
		
	}

	public Check(String str) {
		expression = str;
		legal = true;
		process();
	}

	// ���˿հ׷�
	private void filterSpace() {
		expression = expression.replaceAll("\\s", "");
	}

	// ���Ÿ����Ƿ�ƥ��
	private void legalOfBrackets() {
		pattern = Pattern.compile("[\\(\\)]");
		Matcher matcher = pattern.matcher(expression);
		String tmp = "";
		// ��������
		while (matcher.find()) {
			tmp += matcher.group();
		}
		// ����������
		while(tmp.contains("()")){
			tmp = tmp.replaceAll("\\(\\)", "");
		}
		if (tmp.equals("") == false) {
			legal = false;
			error = "���Ų�ƥ��";
		}
	}

	// ����ַ���
	public void process() {
		// ���˿հ׷�
		filterSpace();
		// ���Ÿ���У��
		legalOfBrackets();
		// �����ʽ����ȷ��
		for (int i = 0; i < regex.length && legal; ++i) {
			pattern = Pattern.compile(regex[i]);
			Matcher matcher = pattern.matcher(expression);
			if (matcher.find()) {
				legal = false;
				error = errorInformation[i];
			}
		}
	}

	// ������תΪ0-��������ʽ
	private void transform() {
		expression = expression.replaceAll("\\(\\-", "(0-");
		expression = expression.replaceAll("\\(\\+", "(0+");
		expression = expression.replaceAll("^\\+", "0+");
		expression = expression.replaceAll("^\\-", "0-");
	}

	// תΪ��׺
	public ArrayList<String> toInfix() {
		transform();
		ArrayList<String> str = new ArrayList<>();
		pattern = Pattern.compile("[\\+\\-\\*\\/\\(\\)]|\\d+");
		Matcher matcher = pattern.matcher(expression);
		while (matcher.find()) {
			str.add(matcher.group());
		}
		return str;
	}

	//��ȡ���ʽ
	public String getExpression() {
		return expression;
	}

	//��ȡ������Ϣ
	public String getError() {
		return error;
	}

	//��ȡ���ʽ�Ƿ�Ϸ�
	public boolean getLegal() {
		return legal;
	}

	//���ñ��ʽ�Ƿ�Ϸ�
	public void setLegal(boolean legal) {
		this.legal = legal;
	}
	
	//���ô�����Ϣ
	public void setError(String error) {
		this.error = error;
	}
}
