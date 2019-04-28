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
	    Object[] stacks; // ջ����
	    int size; // ջ����
	    int top; // ��¼λ��
	    int length; // ջʵ�ʳ�Ա����

	    public MyStack(int size) {
	        super();
	        this.size = size;
	        this.stacks = new Object[this.size];
	        this.top = -1;
	    }

	    // ��ȡջ��Ԫ��
	    public Object peek() {
	        return this.stacks[top];
	    }

	    // �ж�ջ�Ƿ�Ϊ��
	    public boolean isEmpty() {
	        return top == (-1);
	    }

	    // �ж�ջ�Ƿ�����
	    public boolean isFull() {
	        return top == (size - 1);
	    }

	    // ��ջ����
	    public void push(Object value) {
	        length++;
	        stacks[++this.top] = value;
	    }

	    // ��ջ����
	    public Object pop() {
	        length--;
	        return stacks[this.top--]; // ע�����ﲻ���á�--this.top�����ᵼ��ջ���
	    }

	    // ��ȡջʵ�ʴ�С
	    public int length() {
	        return this.length;
	    }
	}
static class ExperssionCalculate{//���ʽ����
	
	
	public static int getPriority(String s) throws Exception {//���ȼ�
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
		
		/*����ջ*/
	    //Stack<Integer> number = new Stack<Integer>(); 
		MyStack number = new MyStack(100);
	    /*����ջ*/
	    //Stack<String> operator = new Stack<String>();
	    MyStack operator = new MyStack(100);
	    if(!checkExpression.check(expr,f1))	return "";
	    operator.push(null);//��ջ��ѹ��һ��null�����ٳ�����ж�
	    /* ��expr��ɢΪ������������� */
	    Pattern p = Pattern.compile("(?<!\\d)-?\\d+(\\.\\d+)?|[+\\-*/()]");// �������Ϊƥ����ʽ�е����ֻ������
	    Matcher m = p.matcher(expr);
	    while(m.find()) {
	    	String temp = m.group();
	        if(temp.matches("[+\\-*/()]")){//��������
	        	if(temp.equals("(")) {//���������ţ�ֱ�������ջ
	        		operator.push(temp);
	                    
	            }else if(temp.equals(")")){//���������ţ�"����ջ��ջȡջ������b������ջ��ջȡջ������secondNum������ջ��ջȡջ������firstNum������firstNum b secondNum ,�����ѹ������ջ"���ظ����Ų�����ȡջ��Ϊ�����ţ��������ŵ���
	            		String t = null;
	            		
	                    while(!(t = (String) operator.pop()).equals("(")) {
	                        
	                    	int firstNum = (int) number.pop();
	                    	int secondNum = (int) number.pop();
	                        number.push(intCalculate( secondNum, firstNum, t.charAt(0)));
	                        
	                    }
	                }else{//��������������������������ȼ�����ջ��Ԫ�ص����ȼ�ѹջ����������ѹջ
	                    	while(getPriority(temp) <= getPriority((String) operator.peek())) {
	                    		int firstNum = (int) number.pop();
	                    		int secondNum = (int) number.pop();
	                    		String b = (String) operator.pop();
	                        
	                    		number.push(intCalculate( secondNum, firstNum, b.charAt(0)));
	                        
	                    }
	                    operator.push(temp);  
	                }
	            }else{//�������֣�ֱ��ѹ������ջ
	                	number.push(Integer.valueOf(temp));
	                }
	    	}

	        while(operator.peek()!=null){//���������󣬷���ջ����ջ���ε�ջ���㣬�������ѹ������ջ
	        	int firstNum = (int) number.pop();
	            int secondNum = (int)number.pop();
	            String b = (String) operator.pop();
	            number.push(intCalculate(secondNum, firstNum, b.charAt(0)));
	        }
	        
	        return number.pop()+"";
	    }
	public static int intCalculate(int firstNum, int secondNum, char operator) throws Exception {//��������
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
		
	static boolean check(String s,File f1){//���ʽУ��
		int i=0;
		char item;
		
		Pattern EXPRESSION_PATTERN_ONE = Pattern.compile("[0-9\\.+-/*()= ]+");
		Matcher matcherOne = EXPRESSION_PATTERN_ONE.matcher(s);       
	    if (!matcherOne.matches()) {           
	    	//System.out.println("ERROR\r\n" + "#���ʽ�����Ƿ��ַ�");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#���ʽ�����Ƿ��ַ�");
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
			    //System.out.println("ERROR\r\n" + "#���Ų�ƥ��");
				FileOp.FileWrite(f1,"ERROR\r\n" + "#���Ų�ƥ��");
			    return false;				
				}			
			}		
		}		
		if(!stack.isEmpty()){	
			//System.out.println("ERROR\r\n" + "#���Ų�ƥ��");
			FileOp.FileWrite(f1,"ERROR\r\n" + "#���Ų�ƥ��");
			return false;		
		}
	    Matcher matcher = Pattern.compile("[\\\\+\\\\-\\\\*\\\\/]{2,}").matcher(s);            
	    while (matcher.find()) {                
	    	//System.out.println("ERROR\r\n" + "#���������");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#���������");
	    	return false;
	    }
	    
