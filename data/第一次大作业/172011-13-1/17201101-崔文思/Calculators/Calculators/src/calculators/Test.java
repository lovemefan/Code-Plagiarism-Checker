package calculators;
//import java.util.Deque;
//import java.util.regex.*;
//import java.util.LinkedList;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

//开头是运算符没解决  括号前后有字符  

public class Test {
	private String test = "";
	private int  testNum;
	int find=0;
	public Test(){
		
	}
	
	public String getTest(String number){
		test=number;
		//this.test=test;
		return test;
	}
	public Test(String test){
		this.test=test;
	}
	
	
	public int getTestNum(){
		return testNum;
	}
	
	public int testIt(String test){
		testNum=0;
		
		//判断括号是否匹配
        int testNum2=0;
		int left=0;
		int right=0;
		for(int i=0;i<test.length();++i){
			if(test.charAt(i)=='('){
				left=left+1;
				}
			if(test.charAt(i)==')'){
				right=right+1;
			}
			if(left<right){
				 testNum2=1;
			}
		}
		if(testNum2==0){
		if(left==right){
			testNum=0;
		}
		else{
			testNum=1;
			find=3;
			System.out.println("ERROR");
			System.out.println("#括号数目不匹配!");
		}
		}
		else{
			find=4;
			testNum=1;
			System.out.println("ERROR");
			System.out.println("#括号顺序不匹配  ）先出现!");
		}
		
		
		//判断是否为空字符串
		if(test == ""){
			System.out.println("ERROR");
			System.out.println("#是空字符串!");
			testNum=1;
			find=1;
		}
	
		//"[^\\+\\-\\*\\/\\(\\)\\.0-9]"
		//判断是否含有非法字符
		if(test.matches(".*[^\\d|^\\+|^\\-|^\\*|\\/|^\\(|^\\)].*")){
			System.out.println("ERROR");
			System.out.println("#含有非法字符!");
			testNum=1;
			find=2;
		}
					
		if(testNum==0){
		//判断字符串开头是否有运算符
		if(test.matches("[\\+\\-\\*\\/][\\d].*")){
			System.out.println("ERROR");
			System.out.println("#开头有运算符!");
			testNum=1;
			find=5;
		}
		
		//判断字符串结尾有运算符
		if(test.matches(".*[\\+\\-\\*\\/]")){
			System.out.println("ERROR");
			System.out.println("#结尾有运算符!");
			testNum=1;
			find=6;
		}
		
		//判断是否）前有运算符      [\\+\\-\\*\\/][)]|[)][0-9.]
		if(test.matches(".*(\\+\\)|\\*\\)|-\\)|/\\)).*")==true){   ///
			System.out.println("ERROR");
			System.out.println("#）前有运算符!");
			testNum=1;
			find=7;
		}
		//判断是否（后有运算符
		if(test.matches(".*(\\(-|\\(\\+|\\(/|\\(\\*).*")){     ///
			System.out.println("ERROR");
			System.out.println("#（后有运算符!");
			find=8;
			testNum=1;
		}
		//判断是否（前有数字 或是 ）后有数字
		if(test.matches(".*(\\)\\d|\\d\\().*")==true){       ///
			System.out.println("ERROR");
			System.out.println("#（前有数字或  ）后有数字!");
			find=9;
			testNum=1;
		}
		//判断是否是空括号
		if(test.matches(".*(\\(\\)).*")){            ///
			System.out.println("ERROR");
			System.out.println("#空括号!");
			testNum=1;
			find=10;
		}
		
		//判断是否有重复的运算符	
		if(test.matches("[\\S]*[+\\-/*/][+/*/][\\S]*")==true){      ///
			System.out.println("ERROR");
			System.out.println("#有两个或以上连续重的复运算符!");
			testNum=1;
			find=11;
		}
		
		//判断/后是否为0
		if(test.matches(".*(\\/0).*")){     
			System.out.println("ERROR");
			System.out.println("# /后为0!");
			find=12;
			testNum=1;
		}
		
		}
		return testNum;
	}
	public String finding(int find){
		String[] finded=new String[13];
		finded[0]="";
		finded[1]="#是空字符串";
		finded[2]="#含有非法字符!";
		finded[3]="#括号数目不匹配!";
		finded[4]="#括号顺序不匹配  ）先出现!";
		finded[5]="#开头有运算符!";
		finded[6]="#结尾有运算符!";
		finded[7]="#）前有运算符或）后有数字!";
		finded[8]="#（后有运算符!";
		finded[9]="#（前有数字或  ）后有数字!";
		finded[10]="#空括号!";
		finded[11]="#有两个或以上连续重的复运算符!";
		finded[12]="# /后为0!";
		return finded[find];
	}
	
	
	
}

	


