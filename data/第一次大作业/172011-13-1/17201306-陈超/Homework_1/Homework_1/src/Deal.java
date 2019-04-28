
//表达式处理类
public class Deal {

	String RPN; // 后缀表达式
	double result; // 表达式所求结果
	String nowResult; // 现在计算的表达式的结果
	Stack stack;	//Stack类
	Regex regex;	//Regex类
	DelSameExpression delSameExpression;	//DelSameExpression类

	// 构造方法
	public Deal() {
		RPN = "";
		result = 0.0;
		nowResult = "";
		stack = new Stack();
		delSameExpression = new DelSameExpression();
	}

	// 处理方法，参数是表达式和最终结果
	public String dealExpression(String expression, String allResult) throws Exception {
		regex = new Regex(expression);
		// 对表达式进行删除空白字符处理
		expression = regex.cancelSpace();
		// 如果表达式不为空
		if (!expression.equals("")) {
			// 进行正负号情况的处理
			expression = expression.replace("(-", "(0-");
			expression = expression.replace("(+", "(0+");
			expression = subOrAddStartExpression(expression);
			delSameExpression.delSE(expression);
			// 如果表达式正确
			if (delSameExpression.deleteSame()) {
				allResult += "";
			} else if (regex.judgeAll()) {
				// 获得后缀表达式
				RPN = stack.RPN(expression);
				// 由后缀表达式运算
				result = stack.calculateResult(RPN);
				// System.out.println(RPN);
				// System.out.println(result);
				// 将得到的结果给最终结果
				nowResult = expression + "=" + result + "\r\n";
				allResult += nowResult;
			} else {
				// 如果表达式错误,录入错误信息
				allResult += expression + "\r\n";
				allResult += "Error\r\n" + regex.getErrorMessage();
			}
		} else {
			// 如果表达式是空的，录入表达式为空信息
			allResult = allResult + "ERROR\n" + "#表达式是空的\r\n";
		}
		return allResult;
	}

	// 对表达式开头为正负号的处理
	public String subOrAddStartExpression(String expression) {
		if (expression.charAt(0) == '-' || expression.charAt(0) == '+') {
			expression = '0' + expression;
		}
		return expression;
	}
}
