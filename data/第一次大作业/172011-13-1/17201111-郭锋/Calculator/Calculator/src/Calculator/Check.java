package Calculator;

public class Check {
	String s;
	String a;
	public boolean check(String s){
		//ƥ��Ƿ��ַ�
		
		if(!s.matches("[\\+\\-\\*\\/\\(\\)\\d\\s]*")) {
			a = "ERROR:\r\n #���ʽ�ں��Ƿ��ַ�";
			return true;
		}
		//ƥ���ĸΪ0
		if(s.matches("[\\S]*[/][0][\\S]*")){
			a = "ERROR:\r\n #���ʽ�з�ĸΪ��";
			return true;
		}
		// ƥ�������
		if (s.matches("[\\S]*[(][)][\\S]*")) {
			a = "ERROR:\r\n #���ʽ�д��ڿ�����";
			return true;
		}
		if (s.matches("[\\S]*[)][(][\\S]*")) {
			a = "ERROR: \r\n #���ʽ�������ź�����������";
			return true;
		}
		// ���������������� +++.
		if (s.matches("[\\S]*[+-/*][+-/*][+-/*][\\S]*")) {
			a = "ERROR: \r\n #����������������";
			return true;
		}
		// ����������������� 
		if (s.matches("[\\S]*[+-/*][+-/*][\\S]*")) {
			a =  "ERROR: \r\n #�����������������";
			return true;
		}
		// ���ұ������ֵ����
		if (s.matches("[\\S]*[)][0-9][\\S]*")) {
			a = "ERROR:\r\n #���ʽ��)�ұ�������";
			return true;
		}
		// �� ��������ֵ����
		if (s.matches("[\\S]*[0-9][(][\\S]*")) {
			a =  "ERROR:\r\n #���ʽ��(���������";
			return true;
		}
		// �� �ұ���*/�����
		if (s.matches("[\\S]*[(][/*/][\\S]*")) {
			a =  "ERROR: \r\n#���ʽ��(�ұ��������";
			return true;
		}
		// ƥ�䣩�����+-*/�����
		if (s.matches("[\\S]*[+-/*/][)][\\S]*")) {
			a =  "ERROR:\r\n #���ʽ��)����������";
			return true;
		}
		if (s.length()>1){
			if (s.charAt(0)==')'||s.charAt(0)=='+'||s.charAt(0)=='-'||s.charAt(0)=='*'||s.charAt(0)=='/'){
				a =  "ERROR: ���ʽ�������λ�ַ����Ϸ�";
				return true;
			}
			if (s.charAt(s.length()-1)=='('||s.charAt(s.length()-1)=='+'||s.charAt(s.length()-1)=='-'||s.charAt(s.length()-1)=='*'||s.charAt(s.length()-1)=='/'){
				a = "ERROR: #���ʽ�����ĩλ�ַ����Ϸ�";
			    return true;
			}
				
		}
		return false;

	}

}
