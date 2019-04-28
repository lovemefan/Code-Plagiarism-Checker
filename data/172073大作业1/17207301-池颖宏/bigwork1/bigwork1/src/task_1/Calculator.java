package task_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//计算器类
public class Calculator {
	
	
	public static int Operator(char c)
	{
	    switch(c)
	    {
	        case '+': 
				return 0;
	        case '-': 
				return 1;
	        case '*': 
				return 2;
	        case '/': 
				return 3;
	        case '(': 
				return 4;
	        case ')':
				return 5;
	        default:  
				return -1;
	    }
	}
	
	// 将字符串转化成List
	public static ArrayList<String> getList(String str){
		
		ArrayList<String> List = new ArrayList<String>();
		String num = "";
		
		for (int i = 0; i < str.length(); i++) {
			
			if(Character.isDigit(str.charAt(i))) {
				num = num + str.charAt(i);
			}
			else{
				if(num != ""){
					List.add(num);
				}	
				List.add(str.charAt(i) + "");
				num = "";						
			}
		}
		if(num != ""){
			List.add(num);
		}
		
		return List;
		
	}
	

	
	//将中缀表达式转化为后缀表达式
	public static ArrayList<String> InversePolandExpression(ArrayList<String> InOrderList){
		
		ArrayList<String> List = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();	//操作符栈
		
	
	    
	    // 运算符优先级表
	    char[][] Prior ={   
	    	{'>','>','<','<','<','>','>'},	//'+'
	    	{'>','>','<','<','<','>','>'},	//'-'
	        {'>','>','>','>','<','>','>'},	//'*'
	        {'>','>','>','>','<','>','>'},	//'/'
	        {'<','<','<','<','<','=','0'},	//'('
	        {'>','>','>','>','0','>','>'},	//')'
	        {'<','<','<','<','<','0','='}	//空栈
	    };
	    
	    int i=0;
	    int row=0;
	    int col=0;
	    while(i < InOrderList.size()) {
	    	
	    	if(Character.isDigit(InOrderList.get(i).charAt(0))) {
				List.add(InOrderList.get(i));
				i++;
			}
			else {
				
				row=6;	
				if(!stack.isEmpty())
					row = Operator(stack.peek().charAt(0));
				col = Operator(InOrderList.get(i).charAt(0));
					
				switch (Prior[row][col]) {
					
					case '<':	//栈顶元素优先权低 
						stack.push(InOrderList.get(i)); 	
						i++;
						break;
					case '=':	//脱括号并接收下一字符 
						stack.pop();
						i++;
						break;
					case '>': 	//栈顶元素优先权高
						List.add(stack.pop());
						break;  
				}
			}		
	    }	   
	    while(!stack.isEmpty()){
			
			List.add(stack.pop());
		}
	    
	    return List;		
	}
	
	// 计算后缀表达式
	public static double CalculatePolandExpression(ArrayList<String> PostOrder){
		
		Stack<Double> stack = new Stack<Double>();
		
		for (int i = 0; i < PostOrder.size(); i++) {
			
			if(Character.isDigit(PostOrder.get(i).charAt(0)))
				stack.push(Double.parseDouble(PostOrder.get(i)));
			else {
				
				double b = (Double)stack.pop();
				double a = (Double)stack.pop();
				double result = 0;
				switch (PostOrder.get(i).charAt(0)) {
					case '+':
						result = a + b;
						break;
					case '-':
						result = a - b;
						break;
					case '*':
						result = a * b;
						break;
					case '/':
						result = a / b;
						break;
				}
				stack.push(result);
			}
		}
		
		return (Double)stack.pop();
	}
	
	public static void main(String[] args) {
		
	//	Calculator calculate = new Calculator();
		FileOperate fo = new FileOperate();
			
		File F = new File("src\\Output");
		
		fo.writeFile(F);
	}

}

//校验类
class Test{
	
	public static int Test0(String[] s,int i) {	//判断是否有相同的请求 
		
		for(int j=i-1;j>=0;j--) {
				
			if(s[j].equals(s[i]))
				return 1;				
		}
		
		return 0;
	}
	
