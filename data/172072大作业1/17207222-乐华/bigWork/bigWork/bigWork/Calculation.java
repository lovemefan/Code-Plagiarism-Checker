package bigWork;

import java.io.File;
public class Calculation {
	public static void main(String[] args) throws NumberFormatException, Exception {
		// TODO Auto-generated method stub
		 FileOperation fo = new FileOperation();
		 File f = new File("print\\experssion");
		 File f1 = new File("print\\result");
		// fo.writeFile(f);
		 expressionTest correct = new expressionTest(fo,f);
		 String[] s = new String[fo.numberLine];
		 String[] ss = new String[fo.numberLine];
		
		 correct.geterrorReminder();
		 String[] error = correct.getError(fo);
		 String[] nibolan;
		 int[] flag = new int[fo.numberLine];
		 int index=1;
		 for(int i=0;i<fo.numberLine;i++) {
			 s[i] = fo.s[i];
		//	 System.out.println(s[i]);
			 if(correct.errorReminder[i]==i) {
				 flag[index] = i;
				 index++;
				 continue;
			 }
			 else {
				String[] aprts = new String[s[i].length()];
				int flagLength = sort(s[i],aprts);
				String[] aprts1 = new String[flagLength];
				for(int k=0;k<flagLength;k++) {
					aprts1[k]=aprts[k];
				}
				nibolan=Inverse(aprts1);
				ss[i] = hzbdsqz(nibolan);
			 }
		 }
		 int[] flag1 = new int[index];
		 if(index!=1){
			 for(int h=0;h<index;h++)
				 flag1[h]=flag[h+1];
		 }
		 fo.writeFile1(f1,ss,s,flag1,error);
	 }
	
	public static int sort(String expression,String[] s) {//把表达式字符串分成运算符和运算数字符串放入一个字符串数组里并返回数组
		 int j=0;
		 String expression1 = expression+"#";
		 int k,index=0;
		 for(int i=0;i<expression1.length();i++) {
			if(expression1.charAt(i) == '#') 
					break;
			if(Character.isDigit(expression1.charAt(i)) == true) {
				s[j]=expression1.substring(i,i+1);
				index=i;
				for(k=index;k<expression1.length();k++) {
					if(expression.charAt(i) == ' ') 
						break;
					else if(Character.isDigit(expression1.charAt(k+1)) == true) {
						s[j]=expression.substring(index,k+2);
						i++;
					}
					else
						break;
				 }
			}
			else {	
				s[j]=expression.substring(i,i+1);	
			}
	//	 System.out.println(j +": " +s[j]);
		 j++;
		 }
	//	 System.out.println(j);
		 return j;
	}
	public static int In(char ch)//判断是否为{'#','+','-','*','/','(',')'}中的一种若是则返回0，不是则返回1 
	{
		char[] OP={'#','+','-','*','/','(',')'};
		int j,i=1;
		for(j=0;j<7;j++)
		{
			if(ch==OP[j])
			{
				i=0;
				break;
			}
			
		}
		if(i==0)
			return 0;
		else
			return 1;
	}
	public static char Precede(char e,char ch)//比较优先级 
	{
		char f = '0';
		switch(ch)
		{
			case '+':
			case '-': 
				if(e=='('||e=='#')
					f='<';
				else
					f='>';
				break;
			case '*':
			case '/':
				if(e=='*'||e=='/'||e==')')
					f='>';
				else
					f='<';
				break;
			default :
				f = Precede1(e,ch);
	    }
	    return f;	
	}
	public static char Precede1(char e,char ch){
		char f = '0';
		switch(ch)
		{
			case '(':
				if(e==')')
				{
					System.out.println("ERROR");
					break;
				}
				else
					f='<';
				break;
			case ')':
				switch(e)
	       		{
	        		case '(':
	       			     f='=';
	           		break;
	        		case '#':
	         			System.out.println("ERROR2");
	       	    	break;
	        		default:
	          		  f='>';
	     		}
	        	break;
			case '#':
	        	switch(e)
	       		{
	       			case '#':
	            		f='=';
	            	break;
	        		case '(':
	        			System.out.println("ERROR3");
	            	break;
	       			default: 
	            		f='>';
	       	}
		}
		 return f;	
	}
	public static String[] Inverse(String[] aprts)//去括号把表达式变为逆波兰式并放入数组并返回；
	{
		String[] num = new String[aprts.length];
		String[] s = new String[aprts.length+2];
		s[0] = "#";
		s[aprts.length+2-1] = "#";
		for(int k=1;k<aprts.length+2-1;k++) {
			s[k]=aprts[k-1];
		}
		char e,ch;
		String x;
		int i,j,flag=0;
		Stack oper = new Stack(); 
		i=0;
		j=0;
		oper.push(s[i]);
		i++;
		e = oper.peek().charAt(0);
		while(s[i].charAt(0)!='#' || e!='#')
		{
			if(In(s[i].charAt(0))==1)
			{
				num[j++]=s[i++];
			}
			else
			{
				e = oper.peek().charAt(0);
				switch(Precede(e,s[i].charAt(0)))
				{
					case '<':
						oper.push(s[i]);	
						i++;
						break;
					case '=':
						x = oper.pop();
						if(x.equals("(")==true)
							flag = flag+2;
						i++;
						break;
					case '>':
						x = oper.pop();
						num[j++] = x;
						break;  
				}
				e = oper.peek().charAt(0);//刷新栈顶元素以便while循环的工作 
			}
		}
		String[] biaodasi =new String[num.length-flag];
		for(i=0;i<num.length-flag;i++) {
			biaodasi[i]=num[i];
		}
		return biaodasi;
	}
	public static String Operate(String a,String theat,String b)//运算后缀表达式 并返回运算后的值 
	{
		double f1,f2,total=0;
		String ch = "0";
		switch (theat)
			{
				case "+":
					total=Double.parseDouble(a)+Double.parseDouble(b);
				break;
				case "-":
					total=Double.parseDouble(a)-Double.parseDouble(b);
				break;
				case "*":
					total=Double.parseDouble(a)*Double.parseDouble(b);
				break;
				case "/":
					total=Double.parseDouble(a)/Double.parseDouble(b);
				break;
			}
			ch = ch.valueOf(total);
			return ch;
	}
	public static String hzbdsqz(String[] s)// 把运算符和操作符分开便于运算 
	{
		String result;
		int j;
			Stack opnd = new Stack();; 
		String a,b,theat,e;
		j=0;
		while(j<s.length)
		{
			if(In(s[j].charAt(0))==1)
				opnd.push(s[j]);
			else
			{
				b=opnd.pop();
				a=opnd.pop();
				theat = s[j];
				opnd.push(Operate(a,theat,b));
			}
			j++;
		}
		result = opnd.pop();
	//	System.out.println(result);
		return result;
	}
}
