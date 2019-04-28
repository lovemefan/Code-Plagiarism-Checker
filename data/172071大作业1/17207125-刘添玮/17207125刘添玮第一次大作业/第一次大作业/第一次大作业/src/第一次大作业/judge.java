package 第一次大作业;
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
		Pattern first = Pattern.compile("[\\+\\-\\*\\/]{2,}");//运算符连续
		Matcher firstM = first.matcher(s);
		boolean firstB = firstM.find();
		Pattern second= Pattern.compile("\\([\\+\\-\\*\\/]");//(左括号后面是运算符,运算符连续
		Matcher secondM = second.matcher(s);
		boolean secondB = secondM.find();
		Pattern third = Pattern.compile("[\\+\\-\\*\\/]\\)");//)右括号前面是运算符,运算符连续
		Matcher thirdM = third.matcher(s);
		boolean thirdB = thirdM.find();
		Pattern fourth = Pattern.compile("\\(\\)");//空括号
		Matcher fourthM = fourth.matcher(s);
		boolean fourthB = fourthM.find();
		Pattern five = Pattern.compile("[a-zA-Z]");//包含非法字符
		Matcher fiveM = five.matcher(s);
		boolean fiveB = fiveM.find();
		Pattern six = Pattern.compile("\\)\\d");//小括号后无运算符，括号非最后一个字符
		Matcher sixM = six.matcher(s);
		boolean sixB = sixM.find();
		Pattern seven = Pattern.compile("\\d\\(");//小括号前无运算符，括号非最后一个字符
		Matcher sevenM = seven.matcher(s);
		boolean sevenB = sevenM.find();
		Pattern eight = Pattern.compile("^[\\+\\-\\*\\/]");//运算符前无运算数
		Matcher eightM = eight.matcher(s);
		boolean eightB = eightM.find();
		Pattern nine = Pattern.compile("[\\+\\-\\*\\/]$");//运算符后无运算数
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
				output.write(s+" ERROR\r\n" + "#表达式为空");
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
				output.write(s+" ERROR\r\n" + "#运算符连续");
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
				output.write(s+" ERROR\r\n" + "#表达式中有空括号");
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
				output.write(s+" ERROR\r\n" + "表达式包含非法字符");
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
				output.write(s+" ERROR\r\n" + "#小括号后无运算符，括号非最后一个字符 ");
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
				output.write(s+" ERROR\r\n" + "#括号非第一个字符且之前无运算符");
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
				output.write(s+" ERROR\r\n" + "#运算符前无运算数 ");
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
				output.write(s+" ERROR\r\n" + "#运算符后无运算数 ");
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
				output.write(s+"ERROR\r\n" + "#括号不匹配 ");
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
