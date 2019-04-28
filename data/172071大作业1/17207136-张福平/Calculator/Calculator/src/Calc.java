
import java.math.BigDecimal;
import java.util.Stack;

public class Calc{


    /* 表达式求值 返回计算的结果*/

    public BigDecimal calc(String resExp){
        String[] exp = inExpToSuffixExp(resExp).split(",");
        //定义一个存放操作数的栈
        Stack<String> stack = new Stack<>();
        for(int i=0;i<exp.length;i++){
            if(!isOperator(exp[i])){
                //如果是操作数，压入操作栈
                stack.push(exp[i]);
            }else{
                //如果是操作符，弹出栈中靠近栈顶的两个操作数
                BigDecimal num2 = new BigDecimal(stack.pop());
                BigDecimal num1 = new BigDecimal(stack.pop());
                if("+".equals(exp[i])){
                    //遇到+号，将两个操作数相加,然后将结果压栈
                    stack.push(""+num1.add(num2));
                }else if("-".equals(exp[i])){
                    //遇到-号，将两个操作数相减,然后将结果压栈
                    stack.push(""+num1.subtract(num2));
                }else if("*".equals(exp[i])){
                    //遇到*号，将两个操作数相乘,然后将结果压栈
                    stack.push(""+num1.multiply(num2));
                }else if("/".equals(exp[i])){
                    //遇到/号，将两个操作数相除,然后将结果压栈
                    stack.push(""+num1.divide(num2));
                }
            }
        }
        //将最后的结果弹出并返回
        return new BigDecimal(stack.pop());
    }

    /*
     将中缀表达式转换成后缀表达式(带,号)
     */
    public String inExpToSuffixExp(String resExp) {
        String[] inExp = dealInExp(resExp).split(",");
        Stack<String> stack = new Stack<>();
        StringBuilder suffixExp = new StringBuilder();
        for (String s : inExp) {
            if (!isOperator(s)) {
                // 遇到数字，直接输出
                suffixExp.append(s + ",");
            } else if ("(".equals(s)) {
                // 遇到左括号,直接压栈
                stack.push(s);
            } else if (")".equals(s)) {
                // 遇到右括号，将栈顶元素依次弹出，直至遇到左括号
                while (!"(".equals(stack.get(stack.size() - 1))) {
                    suffixExp.append(stack.pop() + ",");
                }
                // 弹出左括号但不输出
                stack.pop();
            } else if (isOperator(s)) {
                // 遇到运算符,当前运算符优先级小于等于栈顶运算符优先级，将栈顶运算符弹出
                // 当前运算符继续和新的栈顶运算符比较...
                while (!stack.isEmpty()
                        &&getPriority(s)<=getPriority(stack.get(stack.size()-1))){
                    suffixExp.append(stack.pop() + ",");
                }
                stack.push(s);
            }
        }
        // 最后,将栈内还没有弹出的运算符依次弹出
        while (!stack.isEmpty()) {
            suffixExp.append(stack.pop() + ",");
        }
        // 去除最后一个,号
        suffixExp.delete(suffixExp.length() - 1, suffixExp.length());
        return suffixExp.toString();
    }

    /*
     返回处理后的中缀表达式
     */
    private String dealInExp(String resExp) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resExp.length(); i++) {
            String tmp = resExp.substring(i, i + 1);
            if (!isOperator(tmp)||tmp.equals("-")) {
                sb.append(tmp);
            } else {
                if (sb.length() == 0) {
                    sb.append(tmp + ",");
                } else if (sb.charAt(sb.length() - 1) == ',') {
                    sb.append(tmp + ",");
                } else {
                    sb.append("," + tmp + ",");
                }
            }
        }
        return sb.toString();
    }

     /*判断是不是运算符*/

    private boolean isOperator(String str) {
        return "+-*/()".contains(str);
    }

    /*获取运算符的优先级*/

    private int getPriority(String operator) {
        return "()+-*/".indexOf(operator)/2;
    }
    /*
    返回计算后的表达式
     */
    public String test(String str){
        String resExp = str;
        String string = resExp + "=" + calc(resExp);
        return string;
    }

}
