import java.util.*;
public class stack {
    //使用空格分割字符串，以便后面使用分割函数使得将字符串分割成数组
    public String insetBlanks(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
                    s.charAt(i) == '+' || s.charAt(i) == '-'
                    || s.charAt(i) == '*' || s.charAt(i) == '/')
                result += " " + s.charAt(i) + " ";
            else
                result += s.charAt(i);
        }
        return result;
    }

    public int evaluateExpression(String expression) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        expression = insetBlanks(expression);
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.length() == 0)   //如果是空格的话就继续循环，什么也不操作
                continue;
            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '-' || operatorStack.peek() == '+' || operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
                    processAnOperator(operandStack, operatorStack);   //开始运算
                }
                operatorStack.push(token.charAt(0));   //运算完之后将当前的运算符入栈
            }
            else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));   //将当前操作符入栈
            }
            //如果是左括号的话直接入栈，什么也不用操作,trim()函数用来去除空格，由于上面的分割操作可能会令操作符带有空格
            else if (token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            }
            //如果是右括号的话，清除栈中的运算符直至左括号
            else if (token.trim().charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);    //开始运算
                }
                operatorStack.pop();   //运算完之后清除左括号
            }
            //如果是数字的话直接如数据的栈
            else {
                operandStack.push(Integer.parseInt(token));   //将数字字符串转换成数字然后压入栈中
            }
        }
        //当栈中不是空的时候继续运算，知道栈中为空即可
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }
        return operandStack.pop();    //此时数据栈中的数据就是运算的结果
    }

    //处理栈中的两个数据，然后将栈中的两个数据运算之后将结果存储在栈中
    public void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();  //弹出一个操作符
        int op1 = operandStack.pop();  //从存储数据的栈中弹出连个两个数用来和操作符op运算
        int op2 = operandStack.pop();
        if (op == '+')  //如果操作符为+就执行加运算
            operandStack.push(op1 + op2);
        else if (op == '-')
            operandStack.push(op2 - op1);   
        else if (op == '*')
            operandStack.push(op1 * op2);
        else if (op == '/'){
        	if(op1 == 0){
            operandStack.push(0);
        	}
        	else
            operandStack.push(op2 / op1);
       }
    }	
}