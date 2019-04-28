import java.util.*;

//计算表达式类
public class Evaluate  {
    
//构造方法	
	Evaluate(){
		
	}
	
//进行字符串初步处理
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
//入栈操作及表达式计算
    public double evaluate(String str) {
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        str = insetBlanks(str);
        String[] Arrays = str.split(" ");
        for (String Ar : Arrays) {
            if (Ar.length() == 0)   //如果是空格的话就继续循环，什么也不操作
                continue;
            //如果是加减的话，因为加减的优先级最低，因此这里的只要遇到加减号，无论操作符栈中的是什么运算符都要运算
            else if (Ar.charAt(0) == '+' || Ar.charAt(0) == '-') {
                //当栈不是空的，并且栈中最上面的一个元素是加减乘除的人任意一个
                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '-' || operatorStack.peek() == '+' || operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
                    processAnOperator(operandStack, operatorStack);   //开始运算
                }
                operatorStack.push(Ar.charAt(0));   //运算完之后将当前的运算符入栈
            }
            //当前运算符是乘除的时候，因为优先级高于加减，因此要判断最上面的是否是乘除，如果是乘除就运算，否则的话直接入栈
            else if (Ar.charAt(0) == '*' || Ar.charAt(0) == '/') {
                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(Ar.charAt(0));   //将当前操作符入栈
            }
            //如果是左括号的话直接入栈，什么也不用操作,trim()函数是用来去除空格的，由于上面的分割操作可能会令操作符带有空格
            else if (Ar.trim().charAt(0) == '(') {
                operatorStack.push('(');
            }
            //如果是右括号的话，清除栈中的运算符直至左括号
            else if (Ar.trim().charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);    //开始运算
                }
                operatorStack.pop();   //这里的是运算完之后清除左括号
            }
            //这里如果是数字的话直接如数据的栈
            else {
                operandStack.push(Double.parseDouble(Ar));   //将数字字符串转换成数字然后压入栈中
            }
        }
        //最后当栈中不是空的时候继续运算，知道栈中为空即可
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }
        return operandStack.pop();    //此时数据栈中的数据就是运算的结果
    }

    //计算栈中操作数
    public void processAnOperator(Stack<Double> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        double num1 = operandStack.pop();
        double num2 = operandStack.pop();
        if (op == '+')
            operandStack.push(num1 + num2);
        else if (op == '-')
            operandStack.push(num2 - num1);
        else if (op == '*')
            operandStack.push(num1 * num2);
        else if (op == '/')
            operandStack.push(num2 / num1);
        	
    }

    
}