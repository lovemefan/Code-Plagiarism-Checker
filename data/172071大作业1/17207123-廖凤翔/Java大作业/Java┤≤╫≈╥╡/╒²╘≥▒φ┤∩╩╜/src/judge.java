import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
public class judge{
	static File fi = new File("src\\count");
	private static Stack<Character> stack;
	public static Object compute(String s) throws ScriptException {//当排除后用来计算表达式
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Object result = engine.eval(s);
		return result;
	}
	public static void clearInfoForFile(File f) {//清空文件夹
	    try {
	    	if(!f.exists()) {
	    		f.createNewFile();
	        }
	        FileWriter fileWriter =new FileWriter(f);
	        fileWriter.write("");
	        fileWriter.flush();
	        fileWriter.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	      }
	 }
	public static boolean True(String s) {//判断括号是否匹配
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
	public static void Test(String a) throws ScriptException, IOException {//用来判断输入的式子是否符合标准
		String s=a.replaceAll("\\s*","");
		boolean tens = false;
		Pattern one = Pattern.compile("[\\+\\-\\*\\/]{2,}");//运算符连续
		Matcher onet = one.matcher(s);
		boolean ones = onet.find();
		Pattern two = Pattern.compile("\\([\\+\\-\\*\\/]");//(左括号后面是运算符,运算符连续
		Matcher twot = two.matcher(s);
		boolean twos = twot.find();
		Pattern three = Pattern.compile("[\\+\\-\\*\\/]\\)");//)右括号前面是运算符,运算符连续
		Matcher threet = three.matcher(s);
		boolean threes = threet.find();
		Pattern four = Pattern.compile("\\(\\)");//空括号
		Matcher fourt = four.matcher(s);
		boolean fours = fourt.find();
/*		Pattern five = Pattern.compile("[a-zA-Z]");//包含非法字符
		Matcher fivet = five.matcher(s);*/
		boolean fives = s.matches("[\\+\\-\\*\\d\\.\\/\\(\\)]*");
		Pattern six = Pattern.compile("\\)\\d");//小括号后无运算符，括号非最后一个字符
		Matcher sixt = six.matcher(s);
		boolean sixs = sixt.find();
		Pattern seven = Pattern.compile("\\d\\(");//小括号前无运算符，括号非最后一个字符
		Matcher sevent = seven.matcher(s);
		boolean sevens = sevent.find();
		Pattern eight = Pattern.compile("^[\\+\\-\\*\\/]");//运算符前无运算数
		Matcher eightt = eight.matcher(s);
		boolean eights = eightt.find();
		Pattern nine = Pattern.compile("[\\+\\-\\*\\/]$");//运算符后无运算数
		Matcher ninet = nine.matcher(s);
		boolean nines = ninet.find();
		tens = True(s);
		int judge;
		if(s.length()==0) {
			judge = 1;
		}
		else if(ones) {
			judge = 2;
		}
		else if(twos) {
			judge = 2;
		}
		else if(threes) {
			judge = 2;
		}
		else if(fours) {
			judge = 3;
		}
		else if(!fives) {
			judge = 4;
		}
		else if(sixs) {
			judge = 5;
		}
		else if(sevens) {
			judge = 6;
		}
		else if(eights) {
			judge = 7;
		}
		else if(nines) {
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
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"\r\nERROR\r\n" + "#表达式为空");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 2:
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"\r\nERROR\r\n" + "#运算符连续");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 3:
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"\r\nERROR\r\n" + "#表达式中有空括号");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 4:
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"\r\nERROR\r\n" + "表达式包含非法字符");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 5:
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"\r\nERROR\r\n" + "#小括号后无运算符，括号非最后一个字符 ");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 6:
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"\r\nERROR\r\n" + "#括号非第一个字符且之前无运算符");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 7:
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"\r\nERROR\r\n" + "#运算符前无运算数 ");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 8:
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"\r\nERROR\r\n" + "#运算符后无运算数 ");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 9:
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"\r\nERROR\r\n" + "#括号不匹配 ");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			break;
		case 10:
			Object t = compute(s);
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"="+t);
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
		}
	}
	public static void Read(File f) throws ScriptException, IOException {
		String s = null;
		clearInfoForFile(fi);
		try (Scanner input = new Scanner(f);){
			while(input.hasNext()) {
				s = input.nextLine();
				Test(s);
			}
		}
	}
}