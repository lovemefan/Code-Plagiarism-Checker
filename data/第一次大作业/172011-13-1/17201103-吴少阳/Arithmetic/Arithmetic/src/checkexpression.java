
public class checkexpression {
	public String check(String s) {
		int number = 0;// �������������ź������ŵĸ����Ƿ���ȣ��Դ��ж������Ƿ����
		int flag = 0;// ��������Ƿ���ַǷ��ַ�
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ')' && s.charAt(i) != '(' && s.charAt(i) != '*' && s.charAt(i) != '-'
					&& s.charAt(i) != '+' && s.charAt(i) != '/' && !(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
				flag = 1;// �����˷Ƿ��ַ�
			if (s.charAt(i) == ')')
				number--;
			else if (s.charAt(i) == '(')
				number++;
		}
		// ƥ����ַǷ��ַ������
		if (flag == 1)
			return "�����˷Ƿ��ַ�";
		// ƥ�����Ų���Ե����
		if (number != 0)
			return "���Ų����";
        //ƥ����������������
		if (s.matches("[\\S]*[+-/*/][+-/*/][\\S]*")) {
			return "���������";
		}
		// ƥ��(�ұ�������������
		if (s.matches("[\\S]*[(][/*+-][\\S]*")) {
			return "(�����������";
		}
		// ƥ��)�����+-*/�����
		if (s.matches("[\\S]*[+-/*/][)][\\S]*")) {
			return ")ǰ���������";
		}
		// ƥ��(ǰ��������������
		if (s.matches("[\\S]*[0-9][(][\\S]*")) {
			return "(ǰ�治�������";
		}
		// ƥ��)��������������
		if (s.matches("[\\S]*[)][0-9][\\S]*")) {
			return ")���治�������";
		}                                                                                
		// ƥ�������
		if (s.matches("[\\S]*[(][)][\\S]*")) {
			return "������";
		}
		// ƥ�����һ��������������
		if (s.matches("[\\S]*[+-/*[0-9]][+-/*][\\s]*")) {
			return "���һ���������";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
		}
		//ƥ�����Ϊ0�����
		if (s.matches("[\\S]*[/][0][\\S]*")){
			return "����Ϊ0";
		}
		// ƥ����ַ������
		if (s.length() == 0)
			return "���ַ���";
		else
			return "1";
	}
}