	public static int Test1(String s) {	//表达式为空
		
		if(s.matches(""))
			return 1;
		
		return 0;
	}
	
	public static int Test2(String s) {	//表达式中有空括号
		
		if(s.matches(".*[(][)].*"))
			return 1;
		
		return 0;
	}
	
	public static int Test3(String s) {	//表达式包含非法字符
		
		if(s.matches(".*[\\D&&[^+&&[^-&&[^*&&[^/&&[^(&&[^)]]]]]]].*"))
			return 1;
		
		return 0;
	}
	
	public static int Test4(String s) {	//括号不匹配
		
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++){
			
			char c = s.charAt(i);
			if(c == '('){
				stack.push('(');
			}
			else if(c == ')'){
				
				if(!stack.isEmpty())
					stack.pop();
				else
					return 1;
			}
		}
		if(!stack.isEmpty())
			return 1;
		
		return 0;
	}
	
	public static int Test5(String s) {	//运算符连续
		
		if(s.matches(".*[+[-[*[/]]]]{2}.*")) 
			return 1;
		
		return 0;
	}
	
	public static int Test6(String s) {	//运算符前无运算数
		
		if(s.matches(".*[\\D&&[^)]][+[-[*[/]]]].*") || s.matches("[+[-[*[/]]]].*"))
			return 1;
		
		return 0;
	}
	
	public static int Test7(String s) {	//运算符后无运算数
		
		if(s.matches(".*[+[-[*[/]]]][\\D&&[^(]].*") || s.matches(".*[+[-[*[/]]]]"))
			return 1;
				
		return 0;
	}
	
	public static int Test8(String s) {	//括号非第一个字符且之前无运算符
		
		if(s.matches(".*[^+&&[^-&&[^*&&[^/&&[^(]]]]][(].*"))
			return 1;
		
		return 0;
	}
	
	public static int Test9(String s) {	//小括号后无运算符，括号非最后一个字符
		
		if(s.matches(".*[)][^+&&[^-&&[^*&&[^/&&[^)]]]]].*"))
			return 1;
		
		return 0;
	}

}

//文件类
class FileOperate{
	
	public String[] readLine(File f) {

		ArrayList<String> arrString=new ArrayList<String>();
		
		try (Scanner input = new Scanner(f);){

			while(input.hasNextLine()) {

				arrString.add(input.nextLine());
			}

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String[] str = arrString.toArray(new String[arrString.size()]);
		
		return str;
	}
	
	public void writeFile(File F) {

		try (PrintWriter output = new PrintWriter(F);){

			File f = new File("src\\Input");
			String[] s =readLine(f);
			double result=0;
			
			for(int i=0;i<s.length;i++) {
				
				s[i]=s[i].replace(" ", ""); 
				
				if(Test.Test0(s,i) == 0) {
				
					if(Test.Test1(s[i]) == 1)
						output.println("ERROR\n#表达式为空");
					else if(Test.Test2(s[i]) == 1)
						output.println("ERROR\n#表达式中有空括号");
					else if(Test.Test3(s[i]) == 1)
						output.println("ERROR\n#表达式包含非法字符");
					else if(Test.Test4(s[i]) == 1)
						output.println("ERROR\n#括号不匹配");
					else if(Test.Test5(s[i]) == 1)
						output.println("ERROR\n#运算符连续");
					else if(Test.Test6(s[i]) == 1)
						output.println("ERROR\n#运算符前无运算数");
					else if(Test.Test7(s[i]) == 1)
						output.println("ERROR\n#运算符后无运算数");
					else if(Test.Test8(s[i]) == 1)
						output.println("ERROR\n#括号非第一个字符且之前无运算符");
					else if(Test.Test9(s[i]) == 1)
						output.println("ERROR\n#小括号后无运算符，括号非最后一个字符");
					else {
						
						ArrayList<String> Lista = Calculator.getList(s[i]);  //String转换为List
						ArrayList<String> Listb = Calculator.InversePolandExpression(Lista);   //中缀变后缀
						result = Calculator.CalculatePolandExpression(Listb);   //计算
						
						output.println(s[i]+"="+result);
					}
				}
				else {					
				}
			}
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} 

	}
}
