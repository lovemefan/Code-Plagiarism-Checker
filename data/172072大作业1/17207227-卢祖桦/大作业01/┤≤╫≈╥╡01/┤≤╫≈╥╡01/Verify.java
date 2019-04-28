package ����ҵ01;

import java.io.File;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verify {
	
	public boolean isTrue(String s) {
	
		Pattern regularString = Pattern.compile("\\s");//ƥ��ձ��ʽ
		Matcher m = regularString.matcher(s);
		if(m.find() == true){
			System.out.println("ERROR");
			System.out.println("#���ʽΪ��");
			return false;
		}

		Pattern regularString1 = Pattern.compile("\\(\\)");//ƥ�������
		Matcher m1 = regularString1.matcher(s);
		if(m1.find() == true) {
			System.out.println("ERROR");
			System.out.println("#���ʽ���п�����");
			return false;
		}
		
		Pattern regularString2 = Pattern.compile("([A-Za-z]|`|!|,|#|&|\\\\|:|;|<|>|%|=|\\$|\\.)");//ƥ��Ƿ��ַ�
		Matcher m2 = regularString2.matcher(s);
		if(m2.find() == true) {
			System.out.println("ERROR");
			System.out.println("#���ʽ�����Ƿ��ַ�");
			return false;
		}
		
		
		Stack var=new Stack();//���Ų�ƥ�����
		char item;
		for(int i = 0;i < s.length();i++) {
			item = s.charAt(i);
			if(item == '(') {
				var.push(item);
			}
			else if(item == ')') {
				if(var.isEmpty() == false) {
					var.pop();
				}
				else {
					System.out.println("ERROR");
					System.out.println("#���Ų�ƥ��");
					return false;
				}
			}
			
		}
		 if(var.isEmpty() == false) {
			System.out.println("ERROR");
			System.out.println("#���Ų�ƥ��");
			return false;
		}
		
		Pattern regularString4 = Pattern.compile("[\\+\\-\\*\\/]{2,}");//���������
		Matcher m4 = regularString4.matcher(s);
		if(m4.find() == true) {
			System.out.println("ERROR");
			System.out.println("#���������");
			return false;
		}
		
		Pattern regularString5 = Pattern.compile("\\([\\+\\-\\*\\/]");//�����ǰ��������
		Matcher m5 = regularString5.matcher(s);
		if(m5.find() == true) {
			System.out.println("ERROR");
			System.out.println("#�����ǰ��������");
			return false;
		}
		
		Pattern regularString6 = Pattern.compile("[\\+\\-\\*\\/]\\)");//���������������
		Matcher m6 = regularString6.matcher(s);
		if(m6.find() == true) {
			System.out.println("ERROR");
			System.out.println("#���������������");
			return false;
		}
		
		else
			return true;
		
	}

}
