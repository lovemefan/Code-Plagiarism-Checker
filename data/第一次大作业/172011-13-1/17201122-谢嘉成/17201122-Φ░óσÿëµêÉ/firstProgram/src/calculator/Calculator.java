package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 计算器

public class Calculator {
	private String expressionStr;// 输入表达式

	public Calculator(String expressionStr) {
		this.expressionStr = expressionStr;
	}

	// 计算结果

	public String calculate() {
		String message = validateExpression(expressionStr);
		if (message != null && !"".equals(message)) {
			return message;// 表达式不合法
		}
		List opElement = getObject(expressionStr);

		List houzhuiElement = covertOpElementToHouZhuiElement(opElement);
		// printList(houzhuiElement);

		Double result = calculateHouzhuiElement(houzhuiElement);
		return String.valueOf(result);
	}


	/*
	 * 计算后缀表达式 从左到右遍历表达式的每个数字和符号 遇到是数字就进栈 遇到是符号就将处于栈顶两个数字出栈，进行运算，运算结果进栈
	 * 一直到最终获得结果
	 * 
	 */
	private static Double calculateHouzhuiElement(List houzhuiElement) {
		Stack stack = new Stack();
		for (Object element : houzhuiElement) {
			if (element instanceof NumberObj) {
				NumberObj numObj = (NumberObj) element;
				stack.push(Double.valueOf(numObj.getNumberValue()));
				continue;
			}

			if (element instanceof OperatorObj) {
				OperatorObj opObj = (OperatorObj) element;
				String operatorStr = opObj.getOperatorStr();
				Double value1 = (Double) stack.pop();
				Double value2 = (Double) stack.pop();
				switch (operatorStr) {
				case "+":
					stack.push(value2 + value1);
					break;
				case "-":
					stack.push(value2 - value1);
					break;
				case "*":
					stack.push(value2 * value1);
					break;
				case "/":
					stack.push(value2 / value1);
					break;
				default:
					break;
				}
			}
		}
		// 计算结果（已知他是Double类型的）
		return (Double) stack.peek();
	}

	private void printList(List opElement) {
		System.out.print(expressionStr + "=");
		for (Object el : opElement) {
			if (el instanceof OperatorObj) {
				OperatorObj opObj = (OperatorObj) el;
				System.out.print(opObj.getOperatorStr() + " ");
			} else if (el instanceof NumberObj) {
				NumberObj numObj = (NumberObj) el;
				System.out.print(numObj.getNumberValue() + " ");
			}
		}
	}

