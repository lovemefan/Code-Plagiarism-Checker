
public class panDuan {
	String s ;
	
	public void setError(String g){
		
		s= g;
	}
	
	public String getError(){
		
		return s;
	}
	
	//利用正则表达式对输入的式子判断	
	
	public boolean judge1(String s){

		boolean m1= s.matches("[0-9\\+\\-\\(\\)\\*\\/]*");//判断字符串只能由四则运算符号，数字，左右括号组
		boolean m2= s.matches("(.*)[0-9]\\((.*)");//缺少操作符：左括号左边缺少操作符
		boolean m3= s.matches("(.*)\\)[0-9](.*)");//缺少操作符：右括号右边缺少操作符
		boolean m4= s.matches("(.*)\\([\\*+-/](.*)");//缺少操作数：左括号右边缺少操作数
		boolean m5= s.matches("(.*)[\\*+-/]\\)(.*)");//缺少操作数：右括号左边缺少操作数
		boolean m6= s.matches("(.*)\\(\\)(.*)");//空括号：括号内无表达式
		boolean m7= s.matches("(.*)[\\*+-/][\\*+-/](.*)");//运算符缺少操作数
		boolean m8= s.matches("(.*)\\/0(.*)");//除数为0


 
		if(m1 == false){
			 String q ="	#字符串只能由四则运算符号，数字，左右括号组";
			 setError(q);
			 return false;
		}
		else if(m2){
			 String q ="	#缺少操作符：左括号左边缺少操作符";
			 setError(q);
			 return false;
		}
		else if(m3){
			String q ="		#缺少操作符：右括号右边缺少操作符";
			setError(q);
			return  false;
		}
		else if(m4){
			String q ="		#缺少操作数：左括号右边缺少操作数";
			setError(q);
			return false;
		}	
		else if(m5){
			String q ="		#缺少操作数：右括号左边缺少操作数";
			setError(q);
			return false;		
		}
		else if(m6){
			 String q ="	#空括号：括号内无表达式";
			 setError(q);
			 return false;
		}
		else if(m7){
			 String q ="	#运算符缺少操作数";
			 setError(q);
			 return false;
		}
		else if(m8){
			 String q ="	#除数为0";
			 setError(q);
			 return false;
		}


		else
			return true;
	}


	public boolean judge2(String s){
		char first=s.charAt(0);

		if(first =='+' || first =='-'|| first =='*'|| first =='/'|| first =='（'){
			 String q ="	#首字符出现运算符";
			 setError(q);
			 return false;
		}
		
		else
			return true;
	}
	
	public boolean judge3(String s){
		char end=s.charAt(s.length()-1);
	 if(end =='+' || end =='-'|| end =='*'|| end =='/' || end =='）'){
			 String q ="	#尾字符出现运算符";
			 setError(q);
			 return false;
		}
	else
		return true;
	}
	
	public boolean judge4(String s){
        int top = 0;// 计数，左括号 1，右括号 -1，最后总和0则匹配
        boolean end = true;// true 表示匹配


        char[] biao = s.toCharArray();// 将字符串转化成字符数组


        // 遍历表达式中所有字符
        for (int i = 0; i < biao.length; i++){
            // 如果是(则加1，进栈
            if (biao[i] == '('){
                top++;
            }else if (biao[i] == ')'){// 如果是)则-1，出栈 
                if (!(top == 0)){
                    top--;
                }

                else {//top == 0,无左括号却有一个右括号，有一个右括号不匹配
                    System.out.println("括号不匹配 - -");
                    end = false;
                    return false;
                }
            }
        } 

        // 循环结束时两种可能
         if (top != 0 && end){
			 String q ="	#左右括号组不匹配";
			 setError(q);
        	return false;// 出循环时stack不空
         }
         else
            return true;
    }

	
	
}
