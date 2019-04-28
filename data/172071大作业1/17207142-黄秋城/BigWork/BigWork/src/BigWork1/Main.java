package BigWork1;
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) throws Exception{
		final int NUM=10;//输入的运算式数量
		
		java.io.File file=new java.io.File("operationIn.txt");//从operationIn读入
		java.io.File file1=new java.io.File("operationOut.txt");//对operationOut写出
		
		Scanner input=new Scanner(file);
		java.io.PrintWriter output=new java.io.PrintWriter(file1);
		String[] op=new String[NUM];
		
		Loop:for(int i=0;i<NUM;i++) {
			String b=input.nextLine();//b为文件输入的运算式
			op[i]=b;//把字符串b放在字符串数组中用来查重
			for(int j=0;j<i;j++) {//查重
				if(op[j].equals(op[i])) {//发现重复
					output.println("ERROR");
					output.println("#请求重复");
					continue Loop;//处理下一个请求
				}
			}
			
			Regex s1;
			s1=new Regex();//正则表达式类
			
			s1.Islegal(b);//正则表达式检查合法性
			if(s1.legal) {
				Stack st=new Stack();//处理表达式栈
				FixTo fi=new FixTo(st,b);//转后缀类
				String[] s2=fi.Process(b, st);//s2现在为保存后缀表达式的字符串数组
				
				StackInt sin=new StackInt();//处理运算类
				Calculate c=new Calculate(sin,s2);//计算后缀式类
				c.Operation(s2);
				output.println("运算结果为:"+c.result);
			}
			else if(s1.legal==false){
				s1.SetError(b);
				output.print("ERROR");
				output.println("");
				output.println(s1.error);
			}
			output.println("");
		}
		output.close();
		
	
	}
}
