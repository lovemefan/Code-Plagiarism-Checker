class Calcu {
	private Stack stack; 
	private String postfix;

	public Calcu(String post, Stack stack) {// 有参构造
		this.postfix = post;
		this.stack = stack;
	}

	public String getSum() {// 将两两结果存入栈中并最后得出结果return
		String[] str = postfix.split(" ");
		for (int i = 0; i < str.length; i++) {
			String t = str[i];
			if (number(t)) {
				stack.in(String.valueOf(t));
			} else {
				String sum = String.valueOf(calculate(t));
				stack.in(sum);
			}
		}
		return stack.out();
		
	}

	private int calculate(String str) {//计算两两结果
		int sum = 0;
		int m = Integer.parseInt(stack.out());
		int n = Integer.parseInt(stack.out());

		if (str.equals("+")) {
			sum = n + m;
		} else if (str.equals("-")) {
			sum = n - m;
		} else if (str.equals("*")) {
			sum = n * m;
		} else if (str.equals("/")) {
			sum = n / m;
		}
		return sum;
	}

	private boolean number(String str) {//判断是否为数字
		char[] c = str.toCharArray();
		int length = c.length;
		int n = 0;
		for (int i = 0; i < length; i++) {
			if (c[i] >= '0' && c[i] <= '9')
				n++;
		}
		return n == length;
	}

}