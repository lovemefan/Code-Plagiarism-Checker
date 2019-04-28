package assignment1;

public class Stack {
	public StackNode top;//ջ��
	
	//��ʼ��ջ
	public Stack() {
		top = new StackNode();
	}
	
	//@TODO ��ԭ���ʽ��Ϊ��׺���ʽ
	public String toSuffixExpression(String str) {
		String str1 = "";
		String splitedStr[] = str.split(" ");//���ո�ָ�
		String suffixExpression = "";//��׺���ʽ(���)
		for (int i = 0; i < splitedStr.length; i++) {
			str1 = splitedStr[i];
			switch(str1){
				case "+":
				case "-":
					suffixExpression = symbolAddSub(suffixExpression, str1);
					break;
				case "*":
				case "/":
					suffixExpression = symbolMulDiv(suffixExpression, str1);
					break;
				case "(":
					push(str1);//��ջ
					break;
				case ")":
					suffixExpression = symbolRightBracket(suffixExpression, str1);
					break;
				default:
					suffixExpression = suffixExpression + " " + str1;//ֱ�����
					break;
			}
		}
		while(!isEmpty()) {//�������Ԫ��
			suffixExpression = suffixExpression + " " + pop();
		}
		suffixExpression = suffixExpression.trim();//ȥ��ͷ���ո�
		return suffixExpression;
	}
	
	//�����׺���ʽ
	public String calculateSuffixExpression(String str) {
		String str1 = "";
		String splitedStr[] = str.split(" ");//���ո�ָ�
		String result = "";
		
		for (int i = 0; i < splitedStr.length; i++) {
			str1 = splitedStr[i];
			if (isNumber(str1)) {
				push(str1);
			}
			else{
				String k = calculate(pop(), pop(), str1);//��ջ������ֵ
				if (k == "ERROR") {//����Ϊ��
					return "ERROR";
				}
				result = k;
				push(k);
			}
		}
		while(!isEmpty()) {//�������Ԫ��
			pop();
		}
		return result;
	}
	
	//Ԫ����ջ
	public void push(String str) {
		StackNode newNode = new StackNode(str);//����һ���½ڵ�
		newNode.nextNode = top;
		top = newNode;
	}
	
	//Ԫ�س�ջ
	public String pop() {//ɾ��һ���ڵ㲢������������
		String recv = top.symbol;
		top = top.nextNode;
		return recv;
	}
	
	//�ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		if (top.nextNode == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//�ж�һ���ַ����Ƿ�Ϊ����
	public boolean isNumber(String str) {
		char[] chs = str.toCharArray();
        int number = 0;
        for(int i = 0; i < chs.length; i++){
            if(chs[i] >= '0' && chs[i] <= '9') {
            	number++;
            }
        }
        if (chs.length == number) {
        	return true;
        }
        else {
        	return false;
        }
    }
	
	//��������
	public String calculate(String number1, String number2, String symbol) {
		double result = 0.0;
		double number1D = Double.parseDouble(number1);
		double number2D = Double.parseDouble(number2);
		
		
		switch(symbol) {
		case "+":
			result = number2D + number1D;
			break;
		case "-":
			result = number2D - number1D;
			break;
		case "*":
			result = number2D * number1D;
			break;
		case "/":
			if (number1D == 0.0) {
				return "ERROR";
			}
			result = number2D / number1D;
			break;
		}
		
		return String.valueOf(result);
	}
	
	//�����ǼӼ��ŵĴ�����
	public String symbolAddSub(String suffixExpression, String str1) {
		while (!top.symbol.equals("(") && top.nextNode != null) {//ջ��Ԫ�ز�Ϊ������
			suffixExpression = suffixExpression + " " + pop();//ջ��Ԫ�س�ջ
		}
		push(str1);//��ǰԪ����ջ
		return suffixExpression;
	}
	
	//�����ǳ˳��ŵĴ�����
	public String symbolMulDiv(String suffixExpression, String str1) {
		while (!top.symbol.equals("(")) {//ջ��Ԫ�ز�Ϊ������
			if (top.symbol.equals("*") || top.symbol.equals("/")) {//�÷��ŵ����ȼ�������ջ��Ԫ�ص����ȼ�
				suffixExpression = suffixExpression + " " + pop();//ջ��Ԫ�س�ջ
			}
			else {	
				break;
			}
		}
		push(str1);//��ǰԪ����ջ
		return suffixExpression;
	}
	
	//�����������ŵĴ�����
	public String symbolRightBracket(String suffixExpression, String str1) {
		while (!top.symbol.equals("(")) {//��������ǰһֱ��ջ
			suffixExpression = suffixExpression + " " + pop();
		}
		pop();//ɾ��������
		return suffixExpression;
	}
	
}
