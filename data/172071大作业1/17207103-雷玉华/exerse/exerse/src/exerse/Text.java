package exerse;
import java.util.*;
//import exerse.FileOperation; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
	
	static class  MyStack {
	    Object[] stacks; // 栈容器
	    int size; // 栈容量
	    int top; // 记录位置
	    int length; // 栈实际成员数量

	    public MyStack(int size) {
	        super();
	        this.size = size;
	        this.stacks = new Object[this.size];
	        this.top = -1;
	    }

	    // 获取栈顶元素
	    public Object peek() {
	        return this.stacks[top];
	    }

	    // 判断栈是否为空
	    public boolean isEmpty() {
	        return top == (-1);
	    }

	    // 判断栈是否已满
	    public boolean isFull() {
	        return top == (size - 1);
	    }

	    // 入栈过程
	    public void push(Object value) {
	        length++;
	        stacks[++this.top] = value;
	    }

	    // 出栈过程
	    public Object pop() {
	        length--;
	        return stacks[this.top--]; // 注意这里不能用“--this.top”，会导致栈溢出
	    }

	    // 获取栈实际大小
	    public int length() {
	        return this.length;
	    }
	}
static class ExperssionCalculate{//表达式计算
	
	
	public static int getPriority(String s) throws Exception {//优先级
		if(s==null) return 0;
	    switch(s) {
	        case "(":return 1;
	        case "+":;
	        case "-":return 2;
	        case "*":;
	        case "/":return 3;
	        default:break;
	    }
	    throw new Exception("illegal operator!");
	}
		
	public static String getResult(String expr,File f1) throws Exception {
		
		/*数字栈*/
	    //Stack<Integer> number = new Stack<Integer>(); 
		MyStack number = new MyStack(100);
	    /*符号栈*/
	    //Stack<String> operator = new Stack<String>();
	    MyStack operator = new MyStack(100);
	    if(!checkExpression.check(expr,f1))	return "";
	    operator.push(null);//在栈顶压人一个null，减少程序的判断
	    /* 将expr打散为运算数和运算符 */
	    Pattern p = Pattern.compile("(?<!\\d)-?\\d+(\\.\\d+)?|[+\\-*/()]");// 这个正则为匹配表达式中的数字或运算符
	    Matcher m = p.matcher(expr);
	    while(m.find()) {
	    	String temp = m.group();
	        if(temp.matches("[+\\-*/()]")){//遇到符号
	        	if(temp.equals("(")) {//遇到左括号，直接入符号栈
	        		operator.push(temp);
	                    
	            }else if(temp.equals(")")){//遇到右括号，"符号栈弹栈取栈顶符号b，数字栈弹栈取栈顶数字secondNum，数字栈弹栈取栈顶数字firstNum，计算firstNum b secondNum ,将结果压入数字栈"，重复引号步骤至取栈顶为左括号，将左括号弹出
	            		String t = null;
	            		
	                    while(!(t = (String) operator.pop()).equals("(")) {
	                        
	                    	int firstNum = (int) number.pop();
	                    	int secondNum = (int) number.pop();
	                        number.push(intCalculate( secondNum, firstNum, t.charAt(0)));
	                        
	                    }
	                }else{//遇到运算符，如果该运算符的优先级大于栈顶元素的优先级压栈；否则计算后压栈
	                    	while(getPriority(temp) <= getPriority((String) operator.peek())) {
	                    		int firstNum = (int) number.pop();
	                    		int secondNum = (int) number.pop();
	                    		String b = (String) operator.pop();
	                        
	                    		number.push(intCalculate( secondNum, firstNum, b.charAt(0)));
	                        
	                    }
	                    operator.push(temp);  
	                }
	            }else{//遇到数字，直接压入数字栈
	                	number.push(Integer.valueOf(temp));
	                }
	    	}

	        while(operator.peek()!=null){//遍历结束后，符号栈数字栈依次弹栈计算，并将结果压入数字栈
	        	int firstNum = (int) number.pop();
	            int secondNum = (int)number.pop();
	            String b = (String) operator.pop();
	            number.push(intCalculate(secondNum, firstNum, b.charAt(0)));
	        }
	        
	        return number.pop()+"";
	    }
	public static int intCalculate(int firstNum, int secondNum, char operator) throws Exception {//四则运算
		switch (operator) {
	        case '+':
	            return firstNum + secondNum;
	        case '-':
	            return firstNum - secondNum;
	        case '*': 
	            return firstNum * secondNum;
	        case '/':
	            return firstNum / secondNum;
	        default:
	            break;
		}
	    throw new Exception("illegal operator!");
	}
	
	}
	
			
	
