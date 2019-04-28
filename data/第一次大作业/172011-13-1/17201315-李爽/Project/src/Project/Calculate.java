package Project;

public class Calculate {
	//构造方法
	public  Calculate(){
		
	}
	
	// 计算结果
	public double calResult(String post) {
		Stack stack = new Stack();// 数字栈
		String culExp[] = post.split(" ");// 把后缀表达式的内容放入culExp里
		int length = culExp.length;// 字符串长度
		for (int i = 0; i < length; i++) {
			culExp[i].trim();
			if (culExp[i].equalsIgnoreCase("+") || culExp[i].equalsIgnoreCase("-") || culExp[i].equalsIgnoreCase("*")
					|| culExp[i].equalsIgnoreCase("/")) {
				double a;
				double result;
				double b;
				switch (culExp[i]) {
				case "+":
					b = Double.parseDouble(stack.pop());
					a = Double.parseDouble(stack.pop());
					result = a + b;
					stack.push(String.valueOf(result));
					break;
				case "-":
					b = Double.parseDouble(stack.pop());
					a = Double.parseDouble(stack.pop());
					result = a - b;
					stack.push(String.valueOf(result));
					break;
				case "*":
					b = Double.parseDouble(stack.pop());
					a = Double.parseDouble(stack.pop());
					result = a * b;
					stack.push(String.valueOf(result));
					break;
				case "/":
					b = Double.parseDouble(stack.pop());
					a = Double.parseDouble(stack.pop());
					result = a / b;
					stack.push(String.valueOf(result));
					break;
				}
			} else {
				stack.push(culExp[i]);
			}
		}
		return Double.parseDouble(stack.pop());
	}
	
}
