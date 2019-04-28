import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

class Stack{

	String result;	//运算所得的结果
	
	//通过两个栈进行运算
	public  Stack(String[] c){
		this.result =Stack_operation(c);
	}
	
	public String Stack_operation(String[] c) {
		String[] elements1 = new String[20];		//定义两个字符串类型的数组作为栈
		String[] elements2 = new String[20];
		int size1=-1;
		int size2=-1;
		String m="null";
		
		for(int i=0;c[i]!=null;i++) {
			if(Character.isDigit(c[i].charAt(0))) {	//如果是数字，则直接入栈
				size1++;
				push(c[i],elements1,size1);
			}
			else {
				if(size2==-1) {
					size2++;
					push(c[i],elements2,size2);
				}
				else if(Judge(elements2[size2],c[i])==0) {		//弹出两个数字及一个运算符进行运算
					String p1=elements1[size1];size1--;
					String p2=elements2[size2];
					String p3=elements1[size1];
					String k=Calculate(p1,p2,p3);
					push(c[i],elements2,size2);
					push(k,elements1,size1);
				}
				else if(c[i].equals(")")) {
					int s;
					for(s=size2;!elements2[s].equals("(");s--) {
						String p1=elements1[size1];size1--;
						String p2=elements2[s];
						String p3=elements1[size1];
						String k=Calculate(p1,p2,p3);
						push(k,elements1,size1);
					}
					size2=s-1;
				}
				else if(Judge(elements2[size2],c[i])==1) {
					size2++;
					push(c[i],elements2,size2);
				}
			}
		}
		while(size1>0) {		//当元素已全部入栈之后
			String p1=elements1[size1];size1--;
			String p2=elements2[size2--];
			String p3=elements1[size1];
			elements1[size1] =Calculate(p1,p2,p3);
		}
		m=elements1[size1];
		return m;
	}
	
	public void push(String value,String[] elements,int size) {
		if(size>=elements.length) {
			String[] temp = new String[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		elements[size] = value;
	}
	
	
	public int Judge(String s1,String s2) {
		int i=1;	//i=1入栈，i=0弹出操作符以及操作数进行计算
		char a= s1.charAt(0);
		char b= s2.charAt(0);
		
		if((a=='+' || a=='-')&&(b=='*' || b=='/'))
			i=1;
		else if((a=='+' || a=='-')&&(b=='+' || b=='-'))
			i=0;
		else if((a=='*' || a=='/')&&(b=='+' || b=='-'))
			i=0;
		else if((a=='*' || a=='/')&&(b=='*' || b=='/'))
			i=0;
		else if(a=='(')
			i=1;
		
		
		return i;
	}
	
	public String Calculate(String d,String e,String f) {		//运算操作
		int r=0; 
		int g =Integer.parseInt(d);
		int k =Integer.parseInt(f);
		if(e.equals("+")) r=g+k;
		if(e.equals("-")) r=k-g;
		if(e.equals("*")) r=k*g;
		if(e.equals("/")) r=k/g;
		
		String R = r+"";
		return R;
	}
	
}

public class Calculator {
	
	//将字符串分解成数字和运算符
	public static String[] GetCharacter(String s) {
		int location1=-1,location2=0,j=0;
		int n=0;
		String[] c = new String[50];
		while(j<s.length()) {
			if((s.charAt(j)>=40&&s.charAt(j)<=43)||s.charAt(j)==45||s.charAt(j)==47){
				location2=j;
				if(location2>0) {
					if(location2-1!=location1) {
						c[n]=s.substring(location1+1,location2);
						n++;
					}
				}
				c[n]=s.substring(j,j+1);
				location1=location2;
				n++;
				j++;
			}
			else
				j++;
		}
		if(Character.isDigit(s.charAt(s.length()-1))) {
			c[n]=s.substring(location2+1);
			n++;
		}
		return c;
	}
	
	//若错方法
	public static int Fault_tolerant(String s) {
		String[] c=GetCharacter(s);

		int f=0,flag=0;
		for(int i=0;i<s.length();i++) {
			if(!(Character.isDigit(s.charAt(i))||(s.charAt(i)>=40&&s.charAt(i)<=43)||s.charAt(i)==45||s.charAt(i)==47)) {
				f=3;
				break;
			}
		}
		
		for(int j=0;c[j]!=null;j++) {
			if(c[j].equals("("))
				flag++;
			if(c[j].equals(")"))
				flag--;
		}
		if(flag!=0)
			f=4;
		else {
			for(int i=0;c[i]!=null;i++) {
				if(c[i].equals("(") && c[i+1].equals(")")) {
					f=2;
					break;
				}
				else if((c[i+1]!=null)&&(c[i].equals("+") ||c[i].equals("-")||c[i].equals("*")||c[i].equals("/"))&&(c[i+1].equals("+") ||c[i+1].equals("-")||c[i+1].equals("*")||c[i+1].equals("/"))) {
					f=5;
					break;
				}
			}
		}
		
		return f;
	}
	
	public static String Fault_print(int z) {
		String q = "ERROR";
		
		switch(z) {
		case 1 : q=" #表达式为空";
				break;
		case 2 : q=" #表达式中有空括号";
				break;
		case 3 : q=" #表达式中含有非法字符";
				break;
		case 4 : q=" #括号不匹配";
				break;
		case 5 : q=" #运算符连续";
				break;
		case 6 : q=" #运算符前无运算数";
				break;
		case 7: q=" #运算符后无运算数";
				break;
		}
		return q;
	}
	
	
	public static String[] read(File f) {
		String[] w=new String[50];
		int i=0;
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {
				String s = input.next();
				System.out.println(s);
				
				if(Fault_tolerant(s)==0) {
					String[] c=GetCharacter(s);
					Stack k =  new Stack(c);
					w[i] = s+" = "+k.result;
					i++;
					System.out.println("the result:"+k.result);
				}
				else {
					w[i]=s+" (ERROR"+Fault_print(Fault_tolerant(s))+")";
					i++;
					continue;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return w;
	}
	
	public static void writeFile(File f,String[] w) {
		try (PrintWriter output = new PrintWriter(f);){	//获取文件的输入流
			for(int i=0;w[i]!=null;i++) 
				output.print(w[i]+"\n");			//通过输入流向文件写入字符串
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator fo = new Calculator();
		File f = new File("src\\test2");
		File W = new File("src\\result");
		String[] w=read(f);
		
		writeFile(W,w);
	}

}
