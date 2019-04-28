import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
	public String exp;// 需要验证的表达式
	public Boolean flag = true;
	public String Error;
	
	// 无参数构造
	public Check(){ 
		
	}
	
    public Check(String exp){
		this.exp = exp;
		this.flag = true;
	}

	// 校验表达式格式是否错误
	public void cheak() {
		String mistake[] = new String[9];
		String error[] = new String[9];
		mistake[0]="";
		error[0] = "ERROR\r\n#空字符串";
		mistake[1] = "[\\+\\-\\*\\/][\\+\\-\\*\\/]";
		error[1] = "ERROR\r\n#运算符连续";
		mistake[2] = "[\\(][\\)]";
		error[2] = "ERROR\r\n#空括号";
		mistake[3] = "[\\(][\\+\\*\\/]";// 不能匹配减号,有可能(后面是负数
		error[3] = "ERROR\r\n#(后是运算符";
		mistake[4] = "[\\+\\-\\*\\/][\\)]";
		error[4] = "ERROR\r\n#)前是运算符";
		mistake[5] = "[0-9][\\(]";// \\)
		error[5] = "ERROR\r\n#(前面不是运算符";
		mistake[6] = "[\\)][0-9]";// \\(
		error[6] = "ERROR\r\n#)后面不是运算符";
		mistake[7] = "[^\\+\\-\\*\\/\\d\\(\\)]";
		error[7] = "ERROR\r\n#表达式内含非法字符";
		mistake[8] = "\\/0";
		error[8] = "ERROR\r\n#除数不能为0";
		if (exp.equals("")) {
			flag = false;
			Error = error[0];
			return;
		}
		for (int i = 1; i < mistake.length; i++) {

			Pattern p = Pattern.compile(mistake[i]);
			Matcher m = p.matcher(exp);

			if (m.find()) {
				flag = false;
				Error = error[i];
				break;
			}
		}
	}
	
	// 判断括号是否匹配
	public void cheak1(){
		int num = 0;
		for(int i = 0;i < exp.length();i ++){
			if(exp.charAt(i) == '('){
				num ++;
			}
			if(exp.charAt(i) == ')'){
				num --;
			}
		}
		if(num != 0){
			flag = false; 
			Error = "ERROR\r\n#括号不匹配";
		}
	}
	
	// 消去表达式的空格符
	public void cancelSpace(){
		String s1 = "[^\\s]";
		String s2 = "";
		Pattern p = Pattern.compile(s1);
		Matcher m = p.matcher(exp);
		while (m.find()){
			s2 += m.group();
		}
		exp = s2;
	}
	
	// 判断数字以0开头
	public void cheakZero(){
		String s = "[0][0-9]";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(exp);
		if (!exp.equals("")){
			if (m.find()||(exp.charAt(0) == '0' && Character.isDigit(exp.charAt(1)))){
				Error = "ERROR\r\n#表达式中含有以0开头的数字";
				flag = false;
			}
		}
		
	}
	
	// 判断首尾运算符是否使用正确
	public void cheakAndEnd(){
		if(exp.charAt(0) == '+' || exp.charAt(0) == '*' || exp.charAt(0) == '/'){
			Error = "ERROR\r\n#表达式运算符使用错误";
			flag = false;
		}
		if (exp.charAt(exp.length() -1) == '+' || exp.charAt(exp.length() - 1) == '-'
				|| exp.charAt(exp.length() - 1 )== '*' || exp.charAt(exp.length() - 1) == '/'){
			Error = "ERROR\r\n#表达式运算符使用错误";
			flag = false;
		}
	}
	
	//判断所有情况
	public Boolean cheakAll(){
		cancelSpace(); // 消去空格符
		cheakZero();// 判断数字以0开头
		if (flag==false){
			return flag;
		}
		if (flag==false){
			return flag;
		}
		cheak();// 校验表达式格式是否错误
		if (flag==false){
			return flag;
		}
		cheak1();// 判断括号是否匹配
		if (flag==false){
			return flag;
		}
	
		cheakAndEnd();// 判断首尾运算符是否使用正确
		return flag;
	}
	
	// 返回错误信息 
	public String errorAll(){
		cheakZero();// 判断数字以0开头
		if (flag==false){
			return Error;
		}
		cheak();// 校验表达式格式是否错误
		if (flag==false){
			return Error;
		}
		cheak1();// 判断括号是否匹配
		if (flag==false){
			return Error;
		}
		cheakAndEnd();// 判断首尾运算符是否使用正确
		return Error;
	}
}
