package ��һ�δ���ҵ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Pattern;

/**
 * ��������С���������������ʽ������
 */
public class Calculator {

    /**
     * @param s ��Ҫȥ������ո���ַ���
     * @return �Ѿ�ȥ������ո���ַ���
     */
    private String removeStringSpace(String s) {
        return s.replaceAll(" ", "");
    }

    /**
     * �ж��Ƿ�Ϊ���ֻ���С����
     * @param ch �ж��ǲ������ֻ���С������ַ�
     * @return true or false
     */
    private boolean isNumber(char ch) {
        return (ch >= '0' && ch <= '9') || (ch == '.');
    }

    /**
     * �ж��ַ����Ƿ�Ϊ����
     * @param s �жϵ��ַ���
     * @return true or false
     */
    private boolean isNumber(String s){
        String pattern = ".*[0-9.].*";
        return Pattern.matches(pattern, s);
    }

    /**
     * �ж��ǲ����������������
     * @param ch �ж��ǲ���������������ŵ��ַ�
     * @return true or false
     */
    private boolean isOperate(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')';
    }

    /**
     * �����Ƿ���ʽ�Ƿ�Ϸ�
     * @param expression �����Ƿ�Ϸ��ı��ʽ
     * @return true or false
     */
    private boolean isValid(String expression) {
        if (expression.isEmpty()) {
            return false;
        } //���ʽΪ��
        String pattern = ""; //����һ��������ʽ�ַ���
        pattern += "(.*[^0-9+*-/.()].*)|";
        pattern += "(^[^1-9(-].*)|"; //���ʽ�ʼֻ����1-9������ ���� ������ ���� ����
        pattern += "(.*([+-/*.][+-/*).]).*)|"; //����������������� ���� ������������� ���� ������С���� ���� �������С����
        pattern += "(.*[(][+)./*].*)|"; //�����пյ����� ���� �������ұ߽ӳ����ŵ��������С����
        pattern += "(.*([)][0-9.(]).*)|"; //�����ź��治��ֱ�ӽ�����С���㡢������
        pattern += "(.*[0-9.)][(].*)|"; //���������ֻ�ܽ����������������
        pattern += "(.*[^0-9)]$)|"; //ֻ�������ֽ�β
        pattern += "(.*([0-9])+\\.([0-9])+\\..*)|"; //һ���������ж��С����
        pattern += "(.*[+-/*][0][^+\\-*/.].*)"; //һ����������0��ͷ
        if(Pattern.matches(pattern, expression)){
            return false;
        }
        boolean isFalse = false; //���ʽͨ��������ʽ����Ƿ����
        Stack<Character> parentheses = new Stack<>(); //���ż��ջ
        //�ж������Ƿ�ƥ��
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
            isFalse = true; //���Ų�ƥ��
        }
        return !isFalse; //���ر��ʽ�Ƿ�Ϸ�
    }

    /**
     * ����׺���ʽ����ջ��
     * @param expression �������׺���ʽ
     * @return ����ջ�е���׺���ʽ
     */
    private Stack<String> getInfixExpression(String expression) {
        Stack<String> infixExpression = new Stack<>();
        int instead;
        boolean number = true;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (isNumber(ch) || (number && ch == '-')) { //��������ֻ��߸��Ž�һ��������ջ
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
            }else if (isOperate(ch)) { //����ǼӼ��˳�ֱ����ջ
                infixExpression.push(ch + "");
                number = ch == '(';
            }
        }
        reverseStack(infixExpression); //��תһ��ջ
        return infixExpression;
    }

    /**
     * ��תջ�е�����
     * @param reverseExpression ��Ҫ��ת�ı��ʽջ
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
     * ջ�е���׺���ʽת�ɺ�׺���ʽ
     * @param infixExpression ջ�е���׺���ʽ
     * @return ��׺���ʽ
     */
    private Stack<String> getPostfixExpression(Stack<String> infixExpression) {
        //�������ȼ�
        HashMap<String, Integer> operatorLevel = new HashMap<>();
        operatorLevel.put("(", 4);
        operatorLevel.put("*", 3);
        operatorLevel.put("/", 3);
        operatorLevel.put("+", 2);
        operatorLevel.put("-", 2);
        operatorLevel.put(")", 1);
        Stack<String> postfixExpression = new Stack<>(); //��׺���ʽջ
        Stack<String> operator = new Stack<>(); //����ջ
        while (infixExpression.size() > 0) {
            if (!isNumber(infixExpression.peek())) { //�Ƿ�Ϊ�������������
                if (operator.empty()) { //�������ջΪ��ֱ����ջ
                    operator.push(infixExpression.pop());
                } else if (operatorLevel.get(infixExpression.peek()) == 4) { //���Ϊ������ֱ����ջ
                    operator.push(infixExpression.pop());
                } else if (operatorLevel.get(infixExpression.peek()) == 1) { //���Ϊ�����ų�ջ��������׺���ʽջֱ������ջ������������
                    infixExpression.pop();
                    while (operatorLevel.get(operator.peek()) != 4) {
                        postfixExpression.push(operator.pop());
                    }
                    operator.pop();
                } else if (operatorLevel.get(operator.peek()) == 4) { //���ջ��Ϊ������ֱ����ջ
                    operator.push(infixExpression.pop());
                } else if (operatorLevel.get(infixExpression.peek()) > operatorLevel.get(operator.peek())) { //�����ջ���ķ������ȼ�����ջ
                    operator.push(infixExpression.pop());
                } else if (operatorLevel.get(infixExpression.peek()) <= operatorLevel.get(operator.peek())) { //�������ջ�����ȼ��߷���ջ��ջ�����׺���ʽջ
                    postfixExpression.push(operator.pop());
                }
            } else { //��ֱ����ջ
                postfixExpression.push(infixExpression.pop());
            }
        }
        while (operator.size() > 0) { //������ջ��ʣ��ķ��Ŵ�����׺���ʽջ
            postfixExpression.push(operator.pop());
        }
        reverseStack(postfixExpression); //��תջ
        return postfixExpression;
    }

    /**
     * ��׺���ʽ�õ�ֵ
     * @param postfixExpression ��׺���ʽ
     * @return ���ʽ������
     */
    private Double getBackValue(Stack<String> postfixExpression) {
        Stack<Double> value = new Stack<>(); //��ֵջ
        while (postfixExpression.size() > 0) {
            if (isOperate(postfixExpression.peek().charAt(0)) && postfixExpression.peek().length() == 1) { //����������
                //����ֵջ��ȡ��������
                Double numDouble_1 = value.pop();
                Double numDouble_2 = value.pop();
                switch (postfixExpression.pop().charAt(0)) { //���������������Ӧ������
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
            } else { //��������ֽ�Stringת����doubleֱ�Ӵ�����ֵջ
                value.push(Double.parseDouble(postfixExpression.pop()));
            }
        }
        return value.pop();
    }

    /**
     * �ж��Ƿ������0
     * @param number_1 ������
     * @param number_2 ����
     * @return ����ֵ�����쳣����
     */
    private Double divideCheck(Double number_1, Double number_2) {
        if (number_1 == 0) {
            throw new ArithmeticException("Divisor cannot be zero");
        }
        return number_2 / number_1;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(); //ʵ��һ������
        Scanner cin = new Scanner(System.in);
        String data = "";
        final String results = "results.txt";
        System.out.println("Enter the name of the file that contains the data:");
        data += cin.nextLine(); //����������ݵ�txt�ļ���
        cin.close();
        if (!data.endsWith(".txt")) {
            data += ".txt";
        }
        File myData = new File(data); //�ҵ�����ļ�
        if (!myData.exists()) { //���û��������ֵ��ļ�������ļ������ڲ�����
            System.out.println("There is no file for data entry!!!");
            System.exit(1);
        }
        try {
            Scanner input = new Scanner(myData); //�����ļ�����
            File myResult = new File(results);
            PrintWriter output = new PrintWriter(myResult); //��������ļ�
            while (input.hasNext()) { //�ļ���Ϊ�ռ�����ȡ
                String expression = input.nextLine();
                expression = calculator.removeStringSpace(expression); //ȥ�����ʽ����ո�
                if (expression.endsWith("=")) {
                    expression = expression.substring(0, expression.length() - 1);
                }
                if (!calculator.isValid(expression)) { //������ʽ�Ƿ�Ϸ�
                    output.println("ERROR");
                    output.println("#" + expression);
                    continue;
                }
                Stack<String> infixExpression = calculator.getInfixExpression(expression); //��׺����ջ��
                Stack<String> postfixExpression = calculator.getPostfixExpression(infixExpression); //��׺ת��׺
                try {
                    double result = calculator.getBackValue(postfixExpression); //�����׺���ʽ�õ�ֵ
                    if ((int) result - result == 0) { //�����һ���������������
                        output.println(expression + "=" + (int) result);
                    } else {
                        output.println(expression + "=" + result);
                    }
                } catch (Exception ex) { //����Ƿ���ڳ���0�ļ���
                    output.println("ERROR");
                    output.println("#" + expression);
                }
            }
            input.close();
            output.close();
            System.out.println("Calculate complete");
        } catch (FileNotFoundException e) { //����ļ������Ƿ�ɶ�
            e.printStackTrace();
        }
    }
}
