
public class Expression {
	public static String getExpression(char[] s) {
		ArrStack as = new ArrStack();
		// 创建字符串存储后缀表达式
		String arr = "";
		for (int i = 0; i < s.length; i++) {
			// 如果是数字或者.直接放入字符串中
			if (ArrStack.isNumber(s[i])) {
				arr = arr + s[i];
				arr = arr + " ";
			} else
				switch (s[i]) {
				case '(':
					as.stackPush(s[i]);
					break;
				case ')':
					char r = as.stackPop();
					while (r != '(') {
						arr = arr + r + " ";
						r = as.stackPop();
					}
					break;
				default:
					deal1(s, arr, i, as);
					break;
				}
		}
		// 将栈中剩余的元素依次存入字符串中
		while (!as.isEmpty()) {
			char r = as.stackPop();
			arr = arr + r + " ";
		}
		return arr;
	}

	public static void deal1(char[] s, String arr, int i, ArrStack as) {
		// 如果是= -则判断栈顶元素是否为 * / 如果是,先将栈顶元素出栈后再入栈 否则,直接入栈
		if (s[i] == '+' || s[i] == '-') {
			if (!as.isEmpty()) { // 判断栈是否为空
				char r = as.getTop();
				while (r == '+' || r == '-' || r == '*' || r == '/') {
					r = as.stackPop();
					arr = arr + r + " ";
					// 如果栈为空,则直接跳出循环
					if (!as.isEmpty()) {
						r = as.getTop();
					} else {
						break;
					}
				}
			}
			as.stackPush(s[i]);
		} else {
			as.stackPush(s[i]);
		}
	}
}
