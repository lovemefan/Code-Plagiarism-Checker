import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Check {
	public Check() {

	}

	public String check1(String enterString) {
		/*
		 * 初步判断输入的String 如果为空字符串 返回1 如果有除了数字 括号 运算符与空格之外的其他字符 返回2 如果括号不匹配 返回3
		 */
		String Wrong[] = { "true", "空字符串", "有除了数字 括号 运算符与空格之外的其他字符", "括号不匹配", "纯数字 无运算符" };
		char c[] = enterString.toCharArray();
		int len = enterString.length();
		int flagK = 0;// 标记左右括号的对象

		if (enterString.equals("")) {// 空字符
			return Wrong[1];// 空字符错误
		}

		int nums = 0;

		for (int i = 0; i < len; i++) {
			if (enterString.charAt(i) == ' ') {
				continue;
			} else if (enterString.charAt(i) == '(') {
				flagK++;
			} else if (enterString.charAt(i) == ')') {
				flagK--;
			} else if (Character.isDigit(enterString.charAt(i))) {
				nums++;
			} else /* if (!Character.isDigit(c[i])) */ {
				String regEx1 = "[^\\+\\-\\*\\/]";
				Pattern pattern1 = Pattern.compile(regEx1);
				String s = "";
				s += enterString.charAt(i);
				Matcher matcher1 = pattern1.matcher(s);
				boolean b1 = matcher1.find();
				if (b1) {
					return Wrong[2];
				}
			}
		}

		if (nums == len) {
			return Wrong[4];
		}
		if (flagK != 0) {
			return Wrong[3];
		}

		return Wrong[0];
	}

	public String check2(String enterString) {
		/*
		 * 用正则表达式进行8种错误的判断
		 * 
		 */
		String Wrong[] = { "true", "数字后不能有(", "(后不能跟符号", ")后不能跟数字", ")前不能有符号", "()为错", "运算符连续", ")(括号连续", "0不能为除数" };

		String regEx1 = "[0-9]\\(";
		String regEx2 = "\\([\\+|\\-|\\*|\\/]";
		String regEx3 = "\\)[0-9]";
		String regEx4 = "[\\+|\\-|\\*|\\/]\\)";
		String regEx5 = "\\(\\)";
		String regEx6 = "[\\/|\\*|\\-|\\+]{2,}";
		String regEx7 = "\\)\\(";
		String regEx8 = "\\/0";

		Pattern pattern1 = Pattern.compile(regEx1);
		Pattern pattern2 = Pattern.compile(regEx2);
		Pattern pattern3 = Pattern.compile(regEx3);
		Pattern pattern4 = Pattern.compile(regEx4);
		Pattern pattern5 = Pattern.compile(regEx5);
		Pattern pattern6 = Pattern.compile(regEx6);
		Pattern pattern7 = Pattern.compile(regEx7);
		Pattern pattern8 = Pattern.compile(regEx8);
		Matcher matcher1 = pattern1.matcher(enterString);
		Matcher matcher2 = pattern2.matcher(enterString);
		Matcher matcher3 = pattern3.matcher(enterString);
		Matcher matcher4 = pattern4.matcher(enterString);
		Matcher matcher5 = pattern5.matcher(enterString);
		Matcher matcher6 = pattern6.matcher(enterString);
		Matcher matcher7 = pattern7.matcher(enterString);
		Matcher matcher8 = pattern8.matcher(enterString);

		boolean b1 = matcher1.find();
		boolean b2 = matcher2.find();
		boolean b3 = matcher3.find();
		boolean b4 = matcher4.find();
		boolean b5 = matcher5.find();
		boolean b6 = matcher6.find();
		boolean b7 = matcher7.find();
		boolean b8 = matcher8.find();

		if (b1 == true) {
			return Wrong[1];
		} else if (b2 == true) {
			return Wrong[2];
		} else if (b3 == true) {
			return Wrong[3];
		} else if (b4 == true) {
			return Wrong[4];
		} else if (b5 == true) {
			return Wrong[5];
		} else if (b6 == true) {
			return Wrong[6];
		} else if (b7 == true) {
			return Wrong[7];
		} else if (b8 == true) {
			return Wrong[8];
		}

		return Wrong[0];
		// 如果检测通过返回true 在主函数中调用dealMid
	}
	
	private List<String> Flag = new ArrayList<String>();
	
	public void setFlag(List<String> Flag){
		this.Flag=Flag;
	}
	public List<String> getFlag(){
		return Flag;
	}
	
	public int check3(String mid){//检测表达式重复的函数
		for (int j = 0; j < Flag.size(); j++) {
			if (mid.equals(Flag.get(j))) {
				return 1;//表示有语句重复 
			}
		}
		Flag.add(mid);
		return 0;
	}
}
