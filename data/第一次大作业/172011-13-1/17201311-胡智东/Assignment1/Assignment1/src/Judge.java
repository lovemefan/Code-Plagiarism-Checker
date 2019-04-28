import java.util.regex.*;

public class Judge {
	Suffix suffix;// ���ڵ�ȡת����׺����
	Compute compute;// ���ڵ�ȡ�����׺�ķ���
	String[] str;// �ļ��еı��ʽ
	String result = "";// ��������Ľ��
	String[] output = new String[1000];// ��������Ϣ�Ľ��������

	// Judge�Ĺ��췽��
	public Judge(String[] str) {
		this.str = str;
	}

	// ���б��ʽ�ĸ����ж��Լ�ת����ֵ
	public void Judge1() {
		for (int i = 0; str[i] != null; i++) {
			if (isEmptyString(str[i])) {
				printWrong(str[i], i, "���ڿձ��ʽ");
				continue;
			}
			result = str[i].replace(" ", "");
			result = result.replace("\t", "");
			result = firstchar(result);
			if (isrepeated(result, i)) {
				printWrong(str[i], i, "�����ظ����ʽ");
				continue;
			}

			if (isValid(result, i)) {
				result = result.replace("(-", "(0-");// ��0
				result = result.replace("(+", "(0+");
				suffix = new Suffix(result);
				suffix.process();
				compute = new Compute(suffix.post);
				compute.operate();
				printRight(str[i], i, compute.getResult());
			}
		}
	}

	// �жϱ��ʽ�Ƿ�Ϊ����
	public boolean isEmptyString(String str) {
		if (str.matches("^\\s*$")) {
			return true;
		} else {
			return false;
		}
	}

	// ���������Ϣ����output������
	public void printWrong(String wrongStr, int index, String wrongInformation) {
		output[index] = wrongStr + "\r\nERROR\r\n#" + wrongInformation;
	}

	// �ж��Ƿ����ظ��ı��ʽ
	public boolean isrepeated(String str1, int index) {
		for (int i = 0; i < index; i++) {
			if (str1.equals(str[i])) {
				return true;
			}
		}
		return false;
	}

	// ����������ʽ���б��ʽ�ж�
	public boolean isValid(String str, int index) {
		if (!bracketsMatch(str)) {// �ж��������������Ƿ�ƥ��
			printWrong(str, index, "��������������ƥ��");
			return false;
		}
		String mistakes[] = { "[^0-9\\+\\-\\/\\*\\(\\)]", "(\\(\\))", "(\\(\\*)", "(\\(\\/)",
				"[\\+\\-\\*\\/][\\+\\-\\*\\/]", "(\\+\\))", "(\\-\\))", "(\\*\\))", "(\\/\\))", "[\\d][\\(]",
				"[\\)][\\d]", "[\\+\\-\\*\\/]$" };
		String mistakesNew[] = { "���ڴ����ַ�", "���ڿ�����", "(����ֱ����*����", "(����ֱ����/����", "�����Ӧ����������", "+����ֱ����)����", "-����ֱ����)����",
				"*����ֱ����)����", "/����ֱ����)����", "���������Ӧ�������", "�������ұ�Ӧ�������", "�������������β" };
		for (int i = 0; i < mistakes.length; i++) {
			Pattern p = Pattern.compile(mistakes[i]);
			Matcher m = p.matcher(str);
			if (m.find()) {
				output[index] = str + "\r\nERROR\r\n#" + mistakesNew[i];
				return false;
			}
		}
		return true;
	}

	// �ж����������Ƿ�ƥ��
	public boolean bracketsMatch(String str) {
		int number = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				number++;
			} else if (str.charAt(i) == ')') {
				number--;
			}
		}
		if (number == 0) {
			return true;
		} else
			return false;
	}

	// ����ȷ�Ľ������output������
	public void printRight(String str, int index, double result) {
		String temp = str + "=" + result;
		output[index] = temp;
	}

	public String firstchar(String str) {
		if (str.charAt(0) == '-' || str.charAt(0) == '+') {
			str = "0" + str;
		}
		return str;
	}
}
