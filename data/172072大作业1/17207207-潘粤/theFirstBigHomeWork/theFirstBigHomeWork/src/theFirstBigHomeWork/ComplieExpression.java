package theFirstBigHomeWork;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ComplieExpression {

	//检验表达式中是否是空括号
	public static String compileEmpty(String str) {
		Pattern pattern = Pattern.compile("\\(\\s*(?=\\))");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			return "#表达式中有空括号";
		}
		matcher.reset(str);
		return "";
	}
	//检验表达式中运算符前没有运算数例：*（2+3）
		public static String compileFrontNotnumber(String str) {
			String str1 = str.trim();
			Pattern pattern = Pattern.compile("\\(\\s*[\\*\\/\\+]");
			Pattern pattern1 = Pattern.compile("^[\\+\\*\\/]");
			Matcher matcher1 = pattern1.matcher(str1);
			Matcher matcher = pattern.matcher(str1);
			if(matcher1.find()) {
				return "#运算符前无运算数";
			}
			matcher.reset(str1);
			if(matcher.find()) {
				return "#运算符前无运算数";
			}
			matcher.reset(str1);
			return "";
		}
	//检验表达式中运算符后无运算数 例2（2+3）
		public static String compileBehindNotnumber(String str) {
			String str1 = str.trim();
			Pattern pattern = Pattern.compile("([\\+\\-\\*\\/]\\s*\\))");
			Pattern pattern1 = Pattern.compile("([\\+\\-\\*\\/]\\s*)$");
			Matcher matcher1 = pattern1.matcher(str1);
			Matcher matcher = pattern.matcher(str1);
			if(matcher1.find()) {
				return "#运算符后无运算数";
			}
			matcher.reset(str1);
			if(matcher.find()) {
				return "#运算符后无运算数";
			}
			matcher.reset(str);
			return "";
		}
		
		//检验表达式中小括号后无运算数，括号非最后一个字符 例2*（2+3）3
		public static String compileBracketBehindNotnumber(String str) {
			Pattern pattern = Pattern.compile("([\\)](\\s*)([\\+\\-\\*\\/]+\\s*))$");
			Matcher matcher = pattern.matcher(str);
			if(matcher.find()) {
				return "#小括号后无运算数，括号非最后一个字符";
			}
			matcher.reset(str);
			return "";
		}
		//检验表达式是否正确
		public static String compile(String str,PrintWriter output) {
			String str1 = "";
			int i =  0;
			//判断是否为空
		if(compileEmpty(str).equals("") == false) {
				str1 = compileEmpty(str);
				output.print("\n" + "ERROR"+ "\n" + str1);	
				i++;
			}
		//操作符正确
		if(compileFrontNotnumber(str).equals("") == false) {
				str1 = compileFrontNotnumber(str);
				output.print("\n" + "ERROR"+ "\n" + str1);
				i++;
			}
			if(compileBracketBehindNotnumber(str).equals("") == false) {
				str1 = compileBracketBehindNotnumber(str);
				output.print("\n" + "ERROR"+ "\n" + str1);
				i++;
			}
			if(compileBehindNotnumber(str).equals("") == false) {
				str1 = compileBehindNotnumber(str);
				output.print("\n" + "ERROR"+ "\n" + str1);
				i++;
			}
		
			if(i != 0)
			{
				output.println();
				return "has error";
			}
			else
				return "";
		}	
		
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
