import java.util.ArrayList;

public class Check {
	static String check(String str) {
		Calcalute c1 = new Calcalute();
		boolean m1 = str.matches("[0-9\\+\\-\\*\\/\\(\\)]*");// ���зǷ��ַ�
		boolean m2 = str.matches("(.*)[0-9]\\((.*)");// ȱ�ٲ����������������ȱ�ٲ�����
		boolean m3 = str.matches("(.*)\\)[0-9](.*)");// ȱ�ٲ��������������ұ�ȱ�ٲ�����
		boolean m4 = str.matches("(.*)\\([\\*+-/](.*)");// ȱ�ٲ��������������ұ�ȱ�ٲ�����
		boolean m5 = str.matches("(.*)[\\*+-/]\\)(.*)");// ȱ�ٲ����������������ȱ�ٲ�����
		boolean m6 = str.matches("(.*)\\(\\)(.*)");// �����ţ��������ޱ��ʽ
		boolean m7 = str.matches("(.*)[\\*+-/][\\*+-/](.*)");// �����ȱ�ٲ�����
		boolean m8 = str.matches("[\\+\\-\\*\\/](.*)");// �ַ������ַ�Ϊ������
		boolean m9 = str.matches("(.*)[\\+\\-\\*\\/]");// �ַ���β�ַ�Ϊ������
		boolean m10=judge(str);
		if (m1 == false) {
			return str + "  #ERROR ���зǷ��ַ�";
		} else if (m2 == true) {
			return str + "  #ERROR ���������ȱ�ٲ�����";
		} else if (m3 == true) {
			return str + "  #ERROR �������ұ�ȱ�ٲ�����";
		} else if (m4 == true) {
			return str + "  #ERROR �������ұ�ȱ�ٲ�����";
		} else if (m5 == true) {
			return str + "  #ERROR ���������ȱ�ٲ�����";
		} else if (m6 == true) {
			return str + "  #ERROR ������û�б��ʽ";
		} else if (m7 == true) {
			return str + "  #ERROR �����ȱ�ٲ�����";
		} else if (m8 == true) {
			return str + "  #ERROR �ַ������ַ�Ϊ������";
		} else if (m9 == true) {
			return str + "  #ERROR �ַ���β�ַ�Ϊ������";
		} else if(m10==false){
			return str + "  #ERROR ���Ų�ƥ��";
		}
		else {
			ArrayList result = c1.getStringList(str);
			ArrayList result1 = c1.getPostOrder(result);
			int sum = c1.calculate(result1);
			return str + "=" + sum;

		}
	}

	private static boolean judge(String str) {
		Calcalute c1 = new Calcalute();
		int sum=0;
		boolean end=true;
		ArrayList result = c1.getStringList(str);
		for(int i=0;i<result.size();i++){
			if(result.get(i).equals("(")){
				sum=sum+1;
			}else if(result.get(i).equals(")")){
				sum=sum-1;
			}
		}
		if(sum==0){
			return true; 
		}else{
		return false;
		}
	}

}
