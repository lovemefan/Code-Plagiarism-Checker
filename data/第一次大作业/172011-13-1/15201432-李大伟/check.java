import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class check {
	public String str; 
	public check(){
		
	}
	public check(String str){
		this.str = str;
	}
	
	public boolean checking(){
		
		String pattern = "\\(\\-";//检测表达式中是否含有“（-”的格式
		String th = "(0-";//为修改负数格式错误准备
		
		Pattern r = Pattern.compile(pattern);// 创建 Pattern 对象

	
		Matcher m = r.matcher(str);	// 现在创建 matcher 对象
		if (m.find()) {
			System.out.println("Found value: " + m.find() );
			
			str = m.replaceAll(th);//将所有“（-”替换成“（0-”格式
			System.out.println("replace:" + str );
			return true;
			
		} else {
			System.out.println("Found value:" + m.find());
			return false;
		}
		

	

	}	
		
}
	

