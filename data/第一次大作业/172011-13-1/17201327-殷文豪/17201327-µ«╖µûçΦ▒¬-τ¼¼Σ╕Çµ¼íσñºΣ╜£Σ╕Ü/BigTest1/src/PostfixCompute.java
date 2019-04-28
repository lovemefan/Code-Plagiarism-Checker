
//��׺������
public class PostfixCompute {
	private InfixToPostfix deal = new InfixToPostfix();
	private Stack stack = new Stack();//���������ջ

	//���췽��
	public PostfixCompute() {
		
	}
	
	//���ع��췽��
	//String ��׺���ʽ
	public PostfixCompute(String infix) {
		this.deal.setInfix(infix);
	}
	
	//��ȡdeal
	public InfixToPostfix getDeal() {
		return deal;
	}
	
	//��ü�����
	public double getResult() {
		return compute();
	}
	
	//�ж��ַ��Ƿ�������
	//ch �ַ�
	public boolean isnumber(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		}
		else {
			return false;
		}
	}
	
	//���ؼ�����
	public double compute() {
		String postfix = deal.getPostfix();
		for (int i = 0;i < postfix.length();i ++) {
			String numbers = "";//Ҫ��ջ�������ַ���
			while (isnumber(postfix.charAt(i))) {
				numbers += postfix.charAt(i);
				i ++;
			}
			//Ҫ��ջ���ַ�����ΪΪ��
			if (!numbers.equals("")){
				Node newNode = new Node(numbers,stack.getFirst());
				stack.setFirst(newNode);
			}
			if (!isnumber(postfix.charAt(i)) && postfix.charAt(i) != ' ') {
				compute1(i,postfix);
			}
		}
		//��ջ�����Ľ����ջ
		double result = Double.parseDouble(stack.getFirst().getStr());
		stack.setFirst(stack.getFirst().next);
		return result;
	}
	
	//�����һ���ִ���
	//i ѭ�����±�,postfix ��׺���ʽ
	public void compute1(int i,String postfix) {
		//ջ��ǰ�����ڵ��ջ,ת��Ϊdouble������������
		double r1 = Double.parseDouble(stack.getFirst().getStr());
		stack.setFirst(stack.getFirst().next);
		double r2 = Double.parseDouble(stack.getFirst().getStr());
		double r3 = 0;//�����洢������
		switch (postfix.charAt(i)) {
		case '+' :
			r3 = r2 + r1;
			break;
		case '-' :
			r3 = r2 - r1;
			break;
		case '*' :
			r3 = r2 * r1;
			break;
		case '/' :
			r3 = r2 / r1;
			break;
		
		}
		//����ջ��Ԫ��Ϊ������ֵ
		stack.getFirst().setStr("" + r3);;
	}
}
