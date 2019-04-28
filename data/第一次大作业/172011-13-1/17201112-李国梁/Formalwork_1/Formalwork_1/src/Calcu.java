class Calcu {
	private Stack stack; 
	private String postfix;

	public Calcu(String post, Stack stack) {// �вι���
		this.postfix = post;
		this.stack = stack;
	}

	public String getSum() {// �������������ջ�в����ó����return
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

	private int calculate(String str) {//�����������
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

	private boolean number(String str) {//�ж��Ƿ�Ϊ����
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