package Project;

public class toPost {
	
	//���췽��
		public  toPost(){
			
		}

	// ת�����ʽ
	public String toPost(String infix) throws Exception {
		Stack stack = new Stack();// ������ջ
		String suffix = "";// ��ź�׺���ʽ
		int length = infix.length();// �ַ�������
		for (int i = 0; i < length; i++) {
			char c = infix.charAt(i);
			switch (c) {
			case ' ':
				break;
			case '(':
				stack.push(String.valueOf(c));
				break;
			case '+':
			case '-':
				suffix = addSubOp(stack, suffix, c);// ����addSubOp()
				suffix += " ";
				break;
			case '*':
			case '/':
				suffix = mulDivOp(stack, suffix, c);// ����mulDivO()
				suffix += " ";
				break;
			case ')':
				suffix = reightOp(stack, suffix);// ����reightOp()
				break;
			// ��������֣�ֱ�������������
			default:
				suffix += c;
			}
		}
		while (stack.size() != 0) {
			suffix += " " + stack.pop();
		}
		return suffix;
	}
	//����* / �Ĳ���
	public String mulDivOp(Stack stack, String intopost,char c){
		while (stack.size() != 0) {
		String temp = stack.pop();
		if (temp.equals("(") || temp.equals("+") ||temp.equals("-") ) {
			stack.push(temp);
			break;
		} else {
			intopost += " " +temp;
		}
	}
	stack.push(String.valueOf(c));
	return intopost;
	}
	//����+ - �Ĳ���
	public String addSubOp(Stack stack, String intopost,char c){
		while (stack.size() != 0) {
			String temp = stack.pop();
			if (temp.equals("(")) {
				stack.push("(");
				break;
			}
			intopost+= " " +temp;
		}
		stack.push(String.valueOf(c));
		return intopost;
	}
	//���� ) �Ĳ���
	public String reightOp(Stack stack, String intopost){
		while (stack.size() != 0) {
			String temp = stack.pop();
			if (temp.equals("("))
				break;
			else
				intopost += " " + temp;
		}
		return intopost;
	}
}