	    Matcher matcherTwo = Pattern.compile("\\(\\)").matcher(s);            
	    while (matcherTwo.find()) {                
	    	//System.out.println("ERROR\r\n" + "#���ʽ���п�����");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#���ʽ���п�����");
	    	return false;
	    }
	    
	    Matcher matcherThree = Pattern.compile("^[\\+\\*\\/]").matcher(s);            
	    while (matcherThree.find()) {                
	    	//System.out.println("ERROR\r\n" + "#�����ǰ��������");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#�����ǰ��������");
	    	return false;
	    }
	    Matcher matcherFour = Pattern.compile("[\\+\\-\\*\\/]$").matcher(s);            
	    while (matcherFour.find()) {                
	    	//System.out.println("ERROR\r\n" + "#���������������");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#���������������");
	    	return false;
	    }
	   // Matcher matcherFive = Pattern.compile("[^+-/\\\\*]+\\(").matcher(s);            
	    Matcher matcherFive = Pattern.compile("[^\\+\\-\\*\\/]\\(").matcher(s); 
	    while (matcherFive.find()) {                
	    	//System.out.println("ERROR\r\n" + "#���ŷǵ�һ���ַ���֮ǰ��������");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#���ŷǵ�һ���ַ���֮ǰ��������");
	    	return false;
	    }
	    //Matcher matcherSix = Pattern.compile("\\)[^+-/\\\\*]").matcher(s); 
	    Matcher matcherSix = Pattern.compile("\\)[^\\+\\-\\*\\/]").matcher(s); 
	    while (matcherSix.find()) {                
	    	//System.out.println("ERROR\r\n" + "#С���ź��������������ŷ����һ���ַ�");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#С���ź��������������ŷ����һ���ַ�");
	    	return false;
	    }
	    Matcher matcherSeven = Pattern.compile("\\([+/\\\\*]+").matcher(s);            
	    while (matcherSeven.find()) {                
	    	//System.out.println("ERROR\r\n" + "#�����ź������+*/");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#�����ź������+*/");
	    	return false;
	    }
	    Matcher matcherEight = Pattern.compile("[+-/\\\\*]+\\)").matcher(s);            
	    while (matcherEight.find()) {                
	    	//System.out.println("ERROR\r\n" + "#�����ź������+*/");
	    	FileOp.FileWrite(f1,"ERROR\r\n" + "#�����ź������+*/");
	    	return false;
	    }
	    
	    
		return true;
				
	}
}	
	public static String[] array_unique(String[] ss) {    //ȥ��
		ArrayList<String> list =new ArrayList<String>();		
		for(String s:ss){			
			if(!list.contains(s))						
				list.add(s);		
			}		
		return list.toArray(new String[list.size()]);
	}
static class FileOp{//�ļ������
	public static  void read(File f,File f1) throws Exception {
		String fileName = "C:\\eclipse\\exerse\\src\\result";//�ļ�result�ľ���·��
		String write = "";
		System.out.println("������");
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
						output.println("ERROR\r\n"+"#���ʽΪ��");
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();*/
					
					//System.out.println("ERROR\r\n" + 
							//"#���ʽΪ��" );
					FileWrite(f1,"ERROR\r\n" + "#���ʽΪ��");
				}
				
				//fileAdd(fileName,write);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			}
		}
	static void FileWrite(File f1, String s) {
		FileWriter fw = null;        
		try {           //�����������׷�ӹ�����        
			//Ҳ����ʹ�����ֹ����� fw = new FileWriter(new File("b.txt"),true);            
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
	static  void Blank(File f1) {//����ļ�result����������
		try(PrintWriter output = new PrintWriter(f1);){
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	public static void writeFile(File f) {//����Ҫ����ı��ʽ�������ļ�
		Scanner input = new Scanner(System.in);
		String[] record = new String[16];//��һ��������16����ѧ���ʽ������ı�������ʽ���������轫315�к�317�е�16ͬʱ�ĳ�����Ҫ������
		int i=0;
		for(i=0;i<16;i++) {	
			System.out.println("��������ʽ");
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
	public static void fileAdd(String fileName, String content) {//׷���ļ�

		try {// ��һ����������ļ���������д��ʽ
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
		
				long fileLength = randomFile.length();// �ļ����ȣ��ֽ���
				randomFile.seek(fileLength);// ��д�ļ�ָ���Ƶ��ļ�β��
				randomFile.writeBytes(content+"\r\n");
				randomFile.close();
		
			}catch (IOException e){
					e.printStackTrace();
		
			}
		
	}
	public static void readLine(File f1) {//���ж�ȡ�ļ�result������
		
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
