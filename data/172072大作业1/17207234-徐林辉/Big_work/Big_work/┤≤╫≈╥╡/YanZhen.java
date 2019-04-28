package ����ҵ;

import java.io.File;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YanZhen {
	
	public boolean isTrue(String s) {
	
		Pattern regularString = Pattern.compile("\\s");//ƥ��ձ��ʽ
		Matcher m = regularString.matcher(s);
		if(m.find() == true){
			System.out.println("ERROR");
			System.out.println("#���ʽΪ��");
			return false;
		}

		Pattern regularString1 = Pattern.compile("\\(\\)");//ƥ�������
		Matcher n1 = regularString1.matcher(s);
		if(n1.find() == true) {
			System.out.println("ERROR");
			System.out.println("#���ʽ���п�����");
			return false;
		}
		
		Pattern regularString2 = Pattern.compile("([A-Za-z]|`|!|,|#|&|\\\\|:|;|<|>|%|=|\\$|\\.)");//ƥ��Ƿ��ַ�
		Matcher n2 = regularString2.matcher(s);
		if(n2.find() == true) {
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
		Matcher n4 = regularString4.matcher(s);
		if(n4.find() == true) {
			System.out.println("ERROR");
			System.out.println("#���������");
			return false;
		}
		
		Pattern regularString5 = Pattern.compile("\\([\\+\\-\\*\\/]");//�����ǰ��������
		Matcher n5 = regularString5.matcher(s);
		if(n5.find() == true) {
			System.out.println("ERROR");
			System.out.println("#�����ǰ��������");
			return false;
		}
		
		Pattern regularString6 = Pattern.compile("[\\+\\-\\*\\/]\\)");//���������������
		Matcher n6 = regularString6.matcher(s);
		if(n6.find() == true) {
			System.out.println("ERROR");
			System.out.println("#���������������");
			return false;
		}
		//[0-9[+][-][*][/]]*[0-9][(][0-9[+][-][*][/]]*"
		Pattern regularString7 = Pattern.compile("[0-9\\+\\-\\*\\/]*[0-9][(][0-9\\+\\-\\*\\/]*");
		Matcher n7 = regularString7.matcher(s);
		if(n7.find() == true) {
			System.out.println("ERROR");
			System.out.println("#���ŷǵ�һ���ַ�,��֮ǰ�������");
			return false;
		}
		
		Pattern regularString8 = Pattern.compile("[0-9\\+\\-\\*\\/]*[)][0-9][0-9\\+\\-\\*\\/]*");
		Matcher n8 = regularString8.matcher(s);
		if(n8.find() == true) {
			System.out.println("ERROR");
			System.out.println("#С���ź�������������ŷ����һ���ַ�");
			return false;
		}
		
		else
			return true;
		
	}

}
