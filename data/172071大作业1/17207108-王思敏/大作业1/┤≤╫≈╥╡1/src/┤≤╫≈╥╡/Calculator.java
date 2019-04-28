package 大作业;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator{
	public static void main(String[] args) {
		File f1 = new File("src\\expression");
		File f2 = new File("src\\result");
		char[] Exp_a = new char[50];
		String[] str = new String[50];//表达式数组
		Test r1 = new Test();
		ExpWrong r2 = new ExpWrong();
		Arithmetic r3 = new Arithmetic();
		r1.FileRead(f1,str);//读取表达式文件
		r1.coverBlank(f2);//刷新结果文件
		str = expRepeat(str);
		for(int n=0;str[n]!=null;n++) {
			str[n] = absorbEmptyChar(str[n]);//吸收空字符
			if(r2.wrong(str[n])) {//判断表达式是否异常
				Exp_a = str[n].toCharArray();//一个表达式的每一个字符存入一个字符数组中
				int result = r3.expressionEvaluation(Exp_a); //求值
				r1.FileWrite(f2,result,str[n]);//将结果写入结果文件
				r1.readResult(f2);//每次读取结果文件中的最后一行
			}
		}
	}
	
	static String absorbEmptyChar(String str) {//吸收空字符
		Pattern pattern = Pattern.compile("\\s*|\t|\r");
		Matcher match = pattern.matcher(str);
		String s = match.replaceAll("");
		return s;
	}
	
	static String[] expRepeat(String[] str) {//去除重复表达式
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;str[i]!=null;i++) {
			if(!list.contains(str[i]))
				list.add(str[i]);
				
		}
		return list.toArray(new String[50]);
	}
}

//表达式计算类
class Arithmetic{
	
	 boolean In(char c){//判断是否为运算符
		if((c=='+')||(c=='-')||(c=='*')||(c=='/')||(c=='(')||(c==')')||(c=='='))
			return true;
		else
			return false;
	} 

	int Operate(int a,char theta,int b) {//进行加减乘除运算
		int num = 0;
		switch((Character)theta)
		{
			case '+':
				num = a+b;break;
			case '-':
				num = a-b;break;
			case '*':
				num = a*b;break;
			case '/':
				num = a/b;break;
		}
		return num;
	}

	char Precede(char a,char b){//判断运算符的优先级 
		int m=0,n=0;
		char[][] Prior = {{'>','>','<','<','<','>','>'},
						  {'>','>','<','<','<','>','>'},                    
						  {'>','>','>','>','<','>','>'},				
						  {'>','>','>','>','<','>','>'},				
						  {'<','<','<','<','<','=',' '},				
						  {'>','>','>','>',' ','>','>'},			
						  {'<','<','<','<','<',' ','='}};//运算符之间的优先关系 
		m = Level(a);
		n = Level(b);
		return Prior[m][n];
	}
	
	int Level(char a) {//运算符优先级
		int m=0;
		switch(a)
		{
			case '+':
				m = 0;break;
			case '-':
				m = 1;break;
			case '*':
				m = 2;break;
			case '/':
				m = 3;break;
			case '(':
				m = 4;break;
			case ')':
				m = 5;break;
			case '=':
				m = 6;break;
		}
		return m;
	}

	int expressionEvaluation(char[] Exp_a){//表达式求值
		int i = 0;
		Stack<Character> OPTR = new Stack<Character>();//定义一个操作符栈
		Stack<Integer> OPND = new Stack<Integer>();//定义一个操作数栈
		OPTR.push('=');
		while(Exp_a[i]!='='||OPTR.peek()!='=')//当表达式字符数组中数值不为‘=’或操作符栈顶不为‘=’时
		{
			if(!In(Exp_a[i]))//不是操作符，是操作数，压入操作数栈 
			{
				String str = new String(new char[]{Exp_a[i]});//字符转换为字符串
				for(;i<Exp_a.length;i++) {
					if(!In(Exp_a[i+1])) 
						str = str.concat(new String(new char[]{Exp_a[i+1]}));
					else
						break;
				}
				OPND.push(Integer.parseInt(str));
				i++;
			}
			else//是操作符，与OPTR栈顶元素进行优先级比较 
			{
				if(Exp_a[i]=='('&&Exp_a[i+1]=='-') {//如果是负数
					OPND.push(-(Exp_a[i+2]-'0'));
					i = i+2;
					Exp_a[i] = '(';
				}
				switch(Precede(OPTR.peek(),Exp_a[i]))
				{
					case '<':
						OPTR.push(Exp_a[i]);i++;//优先级比栈顶元素高，入栈 
						break;
					case '=':
						OPTR.pop();i++;//脱括号 
						break;
					case '>'://优先级比栈顶元素低，弹出栈顶操作符进行运算
						int b = OPND.pop();//分别从OPND操作数栈栈顶弹出两个数进行计算
						int a = OPND.pop();
						char theta = OPTR.pop();
						OPND.push(Operate(a,theta,b));//运算结果压入OPND栈
						break;
				}
			}
		}
		return OPND.pop();
		
	}
}

