package simpleCalculator;

import java.util.regex.*;

public class Check {
	private String string;//�����洢����ı��ʽ

	Check() {

	}
//����������ʽ���жϱ��ʽ�Ƿ�������ȷ
	public boolean check(String string) {
		Pattern p = Pattern.compile("\\(\\)");
		Matcher m = p.matcher(string);
		if (m.find()) {
			this.string = string + "\nERROR\n#�����ţ�����";
			return false;
		}
		m = Pattern.compile("[\\+-/\\*]{2,}").matcher(string);
		if (m.find()) {
			this.string = string + "\nERROR\n#���������������������";
			return false;
		}
		m = Pattern.compile("\\d\\(").matcher(string);
		if (m.find()) {
			this.string = string + "\nERROR\n#\"(\"���ֱ������������,����֮��ȱ�ٲ�����������";
			return false;
		}
		m = Pattern.compile("\\)\\d").matcher(string);
		if (m.find()) {
			this.string = string + "\nERROR\n#\")\"�ұ�ֱ������������,����֮��ȱ�ٲ�����������";
			return false;
		}
		m = Pattern.compile("[-\\+/\\*]\\)|\\([-\\+/\\*]").matcher(string);
		if (m.find()) {
			this.string = string + "\nERROR\n#\"(\"�ұ߲���ֱ�������������,\")\"��߲���ֱ�������������������";
			return false;
		}
		m = Pattern.compile("[^\\d\\+\\-\\*\\/\\(\\)]").matcher(string);
		if (m.find()) {
			this.string = string + "\nERROR\n#���ʽ�к��зǷ��ַ�������";
			return false;
		}
		this.string = string;
		return true;
	}
//���ش�����ʽ
	public String getExpression() {
		return string;
	}

}
