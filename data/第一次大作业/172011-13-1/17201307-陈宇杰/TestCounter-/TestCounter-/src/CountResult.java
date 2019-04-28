
import java.util.regex.*;
public class CountResult {
	
	public  double counte(String[] temp,int n){
		MyStack stack = new MyStack();	
		double numtop = 0;
		double numtop_ = 0;
		double sum = 0;
		double sum1 = 0;
		for (int i = 0; i < n; i++) {
			// 是数字，进栈
			
			if( !temp[i].equals("")&&!temp[i].equals("+") && !temp[i].equals("-") && !temp[i].equals("*") && !temp[i].equals("/")){
				stack.push(temp[i]);
			}
			else {// 操作符，进行运算处理
				if(stack.getTop()>= 1){
				numtop = Double.parseDouble(stack.pop());
				numtop_ = Double.parseDouble(stack.pop());
				sum = count(numtop, numtop_, temp[i]);
				stack.push(String.valueOf(sum));
				}
			}
			
		}
		if(!stack.isEmpty()){
			 sum1 = Double.parseDouble(stack.pop());
		}
		return sum1;
	}


	public  double count(double a, double b, String c) {// 计算方法
		double result = 0;
			
		if (c.equals("+")) 
			result = a + b;
		
		if (c.equals("-")) 
			result = b - a;
		if (c.equals("*")) 
			result = a * b;
	 	if (c.equals("/")) 
			result = b / a;
		
		return result;
	}

}