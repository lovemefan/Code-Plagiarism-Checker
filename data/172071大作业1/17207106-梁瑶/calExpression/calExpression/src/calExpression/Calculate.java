package calExpression;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calculate {
	public static void main(String[] args) throws IOException {
		LinkedList<Character> stack=new LinkedList<Character>();
		File file = new File("src\\Expression");
		Scanner input = new Scanner(file);
		if (file.exists()) {
			File file1 = new File("src\\Output");
			java.io.PrintWriter output = new java.io.PrintWriter(file1);
			//起初此语句与上一个语句放在了while循环中，出现的问题是文件输出只能显示出输入文件的最后一行
	      	//放在里面，每次进行while循环时，都会先创建文件再打开文件，这样一来，每次都把之前的的文件覆盖掉
			//所以才会出现只显示一行的问题
			while (input.hasNext()) {// 使用has.Next()表示可以自动循环输入
				String str=input.next();
				String s=input.nextLine();
				s=s.replaceAll("\\s","");
				System.out.print(s);
				boolean flag=UnmatchBrackets(s);
				if(s.matches("")){
					System.out.println("\nERROR\r\n" + 
							"#表达式为空\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#表达式为空\n");
					continue;
				}
				else if(s.matches("\\(\\)[\\+\\-\\*\\/]+\\d")){
					System.out.println("\nERROR\r\n" + 
							"#表达式中有空括号\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#表达式中有空括号\n");
					continue;
				}
				else if(s.matches(".*[\\+\\-\\*\\/]{2,}.*")){
					System.out.println("\nERROR\r\n" + 
							"#运算符连续\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#运算符连续\n");
					continue;
				}
				else if(!s.matches("[0-9\\\\.+-/*()= ]+")){
					System.out.println("\nERROR\r\n" + 
							"#表达式包含非法字符\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#表达式包含非法字符\n");
					continue;
				}
				else if(flag==true){
					System.out.println("\nERROR\r\n" + 
							"#括号不匹配\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#括号不匹配\n");
					continue;
				}
				else if(s.matches("[\\+\\*\\/].*")){
					System.out.println("\nERROR\r\n" + 
							"#运算符前无运算数\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#运算符前无运算数\n");
					continue;
				}
				else if(s.matches(".*[\\+\\-\\*\\/]")){
					System.out.println("\nERROR\r\n" + 
							"#运算符后无运算数\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#运算符后无运算数\n");
					continue;
				}
				else if(s.matches(".*[^\\(\\+\\-\\*\\/\\)]\\(.*")){
					System.out.println("\nERROR\r\n" + 
							"#括号非第一个字符且之前无运算符\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#括号非第一个字符且之前无运算符\n");
					continue;
				}
				else if(s.matches(".*\\)[^\\+\\-\\*\\/\\)\\(].*")){
					System.out.println("\nERROR\r\n" + 
							"#小括号后无运算符，括号非最后一个字符\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#小括号后无运算符，括号非最后一个字符\n");
					continue;
				}
				else if(s.matches("\\d+[\\+\\-\\*\\/]\\d\\/0")){
					System.out.println("\nERROR\r\n" + 
							"#除数不能为0\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#除数不能为0\n");
					continue;
				}
					
				else{
					char[] biaodashi = s.toCharArray();// 关键的一步，把文件中由键盘输入的转化为字符数组System.out.print(biaodashi);
					String expression = getchangeExpression(biaodashi);// 获取转换后的字符串表达式，下面有方法
																		// 调用getExpression()方法
					// 将转换后的后缀表达式输出，expression作为参数，上俩行的expression
					char[] s2 = expression.toCharArray();// 将转换成为后缀表达式的字符串expression转换成字符数组，存在数组s2中
					ArrStack as = rpn(s2); // 将字符数组s2设置成数组栈 as
											// 开始利用数据结构中的栈来设置计算器的具体实现
					as.listStack();//调用矩形拼接 把最终结果输出
					System.out.println();
					output.print(biaodashi);
					
					output.println("=" + as.stackPop());
					// +as.stackPop()
					//这里出现的问题是输出文件显示的是地址，而后将as改为as.stackPop()后，结果成功显示
					//表达式出现的问题是输出地址问题，原因是字符数组biaodashi不支持Java中的+号连接
					// output.println(Arrays.toString(biaodashi)+"="+as.stackPop());//+as.stackPop()
					
					continue;
				}
				
			}
			output.close();// 文件用完后进行关闭操作
		}
}
	public static boolean UnmatchBrackets(String s) {// 如果括号不匹配，则返回 true;否则返回false
		int len = s.length();
		LinkedList<Character> stack = new LinkedList<Character>();
		// 循环遍历字符串
		for (int i = 0; i < len; i++) {
			// 如果是左括号则入栈
			char  ch = (char) s.charAt(i);
			if (ch == '(') {
				stack.push(ch);
				// 如果是右括号
			} else if (ch == ')') {
				// 栈空，则右括号没有匹配的左括号，则返回false
				if (stack.isEmpty()) {
					return true;
					// 栈不空，则和栈顶比较
				} else if (stack.peek().equals(ch)) {
					return true;
				} else {
					stack.pop();
				}
			}
		}
		// 循环结束后，栈空表示匹配完了，不空表示多余左括号
		if (stack.isEmpty()) {
			return false;
		} else {
			return true;
		}
}
	public static String getchangeExpression(char[] s) {// 中缀表达式转后缀表达式
		ArrStack as = new ArrStack();// 构造新的数组栈

		String arr = ""; // 创建字符串存储后缀表达式 给字符串数组arr初始化赋值
		for (int i = 0; i < s.length; i++){ // s是字符数组
		
			if (isNumber(s[i]) || s[i] == '.') {// 判断字符数组s中的字符 如果是 数字 或者 .
												// 那么直接放入创建的字符串arr中
				arr = arr + s[i];
				if (i != s.length - 1) { // 判断数字是否完全输入,如果全部输入完毕,则在后面加上空格
					if (!isNumber(s[i + 1]) && s[i + 1] != '.'){ // 判断字符数组s中的最后一位字符
																// 如果不是 数字 或者 .
					
						arr = arr + " ";// 添加空格
					}
				} else { // 如果字符的最后一位是数字,则直接加空格(与最后出栈的运算符字符区分)
				

					arr = arr + " ";
				}
				// 如果是运算符字符,则判断后入栈
			}

			else if (s[i] == '+' || s[i] == '-' || s[i] == '*' || s[i] == '/'){ // 与之前if相对应
			
				// 如果是+ -则判断栈顶元素是否为 * / 如果是,先将栈顶元素出栈后再入栈 否则,直接入栈
				if (s[i] == '+' || s[i] == '-') {
					if (!as.isEmpty()) {// 如果栈不为空
					 // 判断栈是否为空
						char r = as.getTop();// 读取数组栈as的栈顶元素给字符r
						// gettop 是栈的操作，意思是读取栈顶元素的值，但是并不出栈元素，栈中元素个数不变
						while (r == '+' || r == '-' || r == '*' || r == '/') {
							r = as.stackPop();// 相当于把数组栈as转化为字符串r,目的是可以和数组arr相连
							/*
							 * 这里as.pop()是一个Object类型的对象，当其与String相“+”时，
							 * 系统会自动调用Object的toString()方法将其转成String表示。
							 */
							arr = arr + r + " ";

							if (!as.isEmpty()) { // 如果栈不为空,则继续给r,然后继续开始原循环
								r = as.getTop();
							} 
							else { // 如果栈为空,则直接跳出循环
								break;
							}
						}
					}
					as.stackPush(s[i]);// 当栈为空，跳出循环之后，把数组s中的元素 入栈
				}
				else { // /栈为空 把数组s中的元素 入栈
					as.stackPush(s[i]);
				}
}
			// 如果字符是 “ ( ” 直接入栈, 如果是“ ) ” 则栈顶元素依次出栈,直到出栈元素是 “ ( ”为止
			else if (s[i] == '(') {
				as.stackPush(s[i]);
			} else if (s[i] == ')') {
				char r = as.stackPop();
				while (r != '(') {
					arr = arr + r + " ";
					r = as.stackPop();
				}
			}
		}

		// 将栈中剩余的元素依次存入字符串中
		while (!as.isEmpty()) {
			char r = as.stackPop();
			arr = arr + r + " ";
		}
			return arr;
	}

	// 逆波兰表达式求值
	public static ArrStack rpn(char[] s) {// 数组栈 rpn方法 将字符数组s中的字符传入
		ArrStack as = new ArrStack();// 创建一个数组栈as
		int num = 0;
		// 定义空字符串存入字符
		String arr = "";// 初始化字符数组arr，先传入空值
		int a = 0;
		int b = 0;
		int result = 0;
		for (int i = 0; i < s.length; i++) {
			// 如果是数字或者.则推入栈中
			if (isNumber(s[i]) || s[i] == '.') {
				arr = arr + s[i];
			} 
			else if (s[i] == ' ') {
				// 遇到空格,将数据取出转成double类型推入栈中
				if (arr == "") {
					continue;
				}
				else {
					num = Integer.valueOf(arr);// 将字符串数组arr中的值转化为double类
					as.stackPush(num);
					// 字符串置空
					arr = "";
				}

			} 
			else {
				// 遇到运算符字符,弹出栈顶前两个数进行运算后再压入栈中
				switch (s[i]) {
				case '+':
					a = as.stackPop();
					b = as.stackPop();
					result = b + a;
					as.stackPush(result);
					break;
				case '-':
					a = as.stackPop();
					b = as.stackPop();
					result = b - a;
					as.stackPush(result);
					break;
				case '*':
					a = as.stackPop();
					b = as.stackPop();
					result = b * a;
					as.stackPush(result);
					break;
				case '/':
					a = as.stackPop();
					b = as.stackPop();
					if (a == 0) {
						System.out.println("\n除数不能为0!");
						break;
					}
					result = b / a;
					as.stackPush(result);
					break;

				}
			}
		}
		return as;// 返回数组栈as
	}

	// 判断字符是否为数字
	public static boolean isNumber(char c) // 布尔值方法判断字符是否为数字
	{
		if (c >= 48 && c <= 57) {
			return true;
		}
		return false;
	}

}