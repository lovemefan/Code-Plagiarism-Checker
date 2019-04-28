// 中缀转后缀
class Init {
	String[] stack = new String[1005];
	String post = "";// 输入的表达式，去掉啦所有的空格
	String now = "";// 加入空格之后的表达式
	String result = "";// 得到的后缀表达式
	int len = 0;// 栈的长的
	int num = 0;// 栈内左括号的数目
	int flag = 0; // 表达式括号是否配对

	Init(String s) {
		this.post = s;
		len = 0;
		this.flag = 0;
	}

	// 输入的表达式符号和数字之间加入空格
	private void handlePost(String post) {
		Integer i = 0;
		for (i = 0; i < post.length() - 1; i++) {

			char temp1 = post.charAt(i);// 当前位置
			char temp2 = post.charAt(i + 1);// 下一位
			// 判断当前位和下一位是否是数字
			if (Character.isDigit(temp1) && Character.isDigit(temp2)) {
				now += temp1;
			}
			// 判断负数
			else if (i == 0 && temp1 == '-') {
				now += temp1;

			} else if (temp1 == '(' && temp2 == '-') {
				now += temp1 + " " + temp2;
				i++;
			} else
				now += temp1 + " ";
		}
		// System.out.println(now);
		if (post.length() - 1 == i)
			now += post.charAt(post.length() - 1); // 将最后一个元素添加进去
	}

	public boolean getTrue() {
		if (this.flag == 1)
			return true;
		else
			return false;
	}

	// 中缀转后缀
	public String handleNow() {
		handlePost(this.post); // 得到加入空格后的表达式now
		// System.out.println(now);
		String[] nowArr = now.split(" "); // 以空格作为分隔做成字符串数组
		for (int i = 0; i < nowArr.length; i++) {
			String str = nowArr[i];
			// 判断字符串的类型
			switch (str) {
			// +-*/与栈顶比较不小于则将栈顶元素弹出直到小于栈顶元素
			case "+":
			case "-":
				handleSymbol(str);
				break;
			case "*":
			case "/":
				handleSymbol(str);
				break;
			// （直接入栈
			case "(":
				stack[++len] = str;
				this.num++; // 栈内左括号数目加一
				break;
			// 清空栈顶元素直到遇见一个（
			case ")":
				handleBrackets();
				break;
			default:
				result += " " + str;
				break;
			}
		}
		// 栈内的左括号未完全消除
		if (this.num != 0)
			this.flag = 1;
		// 将栈中的符号清空
		while (len != 0) {
			result += " " + stack[len--];
			// 返回得到的后缀表达式
		}
		// System.out.println(result);
		return result;
	}

	// 判断运算符的优先级 +-为1级 */为2级
	private int check(String s) {
		if (s.equals("+") || s.equals("-"))
			return 1;
		else
			return 2;
	}

	// 与栈顶比较不小于则将栈顶元素弹出直到小于栈顶元素
	private void handleSymbol(String s) {
		int a = check(s); // 将要被加入的运算符
		while (len != 0) {
			// 栈顶元素
			String temp = stack[len--];
			// 遇到（则将（重新加入栈并退出循环
			if (temp.equals("(")) {
				stack[++len] = temp;
				break;
			}
			// 将栈顶元素弹出直到小于栈顶元素
			else {
				int b = check(temp);
				// 比较将要加入的运算符和栈顶元素的优先级
				if (b < a) {
					stack[++len] = temp;// 大于则重新加入栈顶元素并退出
					break;
				}
				// 小于则将栈顶元素输出
				else
					result += " " + temp;
			}
		}
		// 将需要加入的运算符加入
		stack[++len] = s;
	}

	// 处理）
	private void handleBrackets() {
		while (len != 0) {

			// 得到栈顶元素
			String temp = stack[len--];
			// 遇到（则退出循环否则将栈顶元素输出
			if (temp.equals("(")) {
				break;
			} else {
				result += " " + temp;
			}
		}
		this.num--;
		// 如果栈内的左括号减到负数说明括号不匹配
		if (this.num < 0)
			flag = 1;
	}
}
