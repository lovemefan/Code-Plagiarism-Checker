import java.util.Stack;
public class Convert {
	public void Convert() {

	}

	public float Convert(String arr) {

		Stack<Character> stack1 = new Stack<Character>(); // 字符的栈

		char[] b = arr.toCharArray();
		char top;

		String result = "";
		float re;

		for (int i = 0; i < b.length; i++) {
			if (b[i] >= '0' && b[i] <= '9') {

				result = result + b[i];
			}

			else {

				result = result + " ";

				if (b[i] == '(') {
					stack1.push(b[i]);
				}

				if (b[i] != '(' && b[i] != ')') {
					while (true) {
						if (stack1.isEmpty() != false) {
							stack1.push(b[i]);
							break;
						}

						top = stack1.peek();
						if (top == '(' || Compare(b[i], top) >= 0) {
							stack1.push(b[i]);
							break;
						}

						else if (Compare(b[i], top) < 0) {
							result = result + top + " ";
							stack1.pop();
							stack1.push(b[i]);
							break;
						}
					}
				}

				if (b[i] == ')') {
					while (true) {
						if (stack1.isEmpty() != false) {
							stack1.push(b[i]);
							break;
						}

						top = stack1.pop();
						if (top == '+' || top == '-' || top == '*' || top == '/')
							result = result + top + " ";
						else {
							break;
						}
					}
				}
			}
		}

		while (stack1.isEmpty() == false) {
			result = " " + result + " " + stack1.pop() + " ";
		}

		
		Calculate cal = new Calculate();
		re = cal.Calculate(result);
		return re;

	}

    //比较a,b运算符的优先级
	public int Compare(char a, char b){
		int s = 0;

		if (a == '+' ||a == '-') {
			if (b == '*' || b == '/' || b == '(' || b == ')')
				s = -1;
			else
				s = 0;
		}

		if (a == '*' || b == '/') {
			if (b == '+' ||a == '-')
				s = 1;
			else if (b == '(' || b == ')')
				s = -1;
			else 
				s = 0;
		}
		return s;
	}

}