package javaAssignment;

public class Negative {//������и�������ı��ʽ

	Negative() {

	}

	public String cNegative(String exp) {
			char ch1 = exp.charAt(0);
			char ch2 = exp.charAt(1);
			String temp = "";
			if (ch1 == '-' && (ch2 == '(' || (Character.isDigit(ch2)))) {//�����ʽ��һ���ַ���-���һ��0�ڱ��ʽǰ��
				temp = "0";
			}
			return expr(temp,exp);
		
	}
	
	public String expr(String temp,String exp){
		int i = 0;
		int j = exp.length();
		while (i < j - 2) {
			char ch1 = exp.charAt(i);
			char ch2 = exp.charAt(i + 1);
			char ch3 = exp.charAt(i + 2);
			if (ch1 == '(' && ch2 == '-' && (ch3 == '(' || (Character.isDigit(ch3)))) {//�����ʽ����(-(��(-�������һ��0��-ǰ
				temp += ch1;
				temp += '0';
				temp += ch2;
				i += 2;
				continue;
			}
			temp += ch1;
			i++;
		}
		return temp + exp.charAt(i) + exp.charAt(i + 1);//���ش�����ı��ʽ
	}

}
