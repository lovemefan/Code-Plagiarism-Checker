import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class calculator {
	
	static String[] flagArray = new String[100];  //存放已经通过的计算式
	static int flag = 0;  //标记计算式在flagArray的位置
	
	public calculator() {
		// TODO Auto-generated constructor stub
	}
	
	//枚举
	public enum operatorEnum{
		PLUS(0, '+'), MINUS(0, '-'), MULTIPLY(1, '*'), DIVIDE(1, '/'),  LEFT_BRACKET(2, '('), RIGHT_BRACKET(2, ')');//枚举操作符
		
		public Integer first;		//优先级
		public Character opera;     	//操作符
			
		private operatorEnum(int first,char opera){
			this.first = first;
			this.opera = opera;
		}
			
		public String toString(){
			return String.valueOf(opera);
		}
				
	}
		
	//判断字符是否为操作符
	private operatorEnum isOperator(char c){
		for(operatorEnum p : operatorEnum.values()){
			if(c == p.opera){
				return p;
			}
		}
		return null;
	}
		
	//将计算式转换为后缀表达式
	public String toBack(String s1){
		//存放算数字符的数组
		char[] c = s1.trim().toCharArray(); //trim() 函数移除字符串两侧的空白字符或其他预定义字符
		 LinkedList<operatorEnum> stack = new LinkedList<operatorEnum>();
		 StringBuilder sb = new StringBuilder();
		 
		 operatorEnum opera = null;
		 
		 for(int i = 0; i < c.length; i++){
			 //遍历每个字符，检查是否为操作符
			 if((opera = isOperator(c[i])) == null){
				 sb.append(c[i]);
			 }
			 //持续弹出栈顶元素直到左括号，但不输出
			 else if(opera.equals(operatorEnum.RIGHT_BRACKET)){
				 //如果不是左括号，持续弹出并输出
				 while(!stack.peek().equals(operatorEnum.LEFT_BRACKET)){
					 sb.append(stack.pop());
				 }
				 stack.pop();
			 }
			 else{
				 //弹出并输出所有高优先级或者同等优先级，直到遇到低优先级或者左括号为止
				 while(stack.size() > 0 && stack.peek().first >= opera.first && !stack.peek().equals(operatorEnum.LEFT_BRACKET)){
					 sb.append(stack.pop());
				 }
				 //入栈
				 stack.push(opera);
			 }
		 }
		 //弹出栈中剩下的所有操作符
		 while(stack.size() > 0){
			 sb.append(stack.pop());
		 }
		 return sb.toString();
	}
		
	//计算后缀表达式
	public double compute(String toback){
		char[] c = toback.toCharArray();
		LinkedList<Double> stack = new LinkedList<Double>();
		operatorEnum opera = null;
		for(int i = 0; i < c.length; i++){
			//判断是否为操作符，是则入栈
			if((opera = isOperator(c[i])) == null){
				stack.push(Double.parseDouble(String.valueOf(c[i])));
			}
			else{
				//不是操作符，进行计算
				double m = stack.pop();
				double n = stack.pop();
				switch(opera){
					
				case PLUS:
					stack.push(n + m);//加法运算
					break;
				case MINUS:
					stack.push(n - m);//减法运算
					break;
				case MULTIPLY:
					stack.push(n * m);//乘法运算
					break;
				case DIVIDE:
					stack.push(n / m);//除法运算
					break;
						
				default:
					break;
				}
			}
		}
		//返回弹出栈顶
		return stack.pop();
	}
	
	//将计算式存入数组
	public static void getArray(String s){
		flagArray[flag] = s;
		flag++;
	}

	//比较数组的元素来查重
	public static boolean repeat(String s){
		for(int i = flag-1; i > 0;i--){
			if(s.equals(flagArray[i-1])){
				return true;
			}
		}
		return false;
	}
	
	//正则表达式的校验
	public static String regularExpression(String s){
		
		char s_first = s.charAt(0);
		char s_end = s.charAt(s.length()-1);
		
		boolean a = s.matches("(.*)[\\*+-/][\\*+-/](.*)");
		boolean b = s.matches("(.*)\\([\\*+-/](.*)");
		boolean c = s.matches("[0-9\\+\\-\\(\\)\\*\\/]*");
		boolean d = s.matches("(.*)[\\*+-/]\\)(.*)");
		boolean e = s.matches("(.*)[0-9]\\((.*)");
		boolean f = s.matches("(.*)\\)[0-9](.*)");
		boolean g = s.matches("(.*)\\(\\)(.*)");
		
		
		if(a == true){
			return "          #运算符连续";
		}
		else if(b == true){
			return "          #左括号后是运算符";
		}
		else if(c == false){
			return "          #表达式内含非法字符";
		}
		else if(d == true){
			return "          #右括号前是运算符";
		}
		else if(e == true){
			return "          #左括号前不是运算符";
		}
		else if(f == true){
			return "          #右括号后不是运算符";
		}
		else if(g == true){
			return "          #空括号";
		}
		else if(s_first == '+' || s_first == '/' ||s_first == '*' || s_first == '-'){
			return "          #运算符出现在首位";
		}
		else if(s_end == '+' || s_end == '/' ||s_end == '*' || s_end== '-'){
			return "          #运算符出现在末尾";
		}
		
		return s;
		
	}
	
	public static void main(String[] args) throws IOException{
	
		calculator my = new calculator();
		
		java.io.File file = new java.io.File("I:/experimentTest/test.txt");		//在指定路径下创建file对象，打开test.txt
		java.io.File file1 = new java.io.File("I:/experimentTest/testResult.txt");		//在指定路径下创建file1对象，创建testResult.txt
		
		Scanner input = new Scanner(file);
		java.io.PrintWriter p = new java.io.PrintWriter(file1);
		
		//若testResult.txt文件已经存在，则删除文件
		if(file1.exists() && file1.isFile()){
			file1.delete();
		}
		
		//计算式输出操作
		while(input.hasNext()){
			String s1 = input.nextLine();
			String s1_quit = s1.replaceAll(" ","");  //replacAll语句去除字符串里的空格
			getArray(s1_quit);
			boolean check = repeat(s1_quit);
			if(check == true){
				continue;
			}
			else if(regularExpression(s1_quit) == s1_quit){
				String result = s1_quit+" = "+my.compute(my.toBack(s1_quit));
				p.println(result);		//将正确结果写入文件
			}
			else{
				p.println(s1_quit);
				p.println("          ERROR");
				p.println(regularExpression(s1_quit));  //将错误信息写入文件
			}
		}
		p.close();
		input.close();
		
	}

}
