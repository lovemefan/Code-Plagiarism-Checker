import java.util.ArrayList;

// 计算类
public class Calculate {
	// 栈
	Stack stack;
	// 中缀表达式
	ArrayList<String> infix;
	// 后缀表达式
	ArrayList<String> postfix;
	// 表达式的结果
	double num = 0;
	// 校验类的传入
	private Check check;

	public Calculate() {

	}

	// 构造方法
	// 校验类的引用
	public Calculate(Check check) {
		stack = new Stack();
		postfix = new ArrayList<>();
		infix = check.toInfix();
		this.check = check;
		toPostfix();
		compute();
	}

	// 计算后缀表达式的结果
	public void compute() {
		stack = new Stack();
		for (String str : postfix) {
			if (str.matches("[\\+\\-\\*\\/]")) {
				double num2 = Double.valueOf(stack.pop());  //类型转换
				double num1 = Double.valueOf(stack.pop());  //类型转换
				switch (str) {
				case "+":
					num = num1 + num2;
					break;
				case "-":
					num = num1 - num2;
					break;
				case "*":
					num = num1 * num2;
					break;
				case "/":
					// 除数为0的情况
					if (Math.abs(num2) < 1e-8) {
						check.setLegal(false);
						check.setError("除数不能为0");
						return;
					}
					num = num1 / num2;
					break;
				}
				stack.push(String.valueOf(num));
			} else {
				stack.push(str);   //进栈
			}
		}
	}

	// 中缀转后缀
	private void toPostfix() {
		// 遍历中缀表达式
		for (String str : infix) {
			// 优先级低全部出栈再入栈或者遇到左括号结束
			if (str.matches("[\\+\\-]")) {
				while (!stack.isEmpty() && !stack.top().equals("(")) {
					postfix.add(stack.pop());  
				}
				stack.push(str);     //进栈
			} else if (str.matches("[\\*\\/]")) {
				while (!stack.isEmpty() && stack.top().equals("[\\*\\/]")) {
					postfix.add(stack.pop());   
				}
				stack.push(str);   //进栈
			} else if (str.matches("\\(")) {
				stack.push(str);    //进栈
			} else if (str.matches("\\)")) {
				while (!stack.top().matches("\\(")) {
					postfix.add(stack.pop());     
				}
				stack.pop();  //出栈
			} else {
				num = Double.valueOf(str);
				postfix.add(str);
			}
		}
		// 将栈中符号弹出到后缀表达式中
		while (!stack.isEmpty()) {
			postfix.add(stack.pop());
		}
	}

	public ArrayList<String> getPostfix() {
		return postfix;
	}

	public double getNum() {
		return num;
	}
}
