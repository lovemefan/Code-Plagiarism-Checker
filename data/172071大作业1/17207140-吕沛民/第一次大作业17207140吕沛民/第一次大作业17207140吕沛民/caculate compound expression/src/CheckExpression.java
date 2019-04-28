import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckExpression {
	private String[] errorKind = new String[11];
	private String[] errorMark = new String[11];
	public String expression;
	boolean determine;
	public CheckExpression() {
		
	}
	public CheckExpression(String expression) {
		this.expression = expression;
		this.determine = true;
		errorMarkAndInput();
	}
	public boolean getdetermine() {
		return determine;
	}
	private void errorMarkAndInput() {
		errorKind[0] = "[^\\d\\+\\-\\*\\/\\(\\)]"; 		//表达式含非法字符
		errorKind[1] = "[\\+|\\-|\\*|\\/]{2,}"; 		//运算符连续
		errorKind[2] = "\\(\\)";		//空括号
		errorKind[3] = "\\([\\+\\*\\-\\/]";		 //'('后是运算符
		errorKind[4] = "[\\+|\\-|\\*|\\/]\\)";		//')'前是运算符
		errorKind[5] = "[\\d|\\)]\\("; 		//'('前面是数字或者')'
		errorKind[6] = "\\)[\\d|\\(]";		//')'后面是是数字或者是'('
		errorKind[7] = "^[^\\d|\\(\\-]";		 //表达式 开头必须是数字，'('
		errorKind[8] = "[^\\d|\\)]$";		//表达式结尾必须是数字,')'的一种;
		errorMark[0] = "#表达式含非法字符";
		errorMark[1] = "#运算符连续";
		errorMark[2] = "#空括号";
		errorMark[3] = "#'('后是运算符";
		errorMark[4] = "#')'前是运算符";
		errorMark[5] = "#'('前面是数字或者是')'";
		errorMark[6] = "#')'后面是数字或者是括号'('";
		errorMark[7] = "#表达式开端必须是数,'('中的一种";
		errorMark[8] = "#表达式结尾必须是数字,')'的一种";
		errorMark[9] = "#括号不匹配";
		errorMark[10] = "#空字符串";
		
	}
	private int markError() {	//实现匹配规则和进行匹配
		int flag = -1;
		for(int i =0 ;i<9; i++)
		{	
			Pattern pattern = Pattern.compile(errorKind[i]);
			Matcher matcher = pattern.matcher(expression);
			while(matcher.find())
			{	
				determine = false;
				flag = i;
				break;
			}
			//若是到表达式的一个错误，则退出循环
			if(!determine)  
			{
				break;
			}
		}
		return flag;
	}
	
	private int brackets() {	//查看表达式空格是否匹配
		int flag = -1;
		int k= 0;
		for(int i=0; i<expression.length();i++) 
		{	
			
			if(expression.charAt(i)=='(') {
				k++;
			}
			else if (expression.charAt(i)==')') {
				k--;
			}
		}
			if(k<0) 
			{
				determine = false;
				flag = 9;
				
			}
			if (k!=0) {
				determine = false;
				flag = 9;
				
			}
		
		return flag;
	}
	private int space() { 	//查看表达式是否为空
		int l =0;
		int flag = -1;
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)==' ') {
				l++;
			}
		}
		if(l==expression.length()) {
			determine =false;
			flag = 10;
		}
		return flag;
	}
	public String errorFind() {			//找到表达式错误的类型
		int flag = markError();
		if(flag > -1) {
			
			return errorMark[flag];
		}
		else if(brackets()== 9) {
			return errorMark[9];
		}
		else if(space() == 10) {
			return errorMark[10];
		}
		else
		{
			return expression;
		}
		
	}
}
