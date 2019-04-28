
package theFirstBigHomeWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorExpression {
	static int strlength = 0;
	static int i=0;
	public static void read(File f1,File f2) {
		String st1 = "";
		String st2[] = new String[80];
		st2[1] = " ";
		boolean m = false;
		try(Scanner input = new Scanner(f1);PrintWriter output = new PrintWriter(f2);){
			while(input.hasNextLine()) {
				st1 = input.nextLine();
				while(Compile(st1,st2)) {
					if(input.hasNextLine()==false) {
						m = true;
						break;
					}else {
						st1 = input.nextLine();
					}
				}
					st2[i] = st1;
					i++;
					 strlength = i;
					 ComplieExpression cm = new ComplieExpression();
					 output.print(st1);
					 if(cm.compile(st1, output).equals("")==false) {
						 
					 }else {
						 System.out.println(st1+"="+compute(st1));
						 output.println("="+compute(st1));
					 }
				

				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	//判断输入表达式是否相等
	
	//运算
	public static String compute(String str) {
		StringBuilder builder = new StringBuilder();
		str = str.trim();
		if(str.contains("(")) {
			Pattern pattern = Pattern.compile("\\(([^()]+)\\)"); 
			Matcher matcher = pattern.matcher(str);
			int lastEnd = 0;
			while(matcher.find()) {
				builder.append(str.substring(lastEnd, matcher.start()));
				builder.append(compute(matcher.group(1)));
				lastEnd = matcher.end();
			}
			builder.append(str.substring(lastEnd));
			
		}else {
			Pattern pattern = Pattern.compile("(\\-*[\\d.]+)\\s*([\\/\\*])\\s*(\\-*[\\d.]+)");
			Pattern pattern1 = Pattern.compile("\\-\\d+\\s*(?!.)");
			builder.append(str);
			Matcher matcher1 = pattern1.matcher(builder.toString());
			
			if(matcher1.find()) {
				builder.append("*1");
			}
			//builder.append(str);
			Matcher matcher = pattern.matcher(builder.toString());
			while(matcher.find()) {
				float f1 = Float.parseFloat(matcher.group(1));
				float f2 = Float.parseFloat(matcher.group(3));
				float result = 0;
				switch(matcher.group(2)) {
				case "*" :	
					result = f1 * f2;
					break;
				case "/" :	
					result = f1 / f2;
					break;
				}
				builder.replace(matcher.start(),matcher.end(),String.valueOf(result));
				matcher.reset(builder.toString());
			}
			pattern = Pattern.compile("(\\-*[\\d.]+)\\s*([\\+\\-])\\s*(\\-*[\\d.]+)");
			matcher = pattern.matcher(builder.toString());
			while(matcher.find()) {
				float f1 = Float.parseFloat(matcher.group(1));
				float f2 = Float.parseFloat(matcher.group(3));
				float result = 0;
				switch(matcher.group(2)) {
				case "+" : 
					result = f1 + f2;
					break;
				case "-" :
					result = f1 - f2;
					break;
				}
				builder.replace(matcher.start(), matcher.end(), String.valueOf(result));
				matcher.reset(builder.toString());
			}
			return builder.toString();
		}
		return compute(builder.toString());
		
	}
	public static boolean Compile(String str1,String str2[]) {
		String s1 = "";
		String s2 = "";
		s1 = str1.replace("","");
		if(str1.equals("")) {
			return false;
		}
		
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f1 = new File("src\\expression");
		File f2 = new File("src\\compute");
		read(f1,f2);

	}

}
