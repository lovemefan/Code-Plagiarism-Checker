package test6;

public class CountResult {
	private String postCounter; //记录表达式
	Stack stack2 = new Stack();

	// 构造方法
	public CountResult(){

	}

	//对变量进行初始化
	public CountResult(String postCounter) {
		this.postCounter = postCounter;
		OperateCounter();
	}

	// 操作将数字字符串传入压入栈中
	private void OperateCounter() {
		String[] divideCou = postCounter.split(" ");
		for (int i = 0; i < divideCou.length; i++) {
			String flag = divideCou[i];
			if (isNumber(flag) == true) {
				stack2.inputStack(flag);
			} else {
				String result = computeCounter(flag);
				stack2.inputStack(result);
			}
		}
	}

	//对数据进行计算
	private String computeCounter(String flag) {
		float rest = 0;
		String res = "";
		//将字符串型转化成float
		float b = Float.parseFloat(stack2.outputStack());
		float a = Float.parseFloat(stack2.outputStack());
		switch (flag) {
		case "+":
			rest = a + b;
			break;
		case "-":
			rest = a - b;
			break;
		case "*":
			rest = a * b;
			break;
		case "/":
			rest = a / b;
			break;
		default:
			break;
		}
		res = rest + "";
		return res;
	}

	// 判断字符串是不是纯数字
	private boolean isNumber(String flag){
		boolean a = true;
		for (int i = 0; i < flag.length(); i++) {
			if (!(flag.charAt(i) >= '0' && flag.charAt(i) <= '9')) {
				a = false;
				break;
			}
		}
		return a;
	}

	// 获得结果；
	public String getCounterResult() {
		return stack2.outputStack();
	}
}
