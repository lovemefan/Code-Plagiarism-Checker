import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Operate {
	ArrayDeque<Double> stack = new ArrayDeque<Double> ();
	private String[] input;//输入进来的后缀表达式 
	private String store = " ";//操作后的表达式
	public String Error = "";//输入的错误信息
	public String Result = "";//计算后的结果
	public Operate(){
		
	}
	
	//判断是否为数字
	public boolean isDigit(String input){
		char[] charArr = input.toCharArray();
		int len = charArr.length;
		int temp = 0;
		if(len == 0){
			return false;
		}
		for(int i = 0;i < len;i ++){
			if(charArr[i] <= '9' && charArr[i] >= '0'){
				temp ++;
			}
		}
		return temp == len;
	}
	
	//对后缀表达式进行计算
	public void Last(String input){
		String[] strArr = input.split(" ");
		for(int i = 0;i < strArr.length; i ++){
			String str = strArr[i];
			if(str.isEmpty()){
				continue;
			}
			else if (isDigit(str)){
				stack.push(Double.valueOf(str));
			}
			else{
				double sum = operate(str);
				stack.push(sum);
			}
		}
		String end = stack.peek() + "";
		if(end.equals("Infinity")){
			Error = "\r\nERROR\r\n#该表达式除数为零\r\n";
		}
		else{
			Result = stack.pop() + "";
		}
	}
	
	//取栈中的数字计算
	public double operate(String str){
		
		double a = stack.pop();//取出栈顶的第一个数字
		double b = stack.pop();//取出栈顶的第二个数字
		double result = 0;//计算的结果
		switch(str){
		case "+":
			result = b + a;
			break;
		case "-":
			result = b - a;
			break;
		case "*":
			result = b * a;
			break;
		case "/":
			result = b / a;
			break;
		default:
			break;
		}
		return result;
	}
}