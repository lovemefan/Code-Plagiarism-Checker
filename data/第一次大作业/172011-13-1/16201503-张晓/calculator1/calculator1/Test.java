package calculator1;

import java.util.Scanner;

public class Test {
	private String test = "";
	private int  testNum;
	public Test(){

	}	
	
	public int getTestNum(){
		return testNum;
	}
	public int testIt(String text){
		testNum=0;
		
		//判断是否为空字符串
		if(text == ""){
			System.out.println("ERROR");
			testNum=1;
		}

		//判断是否含有非法字符
		if(text.matches("[^0-9\\.\\+\\-\\*\\/\\(\\)]")==true){
			System.out.println("ERROR");
			testNum=1;
		}
		
		//判断括号是否匹配
				int left=0;
				int right=0;
				for(int i=0;i<text.length();++i){
					if(test.charAt(i)=='('){
						left=left+1;
						}
					if(test.charAt(i)==')'){
						right=right+1;
					}
				}
				if(left==right){
					testNum=0;
				}
				else{
					testNum=1;
					System.out.println("ERROR");
					
				}
					
		if(testNum==0){
		//判断字符串开始或结束是否有有运算符
		if(text.matches("^[\\*\\/]|[\\+\\-\\*\\/\\ ]$" )==true){
			System.out.println("ERROR");
			testNum=1;
		}
		
		//判断是否）前有运算符或）后有数字
		if(text.matches("[\\+\\-\\*\\/][)]|[)][0-9.]")==true){
			System.out.println("ERROR");
			testNum=1;
		}
		
		//判断是否（前有数字或 （后有运算符
		if(test.matches("[0-9\\.][(]|[(][\\*\\/]")==true){
			System.out.println("ERROR");
		}
		
		
		//判断是否有重复的运算符	
		if(test.matches("[\\S]*[+\\-/*/][+/*/][\\S]*")==true){
			System.out.println("ERROR");
			testNum=1;
		}
		
		
		}
		return testNum;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public void setTestNum(int testNum) {
		this.testNum = testNum;
	}
	
	
	
}