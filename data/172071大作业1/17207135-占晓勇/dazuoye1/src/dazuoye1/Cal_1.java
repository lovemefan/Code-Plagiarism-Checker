package dazuoye1;

import java.io.File;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import java.util.regex.Matcher;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Cal_1 {
	
	
	public void readLine(File f1, String[] shushi) {
		int i = 0;
		int j = 0;
		String str = null;/* 用于接收文件信息中不需要的信息 */
		try (Scanner input = new Scanner(f1);){
			while(input.hasNextLine()) {
				str = input.next();//接收不要的序号
				shushi[i] = input.nextLine();//将式子写入
				shushi[i] = shushi[i].replaceAll("\\s", "");//将式子中所有的空格去除
				i++;
			}
			for ( i=0; i<shushi.length; i++ ) 
			{
				for (  j=i+1; j<shushi.length; j++ ) {
					if ( String.valueOf( shushi[i] ).equals( String.valueOf(shushi[j]) ))
					{
						shushi[j] = null;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readrecords(File f2) {
		int i = 0;
		String str = null;/* 用于接收文件信息中不需要的信息 */
		try (Scanner input = new Scanner(f2);){
			while(input.hasNextLine()) {
				String s = input.nextLine();
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Object compute(String shushi) throws ScriptException {//当排除后用来计算表达式-
		String str = shushi;
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Object result = engine.eval(str);
		return result;
	}

	boolean UnmatchBrackets(String shushi) {// 如果括号不匹配，则返回 true;否则返回false
		int len = shushi.length();
		LinkedList<Character> stack = new LinkedList<Character>();
		// 循环遍历字符串
		for (int i = 0; i < len; i++) {
			// 如果是左括号则入栈
			char  ch = (char) shushi.charAt(i);
			if (ch == '(') {
				stack.push(ch);
				// 如果是右括号
			} else if (ch == ')') {
				// 栈空，则右括号没有匹配的左括号，则返回false
				if (stack.isEmpty()) {
					return true;
					// 栈不空，则和栈顶比较
				} else if (stack.peek().equals(ch)) {
					return true;
				} else {
					stack.pop();
				}
			}
		}
		// 循环结束后，栈空表示匹配完了，不空表示多余左括号
		if (stack.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	
	
	public void write ( File f2 , String[] shushi ) throws ScriptException
	{
		int i=0;
		/*正则表达式的匹配类型*/
		
		String regex1 = "";//空字符
		String regex2 = "\\(\\)";//空括号
		String regex3 = "[0-9\\\\.+-/*()= ]+";//非法字符
		String regex4 = ".*[\\/\\*\\-\\+]{2,}.*";//运算符连续
		String regex5 = "^[\\+\\-\\*\\/\\)].*";//运算符前无运算数
		String regex6 = ".*[\\(\\+\\/\\*\\-]";//运算符后无运算数
		String regex7 = ".+\\d\\(.*";//括号前无运算符,且括号不是第一个
		String regex8 = ".+\\)\\d.*";//括号后无运算符
		/*先判断是否是正确的表达式，如果是错误的，不进行去括号处理，如果是正确的，则进行去括号处理*/
		try ( PrintWriter output = new PrintWriter ( f2 ) )
		{
			while ( i<shushi.length-1 )
			{
				if ( shushi[i] != null )
				{
					boolean str = UnmatchBrackets(shushi[i]);
					if ( shushi[i].matches(regex1) == true )
					{
						output.println("表达式为: 空"+shushi[i]);
						output.println( "ERROR");
						output.println("#表达式为空");
						output.println(" ");
						
					}
					else if ( shushi[i].matches(regex2) == true ) {
						output.println("表达式为: "+shushi[i]);
						output.println("ERROR");
						output.println("#表达式中有空括号 ");
						output.println(" ");
					}
					else if ( shushi[i].matches(regex3) == false ) {
						output.println("表达式为: "+shushi[i]);
						output.println("ERROR ");
						output.println("#表达式包含非法字符 ");
						output.println(" ");
					}
					else if ( str == true ) {
						output.println("表达式为: "+shushi[i]);
						output.println("ERROR ");
						output.println("#括号不匹配 ");
						output.println(" ");
					}
					else if ( shushi[i].matches(regex4) == true ) {
						output.println("表达式为: "+shushi[i]);
						output.println("ERROR ");
						output.println("#运算符连续");
						output.println(" ");
					}
					else if ( shushi[i].matches(regex5) == true ) {
						output.println("表达式为: "+shushi[i]);
						output.println("ERROR ");
						output.println("#运算符前无运算数");	
						output.println(" ");
					}
					else if ( shushi[i].matches(regex6) == true ) {
						output.println("表达式为: "+shushi[i]);
						output.println("ERROR ");
						output.println("#运算符后无运算数");
						output.println(" ");
					}
					else if ( shushi[i].matches(regex7) == true ) {
						output.println("表达式为: "+shushi[i]);
						output.println("ERROR ");
						output.println("#括号非第一个字符且之前无运算符");
						output.println(" ");
	
					}
					else if ( shushi[i].matches(regex8) == true ) {
						output.println("表达式为: "+shushi[i]);
						output.println("ERROR ");
						output.println("#小括号后无运算符，括号非最后一个字符");
						output.println(" ");
					}
					else 
					{
						String m = shushi[i];
						Object num = compute(m);
						output.println("结果为："+shushi[i]+"="+num);
						output.println(" ");
					}
				}
				i++;
			}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static void main(String[] args) throws ScriptException {
		// TODO Auto-generated method stub
		String shushi[] = new String[50];
		String biaodashi [] = new String[ shushi.length ];
		Cal_1 fo = new Cal_1();
		File f1 = new File("src\\jisuanshi");
		fo.readLine(f1, shushi);
		File f2 = new File("src\\jieguo");
		fo.write(f2, shushi);
		int i=0;
		System.out.println("该计算结果已储存在\\\\src\\\\jieguo中!");
		System.out.println("");
		fo.readrecords(f2);
	}

}
