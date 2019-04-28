
public class Checkout {//校验类
	
	private String data;//表达式
    boolean  corr;//合法性
    
    public Checkout(){
    	
    }
    
    public Checkout(String data,boolean corr){
    	this.data = data;
    	this.corr = corr;
    }
 
    public String c1(){//判断非法字符
    	
    	String s1="";
    	if (data.matches(".*([\\!-\\&]|\\,|\\.\\=|[\\:-\\~]).*"))
    	{
    		s1 = "含有非法字符 ";
			corr = false;
    	}
    	return s1;
    }
    
    public String c2(){//判断运算符连续 
    	String s2 = "";
    	if(data.matches(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*")){
    		s2 = "运算符连续 ";
    		corr = false;
    	}
    	return s2;
    }
    
    public String c3(){//判断空括号
    	String s3 = "";
    	if(data.matches(".*\\(\\).*")){
    		s3 = "空括号 ";
    		corr = false;
    	}
    	return s3;
    }
    
    public String c4(){//判断括号)(之间没有运算符
    	String s4 = "";
    	if(data.matches(".*\\)\\(.*")){
    		s4 = "括号)(之间没有运算符 ";
    		corr = false;
    	}
    	return s4;
    }
    
    public String c5(){//判断(后面是运算符 
    	String s5 = "";
    	if(data.matches(".*\\([\\+\\-\\*\\/].*")){
    		s5 = "(后面是运算符 ";
    		corr = false;
    	}
    	return s5;
    }
    
    public String c6(){//判断)前面是运算符 
    	String s6 = "";
    	if(data.matches(".*[+-/]\\).*")){
    		s6 = ")前面是运算符 ";
    		corr = false;
    	}
    	return s6;
    }
    
    public String c7(){//判断(前面不是运算符
    	String s7 ="";
    	if(data.matches(".*[\\d]\\(.*")){
    		s7 = "(前面不是运算符 ";
    		corr = false;
    	}
    	return s7;
    }
    public String c8(){//判断)后面不是运算符
    	String s8 ="";
    	if(data.matches(".*\\)[\\d].*")){
    		s8 = ")后面不是运算符 ";
    		corr = false;
    	}
    	return s8;
    }
    public String c9(){//判断括号不配对 
    	char[] d = data.toCharArray();
    	String s9="";
    	int num1 = 0,num2 = 0;
    	for(int i = 0; i < d.length; i++){
    		if(d[i]=='('){
    			num1 =num1 +1;
    		}
    		if(d[i]==')'){
    			num2 = num2 +1;
    		}
    	}
    	if (num1 != num2){
    		s9 = "括号不配对  ";
    		corr = false;
    	}
    	return s9;
    }
    
    public String c10(){//判断前面有多余运算符
    	String s10 ="";
    	if(data.matches("[\\+\\-\\*\\/](\\(|[\\d]).*")){
    		s10 = "前面有多余运算符 ";
    		corr = false;
    	}
    	return s10;
    }
    
    public String c11(){//判断后面有多余运算符 
    	String s11 ="";
    	if(data.matches(".*(\\)|[\\d])[\\+\\-\\*\\/]")){
    		s11 = "后面有多余运算符 ";
    		corr = false;
    	}
    	return s11;
    }
    
     public void check(){
    	 String s = "";
         s = c1() + c2() + c3() + c4() + c5() + c6() + c7() + c8() + c9() +c10() +c11();//将一个表达式所有错误类型输出
         if (data.length()==0){//判断空字符串
        	 s = "空字符串 ";
        	 corr = false;
         }
         if(s.length()>0){
        	 this.data = s;
         }
     }
     
     public String getdata(){
    	 return data;
     }
     
    public boolean getcorr(){
    	return corr;
    }
   
}
