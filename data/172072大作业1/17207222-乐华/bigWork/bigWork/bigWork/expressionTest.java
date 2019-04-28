package bigWork;

import java.io.File;
import java.util.regex.*;
public class expressionTest {
	int[] errorReminder = new int[10]; //存入错误的表达式编号
	String[] expression;  //存入从文件里取出的表达式；
	expressionTest( FileOperation fo, File f){	 
		this.expression = fo.readLine(f);
	}
	void geterrorReminder(){ //初始化errorReminder数组；
		for(int i=0;i<errorReminder.length;i++) {
			errorReminder[i]=100;
		}
	}
	String[] getError(FileOperation fo) {  //判断表达式错误
		String[] ss =new String[this.expression.length];
		for(int i=0;i<fo.numberLine;i++) {
			String s = this.expression[i];
			if(s.length()==0 || s.matches("[\\s]*")) {
				ss[i]="#表达式为空";
				errorReminder[i] = i;
			}
			if(s.indexOf("()")!=-1) {
				ss[i] = "#表达式中有空括号";
				errorReminder[i] = i;
			}
			if(!s.matches("[0-9[+][-][*][/][(][)]]*")) {
				ss[i] = "#表达式包含非法字符";
				errorReminder[i] = i;
			}
			if(notMatch(s)==1){
				ss[i] = "#括号不匹配";
				errorReminder[i] = i; 
			 }
			if(s.matches(".*((\\+|-|\\*|/)\\s*){2,}.*")){
				ss[i] = "#运算符连续";
				errorReminder[i] = i;
			}
		
			if(error1(s,i)!="NULL")
				ss[i]=error1(s,i);
		}
		return ss;
	}
	int notMatch(String s){ 	//判断表达式括号不匹配
	int k=0,k1=0;
		for(int j=0;j<s.length();j++) {
			if(s.charAt(j) == ')')
				k1++;
			if(s.charAt(j) == '(')
				k++;
			if(k < k1) {
				return 1;
			}
			if(j == s.length()-1 && k!=k1) {
				return 1;
			}	
     	}
		return 0;
	}
	String error1(String s,int i){ //判断表达式括号和运算符间的错误
		String ss="NULL";
		if(s.matches("[[+][-][*][/]][0-9][0-9[+][-][*][/][(][)]]*") || s.matches("[0-9[+][-][*][/][(][)]]*[(][[+][-][*][/]][0-9[+][-][*][/][(][)]]*")) {
			ss= "#运算符前无运算数";
			errorReminder[i] = i;
			return ss;
		}
		if(s.matches("[0-9[+][-][*][/][(][)]]*[0-9][[+][-][*][/]]") || s.matches("[0-9[+][-][*][/][(][)]]*[[+][-][*][/]][)][0-9[+][-][*][/][(][)]]*")) {
			ss = "#运算符后无运算数";
			errorReminder[i] = i;
			return ss;
		}
		if(s.matches("[[+][-][*][/]][(][0-9[+][-][*][/][(][)]]*")) {
			ss = "#括号非第一个字符且之前无运算数";
			errorReminder[i] = i;
			return ss;
		}
		if(s.matches("[0-9[+][-][*][/][(][)]]*[)][[+][-][*][/]]")) {
			ss = "#小括号后无运算数、括号非最后一个字符";
			errorReminder[i] = i;
			return ss;
		}
		return ss;
	}
}
