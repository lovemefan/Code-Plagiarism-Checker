package Big_Exiperment_01;

//str = str.replace(" ", "");		//去掉字符串中的空格
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private static int stringLength = 0;
	public static void readFile(File f,File f1) {
		String str = "";
		int i = 0;
		String[] str1 = new String[100];
		str1[1] = " ";
		boolean a = false;
		try(Scanner input = new Scanner(f);PrintWriter output = new PrintWriter(f1);){
			while(input.hasNextLine()) {
				str = input.nextLine();
				while(simple (str1,str)){
					if(input.hasNextLine() == false) {
						a = true;
						break;
					}else
						str  = input.nextLine();
				}
				if(a == true) {
					break;
				}
				str1[i] = str;
				i++;
				stringLength = i;
				CheckExpression ce = new CheckExpression();	
				output.print(str);
				if(ce.check(str,output).equals("") == false)
				{
				}else {
					System.out.println(str + " = " + cal(str));
					output.println(" = " + cal(str));
				}
			}
			//output.close();
		}catch(FileNotFoundException ex) {
			System.out.println("找不到文档！" + "\n" + ex.toString());
		}
	}
	
	
	public static boolean simple(String[] str1,String str) {
		int i = 0;
		String st1 = "";
		String st = "";
		st = str.replace(" ","");
		if(str.equals("")) {
			return false;
		}
		for(int j = 0;j < stringLength;j++){
			st1 = str1[i].replace(" ", "");
			if(st.equals(st1)) {
				return true;
			}
		}
		return false;
	}
	
	public static String cal(String str) {
		
		StringBuilder builder = new StringBuilder();
		str = str.trim();
		if(str.contains("(")) {
			Pattern pattern = Pattern.compile("\\(([^()]+)\\)"); 
			Matcher matcher = pattern.matcher(str);
			int lastEnd = 0;
			while(matcher.find()) {
				builder.append(str.substring(lastEnd, matcher.start()));
				builder.append(cal(matcher.group(1)));
				lastEnd = matcher.end();
			}
			builder.append(str.substring(lastEnd));
			
		}else {
			Pattern pattern = Pattern.compile("([\\d.]+)\\s*([\\/\\*])\\s*(\\-*[\\d.]+)");
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
		return cal(builder.toString());
		
	}
	public static void main(String[] args) {
		File f = new File("src\\expression");
		File f1 = new File("src\\calculator");
		readFile(f,f1);
	}
	
}
