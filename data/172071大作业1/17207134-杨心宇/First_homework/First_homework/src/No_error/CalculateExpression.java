package No_error;

import java.io.IOException;
import java.util.Stack;

public class CalculateExpression {

	String number = null;// 用于存储记录的编号
	String string = null;
	/*
	 * 计算之前要调用这个方法，让带序号的字符串变为一个表达式 表达式的形式为： #expression#
	 */

	int Divisor(int number1, int number2) {
		if (number2 == 0) {
			throw new ArithmeticException("Divisor cannot be zero");
		}
		return number1 / number2;
	}

	/* 在表达式后面添加 "#"号 以便于利用栈来进行运算 */
	void Conversion(Expression exp) {

		String str = "#";
		exp.expression = exp.expression + str;

	}

	/* 用于记录表达式的序号 */
	void getNumber(Expression exp) {
		this.number = exp.expression.substring(0, 2);
		int pre = 0;
		int after = 0;
		int i = 0;
		char ch[] = exp.expression.toCharArray();

		for (i = 2; i < ch.length; i++) {
			if (ch[i] != ' ') {
				pre = i;
				break;
			}
		}

		for (i = pre; i < ch.length; i++) {
			if (ch[i] == '=') {
				after = i;
				break;

			}
		}
		exp.expression = exp.expression.substring(pre - 1);
	}

	/* 设置CalculateExpression的属性，用于 */
	private void SetString(Expression exp) {
		this.string = exp.expression;
	}

	private void SetString2(Expression exp) {
		this.string = exp.expression + '#';
	}

	/* 去除空格 */
	void TrimSpace(Expression exp) {

		exp.expression = exp.expression.replaceAll("\\s*", "");

	}

	/* 有两种方法，一种很蠢，另一种超级蠢 */
	public void Calculate(Expression exp) {

		/* 首先判断是否为错误的表达式，如果为错误的表达式，只需要把后面的内容清零即可 */
		if (exp.IsaExp == false) {
			if (exp.expression != "")
				exp.expression = exp.expression.substring(0, 2);

		} else {// 如果真的为一个表达式的话,就开始计算
			if (exp.IsaExp != false) {
				Conversion(exp);// 将表达式转换的易于计算
				getNumber(exp);// 顺带把所有的都减了，只留下有用的
				TrimSpace(exp);
				SetString2(exp);

				String result = Result(this.string, exp);
				finishExpression(exp, result);
				System.out.println(exp.expression);
			}

		}

	}

	private String Result(String expression, Expression exp) {
		Stack<String> OPTR = new Stack();
		Stack<String> OPND = new Stack();

		this.string = AddComma(this.string);
		Change(this.string);

		int[] index = new int[50];// 用于存放截取的字符串的下标
		index = GetIndex(this.string);

		OPTR.push("#");

		String temp = null;
		int number = 0;
		int times = 1;
		String abc = "#";

		temp = this.string.substring(1, index[times]);
		times++;
		while (temp.equals(abc) != true || OPTR.peek().equals(abc) != true) {
			if (IsNumber(temp) == true) {
				OPND.push(temp);
				temp = this.string.substring(index[times - 1] + 1, index[times]);
				times++;
			} else {
				switch (Precede(OPTR.peek(), temp)) {
				case 1: {
					String theta = "";
					String a = "";
					String b = "";
					theta = OPTR.pop();
					b = OPND.pop();
					a = OPND.pop();
					OPND.push(Operate(a, theta, b, exp));
					break;

				}
				case 0: {
					OPTR.pop();
					temp = this.string.substring(index[times - 1] + 1, index[times]);
					times++;
					break;

				}
				case -1: {
					OPTR.push(temp);
					temp = this.string.substring(index[times - 1] + 1, index[times]);
					times++;
				}
				}
			}
		}

		// TODO Auto-generated method stub
		return OPND.peek();
	}

	private String Operate(String a, String theta, String b, Expression exp) {
		int number1 = 0;
		int number2 = 0;
		number1 = Integer.parseInt(a);
		number2 = Integer.parseInt(b);
		int result = 0;
		String abc = "";
		switch (theta) {
		case "+":
			result = number1 + number2;
			break;
		case "-":
			result = number1 - number2;
			break;
		case "*":
			result = number1 * number2;
			break;
		case "/":
			try {
				result = Divisor(number1, number2);
			} catch (ArithmeticException ex) {
				exp.TypeOfError = 10;
				System.out.println(ex.getMessage());
			}
			break;
		}

		abc = abc.valueOf(result);
		// TODO Auto-generated method stub
		return abc;
	}

