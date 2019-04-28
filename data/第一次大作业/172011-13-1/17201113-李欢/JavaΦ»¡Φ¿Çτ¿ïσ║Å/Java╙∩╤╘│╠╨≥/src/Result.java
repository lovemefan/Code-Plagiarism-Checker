
public class Result {

	private String post; // ��׺���ʽת���õ��ĺ�׺���ʽ
	private Stack stack; // ���ڵõ���������ջ

	public Result(String post, Stack stack) {
		this.post = post;
		this.stack = stack;
	}

	// �ɺ�׺���ʽ�õ�������������ʵ�ֹ���
	public void operate() {
		String[] strArr = post.split(" ");
		for (int i = 0; i < strArr.length; i++) {
			String kt = strArr[i];
			if (isDigital(kt)) {
				stack.push(String.valueOf(kt));
			} else {
				String result = String.valueOf(compute(kt));
				stack.push(result);
			}
		}
	}

	public int compute(String str) {
		int e = 0;
		int m = Integer.parseInt(stack.pop());
		int n = Integer.parseInt(stack.pop());
		
		if(str.equals("+")){
			e=m+n;
		}
		else if(str.equals("-")){
			e=n-m;
		}
		else if(str.equals("*")){
			e=n*m;
		}
		else if(str.equals("/")){
			e=n/m;
		}
		return e;
	}

	private boolean isDigital(String str) {
		char[] chArr = str.toCharArray();
		int len = chArr.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (chArr[i] >= '0' && chArr[i] <= '9')
				count++;
		}
		return count == len;
	}

	public String getResult() {
		return stack.pop();
	}
}
