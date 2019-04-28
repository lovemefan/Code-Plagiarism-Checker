
//���ʽ������
public class Deal {

	String RPN; // ��׺���ʽ
	double result; // ���ʽ������
	String nowResult; // ���ڼ���ı��ʽ�Ľ��
	Stack stack;	//Stack��
	Regex regex;	//Regex��
	DelSameExpression delSameExpression;	//DelSameExpression��

	// ���췽��
	public Deal() {
		RPN = "";
		result = 0.0;
		nowResult = "";
		stack = new Stack();
		delSameExpression = new DelSameExpression();
	}

	// �������������Ǳ��ʽ�����ս��
	public String dealExpression(String expression, String allResult) throws Exception {
		regex = new Regex(expression);
		// �Ա��ʽ����ɾ���հ��ַ�����
		expression = regex.cancelSpace();
		// ������ʽ��Ϊ��
		if (!expression.equals("")) {
			// ��������������Ĵ���
			expression = expression.replace("(-", "(0-");
			expression = expression.replace("(+", "(0+");
			expression = subOrAddStartExpression(expression);
			delSameExpression.delSE(expression);
			// ������ʽ��ȷ
			if (delSameExpression.deleteSame()) {
				allResult += "";
			} else if (regex.judgeAll()) {
				// ��ú�׺���ʽ
				RPN = stack.RPN(expression);
				// �ɺ�׺���ʽ����
				result = stack.calculateResult(RPN);
				// System.out.println(RPN);
				// System.out.println(result);
				// ���õ��Ľ�������ս��
				nowResult = expression + "=" + result + "\r\n";
				allResult += nowResult;
			} else {
				// ������ʽ����,¼�������Ϣ
				allResult += expression + "\r\n";
				allResult += "Error\r\n" + regex.getErrorMessage();
			}
		} else {
			// ������ʽ�ǿյģ�¼����ʽΪ����Ϣ
			allResult = allResult + "ERROR\n" + "#���ʽ�ǿյ�\r\n";
		}
		return allResult;
	}

	// �Ա��ʽ��ͷΪ�����ŵĴ���
	public String subOrAddStartExpression(String expression) {
		if (expression.charAt(0) == '-' || expression.charAt(0) == '+') {
			expression = '0' + expression;
		}
		return expression;
	}
}
