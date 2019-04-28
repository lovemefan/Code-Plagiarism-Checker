package FourOperation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 该类进行表达式检错
 */
public class MyException{
	//定义这些是需要匹配的运算符
	private char[] ch = {'(',')','+','-','*','/'};
	/**
	 * 无参构造方法
	 */
	MyException() {}
	/**
	 * 进行表达式的合理性检验
	 * @param bufWrite
	 * @param expression
	 * @return boolean
	 */
	public boolean expressionIsReasonable(BufferedWriter bufWrite,String expression) {
		try{
			//利用正则表达式判断表达式的合理性
			if(!zhengze(bufWrite,expression))
				return false;
			//判断括号是否匹配
			if(!brackets(bufWrite,expression))
				return false;
			//无错返回true
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return true;
	}	
	/**
	 * 判断括号是否合理匹配
	 * @param bufWrite
	 * @param expression
	 * @return boolean
	 */
	private boolean brackets(BufferedWriter bufWrite,String expression){
		try{
			int length = expression.length();
			
			//flag是左括号标记，mark是右括号标记
			int flag = 0,mark = 0;
			
			for(int i = 0;i < length; i++) {
				
				if(!Error3(bufWrite,expression,expression.charAt(i)))
					return false;
							
				if(expression.charAt(i) == ch[0]) {
					flag++;//左括号标记+1
				}
				//出现右括号之前没有出现左括号，错误
				if(expression.charAt(i) == ch[1]&&flag == 0) {
					bufWrite.write("ERROR\n#括号不匹配\n");
					return false;
				}
				else {
					if(expression.charAt(i) == ch[1]){
						mark++;//右括号标记+1
					}
				}
				//左括号比右括号少，也是错误的
				if(flag < mark) {
					bufWrite.write("ERROR\n#括号不匹配\n");
					return false;
				}
			}
			//左右括号数目不匹配，说明右括号落了一个，出错
			if(flag != mark) {
				bufWrite.write("ERROR\n#括号不匹配\n");
				return false;
			}
			return true;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 正则表达式判断表达式合理性
	 * @param bufWrite
	 * @param expression
	 * @return
	 */
	private boolean zhengze(BufferedWriter bufWrite,String expression){
		try{
			//判断表达式是否为空，为空返回false
			if(!isEmpty(bufWrite,expression))
				return false;
	
			//空括号
			if(expression.indexOf("()") != -1) {
				bufWrite.write("ERROR\n#表达式中有空括号\n");
				return false;
			}
			//包含非法字符
			if(!expression.matches("[\\d[(][)][+][-][*][/]]*")){
				bufWrite.write("ERROR\n#表达式包含非法字符\n");
				return false;
			}
			//括号非第一个字符且之前无运算数
			if(!expression.matches("[\\d[(]][\\d[(][)][+][-][*][/]]*")) {
				bufWrite.write("ERROR\n#括号非第一个字符且之前无运算数\n");
				return false;
			}
			//判断表达式是否为"运算符连续"错误
			if(!Error2(bufWrite,expression))
				return false;
			//判断表达式是否为"小括号后无运算数，括号非最后一个字符"错误
			if(!Error1(bufWrite,expression))
				return false;			
			//运算符后无运算数
			if(expression.matches("[\\d[(][)][+][-][*][/]]*[[+][-][*][/][(]]")) {
				bufWrite.write("ERROR\n#运算符后无运算数\n");	
				return false;
			}
			return true;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return true;		
	}
	/**
	 * 获取文件路径，传入表达式，判断表达式是否为空
	 * @param bufWrite
	 * @param expression
	 * @return
	 */
	private boolean isEmpty(BufferedWriter bufWrite,String expression){
		try{
			//表达式为空
			if(expression.isEmpty()) {
				bufWrite.write("ERROR\n#表达式为空\n");
				return false;
			}
			//表达式为空格组成
			if(expression.matches("[\\s]+")) {
				bufWrite.write("ERROR\n#表达式为空\n");
				return false;
			}
			return true;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * 判断表达式是否是“小括号后无运算数，括号非最后一个字符”错误
	 * @param bufWrite
	 * @param expression
	 * @return boolean
	 */
	private boolean Error1(BufferedWriter bufWrite,String expression){
		try{
			//小括号后无运算数，括号非最后一个字符
			if(!expression.matches("[\\d[(][)][+][-][*][/]]*[\\d[)]]")) {
				bufWrite.write("ERROR\n#小括号后无运算数，括号非最后一个字符\n");
				return false;
			}
			//小括号后无运算数，括号非最后一个字符
			if(expression.matches("[\\d[(][)][+][-][*][/]]*[(][[+][-][*][/]][\\d[(][)][+][-][*][/]]*")) {
				bufWrite.write("ERROR\n#小括号后无运算数，括号非最后一个字符\n");
				return false;
			}
			return true;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * 判断表达式是否是“运算符连续”错误
	 * @param bufWrite
	 * @param expression
	 * @return boolean
	 */
	private boolean Error2(BufferedWriter bufWrite,String expression){
		try{
			//运算符连续
			if(expression.matches("[\\d[(][)][+][-][*][/]]*[[+][-][*][/]][)][\\d[(][)][+][-][*][/]]*")) {
				bufWrite.write("ERROR\n#运算符连续\n");
				return false;
			}
			//运算符连续
			if(expression.matches("[\\d[(][)][+][-][*][/]]*[[+][-][*][/]]{2}[\\d[(][)][+][-][*][/]]*")) {
				bufWrite.write("ERROR\n#运算符连续\n");	
				return false;
			}
			return true;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * 判断表达式是否是“运算符前无运算数”错误
	 * @param bufWrite
	 * @param expression
	 * @param optr
	 * @return boolean
	 */
	private boolean Error3(BufferedWriter bufWrite,String expression,char optr){
		int num = 0;
		try{
			for(int j = 0;j < 6; j++) {
				//若发现当前位不是数字，退出
				if(optr == ch[j])
					break;
				else//找出数字
					num = 1;								
			}
			//判断当前位是不是+-*/左右括号与运算符连续没影响
			for(int j = 2;j < 6; j++) {
				//当前位为运算符
				if(optr == ch[j]){
					//如果之前有出现数字
					if(num == 1)
						break;
					else {
						bufWrite.write("ERROR\n#运算符前无运算数\n");
						return false;
					}
				}
			}
			return true;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * 传入需要被查重的表达式，传入查重列表，传入被查重表达式在列表的当前位置
	 * @param expression
	 * @param exp
	 * @param i
	 * @return boolean
	 */
	public boolean isrepeat(String expression,ArrayList<String> exp,int i){
		for(int j = 0;j < i;j++) {
			if(expression.equals(exp.get(j)))
				return true;
		}
		return false;
	}
}
