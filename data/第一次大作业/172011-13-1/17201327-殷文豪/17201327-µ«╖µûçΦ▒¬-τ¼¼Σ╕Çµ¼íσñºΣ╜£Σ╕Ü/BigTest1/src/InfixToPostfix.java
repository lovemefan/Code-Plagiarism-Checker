
//��׺ת��׺��
public class InfixToPostfix {
	private String infix;//��׺���ʽ
	private String postfix = "";//��׺���ʽ
	
	//���췽��
	public InfixToPostfix() {
		
	}
	
	//���ع��췽��
	//String ��׺���ʽ
	public InfixToPostfix(String infix) {
		this.infix = infix;
	}
	
	//����infix
	public void setInfix(String infix) {
		this.infix = infix;
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
	
	//��������Ϊ0-���ľ���ֵ,ȡ��������Ӱ��,����һ���޸��������ַ���
	public String infixProcess() {
		String infix = "";
		//�Ը��ſ�ͷ
		if (this.infix.matches("\\-.*")) {
			infix = this.infix.replaceFirst("\\-", "0-");
		}
		if (this.infix.matches(".*(\\(\\-)+.*")) {
			//infixû���ֱ����0�����˾Ͷ��䱾�������0
			if (infix.equals("")) {
				infix = this.infix.replaceAll("\\(\\-", "(0-");
			}
			else {
				infix = infix.replaceAll("\\(\\-", "(0-");
			}
		}
		//infix����û���žͷ��ر���
		if (infix.equals("")) {
			infix += this.infix;
		}
		return infix;
	}
	
	//����׺���ʽ�ÿո������9*3���9 * 3 ��
	public String getNewInfix() {
		String result = "";
		//��������Ӱ��
		String infix = infixProcess();
		//�����ո��
		infix = infix.replaceAll(" ", "");
		for (int i = 0;i < infix.length() - 1;i ++) {
			//�ж������ֻ��Ƿ���
			if (isnumber(infix.charAt(i)) && isnumber(infix.charAt(i + 1))) {
				result += infix.charAt(i);
			}
			else {
				result += infix.charAt(i) + " ";
			}
		}
		//�ո�������Կո��β����׺���ʽ
		result += infix.charAt(infix.length() - 1) + " ";
		return result;
	}
	
	//��׺ת��׺,��ȡ��׺
	public String getPostfix() {
		String infix = getNewInfix();//��ô��������׺���ʽ
		Stack stack = new Stack();//������ջ
		for (int i = 0;i < infix.length();i ++) {
			switch (infix.charAt(i)) {
				case '(':
					Node newNode = new Node(infix.charAt(i),stack.getFirst());
					stack.setFirst(newNode);
					i ++;//�������������Ŀո�
					break;
				case ')':
					stack = postfix1(stack,i,infix);
					i ++;//�������������Ŀո�
					break;
				case '+':
				case '-':
					stack = postfix2(stack,i,infix);
					i ++;//�������������Ŀո�
					break;
				case '*':
				case '/':
					stack = postfix3(stack,i,infix);
					i ++;//�������������Ŀո�
					break;
				default :
					postfix += infix.charAt(i);
					break;
			}
		}
		//��ջ��ʣ��ķ������
		while (stack.getFirst() != null) {
			postfix += stack.getFirst().getChar();
			stack.setFirst(stack.getFirst().next);//��ջ
		}
		return postfix;
	}
	
	//getPostfix�Ĵ��룬�򻯴�����
	//stack ջ,i ѭ�����±�ֵ,infix ���ո����׺���ʽ
	public Stack postfix1(Stack stack,int i,String infix) {
		while (stack.getFirst().getChar() != '(') {
			postfix += stack.getFirst().getChar();
			stack.setFirst(stack.getFirst().next);//��ջ
		}
		stack.setFirst(stack.getFirst().next);//��ջ
		return stack;
	}
	
	//getPostfix�Ĵ��룬�򻯴�����
	//stack ջ,i ѭ�����±�ֵ,infix ���ո����׺���ʽ
	public Stack postfix2(Stack stack,int i,String infix) {
		//ջ����Ϊ�ս���ѭ��
		while (stack.getFirst() != null) {
			//�ж���������ȼ�������ջ��ջ
			if (stack.getFirst().getChar() == '(') {
				Node newNode = new Node(infix.charAt(i),stack.getFirst());
				stack.setFirst(newNode);//��ջ
				break;
			}
			postfix += stack.getFirst().getChar();
			stack.setFirst(stack.getFirst().next);//��ջ
		}
		//�ж�ջ��Ϊ��,����ֱ����ջ
		if (stack.getFirst() == null) {
			Node newNode = new Node(infix.charAt(i),stack.getFirst());
			stack.setFirst(newNode);//��ջ
		}
		return stack;
	}
	
	//getPostfix�Ĵ��룬�򻯴�����
	//stack ջ,i ѭ�����±�ֵ,infix ���ո����׺���ʽ
	public Stack postfix3(Stack stack,int i,String infix) {
		//ջ����Ϊ�ս���ѭ��
		while (stack.getFirst() != null) {
			//�ж���������ȼ�������ջ��ջ
			if (stack.getFirst().getChar() == '(' || 
					stack.getFirst().getChar() == '+' || stack.getFirst().getChar() == '-') {
				Node newNode = new Node(infix.charAt(i),stack.getFirst());
				stack.setFirst(newNode);//��ջ
				break;
			}
			postfix += stack.getFirst().getChar();
			stack.setFirst(stack.getFirst().next);//��ջ
		}
		//�ж�ջ��Ϊ��,����ֱ����ջ
		if (stack.getFirst() == null) {
			Node newNode = new Node(infix.charAt(i),stack.getFirst());
			stack.setFirst(newNode);//��ջ
		}
		return stack;
	}
	
}
