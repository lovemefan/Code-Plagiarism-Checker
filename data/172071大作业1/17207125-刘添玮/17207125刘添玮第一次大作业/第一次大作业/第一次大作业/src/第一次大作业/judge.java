package ��һ�δ���ҵ;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
public class judge{
	private static Stack<Character> stack;
	File f;
	public judge(File f) {
		this.f=f;
	}
	public  boolean True(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else if (s.charAt(i) == ')') {
                if (stack.empty())
                    return true;
                if (stack.peek() == '(')
                    stack.pop();
                else
                    return true;
            }
        }
		return !stack.empty() ? true : false;
	}
	public  int Test(String a) throws ScriptException, IOException {
		String s=a.replaceAll("\\s*","");
		boolean tens = false;
		Pattern first = Pattern.compile("[\\+\\-\\*\\/]{2,}");//���������
		Matcher firstM = first.matcher(s);
		boolean firstB = firstM.find();
		Pattern second= Pattern.compile("\\([\\+\\-\\*\\/]");//(�����ź����������,���������
		Matcher secondM = second.matcher(s);
		boolean secondB = secondM.find();
		Pattern third = Pattern.compile("[\\+\\-\\*\\/]\\)");//)������ǰ���������,���������
		Matcher thirdM = third.matcher(s);
		boolean thirdB = thirdM.find();
		Pattern fourth = Pattern.compile("\\(\\)");//������
		Matcher fourthM = fourth.matcher(s);
		boolean fourthB = fourthM.find();
		Pattern five = Pattern.compile("[a-zA-Z]");//�����Ƿ��ַ�
		Matcher fiveM = five.matcher(s);
		boolean fiveB = fiveM.find();
		Pattern six = Pattern.compile("\\)\\d");//С���ź�������������ŷ����һ���ַ�
		Matcher sixM = six.matcher(s);
		boolean sixB = sixM.find();
		Pattern seven = Pattern.compile("\\d\\(");//С����ǰ������������ŷ����һ���ַ�
		Matcher sevenM = seven.matcher(s);
		boolean sevenB = sevenM.find();
		Pattern eight = Pattern.compile("^[\\+\\-\\*\\/]");//�����ǰ��������
		Matcher eightM = eight.matcher(s);
		boolean eightB = eightM.find();
		Pattern nine = Pattern.compile("[\\+\\-\\*\\/]$");//���������������
		Matcher nineM = nine.matcher(s);
		boolean nineB = nineM.find();
		tens = True(s);
		int judge;
		if(s.length()==0) {
			judge = 1;
		}
		else if(firstB) {
			judge = 2;
		}
		else if(secondB) {
			judge = 2;
		}
		else if(thirdB) {
			judge = 2;
		}
		else if(fourthB) {
			judge = 3;
		}
		else if(fiveB) {
			judge = 4;
		}
		else if(sixB) {
			judge = 5;
		}
		else if(sevenB) {
			judge = 6;
		}
		else if(eightB) {
			judge = 7;
		}
		else if(nineB) {
			judge = 8;
		}
		else if(tens) {
			judge = 9;
		}
		else {
			judge = 10;
		}
		switch(judge) {
		case 1:
			try {
				FileWriter output = new FileWriter(f,true);
				output.write(s+" ERROR\r\n" + "#���ʽΪ��");
				output.write("\r\n");
				output.flush();	
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 2:
			try {
				FileWriter output = new FileWriter(f,true);
				output.write(s+" ERROR\r\n" + "#���������");
				output.write("\r\n");
				output.flush();	
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 3:
			try {
				FileWriter output = new FileWriter(f,true);
				output.write(s+" ERROR\r\n" + "#���ʽ���п�����");
				output.write("\r\n");
				output.flush();
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 4:
			try {
				FileWriter output = new FileWriter(f,true);
				output.write(s+" ERROR\r\n" + "���ʽ�����Ƿ��ַ�");
				output.write("\r\n");
				output.flush();	
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 5:
			try {
				FileWriter output = new FileWriter(f,true);
				output.write(s+" ERROR\r\n" + "#С���ź�������������ŷ����һ���ַ� ");
				output.write("\r\n");
				output.flush();
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 6:
			try {
				FileWriter output = new FileWriter(f,true);
				output.write(s+" ERROR\r\n" + "#���ŷǵ�һ���ַ���֮ǰ�������");
				output.write("\r\n");
				output.flush();	
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 7:
			try {
				FileWriter output = new FileWriter(f,true);
				output.write(s+" ERROR\r\n" + "#�����ǰ�������� ");
				output.write("\r\n");
				output.flush();
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 8:
			try {
				FileWriter output = new FileWriter(f,true);
				output.write(s+" ERROR\r\n" + "#��������������� ");
				output.write("\r\n");
				output.flush();	
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 9:
			try {
				FileWriter output = new FileWriter(f,true);
				output.write(s+"ERROR\r\n" + "#���Ų�ƥ�� ");
				output.write("\r\n");
				output.flush();	
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 10:
			System.out.println("Success");
		}
		return judge;
	}
}