	/*
	 * 将中缀运算元素转换为后缀运算 1.遇到操作数：直接输出（添加到后缀表达式中） 2.栈为空时，遇到运算符，直接入栈 3.遇到左括号：将其入栈
	 * 4.遇到右括号：执行出栈操作，并将出栈的元素输出，直到弹出栈的是左括号，左括号不输出。
	 * 5.遇到其他运算符：加减乘除：弹出所有优先级大于或者等于该运算符的栈顶元素，然后将该运算符入栈 6.最终将栈中的元素依次出栈，输出。
	 */
	private static List covertOpElementToHouZhuiElement(List opElement) {

		Stack stack = new Stack();
		List houZhuiList = new ArrayList();

		for (Object element : opElement) {
			if (element instanceof NumberObj) {// 操作数
				houZhuiList.add(element);
				continue;
			}

			if (element instanceof OperatorObj) {// 运算符
				OperatorObj currentOpObj = (OperatorObj) element;
				if (stack.isEmpty()) {// 栈为空时，遇到运算符，直接入栈
					stack.push(currentOpObj);
					continue;
				}
				if ("(".equals(currentOpObj.getOperatorStr())) {// 遇到左括号：将其入栈
					stack.push(currentOpObj);
					continue;
				}
				if (")".equals(currentOpObj.getOperatorStr())) {// 遇到右括号：执行出栈操作，并将出栈的元素输出，直到弹出栈的是左括号，左括号不输出。
					while (true) {
						OperatorObj op = (OperatorObj) stack.pop();
						if (!"(".equals(op.getOperatorStr())) {
							houZhuiList.add(op);
						} else {
							break;
						}
					}
					continue;
				}

				if ("+".equals(currentOpObj.getOperatorStr()) || "-".equals(currentOpObj.getOperatorStr())
						|| "*".equals(currentOpObj.getOperatorStr()) || "/".equals(currentOpObj.getOperatorStr())) {// 加减乘除：弹出所有优先级大于或者等于该运算符的栈顶元素，然后将该运算符入栈
					while (true) {
						// 栈顶元素
						OperatorObj obj = null;
						if (!stack.isEmpty()) {
							obj = (OperatorObj) stack.peek();
						}

						if (obj == null || "(".equals(currentOpObj.getOperatorStr())// 当循环至栈顶元素为"("符号时，将当前符号元素入栈，停止循环
								|| currentOpObj.getPriorityLevel() > obj.getPriorityLevel()) { // 当栈顶优先级小于当前优先级时
							// 入栈
							stack.push(currentOpObj);
							break;
						} else { // 当栈顶优先级大于当前优先级时 出栈
							houZhuiList.add(stack.pop());
						}
					}
					continue;
				}
			}
		}
		while (!stack.isEmpty()) {
			houZhuiList.add(stack.pop());
		}
		return houZhuiList;
	}

	
	/*
	 * 校验计算的表达式是否合法
	 */
	private String validateExpression(String expressionStr) {
		if (expressionStr == null || expressionStr.length() == 0) {
			return null;
		}

		String lengthLower5 = lengthLower5(expressionStr);
		if(null!=lengthLower5){
			return lengthLower5;
		}
		
		

		// 如果第一个是符号则必须是-号 括号
		String validateFirstChar =validateFirstChar(expressionStr);
		if(null!=validateFirstChar){
			return validateFirstChar;
		}

		String isHeFa = isHeFa(expressionStr);
		if(null!=isHeFa){
			return isHeFa;
		}
		
		String validateFuHaoLianXu = validateFuHaoLianXu(expressionStr);
		if(null!=validateFuHaoLianXu){
			return validateFuHaoLianXu;
		}

		String validationKuoHaoCount = validationKuoHaoCount(expressionStr);
		if(null!=validationKuoHaoCount){
			return validationKuoHaoCount;
		}
		return null;
	}

	private String validateFuHaoLianXu(String expressionStr) {
		for (int i = 0; i < expressionStr.length(); i++) {
			char currentChar = expressionStr.charAt(i);
			Character lastChar = null;
			Character lastLastChar = null;
			if (i - 1 >= 0) {
				lastChar = expressionStr.charAt(i - 1);
			}
			if (i - 2 >= 0) {
				lastLastChar = expressionStr.charAt(i - 2);
			}
			boolean ccIsJJCCKK = MyUtils.isJJCCKK(currentChar);
			

			String lianxuFuhao = lianxuFuhao(currentChar, lastChar, lastLastChar, ccIsJJCCKK);
			if(null!=lianxuFuhao){
				return lianxuFuhao;
			}
		}
		return null;
	}

	private String lianxuFuhao(char currentChar, Character lastChar, Character lastLastChar, boolean ccIsJJCCKK) {
		if(lastChar!=null&&ccIsJJCCKK&&MyUtils.isJJCCKK(lastChar)){
			if (currentChar != '-') {
				return "存在连续两个符号时，第二个符号必须时减号";
			}
			
			if(lastChar == '+' || lastChar == '-'){
				return "存在连续两个符号且第二个符号为减号时第一个符号不能是加号或者减号";
			}
			
			if(lastLastChar!=null&&MyUtils.isJJCCKK(lastLastChar)){
				return "存在连续两个符号且第二个符号为减号时第一个符号不能是加号或者减号";
			}
		}
		return null;
	}

	private String validateFirstChar(String expressionStr) {
		char firstChar = expressionStr.charAt(0);
		if (MyUtils.isJJCCKK(firstChar)&&('-'!=firstChar||'('!=firstChar)) {
			return "如果第一个是符号则必须是负号或者左括号";
		}
		return null;
	}

	private String isHeFa(String expressionStr) {
		for (int i = 0; i < expressionStr.length(); i++) {
			char currentChar = expressionStr.charAt(i);
			// 所有数字只能是0-9 +-*/()
			if (!MyUtils.isYSFF(currentChar)) {
				return "所有字符只能是0到9或者 是\"+\",\"-\",\"*\",\"/\",\"（\",\"）\"";
			}
		}
		return null;
	}

