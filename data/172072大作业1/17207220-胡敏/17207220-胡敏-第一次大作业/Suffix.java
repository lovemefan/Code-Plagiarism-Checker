package 大作业;//构建得出逆波兰式的栈,输出运算符的顺序,栈和队列的使用,运算符前没有运算数,文件输出

import java.util.Queue;
import java.util.Stack;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.io.IOException;
//9+(3-1)*3+10/2
//(1-15+16)*90
//(15+5)*14-6*(3+32-5)

public class Suffix {
	public static void filetoexp(String a,File fw) throws IOException {
	Stack<String> exp=new Stack<String>();//
	Stack<String> dig=new Stack<String>();
	Queue<String> suff=new LinkedList<String>();
	
//	Scanner input=new Scanner(System.in);
//	String a=input.nextLine();//读取一个表达式
//	System.out.println(a);
	if(a.isEmpty()) {
		System.out.println("ERROR\n#表达式为空");
		return;
	}
	int left=0;
	int right=0;
	for(int i=0;i<a.length();i++) {
		char e=a.charAt(i);
		if(e=='(') {
			left++;
		}
		if(e==')') {
			right++;
		}
	}
	if(right!=left) {
		System.out.println("ERROR\n#括号不匹配\n");
		return;
	}
	
	for(int i=0;i<a.length();i++) {//求逆波兰式
		
		char b=a.charAt(i);
		String str0=String.valueOf(b);
		
		if(b=='(') {
			exp.push(str0);
			//continue;
		}
		else if(b==')') {
			String c=(String)exp.pop();
			if(c.equals("(")) {
				System.out.println("ERROR\n#表达式中有空括号\n");
				return;
			}
			while(!c.equals("(")&&!exp.isEmpty()) {
				suff.offer(c);
				c=(String)exp.pop();
						}
		//	suff.offer(c);
		}
		else 
		
		if(b>='0'&&b<='9'){//读到是数字时
	
			if(i+1!=a.length())//需要连接数字
			{
				dig=Linkdig(dig,str0,a,i,suff);
				
				if((a.charAt(i+1)<'0'||a.charAt(i+1)>'9')) {
					String str4=dig.pop();
					suff.offer(str4);
					}
			}
			else if(i+1==a.length())
			{//遇到数字
				dig=Linkdig(dig,str0,a,i,suff);
				String str4=dig.pop();
				suff.offer(str4);
			}
		}
		//读到操作符“+”，“-”，“*”，“/”，则从栈中弹出栈元素并输出，
		//直到遇到优先级更低或者“(”的为止操作符为止（该元素不出栈）。
		else if(b=='+'||b=='-'||b=='/'||b=='*') {
			
			if(i+1!=a.length()) {
				if('+'==a.charAt(i+1)||a.charAt(i+1)=='-'
								||a.charAt(i+1)=='*'||a.charAt(i+1)=='/') {
					System.out.println("ERROR\n#运算符连续\n");
					return;
				}
			}

//运算符前没有运算数，运算符之前只能是运算数或是")"
			
			if(i==0) {
				System.out.println("ERROR\n#运算符前无运算数\n");
				return;
			}
			else 
			{
				String qian=String.valueOf(a.charAt(i-1));
				if(!qian.equals(")")&&(!qian.matches("[0-9.0]{1,}"))){
							System.out.println("ERROR\n#运算符前无运算数\n");
							return;
						}
			}
			
			if(i==a.length()-1) {
				System.out.println("ERROR\n#运算符后无运算数\n");
				return;
			}
			else 
			{
				String hou=String.valueOf(a.charAt(i+1));
				if(!hou.equals("(")&&(!hou.matches("[0-9.0]{1,}"))){
							System.out.println("ERROR\n#运算符后无运算数\n");
							return;
						}
			}
			
			if(exp.isEmpty()) {
				exp.push(str0);//只在空栈时存了一个
			}
			else if(!exp.isEmpty()) 
			{
				String str7=exp.peek();
				while(!(
								(
									str0.equals("*")||str0.equals("/")
								)
								&
								(
									str7.equals("+")||str7.equals("-")
								)
						)
							&!str7.equals("(")) {
					if(!exp.isEmpty()) {
						suff.offer(exp.pop());
					}
					else {
						break;
					}
					if(!exp.isEmpty()) {
						str7=exp.peek();
					}
					else {
						break;
					}
				}
				exp.push(str0);
			}
		}
		else {//检测非法字符
			System.out.println("ERROR\n#表达式包含非法字符\n");
			return;
		}
	}//for循环结束
	while(!exp.isEmpty()) {//Stack.peek读栈顶元素
		suff.offer(exp.pop());
	}
		int i=0;
		int size=suff.size();
		String[] p=new String[size];
		for(String q : suff){
			p[i]=q;
			i++;
//	        System.out.println(q);//展示逆波兰式
	    }
		
		String zy=Calculate.suffixtocal(p);
		String output=a.concat(zy);
		System.out.println(output);
		
//		fo.writeFile(f);//将内容写入文件，并覆盖原有内容
//		try (PrintWriter hzy= new PrintWriter(fw)){//文本输出打印对象格式化形式
//			hzy.println(output);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} 		
		
		FileWriter f= null;
		try {//如果文件存在，则追加内容；如果文件不存在，则创建文件
			f= new FileWriter(fw, true);
			} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(f);//pw
		pw.println(output);//输入数据
		pw.flush();
		try {
			f.flush();
			pw.close();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		File file=new File("src\\output");//写文件
//		Writer out=new FileWriter(file);
//		out.write("");
//		out.close();
}

	private static  Stack<String> Linkdig(Stack<String> dig,String str0,String a,int i,Queue<String> suff) {
		if(dig.isEmpty())
		{
			dig.push(str0);
		}
			else if(!dig.isEmpty()) 
			{
				String str1=dig.pop();//(String)dig.pop();
				String str2=str1.concat(str0);
				dig.push(str2);
			}
		return dig;
		}
}