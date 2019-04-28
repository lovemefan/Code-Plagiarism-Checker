package test6;

/*对表达式进行预处理
例如 infix：(5+6)*78
得到 result ：( 5 + 6 ) * 78
*/
public class ProcessInfix {
	String result = "";
	public ProcessInfix(){
		
	}
	
	//构造方法
	public ProcessInfix(String infix){
		processInfix(infix);
	}
	
	//处理表达式加空格
	private void processInfix(String infix){
		String temp = "";
		for(int i = 0; i < infix.length()-1; i++){
			char temp1 = infix.charAt(i);
			char temp2 = infix.charAt(i + 1);
						//判断是不是大于9的数字
			if(isNumber(temp1) && isNumber(temp2)){
				result += temp1;
			}
			//判断是不是复数
			else if(temp1 == '(' && temp2 == '-' && isNumber(infix.charAt(i + 2))){
				result += temp1 + " " + '0' + " ";
			}
			else{
				result += temp1 + " ";
			}
		}
		if (infix.charAt(0) == '-'){
			 temp = '0' + " ";
			 result = temp + result;
		 }
		result += infix.charAt(infix.length() - 1);
	}
	
	//判断数
	private boolean isNumber(char ch) {
		if(ch >= '0' && ch <= '9'){
			return true;
		}
		else
			return false;
	}
	
	//获得处理好了的表达式
	public String getProcessInfix(){	
		System.out.println(result);
		return result;
	}
}
