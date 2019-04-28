package 大作业;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Stack {
	// 顺序栈
		private String[] data;
		// 栈顶
		private int top;

		// 指定栈的大小为10000
		public Stack() {
			data = new String[10000];
			top = 0;
		}

		// 入栈
		public void push(String data) {
			this.data[top++] = data;
		}

		// 出栈
		public String pop() {
			return data[--top];
		}

		// 栈是否为空
		public boolean isEmpty() {
			return top == 0;
		}

		// 查看栈顶元素
		public String top() {
			return data[top - 1];
		}

}
class Calculate {
	// 栈
	Stack stack;
	// 中缀表达式
	ArrayList<String> infix;
	// 后缀表达式
	ArrayList<String> postfix;
	// 表达式的结果
	double num = 0;
	// 校验类的传入
	private Check check;

	public Calculate() {

	}

	// 构造方法
	// 校验类的引用
	public Calculate(Check check) {
		stack = new Stack();
		postfix = new ArrayList<>();
		infix = check.toInfix();
		this.check = check;
		toPostfix();
		compute();
	}

	// 计算后缀表达式的结果
	public void compute() {
		stack = new Stack();
		for (String str : postfix) {
			if (str.matches("[\\+\\-\\*\\/]")) {
				double num2 = Double.valueOf(stack.pop());  //类型转换
				double num1 = Double.valueOf(stack.pop());  //类型转换
				switch (str) {
				case "+":
					num = num1 + num2;
					break;
				case "-":
					num = num1 - num2;
					break;
				case "*":
					num = num1 * num2;
					break;
				case "/":
					// 除数为0的情况
					if (Math.abs(num2) < 1e-8) {
						check.setLegal(false);
						check.setError("除数不能为0");
						return;
					}
					num = num1 / num2;
					break;
				}
				stack.push(String.valueOf(num));
			} else {
				stack.push(str);   //进栈
			}
		}
	}

	// 中缀转后缀
	private void toPostfix() {
		// 遍历中缀表达式
		for (String str : infix) {
			// 优先级低全部出栈再入栈或者遇到左括号结束
			if (str.matches("[\\+\\-]")) {
				while (!stack.isEmpty() && !stack.top().equals("(")) {
					postfix.add(stack.pop());  
				}
				stack.push(str);     //进栈
			} else if (str.matches("[\\*\\/]")) {
				while (!stack.isEmpty() && stack.top().equals("[\\*\\/]")) {
					postfix.add(stack.pop());   
				}
				stack.push(str);   //进栈
			} else if (str.matches("\\(")) {
				stack.push(str);    //进栈
			} else if (str.matches("\\)")) {
				while (!stack.top().matches("\\(")) {
					postfix.add(stack.pop());     
				}
				stack.pop();  //出栈
			} else {
				num = Double.valueOf(str);
				postfix.add(str);
			}
		}
		// 将栈中符号弹出到后缀表达式中
		while (!stack.isEmpty()) {
			postfix.add(stack.pop());
		}
	}

	public ArrayList<String> getPostfix() {
		return postfix;
	}

	public double getNum() {
		return num;
	}
}
class Check {
	// 表达式
	private String expression;
	// 错误信息
	private String error;
	// 表达式正确性true正确，false错误
	private boolean legal;
	// 正则表达式
	private String[] regex = { "^$", "\\(\\)", "[\\+\\-\\*\\/]{2,}", "[^0-9\\+\\-\\*\\/\\(\\)]",
			"\\([\\*\\/]", "\\d\\(", "\\)\\d", "[\\+\\-\\*\\/]\\)", "[\\+\\-\\*\\/]$|^[\\*\\/]" };
	//错误信息
	private String[] errorInformation = { "空行","空括号", "运算符连续", "含有非法字符", "左括号后乘除运算符", 
			                              "左括号前数字", "右括号后数字", "右括号前运算符", "首尾符号非法" };
	Pattern pattern;
	
	public Check(){
		
	}

	public Check(String str) {
		expression = str;
		legal = true;
		process();
	}

	// 过滤空白符
	private void filterSpace() {
		expression = expression.replaceAll("\\s", "");
	}

	// 括号个数是否匹配
	private void legalOfBrackets() {
		pattern = Pattern.compile("[\\(\\)]");
		Matcher matcher = pattern.matcher(expression);
		String tmp = "";
		// 括号序列
		while (matcher.find()) {
			tmp += matcher.group();
		}
		// 括号消消乐
		while(tmp.contains("()")){
			tmp = tmp.replaceAll("\\(\\)", "");
		}
		if (tmp.equals("") == false) {
			legal = false;
			error = "括号不匹配";
		}
	}

	// 检查字符串
	public void process() {
		// 过滤空白符
		filterSpace();
		// 括号个数校验
		legalOfBrackets();
		// 检查表达式的正确性
		for (int i = 0; i < regex.length && legal; ++i) {
			pattern = Pattern.compile(regex[i]);
			Matcher matcher = pattern.matcher(expression);
			if (matcher.find()) {
				legal = false;
				error = errorInformation[i];
			}
		}
	}

	// 将负数转为0-正数的形式
	private void transform() {
		expression = expression.replaceAll("\\(\\-", "(0-");
		expression = expression.replaceAll("\\(\\+", "(0+");
		expression = expression.replaceAll("^\\+", "0+");
		expression = expression.replaceAll("^\\-", "0-");
	}

	// 转为中缀
	public ArrayList<String> toInfix() {
		transform();
		ArrayList<String> str = new ArrayList<>();
		pattern = Pattern.compile("[\\+\\-\\*\\/\\(\\)]|\\d+");
		Matcher matcher = pattern.matcher(expression);
		while (matcher.find()) {
			str.add(matcher.group());
		}
		return str;
	}

	//获取表达式
	public String getExpression() {
		return expression;
	}

	//获取错误信息
	public String getError() {
		return error;
	}

	//获取表达式是否合法
	public boolean getLegal() {
		return legal;
	}

	//设置表达式是否合法
	public void setLegal(boolean legal) {
		this.legal = legal;
	}
	
	//设置错误信息
	public void setError(String error) {
		this.error = error;
	}
}
class FileToFile {
	// 数据存储
	ArrayList<String> data = new ArrayList<>();

	public FileToFile() {

	}

	// 读文件写文件
	public void inputFile() throws IOException {
		File file = new File("input.txt");
		File outputFile = new File("output.txt");
		//判断文件是否存在
		if (!file.exists()) {
			System.out.println("文件不存在");
			System.exit(0);
		}
		Scanner input = new Scanner(file);
		PrintWriter output = new PrintWriter(outputFile);
		while (input.hasNextLine()) {
			String str = input.nextLine();
			Check check = new Check(str);
			str = check.getExpression();
			// 数据查重
			if (!data.contains(str)) {
				outputFile(check, output);
				data.add(str);
			}
		}
		output.close();
		System.out.println("成功");
		input.close();
	}

	// 输出到文件
	private void outputFile(Check check, PrintWriter output) {
		String str = check.getExpression();
		if (check.getLegal()) {
			Calculate c = new Calculate(check);
			// 在计算之后知道除数为0的情况
			c.compute();
			if (check.getLegal()) {
				output.println(str + "=" + c.getNum());   //将计算结果写入文件
			} else {
				output.println("ERROR\n#" + check.getError());  //将错误信息写入文件
			}
		} else {
			output.println("ERROR\n#" + check.getError());  //将错误信息写入文件
		}
	}
}



