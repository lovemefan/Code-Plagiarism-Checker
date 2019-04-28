package 第一次大作业2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class calculatorExpression {

    public static void main(String[] args) throws IOException {
        String expression;
        String s ;

        List<String> list = new ArrayList<>();
        int count = 0;
        float num1 = 1;
        float num2;
        BufferedReader bufferedReader1=new BufferedReader(new FileReader("calculate1.txt"));//写运算式在calculate1文档里，从calculate1里读取字符串
        BufferedWriter bufferedWriter1=new BufferedWriter(new FileWriter("calculate2.txt"));//计算好的运算式卸载calculate2里
        
		
        while ((s = bufferedReader1.readLine()) != null) {//判断calculate1是否为空，如果不为空，可以从里面调出字符串进行操作

            expression = s;

            if (!compareIsSame(list, count, expression)) {
                ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
                Stack<String> operation = reversePolishNotation.transform(expression);
                if (operation == null || operation.size() == 0) {
                    bufferedWriter1.write(expression + "   Error");
                    bufferedWriter1.newLine();
                    continue;
                }
                Stack<String> dight = new Stack<>();//创建新栈
                while (!operation.isEmpty()) {
                    if (!reversePolishNotation.isOperator(operation.peek())) {
                        dight.push(operation.pop());
                    } else {
                        switch (operation.peek()) {//如果是运算符则入符号栈
                            case "+":
                                dight.push(intToString(stringToInt(dight.pop()) + stringToInt(dight.pop())));
                                operation.pop();
                                break;
                            case "-":
                                dight.push(intToString(-stringToInt(dight.pop()) + stringToInt(dight.pop())));
                                operation.pop();
                                break;
                            case "*":
                                dight.push(intToString(stringToInt(dight.pop()) * stringToInt(dight.pop())));
                                operation.pop();
                                break;
                            case "/":
                                num1 = stringToFloat(dight.pop());
                                num2 = stringToFloat(dight.pop());
                                if (num1 != 0) {//数字入数字栈
                                    dight.push(floatToString(num2 / num1));
                                    operation.pop();
                                }

                        }
                    }
                    if (num1 == 0) break;
                }
                if (operation.isEmpty()) {
                    bufferedWriter1.write(expression + "=" + dight.peek());
                    bufferedWriter1.newLine();
                } else {
                    bufferedWriter1.write(expression + "  Error");
                    bufferedWriter1.newLine();
                }
            }
            list.add(expression);
            count++;
        }
        bufferedReader1.close();
        bufferedWriter1.close();

    }

    private static boolean compareIsSame(List<String> list, int count, String expression) {//判断栈内是否为空
        if (count == 0)
            return false;
        else
            for (int i = 0; i < count; i++) {
                if (expression.equals(list.get(i))) {
                    return true;
                }
            }
        return false;
    }

    private static String floatToString(float v) {
        return String.valueOf(v);
    }

    private static float stringToFloat(String pop) {
        return Float.parseFloat(pop);
    }


    private static String intToString(int i) {
        return String.valueOf(i);
    }

    private static int stringToInt(String pop) {
        return Integer.parseInt(pop);
    }


}