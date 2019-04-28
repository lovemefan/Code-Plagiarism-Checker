
public class StackProcced {
	// ������ʽ
	// ջ�����ʽ
	public String Procced(Stack stack, String expression) {
		char[] buf = expression.toCharArray();
		String[] buf2 = new String[buf.length];
		for (int i = 0, j = 0; i < buf.length; i++, j++) {
			if (buf[i] <= '9' && buf[i] >= '0') {
				buf2[j] = buf[i] + "";
				i++;
				while (i < buf.length && buf[i] <= '9' && buf[i] >= '0') {
					buf2[j] += buf[i];
					i++;
				}
				buf2[j] += " ";
				i--;
			} else {
				buf2[j] = buf[i] + " ";
			}
		}
		String s = "";
		for (int i = 0; i < buf2.length; i++) {
			if (buf2[i] == null) {
				break;
			}
			//System.out.print(buf[i]);
			s += buf2[i];
		}
		//System.out.println(s);
		return s;
	}

	// �жϸ���
	public String isNegative(String buf) {
		char[] newBuf = buf.toCharArray();
		String s = new String();
		for (int i = 0; i < buf.length(); i++) {
			if (newBuf[i] == '-') {
				if (i == 0) {
					s += "0-";
				} else if (newBuf[i - 1] == '(') {
					s += "0-";
				} else {
					s += newBuf[i] + "";
				}
			} else {
				s += newBuf[i] + "";
			}
		}
		return s;
	}

	// ��׺���ʽת��
	public String laterExp(Stack stack, String buf, java.io.PrintWriter output, String expression) {
		String s = new String();
		String[] newBuf = buf.split(" ");
		for (int i = 0; i < newBuf.length; i++) {
			if (newBuf[i] == null) {
				break;
			}
			switch (newBuf[i]) {
			case "+":
				s += this.addORreduceProcceed(stack, newBuf[i] + " ");
				break;
			case "-":
				s += this.addORreduceProcceed(stack, newBuf[i] + " ");
				break;
			case "*":
				s += this.multiORdivisionProcceed(stack, newBuf[i] + " ");
				break;
			case "/":
				s += this.multiORdivisionProcceed(stack, newBuf[i] + " ");
				break;
			case "(":
				stack.pushStack(stack, newBuf[i] + " ");
				break;
			case ")":
				s += this.rightProcceed(stack);
				break;
			default:
				s += newBuf[i] + " ";
				break;
			}
		}
		while (stack.stackTop != stack.stackBottom) {
			s += stack.outStack(stack);
		}
		//System.out.println(s);
		Calculate calculate = new Calculate();
		calculate.calculte(stack, s, output, expression);
		return s;
	}

	// �����ӺŻ����
	public String addORreduceProcceed(Stack stack, String buf) {
		String s = new String();
		while (stack.stackTop != stack.stackBottom) {
			if (stack.stackTop.expression.equals("( ")) {
				break;
			} else {
				s += stack.outStack(stack);
			}
		}
		stack.pushStack(stack, buf);

		return s;
	}

	// �����˺Ż����
	public String multiORdivisionProcceed(Stack stack, String buf) {
		String s = new String();
		if (stack.stackTop.expression.equals("/ ") || stack.stackTop.expression.equals("* ")) {
			s += stack.outStack(stack);
		}
		stack.pushStack(stack, buf);

		return s;
	}

	// ����������
	public String rightProcceed(Stack stack) {
		String s = new String();
		while (!stack.stackTop.expression.equals("( ")) {
			s += stack.outStack(stack);
		}
		stack.outStack(stack);

		return s;
	}
}
