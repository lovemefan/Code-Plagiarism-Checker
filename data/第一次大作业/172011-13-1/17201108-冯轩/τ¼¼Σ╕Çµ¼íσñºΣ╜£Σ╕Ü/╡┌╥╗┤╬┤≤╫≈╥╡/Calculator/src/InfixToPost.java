
public class InfixToPost {
	private Stack stack; // ��׺���ʽת��Ϊ��׺���ʽ����Ҫ��ջ
	private String infix; // �������׺���ʽ
	private String post = ""; // �洢�õ��ĺ�׺���ʽ

	//��ʼ��������
    public InfixToPost (Stack stack, String infix) {
        this.stack = stack;
        this.infix = infix.replaceAll("\\s+","");//ȥ���ַ����еĿո�;
    }
    
	private void getOperation(String str, int priority) {
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {
				stack.push(top);
				break;
			} else {
				int priTop = getPriority(top);
				if (priTop < priority) {
					stack.push(top);
					break;
				} else {
					post += " " + top;
				}
			}
		}
		stack.push(str);
	}

	//��ȡ��������ȼ�
	private int getPriority(String str) {
		int pri = 0;
		if (str.equals("+") || str.equals("-")) {
			pri = 1;
		} else {
			pri = 2;
		}
		return pri;
	}

	//��ȡ����
	private void getParent() {
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {
				break;
			} else {
				post += " " + top;
			}
		}
	}

	//Ϊ���ʽ������Ͽո�
	private String processInfix(String infix) {
        String result = "";
        for (int i = 0; i < infix.length() - 1; i++) {
            char temp1 = infix.charAt(i);
            char temp2 = infix.charAt(i + 1);
            if (isDigital(temp1) && isDigital(temp2)) {
                result += temp1;
            } else {
                result += temp1 + " ";
            }
        }
        result += infix.charAt(infix.length() - 1); // �����һ��Ԫ����ӽ�ȥ
        return result;
    }

	//�ж��Ƿ�������
	private boolean isDigital(char ch) {
        if (ch >= '0' && ch <= '9')
            return true;
        else
            return false;
    }

	//��׺���ʽת��׺���ʽ
	public void process() {
		String[] strArr = processInfix(infix).split(" ");
		for (int i = 0; i < strArr.length; i++) {
			String str = strArr[i];
			switch (str) {
			case "+":
			case "-":
				getOperation(str, 1);
				break;
			case "*":
			case "/":
				getOperation(str, 2);
				break;
			case "(":
				stack.push(str);
				break;
			case ")":
				getParent();
				break;
			default:
				post += " " + str;
				break;
			}
		}
		// ����ȫ���������Ҫ���ջ��ʣ��ķ���
		while (!stack.isEmpty()) {
			post += " " + stack.pop();
		}
	}

	//�õ����
	public String getPost() {
		return post.trim();
	}
}
