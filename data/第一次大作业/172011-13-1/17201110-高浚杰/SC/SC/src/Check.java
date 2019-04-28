import java.util.regex.Pattern;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;

public class Check {
   private String str;

	public void check(String str) {
		String p1 = "[\\S]*[)][0-9][\\S]*";
		Pattern pater1 = Pattern.compile(p1);// )右边是数字
		Matcher m1 = pater1.matcher(str);
		if (m1.find()) {
			this.str = str + "\r\nERROR\r\n#)右边是数字";
		}
		String p2 = "[\\S]*[0-9][(][\\S]*";
		Pattern pater2 = Pattern.compile(p2);// (左边是数字
		Matcher m2 = pater2.matcher(str);
	    if (m2.find()) {
			this.str = str + "\r\nERROR\r\n#(左边是数字";
		}
		String p3 = "[\\S]*[(][)][\\S]*";
		Pattern pater3 = Pattern.compile(p3);// 空括号
		Matcher m3 = pater3.matcher(str);
		if (m3.find()) {
			this.str = str + "\r\nERROR\r\n#空括号";
		}
		String p4 = "[\\S]*[+-/*/]{2,}[\\S]*";
		Pattern pater4 = Pattern.compile(p4);// 运算符连续
		Matcher m4 = pater4.matcher(str);
		if (m4.find()) {
			this.str = str + "\r\nERROR\r\n#运算符连续";
		}
		String p5 = ("[^\\d\\+\\-\\*\\/\\(\\)]");
		Pattern pater5 = Pattern.compile(p5);// 非法字符
		Matcher m5 = pater5.matcher(str);
		if (m5.find()) {
			this.str = str + "\r\nERROR\r\n#非法字符";
		}
		String p6 = ("^$");
		Pattern pater6 = Pattern.compile(p6);// 空字符串
		Matcher m6 = pater6.matcher(str);
		if (m6.find()) {
			this.str = str + "\r\nERROR\r\n#空字符串";
		}
		String p7 = "[\\S]*[+-/*/][)][\\S]*";
		Pattern pater7 = Pattern.compile(p7);// )左边为运算符
		Matcher m7 = pater7.matcher(str);
		if (m7.find()) {
			this.str = str + "\r\nERROR\r\n#)左边为运算符";
		}
		String p8 = "[\\S]*[(][+-/*/][\\S]*";
		Pattern pater8 = Pattern.compile(p8);// (右边为运算符
		Matcher m8 = pater8.matcher(str);
		if (m8.find()) {
			this.str = str + "\r\nERROR\r\n#(右边为运算符";
		}
		String p9 = "^[+-/*/]|[+-/*/]$";
		Pattern pater9 = Pattern.compile(p9);// 首尾是运算符
		Matcher m9 = pater9.matcher(str);
		if (m9.find()) {
			this.str = str + "\r\nERROR\r\n#首尾是运算符";
		}
		String p10 = "[[(]|[)]{2,}[[(]|[)]{4,}]]";
		Pattern pater10 = Pattern.compile(p10);// 括号不匹配
		Matcher m10 = pater10.matcher(str);
		if (m10.find()) {
			this.str = str + "\r\nERROR\r\n#括号不匹配";
		}
		 
	}

    public String getStr(){
    	return str;
    }
    
    public void setStr(String str){
    	this.str = str;
    }
    
  //删除相同的表达式
  	public static String[] delete(String[] str) {
  		List<String> list = new LinkedList<String>();
  		for (int i = 0; i < str.length; i++) {
  			if (!list.contains(str[i])) {
  				list.add(str[i]);
  			}
  		}
  		String[] newStr = list.toArray(new String[list.size()]);
  		return newStr;
  	}
}

