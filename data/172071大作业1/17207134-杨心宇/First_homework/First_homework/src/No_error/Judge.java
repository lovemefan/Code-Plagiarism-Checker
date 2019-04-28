package No_error;

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.*;

/*此类的作用为判断表达式是否正确，如果不正确的话 对Expression的对象属性进行修改
 * 修改有两处修改，一处为对类型为boolean 的 IsaExp 属性进行修改，如果正确的话，就直接输出，
 * 另一处为对错误类型进修修改，如果正确的话，TypeOfError不变，为初始值0，如果错误的话依据已给出的错误类型进行输出到文件中，并继续处理下一个表达式*/

class Judge {

	String expression = null;

	/* 总的判断方法，对Expression类的对象的TypeOfError进行修改 */

	/* 删除多余的表达式 */
	void DelSameEXP(Expression[] exp)/* 如果出现重复，则直接将表达式字符床改为null，结合后面的可以进行判断丢弃 */ {
		String[] string1 = new String[50];
		String string2 = null;
		int[] index = new int[50];
		int count = 0;

		int i = 0; // 用于记录进行判断的表达式的下标
		for (count = 0; count < exp.length; count++) {
			string1[count] = exp[count].expression;
			string1[count] = string1[count].substring(1);
			if (string1[count].matches("\\s+"))
				;
			else {
				string1[count] = string1[count].replaceAll(" ", "");
			}

		}
		int length = exp.length;

		for (i = 0; i < length; i++) {
			string2 = string1[i];
			for (count = i + 1; count < length; count++) {

				if (string2.equals(string1[count]) != true) {
					continue;
				} else {
					string1[count] = "";
				}
			}
		}
		for (i = 0; i < length; i++) {
			if (string1[i].equals("")) {
				exp[i].expression = "";
				exp[i].TypeOfError = 11;
				exp[i].IsaExp = false;
				System.out.println(exp[i].expression);
			}
		}

	}
	/* 对DealedStrings进行修改的方法，可以在其他类中进行调用 */

	private void setExpression(Expression exp) {
		this.expression = exp.expression;
	}

	/* 提出空格和序列号 */
	private void getNumber(String string) {
		int pre = 0;
		char[] ch = string.toCharArray();
		int count = 0;// use to coungt number
		if (string.matches("\\d\\d?\\s+") == false) {
			for (count = 1; count < ch.length; count++) {
				if (ch[count] != ' ') {
					pre = count;
					break;
				}
			}
			string = string.substring(pre - 1);// 剪切字符串
			this.expression = string.replaceAll(" ", "");// 删除空格
		}

	}

	public void JudgeType(Expression exp) {// 如果表达式符合规范，则返回true；否则返回false

		setExpression(exp);
		if (exp.IsaExp == true) {
			getNumber(this.expression);

			if (EmptyExp(this.expression) == true) {// 大前提，判断是否为空表达式
				System.out.println("ERROR");
				System.out.println("#表达式位空");
				exp.TypeOfError = 1;
				exp.IsaExp = false;
			} else {// 如果不为空

				if (illegalBuffer(this.expression) == true) {// 第二个前提，判断是否包含非法字符
					System.out.println("ERROR");
					System.out.println("#表达式包含非法字符");
					exp.TypeOfError = 3;
					exp.IsaExp = false;
				} else { // 进行其他的判断
					if (UnmatchBrackets(this.expression) == true) {// 如果括号不匹配
						System.out.println("ERROR");
						System.out.println("#表达式包含不匹配括号");
						exp.TypeOfError = 4;
						exp.IsaExp = false;
					} else {
						if (EmptyBrackets(this.expression) == true) {// 有空括号
							System.out.println("ERROR");
							System.out.println("#表达式包含空括号");
							exp.TypeOfError = 2;
							exp.IsaExp = false;
						} else {
							if (continuellyCharacter(this.expression)) {// 连续运算符
								// 运算符连续
								System.out.println("ERROR");
								System.out.println("#表达式包含连续运算符");
								exp.TypeOfError = 5;
								exp.IsaExp = false;
							} else {
								if(NoNumberBeforeOPTR (this.expression) == true) {//以+-*/）开头
									System.out.println("ERROR");
									System.out.println("#运算符前无运算数");
									exp.TypeOfError = 6;
									exp.IsaExp = false;
									return ;
									
								}
								if (NoNumberAfterOPTR(this.expression) == true) {//以+-*/（结尾
									System.out.println("ERROR");
									System.out.println("#运算符后无运算数");
									exp.TypeOfError = 7;
									exp.IsaExp = false;
									return;
								}
								if (NoNumberBeforeBracketAndBracketNottheFirst(this.expression) == true) {//9（
									System.out.println("ERROR");
									System.out.println("#括号非第一个字符且之前无运算数 ");
									exp.TypeOfError = 8;
									exp.IsaExp = false;
									return;
									
								}
								if (NonumberBeforeBracketAndBracketNottheLast(this.expression) == true) {//）9
									System.out.println("ERROR");
									System.out.println("#小括号后无运算数，括号非最后一个字符 ");
									exp.TypeOfError = 9;
									exp.IsaExp = false;


							}

						}
					}
				}
			}
		}

	}
}

