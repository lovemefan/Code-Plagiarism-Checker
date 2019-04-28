import java.util.regex.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Regular {
	private String str;

	public String[] getString(String str) {
		str = str.replaceAll(" ", "");
		String[] s = str.split("\\n");
		List<String> list = Arrays.asList(s); //数组转集合
		List<String> arrayList=new ArrayList<String>(list);
		for (int i = 0; i < s.length; i++) { //删除重复字符串
			for (int j = i + 1; j < s.length; j++) {
				if (s[i].equals(s[j])) {
					arrayList.remove(s[j]);
				}
			}
		}
		String[] array = arrayList.toArray(new String[0]);
		return array;
	}

	public String[] dealString(String[] str) {
		for (int i = 0; i < str.length; i++) {
			if (str[i].isEmpty()) {
				str[i] += "\r\nERROR\r\n#空字符串\r\n";
			} else {
				str[i] = process(str[i]);
			}
			if (str[i].contains("E") == false) { // 如果process方法处理后表达式没有错误，再对括号匹配检测
				str[i] = process2(str[i]);
			}

		}
		return str;
	}

	public String process(String str) {
		Matcher m = Pattern.compile("[^\\d\\+\\-\\*\\/\\(\\)]").matcher(str);
		if (m.find()) {
			str += "\r\nERROR\r\n#非法字符\r\n";
			return str;
		}
		m = Pattern.compile("[\\+\\-\\*\\/]{2,}").matcher(str);
		if (m.find()) {
			str += "\r\nERROR\r\n#运算符连续\r\n";
			return str;
		}
		m = Pattern.compile("(\\(\\))").matcher(str);
		if (m.find()) {
			str += "\r\nERROR\r\n#空括号\r\n";
			return str;
		}
		m = Pattern.compile("[\\+\\-\\*\\/]\\)").matcher(str);
		if (m.find()) {
			str += "\r\nERROR\r\n#)前面是运算符\r\n";
			return str;
		}
		m = Pattern.compile("\\([\\+\\-\\*\\/]").matcher(str);
		if (m.find()) {
			str += "\r\nERROR\r\n#(后面是运算符\r\n";
			return str;
		}
		m = Pattern.compile("[^\\+\\-\\*\\/\\(]\\(").matcher(str);
		if (m.find()) {
			str += "\r\nERROR\r\n#(前面不是运算符\r\n";
			return str;
		}
		m = Pattern.compile("\\)[^\\+\\-\\*\\/\\)]").matcher(str);
		if (m.find()) {
			str += "\r\nERROR\r\n#)后面不是运算符\r\n";
			return str;
		}
		return str;
	}

	public String process2(String str) {
		if (str.contains("(") || str.contains(")")) {
			Matcher m = Pattern.compile("\\(.*\\)").matcher(str);
			String temp = "|" + str + "|";
			int count1 = temp.split("\\(").length - 1;
			int count2 = temp.split("\\)").length - 1;
			if (m.find() == false || count1 != count2) { // 左括号个数不等于右括号个数
				str += "\r\nERROR\r\n#括号不配对\r\n";
				return str;
			}
		}
		return str;
	}

	public String getRegular() {
		return str;
	}

	public void setRegular(String str) {
		this.str = str;
	}

}
