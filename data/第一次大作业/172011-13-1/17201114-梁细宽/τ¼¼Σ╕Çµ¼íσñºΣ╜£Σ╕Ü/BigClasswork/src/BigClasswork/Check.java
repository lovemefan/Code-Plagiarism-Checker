package BigClasswork;

public class Check {
	private String expression;// �����жϵı��ʽ

	public Check() {

	}

	public Check(String expression) {
		this.expression = expression;
	}

	public int check() {
		String[] str = { ".*(\\+\\+|\\+-|\\+/|\\+\\*|--|-\\+|-\\*|-/|\\*\\+|\\*-|\\*/|\\*\\*|/-|//|/\\+|/\\*).*",
				".*(\\)\\d).*", ".*(\\d\\().*", ".*(\\(\\)).*", ".*(\\+\\)|\\*\\)|-\\)|/\\)).*",
				".*(\\(-|\\(\\+|\\(/|\\(\\*).*", ".*(/0).*", "[\\+\\-\\*\\/\\)\\s].*", ".*[\\+\\-\\*\\/]",
				"[\\S]*[)][(][\\S]*" };
		// String[] message =
		// {"�������������","���ұ������ֵ����","(��������ֵ����","ƥ�������","��������ߺ��������","�������ұ��������","����������0","��һ��Ϊ�����","�Է��Ž�β",")(����"};
		for (int i = 0; i < str.length; i++) {
			if (expression.matches(str[i])) {
				return i + 1;
			}
		}
		if (!judge(expression)) {// �������
			return 11;
		} else if (!expression.matches("[\\+\\-\\*\\/\\(\\)\\d\\s]*")) {// ƥ��Ƿ��ַ�
			return 12;
		} else {
			return 0; // �����еĴ����ʽ����ƥ��ʱ������
		}

	}

	// �ж��������ŵĸ����Ƿ�һ��
	public static boolean judge(String expression) {
		int i1 = 0;
		int i2 = 0;

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '(') {
				i1++;
			} else if (ch == ')') {
				i2++;
			}
		}

		return i1 == i2;
	}

}
