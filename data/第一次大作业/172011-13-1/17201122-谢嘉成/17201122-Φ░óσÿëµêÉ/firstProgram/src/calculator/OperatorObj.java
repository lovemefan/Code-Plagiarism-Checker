package calculator;

/*
 * 运算符对象
 */
public class OperatorObj {

	private String operatorStr;
	/*
	 * 优先级
	 */
	private int priorityLevel;// 优先级

	public OperatorObj(String operatorStr) {
		this.operatorStr = operatorStr;
		switch (operatorStr) {
		case "(":
			this.priorityLevel = 0;
			break;
		case ")":
			this.priorityLevel = 0;
			break;
		case "+":
			this.priorityLevel = 1;
			break;
		case "-":
			this.priorityLevel = 1;
			break;
		case "*":
			this.priorityLevel = 2;
			break;
		case "/":
			this.priorityLevel = 2;
			break;
		default:
			break;
		}
	}

	public String getOperatorStr() {
		return operatorStr;
	}

	/*
	 * 判断是否是运算符
	 */
	public static boolean isOperatorObj(String input) {
		return "+-*/()".indexOf(input) >= 0;
	}

	public int getPriorityLevel() {
		return priorityLevel;//返回优先级
	}

}
