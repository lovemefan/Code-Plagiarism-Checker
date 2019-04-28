package Call;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//该类为计算主方法里传来的正确表达式
public class ExperssionEvaluator {
	// 该方法为参数operator确认是否是符合要求的符号
	private static int getOperatorIndex(String operator) {
		String[] operators = { "+", "-", "*", "/", "(", ")", "#" };// 匹配数组里的限定符号
		for (int i = 0; i < operators.length; i++) {
			if (operator.equalsIgnoreCase(operators[i])) {
				return i;// 若有，返回非零
			}
		}
		return -1;// 没有返回-1
	}

	// 启动getOperatorIndex(c)方法并且将返回值给调用的方法
	private static boolean isOperator(String c) {
		int index = getOperatorIndex(c);
		if (index == -1) {
			return false;
		} else {
			return true;
		}
	}

	// 比较两个操作符的计算优先顺序，并且返回比较以后的优先级顺序
	private static String priority(String operatorA, String operatorB) {
		String[][] priorityMatrix = { { ">", ">", "<", "<", "<", ">", ">" }, { ">", ">", "<", "<", "<", ">", ">" },
				{ ">", ">", ">", ">", "<", ">", ">" }, { ">", ">", ">", ">", "<", ">", ">" },
				{ "<", "<", "<", "<", "<", "=", "" }, { ">", ">", ">", ">", "", ">", ">" },
				{ "<", "<", "<", "<", "<", "", "=" } };
		return priorityMatrix[getOperatorIndex(operatorA)][getOperatorIndex(operatorB)];
	}

	// 调整为后缀表达式
	public static String[] splitExpression(String experssion) {
		List<String> units = new ArrayList<String>();
		units.add("#");// 为方便判别表达式结束，在表达式的最前最后增加起始符号#，栈初始化时设置操作数栈为空，运算符栈的栈顶元素为表达式起始符号#,表示计算即将开始
		String unit = "";
		Pattern p = Pattern.compile("\\d+(\\.\\d+)*");// 正则表达式判断，调整为后缀式
		Matcher m = p.matcher(experssion);
		int i = 0;
		while (i < experssion.length()) {
			if (isOperator(String.valueOf(experssion.charAt(i)))) {
				units.add(String.valueOf(experssion.charAt(i)));
				i++;
			} else {
				if (m.find()) {
					units.add(m.group());
					i = i + m.group().length();
				}
			}
		}
		units.add("#");// 最后加起始符
		String[] u = new String[units.size()];
		units.toArray(u);
		return u;// 返回后缀式
	}

	// 计算后缀表达式，返回中间结果或者最终结果
	public static String calculate(String leftOperand, String operand, String rightOperand) {
		double left = Double.parseDouble(leftOperand);
		double right = Double.parseDouble(rightOperand);
		double result = 0;
		switch (operand) {
		case "+":
			result = left + right;
			break;
		case "-":
			result = left - right;
			break;
		case "*":
			result = left * right;
			break;
		case "/":
			result = left / right;
			break;
		}
		return String.valueOf(result);
	}

	// 主方法的连接窗口
	public static double evaluate(String experssion) {
		String result = null;// 表达式结果存放处
		StackLinlesNode<String> operatorStack = new StackLinlesNode<String>();// 操作符表达式
		StackLinlesNode<String> operandStack = new StackLinlesNode<String>();// 操作数表达式
		String[] units = splitExpression(experssion);// 调用splitExpression（）方法，将传入的expression改为标准后缀式
		int unitIndex = 1;
		operatorStack.push(units[0]);// 表达式的操作符入栈
		String u = units[unitIndex];//
		// 依次入栈，若操作字符或者最后一个字符为#，说明读取完全，退出循环
		while ((!u.equalsIgnoreCase("#")) || !(operatorStack.getTop().equalsIgnoreCase("#"))) {
			if (isOperator(u)) {// 判断是否是操作符号
				String priority = priority(operatorStack.getTop(), u);// 比较运算符栈栈顶元素与该读取到的算符比较优先级，返回值为boolean
				switch (priority) {
				case "<":// 栈顶算符优先级小于待处理运算符优先级：压入运算符栈
					operatorStack.push(u);
					unitIndex++;
					break;
				case "=":// 栈顶算符优先级等于待处理运算符优先级：运算符栈出一个运算符与读取到的算符抵消
					operatorStack.pop();
					unitIndex++;
					break;
				case ">":// 栈顶算符优先级大于待处理运算符优先级：运算符栈出一算符，操作数栈出两个操作数，计算，结果压入操作数栈
					String rightOperand = operandStack.getTop();// 得到栈顶元素，左操作数
					operandStack.pop();// 栈顶元素出栈
					String leftOperand = operandStack.getTop();// 得到栈顶元素，右操作数
					operandStack.pop();// 栈顶元素出栈
					String operand = operatorStack.getTop();// 操作符出一个操作符
					operatorStack.pop();// 栈顶元素出栈
					result = calculate(leftOperand, operand, rightOperand);// 调用计算方法
					operandStack.push(result);// 返回中间结果或者最终结果
					break;
				}
			} else {
				operandStack.push(u);// 操作数入栈
				unitIndex++;
			}
			u = units[unitIndex];
		}
		return Double.parseDouble(result);// 最终结果化为浮点型数据返回
	}
}