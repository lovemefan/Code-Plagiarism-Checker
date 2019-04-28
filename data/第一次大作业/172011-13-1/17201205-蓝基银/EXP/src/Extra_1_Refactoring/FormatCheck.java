package Extra_1_Refactoring;

public class FormatCheck {
	
	String check (String input){
		String result = "";
		if (input.matches("[\\S]*[(][+-/*/][\\S]*")){
			result = "ERROR\n# (���ұ��������";
		}
		if (input.matches("[\\S]*[0-9]*[(][\\S]*")){
			result = "ERROR\n# (�����������";
		}
		if (input.matches("[\\S]*[+-/*/][)][\\S]*")){
			result = "ERROR\n# )������������";
		}
		if (input.matches("[\\S]*[)][0-9]*[\\S]*")){
			result = "ERROR\n# )���ұ�������";
		}
		if (input.matches("[\\S]*[+-/*/][+-/*/][\\S]*")){
			result = "ERROR\n# ���������";
		}
		if (input.matches("[\\S]*[(][)][\\S]*")){
			result = "ERROR\n# ������";
		}
		if (input.matches("[\\S]*[/][0][\\S]*")){
			result = "ERROR\n# ��������Ϊ0";
		}
		if (input.matches("")){
			result = "ERROR\n# ���ַ���";
		}
		if (input.matches("[+-/*/][\\S]*")){
			result = "ERROR\n# ������ڵ�һλ";
		}
		if (input.matches("[\\S]*[+-/*/]")){
			result = "ERROR\n# ����������һλ";
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
				result = "ERROR\n# (��)��ƥ��";
			}
		}
		if (count!=0){
			result = "ERROR\n# (��)��ƥ��";
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
				result = "ERROR\n# �Ƿ����ַ� " + String.valueOf(input.charAt(i));
				break;
			}
			
		}
		
		return result;
	}
}
