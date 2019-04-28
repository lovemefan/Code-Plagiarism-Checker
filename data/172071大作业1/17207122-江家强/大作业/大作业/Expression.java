package ����ҵ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import javax.script.ScriptException;

class  Calculate {	//���ʽ��ֵ
	public  boolean research(String exp) {//�ж��Ƿ�Ϊ�����
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
	
	public  int Switch(String ch) {//���������
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
	
	public  char judge(String One, String Two) {//��������ȼ��Ƚ�
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
	
    public  ArrayList<String>  InversePolandExpression(String L) {//���������ʽ L���沨�����ʽ	
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
		}//���յõ���һ���ַ�������exp ����ÿһ��Ԫ�ض�Ϊһ������Ķ���
		for(int j=0;j<exp.length;j++)
			System.out.print(""+exp[j]);
		int m=1; 
		Stack<String> OPND = new Stack<String>();//OPNDΪ��������ջ
		ArrayList<String> OPTR = new ArrayList<>();//OPTRΪ�����������
		OPND.push("#");
		i = 0;
		while(m<exp.length) {
			if(!research(exp[m]))  {
				OPTR.add(exp[m]);
				m++;
			}
			else  {
				String peek=OPND.peek();//ջ��Ԫ��
				switch(judge(peek,exp[m]))
				{
					case '<': OPND.push(exp[m]);  //��ջ��Ԫ�����ȼ��ͣ����������ջ
							  m++;
					 	      break;
					case '=': OPND.pop();	//�����Ų������¸��ַ� 
		      	   			  m++;
		      	   			  break;
					case '>': OPTR.add(OPND.pop());//��ջ��Ԫ�����ȼ��ߣ��������ջ��������OPTR��							  
							  break;
				}
			}
		  }
		return OPTR; 
   }
    
    public int counter(String[] tokens) { //�沨�����ʽ��ֵ
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
    		System.out.print("���Ϊ��");
    		return stack.pop();     
    	}
}

public class Expression { //����
	public static String []stu=new String[20];
	static int i=0;
	public void readLine(File f) {//��ȡ�ļ��е��������ʽ
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {//��������ĵ�һ���ַ�
				String S= input.nextLine();//�����յĵ�һ���ַ���ֵ���ַ��� s
				stu[i]=S;
				System.out.println(stu[i]);
				//System.out.println(stu[i].length());
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static  void clearInfoForFile(File f) {//����ļ���
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
		fo.readLine(f);//��ȡ�ļ�test
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
						output.write("���Ϊ\t"+h);
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