//�ж�����ʽ��

public class Judge {

	String s = "";

	Judge(String s) {
		this.s = s;// ���ʽ
	}

	// �д�
	public String check(String s) {
		int t = 0; // �����������
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')')
				t++;
			if (s.charAt(i) == '(')
				t--;
		}
		if (t != 0)
			return "ERROR\r\n#����������ƥ��";
		// ƥ�������
		if (s.matches("[\\S]*[(][)][\\S]*")) {
			return "ERROR\r\n#���ʽ�д��ڿ�����";
		}
		// ���������������� +++.
		if (s.matches("[\\S]*[+-/*/][+-/*/][+-/*/][\\S]*")) {
			return "ERROR\r\n#����������������";
		}
		// ����������������� ������ +- -- /- *-
		if (s.matches("[\\S]*[+-/*/][+/*/][\\S]*")) {
			return "ERROR\r\n#�����������������";
		}
		// ���ұ������ֵ����
		if (s.matches("[\\S]*[)][0-9][\\S]*")) {
			return "ERROR\r\n#���ʽ��)�ұ�������";
		}
		// �� ��������ֵ����
		if (s.matches("[\\S]*[0-9][(][\\S]*")) {
			return "ERROR\r\n#���ʽ��(���������";
		}
		// �� �ұ���*/�����
		if (s.matches("[\\S]*[(][/*/][\\S]*")) {
			return "ERROR\r\n#���ʽ��(�ұ��������";
		}
		if (s.matches("[\\S]*[)][(][\\S]*")) {
			return "ERROR\r\n#���ʽ��)�ұ���("; 
		}
		// ƥ�䣩�����+-*/�����
		if (s.matches("[\\S]*[+-/*/][)][\\S]*")) {
			return "ERROR\r\n#���ʽ��)����������";
		}
		// �����еĴ����ʽ����ƥ��ʱ����""
		return "";
	}

}