	void RidSame(String[] string) {// 用于减去读取的字符串中的相同的字符串,最终得到的为一个没有重复的字符串
		int p = 0;
		int q = 0;
		int r = 0;
		r = string.length + 1;
		for (p = 0, q = p + 1; q < r; q++) {
			if (string[p] != string[q]) {
				string[p + 1] = string[q];
				p++;
			} else {
				int i = string.length;
			}
		}
	}

	/* 1 */
	boolean EmptyExp(String str) {// 如果为空 返回true,不为空返回false

		String regex = "\\d\\d?\\s+";// 表达式为空

		return Pattern.matches(regex, str);
	}

	/* 2 */
	boolean EmptyBrackets(String str) {// 如果存在空括号，则返回true，否则返回false
		String regex = ".*\\(\\).*";
		return Pattern.matches(regex, str);
	}

	/* 3、 此处相反 */
	boolean illegalBuffer(String str) {// 如果含有非法字符，则返回true;否则返回false

		boolean flag = true;
		String regex = "[-*/+0-9\\(\\)\\=]+";
		if (Pattern.matches(regex, str) == true)
			flag = false;
		else {
			flag = true;
		}
		return flag;

	}

	/* 4 */
	boolean UnmatchBrackets(String s) {// 如果括号不匹配，则返回 true;否则返回false
		int len = s.length();

		LinkedList<Character> stack = new LinkedList<Character>();
		// 循环遍历字符串
		for (int i = 0; i < len; i++) {
			// 如果是左括号则入栈
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(ch);
				// 如果是右括号
			} else if (ch == ')') {
				// 栈空，则右括号没有匹配的左括号，则返回false
				if (stack.isEmpty()) {
					return true;
					// 栈不空，则和栈顶比较
				} else if (stack.peek().equals(ch)) {
					return true;
				} else {
					stack.pop();
				}
			}
		}
		// 循环结束后，栈空表示匹配完了，不空表示多余左括号
		if (stack.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	/* 5 */
	/* 忽略 （+ 的情况 将其归入运算符前无操作数 */
	boolean continuellyCharacter(String str) {// 如果存在运算符连续，则返回true;否则返回false

		char ch[] = str.toCharArray();
		boolean flag = false;
		int i = 0;
		int theNext = 0;
		for (i = 0; i < ch.length - 1; i++) {
			if (ch[i] == '+' || ch[i] == '-' || ch[i] == '/' || ch[i] == '*') {
				theNext = i + 1;
				if (ch[theNext] == '+' || ch[theNext] == '-' || ch[theNext] == '/' || ch[theNext] == '*') {
					flag = true;
					break;
				}
			}

			/* 判断是否存在 （+ 情况 */
			if (ch[i] == '(') {
				theNext = i + 1;
				if (ch[theNext] == '+' || ch[theNext] == '/' || ch[theNext] == '-' || ch[theNext] == '*') {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	/*
	 * 6 运算符前无运算数 只考虑开头为 +-/*的情况,不考虑 （+ 的情况
	 */
	boolean NoNumberBeforeOPTR(String str) {//  以-*/+)开头 则返回true 否则返回false
		char ch = str.charAt(0);
		if(ch == '+'||ch == '-'||ch == '*'||ch == '/'||ch == ')') {
			return true;
		}
		else return false;
		
	}

	/* 7 */
	boolean NoNumberAfterOPTR(String string) {// 以-*/+（结尾 则返回true 否则返回false
		int len = string.length();
		char ch = string.charAt(len-1);
		if(ch == '+'||ch == '-'||ch == '*'||ch == '/'||ch == '(') {
			return true;
		}
		else return false;
	}

	/*
	 * 8 因为操作符丢失
	 */
	boolean NoNumberBeforeBracketAndBracketNottheFirst(String string) {
		String regex = ".*\\d\\(.*";
		return string.matches(regex);
	}

	/* 9 */
	boolean NonumberBeforeBracketAndBracketNottheLast(String string) {// 真return true,假return false
		String regex = ".*\\)\\d.*";
		return string.matches(regex);
	}

}
