package jsq;
import java.util.regex.*;;
public class Verdict {
	String s = "";

	Verdict(String s) {
		s = s.replaceAll(" ", "");//ɾ�����ʽ�еĿո�
		this.s = s;// ���ʽ
	}
	//�д�
	public static String check(String s) {
		int t = 0; //�����������
		for (int i = 0;i <s.length()-1;i++)
		{
			if (s.charAt(i)!=')'&&s.charAt(i)!='('&&s.charAt(i)!='+'&&s.charAt(i)!='-'&&s.charAt(i)!='*'&&s.charAt(i)!='/'&&(s.charAt(i)<'0'||s.charAt(i)>'9'))
				return "error: ���ʽ�г����˷Ƿ��ַ�";
			if (s.charAt(i)==')')
				t++;
			if (s.charAt(i)=='(')
				t--;
		}
		
		if (t!=0)
				return "error: ����������ƥ��";
		
		// ƥ�������
		if (s.matches("[\\S]*[(][)][\\S]*")) {
			return "error: ���ʽ�д��ڿ�����";
		}
		// ���������������� +++.
		if (s.matches("[\\S]*[+-/*/][+-/*/][+-/*/][\\S]*")) {
			return "error: ����������������";
		}
		// ����������������� ������ +- -- /- *-
		if (s.matches("[\\S]*[+-/*/][+/*/][\\S]*")) {
			return "error: �����������������";
		}
		// ���ұ������ֵ����
		if (s.matches("[\\S]*[)][0-9][\\S]*")) {
			return "error: ���ʽ��)�ұ�������";
		}
		// �� ��������ֵ����
		if (s.matches("[\\S]*[0-9][(][\\S]*")) {
			return "error: ���ʽ��(���������";
		}
		// �� �ұ���*/�����
		if (s.matches("[\\S]*[(][/*/][\\S]*")) {
			// System.out.println(s);
			return "error: ���ʽ��(�ұ��������";
		}
		// ƥ�䣩�����+-*/�����
		if (s.matches("[\\S]*[+-/*/][)][\\S]*")) {
			return "error: ���ʽ��)����������";
		}
		if (s.length()>1){
			if (s.charAt(0)==')'||s.charAt(0)=='+'||s.charAt(0)=='-'||s.charAt(0)=='*'||s.charAt(0)=='/')
				return "error: ���ʽ�������λ�ַ����Ϸ�";
			if (s.charAt(s.length()-2)=='('||s.charAt(s.length()-2)=='+'||s.charAt(s.length()-2)=='-'||s.charAt(s.length()-2)=='*'||s.charAt(s.length()-2)=='/')
				return "error: ���ʽ�����ĩλ�ַ����Ϸ�";
			}
		// �����еĴ����ʽ����ƥ��ʱ����""
		return "";
	}

}
