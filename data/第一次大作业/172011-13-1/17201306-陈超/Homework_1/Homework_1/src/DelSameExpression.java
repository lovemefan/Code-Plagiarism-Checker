
public class DelSameExpression {

	private String[] expressions; // ��ס���б��ʽ���ַ�������
	private boolean isSame; // �Ƿ���ͬ��־
	private int index; // �ַ��������±�

	// ���췽��
	public DelSameExpression() {
		isSame = false;
		expressions = new String[9999];
		index = 0;
	}

	// �����ʽ��������
	public void delSE(String expression) {
		expressions[index] = expression;
		index++;
	}

	// �ж��Ƿ��ظ�
	public boolean deleteSame() {
		for (int i = 0; i < index - 1; i++) {
			isSame = expressions[i].equals(expressions[index - 1]);
			if (isSame == true) {
				break;
			}
		}
		return isSame;
	}
}
