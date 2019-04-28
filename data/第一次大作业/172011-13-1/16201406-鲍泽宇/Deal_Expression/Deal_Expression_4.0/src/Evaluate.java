import java.util.*;

//������ʽ��
public class Evaluate  {
    
//���췽��	
	Evaluate(){
		
	}
	
//�����ַ�����������
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
//��ջ���������ʽ����
    public double evaluate(String str) {
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        str = insetBlanks(str);
        String[] Arrays = str.split(" ");
        for (String Ar : Arrays) {
            if (Ar.length() == 0)   //����ǿո�Ļ��ͼ���ѭ����ʲôҲ������
                continue;
            //����ǼӼ��Ļ�����Ϊ�Ӽ������ȼ���ͣ���������ֻҪ�����Ӽ��ţ����۲�����ջ�е���ʲô�������Ҫ����
            else if (Ar.charAt(0) == '+' || Ar.charAt(0) == '-') {
                //��ջ���ǿյģ�����ջ���������һ��Ԫ���ǼӼ��˳���������һ��
                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '-' || operatorStack.peek() == '+' || operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
                    processAnOperator(operandStack, operatorStack);   //��ʼ����
                }
                operatorStack.push(Ar.charAt(0));   //������֮�󽫵�ǰ���������ջ
            }
            //��ǰ������ǳ˳���ʱ����Ϊ���ȼ����ڼӼ������Ҫ�ж���������Ƿ��ǳ˳�������ǳ˳������㣬����Ļ�ֱ����ջ
            else if (Ar.charAt(0) == '*' || Ar.charAt(0) == '/') {
                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(Ar.charAt(0));   //����ǰ��������ջ
            }
            //����������ŵĻ�ֱ����ջ��ʲôҲ���ò���,trim()����������ȥ���ո�ģ���������ķָ�������ܻ�����������пո�
            else if (Ar.trim().charAt(0) == '(') {
                operatorStack.push('(');
            }
            //����������ŵĻ������ջ�е������ֱ��������
            else if (Ar.trim().charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);    //��ʼ����
                }
                operatorStack.pop();   //�������������֮�����������
            }
            //������������ֵĻ�ֱ�������ݵ�ջ
            else {
                operandStack.push(Double.parseDouble(Ar));   //�������ַ���ת��������Ȼ��ѹ��ջ��
            }
        }
        //���ջ�в��ǿյ�ʱ��������㣬֪��ջ��Ϊ�ռ���
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }
        return operandStack.pop();    //��ʱ����ջ�е����ݾ�������Ľ��
    }

    //����ջ�в�����
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