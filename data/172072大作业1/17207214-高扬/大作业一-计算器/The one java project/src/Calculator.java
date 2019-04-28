import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Calculator {
	
	public static final int EXPRESSION_LONGTH = 100;
	public static final int OPERATOR_COUNT = 50;
	
	static String[] exp = new String[100];
	static String[] ans = new String[100];
	static String Exp = new String();
	static String ipExp = new String();
	static FileOperation fo = new FileOperation();
	static int num = 0;
	
	public static void main(String[] args) {
		
		FileOperation fo = new FileOperation();
		File fileOne = new File("src\\ArithmeticExpression");
		File fileTwo = new File("src\\Results");
		fo.FileTest(fileOne);
		
		num = fo.Read(fileOne);
		
		for(int i = 0; i < num; i++) {
				
				if(exp[i].charAt(0) == 'E') {
					ans[i] = exp[i];
				}
				else {
					Exp = expressionInit(exp[i]);
					
					ipExp = InversePolishEX.exchange(Exp);
					
					ans[i] = exp[i] + "=" + Calculate.Operator(ipExp);
				}
				
				
				fo.writeFile(fileTwo);
				
				System.out.println(ans[i]);
		}
		
		
	}
	
	//进行输入表达式的存储
	static String  expressionInit(String exp) {
		
		exp = "#" + exp + "#";
		
		return exp;
	}

}

//正则表达式检测算术表达式的合法性
class RegularExpressionDetection{
	
	static String judge;
	
	static int Judge(String data) {
		
		
		if(data == "") {
			judge = ("#表达式为空");
			return -1;
		}
		
		for(int i = 1; i < data.length(); i++) {
			if(data.charAt(i) == ')' && data.charAt(i - 1) == '(') {

				judge = ("#表达式中有空括号");
				return -1;
			}
		}
		
		int left = 0;
		for(int i = 0; i < data.length(); i++) {
			if(data.charAt(i) == '(') {
				left++;
			}
			else if(data.charAt(i) == ')') {
				if(left > 0)
					left--;
				else {
					judge = ("#括号不匹配");
					return -1;
				}
			}
			
			if(data.charAt(i) >= '0' && data.charAt(i) <= '9')
				continue;
			else if(data.charAt(i) == '+' || data.charAt(i) == '-' || data.charAt(i) == '*' || data.charAt(i) == '/' || data.charAt(i) == '(' || data.charAt(i) == ')')
				continue;
			else {
				judge = ("#表达式包含非法字符");
				return -1;
			}
		}
		if(left != 0) {
			judge = ("#括号不匹配");
			return -1;
		}
		
		if(data.charAt(0) == '+' || data.charAt(0) == '-' || data.charAt(0) == '*' || data.charAt(0) == '/') {
			if(data.charAt(1) == '(') {
				judge = ("#括号非第一个字符且之前无运算数");
				return -1;
			}
			else {
				judge = ("#运算符前无运算数");
				return -1;
			}
		}
		
		if(data.charAt(data.length() - 1) == '+' || data.charAt(data.length() - 1) == '-' || data.charAt(data.length() - 1) == '*' || data.charAt(data.length() - 1) == '/') {
			if(data.charAt(data.length() - 2) == ')') {
				judge = ("#小括号后无运算数，括号非最后一个字符");
				return -1;
			}
			else {
				judge = ("#运算符后无运算数");
				return -1;
			}
		}
		
		for(int i = 1; i < data.length(); i++) {
			if(data.charAt(i) == '+' || data.charAt(i) == '-' || data.charAt(i) == '*' || data.charAt(i) == '/') {
				if(data.charAt(i - 1) == '+' || data.charAt(i - 1) == '-' || data.charAt(i - 1) == '*' || data.charAt(i - 1) == '/') {
					judge = ("#运算符连续");
					return -1;
				}
				else if(data.charAt(i - 1) < '0' && data.charAt(i - 1) != ')') {
					judge = ("#运算符前无运算数");
					return -1;
				}
				
			}
			
			if(data.charAt(i - 1) == '+' || data.charAt(i - 1) == '-' || data.charAt(i - 1) == '*' || data.charAt(i - 1) == '/') {
				if(data.charAt(i) < '0' && (data.charAt(i) != '(')) {
					judge = ("#运算符后无运算数");
					return -1;
				}
			}
		}
		
		return 0;
	}
}

//将算术表达式转换为逆波兰式
class InversePolishEX{
	
