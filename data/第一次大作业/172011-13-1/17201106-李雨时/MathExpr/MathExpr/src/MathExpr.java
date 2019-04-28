import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

// 解析出来一个token
class Token {
	static int OP = 0;
	static int NUM = 1;
	char op;
	int num;
	int type;
	public Token(char op, int num, int type) {
		this.op = op;
		this.num = num;
		this.type = type;
	}
}

public class MathExpr {
	static boolean isValid;
	static char[][] priorMap = { // 运算符号的优先级
			{ '>', '>', '<', '<', '<', '<', '<', '>', '>' }, { '>', '>', '<', '<', '<', '<', '<', '>', '>' },
			{ '>', '>', '>', '>', '<', '<', '<', '>', '>' }, { '>', '>', '>', '>', '<', '<', '<', '>', '>' },
			{ '>', '>', '>', '>', '>', '>', '<', '>', '>' }, { '>', '>', '>', '>', '>', '>', '<', '>', '>' },
			{ '<', '<', '<', '<', '<', '<', '<', '=', '$' }, { '>', '>', '>', '>', '>', '>', '$', '>', '>' },
			{ '<', '<', '<', '<', '<', '<', '<', '$', '=' } };

	// 根据运算符号获得优先级表格中的下表
	static int getIndex(char ch) {
		int index = 0;
		switch (ch) {
		case '+':
			index = 0;
			break;
		case '-':
			index = 1;
			break;
		case '*':
			index = 2;
			break;
		case '/':
			index = 3;
			break;
		case '(':
			index = 6;
			break;
		case ')':
			index = 7;
			break;
		case '#':
			index = 8;
			break;
		}
		return index;
	}

	static int parseExpr(String expr) {
		isValid = true;
		Stack<Token> stackVals = new Stack<Token>(); // 保存操作数
		Stack<Token> stackOps = new Stack<Token>(); // 保存运算符
		Token token = null, tokenA = null, tokenB = null;
		token = new Token('#', 0, Token.OP);
		stackOps.push(token);
		expr += "#";
		int len = expr.length();
		int b = 0, e = 0;
		char ch = 0;
		int value = 0;
		while (b != len && isValid) {
			ch = expr.charAt(b);
			if (ch == ' ') { // 空格字符
				b++;
			} else if (ch >= '0' && ch <= '9') { // 获得一个数字
				value = 0;
				e = b;
				while (expr.charAt(e) >= '0' && expr.charAt(e) <= '9') {
					value = value * 10 + Integer.parseInt("" + expr.charAt(e));
					e++;
				}
				b = e;
				token = new Token('?', value, Token.NUM);
				stackVals.push(token);
			} else { // 一个操作数
				while (true) {
					// System.out.println("c");
					if (stackOps.empty()) {
						isValid = false;
						break;
					}
					Token topToken = stackOps.peek();
					char cmp = priorMap[getIndex(topToken.op)][getIndex(ch)];
					if (cmp == '$') { // 括号不匹配引起的错误
						isValid = false;
						break;
					} else if (cmp == '<') { // 操作符号入栈
						token = new Token(ch, 0, Token.OP);
						stackOps.push(token);
						break;
					} else if (cmp == '=') {
						stackOps.pop();
						break;
					} else if (cmp == '>') { // 高优先级的先机计算
						token = stackOps.pop();
						switch (token.op) {
						case '+': // 加法
							if (stackVals.empty()) {
								isValid = false;
								break;
							}
							tokenB = stackVals.pop();
							if (stackVals.empty()) {
								isValid = false;
								break;
							}
							tokenA = stackVals.pop();
							tokenA.num += tokenB.num;
							stackVals.push(tokenA);
							break;
						case '-': // 减法
							if (stackVals.empty()) {
								isValid = false;
								break;
							}
							tokenB = stackVals.pop();
							if (stackVals.empty()) {
								isValid = false;
								break;
							}
							tokenA = stackVals.pop();
							tokenA.num -= tokenB.num;
							stackVals.push(tokenA);
							break;
						case '*': // 乘法
							if (stackVals.empty()) {
								isValid = false;
								break;
							}
							tokenB = stackVals.pop();
							if (stackVals.empty()) {
								isValid = false;
								break;
							}
							tokenA = stackVals.pop();
							tokenA.num *= tokenB.num;
							stackVals.push(tokenA);
							break;
						case '/': // 除法
							if (stackVals.empty()) {
								isValid = false;
								break;
							}
							tokenB = stackVals.pop();
							if (stackVals.empty()) {
								isValid = false;
								break;
							}
							tokenA = stackVals.pop();
							tokenA.num /= tokenB.num;
							stackVals.push(tokenA);
							break;
						}
						if (!isValid) {
							break;
						}
					}
				}
				b++;
			}
		}
		if (stackVals.size() != 1 && stackOps.size() != 0) { // 出现错误
			isValid = false;
			return -1;
		}
		if (!stackVals.empty())
			value = stackVals.pop().num;
		return value;
	}
}