import java.util.*;
import java.util.regex.*;


import java.io.*;
public class calculator {
	public static void main(String[] args) throws Exception {
		ArrayList<String> AllExpression = new ArrayList<>();
		ArrayList<String> Expression = new ArrayList<>();
		System.out.println("Please enter expressions in File of Expression:");
		AllExpression = Check(Read());
		for(int i=0;i<AllExpression.size();i++) {
			Expression = strFormat(AllExpression.get(i));
			System.out.println(calculator(Expression));
			Write(calculator(Expression),AllExpression.get(i));
		}
		
	}
	public static ArrayList<String> Read() throws Exception {//从文件读取表达式并加入ArrayList类内
		File file = new File("src\\Expression");
		Scanner input = new Scanner(file);
		ArrayList<String> net = new ArrayList<>();
		while(input.hasNextLine()) {
			net.add(input.nextLine());
		}
		input.close();
		return net;	
	}
	public static void Write(int Answer,String Expression) throws IOException {//将原表达式及运算结果写入文件内
		FileWriter fw = null;
		try {
			File file=new File("src\\Answer");
			fw = new FileWriter(file, true);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter output = new PrintWriter(fw);
		output.println(Expression + "=" + Answer);//输出表达式的计算结果
		output.flush();
		try {
			fw.flush();
			output.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<String> Check(ArrayList<String> net) throws IOException{//用正则表达式对算是进行校验并将错误表达式删除
		File file = new File("src\\Answer");
		PrintWriter output = new PrintWriter(file);
		String pattern = "(?:（|&|!|@|>|<|:|）|\\{|\\$)";
		String pattern1 = "(?:\\(\\))";
		String pattern2 = "(?:\\+\\+|\\-\\-|\\*\\*|\\/\\/)";
	    Pattern r = Pattern.compile(pattern);
	    Pattern r1 = Pattern.compile(pattern1);
	    Pattern r2 = Pattern.compile(pattern2);
	    String symbol;
		for(int i=0;i<net.size();i++) {
			symbol = net.get(i);
			Matcher m = r.matcher(symbol);
			Matcher m1 = r1.matcher(symbol);
			Matcher m2 = r2.matcher(symbol);
			if (m.find( )) {//判断表达式是否包含非法字符
				output.println("ERROR");
				output.println("#表达式包含非法字符" );
				net.remove(i);
				i=i-1;
				}	
			else if (symbol.length() == 0) {//判断表达式是否为空
				output.println("ERROR");
				output.println("#表达式为空" );
				net.remove(i);
				i=i-1;
				}
			else if(m1.find()){//判断表达式中是否有空括号
				output.println("ERROR");
				output.println("#表达式中有空括号" );
				net.remove(i);
				i=i-1;
				}
			else if(m2.find()){//判段表达式是否运算符连续
				output.println("ERROR");
				output.println("#运算符连续" );
				net.remove(i);
				i=i-1;
				}
			else{//判断表达式的括号是否匹配
				int length = symbol.length();
				int R=0;   //右括号的数量
				int L=0;   //左括号的数量
				for(int x=0;x<length;x++){
					char a = symbol.charAt(x);
					if(a=='(')
						R++;
					else if(a==')')
						L++;
				}
				if(R!=L){
					output.println("ERROR");
					output.println("#括号不匹配" );
					net.remove(i);
					i=i-1;
				}
			}
		}
		output.close();
		return net;
	}
	
	public static int calculator(ArrayList<String> obj) {//表达式的运算
		ArrayList<String> result = transform(obj);//获取堆栈后的表达式
		//System.out.println(result);
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < result.size(); i++) {
			String symbol = result.get(i);//获取一个字符
			if (isDigital(symbol)) {//如果字符是数字型，堆栈
				stack.push(Integer.parseInt(symbol));
			}
			else {//如果字符是非数值型，计算
				int num1, num2;
				num1 = stack.pop();
				num2 = stack.pop();
				switch (symbol) {
				case "+":
					stack.push(num2 + num1);
					break;
				case "-":
					stack.push(num2 - num1);
					break;
				case "*":
					stack.push(num2 * num1);
					break;
				case "/":
					stack.push(num2 / num1);
					break;
				default:
					break;
				}
			}
		}
		return stack.pop();//返回表达式的计算结果
	}
	public static ArrayList<String> transform(ArrayList<String> arrayList) {//中缀表达式转化为后缀表达式
		Stack<String> stack = new Stack<>();//创建一个栈
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < arrayList.size(); i++) {
			String symbol = arrayList.get(i);
			if (isDigital(symbol)) {//字符是数值型就放入数组
				result.add(symbol);
			} 
			else if (symbol.equals(")")) {//字符是)栈顶元素不是(就把栈顶元素输出，指导遇到(
				String temp;
				while (!(temp = stack.pop()).equals("(")) {
					result.add(temp);
				}
			} 
			else {
				if (stack.isEmpty()) {//如果栈为空就把字符压栈，然后继续
					stack.push(symbol);
					continue;
				}
				String temp = stack.peek();
				while (outPriority(symbol) <= inPriority(temp)) {//当字符的优先级低于栈顶元素的优先级，输出栈顶元素
					result.add(temp);
					stack.pop();
					if (stack.isEmpty()) {//栈为空就停止
						break;
					}
					temp = stack.peek();
				}//while循环结束
				stack.push(symbol);//当字符的优先级高于栈顶元素就把字符压栈
			}
		}

		while (!stack.isEmpty()) {//栈为非空就把里面的符号依次输出
			result.add(stack.pop());
		}
		return result;//返回后缀表达式
	}
	public static ArrayList<String> strFormat(String s) {//表达式格式化
		ArrayList<String> arrayList = new ArrayList<>();
		StringBuilder sExp = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ' ') {
				continue;
			}
			if (!Character.isDigit(ch)) {
				if (!sExp.toString().trim().equals("")) {
					arrayList.add(sExp.toString().trim());
					sExp.delete(0, sExp.length());
				}
				arrayList.add(ch + "");
				continue;
			}
			sExp.append(ch);
		}
		if (!sExp.toString().trim().equals("")) {
			arrayList.add(sExp.toString().trim());
		}
		return arrayList;
	}
	public static boolean isDigital(String symbol) {//判断字符是否为运算符号
		return !symbol.equals("+") && !symbol.equals("-") && !symbol.equals("*") && !symbol.equals("/")
				&& !symbol.equals("(") && !symbol.equals(")");
	}

	public static int inPriority(String ch) {//判断符号优先级
		switch (ch) {
		case "+":
		case "-":
			return 2;
		case "*":
		case "/":
			return 4;
		case ")":
			return 7;
		case "(":
			return 1;
		default:
			return 0;
		}
	}

	public static int outPriority(String ch) {//判断符号优先级
		switch (ch) {
		case "+":
		case "-":
			return 3;
		case "*":
		case "/":
			return 5;
		case ")":
			return 1;
		case "(":
			return 7;
		default:
			return 0;
		}
	}
}