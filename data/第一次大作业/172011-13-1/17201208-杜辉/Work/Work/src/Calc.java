//计算后缀表达式
class Calc {
	String s = ""; // 后缀表达式
	Double[] integer = new Double[1005];// 栈
	Integer len; // 栈的长度

	Calc(String s) {
		this.s = s;
		this.len = 0;

	}

	// 计算过过程
	public Double calculation() {
		String[] strArr = s.split(" "); // 以空格作为分隔做成字符串数组
		// System.out.prIntegerln(s);
		for (Integer i = 0; i < strArr.length; i++) {
			String temp = strArr[i];

			// 判断是否是数字，包括负数
			if (isDigital(temp)) {
				integer[++len] = (double) Integer.valueOf(temp);
			}
			// 不是数字则取出栈顶元素和栈顶下一个元素进行运算
			else {
				if (len >= 2) {
					Double result = calc(temp);
					integer[++len] = result; // 将所得结果放入栈顶

				}
			}
		}
		return integer[len--];
	}

	private Double calc(String str) {
		Double re = 0.0; // 计算结果的初始化
		Double m = integer[len--]; // 栈顶元素
		Double n = integer[len--]; // 栈顶的下一个元素
		// 不同的运算符
		switch (str) {
		case "+":
			re = n + m;
			break;
		case "-":
			re = n - m;
			break;
		case "*":
			re = n * m;
			break;
		case "/":
			re = n / m;
			break;
		default:
			break;
		}
		// System.out.prIntegerln(re);
		return re;
	}

	// 判断是否是数字
	private boolean isDigital(String str) {
		Integer len = str.length();// 字符串的长度
		// 长度为1时只判断第一位
		if (len == 1 && Character.isDigit(str.charAt(0)))
			return true;
		// 长度为2时判断第二位避开负数的情况
		else if (len > 1 && Character.isDigit(str.charAt(1)))
			return true;
		// 如果两个都不符合的话就返回false
		return false;

	}
}
