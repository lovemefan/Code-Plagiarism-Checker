package assignment_one;

public class TransferExpression {

	public static int index(char a){
			
			switch (a){
				case '+': return 0;
				case '-': return 1;
				case '*': return 2;
				case '/': return 3;
				case '(': return 4;
				case ')': return 5;
				case '#': return 6;
			}
			return -1;
		}
		
		public static char priority(char a,char b){
			char prior[][]=	{	{'>','>','<','<','<','>','>'},
								{'>','>','<','<','<','>','>'},
								{'>','>','>','>','<','>','>'},
								{'>','>','>','>','<','>','>'},
								{'<','<','<','<','<','=',' '},
								{'>','>','>','>',' ','>','>'},
								{'<','<','<','<','<',' ','='}};
			return prior[index(a)][index(b)];	//将优先级返回
		}
		
		public static String transfer( String nifixExpression, String postfixExpression){//将中缀表达式转化为后缀表达式 
			
			int i=0;
			StackOfChar stack = new StackOfChar();//操作符栈 
			nifixExpression = nifixExpression.replaceAll("\\s+","");
			nifixExpression = "#"+nifixExpression+"#"; 
			stack.push(nifixExpression.charAt(i));//将中缀表达式中第一个#压入堆栈 
			i++;
			char c = stack.peek();//获取栈顶元素 
			while(nifixExpression.charAt(i)!='#'||c!='#')
			{
				if(judgedigital ( nifixExpression.charAt(i) ) )
				{
					postfixExpression = postfixExpression + nifixExpression.charAt(i);//若为操作数直接放入后缀表达式顺序表中 
					if(!judgedigital ( nifixExpression.charAt(i+1) ) ){
						postfixExpression = postfixExpression +",";
					}
					i++;
				}
				else{
					c = stack.peek();
					char compare = priority(c,nifixExpression.charAt(i));
					switch(compare)
					{
						case '<':
								stack.push(nifixExpression.charAt(i));//若中缀表达式识别的操作符优先级高，直接压入堆栈 
								i++;//识别下一中缀表达式中的元素 
								break;
						case '=':
								stack.pop();//若两操作符优先级相等，将栈顶元素弹出 
								if(nifixExpression.charAt(i)!='#')//若中缀表达式未识别完继续识别 
									i++;
								break;
						case '>':
								c = stack.pop();//若栈顶操作符优先级高，将栈顶操作符弹出，并放入后缀表达式线性表中 
								postfixExpression = postfixExpression + c ;
								break;
					}//switch 
				}//else 
			}//while 
			while(!stack.isEmpty())
			{
				char temp = stack.pop();
				if( temp != '#'){
					postfixExpression = postfixExpression + temp;
				}
		 	}
			return postfixExpression;
		} 
		
		static boolean judgedigital(char c)//判断c是数字还是其他字符，若为数字，返回1，若为其他字符，返回-1 
		{
			if( c >='0' && c <= '9' )
				return true;
			else
				return false;	
		}

}

