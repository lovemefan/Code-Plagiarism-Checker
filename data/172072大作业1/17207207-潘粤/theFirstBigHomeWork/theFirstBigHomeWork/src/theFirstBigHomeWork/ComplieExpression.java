package theFirstBigHomeWork;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ComplieExpression {

	//������ʽ���Ƿ��ǿ�����
	public static String compileEmpty(String str) {
		Pattern pattern = Pattern.compile("\\(\\s*(?=\\))");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			return "#���ʽ���п�����";
		}
		matcher.reset(str);
		return "";
	}
	//������ʽ�������ǰû������������*��2+3��
		public static String compileFrontNotnumber(String str) {
			String str1 = str.trim();
			Pattern pattern = Pattern.compile("\\(\\s*[\\*\\/\\+]");
			Pattern pattern1 = Pattern.compile("^[\\+\\*\\/]");
			Matcher matcher1 = pattern1.matcher(str1);
			Matcher matcher = pattern.matcher(str1);
			if(matcher1.find()) {
				return "#�����ǰ��������";
			}
			matcher.reset(str1);
			if(matcher.find()) {
				return "#�����ǰ��������";
			}
			matcher.reset(str1);
			return "";
		}
	//������ʽ����������������� ��2��2+3��
		public static String compileBehindNotnumber(String str) {
			String str1 = str.trim();
			Pattern pattern = Pattern.compile("([\\+\\-\\*\\/]\\s*\\))");
			Pattern pattern1 = Pattern.compile("([\\+\\-\\*\\/]\\s*)$");
			Matcher matcher1 = pattern1.matcher(str1);
			Matcher matcher = pattern.matcher(str1);
			if(matcher1.find()) {
				return "#���������������";
			}
			matcher.reset(str1);
			if(matcher.find()) {
				return "#���������������";
			}
			matcher.reset(str);
			return "";
		}
		
		//������ʽ��С���ź��������������ŷ����һ���ַ� ��2*��2+3��3
		public static String compileBracketBehindNotnumber(String str) {
			Pattern pattern = Pattern.compile("([\\)](\\s*)([\\+\\-\\*\\/]+\\s*))$");
			Matcher matcher = pattern.matcher(str);
			if(matcher.find()) {
				return "#С���ź��������������ŷ����һ���ַ�";
			}
			matcher.reset(str);
			return "";
		}
		//������ʽ�Ƿ���ȷ
		public static String compile(String str,PrintWriter output) {
			String str1 = "";
			int i =  0;
			//�ж��Ƿ�Ϊ��
		if(compileEmpty(str).equals("") == false) {
				str1 = compileEmpty(str);
				output.print("\n" + "ERROR"+ "\n" + str1);	
				i++;
			}
		//��������ȷ
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
