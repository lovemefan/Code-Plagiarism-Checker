
public class Calculator {
	
	//构造方法
	public Calculator(){
		
	}

	// 中缀转后缀
	// 字符串类型 存储着合法运算式
	public String Change(String src) {
		newStack newstack = new newStack(100);
		String src2 = "";
		int m = 0;
		int n = 0;
		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i);
			switch (ch) {
			case '(':
				newstack.push(ch);
				m = 0;
				n = 1;
				break;
			case ')':
				src2 = gotParen(ch, newstack, src2);
				m = 0;
				n = 0;
				break;
			case '+':
			case '-':
				src2 = gotOper1(ch, newstack, src2, n);
				m = 0;
				break;
			case '*':
			case '/':
				src2 = gotOper2(ch, newstack, src2);
				m = 0;
				n = 0;
				break;
			default:
				n = 0;
				if (m == 0) {
					src2 += " " + ch;
					m = 1;
				} else {
					src2 += ch;
				}
				break;
			}
		}
		while (newstack.size() != 0) {
			src2 += " " + newstack.pop();
		}

		return src2;

	}

	// 中缀转后缀中遇见")"
	// 字符类型 此时需判定的字符 自定义栈类型 后缀表达式所存放的字符串
	public String gotParen(char ch, newStack stack, String src) {
		Character temp;
		while (stack.size() != 0) {
			temp = stack.pop();
			if (temp == '(') {
				break;
			} else{
				src += " " + temp;
			  }
		}
		return src;
	}

	// 中缀转后缀中遇见"+"或"-"
	// 字符类型 此时需判定的字符 自定义栈类型 后缀表达式所存放的字符串
	public String gotOper1(char ch, newStack stack, String src, int n) {
		if (n == 1) {// 当输入负数时 在负数前加个0 如为(-1) 那么转后缀时为 01-
			src = src + " 0";
			n = 0;
		}
		Character temp;
		while (stack.size() != 0) {
			temp = stack.pop();
			if (temp == '(') {
				stack.push('(');
				break;
			}
			src += " " + temp;
		} 
			stack.push(ch);
		return src;
	}

	// 中缀转后缀中遇见"*"或"/"
	// 字符类型 此时需判定的字符 自定义栈类型 后缀表达式所存放的字符串
	public String gotOper2(char ch, newStack stack, String src) {
		Character temp;
		while (stack.size() != 0) {
			temp = stack.pop();
			if (temp == '(' || temp == '+' || temp == '-') {
				stack.push(temp);
				break;
			} else {
				src += " " + temp;
			}
		}
		stack.push(ch);
		return src;
	}

	// 计算结果
	// 字符串类型 后缀表达式
	public String Cal(String src, int flag) {
		src = src.trim();
		src = src + " ";
		newStack stack = new newStack(100);
		char ch;
		String temp = "";
		for (int i = 0; i < src.length(); i++) {
			ch = src.charAt(i);
			if (ch == ' ') {// 空格分隔运算符与数字 所以遇见空格便进行判定一次
				flag = Calculate(temp, stack, flag);
				if (flag != 0) {// 当Calculate(temp, stack,flag)返回值不为0时
									// 说明出现 /0 的情况 属于算式不合法 返回false的值
					String result = "false";
					return result;
				}
				temp = "";
			} else {
				temp = temp + ch;
			}
		}
		return stack.pop2();
	}

	// 在栈中计算
	// 所判定的字符串 栈
	public int Calculate(String temp, newStack stack, int flag) {
		double result = 0;
		double f1, f2;
		switch (temp) {
		case "+":// 如果为"+" 则弹出两次栈顶 并将两者相加 再放入栈中
			f2 = Double.parseDouble(stack.pop2());
			f1 = Double.parseDouble(stack.pop2());
			result = f1 + f2;
			stack.push(result);
			break;
		case "-":// 如果为"-" 则弹出两次栈顶 并将第二次弹出的减去第一次弹出的
			f2 = Double.parseDouble(stack.pop2());
			f1 = Double.parseDouble(stack.pop2());
			result = f1 - f2;
			stack.push(result);
			break;
		case "*":// 如果为"*" 则弹出两次栈顶 并将两者相乘 再放入栈中
			f2 = Double.parseDouble(stack.pop2());
			f1 = Double.parseDouble(stack.pop2());
			result = f1 * f2;
			stack.push(result);
			break;
		case "/":// 如果为"/" 则弹出两次栈顶 并将第二次弹出的处除以第一次弹出的
			f2 = Double.parseDouble(stack.pop2());
			f1 = Double.parseDouble(stack.pop2());
			if (f2 != 0) {// 检验是否出现 /0 的情况 出现则返回false
				result = f1 / f2;
				stack.push(result);
			} else{
				flag = 2;
			  }
			break;
		default:// 如果为数字 则直接压入栈中
			stack.push(temp);
		}
		return flag;
	}

}
