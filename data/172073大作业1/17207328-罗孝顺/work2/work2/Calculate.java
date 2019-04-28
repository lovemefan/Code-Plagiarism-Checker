package work2;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
class Calculate{
	  Stack<Integer> OPTR = new Stack<>();
	  Stack<Character> OPND = new Stack<>();
	  String str;

	  public int calculate(String str) {
	        String[] str1 = strToExpressionArr(str);
	        return calculate(str1);
	    }
//�ѱ��ʽת��Ϊ����
private static String[] strToExpressionArr(String str) {
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) < '0' || str.charAt(i) > '9') {
            str = str.substring(0, i) +
                    " " + str.charAt(i) + " " +
                    str.substring(i + 1, str.length());
            i += 2;
        }
    }
    Scanner scan = new Scanner(str);
    while (scan.hasNext()) {
        list.add(scan.next());
    }
    scan.close();
    return list.toArray(new String[list.size()]);
}

//�����������ʽ
private  int calculate(String[] expression) {
  

    for (int i = 0; i < expression.length; i++) {
        String ele = expression[i];

        //��������֣���������ջ
        if (isOPTR(ele)) {
            OPTR.push(new Integer(ele));
        }
        //�����Ƿ���
        //�����Ӽ��ţ���ջ���ķ��Ŷ������ֱ꣬�������������ź�ջ�������������ȡ���ķ���ѹ��ջ
        else if (ele.charAt(0) == '+' || ele.charAt(0) == '-') {
            while (!OPND.isEmpty() && OPND.peek() != '(') {
                int b = OPTR.pop();
                int a = OPTR.pop();
                OPTR.push(getAnswer(a, OPND.pop(), b));
            }

            if (!OPND.isEmpty() && OPND.peek() == '(')
                OPND.pop();

            OPND.push(ele.charAt(0));
        }
        //�����˳��ţ���ǰ��ĳ˳��Ŵ����꣬������ȡ���ķ���ѹ��ջ
        else if (ele.charAt(0) == '*' || ele.charAt(0) == '/') {
            while (!OPND.isEmpty() && OPND.peek() != '(' &&
                    OPND.peek() != '+' && OPND.peek() != '-') {
                int b = OPTR.pop();
                int a = OPTR.pop();
                OPTR.push(getAnswer(a, OPND.pop(), b));
            }

            if (!OPND.isEmpty() && OPND.peek() == '(')
                OPND.pop();

            OPND.push(ele.charAt(0));
        }
        //���������ţ�ֻ��ջ
        else if (ele.charAt(0) == '(') {
            OPND.push(ele.charAt(0));
        }
        //���������ţ�ֻ����ջ��ȫ������
        else if (ele.charAt(0) == ')') {
            while (!OPND.isEmpty() && OPND.peek() != '(') {
                int b = OPTR.pop();
                int a = OPTR.pop();
                OPTR.push(getAnswer(a, OPND.pop(), b));
            }

            if (!OPND.isEmpty() && OPND.peek() == '(')
                OPND.pop();
        }
    }

    //���û���������Ž�β�ı��ʽ���������ʣ�µķ��Ŵ�����
    if (!OPND.isEmpty()) {
        int b = OPTR.pop();
        int a = OPTR.pop();
        OPTR.push(getAnswer(a, OPND.pop(), b));
    }

    return OPTR.peek();
}

//�ж��Ƿ�����
private static boolean isOPTR(String s) {
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) < '0' || s.charAt(i) > '9')
            return false;
    }
    return true;
}

//��������
private static int getAnswer(int a, char operator, int b) {
    switch (operator) {
        case '+': return a + b;
        case '-': return a - b;
        case '*': return a * b;
        case '/': return a / b;
    }
    return 0;
}
}