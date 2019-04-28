import java.util.ArrayList;

// ������
public class Calculate {
	// ջ
	Stack stack;
	// ��׺���ʽ
	ArrayList<String> infix;
	// ��׺���ʽ
	ArrayList<String> postfix;
	// ���ʽ�Ľ��
	double num = 0;
	// У����Ĵ���
	private Check check;

	public Calculate() {

	}

	// ���췽��
	// У���������
	public Calculate(Check check) {
		stack = new Stack();
		postfix = new ArrayList<>();
		infix = check.toInfix();
		this.check = check;
		toPostfix();
		compute();
	}

	// �����׺���ʽ�Ľ��
	public void compute() {
		stack = new Stack();
		for (String str : postfix) {
			if (str.matches("[\\+\\-\\*\\/]")) {
				double num2 = Double.valueOf(stack.pop());  //����ת��
				double num1 = Double.valueOf(stack.pop());  //����ת��
				switch (str) {
				case "+":
					num = num1 + num2;
					break;
				case "-":
					num = num1 - num2;
					break;
				case "*":
					num = num1 * num2;
					break;
				case "/":
					// ����Ϊ0�����
					if (Math.abs(num2) < 1e-8) {
						check.setLegal(false);
						check.setError("��������Ϊ0");
						return;
					}
					num = num1 / num2;
					break;
				}
				stack.push(String.valueOf(num));
			} else {
				stack.push(str);   //��ջ
			}
		}
	}

	// ��׺ת��׺
	private void toPostfix() {
		// ������׺���ʽ
		for (String str : infix) {
			// ���ȼ���ȫ����ջ����ջ�������������Ž���
			if (str.matches("[\\+\\-]")) {
				while (!stack.isEmpty() && !stack.top().equals("(")) {
					postfix.add(stack.pop());  
				}
				stack.push(str);     //��ջ
			} else if (str.matches("[\\*\\/]")) {
				while (!stack.isEmpty() && stack.top().equals("[\\*\\/]")) {
					postfix.add(stack.pop());   
				}
				stack.push(str);   //��ջ
			} else if (str.matches("\\(")) {
				stack.push(str);    //��ջ
			} else if (str.matches("\\)")) {
				while (!stack.top().matches("\\(")) {
					postfix.add(stack.pop());     
				}
				stack.pop();  //��ջ
			} else {
				num = Double.valueOf(str);
				postfix.add(str);
			}
		}
		// ��ջ�з��ŵ�������׺���ʽ��
		while (!stack.isEmpty()) {
			postfix.add(stack.pop());
		}
	}

	public ArrayList<String> getPostfix() {
		return postfix;
	}

	public double getNum() {
		return num;
	}
}
