import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class stacks {
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
                continue;
            //����ǼӼ��Ļ�����Ϊ�Ӽ������ȼ���ͣ���������ֻҪ�����Ӽ��ţ����۲�����ջ�е���ʲô�������Ҫ����
            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                //��ջ���ǿյģ�����ջ���������һ��Ԫ���ǼӼ��˳���������һ��
                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '-' || operatorStack.peek() == '+' || operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
                    processAnOperator(operandStack, operatorStack);   //��ʼ����
                }
                operatorStack.push(token.charAt(0));   //������֮�󽫵�ǰ���������ջ
            }
            //��ǰ������ǳ˳���ʱ����Ϊ���ȼ����ڼӼ������Ҫ�ж���������Ƿ��ǳ˳�������ǳ˳������㣬����Ļ�ֱ����ջ
            else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
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
        return operandStack.pop();    //��ʱ����ջ�е����ݾ�������Ľ��
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
    
    
    
    	
		
	
    static String expression;
    
    public static void main(String[] args) {
    	stacks s = new stacks();
    	File f = new File("src\\test.txt");
    	
    	try (Scanner input = new Scanner(f);){
			while(input.hasNext()) {
				expression = input.next();
				int n1=0,n2=0;
		        for(int i=0;i<expression.length();i++) {
		        	char ch='(';
		        	if(expression.charAt(i)==ch)
		        		n1++;
		        }
		        for(int i=0;i<expression.length();i++) {
		        	char ch=')';
		        	if(expression.charAt(i)==ch) 
		        		n2++;
		        }
		        if(expression=="") {
		        	System.out.println("ERROR #���ʽΪ��");
		        	
		        }
		        else if(expression.matches(".*(\\(\\))+.*")){
		        	System.out.println("ERROR #���ʽ���п�����");
		        }
		        else if(expression.matches(".*[^\\d\\(\\)\\+\\-\\*\\/].*")) {
		        	System.out.println("ERROR #���ʽ�����Ƿ��ַ�");
		        }
		        else if(expression.matches(".*[\\+\\-\\*\\/][\\)].*")) {
		        	System.out.println("ERROR #���Ų�ƥ��");
		        }
		        else if((expression.matches(".*[\\+\\-\\*\\/][\\)].*"))||(n1!=n2)) {
		        	System.out.println("ERROR #���Ų�ƥ��");
		        }
		        else if(expression.matches(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*")) {
		        	System.out.println("ERROR #���������");
		        }
		        else if(expression.matches(".*\\([\\+\\-\\*\\/].*")) {
		        	System.out.println("ERROR #�����ǰ��������");
		        }
		        else if(expression.matches(".*[\\+\\-\\*\\/]\\).*")) {
		        	System.out.println("ERROR #���������������");
		        }
		        else if(expression.matches(".*\\d\\(.*")) {
		        	System.out.println("ERROR #���ŷǵ�һ���ַ���֮ǰ��������");
		        }
		        else if(expression.matches(".*\\)\\d.*")) {
		        	System.out.println("ERROR #С���ź��������������ŷ����һ���ַ�");
		        }
		        else{
		        	int data = s.evaluateExpression(expression);
		        	System.out.println(data);
		        }
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
    }
}
 
