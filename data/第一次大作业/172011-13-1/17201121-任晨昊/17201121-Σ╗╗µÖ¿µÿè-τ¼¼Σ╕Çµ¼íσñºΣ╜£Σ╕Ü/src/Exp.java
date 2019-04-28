import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exp {
	private Queue<Node> exp;//表达式队列（中缀）

	public boolean setExp(String s) {
		/*
		 * 验证模块
		 */ 
		Translate(s);
		return true;
	}

	private void Translate(String str) {//中缀改后缀方法
		Queue<Node> expression = new LinkedList<Node>();
		int p = 0;
		while (p < str.length()) {//遍历该字符串
			if (str.charAt(p) >= '0' && str.charAt(p) <= '9') {//当元素为数字时
				int t = 0;
				while (p + t + 1 < str.length() && str.charAt(p + t + 1) >= '0' && str.charAt(p + t + 1) <= '9')
					t++;
				int value = 0;
				for (int i = 0; i <= t; i++) {
					value += (str.charAt(p + i) - '0') * Math.pow(10, t - i);
				}
				// System.out.println(value);
				expression.offer(new Node(false, value));
				p += t + 1;
			} else if (str.charAt(p) == '+' || str.charAt(p) == '-' || str.charAt(p) == '*' || str.charAt(p) == '/'
					|| str.charAt(p) == '(' || str.charAt(p) == ')') {//当该元素为四则符号时
				switch (str.charAt(p)) {
				case '+':
					expression.offer(new Node(true, 0));//根据符号优先级接入
					break;
				case '-':
					expression.offer(new Node(true, 1));
					break;
				case '*':
					expression.offer(new Node(true, 2));
					break;
				case '/':
					expression.offer(new Node(true, 3));
					break;
				case '(':
					expression.offer(new Node(true, 4));
					break;
				case ')':
					expression.offer(new Node(true, 5));
					break;
				}
				p++;
			}
		}
		setExp(expression);
	}

	public Queue<Node> getSuffix() {//转后缀
		Queue<Node> res = new LinkedList<Node>();
		Stack<Node> s = new Stack<Node>();
		Node tem;
		while (exp.isEmpty() == false) {
			tem = exp.poll();

			if (tem.ifop) {
				if (tem.value == 5) {//当读取出右括弧时
					tem = s.pop();//从栈中弹出
					while (tem.value != 4) {//当读取到的不是左括号时
						res.offer(tem);//接入
						tem = s.pop();
					}
					continue;
				}
				if (s.isEmpty() || tem.value == 4 || s.firstElement().value == 4) {//空栈或读取为左括弧或栈顶元素为左括弧
					s.push(tem);//将元素推送到栈中
					continue;
				}

				if (tem.value == 2 || tem.value == 3) {// 若为乘或除
					s.push(tem);
					continue;
				}
				if (tem.value == 1 || tem.value == 0) {//若为加或减
					if (s.firstElement().value == 4) {//当读取到左括号
						s.push(tem);
						continue;
					} else {
						while (s.isEmpty() == false) {
							Node temp = s.pop();
							if (temp.value == 4) {
								s.push(temp);
								break;
							}
							res.offer(temp);
						}
						s.push(tem);
						continue;
					}
				}

			} else
				res.offer(tem);//将转换好的中缀以后缀形式接入
		}
		while (!s.isEmpty()) {//该栈为空时
			res.offer(s.pop());
		}
		return res;
	}

	public Queue<Node> getExp() {//返回私有字符串
		return exp;
	}

	public void setExp(Queue<Node> exp) {//写入私有字符串
		this.exp = exp;
	}
}