import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Judge {
	private String detail = "";
	private int flag = 1;
	
	public Judge() {//有参构造
		detail = "";
		flag = 1;
	}

	private static String brackets(String str) {// 判断左右括号数量
		int n = 0;
		int m = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				n++;
			if (str.charAt(i) == ')')
				m++;
		}
		if (n == m)
			return "bingo";
		else
			return "no";
	}

	public String detail(String str) {//比较是否出现错误及类型
		String strs[] = { ".*(\\+|\\-|\\*|\\/|\\(|\\)|\\d).*", "yes",
				".*(\\+\\+|\\+-|\\+\\*|\\+/|-\\+|--|-\\*|-/|\\*\\+|\\*-|\\*\\*|\\*/|/\\+|/-|/\\*|//).*", ".*(\\(\\)).*",
				".*(/0).*", ".*(\\(\\+|\\(-|\\(\\*|\\(/).*", ".*(\\+\\)|-\\)|\\*\\)|/\\)).*",
				".*(\\d\\(|\\)\\d|\\)\\().*", "(\\+|\\-|\\*|\\/|\\)).*", ".*(\\+|-|\\*|/|\\()" };
		String details[] = { "ERROR\r\n#运算符号含非法字符", "ERROR\r\n#左右括号不匹配", "ERROR\r\n#运算符号相邻", "ERROR\r\n#括号内为空",
				"ERROR\r\n#除数为零", "ERROR\r\n#运算符号前左括号", "ERROR\r\n#运算符号后右括号", "ERROR\r\n#左括号左边接非法或右括号右边接非法",
				"ERROR\r\n#运算符号或右括号在第一位", "ERROR\r\n#运算符号或左括号在最后一位" };
		strs[1]=brackets(str);

		for (int i = 0; i < 10; i++) {
			if(!str.matches(strs[0])){
				this.detail = details[i];
				flag = 0;
				break;
			}else if(strs[1].matches("no")){
				this.detail = details[i];
				flag = 0;
				break;
			}
			else if(i!=0&&str.matches(strs[i])) {
				this.detail = details[i];
				flag = 0;
				break;
			}
		}
		return detail;
	}

	public int getflag() {//返回是否错误
		return this.flag;
	}

}