static class checkExpression{		
		
	static boolean check(String s,File f1){//表达式校验
		int i=0;
		char item;
		
		Pattern EXPRESSION_PATTERN_ONE = Pattern.compile("[0-9\\.+-/*()= ]+");
		Matcher matcherOne = EXPRESSION_PATTERN_ONE.matcher(s);       
	    if (!matcherOne.matches()) {           
	    	//System.out.println("ERROR\r\n" + "#表达式包含非法字符");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#表达式包含非法字符");
	    	return false;
	    }
	    MyStack stack = new MyStack(100);
	    //Stack<Object> stack = new Stack<Object>();		
	    for(i=0;i<s.length();i++){	
		item = s.charAt(i);
			    			
		if(item=='('){				
			stack.push('(');			
		}else if(')' == item){				
			if(!stack.isEmpty()){					
			    stack.pop();				
			}else{	
			    //System.out.println("ERROR\r\n" + "#括号不匹配");
				FileOp.FileWrite(f1,"ERROR\r\n" + "#括号不匹配");
			    return false;				
				}			
			}		
		}		
		if(!stack.isEmpty()){	
			//System.out.println("ERROR\r\n" + "#括号不匹配");
			FileOp.FileWrite(f1,"ERROR\r\n" + "#括号不匹配");
			return false;		
		}
	    Matcher matcher = Pattern.compile("[\\\\+\\\\-\\\\*\\\\/]{2,}").matcher(s);            
	    while (matcher.find()) {                
	    	//System.out.println("ERROR\r\n" + "#运算符连续");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#运算符连续");
	    	return false;
	    }
	    
	    Matcher matcherTwo = Pattern.compile("\\(\\)").matcher(s);            
	    while (matcherTwo.find()) {                
	    	//System.out.println("ERROR\r\n" + "#表达式中有空括号");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#表达式中有空括号");
	    	return false;
	    }
	    
	    Matcher matcherThree = Pattern.compile("^[\\+\\*\\/]").matcher(s);            
	    while (matcherThree.find()) {                
	    	//System.out.println("ERROR\r\n" + "#运算符前无运算数");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#运算符前无运算数");
	    	return false;
	    }
	    Matcher matcherFour = Pattern.compile("[\\+\\-\\*\\/]$").matcher(s);            
	    while (matcherFour.find()) {                
	    	//System.out.println("ERROR\r\n" + "#运算符后无运算数");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#运算符后无运算数");
	    	return false;
	    }
	   // Matcher matcherFive = Pattern.compile("[^+-/\\\\*]+\\(").matcher(s);            
	    Matcher matcherFive = Pattern.compile("[^\\+\\-\\*\\/]\\(").matcher(s); 
	    while (matcherFive.find()) {                
	    	//System.out.println("ERROR\r\n" + "#括号非第一个字符且之前无运算数");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#括号非第一个字符且之前无运算数");
	    	return false;
	    }
	    //Matcher matcherSix = Pattern.compile("\\)[^+-/\\\\*]").matcher(s); 
	    Matcher matcherSix = Pattern.compile("\\)[^\\+\\-\\*\\/]").matcher(s); 
	    while (matcherSix.find()) {                
	    	//System.out.println("ERROR\r\n" + "#小括号后无运算数，括号非最后一个字符");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#小括号后无运算数，括号非最后一个字符");
	    	return false;
	    }
	    Matcher matcherSeven = Pattern.compile("\\([+/\\\\*]+").matcher(s);            
	    while (matcherSeven.find()) {                
	    	//System.out.println("ERROR\r\n" + "#左括号后面出现+*/");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#左括号后面出现+*/");
	    	return false;
	    }
	    Matcher matcherEight = Pattern.compile("[+-/\\\\*]+\\)").matcher(s);            
	    while (matcherEight.find()) {                
	    	//System.out.println("ERROR\r\n" + "#左括号后面出现+*/");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#左括号后面出现+*/");
	    	return false;
	    }
	    
	    
		return true;
				
	}
}	
	public static String[] array_unique(String[] ss) {    //去重
		ArrayList<String> list =new ArrayList<String>();		
		for(String s:ss){			
			if(!list.contains(s))						
				list.add(s);		
			}		
		return list.toArray(new String[list.size()]);
	}
