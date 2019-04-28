package homeWork;
import java.util.regex.*;
public class ComputeExpression {
	public String copmpute(String string1) {
		string1=suppelmentDecimals(string1);//处理不完整小数
		string1=preproccessing(string1);//预处理-(转-1*(
		ExpressionStack operand=new ExpressionStack();//操作数栈
		String temp="";//
		String pattern="\\-?\\(*\\-?\\d+\\)*|\\-?\\(*\\-?\\d+\\.\\d+\\)*";
		boolean isMatch=Pattern.matches(pattern,string1);
		if(isMatch) {//只有一个操作数时
			String pattern_1="(\\-?\\d+\\.\\d+)";
			String pattern_2="(\\-?\\d+)";
			Pattern r1=Pattern.compile(pattern_1);
			Pattern r2=Pattern.compile(pattern_2);
			Matcher m1=r1.matcher(string1);
			Matcher m2=r2.matcher(string1);
			if(m1.find()) {
					temp=m1.group(1);//捕获浮点数
			}
			else if(m2.find()) {
					temp=m2.group(1);//捕获整数
			}
			else
				temp="0";
		}
		else {
			string1+="#";//作为结束标志
			pluralOperand(operand,string1);//表达式含多个操作数
			temp=operand.getTops();
		}
		return temp;
	}//copmpute(String reply)
	
	private void pluralOperand(ExpressionStack operand,String string){//表达式含多个操作数时在此计算
		ExpressionStack operator=new ExpressionStack();//操作符栈
		operator.push("#");//设一标记
		Priority judge=new Priority();//判断优先级
		int i=0;
		String temp="";
		String ch=string.substring(i,i+1);
		String str4=operator.getTops();
		while(!ch.equals("#")||!str4.equals("#")){			//ch!="#"不能这样判断字符串是否相等
			if(Character.isDigit(ch.charAt(0))||ch.equalsIgnoreCase(".")) {
				temp+=ch;				//用来存储操作数直到遇到操作符才压入栈中
				i++;
				ch=string.substring(i,i+1);
			}
			else{
				if(!temp.equalsIgnoreCase(""))				//操作数封装完成,压入栈中
					operand.push(temp);
				String minus="next";
				String character="first";
				if(i<(string.length()-1)) //substring函数的参数只能取0到string.length()-1之间的值
					minus=string.substring(i+1, i+2);//ch后一字符
				if(i>0)
					character=string.substring(i-1,i);//ch前一字符
				boolean digit=Character.isDigit(minus.charAt(0));//ch后的字符为数字
				boolean double_num=minus.equalsIgnoreCase(".");
				boolean before1=character.equals(")");
				boolean before2=Character.isDigit(character.charAt(0));
				if((ch.equals("-")||ch.equals("+"))&&(digit||double_num)&&(!before1&&!before2)) {//操作数为带符号的数,则加入符号
					if(ch.equals("-"))											 //注:a||b&&c 先进行b与c的与运算,再与a进行或运算
						temp="-";												//带符号的数,符号前必定不是')'和数字,以此判断此数是否为带符号数
					else
						temp="+";
					ch=minus;	
					i++;
					continue;
				}
				temp="";							
				String str3=judge.comparePriority(ch,operator.getTops());
				switch(str3) {		//判断栈顶元素与输入的字符的优先级
					case "<":			//栈顶元素比操作符优先级低
						operator.push(ch);
						i++;
						ch=string.substring(i,i+1);
						break;
					case "=":		//优先级相等则脱括号
						operator.pop();
						i++;
						ch=string.substring(i,i+1);
						break;
					case ">":
						String operator1=operator.pop();
						String operand2=operand.pop();		//弹出两个操作数和一个操作符进行计算
						String operand1=operand.pop();		//注:一定是先入栈的数对后入栈的数进行计算,如进行减法,那就是operand1-operand2
						String str=operate(operand1,operand2,operator1);
						operand.push(str);
				}//switch
			}//if(Character.isDigit(ch.charAt(0)))
			str4=operator.getTops();
		}//while
	}
	
	private String operate(String operand1,String operand2,String operator1) {//返回两个操作数的结算结果
		double x=Double.valueOf(operand1);
		double y=Double.valueOf(operand2);
		double temp=0;
		switch(operator1){
		case "+":
			temp=x+y;
			break;
		case "-":
			temp=x-y;
			break;
		case "*":
			temp=x*y;			
			break;
		case "/":
			temp=x/y;
			break;
		}
		return String.valueOf(temp);
	}
	
	private String preproccessing(String reply) {//预处理,使"-("转换成"-1*("的形式
		String string="";
		String ch1="";
		String ch2="";
		String ch3="";
		for(int i=0;i<reply.length();i++) {
			ch1=reply.substring(i,i+1);
			ch2="next";
			ch3="before";
			if(i<reply.length()-1)
				ch2=reply.substring(i+1, i+2);//ch1后一字符
			if(i>0)
				ch3=reply.substring(i-1, i);//ch1前一字符
			if(ch1.equals("-")&&ch2.equals("("))
				string=string+ch1+"1"+"*";
			else
				string+=ch1;
		}
		return string;
	}
	
	private String suppelmentDecimals(String reply) {//处理不完整小数
		String string="";
		String ch1="";
		String ch2="";
		String ch3="";
		for(int i=0;i<reply.length();i++) {
			ch1=reply.substring(i,i+1);
			ch2="next";
			ch3="before";
			if(i<reply.length()-1)
				ch2=reply.substring(i+1, i+2);//ch1后一字符
			if(i>0)
				ch3=reply.substring(i-1, i);//ch1前一字符
		    if(ch1.equals(".")) {
				if(!Character.isDigit(ch3.charAt(0))&&Character.isDigit(ch2.charAt(0)))
					string+="0"+ch1;
				else if(!Character.isDigit(ch3.charAt(0))&&!Character.isDigit(ch2.charAt(0)))
					string+="0";
				else if(!Character.isDigit(ch2.charAt(0)))
					continue;
				else
					string+=ch1;
			}
			else
				string+=ch1;
		}
		return string;
	}
	
}
