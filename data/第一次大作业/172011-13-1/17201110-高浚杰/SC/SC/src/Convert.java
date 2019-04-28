public class Convert {
    private Stack<String> stack;  //��׺���ʽת��Ϊ��׺���ʽ����Ҫ��ջ
    private String infix;    //�������׺���ʽ
    private String post = "";     //�洢�õ��ĺ�׺���ʽ

    //��ʼ�����췽��
    public Convert(Stack<String> stack2, String s2) {
        this.stack = stack2;
        this.infix = s2;
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

    //�ж��Ƿ�Ϊ����
    private boolean isDigital(char ch) {
        if (ch >= '0' && ch <= '9')
            return true;
        else
            return false;
    }

    //����׺���ʽת��Ϊ��׺���ʽ�Ĵ������
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
        while (!stack.isEmpty()) {
            post += " " + stack.pop();// ���ջ��ʣ��ķ���
        }
    }

    //ƥ�䵽���ŵ���
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
        int pri = 0;
        if (str.equals("+") || str.equals("-")) {
            pri = 1;
        } else {
            pri = 2;
        }
        return pri;
    }
    
    //ȥ������Ŀո��
    public String getPost() {
        return post.trim();
    }
}