	private void Rpn() {
		this.string = AddComma(this.string);
		Change(this.string);

		int[] index = new int[50];// 用于存放截取的字符串的下标
		index = GetIndex(this.string);

		String temp = null;
		int number = 0;
		int times = 1;
		Stack<String> OPND = new Stack<>();// 改栈中可以存放String类
		Stack<String> OPTR = new Stack<>();

		temp = this.string.substring(1, index[times]);
		times++;

		OPTR.push("#");
		String abc = "#";
		String str = "";
		while (temp.equals(abc) != true || OPTR.peek().equals(abc) != true) {
			if (IsNumber(temp) == true) {// 如果是一个操作数的话
				str = str + temp + ",";
				temp = this.string.substring(index[times - 1] + 1, index[times]);
				times++;
			} else {
				switch (Precede(OPTR.peek(), temp)) {
				case 1: {
					str = str + OPTR.pop() + ",";
					break;

				}
				case -1: {
					OPTR.push(temp);
					temp = this.string.substring(index[times - 1] + 1, index[times]);
					times++;
					break;

				}
				case 0: {
					OPTR.pop();
					temp = this.string.substring(index[times - 1] + 1, index[times]);
					times++;
					break;
				}
				}
			}
		}

		this.string = str;
		System.out.println(this.string);
		Transform(this.string);
		String abdc = ",";
		this.string = abdc + this.string;

	}

	private void Transform(String string1) {

		// TODO Auto-generated method stub

	}

	private int Precede(String peek, String temp) {
		int m = 0;
		int n = 0;
		int[][] a = { { 1, 1, -1, -1, -1, 1, 1 }, { 1, 1, -1, -1, -1, 1, 1 }, { 1, 1, 1, 1, -1, 1, 1 },
				{ 1, 1, 1, 1, -1, 1, 1 }, { -1, -1, -1, -1, -1, 0, 2 }, { 1, 1, 1, 1, 2, 1, 1 },
				{ -1, -1, -1, -1, -1, 2, 0 } };
		switch (peek) {
		case "+":
			m = 0;
			break;
		case "-":
			m = 1;
			break;
		case "*":
			m = 2;
			break;
		case "/":
			m = 3;
			break;
		case "(":
			m = 4;
			break;
		case ")":
			m = 5;
			break;
		case "#":
			m = 6;
			break;
		}
		switch (temp) {
		case "+":
			n = 0;
			break;
		case "-":
			n = 1;
			break;
		case "*":
			n = 2;
			break;
		case "/":
			n = 3;
			break;
		case "(":
			n = 4;
			break;
		case ")":
			n = 5;
			break;
		case "#":
			n = 6;
			break;
		}
		return a[m][n];
	}

	private boolean IsNumber(String temp) {
		char[] ch = temp.toCharArray();
		int i = 0;
		if (ch[i] <= '9' && ch[i] >= '0')
			return true;
		else {
			return false;
		}
	}

	void SetString(int index) {
		int length = string.length();
		this.string = (String) this.string.subSequence(index, length);

	}

	private int[] GetIndex(String string2) {

		int[] index = new int[50];
		char[] getstring = string2.toCharArray();
		int i = 1;
		int count = 0;
		for (count = 1; count < getstring.length; count++) {
			if (getstring[count] == ',') {
				index[i++] = count;
			}
		}

		return index;
	}

	String AddComma(String string) {
		StringBuffer stringBuffer = new StringBuffer(string);

		int i = 0;
		int count = 0;

		for (i = 0; i < stringBuffer.length(); i++) {

			stringBuffer.insert(i + 1, ',');
			i++;
		}
		string = stringBuffer.toString();
		Change(string);
		// System.out.println(string);
		return string;

	}

	void Change(String string) {
		int i = 0;
		char[] ch = string.toCharArray();
		for (i = 0; i < ch.length - 2; i++) {
			if (ch[i] <= '9' && ch[i] >= '0') {
				if (ch[i + 2] <= '9' && ch[i + 2] >= '0') {
					ch[i + 1] = ' ';
				}
			}
		}
		String a = new String(ch);
		string = a;
		this.string = "," + string.replaceAll("\\s*", "");

	}

	int operate(int number1, String op, int number2, Expression exp) {

		int result = 0;
		switch (op) {
		case "+":
			result = number1 + number2;
			break;
		case "-":
			result = number1 - number2;
			break;
		case "*":
			result = number1 * number2;
			break;
		case "/":
			try {
				result = Divisor(number1, number2);
			} catch (ArithmeticException ex) {
				exp.expression = exp.expression = exp.expression.substring(0, 2);
				exp.TypeOfError = 10;
				System.out.println(ex.getMessage());
			}
			break;
		}
		return result;
	}

	void finishExpression(Expression expression, String string) {// 将表达式还原
		expression.expression = expression.expression.replaceAll("#", "=");
		expression.expression = this.number + expression.expression;
		expression.expression += string;

	}

}
