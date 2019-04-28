package 大作业;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import javax.script.ScriptException;

class  Calculate {	//表达式求值
	public  boolean research(String exp) {//判断是否为运算符
		switch(exp)
		{
			case "+":
			case "-":
			case "*":
			case "/":
			case "(":
			case ")":
			case "#":
				return true;
			default:
				return false;
		 } 
	}
	
	public  int Switch(String ch) {//运算符查找
        int number = 0;
        switch (ch) {
        case "+": number = 0; break;
        case "-": number = 1; break;
        case "*": number = 2; break;
        case "/": number = 3; break;
        case "(": number = 4; break;
        case ")": number = 5; break;
        case "#": number = 6; break;
        default:
        	number = 11; break;
        }
        return number;
    }
	
	public  char judge(String One, String Two) {//运算符优先级比较
        char[][] menu = { 
                { '>','>','<','<','<','>','>' },
                { '>','>','<','<','<','>','>' },
                { '>','>','>','>','<','>','>' },
                { '>','>','>','>','<','>','>' },
                { '<','<','<','<','<','=',' ' },
                { '>','>','>','>',' ','>','>' },
                { '<','<','<','<','<',' ','=' }, };
        int x = 0, y = 0;
        x = Switch(One);
        y = Switch(Two);
        return menu[x][y];
    }
	
    public  ArrayList<String>  InversePolandExpression(String L) {//求算术表达式 L的逆波兰表达式	
		char []ch = L.toCharArray();
		String [] exp = new String[100];
		for(int j = 0;j<100;j++) {
			exp[j] = "";
		}
		int count = 0;		
		int i=0;
		while(i<ch.length)
		{
			if( ch[i] == '+'||ch[i] == ')'||ch[i] == '('||ch[i] == '/'||ch[i] == '*'||ch[i] == '-'||ch[i] == '#') {
				exp[count] =exp[count]+ch[i];
				count ++;
				i++;				
			}
			else {
				do {
					exp[count]+=ch[i];
					i++;					
				}while(ch[i]<= '9' && ch[i]>='0');
				count++;				
			}
		}//最终得到了一个字符串数组exp 里面每一个元素都为一个处理的对象
		for(int j=0;j<exp.length;j++)
			System.out.print(""+exp[j]);
		int m=1; 
		Stack<String> OPND = new Stack<String>();//OPND为存放运算符栈
		ArrayList<String> OPTR = new ArrayList<>();//OPTR为存放数字数组
		OPND.push("#");
		i = 0;
		while(m<exp.length) {
			if(!research(exp[m]))  {
				OPTR.add(exp[m]);
				m++;
			}
			else  {
				String peek=OPND.peek();//栈顶元素
				switch(judge(peek,exp[m]))
				{
					case '<': OPND.push(exp[m]);  //若栈顶元素优先级低，则将运算符进栈
							  m++;
					 	      break;
					case '=': OPND.pop();	//脱括号并处理下个字符 
		      	   			  m++;
		      	   			  break;
					case '>': OPTR.add(OPND.pop());//若栈顶元素优先级高，运算符出栈，并放入OPTR中							  
							  break;
				}
			}
		  }
		return OPTR; 
   }
    
    public int counter(String[] tokens) { //逆波兰表达式求值
    	if(tokens==null||tokens.length==0){	
    		return 0;		
    		}		
    	if(tokens.length==1){			
    		return Integer.parseInt(tokens[0]);		
    		}		
    	Stack<Integer> stack=new Stack<Integer>();		
    	//for(int i=0;i<5;i++){
    	int i=0;
    	while(tokens[i]!="") {
    		String temp=tokens[i];			
    		if(temp.equals("+")){				
    			int a=stack.pop();				
    			int b=stack.pop();				
    			stack.push(a+b);
    			i++;
    			}else if(temp.equals("*")){				
    				int a=stack.pop();				
    				int b=stack.pop();				
    				stack.push(a*b);	
    				i++;
    			}else if(temp.equals("-")){				
    				int a=stack.pop();				
    				int b=stack.pop();				
    				stack.push(b-a);	
    				i++;
    			}else if(temp.equals("/")){				
    				int a=stack.pop();				
    				int b=stack.pop();				
    				stack.push(b/a);
    				i++;
    			}else{				
    				stack.add(Integer.parseInt(temp));	
    				i++;
    			}		
    		}
			System.out.println();
    		System.out.print("结果为：");
    		return stack.pop();     
    	}
}

public class Expression { //主类
	public static String []stu=new String[20];
	static int i=0;
	public void readLine(File f) {//读取文件中的算术表达式
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {//接收输入的第一行字符
				String S= input.nextLine();//将接收的第一段字符赋值给字符串 s
				stu[i]=S;
				System.out.println(stu[i]);
				//System.out.println(stu[i].length());
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static  void clearInfoForFile(File f) {//清空文件夹
	    try {
	    	if(!f.exists()) {
	    		f.createNewFile();
	        }
	        FileWriter fileWriter =new FileWriter(f);
	        fileWriter.write("");
	        fileWriter.flush();
	        fileWriter.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	      }
	 }
	
	public static void main(String[] args) throws ScriptException, IOException {
		Expression fo = new Expression();
		File f = new File("src\\test");
		fo.readLine(f);//读取文件test
		File fi = new File("src\\file");
		clearInfoForFile(fi);
		Calculate calculate=new Calculate();
		Check check=new Check();
		for(int m=0;m<i;m++) {
			String s="";
				s=stu[m];
				//System.out.println(s);
				if(check.Test(s))
				{
					ArrayList<String> L=calculate.InversePolandExpression(s);//System.out.println(L);
					String[] l = (String[]) L.toArray(new String[0]);
					/*for(int n=0;n<l.length;n++)
						System.out.println(l[n]);*/
					int h=calculate.counter(l);
					System.out.println(h);
					try {
						FileWriter output = new FileWriter(fi,true);
						output.write(s+"\n");
						output.write("结果为\t"+h);
						output.write("\r\n");
						output.flush();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				/*else {
					m++;
				}*/
		//****///
		//ArrayList<String> list = new ArrayList<>();	
		}
	}
}