package 表达式计算器;

public class Calculate {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int count;//统计文本读入的表达式的个数
		StackOfOperater optr=new StackOfOperater();
		StackOfOperand opnd=new StackOfOperand();//创建一个操作数栈和一个运算符栈
		FileOperation f=new FileOperation();//创建一个文件操作类的对象
		String[] s=new String[10];//创建字符串数组，用于接收表达式
		
		String[] tokens=new String[30];//创建字符串数组，拆分一个表达式字符串为多个子字符串
		double value;
		double n1,n2;
		char theta;//以上三个声明，见while语句
		double[] result=new double[10];//创建一个数值型数组，保存计算结果
		count=f.readFile(s);//读取文件，并返回表达式个数
		optr.push('#');
		for(int i=0;i<count;i++) {
			tokens=s[i].split(" ");//使用字符串拆分，把一个空格隔开的表达式拆成一个个子字符串
			char ch=tokens[0].charAt(0);//把子字符串转换为字符
			char c=optr.peek();//让c成为为运算符栈的栈顶元素
			int j=0;
			while(ch!='#'||c!='#') {//当栈顶元素和输入元素不同时为#时，进行表达式计算
				if(ch>=48&&ch<=57) {//当输入元素为数字字符时，转换成数字，然后进入操作数栈
					value=Double.parseDouble(tokens[j]);
					opnd.push(value);
					ch=tokens[++j].charAt(0);//ch接收下一字符
				}
				else {//当输入元素为运算符时，分三种情况讨论
					switch(prior(c,ch)) {//比较运算符栈栈顶元素和输入元素的优先权
					case '<': optr.push(ch);			  
							  ch=tokens[++j].charAt(0);
							  break;
					case '=': optr.pop();
							  ch=tokens[++j].charAt(0);
							  break;
					case '>': n2=opnd.pop();
							  n1=opnd.pop();
							  theta=optr.pop();
							  opnd.push(operate(n1,theta,n2));
							  break;
					}
				}
				c=optr.peek();
			}
			result[i]=opnd.pop();
		}
		f.writeFile(s,count,result);
	}
	public static char prior(char a,char b) {
		char[][] ch= {
						{'>','>','<','<','<','>','>'},{'>','>','<','<','<','>','>'},
						{'>','>','>','>','<','>','>'},{'>','>','>','>','<','>','>'},
						{'<','<','<','<','<','=',' '},{'>','>','>','>',' ','>','>'},
						{'<','<','<','<','<',' ','='}
					};
		return ch[index(a)][index(b)];
	}
	public static int index(char a) {
		int index=0;
		if(a=='+')
			index=0;
		if(a=='-')
			index=1;
		if(a=='*')
			index=2;
		if(a=='/')
			index=3;
		if(a=='(')
			index=4;
		if(a==')')
			index=5;
		if(a=='#')
			index=6;
		return index;
	}
	public static double operate(double n1,char theta,double n2) {
		double result=0;
		if(theta=='+')
			result=n1+n2;
		if(theta=='-')
			result=n1-n2;
		if(theta=='*')
			result=n1*n2;
		if(theta=='/')
			result=n1/n2;
		return result;
	}

}
