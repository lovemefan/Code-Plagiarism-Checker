package 第一次大作业;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 带括号与小数点的四则运算表达式计算器
 */
public class Calculator {

    /**
     * @param s 需要去除多余空格的字符串
     * @return 已经去除多余空格的字符串
     */
    private String removeStringSpace(String s) {
        return s.replaceAll(" ", "");
    }

    /**
     * 判断是否为数字或者小数点
     * @param ch 判断是不是数字或者小数点的字符
     * @return true or false
     */
    private boolean isNumber(char ch) {
        return (ch >= '0' && ch <= '9') || (ch == '.');
    }

    /**
     * 判断字符串是否为数字
     * @param s 判断的字符串
     * @return true or false
     */
    private boolean isNumber(String s){
        String pattern = ".*[0-9.].*";
        return Pattern.matches(pattern, s);
    }

    /**
     * 判断是不是运算符或者括号
     * @param ch 判断是不是运算符或者括号的字符
     * @return true or false
     */
    private boolean isOperate(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')';
    }

    /**
     * 检验是否表达式是否合法
     * @param expression 检验是否合法的表达式
     * @return true or false
     */
    private boolean isValid(String expression) {
        if (expression.isEmpty()) {
            return false;
        } //表达式为空
        String pattern = ""; //声明一个正则表达式字符串
        pattern += "(.*[^0-9+*-/.()].*)|";
        pattern += "(^[^1-9(-].*)|"; //表达式最开始只能是1-9的数字 或者 左括号 或者 负号
        pattern += "(.*([+-/*.][+-/*).]).*)|"; //不能有连续的运算符 或者 运算符接右括号 或者 连续的小数点 或者 运算符接小数点
        pattern += "(.*[(][+)./*].*)|"; //不能有空的括号 或者 左括号右边接除负号的运算符、小数点
        pattern += "(.*([)][0-9.(]).*)|"; //右括号后面不能直接接数字小数点、左括号
        pattern += "(.*[0-9.)][(].*)|"; //左括号左边只能接运算符或者左括号
        pattern += "(.*[^0-9)]$)|"; //只能以数字结尾
        pattern += "(.*([0-9])+\\.([0-9])+\\..*)|"; //一个数不能有多个小数点
        pattern += "(.*[+-/*][0][^+\\-*/.].*)"; //一个数不能以0开头
        if(Pattern.matches(pattern, expression)){
            return false;
        }
        boolean isFalse = false; //表达式通过正则表达式检测是否错误
        Stack<Character> parentheses = new Stack<>(); //括号检测栈
        //判断括号是否匹配
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                parentheses.push(ch);
            }
            if (ch == ')' && (parentheses.isEmpty() || !(parentheses.pop() == '('))) {
                    isFalse = true;
                    break;
            }
        }
        if (!parentheses.isEmpty()) {
            isFalse = true; //括号不匹配
        }
        return !isFalse; //返回表达式是否合法
    }

    /**
     * 将中缀表达式放入栈中
     * @param expression 输入的中缀表达式
     * @return 放入栈中的中缀表达式
     */
    private Stack<String> getInfixExpression(String expression) {
        Stack<String> infixExpression = new Stack<>();
        int instead;
        boolean number = true;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (isNumber(ch) || (number && ch == '-')) { //如果是数字或者负号将一个数放入栈
                StringBuilder s = new StringBuilder();
                instead = i;
                do {
                    instead++;
                    s.append(ch);
                    if (instead == expression.length()) {
                        break;
                    }
                    ch = expression.charAt(instead);
                } while (isNumber(ch));
                infixExpression.push(s.toString());
                i = instead - 1;
                number = false;
            }else if (isOperate(ch)) { //如果是加减乘除直接入栈
                infixExpression.push(ch + "");
                number = ch == '(';
            }
        }
        reverseStack(infixExpression); //反转一下栈
        return infixExpression;
    }

    /**
     * 反转栈中的数据
     * @param reverseExpression 需要反转的表达式栈
     */
    private void reverseStack(Stack<String> reverseExpression) {
        Queue<String> reverse = new LinkedList<>();
        while (reverseExpression.size() > 0) {
            reverse.offer(reverseExpression.pop());
        }
        while (reverse.size() > 0) {
            reverseExpression.push(reverse.poll());
        }
    }

    /**
     * 栈中的中缀表达式转成后缀表达式
     * @param infixExpression 栈中的中缀表达式
     * @return 后缀表达式
     */
    private Stack<String> getPostfixExpression(Stack<String> infixExpression) {
        //设置优先级
        HashMap<String, Integer> operatorLevel = new HashMap<>();
        operatorLevel.put("(", 4);
        operatorLevel.put("*", 3);
        operatorLevel.put("/", 3);
        operatorLevel.put("+", 2);
        operatorLevel.put("-", 2);
        operatorLevel.put(")", 1);
        Stack<String> postfixExpression = new Stack<>(); //后缀表达式栈
        Stack<String> operator = new Stack<>(); //符号栈
        while (infixExpression.size() > 0) {
            if (!isNumber(infixExpression.peek())) { //是否为运算符或者括号
                if (operator.empty()) { //如果符号栈为空直接入栈
                    operator.push(infixExpression.pop());
                } else if (operatorLevel.get(infixExpression.peek()) == 4) { //如果为左括号直接入栈
                    operator.push(infixExpression.pop());
                } else if (operatorLevel.get(infixExpression.peek()) == 1) { //如果为右括号出栈并存入中缀表达式栈直到符号栈顶遇到左括号
                    infixExpression.pop();
                    while (operatorLevel.get(operator.peek()) != 4) {
                        postfixExpression.push(operator.pop());
                    }
                    operator.pop();
                } else if (operatorLevel.get(operator.peek()) == 4) { //如果栈顶为左括号直接入栈
                    operator.push(infixExpression.pop());
                } else if (operatorLevel.get(infixExpression.peek()) > operatorLevel.get(operator.peek())) { //如果比栈顶的符号优先级高入栈
                    operator.push(infixExpression.pop());
                } else if (operatorLevel.get(infixExpression.peek()) <= operatorLevel.get(operator.peek())) { //如果不比栈顶优先级高符号栈出栈存入后缀表达式栈
                    postfixExpression.push(operator.pop());
                }
            } else { //数直接入栈
                postfixExpression.push(infixExpression.pop());
            }
        }
        while (operator.size() > 0) { //将符号栈中剩余的符号存入中缀表达式栈
            postfixExpression.push(operator.pop());
        }
        reverseStack(postfixExpression); //反转栈
        return postfixExpression;
    }

    /**
     * 后缀表达式得到值
     * @param postfixExpression 后缀表达式
     * @return 表达式计算结果
     */
    private Double getBackValue(Stack<String> postfixExpression) {
        Stack<Double> value = new Stack<>(); //数值栈
        while (postfixExpression.size() > 0) {
            if (isOperate(postfixExpression.peek().charAt(0)) && postfixExpression.peek().length() == 1) { //如果是运算符
                //从数值栈中取出两个数
                Double numDouble_1 = value.pop();
                Double numDouble_2 = value.pop();
                switch (postfixExpression.pop().charAt(0)) { //根据运算符进行相应的运算
                    case '+':
                        value.push(numDouble_2 + numDouble_1);
                        break;
                    case '-':
                        value.push(numDouble_2 - numDouble_1);
                        break;
                    case '*':
                        value.push(numDouble_2 * numDouble_1);
                        break;
                    case '/':
                        value.push(divideCheck(numDouble_1, numDouble_2));
                        break;
                }
            } else { //如果是数字将String转换成double直接存入数值栈
                value.push(Double.parseDouble(postfixExpression.pop()));
            }
        }
        return value.pop();
    }

    /**
     * 判断是否除以了0
     * @param number_1 被除数
     * @param number_2 除数
     * @return 除的值或者异常处理
     */
    private Double divideCheck(Double number_1, Double number_2) {
        if (number_1 == 0) {
            throw new ArithmeticException("Divisor cannot be zero");
        }
        return number_2 / number_1;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(); //实例一个对象
        Scanner cin = new Scanner(System.in);
        String data = "";
        final String results = "results.txt";
        System.out.println("Enter the name of the file that contains the data:");
        data += cin.nextLine(); //输入存有数据的txt文件名
        cin.close();
        if (!data.endsWith(".txt")) {
            data += ".txt";
        }
        File myData = new File(data); //找到这个文件
        if (!myData.exists()) { //如果没有这个名字的文件则输出文件不存在并结束
            System.out.println("There is no file for data entry!!!");
            System.exit(1);
        }
        try {
            Scanner input = new Scanner(myData); //读入文件内容
            File myResult = new File(results);
            PrintWriter output = new PrintWriter(myResult); //输出存入文件
            while (input.hasNext()) { //文件不为空继续读取
                String expression = input.nextLine();
                expression = calculator.removeStringSpace(expression); //去除表达式多余空格
                if (expression.endsWith("=")) {
                    expression = expression.substring(0, expression.length() - 1);
                }
                if (!calculator.isValid(expression)) { //检验表达式是否合法
                    output.println("ERROR");
                    output.println("#" + expression);
                    continue;
                }
                Stack<String> infixExpression = calculator.getInfixExpression(expression); //中缀存入栈中
                Stack<String> postfixExpression = calculator.getPostfixExpression(infixExpression); //中缀转后缀
                try {
                    double result = calculator.getBackValue(postfixExpression); //计算后缀表达式得到值
                    if ((int) result - result == 0) { //如果是一个整数按整数输出
                        output.println(expression + "=" + (int) result);
                    } else {
                        output.println(expression + "=" + result);
                    }
                } catch (Exception ex) { //检测是否存在除以0的计算
                    output.println("ERROR");
                    output.println("#" + expression);
                }
            }
            input.close();
            output.close();
            System.out.println("Calculate complete");
        } catch (FileNotFoundException e) { //检测文件内容是否可读
            e.printStackTrace();
        }
    }
}
