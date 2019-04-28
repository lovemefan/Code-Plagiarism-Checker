package assignment_one;

public class CalculatPostExpression {
	
	public  static int  calculatPostExpression( String postExpression) {
		StackOfChar stack = new StackOfChar();
		for(int i = 0; i < postExpression.length(); i++){
			char present = postExpression.charAt(i);
			if( present == ',' || TransferExpression.judgedigital (present) ){
				stack.push(present);
			}
			else{
				int post = getinteger(stack);
				int ex = getinteger(stack);
				int result = calculate(ex,post,present);
				String sresult = result+"";
				for(int j = 0; j < sresult.length(); j++){
					stack.push(sresult.charAt(j));
				}
				stack.push(',');
			}
		}
		int result = getinteger(stack);
		return result;
	}
	
	public  static int getinteger(StackOfChar stack) {
		String string = "";
		stack.pop();
		while(!stack.isEmpty())
		{
			char top = stack.peek();
			if(TransferExpression.judgedigital(top) || top =='-'){
				char ch = stack.pop();
				string = ch + string; 
			}
			else 
				break;
		}
		return Integer.parseInt(string);
	}
	public static int calculate(int a,int b,char c){
		int result=0;
		switch(c)
		{
			case '+':
				result=a+b;
				break;
			case '-':
				result=a-b;
				break;
			case '*':
				result=a*b;
				break;
			case '/':
				result=a/b;
				break;
		}
		return result;
	}
}
