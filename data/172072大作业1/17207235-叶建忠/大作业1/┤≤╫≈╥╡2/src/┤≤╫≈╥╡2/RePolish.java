package 大作业2;

import java.util.Stack;
import java.util.regex.Pattern;

class RePolish {
    public Stack<String> transformToRePolish(String express) {
        Stack<String> operator = new Stack<>();       //存储操作符
        Stack<String> endRepolish = new Stack<>();       //存储逆波兰式

        //去除字符串中的空格
        String expression = express.replaceAll( "\\s+", "");

        //正序表达式转换为逆波兰表达式
        int k;//记录字符串数字后第一个非数字字符的下标
        for(int i = 0; i < expression.length(); i++){
            //判断是否为运算符
            if(isOperator(String.valueOf(expression.charAt(i)))){
                //如果遇到左括号，直接加入到operator中；
                if("(".equals(String.valueOf(expression.charAt(i))))
                    operator.push("(");
                //如果遇到右括号，那么将operator中的操作符出栈，合成逆波兰表达式，存入到value中。直到遇到operator中的左括号，将其出栈；
                else if(")".equals(String.valueOf(expression.charAt(i)))){
                    while(!"(".equals(operator.peek()))
                        endRepolish.push(operator.pop());
                    //将（出栈
                    operator.pop();
                }
                //如果遇到-+*/操作符
                else {
                    //操作符的优先级小于当前operator栈顶的优先级，则将operator栈顶的操作符出栈，并与endRePolish中的操作数进行合成逆波兰表达式，直到operator栈顶的操作符为空或者op栈顶的操作符小于等于操作符
                    while(!operator.isEmpty()&&!isBigger(String.valueOf(expression.charAt(i)),operator.peek())){
                        endRepolish.push(operator.pop());
                    }
                    operator.push(String.valueOf(expression.charAt(i)));
                    /*操作符的优先级大于当前operator栈顶的优先级或者operator栈为空，则将该操作符入栈
                    if(operator.isEmpty() || isBigger(String.valueOf(expression.charAt(i)),operator.peek()))
                        operator.push(String.valueOf(expression.charAt(i)));
                    操作符的优先级小于当前operator栈顶的优先级，则将operator栈顶的操作符出栈，并与endRePolish中的操作数进行合成逆波兰表达式，直到operator栈顶的操作符为空或者op栈顶的操作符小于等于操作符
                    else {
                        while(!operator.isEmpty()&&!isBigger(String.valueOf(expression.charAt(i)),operator.peek())){
                             endRepolish.push(operator.pop());
                    }
                          operator.push(String.valueOf(expression.charAt(i)));
                    }*/
                }
            }
            //如果遇到数字或者变量,直接加入到endRePolish中；
            else {
                k = i;//判断数字后面是否为运算符
                while (k < expression.length() && !isOperator(String.valueOf(expression.charAt(k))))
                    k++;
                endRepolish.push(expression.substring(i,k));
                i = k-1;
            }
        }
        //如果op栈中仍然还有操作符，则将其弹出进行逆波兰表达式的合成
        while(!operator.isEmpty()){
            endRepolish.push(operator.pop());
        }
        return endRepolish;
    }
    //计算逆波兰表达式的值
    public String computeResult(Stack<String> expression){
        Stack<String> compute = new Stack<>();//储存最终结果
        //将expression中的内容进行翻转
        while (!expression.isEmpty()){
            compute.push(expression.pop());
        }
        String SOperator = "\\d+";//用于判断内容是否为数字的正则表达式
        while(!compute.isEmpty()) {
            //如果是数字,直接入栈
            if (Pattern.matches(SOperator,compute.peek())){
                expression.push(compute.pop());
            }
            //如果是运算符，将栈最上层两个数据提出和运算符进行运算，结果入栈
            else {
                String s1 = expression.pop();
                String s2 = expression.pop();
                String op = compute.pop();
                expression.push(compute(s2,s1,op));
            }
        }
        return String.valueOf(expression.peek());
    }
    //算数运算
    public String compute(String s1, String s2, String op){
        int result;
        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);
        switch (op){
            case "-":
                result = num1 - num2;
                break;
            case "+":
                result = num1 + num2;
                break;
            case"*":
                result = num1 * num2;
                break;
            case"/":
                result = num1 / num2;
                break;
                default:
                    return null;
        }
        op = String.valueOf(result);
        return op;
    }

    //判断是否为运算符
    public boolean isOperator(String c){
        return c.equals("-")||c.equals("+")||c.equals("*")||c.equals("/")||c.equals("(")||c.equals(")");
    }
    //判断操作符的优先级;优先级从高到低 ）  /*  -+  （
    public boolean isBigger(String s1,String s2){
        boolean flag = false;
        switch (s1){
            case "+":
            case "-":
                if(s2.equals("("))
                    flag = true;
                break;
            case "*":
            case "/":
               flag = true;
               break;
            default:
        }
        return flag;
    }



}
