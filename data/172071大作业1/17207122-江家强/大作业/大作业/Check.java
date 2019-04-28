package ����ҵ;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptException;

public class Check{
	 File fi = new File("src\\file");
	
	public  boolean Test(String a) throws ScriptException, IOException {
		String s=a.replaceAll("\\s*","");
		boolean tens = false;
		
		Pattern one = Pattern.compile("\\(\\)");//���ʽ���п�����(2)
		Matcher onet = one.matcher(s);
		boolean ones = onet.find();
		
		Pattern two = Pattern.compile("[a-zA-Z]");//���ʽ�����Ƿ��ַ�(3)
		Matcher twot = two.matcher(s);
		boolean twos = twot.matches();
		
		Pattern three = Pattern.compile("[\\+\\-\\*\\/]{2,}");//���������(5)
		Matcher threet = three.matcher(s);
		boolean threes = threet.find();
		
		Pattern four = Pattern.compile("\\([\\+\\-\\*\\/]");//(�����ź����������,���������(5)
		Matcher fourt = four.matcher(s);
		boolean fours = fourt.find();
		
		Pattern five = Pattern.compile("[\\+\\-\\*\\/]\\)");//)������ǰ���������,���������(5)
		Matcher fivet = five.matcher(s);
		boolean fives = fivet.find();	
		
		Pattern six = Pattern.compile("^[\\+\\-\\*\\/]");//�������Ч(�����ǰ��������)  (6)
		Matcher sixt = six.matcher(s);
		boolean sixs = sixt.matches();
		
		Pattern seven = Pattern.compile("[\\+\\-\\*\\/]$");//�������Ч(���������������)  (7)
		Matcher sevent = seven.matcher(s);
		boolean sevens = sevent.matches();
		
		Pattern eight = Pattern.compile("\\d\\(");//�������Ч(С����ǰ������������ŷ����һ���ַ�)  (8)
		Matcher eightt = eight.matcher(s);
		boolean eights = eightt.matches();
		
		Pattern nine = Pattern.compile("\\)\\d");//�������Ч(С���ź�������������ŷ����һ���ַ�)  (9)
		Matcher ninet = nine.matcher(s);
		boolean nines = ninet.matches();
		
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else if (s.charAt(i) == ')') {
                if (stack.empty())
                    tens = true;
                if (stack.peek() == '(')
                    stack.pop();
                else
                    tens = false;
            }
        }
		
		if(s.length()==0) {//�жϱ��ʽΪ��(1)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#���ʽΪ��");
				output.write("\r\n");
				output.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		else if(ones) {//�жϱ��ʽ���п�����(2)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#���ʽ���п�����");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		else if(twos) {//�жϱ��ʽ�����Ƿ��ַ�(3)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#���ʽ�����Ƿ��ַ�");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		else if(threes || fours || fives) {//�ж����������(5)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#���������");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 	
			return false;
		}
		else if(sixs) {//�ж������ǰ��������(6)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#�����ǰ��������");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		else if(sevens) {//�ж����������������(7)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#���������������");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		else if(eights) {//�ж����ŷǵ�һ���ַ���֮ǰ��������(8)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#���ŷǵ�һ���ַ���֮ǰ�������� ");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
			return false;
		}
		else if(nines) {//�ж�С���ź��������������ŷ����һ���ַ�(9) 
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#С���ź��������������ŷ����һ���ַ� ");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		else if(tens) {//�ж�����ƥ��(4)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#���Ų�ƥ�� ");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		else
			return true;
	}
	
	public String jckg(String ex) {
		String exp = new String();
		int i = 0,j = 0;
		while(ex.charAt(j)!='#') {
			if(ex.charAt(j)!=' ') {
				exp = exp + ex.charAt(j);
			}else
				i++;
			
			j++;
		}
		if(i>0)
			System.out.println(ex+"ʽ������"+i+"����Ч����   ������ɾ��");
		return exp;
	}
}
