
public class Computer {
	public Computer() {

	}

	public double Deal(Figure f, Machine m, String op) {
		int n = op.length();
		int i = 0;
		double num = 0;
		int k = 0;
		m.pushMachine((char) (40));
		for (i = 0; i < n; i++) {
			if (op.charAt(i) <= '9' && op.charAt(i) >= '0') {
				num = op.charAt(i) - '0';
				f.pushFigure(num);
				 System.out.println("此时顶端数字"+f.searchFigure());
				// System.out.println("此时符号个数"+m.getN());
				// System.out.println("此时数字个数"+f.getN());
				// System.out.println("此时顶端符号"+m.searchMachine());
				// 多位数以上
				if (i + 1 < n) {
					if (op.charAt(i) <= '9' && op.charAt(i) >= '0' && op.charAt(i + 1) <= '9'
							&& op.charAt(i + 1) >= '0') {
						double a = f.popFigure();
						double b = op.charAt(i + 1) - '0';
						f.pushFigure(mergeFigure(a, b));
						System.out.println("此时顶端数字"+f.searchFigure());
						i++;
					}
				}
				if ((m.searchMachine() == '*' || m.searchMachine() == '/') && m.getN() != -1) {// 优先算出*和/
					double a = f.popFigure();
					double b = f.popFigure();
					char ch = m.popMachine();
					f.pushFigure(accountResult(a, b, ch));
				}
			} else {
				m.pushMachine(op.charAt(i));
				System.out.println("此时顶端符号" + m.searchMachine());
			}
			if (m.searchMachine() == ')') {
				System.out.println("此时顶端符号" + m.searchMachine());
				m.cutN();
				k = 1;
			}
			while (k == 1) {
				int p = 1;
				if (m.searchMachine() == '(') {
					m.cutN();
					k = 0;
					p = 0;
				}
				if (p == 1) {
					double a = f.popFigure();
					double b = f.popFigure();
					char ch = m.popMachine();
					f.pushFigure(accountResult(a, b, ch));
					 System.out.println("此时顶端数字"+f.searchFigure());
				}
				/*
				 * if(m.searchMachine()=='('){ m.cutN(); k = 0; }
				 */
			}
			// System.out.println("此时顶端数字"+f.searchFigure());
			/*
			 * while ((m.searchMachine() == '(' && op.charAt(i + 1) !=
			 * '(')&&m.getN()!=-1) { // 连续多个（括号也不能 Figure f1 = new Figure();
			 * Machine m1 = new Machine(); temp = i + 1; if (op.charAt(temp) >=
			 * '0' && op.charAt(temp) <= '9') { num = op.charAt(temp)-'0';
			 * f1.pushFigure(op.charAt(temp)); temp++; if (m1.searchMachine() ==
			 * '*' || m1.searchMachine() == '/') { int a = f1.popFigure(); int b
			 * = f1.popFigure(); char ch = m1.popMachine();
			 * f1.pushFigure(c.accountResult(a, b, ch));// 将乘获除的结果先算出，压入栈中 } }
			 * else { m1.pushMachine(op.charAt(temp)); temp++; } if
			 * (m1.popMachine() == ')') {// 括号内*和/运算结束脱掉） while (f1.getN() > 1)
			 * { // 将剩下的加减运算完成，直到剩下一个数 int a = f1.popFigure(); int b =
			 * f1.popFigure(); char ch = m1.popMachine();
			 * f1.pushFigure(c.accountResult(a, b, ch)); }
			 * f.pushFigure(f.popFigure()); // 将括号中结果压入栈 i = temp; // 跟进到当前操作位置
			 * } if (m.searchMachine() == '(') { char ch = m.popMachine(); //
			 * 将原运算符栈中的（也脱掉 } }
			 */

		}
		while (f.getN()>0) {// 将整个式子剩余的数进行+ -运算，最后剩下一个数
			double a = f.popFigure();
			double b = f.popFigure();
			char ch = m.popMachine();
			f.pushFigure(accountResult(a, b, ch));
		}

		return f.popFigure();// System.out.println("此时顶端数字"+f.searchFigure());
	}

	public double accountResult(double a, double b, char op) {
		double c = 0;
		switch (op) {
		case '+':
			c = a + b;
			break;
		case '-':
			c = b - a;
			break;
		case '*':
			c = a * b;
			break;
		case '/':
			c = b / a;
			break;
		}
		return c;
	}

	public double mergeFigure(double a, double b) {
		return a * 10 + b;
	}
}
