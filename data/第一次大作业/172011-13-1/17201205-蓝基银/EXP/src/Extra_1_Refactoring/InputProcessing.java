package Extra_1_Refactoring;

public class InputProcessing {
	
	InputProcessing(){
		
	}
	String removeSpaces(String input){
		char temp=0;
		int j=0;
		String result ="";
		for (int i = 0;i< input.length();i++){
			if (input.charAt(i)==' '){
				
			}
			else{
				temp=input.charAt(i);
				result = result+temp;
			}
		}
		result = result;
		return result;
	}
	public String calculation (String []list){
		PopAndPush C2=new PopAndPush();
		String S1[] = new String[101]; 
		String S2[] = new String[101]; 
		int m=0;
		int n=0;
		double temp = 0;
		String result ="";
		
		S1[0]=list[0];
		S1[1]=list[1];
		m=1;
		n=0;
		for (int i = 2;((i<101)&&(!(list[i].equals(""))));i++){	
			if (list[i].matches("[0-9]*")){
				m++;
				S1[m]=list[i];
			}
			if (list[i].matches("[\\D]")){
				
				n++;
				S2[n]=list[i];
				temp =cal(S1[m],S1[m-1],S2[n]);
				S1[m]=null;
				S1[m-1]=null;
				m=m-2;
				
				m++;
				S1[m]=String.valueOf(temp);
				
				S2[n]=null;
				n=n-1;
				
				
				
			}
			//System.out.println(m +"  "+ n + " [0] " + S1[0] +" [1] " + S1[1]);
			
		}
	/*	for (int j=0;j<15;j++){
			System.out.println(S1[j]+ "  -- " +S2[j]);
		}*/
		result = S1[0];
		//System.out.println(result + "/*-+");
		return result;
	}
		double cal (String num1,String num2,String operator){
        switch (operator){
            case "+":return Double.valueOf(num2)+Double.valueOf(num1);
            case "-":return Double.valueOf(num2)-Double.valueOf(num1);
            case "*":return Double.valueOf(num2)*Double.valueOf(num1);
            case "/":return Double.valueOf(num2)/Double.valueOf(num1);
            default :return 0;
        }
    }
	
}
