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
//把表达式转换为数组
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

//计算算术表达式
private  int calculate(String[] expression) {
  

    for (int i = 0; i < expression.length; i++) {
        String ele = expression[i];

        //如果是数字，进入数字栈
        if (isOPTR(ele)) {
            OPTR.push(new Integer(ele));
        }
        //以下是符号
        //遇到加减号，把栈顶的符号都处理完，直到遇到（左括号和栈空情况，最后把提取到的符号压入栈
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
        //遇到乘除号，把前面的乘除号处理完，最后把提取到的符号压入栈
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
        //遇到左括号，只进栈
        else if (ele.charAt(0) == '(') {
            OPND.push(ele.charAt(0));
        }
        //遇到右括号，只处理栈顶全部符号
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

    //最后没有以右括号结尾的表达式还得另外把剩下的符号处理完
    if (!OPND.isEmpty()) {
        int b = OPTR.pop();
        int a = OPTR.pop();
        OPTR.push(getAnswer(a, OPND.pop(), b));
    }

    return OPTR.peek();
}

//判断是否数字
private static boolean isOPTR(String s) {
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) < '0' || s.charAt(i) > '9')
            return false;
    }
    return true;
}

//四则运算
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