package 大作业;
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
		
		Pattern one = Pattern.compile("\\(\\)");//表达式中有空括号(2)
		Matcher onet = one.matcher(s);
		boolean ones = onet.find();
		
		Pattern two = Pattern.compile("[a-zA-Z]");//表达式包含非法字符(3)
		Matcher twot = two.matcher(s);
		boolean twos = twot.matches();
		
		Pattern three = Pattern.compile("[\\+\\-\\*\\/]{2,}");//运算符连续(5)
		Matcher threet = three.matcher(s);
		boolean threes = threet.find();
		
		Pattern four = Pattern.compile("\\([\\+\\-\\*\\/]");//(左括号后面是运算符,运算符连续(5)
		Matcher fourt = four.matcher(s);
		boolean fours = fourt.find();
		
		Pattern five = Pattern.compile("[\\+\\-\\*\\/]\\)");//)右括号前面是运算符,运算符连续(5)
		Matcher fivet = five.matcher(s);
		boolean fives = fivet.find();	
		
		Pattern six = Pattern.compile("^[\\+\\-\\*\\/]");//运算符无效(运算符前无运算数)  (6)
		Matcher sixt = six.matcher(s);
		boolean sixs = sixt.matches();
		
		Pattern seven = Pattern.compile("[\\+\\-\\*\\/]$");//运算符无效(运算符后无运算数)  (7)
		Matcher sevent = seven.matcher(s);
		boolean sevens = sevent.matches();
		
		Pattern eight = Pattern.compile("\\d\\(");//运算符无效(小括号前无运算符，括号非最后一个字符)  (8)
		Matcher eightt = eight.matcher(s);
		boolean eights = eightt.matches();
		
		Pattern nine = Pattern.compile("\\)\\d");//运算符无效(小括号后无运算符，括号非最后一个字符)  (9)
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
		
		if(s.length()==0) {//判断表达式为空(1)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#表达式为空");
				output.write("\r\n");
				output.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		else if(ones) {//判断表达式中有空括号(2)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#表达式中有空括号");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		else if(twos) {//判断表达式包含非法字符(3)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#表达式包含非法字符");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		else if(threes || fours || fives) {//判断运算符连续(5)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#运算符连续");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 	
			return false;
		}
		else if(sixs) {//判断运算符前无运算数(6)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#运算符前无运算数");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		else if(sevens) {//判断运算符后无运算数(7)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#运算符后无运算数");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		else if(eights) {//判断括号非第一个字符且之前无运算数(8)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#括号非第一个字符且之前无运算数 ");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
			return false;
		}
		else if(nines) {//判断小括号后无运算数，括号非最后一个字符(9) 
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#小括号后无运算数，括号非最后一个字符 ");
				output.write("\r\n");
				output.flush();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		else if(tens) {//判断括号匹配(4)
			try {
				FileWriter output = new FileWriter(fi,true);
				output.write(s+"   ERROR\r\n" + "#括号不匹配 ");
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
			System.out.println(ex+"式子中有"+i+"个无效输入   并且已删除");
		return exp;
	}
}
