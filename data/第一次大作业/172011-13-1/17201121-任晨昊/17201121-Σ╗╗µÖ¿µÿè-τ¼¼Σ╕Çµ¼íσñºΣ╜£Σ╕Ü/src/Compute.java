
import java.util.Queue;
import java.util.Stack;

public class Compute {
	public static int calculate(Queue<Node> exp) {//计算方法
		Stack<Node> s = new Stack<Node>();
		Node t1, t2, t;
		while (!exp.isEmpty()) {
			t = exp.poll();
			if (t.ifop) {
				t2 = s.pop();//从栈中读取元素
				t1 = s.pop();
				switch (t.value) {//根据符号分情况计算
				case 0:
					s.push(new Node(false, t1.value + t2.value));
					break;
				case 1:
					s.push(new Node(false, t1.value - t2.value));
					break;
				case 2:
					s.push(new Node(false, t1.value * t2.value));
					break;
				case 3:
					s.push(new Node(false, t1.value / t2.value));
					break;
				}
			} else
				s.push(t);//将元素存入栈中
		}
		return s.pop().value;
	}
}
