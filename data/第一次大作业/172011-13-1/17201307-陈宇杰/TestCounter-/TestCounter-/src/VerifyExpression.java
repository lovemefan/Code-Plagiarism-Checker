import java.util.regex.*;
public class VerifyExpression{//表达式校验类
	private String str;//传入的表达式
	private boolean f = true;//判断表达式的正确与否
	String s = "";//储存错误信息的字符串
	public VerifyExpression(String str){//构造函数
		this.str = str;
	}
	public  boolean judgeverifyExpression() {//判断表达式是否合法
		
		Space();//去除空格
		str = str.replace("(+","(0+");//加上0
		addZero();//如果符号开头，则加0
 		judge1();
 		judge2(str);
 		judge3();
 		judge4();
 		return getF();//返回f
	}
	public boolean getF(){//获取表达式的true或false
		return f;
	}
public void addZero(){//在以+-开头的表达式前加0预处理
	if(!str.equals("")){
	if(str.charAt(0) == '-'||str.charAt(0) == '+' )
			str = "0"+str;
	}
	

 }
public void Space(){//去除空格的方法
	String s = "[^\\s]";
	String s1 = "";
	Pattern pattern = Pattern.compile(s);
	Matcher matcher = pattern.matcher(str);
	while (matcher.find()){
		s1 += matcher.group();
	}
	str = s1;
}

 public void judge2(String s){//判断是否括号不匹配
	  int top1 = 0;// 计数
	  int top2 = 0;
      char[] biao = s.toCharArray();// 将字符串转化成字符数组
      for (int i = 0; i < biao.length; i++){
          if (biao[i] == '('){//如果是左括号
              top1++;
          }else if (biao[i] == ')'){// 如果是)
        	  top2++;   
              }
          }
      if(top1 !=top2){
    	  f = false;
    	  s = "ERROR\r\n#表达式括号不匹配\r\n";
    	  return;
      }
      	 
      } 

   public void judge4(){//判断（+*/)数字这种模式是否存在
	 String  s1 = "[\\(][\\+\\*\\/][\\d]{1,10}[\\)]";
	 String  s2 = "[\\(][\\d]{1,10}[\\)]";
	 Pattern p1 = Pattern.compile(s1);
	 Matcher m1 = p1.matcher(str);
	  Pattern p2 = Pattern.compile(s2);
	  Matcher m2 = p2.matcher(str);
	  if( m2.find()){
		  f = false;
		  s = "ERROR\r\n#表达式错误\r\n";
		  return;
	  }
	 
	   
   }
 public  void judge1(){//判断开头是否为+*/,0
	 String s1= "[0]{1,10}[0-9]+";
	 Pattern pattern = Pattern.compile(s1);
	 Matcher matcher = pattern.matcher(str);
	if(!str.equals("")){
	 if(str.charAt(0)== '*'||str.charAt(0)== '/'||
			 matcher.find()||str.charAt(str.length() -1) == '+'||str.charAt(str.length() - 1) == '-'||
			 str.charAt(str.length() - 1 )== '*'||str.charAt(str.length() - 1) == '/'){
		 s = "ERROR\r\n#表达式有错误\r\n";
		 f = false;	
		 }
	}
 }
 
 public void judge3(){//判断(后是否是运算符，是返回true,不是返回false
	 String[] s1 = new String[10];
	 s1[0] = "[\\(][\\+\\*\\/]";
	 s1[1] = "[\\+\\-\\*\\/][\\)]";
	 s1[2] = "[\\d]{1,10}[\\(]";
	 s1[3] = "[\\)][\\d]{1,10}";
	 s1[4] = "[\\)][\\(]";
	 s1[5] = "[\\(][\\)]";
	 s1[6] = "[\\+\\-\\*\\/]{2}";
	 s1[7] = "[\\-][\\(][\\d]{1,10}[\\)]";//
	 s1[8]= "[\\/][0]";//除数为0 
	 s1[9] = "[^0-9\\+\\-\\*\\/\\(\\)]";//其他字符
	 for(int i = 0; i <10;i ++){
		 Pattern p =  Pattern.compile(s1[i]);	 
		 Matcher m =  p.matcher(str);
		 if(m.find()){
			 f = false;
			 s = "ERROR\r\n#表达式不合法\r\n";
			 break;
		 }
	 }

 }

 }