//数据测试类
class Test{
	void FileRead(File f1,String[] str){//读取表达式文件存入字符串数组中
		int i = 0;
		try (Scanner input = new Scanner(f1);){
			while(input.hasNextLine()) {
				str[i] = input.nextLine();
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void FileWrite(File f2,int result,String str) {//将结果写入结果文件
		FileWriter fileWiter = null;
		try {
			fileWiter = new FileWriter(f2,true);
			fileWiter.write(str+result+"\n");
			fileWiter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void coverBlank(File f2) {//对结果文件进行刷新，即用空白覆盖原有数据
		try (PrintWriter output = new PrintWriter(f2);){
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void readResult(File f2) {//读取结果文件中最后一行数据
		String line = null;
		try (Scanner input = new Scanner(f2);){
			while(input.hasNextLine()&&(line=input.nextLine())!=null) {
				if(!input.hasNextLine())
					System.out.println(line+"\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

//异常输入类
class ExpWrong{
	
	boolean wrong(String str) {
		if(!exp_Empty(str)) {
			System.out.println(str+"\n"+"ERROR\n#表达式为空！\n");
			return false;
		}
		if(!exp_Bracket(str)) {
			System.out.println(str+"\n"+"ERROR\n#表达式中有空括号！\n");
			return false;
		}
		if(!exp_IllegalChar(str)) {
			System.out.println(str+"\n"+"ERROR\n#表达式包含非法字符！\n");
			return false;
		}
		if(!exp_Mismatch(str)) {
			System.out.println(str+"\n"+"ERROR\n#表达式中括号不匹配！\n");
			return false;
		}
		if(!exp_OperContinuity(str)) {
			System.out.println(str+"\n"+"ERROR\n#表达式中运算符连续！\n");
			return false;
		}
		if(!exp_BeforeOperator(str)) {
			System.out.println(str+"\n"+"ERROR\n#表达式中运算符前无运算数！\n");
			return false;
		}
		if(!exp_AfterOperator(str)) {
			System.out.println(str+"\n"+"ERROR\n#表达式中运算符后无运算数！\n");
			return false;
		}
		if(!exp_AfterEqualSign(str)) {
			System.out.println(str+"\n"+"ERROR\n#表达式中=不是最后一个字符！\n");
			return false;
		}
		if(!exp_beforeLeftBracket(str)) {
			System.out.println(str+"\n"+"ERROR\n#表达式中(非第一个字符且(前无运算符！\n");
			return false;
		}
		if(!exp_afterRightBracket(str)) {
			System.out.println(str+"\n"+"ERROR\n#表达式中)后无运算符或等号！\n");
			return false;
		}
		return true;
	}
	
	boolean exp_Empty(String str){//判断表达式是否为空
		if(str.equals(""))
			return false;
		return true;
	}
	
	boolean exp_Bracket(String str) {//判断表达式是否有空括号
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='('&&str.charAt(i+1)==')')
				return false;
		}
		return true;
	}
	
	boolean exp_IllegalChar(String str){//判断表达式是否有非法字符
		Pattern pattern = Pattern.compile("[^0-9\\+\\-\\*\\/\\(\\)\\=]");
		for(int i=0;i<str.length()-1;i++) {
			Matcher match = pattern.matcher(str.substring(i,i+1));
			if(match.matches())
				return false;
		}
		return true;
	}
	
	boolean exp_Mismatch(String str){//表达式中括号不匹配
		int num=0;
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c=='(')
				num++;
			else if(c==')') {
				if(num==0)//无左括号却有一个右括号
					return false;
				else
					num--;
			}
		}
		if(num!=0)
			return false;
		return true;
	}
	
	boolean exp_OperContinuity(String str){//表达式中运算符连续
		Pattern pattern = Pattern.compile(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*");
			Matcher match = pattern.matcher(str);
			if(match.matches())
				return false;
		return true;
	}
	
	boolean exp_BeforeOperator(String str) {//运算符前无运算数
		Pattern pattern = Pattern.compile("^[\\+\\-\\*\\/].*||.*[(][\\+\\*\\/].*");
			Matcher match = pattern.matcher(str);
			if(match.matches())
				return false;
		return true;
	}
	
	boolean exp_AfterOperator(String str) {//运算符后无运算数
		Pattern pattern = Pattern.compile(".*[\\+\\-\\*\\/][\\=]$||.*[\\+\\-\\*\\/][)].*");
			Matcher match = pattern.matcher(str);
			if(match.matches())
				return false;
		return true;
	}
	boolean exp_AfterEqualSign(String str) {//等号后面还有字符
		Pattern pattern = Pattern.compile(".*[\\=]$");
			Matcher match = pattern.matcher(str);
			if(!match.matches())
				return false;
		return true;
	}
	
	boolean exp_beforeLeftBracket(String str) {//表达式中(非第一个字符且(前无运算符
		Pattern pattern = Pattern.compile(".*[0-9][(].*");
		for(int i=0;i<str.length()-2;i++) {
			Matcher match = pattern.matcher(str);
			if(match.matches())
				return false;
		}
		return true;
	}
	
	boolean exp_afterRightBracket(String str) {//表达式中)后不是运算符或等号！
		Pattern pattern = Pattern.compile(".*[)][0-9].*");
		for(int i=0;i<str.length()-2;i++) {
			Matcher match = pattern.matcher(str);
			if(match.matches())
				return false;
		}
		return true;
	}
}
