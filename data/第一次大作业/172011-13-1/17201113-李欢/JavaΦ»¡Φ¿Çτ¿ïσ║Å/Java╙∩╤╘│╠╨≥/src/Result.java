
public class Result {

	private String post; // 中缀表达式转换得到的后缀表达式
	private Stack stack; // 用于得到计算结果的栈

	public Result(String post, Stack stack) {
		this.post = post;
		this.stack = stack;
	}

	// 由后缀表达式得到四则运算结果的实现过程
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
