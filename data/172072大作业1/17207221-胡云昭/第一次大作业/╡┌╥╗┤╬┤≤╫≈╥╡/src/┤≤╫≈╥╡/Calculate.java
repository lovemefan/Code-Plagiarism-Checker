package 大作业;

public class Calculate {

	private LinkStack1 stack1;//需要的栈
	private String string;//计算之前表达式
	private int nowLucky;//运算结果

	//创建表达式和栈的构造方法
	public Calculate(String string, LinkStack1 stack1) {
		this.string = string;
		this.stack1 = stack1;
	}

	//进栈
	public void process() {

		String[] arr = string.split(" ");
		for (int i = 0; i < arr.length; i++) {
			String temp = arr[i];

			if (temp.matches("[0-9].*"))
				stack1.push(Integer.valueOf(temp));
			else
				stack1.push(result(temp));

		}
		nowLucky = stack1.pop();

	}
    
	//运算
	public int result(String temp) {
		int x = 0;
		int n1 = stack1.pop();
		int n2 = stack1.pop();
		switch (temp) {
		case "+":
			x = n2 + n1;
			break;
		case "-":
			x = n2 - n1;
			break;
		case "*":
			x = n2 * n1;
			break;
		case "/":
			x = n2 / n1;
			break;
		}
		return x;
	}
   
	//得到结果
	public int getResult() {
		return nowLucky;
	}

}
