
import java.util.*;


public class A1 {
    //������������þ���ʹ�ÿո�ָ��ַ������Ա����ʹ�÷ָ��ʹ�ý��ַ����ָ������
    public String Sum(String sum) {
        String result = "";
        for (int i = 0; i < sum.length(); i++) {//������������þ���ʹ�ÿո�ָ��ַ������Ա����ʹ�÷ָ��ʹ�ý��ַ����ָ������
            if (sum.charAt(i) == '(' ||
            	sum.charAt(i) == ')' ||   
            	sum.charAt(i) == '+' ||
            	sum.charAt(i) == '-' || 
            	sum.charAt(i) == '*' || 
            	sum.charAt(i) == '/')
                result += " " + sum.charAt(i) + " ";
            else
                result += sum.charAt(i);
        }
        return result;
    }
    public void C1(Stack<Integer> operandStack, Stack<Character> operatorStack) {  //������������þ��Ǵ���ջ�е��������ݣ�Ȼ��ջ�е�������������֮�󽫽���洢��ջ��
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
    
    public int Z1(String expression) {
    	
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        
        expression = Sum(expression);
        
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            if (token.length() == 0)   //����ǿո�Ļ��ͼ���ѭ����ʲôҲ������.
                continue;
            
            //����ǼӼ��Ļ�����Ϊ�Ӽ������ȼ���ͣ���������ֻҪ�����Ӽ��ţ����۲�����ջ�е���ʲô�������Ҫ����
            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
            	
                //��ջ���ǿյģ�����ջ���������һ��Ԫ���ǼӼ��˳���������һ��
                while (!operatorStack.isEmpty()&&
                		(operatorStack.peek() == '-' 
                		|| operatorStack.peek() == '+' 
                		|| operatorStack.peek() == '/' 
                		|| operatorStack.peek() == '*')) {
                    C1(operandStack, operatorStack);   //��ʼ����
                }
                operatorStack.push(token.charAt(0));   //������֮�󽫵�ǰ���������ջ
            }

            else if (token.charAt(0) == '*' || token.charAt(0) == '/') {  //��ǰ������ǳ˳���ʱ����Ϊ���ȼ����ڼӼ������Ҫ�ж���������Ƿ��ǳ˳�������ǳ˳������㣬����Ļ�ֱ����ջ
                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
                    C1(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));   //����ǰ��������ջ
            }
            
            else if (token.trim().charAt(0) == '(') {//����������ŵĻ�ֱ����ջ��ʲôҲ���ò���,trim()����������ȥ���ո�ģ���������ķָ�������ܻ�����������пո�
                operatorStack.push('(');
            }
            
            else if (token.trim().charAt(0) == ')') {//����������ŵĻ������ջ�е������ֱ��������
                while (operatorStack.peek() != '(') {
                    C1(operandStack, operatorStack);    //��ʼ����
                }
                operatorStack.pop();   //�������������֮�����������
            }

            else {            //������������ֵĻ�ֱ�������ݵ�ջ
                operandStack.push(Integer.parseInt(token));   //�������ַ���ת��������Ȼ��ѹ��ջ��
            }
        }

        while (!operatorStack.isEmpty()) {        //���ջ�в��ǿյ�ʱ��������㣬֪��ջ��Ϊ�ռ���
            C1(operandStack, operatorStack);
        }
        return operandStack.pop();    //��ʱ����ջ�е����ݾ�������Ľ��
    }


 
}