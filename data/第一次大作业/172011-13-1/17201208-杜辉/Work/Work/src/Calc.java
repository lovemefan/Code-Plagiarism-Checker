//�����׺���ʽ
class Calc {
	String s = ""; // ��׺���ʽ
	Double[] integer = new Double[1005];// ջ
	Integer len; // ջ�ĳ���

	Calc(String s) {
		this.s = s;
		this.len = 0;

	}

	// ���������
	public Double calculation() {
		String[] strArr = s.split(" "); // �Կո���Ϊ�ָ������ַ�������
		// System.out.prIntegerln(s);
		for (Integer i = 0; i < strArr.length; i++) {
			String temp = strArr[i];

			// �ж��Ƿ������֣���������
			if (isDigital(temp)) {
				integer[++len] = (double) Integer.valueOf(temp);
			}
			// ����������ȡ��ջ��Ԫ�غ�ջ����һ��Ԫ�ؽ�������
			else {
				if (len >= 2) {
					Double result = calc(temp);
					integer[++len] = result; // �����ý������ջ��

				}
			}
		}
		return integer[len--];
	}

	private Double calc(String str) {
		Double re = 0.0; // �������ĳ�ʼ��
		Double m = integer[len--]; // ջ��Ԫ��
		Double n = integer[len--]; // ջ������һ��Ԫ��
		// ��ͬ�������
		switch (str) {
		case "+":
			re = n + m;
			break;
		case "-":
			re = n - m;
			break;
		case "*":
			re = n * m;
			break;
		case "/":
			re = n / m;
			break;
		default:
			break;
		}
		// System.out.prIntegerln(re);
		return re;
	}

	// �ж��Ƿ�������
	private boolean isDigital(String str) {
		Integer len = str.length();// �ַ����ĳ���
		// ����Ϊ1ʱֻ�жϵ�һλ
		if (len == 1 && Character.isDigit(str.charAt(0)))
			return true;
		// ����Ϊ2ʱ�жϵڶ�λ�ܿ����������
		else if (len > 1 && Character.isDigit(str.charAt(1)))
			return true;
		// ��������������ϵĻ��ͷ���false
		return false;

	}
}
