package ooExperiment2;

import java.util.Stack;

public class Check {
	
public String match(String s) {
		
		Stack<Character> st = new Stack<Character>();//����һ��ջ,ջ�ڴ��ַ�
		
		
		
		String[] t = s.split(" ");//������ַ����еĿո񲢽������ַ����浽�ַ���������         split()���÷�
		
		String news = "";
		
	    for(int i = 0;i < t.length;i ++){//���ַ����������ַ���ת����һ���ַ���
	    	
	    	news += t[i];
	    }
	    
		//У����ѧ���ʽ
		String regex = "[\\(]*[1-9]+[\\)]*+(([\\+\\-\\*\\/]{1}[\\(]*[\\d]+)+[\\)]*)+";
				
		boolean match = news.matches(regex);
		
		//ƥ������
		if (match ) {
			char[] c = news.toCharArray();       //���ַ���ת��Ϊ�ַ�����   toCharArray()���÷�
			for (int i = 0; i < c.length; i++) {
				if (c[i] == '(') {
					st.push(c[i]);          //���������ţ��� ��ջ
				} else if (c[i] == ')') {      //����������
					if (st.isEmpty()) {          //ջΪ������ʽ���Ϸ�
						
						return "ERROR" + "\n" + "#���Ų�ƥ��";
						
					} else if (st.peek() == '(');  //ջ��Ϊ��ȡ��ջ��Ԫ�أ�ջ��Ԫ��Ϊ �� ����  ����ջ
					st.pop();
				
				}
			}
			if (st.empty()) {           //ѭ��������ջΪ������ѧ���ʽ�Ϸ�
				return "true";
			} else {
				
				return "ERROR" + "\n" + "#���Ų�ƥ��";
			}
		} else {
			
			return "ERROR" + "\n" + "#���ʽ���Ϸ�";
		}
		
	}
	//�ж��Ƿ�������
			public boolean isDigital(char ch){
				if (ch > '0' && ch < '9'){     //�ж��ַ��Ƿ�������
					return true;
				}else{
					return false;
				}
			}

}
