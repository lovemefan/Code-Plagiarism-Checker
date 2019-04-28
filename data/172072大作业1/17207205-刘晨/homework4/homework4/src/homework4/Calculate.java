package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;


//计算数学表达式类
public class Calculate {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException
	{
		FileOperation fo = new FileOperation();
		File f = new File("src\\Calculator");
		File fs = new File("src\\Result");
		TestError te = new TestError(); 
	//	fo.writeFile(f);
	//	fo.read(f);
		int count=0;
		int result;//计算结果
		Stack<Character> opstack = new Stack<Character>();//运算符栈
		Stack<Character> nostack = new Stack<Character>();//操作数栈
	
		//在文件中读取表达式
		try (Scanner input = new Scanner(f);){
			while(input.hasNext()) {
				String  express=input.nextLine();
				
				String expression=express.replaceAll("\\s*", "");//除去表达式中所有空格得到正确表达式
				expression.toCharArray();//转换为字符串数组
				
				//对正确的表达式计算
				if(te.Regx(expression, fs)) {
					StringBuilder sbs = new StringBuilder(10);//判断是否读取完整个数字 
					for(int i = 0;i<expression.length();i++) {
						char c = expression.charAt(i);
						if(c != ' ') {
							if(c >= '0' && c <= '9') {
								sbs.append(c);
								if(i==expression.length()-1) {
									int a = Integer.parseInt(sbs.toString());
									nostack.push((char)(a+48));
									sbs.delete(0, sbs.length());
								}
							}
							else {
								if(sbs.length()>0) //说明完整读取完一个数字
								{
									int a = Integer.parseInt(sbs.toString());
									nostack.push((char)(a+48));
									sbs.delete(0, sbs.length());
								
								}
							
							
						if(c=='+'||c=='-'||c=='*'||c=='/'||c=='('||c==')') {
							if(opstack.empty())//栈非空，运算符直接进栈
								opstack.push(c);//运算符进栈
							else if(c==')') {
								int a = nostack.pop()-48;
								int b = nostack.pop()-48;
								int r = DoOperate(a,opstack.pop(),b);
								nostack.push((char)(r+48));
								opstack.pop();
							}
								
							else {
								char e = opstack.lastElement();//获得栈顶运算符
								if(TurnToNo(e,c)=='<') {
									opstack.push(c);
								}
								else if(TurnToNo(e,c)=='>') {
									int a = nostack.pop()-48;
									int b = nostack.pop()-48;
									int s = DoOperate(a,opstack.pop(),b);
									nostack.push((char) (s+48));//运算结果压回操作数栈中
									while(opstack.size()==1) {
										char E = opstack.lastElement();
										if(TurnToNo(E,c)=='<')
											opstack.push(c);
										else if(TurnToNo(E,c)=='>') {
											int m = nostack.pop()-48;
											int n = nostack.pop()-48;
											int p = DoOperate(m,opstack.pop(),n);
											nostack.push((char)(p+48));
											
											
										}
											
									}opstack.push(c);
									
								}
							}
						}
					}
					}		
				}
				
					while(nostack.size()!=1) {
						int a = nostack.pop()-48;
						int b = nostack.pop()-48;
						int res = DoOperate(a,opstack.pop(),b);
						nostack.push((char) (res+48));
					}
					if(FileOperation.count) {
						fo.writeFile(expression, fs,nostack.firstElement()-48);
						FileOperation.count=false;
					}else {
						fo.addFile(expression, fs,nostack.firstElement()-48);
					}
					//	System.out.println(nostack.firstElement()-48);
				
					nostack.clear();
					opstack.clear();//清空栈内所有元素
						
				}
				
			}
		}
		catch (FileNotFoundException e) {
		e.printStackTrace();
		}
		fo.readLine(fs);
	}	
	

	
	//计算方法
	public static int DoOperate(int a,char theta,int b)//对运算数进行操作的函数 
	{
		
		if(theta=='+')
			return a+b;
		else if(theta=='-')
			return b-a;
		else if(theta=='*')
			return a*b;
		else 
			return b/a;
		
		
	}




