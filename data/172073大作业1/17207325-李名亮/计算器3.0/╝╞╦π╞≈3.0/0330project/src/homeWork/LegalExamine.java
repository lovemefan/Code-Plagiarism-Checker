package homeWork;

import java.util.regex.*;
import java.io.*;
import java.util.Scanner;

public class LegalExamine {
	public	boolean examine(String string,java.io.FileOutputStream output_2) throws IOException {//合法性检验
		boolean temp_1=false,temp_2=false;
		String expression="";
		
		String ch=bracketStack(string);
		if(!ch.equals("#")) {//栈顶元素不是"#",说明栈内的括号不完全匹配
			output_2.write("ERROR\n#括号不匹配\n".getBytes());
			return temp_2=true;
		}
		
		expression=".*[^\\d+\\.()\\+\\-\\*\\/].*";//包含除+-*/()以及浮点数,整数之外的符号
		temp_1=Pattern.matches(expression, string);
		if(temp_1) {
			output_2.write("ERROR\n#表达式包含非法字符\n".getBytes());
			return temp_2=true;
		}
		
		expression=".*\\s.*";//表达式为空
		temp_1=Pattern.matches(expression, string);
		if(temp_1||string.equals("")) {
			output_2.write("ERROR\n#表达式为空\n".getBytes());
			return temp_2=true;
		}
		
		expression=".*\\(\\).*";//空括号
		temp_1=Pattern.matches(expression, string);
		if(temp_1) {
			output_2.write("ERROR\n#表达式中有空括号\n".getBytes());
			return temp_2=true;
		}
		
		expression=".*\\+\\+.*|.*\\+\\*.*|.*\\+/.*|.*--.*|.*-\\*.*|.*-/.*|.*-\\+.*|.*\\*\\*.*|.*\\*/.*|.*\\*\\+.*|.*//.*|.*/\\*.*|.*/\\+.*";
		temp_1=Pattern.matches(expression, string);//++ +* +/	-- -* -/ -+		** */ *+	// /* /+
		if(temp_1) {
			output_2.write("ERROR\n#运算符连续\n".getBytes());
			return temp_2=true;
    	}
		
		expression="[\\+\\*\\/]\\(.*";//		+*/(
		temp_1=Pattern.matches(expression, string);
		if(temp_1) {
			output_2.write("ERROR\n#括号非第一个字符且之前无运算数\n".getBytes());
			return temp_2=true;
		}
		
		expression=".*\\)[\\+\\-\\*\\/]";//		)+-*/
		temp_1=Pattern.matches(expression, string);
		if(temp_1) {
			output_2.write("ERROR\n#小括号后无运算数，括号非最后一个字符\n".getBytes());
			return temp_2=true;
		}
		
		expression="[\\+\\*\\/][^\\(].*|.*\\([\\+\\*\\/].*|[\\+\\-\\*\\/]";//*8-9 	9-(*7+7)
		temp_1=Pattern.matches(expression, string);
		if(temp_1) {
			output_2.write("ERROR\n#运算符前无运算数\n".getBytes());
			return temp_2=true;
		}
		
		expression=".*[^\\)][\\-\\+\\*\\/]|.*[\\-\\+\\*\\/]\\).*";//8+7-	7-6*(7+)-4
		temp_1=Pattern.matches(expression, string);
		if(temp_1) {
			output_2.write("ERROR\n#运算符后无运算数\n".getBytes());
			return temp_2=true;
		}
		
		expression=".*\\d+\\.\\d+\\(.*|.*\\)\\d+\\.\\d+.*|.*\\d+\\(.*|.*\\)\\d+.*|.*\\)\\(.*";//4.5( 	)4.5   8( 	 )8 	)(	
		temp_1=Pattern.matches(expression, string);
		if(temp_1) {
			output_2.write("ERROR\n#缺少运算符\n".getBytes());
			return temp_2=true;
		}  
		
		expression=".*\\)\\..*|.*\\.\\(.*|.*\\d+\\.+\\d+\\.+.*|.*\\.{2,}.*|.*[\\+\\-\\*\\/\\(]\\.\\d+\\..*|\\.\\d+\\..*";//).	 .(		 ).( 	9.9.	9...	+.8.
		temp_1=Pattern.matches(expression, string);
		if(temp_1) {
			output_2.write("ERROR\n#小数点位置错误\n".getBytes());
			return temp_2=true;
		}
		return temp_2;
	}
	
	private String bracketStack(String string) {//检验括号是否匹配
		ExpressionStack chStack=new ExpressionStack();
		chStack.push("#");
		String string_2=string+"#";
		int i=0;
		String ch=string_2.substring(0,1);
		String strTop=chStack.getTops();
		while(!ch.equals("#")){
			if(ch.equals("(")||ch.equals(")")) {
				if(ch.equals(")")&&strTop.equals("(")) {//ch为(,栈顶为),则去括号,最后栈顶元素不为#,则说明有括号没有完全匹配
					chStack.pop();
				}
				else {
					chStack.push(ch);
				}
			}
			i++;
			ch=string_2.substring(i,i+1);
			strTop=chStack.getTops();
		}
		return ch=chStack.getTops();
	}
	
	public int deleteSameExpression(ExpressionStack arrayTemp,String string1,	int temp_2) {
		String expressionResult="";
		temp_2=0;
		if(arrayTemp.emty()) {
			for(int i=0;i<=arrayTemp.size;i++) {//正在写入时不可读取文件,需先关闭写入操作
				expressionResult=arrayTemp.stack[i];
					if(expressionResult.equals(string1)) {
						temp_2++;
					}
			}
		}
		return temp_2;
	}
	
}
