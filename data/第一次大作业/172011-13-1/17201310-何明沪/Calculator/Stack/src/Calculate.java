public class Calculate {// �����࣬������ʽ����
	LinkStack exp = null;// ���ʽ��������������
	LinkStack head = null;// ջ
	Filter filter = null;// ������
	private double num = 0;// ������

	public Calculate(String expString) {// ���췽���Ա��ʽ���кϷ��Լ��
		filter = new Filter(expString);// ����һ��������
		exp = filter.linkedExp();// �õ��淶��ı��ʽ
		compute();
	}

	private void calculate() {// ������ʽ��ֵ
		if (filter.getIsLegal() == false)// �Ϸ��Լ��
			return;
		head = new LinkStack();// ����һ��ջ
		Node tmp = exp.getHead().getNext();// ����һ���ڵ�ָ���׺���ʽ��ͷ
		while (tmp != null && filter.getIsLegal() == true) {// ������׺���ʽ����
			String s = tmp.getData();// ��ȡ�����е�ÿ���ַ���
			if (s.matches("[\\+\\-\\*\\/]")) {// ������ʽƥ�����
				double num2 = Double.valueOf(head.pop().getData());// ��ջ
				double num1 = Double.valueOf(head.pop().getData());// ��ջ
				plugSigns(s, num1, num2);// ����Ӻ�
				minusSigns(s, num1, num2);// �������
				mulSigns(s, num1, num2);// ����˺�
				divisionSigns(s, num1, num2);// ������ţ���������Ϊ0
				head.push(new Node(String.valueOf(num)));// ��������ջ
			} else {
				head.push(new Node(tmp.getData()));// ������ջ
			}
			tmp = tmp.getNext();// ָ����һ���ڵ�
		}
	}

	private void plugSigns(String s, double num1, double num2) {// ����Ӻ�
		if (s.matches("\\+")) {
			num = num1 + num2;
		}
	}

	private void minusSigns(String s, double num1, double num2) {// �������
		if (s.matches("\\-")) {
			num = num1 - num2;
		}
	}

	private void mulSigns(String s, double num1, double num2) {// ����˺�
		if (s.matches("\\*")) {
			num = num1 * num2;
		}
	}

	private void divisionSigns(String s, double num1, double num2) {// �������
		if (s.matches("\\/")) {
			if (num2 == 0) {// ����Ϊ0�Ĵ���
				filter.setErrorString("ERROR\n#The divisor can't be zero");
				filter.setLegal(false);
				return;
			}
			num = num1 / num2;
		}
	}

	private void toPostList() {// ����׺���ʽת��Ϊ��׺���ʽ
		if (filter.getIsLegal() == false)// ������ʽ���Ϸ�ֱ���˳�
			return;
		head = new LinkStack();// ����ջ
		LinkStack tmpExp = new LinkStack();// ����������ź�׺���ʽ
		Node tmp = exp.getHead().getNext();// ������׺���ʽ�ڵ�
		while (tmp != null) {// �������ʽ������ͬ�����ϲ�
			plugOrMinusSigns(tmpExp, tmp);// �жϼӼ���
			mulOrDivSigns(tmpExp, tmp);// �жϳ˳���
			leftBracket(tmpExp, tmp);// �ж�������
			rightBracket(tmpExp, tmp);// �ж�������
			nums(tmpExp, tmp);// �ж�����
			tmp = tmp.getNext();// ָ����һ���ڵ�
		}
		while (head.isEmpty() == false) {// ��ջ��ʣ�����ȫ����ջ
			tmpExp.addNode(head.pop());
		}
		exp = tmpExp;// ���غ�׺���ʽ
	}

	private void plugOrMinusSigns(LinkStack tmpExp, Node tmp) {// ����Ӽ���
		if (tmp.getData().equals("+") || tmp.getData().equals("-")) {
			// ���ջ��Ϊ���Ҳ�Ϊ������
			while (head.isEmpty() == false && head.top().equals("(") == false) {
				tmpExp.addNode(head.pop());// ��ջ����׺���ʽ��
			}
			head.push(new Node(tmp.getData()));// ������ջ
		}
	}

	private void mulOrDivSigns(LinkStack tmpExp, Node tmp) {// ����˳���
		if (tmp.getData().equals("*") || tmp.getData().equals("/")) {
			// ���ջ���������ȼ����ڵ��ڸ÷����������ջ
			while (head.isEmpty() == false && (head.top().equals("*") || head.top().equals("/"))) {
				tmpExp.addNode(head.pop());
			}
			head.push(new Node(tmp.getData()));// ������ջ
		}
	}

	private void leftBracket(LinkStack tmpExp, Node tmp) {// ����������
		if (tmp.getData().equals("(")) {// ������ֱ����ջ
			head.push(new Node(tmp.getData()));
		}
	}

	private void rightBracket(LinkStack tmpExp, Node tmp) {// ����������
		if (tmp.getData().equals(")")) {
			while (head.top().equals("(") == false) {// ������ջֱ������������
				tmpExp.addNode(head.pop());
			}
			head.pop();// �����ų�ջ����
		}
	}

	private void nums(LinkStack tmpExp, Node tmp) {// ��������
		if (tmp.getData().charAt(0) >= '0' && tmp.getData().charAt(0) <= '9') {
			num = Double.valueOf(tmp.getData());
			tmpExp.addNode(new Node(tmp.getData()));
		}
	}

	private void compute() {
		toPostList();// ת��Ϊ��׺���ʽ
		calculate();// ������ʽ
	}

	public String printExp() {// ��ӡ���ʽֵ
		if (filter.getIsLegal()) {// ����Ϸ�������ʽ���
			String str = filter.getFinalString() + "=" + num;
			return str;
		}
		return null;
	}

	public double getNum() {
		return num;
	}
	
}
