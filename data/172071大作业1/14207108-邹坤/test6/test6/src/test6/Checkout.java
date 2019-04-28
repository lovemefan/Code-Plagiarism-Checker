package test6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//正则表达式对四则运算进行校验
public class Checkout {
	//记录正则表达式
	private String[] errorKind = new String[11];
	//用来记录错误的信息
	private String[] errorHint = new String[11];
	//firstCounter'用来承接传过来的字符串
	String firstCounter ;
	//flag用来记录字符串的是否正确
	boolean flag  ;
	boolean qqqqqqqqqq;
	
	//构造方法
	public Checkout(){
		
	}
	
	//初始化的构造方法
	public Checkout(String firstCounter){
		this.flag = true;
		this.firstCounter = firstCounter;
		errorInputOrHint();
	}
	
	//初始化输入
	private void errorInputOrHint(){
		errorKind[0] = "[^\\d\\+\\-\\*\\/\\(\\)]";//表达式包含非法字符
		errorKind[1] = "[\\+|\\-|\\*|\\/]{2,}";//运算符连续
		errorKind[2] = "\\(\\)";//表达式中有空括号 
		errorKind[3] = "\\([\\+\\*\\/]";//'('后是运算符
		errorKind[4] = "[\\+|\\-|\\*|\\/]\\)";//')'前是运算符
		errorKind[5] = "[\\d|\\)]\\(";//'('前面是数字或者是')'
		errorKind[6] = "\\)[\\d|\\(]";//')'后面是数字或者是括号'('
		errorKind[7] = "^[^\\d|\\(\\-]";//表达式开端必须是数字,,'('中的一种;
		errorKind[8] = "[^\\d|\\)]$";//表达式结尾必须是数字,')'的一种;
		errorHint[0] = "#表达式包含非法字符";
		errorHint[1] = "#运算符连续";
		errorHint[2] = "#表达式中有空括号";
		errorHint[3] = "#'('后是运算符";
		errorHint[4] = "#')'前是运算符";
		errorHint[5] = "#括号不匹配'";
		errorHint[6] = "#')'后面是数字或者是括号'('";
		errorHint[7] = "#括号非第一个字符且之前无运算数";
		errorHint[8] = "#括号后无运算数，括号非最后一个字符";
		errorHint[9] = "#括号不匹配";
		errorHint[10] = "#空字符串";
	}
	
	//判断比较是那种错误
	public String compare(){
		//temp用来记住是哪种错误
		int temp = errorCount();
		if(temp > -1){
			return errorHint[temp];
		}
		//判断是不是括号不匹配
		else if(bracket() == 9){
			return errorHint[9];
		}
		//判断是不是空字符串
		else if(banking() == 10){
			return errorHint[10];
		}
		//如果没有错误返回正确的表达式
		else {
			return firstCounter;
		}
	}
	
	//判断括号是不是匹配
	private int bracket(){
		int n = 0;
		int temp = -1;
		//遍历整个字符串查找(和)的数量
		for(int i = 0; i < firstCounter.length(); i++){
			//如果是左括号n加一
			if(firstCounter.charAt(i) == '('){
					n++;
			}
			//如果是右括号n减一
			else if(firstCounter.charAt(i) == ')'){
					n--;
			}
			//因为不可能出现n小于一的情况如果出现则括号一定输入有误
			if(n < 0){
				flag = false;
				temp = 9;
				break;
			}
		}
		//如果输入没有错，括号数量错了也是
		if(n != 0){
			flag = false;
			temp = 9;
		}
		return temp;
	}
	
	//除括号匹配，空行错误的其他错误
	private int errorCount(){
		//temp用来记录用正则表达式的错误内容
		int temp = -1;
		for(int i = 0; i < 9;i++ ){
			//正则表达式进行匹配
			Pattern pattern = Pattern.compile(errorKind[i]);
			Matcher matcher = pattern.matcher(firstCounter);
			while(matcher.find()){
				flag = false;
				temp = i;
				break;
			}
			//得到表达式的第一个错误
			if(!flag){
				break;
			}
		}
		return temp;
	}
	
	//空行错误
	private int banking(){
		int j = 0;//用来记录空格的数量
		int temp = -1;
		//遍历整个数组查找空格
		for(int i = 0 ; i < firstCounter.length();i++){
			if(firstCounter.charAt(i) == ' '){
				j++;
			}
		}
		//判断空格的数量是否与该行的字数一样如果是则表达式是空的
		if(j == firstCounter.length()){
			flag = false;
			temp = 10;
		}
	return temp;
		
	}
	
	//获得表达式是否正确
	public boolean getFlag(){
		return flag;
	}
}

