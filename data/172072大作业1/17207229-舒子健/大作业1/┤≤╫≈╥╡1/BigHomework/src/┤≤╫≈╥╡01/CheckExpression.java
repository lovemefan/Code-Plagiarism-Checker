package ����ҵ01;

import java.util.regex.Matcher; 
import java.util.regex.Pattern;

/*������ʽ��*/
public class CheckExpression {

	public void checkExp(String expression) {
		
		if(expression.matches("")) {//�ձ��ʽ
			System.out.println("ERROR");
			System.out.println("#���ʽΪ��"); 
		//	return 1;
		}
		
		Pattern pattern1 = Pattern.compile("\\(\\)");//������
		Matcher m1 = pattern1.matcher(expression);
		if(m1.find()) {	//��ƥ�䵽�򷵻�ture,���򷵻�false
			System.out.println("ERROR");
			System.out.println("#���ʽ���п�����");
		//	return 2;
		}
		
		Pattern pattern2 = Pattern.compile("[a-zA-Z[ _`~!@#$%^&=|{}':;',\\\\[\\\\].<>����&������������������]]");//�Ƿ��ַ�
		Matcher m2 = pattern2.matcher(expression);
		if(m2.find()) {	//��ƥ�䵽�򷵻�ture,���򷵻�false
			System.out.println("ERROR");
			System.out.println("#���ʽ�����Ƿ��ַ�");
		//	return 3;
		}
		
		Pattern pattern3 = Pattern.compile("[[+][-][*][/]]{2,}");//���������
		Matcher m3 = pattern3.matcher(expression);
		if(m3.find()) {	//��ƥ�䵽�򷵻�ture,���򷵻�false
			System.out.println("ERROR");
			System.out.println("#���������");
		//	return 4;
		}
		//return 0;
	}
}
