import java.util.regex.*;

public class Check {
	stack a = new stack();
	String[] str;// 原表达式
	String result = "";// 结果
	Shep stack = new Shep();// 生成栈模型
	String[] output = new String[500];// 输出的信息
	public Check(String[] str) {
		this.str = str;
	}

	public void Judge() {
		for (int i = 0; str[i] != null; i++) {
			if (EmptyString(str[i])) {
				Wrong(str[i], i, "不能为空表达式!");
				continue;
			}         
			result = str[i].replace(" ", "");
			result = result.replace("\t", "");
			result = firstchar(result);
			if (repeated(result, i)) {
				Wrong(str[i], i, "不能为重复表达式!");
				continue;
			}

			if(isValid(result,i)){
				result = result.replace("(-", "(0-");//补0
				result = result.replace("(+", "(0+");
				Right(str[i],i,a.evaluateExpression(result));
			}
		}
	}

	public boolean EmptyString(String str) {
		if (str.matches("^\\s*$")) {
			return true;
		} else {
			return false;
		}
	}

	public  void Wrong(String wrongStr, int index, String wrongInformation) {
		output[index] = wrongStr + "\r\nERROR\r\n#" + wrongInformation;
	}

	public boolean repeated(String str1, int index) {
		for (int i = 0; i < index; i++) {
			if (str1.equals(str[i])) {
				return true;
			}
		}
		return false;
	}

	public boolean isValid(String str, int index) {
		if (!isNumberOfBracketRight(str)) {// 判断左右括号数量是否匹配
			Wrong(str, index, "左右括号数量不匹配!");
			return false;
		} 
		String errors[] = { "[^0-9\\+\\-\\/\\*\\(\\)]", "(\\(\\))", "(\\(\\*)", "(\\(\\/)",
				"[\\+\\-\\*\\/][\\+\\-\\*\\/]", "(\\+\\))", "(\\-\\))", "(\\*\\))", "(\\/\\))", "[\\d][\\(]",
				"[\\)][\\d]", "[\\+\\-\\*\\/]$", };
		String errorsName[] = { "不能为非法字符!", "括号内不能什么都没有!", "不能存在(*!", "不能存在(/!", "不能存在连续运算符!", "不能存在+)!", "不能存在-)!", "不能存在*)!", "不能存在/)!",
				"左括号左边不能有数字!", "右括号右边不能有数字!", "结尾不能为运算符!", };
		for (int i = 0; i < errors.length; i++) {
			Pattern p = Pattern.compile(errors[i]);
			Matcher m = p.matcher(str);
			if (m.find()) {
				output[index] = str + "\r\nERROR\r\n#" + errorsName[i];
				return false;
			}
		}
		return true;
	}

	// 判断左右括号数量是否匹配
	public boolean isNumberOfBracketRight(String str) {
		int number = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				number++;
			} else if (str.charAt(i) == ')') {
				number--;
			}
		}
		if (number == 0) {
			return true;
		} else
			return false;
	}
	public void Right(String str,int index,double result){
		String temp = str + "="+ result; 
		output[index] = temp;
	}
	public String firstchar(String str){
		if(str.charAt(0)=='-'||str.charAt(0)=='+'){
			str = "0"+str;
		}
		return str;
	}
}