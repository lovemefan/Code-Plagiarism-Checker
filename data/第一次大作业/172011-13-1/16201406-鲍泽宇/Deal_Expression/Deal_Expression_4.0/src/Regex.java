import java.util.regex.Pattern;

public class Regex {
	
	public int a=-1;
	public boolean x=false;
	
	
	public Regex() {
		
	}
	
	//字符串进入方法
	public void check(String str) {
		
		boolean m1 = Pattern.matches(".*[\\+\\-\\*\\/]\\).*",str);
		boolean m2 = Pattern.matches(".*[^\\+\\-\\*\\/]\\(.*", str);
		boolean m3 = Pattern.matches(".*\\)[^\\+\\-\\*\\/].*", str);
		boolean m4 = Pattern.matches(".*\\(\\).*", str);
		boolean m5 = Pattern.matches(".*\\([\\+\\*\\/].*",str);
		boolean m6 = Pattern.matches(".*[\\+\\-\\*\\/]{2,}.*", str); 
		boolean m7 = Pattern.matches(".*[^\\+\\-\\*\\/\\d+\\(\\)\\s].*", str);
		boolean m8 = Pattern.matches(".*\\/0.*", str);
		boolean m9 = Pattern.matches(".*\\(\\-\\d+.*", str);//中间负号情况
		boolean m10 = str.charAt(0)=='-';//头负号情况
		boolean m11 = Pattern.matches(".*0\\d+[\\+\\-\\*\\/\\)].*", str);
		boolean m12 = 
		str.endsWith("-")||str.endsWith("+")||str.endsWith("*")||str.endsWith("/")||str.endsWith("(");//结尾判断
		boolean m13 = judge(str);
		boolean m14 = str.charAt(0)=='+'||str.charAt(0)=='*'||str.charAt(0)=='/'||str.charAt(0)==')';//头字符处理
	
		
		
		//对负号进行处理，以进行负数运算
        if(m10) {
        	this.a =10;			
		}        
        if(m9) {
			this.a =9;
		}     
        if(m10&&m9) {
        	this.a =12;
        }
        
        //逐个判断,防止非法字符进入运算

		if(m1) {
			this.a =1;
		}		
		if(m2) {
			this.a =2;
		}		
		if(m3) {
			this.a =3;
		}		
		if(m4) {
			this.a =4;
		}
		if(m5) {
			this.a =5;
		}
		if(m6) {
			this.a =6;
		}	
		if(m7) {
			this.a =7;
		}
		if(m8) {
			this.a =8;
		}		
		if(m11) {
			this.a =11;
		}		
		if(m12) {
			this.a =13;
		}
		if(m13) {
			this.a =14;	
			this.x =false;
		}
		if(m14) {
			this.a =15;
		}
				
	}
	
	public boolean judge(String str) {
		
		int num =0;
		boolean t = false;
		
		for(int i =0;i < str.length();i++) {						
			if(str.charAt(i)=='(') {
				num++;
			}
			if(str.charAt(i) ==')') {
				num--;
			}
		}
		if(!(num==0)){ 							
				t = true;
				this.x = t;
			}
				
		return x;
		
		}
	
	public int getA() {
		return a;
	}
	
	public void setA() {
		this.a =-1;
	}
	
	
	


}
