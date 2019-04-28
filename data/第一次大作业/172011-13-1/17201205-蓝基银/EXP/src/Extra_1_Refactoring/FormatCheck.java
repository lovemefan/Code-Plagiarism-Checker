package Extra_1_Refactoring;

public class FormatCheck {
	
	String check (String input){
		String result = "";
		if (input.matches("[\\S]*[(][+-/*/][\\S]*")){
			result = "ERROR\n# (的右边有运算符";
		}
		if (input.matches("[\\S]*[0-9]*[(][\\S]*")){
			result = "ERROR\n# (的左边有数字";
		}
		if (input.matches("[\\S]*[+-/*/][)][\\S]*")){
			result = "ERROR\n# )的左边有运算符";
		}
		if (input.matches("[\\S]*[)][0-9]*[\\S]*")){
			result = "ERROR\n# )的右边有数字";
		}
		if (input.matches("[\\S]*[+-/*/][+-/*/][\\S]*")){
			result = "ERROR\n# 运算符连续";
		}
		if (input.matches("[\\S]*[(][)][\\S]*")){
			result = "ERROR\n# 空括号";
		}
		if (input.matches("[\\S]*[/][0][\\S]*")){
			result = "ERROR\n# 除数不能为0";
		}
		if (input.matches("")){
			result = "ERROR\n# 空字符串";
		}
		if (input.matches("[+-/*/][\\S]*")){
			result = "ERROR\n# 运算符在第一位";
		}
		if (input.matches("[\\S]*[+-/*/]")){
			result = "ERROR\n# 运算符在最后一位";
		}
		
		int count = 0;
		for (int i=0;i<input.length();i++){
			if ((input.charAt(i)=='(')){
				count++;
			}
			if ((input.charAt(i)==')')){
				count--;
			}
			if (count<0){
				result = "ERROR\n# (与)不匹配";
			}
		}
		if (count!=0){
			result = "ERROR\n# (与)不匹配";
		}
		
		for (int i=0;i<input.length();i++){
			if ((input.charAt(i)!='+')&&
				(input.charAt(i)!='-')&&
				(input.charAt(i)!='*')&&
				(input.charAt(i)!='/')&&
				(input.charAt(i)!='0')&&
				(input.charAt(i)!='1')&&
				(input.charAt(i)!='2')&&
				(input.charAt(i)!='3')&&
				(input.charAt(i)!='4')&&
				(input.charAt(i)!='5')&&
				(input.charAt(i)!='6')&&
				(input.charAt(i)!='7')&&
				(input.charAt(i)!='8')&&
				(input.charAt(i)!='9')&&
				(input.charAt(i)!=')')&&
				(input.charAt(i)!='(')){
				result = "ERROR\n# 非法的字符 " + String.valueOf(input.charAt(i));
				break;
			}
			
		}
		
		return result;
	}
}
