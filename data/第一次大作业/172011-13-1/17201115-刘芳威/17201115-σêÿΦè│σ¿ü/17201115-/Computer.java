
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
				 System.out.println("��ʱ��������"+f.searchFigure());
				// System.out.println("��ʱ���Ÿ���"+m.getN());
				// System.out.println("��ʱ���ָ���"+f.getN());
				// System.out.println("��ʱ���˷���"+m.searchMachine());
				// ��λ������
				if (i + 1 < n) {
					if (op.charAt(i) <= '9' && op.charAt(i) >= '0' && op.charAt(i + 1) <= '9'
							&& op.charAt(i + 1) >= '0') {
						double a = f.popFigure();
						double b = op.charAt(i + 1) - '0';
						f.pushFigure(mergeFigure(a, b));
						System.out.println("��ʱ��������"+f.searchFigure());
						i++;
					}
				}
				if ((m.searchMachine() == '*' || m.searchMachine() == '/') && m.getN() != -1) {// �������*��/
					double a = f.popFigure();
					double b = f.popFigure();
					char ch = m.popMachine();
					f.pushFigure(accountResult(a, b, ch));
				}
			} else {
				m.pushMachine(op.charAt(i));
				System.out.println("��ʱ���˷���" + m.searchMachine());
			}
			if (m.searchMachine() == ')') {
				System.out.println("��ʱ���˷���" + m.searchMachine());
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
					 System.out.println("��ʱ��������"+f.searchFigure());
				}
				/*
				 * if(m.searchMachine()=='('){ m.cutN(); k = 0; }
				 */
			}
			// System.out.println("��ʱ��������"+f.searchFigure());
			/*
			 * while ((m.searchMachine() == '(' && op.charAt(i + 1) !=
			 * '(')&&m.getN()!=-1) { // �������������Ҳ���� Figure f1 = new Figure();
			 * Machine m1 = new Machine(); temp = i + 1; if (op.charAt(temp) >=
			 * '0' && op.charAt(temp) <= '9') { num = op.charAt(temp)-'0';
			 * f1.pushFigure(op.charAt(temp)); temp++; if (m1.searchMachine() ==
			 * '*' || m1.searchMachine() == '/') { int a = f1.popFigure(); int b
			 * = f1.popFigure(); char ch = m1.popMachine();
			 * f1.pushFigure(c.accountResult(a, b, ch));// ���˻���Ľ���������ѹ��ջ�� } }
			 * else { m1.pushMachine(op.charAt(temp)); temp++; } if
			 * (m1.popMachine() == ')') {// ������*��/��������ѵ��� while (f1.getN() > 1)
			 * { // ��ʣ�µļӼ�������ɣ�ֱ��ʣ��һ���� int a = f1.popFigure(); int b =
			 * f1.popFigure(); char ch = m1.popMachine();
			 * f1.pushFigure(c.accountResult(a, b, ch)); }
			 * f.pushFigure(f.popFigure()); // �������н��ѹ��ջ i = temp; // ��������ǰ����λ��
			 * } if (m.searchMachine() == '(') { char ch = m.popMachine(); //
			 * ��ԭ�����ջ�еģ�Ҳ�ѵ� } }
			 */

		}
		while (f.getN()>0) {// ������ʽ��ʣ���������+ -���㣬���ʣ��һ����
			double a = f.popFigure();
			double b = f.popFigure();
			char ch = m.popMachine();
			f.pushFigure(accountResult(a, b, ch));
		}

		return f.popFigure();// System.out.println("��ʱ��������"+f.searchFigure());
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
