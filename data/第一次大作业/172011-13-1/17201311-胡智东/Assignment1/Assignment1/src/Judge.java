import java.util.regex.*;

public class Judge {
	Suffix suffix;// 用于调取转换后缀方法
	Compute compute;// 用于调取计算后缀的方法
	String[] str;// 文件中的表达式
	String result = "";// 初步处理的结果
	String[] output = new String[1000];// 存放输出信息的结果的数组

	// Judge的构造方法
	public Judge(String[] str) {
		this.str = str;
	}

	// 进行表达式的各类判断以及转换求值
	public void Judge1() {
		for (int i = 0; str[i] != null; i++) {
			if (isEmptyString(str[i])) {
				printWrong(str[i], i, "存在空表达式");
				continue;
			}
			result = str[i].replace(" ", "");
			result = result.replace("\t", "");
			result = firstchar(result);
			if (isrepeated(result, i)) {
				printWrong(str[i], i, "存在重复表达式");
				continue;
			}

			if (isValid(result, i)) {
				result = result.replace("(-", "(0-");// 补0
				result = result.replace("(+", "(0+");
				suffix = new Suffix(result);
				suffix.process();
				compute = new Compute(suffix.post);
				compute.operate();
				printRight(str[i], i, compute.getResult());
			}
		}
	}

	// 判断表达式是否为空行
	public boolean isEmptyString(String str) {
		if (str.matches("^\\s*$")) {
			return true;
		} else {
			return false;
		}
	}

	// 将错误的信息导入output数组中
	public void printWrong(String wrongStr, int index, String wrongInformation) {
		output[index] = wrongStr + "\r\nERROR\r\n#" + wrongInformation;
	}

	// 判断是否有重复的表达式
	public boolean isrepeated(String str1, int index) {
		for (int i = 0; i < index; i++) {
			if (str1.equals(str[i])) {
				return true;
			}
		}
		return false;
	}

	// 采用正则表达式进行表达式判断
	public boolean isValid(String str, int index) {
		if (!bracketsMatch(str)) {// 判断左右括号数量是否匹配
			printWrong(str, index, "左右括号数量不匹配");
			return false;
		}
		String mistakes[] = { "[^0-9\\+\\-\\/\\*\\(\\)]", "(\\(\\))", "(\\(\\*)", "(\\(\\/)",
				"[\\+\\-\\*\\/][\\+\\-\\*\\/]", "(\\+\\))", "(\\-\\))", "(\\*\\))", "(\\/\\))", "[\\d][\\(]",
				"[\\)][\\d]", "[\\+\\-\\*\\/]$" };
		String mistakesNew[] = { "存在错误字符", "存在空括号", "(不能直接与*相连", "(不能直接与/相连", "运算符应与数字相连", "+不能直接与)相连", "-不能直接与)相连",
				"*不能直接与)相连", "/不能直接与)相连", "左括号左边应是运算符", "右括号右边应是运算符", "不能以运算符结尾" };
		for (int i = 0; i < mistakes.length; i++) {
			Pattern p = Pattern.compile(mistakes[i]);
			Matcher m = p.matcher(str);
			if (m.find()) {
				output[index] = str + "\r\nERROR\r\n#" + mistakesNew[i];
				return false;
			}
		}
		return true;
	}

	// 判断左右括号是否匹配
	public boolean bracketsMatch(String str) {
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

	// 将正确的结果导入output数组中
	public void printRight(String str, int index, double result) {
		String temp = str + "=" + result;
		output[index] = temp;
	}

	public String firstchar(String str) {
		if (str.charAt(0) == '-' || str.charAt(0) == '+') {
			str = "0" + str;
		}
		return str;
	}
}
