package 大作业01;

/*表达式求值类*/
public class CalculateExpression {

		StackOfChar optr = new StackOfChar();//操作符堆栈
		StackOfIntegers opnd = new StackOfIntegers();//操作数堆栈  
		
		/*判断是否是运算符还是运算数；是运算符比较优先级然后进行相应操作，是数则压入操作数堆栈*/
		public void testExp(String infix) {
			String num = "";//运算数
			
			for(int i=0; i<infix.length(); i++){
				char ch = infix.charAt(i);
				if(Character.isDigit(ch)) {	//如果是运算数
					num = num + ch;	//可接收两位及以上的数
				}else {	//如果是运算符
					if(num != "") {//num不为空则转换为数值压入操作数堆栈
						int intValue = Integer.parseInt(num);
						opnd.push(intValue);
					}
					switch(ch){//比较运算符的优先级进行相应操作
						case '+':
					    case '-':
					    	precede(ch,1);//需要判断优先级，n1：设定的是当前的优先级
					    	num = "";
					        break;
					    case '*':
					    case '/':
					    	precede(ch,2);//需要判断优先级
					    	num = "";
				            break;
					    case '(':
					        optr.push(ch);//左括号优先级最高直接进栈
					        num = "";
					        break;
					    case ')':
					    	rightParentheses();//碰到右边括号涉及出栈
					    	num = "";
					        break;
					    default:
					    	num = "";
					        break;
					}
					
				}		
			}
			if(num != "") {//循环结束，num不为空时
				int intValue = Integer.parseInt(num);
				opnd.push(intValue);
			}
			while(!optr.empty()) {//若栈中还有运算符，进行运算
				int op1 = opnd.pop();
				int op2 = opnd.pop();
				char ch = optr.pop();
				int sum = calculator(op1, ch, op2);
				opnd.push(sum);
			}
		}
		
		/*比较运算符优先级*/
		private void precede(char opThis, int n1) {
			
			while(!optr.empty()){
				char opTop = optr.peek();
				if(opTop == '('){  //如果栈中顶是左边括号就进去跳出循环
					break;
				 }
				else{
					int n2;
					//记录栈中操作符优先级，加减优先级是1乘除优先级是2
					if(opTop == '+' || opTop == '-'){
						n2 = 1;
					}
					else{
						n2 = 2;
					}
					//当前运算符优先级高于栈顶优先级，当前运算符进栈
					if(n2 < n1){
						optr.push(opThis);
						break;
					 }
					//当前运算符优先级低于栈顶优先级，将两个数出栈并计算，再将结果压入操作数堆栈
					 else{
						 	int op1 = opnd.pop();
							int op2 = opnd.pop(); 
							char ch = optr.pop();
							int sum = calculator(op1, ch, op2);
							opnd.push(sum);
					 }
				}
			}
			//栈为空就直接进栈或者遇到左边括号也是直接进栈或者栈存储比栈中优先级小的
			optr.push(opThis);
			
		}
		
		/*当前运算符为右括号时*/
		private void rightParentheses() {
			while(!optr.empty()){
				if(optr.peek() == '(') {//括号相遇，直接出栈
					optr.pop();
					break;
				}
				else {
					int op1 = opnd.pop();
					int op2 = opnd.pop();
					char ch = optr.pop();
					int sum = calculator(op1, ch, op2);
					opnd.push(sum);
				}
			}
		}
		
		
		/*计算*/
		private int calculator(int op1, char ch, int op2) {
			int sum = 0;
			switch(ch) {
				case '+':
					sum = op2 + op1;
					break;
				case '-':
					sum = op2 - op1;
					break;
				case '*':
					sum = op2 * op1;
					break;
				case '/':
					sum = op2 / op1;
					break;
				default:
					break;
			}
			return sum;
		}
		
}

