//�ж��� �ж�����ı��ʽ�Ƿ���ȷ
class CheckFormat {
	String s = "";
	String ans = null;

	CheckFormat(String s) {
		this.s = s;// ���ʽ
	}

	public String check() {
		// ƥ������������������� ������ +- -- /- *-
		if (s.matches("[\\S]*[+\\-/*/][+\\-/*/][\\S]*")) {
			ans = "ERROR\n"
					+ "#�����������������";

		}
		if(s.matches("[\\S]*[^0-9+\\-/*/()][\\S]*")){
			ans = "ERROR\n"
					+ "#���ʽ�к��Ƿ��ַ�";
		}
		if (s.matches("[\\S]*[+\\-/*/]")) {
			ans = "ERROR\n"
					+ "#���ʽ��������ұ�û������";
		}if (s.matches("[+/*/][\\S]*")) {
			ans = "ERROR\n"
					+ "#���ʽ����������û������";
		}
		// ƥ�䣩�ұ������ֵ����
		if (s.matches("[\\S]*[)][0-9][\\S]*")) {
			ans = "ERROR\n"
					+ "#���ʽ��)�ұ߲���������";

		}
		// ƥ�䣨��������ֵ����
		if (s.matches("[\\S]*[0-9][(][\\S]*")) {
			ans = "ERROR\n"
					+ "#���ʽ��(��߲���������";
			// return true;
		}
		// ƥ�䣨�ұ���*/�����
		if (s.matches("[\\S]*[(][/*/][\\S]*")) {
			// System.out.println(s);
			ans = "ERROR\n"
					+ "#���ʽ��(�ұ߲�����*������/";
			// return true;
		}
		// ƥ�䣩�����+-*/�����
		if (s.matches("[\\S]*[+\\-/*/][)][\\S]*")) {
			ans = "ERROR\n"
					+ "#���ʽ��)��߲����������";
			// return true;
		}
		// ƥ�������
		if (s.matches("[\\S]*[(][)][\\S]*")) {
			ans = "ERROR\n"
					+ "#���ʽ�д��ڿ�����";
			// return true;
		}
		// �����еĴ����ʽ����ƥ��ʱ����null
		return ans;
	}
}
