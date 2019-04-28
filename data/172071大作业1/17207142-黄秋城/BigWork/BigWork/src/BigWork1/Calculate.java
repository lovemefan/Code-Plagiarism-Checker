package BigWork1;

public class Calculate//计算后缀式
{
	StackInt stack;//处理计算所需要用到的栈
	String[] str;//需要计算的运算式
	double result;//计算结果
	
	public Calculate(StackInt stack,String[] str) {//初始化构造
		this.stack=stack;
		this.str=str;
		this.result=0;
	}
	
	public void Operation(String[] str) {
		int n=str.length;
		for(int i=0;i<n-2;i++) {
			String s=str[i];
			
			if(s.matches("[0-9].*")) {//如果是数字就进栈
				stack.push((Double.valueOf(s)));
			}
			
			else if(s.equals("+")) {//如果是加号
				double top1 = stack.pop();
				double top2 = stack.pop();//两个数字出栈
				result=top2+top1;
				stack.push(result);
			}
			
			else if(s.equals("-")) {
				double top1 = stack.pop();
				double top2 = stack.pop();//两个数字出栈
				result=top2-top1;
				stack.push((double)result);
			}
			
			else if(s.equals("*")) {
				double top1 = stack.pop();
				double top2 = stack.pop();//两个数字出栈
				result=top2*top1;
				stack.push(result);
			}
			
			else if(s.equals("/")) {
				double top1 = stack.pop();
				double top2 = stack.pop();//两个数字出栈
				result=top2/top1;
				stack.push(result);
			}
		}
	}
}
	



