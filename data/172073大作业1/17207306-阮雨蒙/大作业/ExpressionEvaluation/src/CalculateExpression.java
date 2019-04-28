//������ʽ��
public class CalculateExpression {
	private String expression;  //��������ѧ���ʽ
	
	//�޲ι��췽��
	public CalculateExpression(){
		
	}
	
	//�вι��췽��
	public CalculateExpression(String expression){
		this.expression = expression;
	}
	
	// ������ʽ��ֵ
	public float evaluate() {
		char[] tokens = expression.toCharArray(); // ת���ַ�����

		// ������ֵջ
		SqStack stackOfNum = new SqStack(1024);
		// �������ջ
		SqStack stackOfOps = new SqStack(1024);

		try {

			for (int i = 0; i < tokens.length; i++) {  //������ɨ����ʽ�ַ���

				if (tokens[i] >= '0' && tokens[i] <= '9') {
					StringBuffer sbuf = new StringBuffer();//�����洢��ֵ��Ӧ���ַ���

					//�������������ֱ�ʾһ�������������������345+4
					while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
						sbuf.append(tokens[i++]);
					}
					i--; // ����һλ����Ϊi��ֵ���++��һ��
					//����ֵ����ֵջ
					stackOfNum.push(Float.parseFloat(sbuf.toString()));
				}
				//������ֱ�������ջ
				else if (tokens[i] == '(')
					stackOfOps.push(tokens[i]);
				//�������򽫷���ջ����ֵջ��ջ��ֱ������ջ�е�������Ϊֹ�������м��㣬Ȼ������������ֵջ
				else if (tokens[i] == ')') {
					while (!stackOfOps.peek().toString().equals("("))
						stackOfNum.push(
								caculate((char) stackOfOps.pop(), (float) stackOfNum.pop(), (float) stackOfNum.pop()));
					stackOfOps.pop();//�����ų�ջ
				}
				//����ǼӼ��˳������
				else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
					//��Ҫ����ǰ����������ջ��ջ������������ȼ����бȽϣ�
					//�����ǰ��������ȼ����ڷ���ջջ������������ȼ�
					//�򽫷���ջ����ֵջ��ջ��ֱ������ջ�е�������Ϊֹ�������м��㣬Ȼ������������ֵջ
					while (!stackOfOps.isEmpty() && hasPriority(tokens[i], (char) stackOfOps.peek()))
						stackOfNum.push(
								caculate((char) stackOfOps.pop(), (float) stackOfNum.pop(), (float) stackOfNum.pop()));
					stackOfOps.push(tokens[i]);//��ǰ�����������ջ
				}
			}
			//ջ��Ϊ�գ������ջ����ֵջ���γ�ջ������
			while (!stackOfOps.isEmpty())
				stackOfNum.push(caculate((char) stackOfOps.pop(), (float) stackOfNum.pop(), (float) stackOfNum.pop()));
			//����������
			return (float) stackOfNum.pop();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	// �ж�����������Ƿ������ȼ����죬��op1���ȼ�<op2���ȼ�ʱ����true�����򷵻�false
	// С���Ų��������ȼ��Ƚ�
	public boolean hasPriority(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	// ������ʽ��ֵ��opΪ�������a��bΪ������
	public float caculate(char op, float b, float a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0) { // ��0�����
				throw new UnsupportedOperationException("Cannot divide by zero");
			}
			return a / b;
		}
		return 0;
	}
}