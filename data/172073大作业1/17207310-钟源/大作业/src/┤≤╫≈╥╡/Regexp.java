package ����ҵ;

public class Regexp {

	private String expression;//���ʽ

	//�������ʽ���췽��
	public Regexp(String expression) {
		this.expression = expression;

	}

	// ����ʽ�Ƿ���ȷ
	public boolean isTure(String expression) {
		boolean a1 = expression.matches(".*[\\+\\-\\*\\/]{2,}.*");// 1.���������
		boolean a2 = expression.matches(".*[\\+\\-\\*\\/][\\)]|[\\(][\\*\\/\\+\\-].*");// 2.������������Ż������ź��������
        boolean a3 = expression.matches("[\\+\\*\\/][\\d].*");// 5.��ͷΪ�����
		boolean a4 = expression.matches(".*[\\(][\\)].*");// 6.������
        boolean a5 = expression.matches("[^\\d]{1,}|[^\\+\\-\\*\\/]{1,}");// 8.û�����ֻ�û�������
        boolean a6 = expression.matches(".*[\\)][\\d]|[\\d][\\(].*");// 10.�����ź������ֻ����ֺ���������
        boolean a7 = expression.matches(".*[^\\d\\+\\-\\*\\/\\(\\)].*");// 12.�����ַ���Ƿ�����

		if (!a1 && !a2 && !a3 && !a4 && !a5 && !a6 && !a7)
			return true;
		else
			return false;

	}
	
   //�õ�����ԭ��
	  public String export(String expression) {
		boolean a1 = expression.matches(".*[\\+\\-\\*\\/]{2,}.*");// 1.���������
		boolean a2 = expression.matches(".*[\\+\\-\\*\\/][\\)]|[\\(][\\*\\/\\+\\-].*");// 2.������������Ż������ź��������
        boolean a3 = expression.matches("[\\+\\*\\/][\\d].*");// 5.��ͷΪ�����
		boolean a4 = expression.matches(".*[\\(][\\)].*");// 6.������
        boolean a5 = expression.matches("[^\\d]{1,}|[^\\+\\-\\*\\/]{1,}");// 8.û�����ֻ�û�������
        boolean a6 = expression.matches(".*[\\)][\\d]|[\\d][\\(].*");// 10.�����ź������ֻ����ֺ���������
        boolean a7 = expression.matches(".*[^\\d|^\\+|^\\-|^\\*|^\\/|^\\(|^\\)].*");// 12.�����ַ���Ƿ�����

		String isError = "";

		if (a1) {
			isError += "#���������";
		}

		if (a2) {
			isError += "#������������Ż������ź��������";

		}

		if (a3) {
			isError += "#��ͷΪ�����";

		}
		if (a4) {
			isError += "#������";

		}

		if (a5) {
			isError += "#û�����ֻ�û�������";

		}

		if (a6) {
			isError += "#�����ź������ֻ����ֺ���������";
		}

		if (a7) {
			isError += "#�����ַ���Ƿ�����";

		}

		return isError;

	}

}
