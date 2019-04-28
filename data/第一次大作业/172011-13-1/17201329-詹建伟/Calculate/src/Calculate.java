//������
public class Calculate {
	// �����׺���ʽ
	// ջ����׺���ʽ
	public void calculte(Stack stack, String buf, java.io.PrintWriter output, String expression) {
		String[] s = buf.split(" ");
		for (int i = 0; i < s.length; i++) {
			// �п�
			if (s[i].isEmpty()) {
				continue;
			}
			// �ж����ֽ�ջ
			if (s[i].matches("[\\d]{1,}")) {
				stack.pushStack(stack, s[i]);
				continue;
			}
			// �жϼ��㣬���������ջ
			switch (s[i]) {
			case "+":
				stack.pushStack(stack, this.add(stack));
				break;
			case "-":
				stack.pushStack(stack, this.reduce(stack));
				break;
			case "*":
				stack.pushStack(stack, this.multi(stack));
				break;
			case "/":
				stack.pushStack(stack, this.division(stack));
				break;
			default:
				break;
			}
		}
		// ������ս��
		String temp = stack.outStack(stack);
		if (temp.equals("Infinity")) {
			output.println("ERROR\r\n#����Ϊ0");
		} else {
			double temp2 = Double.parseDouble(temp);
			output.println(expression + "=" + temp2);
		}
		// System.out.println(temp);//����̨����ʾ���
	}

	// ʵ�ּӷ�
	public String add(Stack stack) {
		double num1 = Double.parseDouble(stack.outStack(stack));
		double num2 = Double.parseDouble(stack.outStack(stack));

		String s = (num2 + num1) + "";
		return s;
	}

	// ʵ�ּ���
	public String reduce(Stack stack) {
		double num1 = Double.parseDouble(stack.outStack(stack));
		double num2 = Double.parseDouble(stack.outStack(stack));

		String s = (num2 - num1) + "";
		return s;
	}

	// ʵ�ֳ˷�
	public String multi(Stack stack) {
		double num1 = Double.parseDouble(stack.outStack(stack));
		double num2 = Double.parseDouble(stack.outStack(stack));

		String s = (num2 * num1) + "";
		return s;
	}

	// ʵ�ֳ���
	public String division(Stack stack) {
		double num1 = Double.parseDouble(stack.outStack(stack));
		double num2 = Double.parseDouble(stack.outStack(stack));

		String s = (num2 / num1) + "";
		return s;
	}
}
