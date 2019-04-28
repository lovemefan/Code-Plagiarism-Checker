import java.util.ArrayDeque;

public class MiddleC {
	ArrayDeque<String> stack = new ArrayDeque<String> ();
	private String[] input; 
	private String store = " ";
	public String Result = "";
	
	public MiddleC(){
		
	}
	
	//�ж��Ƿ�Ϊ����
	public boolean isDigit(char n){
		if(n >= '0' && n <= '9'){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	//���������׺���ʽ���������֮��ӿո�ת������
	public String process1(String input){
		String output = "";
		Result = input.replace(" ", "");
		int i = 0;
		//������ת��Ϊ0-
		if(input.charAt(0) == '-' && isDigit(input.charAt(1)) || (input.charAt(0) == '-' && input.charAt(1)== '(')){
			output += " 0 - " ;
			i = i + 1;
		}
		for(int j = i; j < input.length() - 1; j ++){
			char temp1 = input.charAt(j);
			char temp2 = input.charAt(j+1);
			if(temp1 == '(' && temp2 == '-'){
				output += temp1 + " 0 - ";
				j++;
			}
			else if(isDigit(temp1) && isDigit(temp2)){//������������֮ǰ�ӿո�
				output  += temp1 ;
			}
			else {
				output += temp1 + " ";
			}
		}
		output += input.charAt(input.length() - 1);
		//System.out.println(output);
		return output;
	}
	
	//����׺���ʽתΪ��׺���ʽ
	public String process2(String input){
		String[] strArr = input.split(" ");
		for(int i = 0; i < strArr.length; i ++){
			String str = strArr[i];
			switch(str){
			case "(":
				stack.push(str);
			    break;
			case ")":
		
			while(!stack.peek().equals("(") ){
				store += " " + stack.pop();
			}
				stack.pop();
				break;
			case "+":
			case "-":
				sentance(str);
				stack.push(str);
				break;
			case "*":
			case "/":
				sentance(str);
		       	break;
		    default:
		    	store += " " + str;
		        break;
	        }
	    }
	        // ����ȫ���������Ҫ���ջ��ʣ��ķ���
	        while (!stack.isEmpty()) {
	            store += " " + stack.pop();
	        }
	        //System.out.println(store);
	        return store;
	    }
	
	//���ַ����еķ��Ž����ж�
	public void sentance(String str){
		if(str.equals("+") || str.equals("-")){
			if (!stack.isEmpty() && !stack.peek().equals("(")){
				store += " " + stack.pop();
			}
		}
		else if(str.equals("/") || str.equals("*")){
			if(stack.isEmpty()){
				stack.push(str);
			}
			else if(stack.peek().equals("*") || stack.peek().equals("/")){
	       		store += " " + stack.pop();
	       		stack.push(str);
       	}
	       	else{
	       		stack.push(str);
	       	}
		}
	}

}
