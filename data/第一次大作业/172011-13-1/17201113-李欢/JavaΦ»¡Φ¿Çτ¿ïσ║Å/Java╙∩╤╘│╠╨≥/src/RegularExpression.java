
public class RegularExpression {

	public RegularExpression() {

	}

	public String check(String x) {//�жϱ��ʽ�Ƿ�淶�����淶���򷵻�true�����򷵻س�����Ϣ��

		if (x.matches(".*(\\+\\+|\\+-|\\+\\*|\\+/|-\\+|--|-\\*|-/|\\*\\+|\\*-|\\*\\*|\\*/|/\\+|/-|/\\*|//).*")) {
			return "ERROR" + "\r\n" + "#�������������";
		} else if (x.matches(".*(\\(\\)).*")) {
			return "ERROR" + "\r\n" + "#������";
		}

		else if (x.matches(".*(\\+\\)|\\-\\)|\\*\\)|\\/\\)|\\(\\+|\\(\\-|\\(\\*|\\(\\/).*")) {
			return "ERROR" + "\r\n" + "#������������������";
		}

		else if (x.matches(".*(/0).*")) {
			return "ERROR" + "\r\n" + "#����Ϊ0";
		}

		else if (!x.matches(".*(\\+|\\-|\\*|\\/|\\d|\\s|\\(|\\)).*")) {
			return "ERROR" + "\r\n" + "#�Ƿ��ַ�";
		}

		else if (x.matches(".*(\\d\\(|\\)\\d).*")) {
			return "ERROR" + "\r\n" + "#������ǰ�������ֻ��������ź���������";
		}

		else if (x.matches("(\\)|\\*|\\+|\\-|\\/).*")) {
			return "ERROR" + "\r\n" + "#��һ���ַ��������ֻ���������";
		}

		else if (x.matches(".*(\\(|\\+|\\-|\\*|\\/)")) {
			return "ERROR" + "\r\n" + "#���һ���ַ��������ֻ���������";
		} else if (x.matches("[\\S]*[)][(][\\S]*")) {
			return "ERROR" + "\r\n" + "#�����ź���ֱ������������";
		}

		else {
			return "right";
		}

	}

	public static int MP(String x) {//�жϱ��ʽ���������������Ƿ�ƥ��
		int m = 0; // ��¼(�ĸ���
		int n = 0; // ��¼)�ĸ���
		for (int i = 0; i < x.length(); i++) {
			char c = x.charAt(i);
			if (c == '(') {
				m++;
			} else if (c == ')') {
				n++;
			}
		}
		if (m == n) {
			return 1;
		} else {
			return 2;
		}
	}
}
