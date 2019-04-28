package Extra_1_Refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperationArray {
	final int LENGTH = 1001;
	int []stackNum = new int [LENGTH];
	
	char []stackOp = new char [LENGTH];
	String []list = new String[LENGTH];
	String []opStack = new String [LENGTH];

	OperationArray(){
		for (int i=0;i<LENGTH;i++){
			list[i] = null;	
		}
	}
	String goIntoStack(String input){
		Priority C1 = new Priority();
		PopAndPush C2=new PopAndPush();
		String infix = input ;
		String result = "" ;
		//String []list = new String[LENGTH];
		//String []opStack = new String [LENGTH];
		int m=0;//m是list栈顶的上一位
		int n=0;//n是opStack栈顶的上一位
		char chArr[] = new char [LENGTH];
		chArr = ("("+input+")").toCharArray();
        char ch = chArr[0];
        String str = "";
        int len = 0;
		for (int i = 0; i < chArr.length; i++) {
			
			ch = chArr[i];
			if(Character.isDigit(ch)) {//如果当前变量为 数字  
                len++;					//长度加一
                //System.out.println("len = "+len);
            }
			if ((ch=='/')||(ch=='*')||(ch=='+')||(ch=='-')||(ch=='(')||(ch==')')){
            	for (int j=i-len ;j<i;j++){//把分离的数字放入list中
            	str=str+chArr[j];
            	}
            	if (str!=""){
				list[m] = str;
				str="";
				m++;
				len=0;
            	}
				
				//把符号放入list中
				if ((ch=='(')){
				opStack[n]=String.valueOf('(');
				n++;
				
				}
				if ((ch=='/')||(ch=='*')||(ch=='+')||(ch=='-')){//是+-*/的情况
					if (opStack[n-1]=="("){//下一个是（ 就进
						opStack[n] = String.valueOf(ch);
						n++;
					}else if (C1.pri(ch)>C1.pri(opStack[n-1].charAt(0))){//要进栈的运算符的优先级如果大于栈顶,则入栈
						opStack[n] = String.valueOf(ch);
						n++;
						
					}
					else{//要进栈的运算符的优先级如果小于等于栈顶，则弹出栈顶到list直到（空或有更小优先级的运算符）,并将运算符入栈;
						//运算符入栈
						for (;;){
						if ((C1.pri(opStack[n-1].charAt(0))>=C1.pri(ch))){
							list[m] = opStack[n-1];//opStack栈顶到list
							C2.pop(opStack,n-1);//弹出栈顶
							n--;
							m++;
						}else{
							if ((opStack[0]==null)||((C1.pri(opStack[n-1].charAt(0))<C1.pri(ch)))){
								opStack[n] = String.valueOf(ch);
								n++;
								break;////运算符入栈后退出循环
							}
						}
						}
						
					}
				}
				
			}
			if (ch==')'){//是)的情况
				for (;;){
				if (!opStack[n-1].equals("(")){
				list[m] = opStack[n-1];//opStack栈顶到list
				C2.pop(opStack,n-1);//弹出栈顶
				n--;
				m++;
				}else{
					break;
				}
				}//删除（
				C2.pop(opStack,n-1);
				n--;
			}
		}
		int pin = 0;
		for (pin = 0; (pin < list.length)&&(list[pin]!=null); pin++) {
			result= result+list[pin];
			//System.out.print(list[pin]+",");
			//System.out.println(opStack[pin]+"");
		}
		list[pin] = "";
		//System.out.print("\n");
		return result;
	}

	
	
	
	void showAll(){
		for (int pin = 0; (pin < list.length)&&(list[pin]!=null); pin++) {
			System.out.print(list[pin]+",");
			System.out.println(opStack[pin]+"");
		}

	}
}
	class stack {
		int num = 0;
		char op = 0;
		Boolean isEnd = true;
		stack(){
			this.num = 0;
			this.op = 0;
			this.isEnd = true;
		}
}