
public class Check {
	public int check(String exp) {

		if (exp.matches(".*(\\+\\+|\\+-|\\+/|\\+\\*|--|-\\+|-\\*|-/|\\*\\+|\\*-|\\*/|\\*\\*|/-|//|/\\+|/\\*).*")) {
			return 0;
		}
		if (exp.matches(".*(\\)\\d).*")) { // ���ұ������ֵ���� 
			return 1;
		}
		if (exp.matches(".*(\\d\\().*")) { // (��������ֵ����
			return 2;
		}

		if (exp.matches(".*(\\(\\)).*")) { // ƥ�������
			return 3;
		}

		if (exp.matches(".*(\\+\\)|\\*\\)|-\\)|/\\)).*")) { // ��������ߺ��������
			return 4;
		}

		if (exp.matches(".*(\\(-|\\(\\+|\\(/|\\(\\*).*")) {// �������ұ��������
			return 5;
		}
		if (!exp.matches("[\\+\\-\\*\\/\\(\\)\\d\\s]*")) { // �зǷ��ַ�
			return 6;
		}
		if (exp.matches(".*(/0).*")) {  //����Ϊ0
			return 7;
		}
		if (exp.matches(("(\\)|\\*|\\+|\\-|\\/).*"))) {  //���ַ����������Ż�����
			return 8;
		}
		if (exp.matches((".*(\\(|\\+|\\-|\\*|\\/)"))) {  //���ʽ������������Ż����ֽ�β
			return 9;
		}
		if (exp.matches("[\\S]*[)][(][\\S]*")) {   //�������ұ���������
			return 10;
		}

		return -1; 

	}
}
