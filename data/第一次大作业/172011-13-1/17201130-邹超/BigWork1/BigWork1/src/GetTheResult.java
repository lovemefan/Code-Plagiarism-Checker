
public class GetTheResult {
	private String exp; 
	private Stack sta; 

	public GetTheResult(String exp, Stack stack) {
		this.exp = exp;
		this.sta = stack;
	}

	public void operate() {
		String[] str = exp.split(" ");

		for (int i = 0; i < str.length; i++) {
			String t = str[i];

			if (isNumber(t)) {
				sta.push(t);
			} else {
				String result = String.valueOf(calculate(t));
				sta.push(result);
			}
		}
	}

	private static boolean isNumber(String str){
		for(int i = 0;i < str.length();i ++){
			if(!Character.isDigit(str.charAt(i))){
				return false ;
			}
		}
		return true;
	}
	private int calculate(String s) {
		int c = 0;
		int b = Integer.parseInt(sta.pop());
		int a = Integer.parseInt(sta.pop());
		switch (s) {
		case "+":
			c = a + b;
			break;
		case "-":
			c = a - b;
			break;
		case "*":
			c = a * b;
			break;
		case "/":
			c = a / b;
			break;
		default:
			break;
		}
		return c;
	}

	public String getResult() {
		return sta.pop();
	}
}