static class FileOp{//文件的相关
	public static  void read(File f,File f1) throws Exception {
		String fileName = "C:\\eclipse\\exerse\\src\\result";//文件result的绝对路径
		String write = "";
		System.out.println("计算结果");
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {
				String s = input.nextLine();

				if(!(s.equals(""))&&!(ExperssionCalculate.getResult(s,f1).equals(""))) {
					
					write = s +"="+ ExperssionCalculate.getResult(s,f1);
					//System.out.println(write);
					//fileAdd(fileName,write);
					FileWrite(f1,write);
				}
				else if(s.equals("")){
					/*try (PrintWriter output = new PrintWriter(f1);){
						output.println("ERROR\r\n"+"#表达式为空");
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();*/
					
					//System.out.println("ERROR\r\n" + 
							//"#表达式为空" );
					FileWrite(f1,"ERROR\r\n" + "#表达式为空");
				}
				
				//fileAdd(fileName,write);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			}
		}
	static void FileWrite(File f1, String s) {
		FileWriter fw = null;        
		try {           //创建输出流的追加构造器        
			//也可以使用这种构造器 fw = new FileWriter(new File("b.txt"),true);            
			fw = new FileWriter(f1,true);
			 
			
		/*FileWriter fileWrite = new FileWrite(f1,ture);
		try {
			//fileWrite = new FileWrite(f1,ture);
			fileWrite.write(s+"\n");
			fileWrite.close();*/
			fw.write(s+"\n");
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	static  void Blank(File f1) {//清空文件result中所有内容
		try(PrintWriter output = new PrintWriter(f1);){
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	public static void writeFile(File f) {//输入要计算的表达式，存入文件
		Scanner input = new Scanner(System.in);
		String[] record = new String[16];//可一次性输入16个数学表达式，如想改变输入表达式的数量，需将315行和317行的16同时改成你想要的数字
		int i=0;
		for(i=0;i<16;i++) {	
			System.out.println("请输入表达式");
			record[i] = input.nextLine();
			
		}
		record=array_unique(record);
		try (PrintWriter output = new PrintWriter(f);){
			for(i=0;i<record.length;i++) {	
				
				String s = record[i];
				output.println(s);	
			}					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	public static void fileAdd(String fileName, String content) {//追加文件

		try {// 打开一个随机访问文件流，按读写方式
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
		
				long fileLength = randomFile.length();// 文件长度，字节数
				randomFile.seek(fileLength);// 将写文件指针移到文件尾。
				randomFile.writeBytes(content+"\r\n");
				randomFile.close();
		
			}catch (IOException e){
					e.printStackTrace();
		
			}
		
	}
	public static void readLine(File f1) {//按行读取文件result中内容
		
		try (Scanner input = new Scanner(f1);){
			while(input.hasNextLine()) {
				String s = input.nextLine();
				
				System.out.println(s);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
}
	public static void main(String[] args) throws Exception {
		
		
		File f = new File("src\\expression");
		File f1 = new File("src\\result");
		FileOp.writeFile(f);
		FileOp.Blank(f1);
		FileOp.read(f,f1);
		FileOp.readLine(f1);
		
		

	 }
}	
