//计算后缀表达式
import java.util.Stack;

public class Compute {
	
	Compute(){
		
	}
	
	public static Double compute(String exp){
		//将后缀表达式分割成字符串数组，此处直接使用空白也可以对字符串进行分割
		String[] strings = exp.split(" ");
		Stack<Double> stack = new Stack<Double>();
		for(int i = 0 ; i < strings.length ; i ++){
			if(strings[i].equals("")){
				continue;
			}
			//如果遇到数字则直接进栈
			else if(checkNumber(strings[i])){
				stack.push((double)Integer.valueOf(strings[i]));
			}
			else{
				double y = stack.pop();
				double x = stack.pop();
				//将运算结果重新压栈
				stack.push(calculate(x , y , strings[i]));
			}
		}
		//弹出栈顶元素就是最终结果
		double a1 = stack.pop();
		return a1;
		
	}
	private static Double calculate(double x , double y ,String string){
		if(string.trim().equals("+")){
			return x + y;
		}
		if(string.trim().equals("-")){
			return x - y;
		}
		if(string.trim().equals("*")){
			return x * y;
		}
		if(string.trim().equals("/")){  
			return x / y;
		}
		return (double) 0;
	}
	private static boolean checkNumber(String s){
		if(s.length()<=1&&s.charAt(0)>='0'&&s.charAt(0)<='9'){
			return true;
		}
		else if(s.length()>1&&s.charAt(1)>='0'&&s.charAt(1)<='9'){
			return true;
		}
		return false;
	}

}


