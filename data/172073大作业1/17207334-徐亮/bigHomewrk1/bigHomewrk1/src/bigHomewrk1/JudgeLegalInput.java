package bigHomewrk1;

public class JudgeLegalInput{
	
	private boolean legal = true;
	private String result;
	private String expression;

	JudgeLegalInput(String expression){
		this.expression = expression;
		result = getJudge();
	}
	private void setLegal(boolean legal) {
		this.legal = legal;
	}
	public boolean getLegal() {
		return legal;
	}

	public String getResult() {
		return result;
	}
	public String getJudge() {
		
		if(expression.length() == 0) {	//判断表达式是否为空
			setLegal(false);
			return "#表达式为空";
		}
		if(expression.matches(".*\\(\\).*")) {	//判断括号是否为空 true为空
			setLegal(false);
			return "#表达式中有空括号";
		}
		if(!expression.matches("[\\d\\(\\)\\*\\-\\+/ \\.]+")) {	//判断是否包合法字符
			setLegal(false);
			return "#表达式包含非法字符";
		}
		if(expression.matches(".*[\\-\\+/\\*][\\*\\+\\-/].*")) {	//判断两个操作符连续
			setLegal(false);
			return  "#运算符连续";
		}
		if(expression.matches("([\\*\\+\\-/]|.*[\\(\\.][*+/]).*")) {	//运算符前无运算数
			setLegal(false);
			return "#运算符前无运算数";
		}
		if(expression.matches(".*[*+-/][\\.\\)].*")) {	//判断运算符后无运算数
			setLegal(false);
			return "#运算符后无运算数";
		}
		if(expression.matches(".*[^\\+\\-\\*\\/ \\(]\\(.*")) {	//判断左括号前有无运算符
			setLegal(false);
			return "#括号非第一个字符且之前无运算符";
		}
		if(expression.matches(".*\\)[^\\+\\-\\*\\/ \\)].*")) {	//判断右括号后有无运算符
			setLegal(false);
			return "#小括号后无运算符，括号非最后一个字符";
		}
		
		int left = 0;
		int leftIndex = 0;
		int right = 0;
		int rightIndex = 0;
		for(int i=0; i<expression.length();i++) {
			if(expression.charAt(i) == '(') {
				left++;
				leftIndex = leftIndex+i; 
			}else if(expression.charAt(i) == ')'){
					right++;
					rightIndex = rightIndex+i;
			}
		}
		if(left != right || leftIndex > rightIndex) {	//判断括号是否匹配
			setLegal(false);
			return "#括号不匹配";
		}
		return "";
	}
}
