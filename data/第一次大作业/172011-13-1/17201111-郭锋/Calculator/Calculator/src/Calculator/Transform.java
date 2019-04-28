package Calculator;


public class Transform {
    private Stack stack;  //��׺���ʽת��Ϊ��׺���ʽ����Ҫ��ջ
    private String infix;    //�������׺���ʽ
    private String post = "";     //�洢�õ��ĺ�׺���ʽ

    //��ʼ��������
    public Transform(Stack stack, String infix) {
        this.stack = stack;
        this.infix = infix;
    }

    
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

    private boolean isDigital(char ch) {
        if (ch >= '0' && ch <= '9')
            return true;
        else
            return false;
    }

	// ��ǰ׺���ʽת��Ϊ��׺���ʽ�Ĵ������
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

    private int getPriority(String str) {
        int p = 0;
        if (str.equals("+") || str.equals("-")) {
            p = 1;
        } else {
            p = 2;
        }
        return p;
    }

    public String getPost() {
        return post.trim();
    } 
}

