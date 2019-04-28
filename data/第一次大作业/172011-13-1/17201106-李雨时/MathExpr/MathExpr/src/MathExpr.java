import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

// ��������һ��token
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
	static char[][] priorMap = { // ������ŵ����ȼ�
			{ '>', '>', '<', '<', '<', '<', '<', '>', '>' }, { '>', '>', '<', '<', '<', '<', '<', '>', '>' },
			{ '>', '>', '>', '>', '<', '<', '<', '>', '>' }, { '>', '>', '>', '>', '<', '<', '<', '>', '>' },
			{ '>', '>', '>', '>', '>', '>', '<', '>', '>' }, { '>', '>', '>', '>', '>', '>', '<', '>', '>' },
			{ '<', '<', '<', '<', '<', '<', '<', '=', '$' }, { '>', '>', '>', '>', '>', '>', '$', '>', '>' },
			{ '<', '<', '<', '<', '<', '<', '<', '$', '=' } };

	// ����������Ż�����ȼ�����е��±�
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
		Stack<Token> stackVals = new Stack<Token>(); // ���������
		Stack<Token> stackOps = new Stack<Token>(); // ���������
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
			if (ch == ' ') { // �ո��ַ�
				b++;
			} else if (ch >= '0' && ch <= '9') { // ���һ������
				value = 0;
				e = b;
				while (expr.charAt(e) >= '0' && expr.charAt(e) <= '9') {
					value = value * 10 + Integer.parseInt("" + expr.charAt(e));
					e++;
				}
				b = e;
				token = new Token('?', value, Token.NUM);
				stackVals.push(token);
			} else { // һ��������
				while (true) {
					// System.out.println("c");
					if (stackOps.empty()) {
						isValid = false;
						break;
					}
					Token topToken = stackOps.peek();
					char cmp = priorMap[getIndex(topToken.op)][getIndex(ch)];
					if (cmp == '$') { // ���Ų�ƥ������Ĵ���
						isValid = false;
						break;
					} else if (cmp == '<') { // ����������ջ
						token = new Token(ch, 0, Token.OP);
						stackOps.push(token);
						break;
					} else if (cmp == '=') {
						stackOps.pop();
						break;
					} else if (cmp == '>') { // �����ȼ����Ȼ�����
						token = stackOps.pop();
						switch (token.op) {
						case '+': // �ӷ�
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
						case '-': // ����
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
						case '*': // �˷�
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
						case '/': // ����
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
		if (stackVals.size() != 1 && stackOps.size() != 0) { // ���ִ���
			isValid = false;
			return -1;
		}
		if (!stackVals.empty())
			value = stackVals.pop().num;
		return value;
	}
}