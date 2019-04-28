package BigWork1;

public class FixTo// 中缀式转换为后缀式
{
	String before = "";//转换之前的中缀表达式
	String after = "";//转换之后的后缀表达式
	Stack stack;//转换所需要的栈

	//构造函数，初始化
	public FixTo(String s, Stack stack){
		this.before = s;
		this.stack = stack;
	}

	//在表达式中加空格以区分连续的两个数字
	public String AddKong(String s){
		String str = "";
		for (int i = 0; i < s.length() - 1; i++){
			char temp1 = s.charAt(i);
			char temp2 = s.charAt(i + 1);
			if (IsDigital(temp1) && IsDigital(temp2)){//如果是连续的两个数字
				str += temp1;
			} 
			else{//如果前面是数字，后面不是数字
				str += temp1 + " ";
			}
		}
		str += s.charAt(s.length() - 1);//最后一个字符
		return str;// 现在是带空格的字符换
	}

	//处理，将字符串转换为后缀表达式
	public void Process(String s){
		String s1 = before.replaceAll(" ", "");// 将传进来的字符串去掉所有空格

		String[] strarr = AddKong(s1).split(" ");// 用空格分割带空格的字符串进入字符串数组

		int n = strarr.length;

		for (int i = 0; i < n; i++){
			switch (strarr[i]){
			case "+":
			case "-":
				PushOrPop(strarr[i], 1);//运算优先级为1
				break;

			case "*":
			case "/":
				PushOrPop(strarr[i], 2);//运算优先级为2
				break;

			case "(":
				stack.push(strarr[i]);//左括号直接进展进栈
				break;

			case ")":
				PopAll();//到左括号之前全部出栈
				stack.pop();//左括号出栈
				break;
			default://数字直接进队
				after += strarr[i];
				after += " ";

			}
		}
		while (!stack.isEmpty()){// 清空栈中运算符
			String top = stack.pop();
			after += top;
			after += " ";
		} 

	}

	//判断是否为数字
	public boolean IsDigital(char a){
		if (a >= '0' && a <= '9')
		{
			return true;
		} else
			return false;
	}

	//对符号进行进栈或出栈处理
	public void PushOrPop(String s, int n){
		if (n == 1){//+或-
			if (stack.isEmpty() || stack.first.data.equals("(")){//空栈或左括号
				stack.push(s);
			} 
			else{//+、-、*、/
				PopAll();//全部出栈
				stack.push(s);// 进栈
			}
		} 
		else if (n == 2){//*或/
			if (stack.first.data.equals("*") || stack.first.data.equals("/")){
				String top = stack.pop();
				after += top;
				after += " ";
				stack.push(s);//进栈
			} 
			else{//+、-、(、空栈
				stack.push(s);
			}
		}

	}

	//到空栈或左括号为止，全部出栈
	public void PopAll(){
		while (!stack.isEmpty()){
			if (stack.first.data.equals("(")){
				break;
			}
			String top = stack.pop();
			after += top;
			after += " ";
		}
	}
}
