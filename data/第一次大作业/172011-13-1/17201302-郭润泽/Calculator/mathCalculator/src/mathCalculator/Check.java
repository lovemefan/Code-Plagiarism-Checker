package mathCalculator;

import java.util.regex.Pattern;

public class Check {          //检验类
	private String[] write;       //错误信息
	
	String regEx1 = "[\\*\\/\\+\\-]{2}";     //运算符连续     
	String regEx2 = "\\(\\)";                //空括号
	String regEx3 = "[^\\*\\/\\+\\-]\\(";    //左括号前不是运算符
	String regEx4 = "[\\*\\/\\+\\-]\\)";     //右括号前是运算符
	String regEx5 = "\\([\\*\\/\\+]";        //左括号后是运算符
	String regEx6 = "\\)[^\\*\\/\\+\\-\\)]";  //右括号后不是运算符或者右括号
	String regEx7 = "\\/0";                  //除以0
	String regEx8 = "^[\\*\\/\\+]";          //开头是除-意外运算符
	String regEx9 = "[^\\*\\/\\+\\-\\d\\(\\)]"; //含有非法字符
	String regEx10 = "[\\*\\/\\+\\-\\(]$";   //结尾是(或者运算符
	
	public Check(){            //构造方法
		this.write= new String[2];
	}
	
	public boolean dealPosition(String str){   //位置信息判断
		boolean flag = true ;
		
		if(Pattern.compile(regEx8).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#开头错误";
    		flag = false;
        }
		
		else if(Pattern.compile(regEx10).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#结尾错误";
			flag = false;
        }
		return flag ;
	}
	
	public boolean dealBrac(String str){       //括号相关判断
		boolean flag = true ;
		if(Pattern.compile(regEx2).matcher(str).find()){
			write[0] = "ERROR";
			write[1] = "#空括号";
			flag = false;
		}
		else if(Pattern.compile(regEx3).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#左括号前不是运算符";
			flag = false;
		}
		
        else if(Pattern.compile(regEx4).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#右括号前是运算符";
			flag = false;
        }
		
        else if(Pattern.compile(regEx5).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#左括号后是运算符";
    		flag = false;
        }
		
        else if(Pattern.compile(regEx6).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#右括号后不是运算符";
			flag = false;
        }
        return flag;
	}
	
    public boolean dealChar(String str){ //字符相关判断
    	boolean flag = true ;
        if(Pattern.compile(regEx7).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#除以0";
			flag = false;
        }
		
        else if(Pattern.compile(regEx9).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#非法字符";
			flag = false;
        }
        else if(Pattern.compile(regEx1).matcher(str).find()){
			write[0] = "ERROR";
			write[1] = "#运算符连续";
			flag = false;
		}
		return flag ;
	}
	
	public boolean process(String str){     //判断处理过程
		boolean flag = true;
		if (!checkCount(str)){
			write[0] = "ERROR";
			write[1] = "#括号不匹配";
			flag = false;
		}
		else if(str.equals("")){
			write[0] = "ERROR";
			write[1] = "#空字符串";
			flag = false;
		}
		else if (!dealBrac(str)||!dealPosition(str)||!dealChar(str)){  //如果有不合法则检测失败
			flag = false;
		}
		
		return flag ;
	}
	
	public boolean checkCount(String str){ //括号匹配判断
		boolean flag = true;
		int len = str.length();
		stringStack stack = new stringStack(len);
		for (int i = 0;i < len;i ++){             //(入栈
			if (str.charAt(i)=='('){
				stack.push("(");
			}
			else if(str.charAt(i)==')'){      //)出栈
				if(stack.isEmpty()){       //栈为空则括号不匹配
					flag = false;
					break;
				}
				else{
					stack.pop();
				}
			}
			if(!flag){
				break;
			}
		}
		if(!stack.isEmpty()){       //栈为空则括号匹配
			flag = false;
		}
		return flag ;
	}
	
	public boolean checkStart(String str){          //开头是否为负号
		return Pattern.compile("^\\-").matcher(str).find();
	}
	
	public boolean checkB(String str){            //(后面是否为负号
		return Pattern.compile("\\(\\-").matcher(str).find();
	}
	
	public String[] getWrite(){    //错误信息获取器
		return this.write; 
	}
	
}