	//逆波兰式转换
	static String exchange(String exp) {
		
		StringBuilder ipexp = new StringBuilder();
		StringBuilder opera = new StringBuilder();
		
		opera.append('#');

		for(int i = 0; i < exp.length(); i++) {
			if(exp.charAt(i) >= '0' && exp.charAt(i) <= '9') {
				ipexp.append(exp.charAt(i));
			}
			else if(exp.charAt(i) >= '#' && exp.charAt(i) <= '/') {
				switch(JudgePriority(exp.charAt(i), opera.charAt(opera.length() - 1))) {
				case '<':{
					opera.append(exp.charAt(i));
					break;
				}
				case '>':{
					ipexp.append(opera.charAt(opera.length() - 1));
					opera.deleteCharAt(opera.length() - 1);
					i--;
					break;
				}
				case '=':{
					if(ParenthesesJudgment(opera, exp.charAt(i)) == 1) {
						opera.deleteCharAt(opera.length() - 1);
						break;
					}
				}
				}
			}
		}
		
		
		return ipexp.toString();
	}
	
	//判断符号优先级
	static char JudgePriority(char ch_before, char ch_after) {
		String opera = "+-*/()#";
		char ans = ' ';
		String prior[] = {">><<<>>",">><<<>>",">>>><>>",">>>><>>","<<<<<= ",">>>> >>","<<<<< ="};
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				if(ch_before == opera.charAt(j) && ch_after == opera.charAt(i)) {
					ans =  prior[i].charAt(j);
				}
			}
		}
		
		return ans;
	}
	
	//检测括号并进行相应的操作
	static int ParenthesesJudgment(StringBuilder opera, char key) {
		if(key == ')') {
			for(int i = 0; i < opera.length(); i++) {
				if(opera.charAt(i) == '(') {
					i++;
					for(int j = i; j < opera.length(); j++) {
						opera.setCharAt(j - 1, opera.charAt(j));
					}
				}
			}
			return 1;
		}
		else {
			return 0;
		}
	}
}

//逆波兰式的运算
class Calculate{
	
	
	//逆波兰式计算
	static int Operator(String ipExp) {
		
		StringBuilder ipexp = new StringBuilder(ipExp);
		int ans = 0;
		
		for(int i = 0; i < ipexp.length(); i++) {
			if(ipexp.charAt(i) < '0') {
				int a = ipexp.charAt(i - 2) - '0';
				int b = ipexp.charAt(i - 1) - '0';
				ans = Compute(a, b, ipexp.charAt(i));

				ipexp.setCharAt(i - 2, (char)(ans + '0'));
				
				for(int j = i + 1; j < ipexp.length(); j++) {
					ipexp.setCharAt(j - 2, ipexp.charAt(j));
				}
				

				ipexp.deleteCharAt(ipexp.length() - 1);
				ipexp.deleteCharAt(ipexp.length() - 1);
				i = i - 2;
			}
			if(ipexp.length() == 1) {
				break;
			}
		}
		
		ans = ipexp.charAt(0) - '0';
		
		
		return ans;
	}
	
	
	//单个运算符运算
	static int Compute(int a, int b, char operator) {
		
		switch(operator) {
		case '+':{
			return a + b;
		}
		case '-':{
			return a - b;
		}
		case '*':{
			return a * b;
		}
		case '/':{
			return a / b;
		}
		default:{
			return 0;
		}
		}
		
	}
	
	
}

class FileOperation{
	
	public void FileTest(File file) {
		if(file.canRead() == false) {
			System.out.println("文件不存在");
			System.exit(0);
		}
	}
	
	public int Read(File file) {
		int key = 0;

		try (Scanner input = new Scanner(file);){
			while(input.hasNextLine()) {
				String s = input.nextLine();
				StringBuilder str = new StringBuilder(s);
				for(int i = 0; i < str.length(); i++) {
					if(str.charAt(i) == ' ') {
						str.deleteCharAt(i);
					}
				}
				for(int i = 0; i < key; i++) {
					if(str.toString().equals(Calculator.exp[i])) {
						continue;
					}
				}
				
				if(str.length() == 0) {
					Calculator.exp[key] = "ERROR\n" + "#表达式为空";
				}
				else if(RegularExpressionDetection.Judge(str.toString()) == -1) {
					Calculator.exp[key] = "ERROR\n" + RegularExpressionDetection.judge;
				}
				else {
					Calculator.exp[key] = str.toString();
				}
				key++;
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return key;
	}
	
	public void writeFile(File file) {
		try (PrintWriter output = new PrintWriter(file);){
			
			for(int i = 0; i < Calculator.num; i++)
				output.println(Calculator.ans[i]);				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}