	private String validationKuoHaoCount(String expressionStr) {
		if (expressionStr.indexOf('(') >= 0 || expressionStr.indexOf(')') >= 0) {
			if (expressionStr.indexOf('(') > expressionStr.indexOf(')')) {
				return "存在括号时，必须是先有左括号，再有右括号";
			}
			String str = expressionStr.replace("(", "");
			String str2 = expressionStr.replace(")", "");
			if ((expressionStr.length() - str.length()) != (expressionStr.length() - str2.length())) {
				return "存在括号时，左括号的总数必须等于右括号的总数";
			}
		}
		return null;
	}

	private String lengthLower5(String expressionStr) {
		// 长度小于3个字符无法计算
		if (expressionStr.length() < 3) {
			return "长度小于3个字符无法计算";
		}

		// 长度等于3时中间符号必须加减乘除符号
		String lengthEq3 = lengthEq3(expressionStr);
		if(null!=lengthEq3){
			return lengthEq3;
		}

		// 长度等于4时中间两个元素至少有一个是加减乘除符号
		String lengthEq4 = lengthEq4(expressionStr);
		if(null!=lengthEq4){
			return lengthEq4;
		}

		// 长度等于5时中间三个元素至少有一个是加减乘除符号
		String lengthEq5 = lengthEq5(expressionStr);
		if(null!=lengthEq5){
			return lengthEq5;
		}
		return null;
	}

	private String lengthEq5(String expressionStr) {
		if (expressionStr.length() == 5 && MyUtils.isKHFF(expressionStr.charAt(1))
				&& MyUtils.isKHFF(expressionStr.charAt(2)) && MyUtils.isKHFF(expressionStr.charAt(3))) {
			return "长度等于5时中间三个元素至少有一个是加减乘除符号";
		}
		return null;
	}

	private String lengthEq4(String expressionStr) {
		if (expressionStr.length() == 4 && MyUtils.isKHFF(expressionStr.charAt(1))
				&& MyUtils.isKHFF(expressionStr.charAt(2))) {
			return "长度等于4时中间两个元素至少有一个是加减乘除符号";
		}
		return null;
	}

	private String lengthEq3(String expressionStr) {
		if (expressionStr.length() == 3 && MyUtils.isKHFF(expressionStr.charAt(1))) {
			return "长度等于3时中间符号必须加减乘除符号";
		}
		return null;
	}

	/*
	 * 将计算的表达式转换为单独的元素放入集合中 （支持最大两位数的整数计算，包含负数） +-符号后的负数必须用括号包裹 *%后的负数不必须
	 */
	private static List getObject(String expressionStr) {

		List result = new ArrayList();
		// 当前字符
		String currentStr = null;
		// 上一字符
		String lastStr = null;
		// 上上一字符
		String lastLastStr = null;
		// 如果表达式第一个数字为负数则在表达式前添加0
		if (expressionStr.startsWith("-")) {
			expressionStr = "0" + expressionStr;
		}
		for (int i = 0; i < expressionStr.length(); i++) {
			currentStr = String.valueOf(expressionStr.charAt(i));
			if(OperatorObj.isOperatorObj(currentStr)){
				result.add(new OperatorObj(currentStr));
				continue;
			}
			if(i==0){
				result.add(new NumberObj(currentStr));
				continue;
			}
			if(i-1>-1){
				lastStr = String.valueOf(expressionStr.charAt(i - 1));
			}
			if(i-2>-1){
				lastLastStr = String.valueOf(expressionStr.charAt(i - 2));
			} 
			// 上一字符为符号
			lastElementIsFuHao(result, currentStr, lastStr, lastLastStr);
			lastStr = null;
			lastLastStr = null;
		}
		return result;
	}

	private static void lastElementIsFuHao(List result, String currentStr, String lastStr, String lastLastStr) {
		if (null != lastStr && OperatorObj.isOperatorObj(lastStr)) {
			// 上一字符为 负号，且上上字符为 乘号或者除号或者“（”
			if (null != lastLastStr && "-".equals(lastStr)
					&& (OperatorObj.isOperatorObj(lastLastStr) && ("*/(").indexOf(lastLastStr) >= 0)) {
				// 覆盖上一个元素
				result.set(result.size() - 1, new NumberObj("-" + currentStr));
			} else {
				result.add(new NumberObj(currentStr));
			}
		} else {// 上一字符为数字
				// 覆盖上一个元素 = 上一元素的值 + 当前数字（考虑到上一元素有可能为负数）
			NumberObj no = (NumberObj) result.get(result.size() - 1);// 上一个元素
			result.set(result.size() - 1, new NumberObj(no.getNumberValue() + currentStr));
		}
	}

}