	//优先级
	private static char [][] pre= { {'>','>','<','<','<','>','>'},
									{'>','>','<','<','<','>','>'},
									{'>','>','>','>','<','>','>'},
									{'>','>','>','>','<','>','>'},
									{'<','<','<','<','<','=',' '},
									{'>','>','>','>',' ','>','>'},
									{'<','<','<','<','<',' ','='}};//优先级数组
	//转化为数字作为返回值
	public static int TurnToNo(char a,char b) {	
			int row = 0,col=0;
			if(a=='+')
				row=0;
			else if(a=='-')
				row=1;
			else if(a=='*')
				row=2;
			else if(a=='/')
				row=3;
			else if(a=='(')
				row=4;
			else if(a==')')
				row=5;
			else if(a=='#')
				row=6;
			if(b=='+')
				col=0;
			else if(b=='-')
				col=1;
			else if(b=='*')
				col=2;
			else if(b=='/')
				col=3;
			else if(b=='(')
				col=4;
			else if(b==')')
				col=5;
			else if(b=='#')
				col=6;
			return pre[row][col]; 
	}
}

//检测错误类
class TestError{
	public boolean Regx(String expression,File f) throws IOException {
	//	FileOperation fo=new FileOperation();
	//	if(FileOperation.count) {
	//		PrintWriter output=new PrintWriter(f);
	//	}else {
			FileWriter fw=new FileWriter(f,true);
			PrintWriter output=new PrintWriter(fw);
	//	}
		int count = 0;
		if(expression.matches("\\s*|")) {
			output.println("ERROR");
			output.println("#表达式为空");//表达式为空
			output.close();
			return false;
		}
		else if(expression.matches("[^0-9+-/\\*\\(\\)]+.*"
				+"|.*[^0-9+-/\\*\\(\\)]+"
				+"|.*[^0-9+-/\\*\\(\\)]+.*"
				+"|[^0-9+-/\\*\\(\\)]+")) {
			output.println("ERROR");
			output.println("#表达式包含非法字符");//表达式包含非法字符
			output.close();
			return false;
		}
		else if(expression.matches(".*\\(\\).*|\\(\\)|\\(\\).*|.*\\(\\)")) {
			output.println("ERROR");
			output.println("#表达式中有空括号");//表达式包含非法字符
			output.close();
			return false;
		}
		for(int i = 0;i<expression.length();i++) {
			char c = expression.charAt(i);
		//	int count=0;
			if(c=='(') {
		//		System.out.println("ERROR");
		//		System.out.println("#括号不匹配");//括号不匹配
				count--;
			}else if(c==')')
				count++;
		}
		if(count!=0) {
			output.println("ERROR");
			output.println("#括号不匹配");//括号不匹配
			output.close();
			return false;
		}
		if(expression.matches(".*[+-/\\*]{2,}"
				+"|.*[+-/\\*]{2,}.*"
				+"|[+-/\\*]{2,}.*")) {
			output.println("ERROR");
			output.println("#运算符连续");//括号不匹配
			output.close();
			return false;
		}
		if(expression.matches(".*[0-9]+\\(.*|[0-9]+\\(.*")) {
			output.println("ERROR");
			output.println("#括号非第一个字符且之前无运算符");//运算符无效
			output.close();
			return false;
		}
		if(expression.matches(".*\\)[0-9]+|.*\\)[0-9]+.*")) {
			output.println("ERROR");
			output.println("#小括号后无运算符，括号非第一个字符");//运算符无效
			output.close();
			return false;
		}
		if(expression.matches("[+-/\\*]+.*")) {
			output.println("ERROR");
			output.println("#运算符前无运算数");//运算符无效
			output.close();
			return false;
		}
		if(expression.matches(".*[+-/\\*]+")) {
			output.println("ERROR");
			output.println("#运算符后无运算数");//运算符无效
			output.close();
			return false;
		}
		output.close();
		return true;
	}
}
	
class FileOperation {	
	static boolean count=true;
	//写入文件
	public void writeFile(String s,File f,int result) {
		try (PrintWriter output = new PrintWriter(f);){
				output.println(s+"="+result);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
		}
	public void addFile(String s,File f,int result) throws IOException {
		try {
				FileWriter pw=new FileWriter(f,true);
				PrintWriter output=new PrintWriter(pw);
				output.println(s+"="+result);
				
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
		}
	
	//读取文件内容
	public void readLine(File f) {
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {//判断条件为:是否还有下一个输入
				String s = input.nextLine();
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();//在命令行打印异常信息在程序中出错的位置及原因
		}
	}
		
}






