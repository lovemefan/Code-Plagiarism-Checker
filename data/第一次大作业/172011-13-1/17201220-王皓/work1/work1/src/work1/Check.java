package work1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Check {
	private String count=null;
	
	public Check(){
		//[\\S]*[+\\-/*/][*\\-/*/][\\S]*
		//if(s.matchs("[\\S]*[+\\-/*/][+\\-/*/][\\S]*")
		//{    ;  }
		//[\\S]*[(][)][\\S]*
		//[\\S]*[0-9][(][\\S]*
		//[\\S]*[(][+/*/][\\S]
		//[\\S]*[^0-9][)][\\S]*
		//[\\S]*[)][0-9][\\S]*
	}
	
	public Check(String count){
		this.count = count;		
	}
	
//	public boolean judge(String count){
//		if(count.matches("[\\S]*[+\\-/*/][+\\-/*/][\\S]*"){
//			return false;
//		}
		
//	}
	public String judge(String count){//判断表达式是否正确
	 String line = count;
	 String result = "";	
	 String pattern = ("[\\S]*[+\\-/*/]+\\-/*/][\\S]*");
	 String pattern1 = ("[\\S]*[(][)][\\S]*");
	 String pattern2 = ("[\\S]*[0-9][(][\\S]*");
	 String pattern3 = ("[\\S]*[(][+/*/][\\S]*");
	 String pattern4 = ("[\\S]*[(][)][\\S]*");
	 String pattern5 = ("[\\S]*[^0-9][)][\\S]*");
	 String pattern6 = ("[\\S]*[)][0-9][\\S]*");
	 if( line.matches("[\\S]*[+\\-/*/][+\\-/*/][\\S]*")){	 
//		 System.out.println("S");
		 result = "ERROR \n#多个符号连续在一起";		 
		 }
	 if( line.matches("[\\S]*[(][)][\\S]*")){
		 
		 result = "ERROR \n#空括号";		 
		 }
	 if( line.matches(pattern2)){	 
		 result = "ERROR \n#左括号左边为数字";		 
		 }
	 if( line.matches(pattern3)){	 
		 result = "ERROR \n#左括号右边为操作符";		 
		 }
	 if( line.matches(pattern4)){	 
		 result = "ERROR \n#";		 
		 }
	 if( line.matches(pattern5)){	 
		 result = "ERROR \n#右括号左边不为数字";		 
		 }
	 if( line.matches(pattern6)){	 
		 result = "ERROR \n#括号";		 
		 }
	 
	 return result;
	 }
	}
