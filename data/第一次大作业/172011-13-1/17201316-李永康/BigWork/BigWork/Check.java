package BigWork;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Check {
	private static String[] old;//定义一个私有属性数组存放表达式
	boolean flag = true;//判断表达式的对错
	String[] mistake = new String[12];
	String[] matchers = new String[14];
	//空的构造函数
	Check(){
		
	}
	//构造函数（含参）
	Check(String[] old){
		this.old = old;
	}
	//匹配表达式对应的错误
	private void match(){
		mistake[0] = "[\\(][\\+|\\-|\\*|\\/]";
		matchers[0] = "左括号后为运算符";
		mistake[1] = "[\\+|\\-|\\*|\\/][\\)]";
		matchers[1] = "右括号前为运算符";
		mistake[2] = "[\\d][\\(]";
		matchers[2] = "左括号前不是运算符或括号";//
		mistake[3] = "[\\)][\\d]";
		matchers[3] = "右括号后不是运算符或括号";//
		mistake[4] = "[^\\+|\\-|\\/|\\*|\\(|\\)|\\d]";
		matchers[4] = "运算符异常";
		mistake[5] = "[\\+|\\-|\\*|\\/][\\+|\\-|\\*|\\/]";
		matchers[5] = "运算符叠加";
		mistake[6] = "[\\(][\\)]";
		matchers[6] = "括号里为空";
		mistake[7] = "^[\\+|\\*|\\/]";
		matchers[7] = "字符首为运算符";
		mistake[8] = "[\\+|\\*|\\/|\\-]$";
		matchers[8] = "字符末为运算符";
		mistake[9] = "[\\)][\\(]";
		matchers[9] = "左右括号间无运算符";
		mistake[10] = "(\\(\\d{1,}\\))";
		matchers[10] = "括号内不能为正数";
		mistake[11] = "[\\+|\\-|\\/|\\*|\\(][0{1,}][\\d{1,}]";
		matchers[11] = "数字不能以零开头";
		matchers[12] = "空字符串";
		matchers[13] = "括号不匹配";
	}
	//将信息输入一个字符串数组
	public String[] checked(String[] old){
		match();
		for(int i = 0;i < old.length;i ++){
			flag = true;
			old[i] = old[i].replaceAll(" ", "");
			old[i] = old[i].replace("(-","(0-");
			//对负数进行处理
			old[i] = minus1(old[i]);
			//old[i] = minus2(old[i]);
			int number = check(old[i]);
			if(flag == false){
				old[i] = "ERROR\r\n#" + matchers[number];
			}
		}
		return old;
	}
	//对表达式进行判断并标记
	private int check(String a){
		int num = 0;
		for( ;num < 12;num ++){
			Pattern pattern = Pattern.compile(mistake[num]);
			Matcher matcher = pattern.matcher(a);
			if(matcher.find()){
				flag = false;
				break;
			}
		}
		num = check1(a,num);
		num = check2(a,num);
		return num;
	}
	//判断是否为空字符串
	private int check1(String a,int num){
		if(flag == false){
			return num;
		}
		else if(a == null){
			flag = false;
			num = 12;
		}
		return num;
	}
	//判断括号是否匹配
	private int check2(String a,int b){
		if(flag == false){
			return b;
		}
		else{
			int num = 0;
			for(int j = 0;j < a.length();j ++){
				if(a.charAt(j) == '('){
					num ++;
				}
				else if(a.charAt(j) == ')'){
					num --;
				}
				if(num < 0){
					flag = false;
				}
			}
			if(num != 0){
				flag = false;
				b = 13;
			}
		}
		return b;
	}
	//对负数进行处理
	private String minus1(String a){
		Pattern pattern = Pattern.compile("^[\\-]");
		Matcher matcher = pattern.matcher(a);
		StringBuilder sb = new StringBuilder(a);
		if(matcher.find()){
			 sb.insert(0,"0");
			 a = sb.toString();
		}
		return a;
	}
	//对负数进行处理
	/*private String minus2(String a){
		Pattern pattern = Pattern.compile("(.*)(\\(\\-\\d{1,}\\))(.*)");
		Matcher matcher = pattern.matcher(a);
		StringBuilder sb = new StringBuilder(a);
		if(matcher.find()){
			 MatchResult result = matcher.toMatchResult();
			 for(int i = 1;i <= result.groupCount();i ++){
				 sb.insert(result.start(i) + 1-i,"0");
			 }
			 a = sb.toString();
		}  
		return a;
	}*/
}