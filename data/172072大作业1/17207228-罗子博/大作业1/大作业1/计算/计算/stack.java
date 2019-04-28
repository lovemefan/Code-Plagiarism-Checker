package ����;

import java.util.Scanner;
import java.util.Stack;

public class stack {
    //������������þ���ʹ�ÿո�ָ��ַ������Ա����ʹ�÷ָ��ʹ�ý��ַ����ָ������
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
            if (token.length() == 0)   //����ǿո�Ļ��ͼ���ѭ����ʲôҲ������
            	//  System.out.println("error");
                continue;
            //����ǼӼ��Ļ�����Ϊ�Ӽ������ȼ���ͣ���������ֻҪ�����Ӽ��ţ����۲�����ջ�е���ʲô�������Ҫ����
                else     if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                //��ջ���ǿյģ�����ջ���������һ��Ԫ���ǼӼ��˳���������һ��
                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '-'
                		|| operatorStack.peek() == '+' ||
                		operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
                    processAnOperator(operandStack, operatorStack);   //��ʼ����
                }
                operatorStack.push(token.charAt(0));   //������֮�󽫵�ǰ���������ջ
            }
            //��ǰ������ǳ˳���ʱ����Ϊ���ȼ����ڼӼ������Ҫ�ж���������Ƿ��ǳ˳�������ǳ˳������㣬����Ļ�ֱ����ջ
            else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '/' || operatorStack.peek() == '*'))
                {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));   //����ǰ��������ջ
            }
            //����������ŵĻ�ֱ����ջ��ʲôҲ���ò���,trim()����������ȥ���ո�ģ���������ķָ�������ܻ�����������пո�
            else if (token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            }
            //����������ŵĻ������ջ�е������ֱ��������
            else if (token.trim().charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);    //��ʼ����
                }
                operatorStack.pop();   //�������������֮�����������
            }
            //������������ֵĻ�ֱ�������ݵ�ջ
            else {
                operandStack.push(Integer.parseInt(token));   //�������ַ���ת��������Ȼ��ѹ��ջ��
            }
        }
        //���ջ�в��ǿյ�ʱ��������㣬֪��ջ��Ϊ�ռ���
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }
        return operandStack.pop(); //��ʱ����ջ�е����ݾ�������Ľ��
 
    }

    //������������þ��Ǵ���ջ�е��������ݣ�Ȼ��ջ�е�������������֮�󽫽���洢��ջ��
    public void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();  //����һ��������
        int op1 = operandStack.pop();  //�Ӵ洢���ݵ�ջ�е������������������Ͳ�����op����
        int op2 = operandStack.pop();
        if (op == '+')  //���������Ϊ+��ִ�м�����
            operandStack.push(op1 + op2);
        else if (op == '-')
            operandStack.push(op2 - op1);   //��Ϊ�����ջ�Ľṹ����Ȼ������������Ǻ���ģ������op2-op1
        else if (op == '*')
            operandStack.push(op1 * op2);
        else if (op == '/')
            operandStack.push(op2 / op1);
    }

    public static void main(String[] args) {

        stack s = new stack();
        System.out.println("��׼���ʽ6+8+(3*8+6)");
        System.out.println("������ʽ" );
        Scanner input = new Scanner(System.in);
        String sum=input.next();
       String expression = sum;
        int data = s.evaluateExpression(expression);
       
        System.out.println("���Ϊ"+data);
    }
}
