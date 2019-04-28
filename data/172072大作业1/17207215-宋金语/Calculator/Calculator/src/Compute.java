//�����׺���ʽ
import java.util.Stack;

public class Compute {
	
	Compute(){
		
	}
	
	public static Double compute(String exp){
		//����׺���ʽ�ָ���ַ������飬�˴�ֱ��ʹ�ÿհ�Ҳ���Զ��ַ������зָ�
		String[] strings = exp.split(" ");
		Stack<Double> stack = new Stack<Double>();
		for(int i = 0 ; i < strings.length ; i ++){
			if(strings[i].equals("")){
				continue;
			}
			//�������������ֱ�ӽ�ջ
			else if(checkNumber(strings[i])){
				stack.push((double)Integer.valueOf(strings[i]));
			}
			else{
				double y = stack.pop();
				double x = stack.pop();
				//������������ѹջ
				stack.push(calculate(x , y , strings[i]));
			}
		}
		//����ջ��Ԫ�ؾ������ս��
		double a1 = stack.pop();
		return a1;
		
	}
	private static Double calculate(double x , double y ,String string){
		if(string.trim().equals("+")){
			return x + y;
		}
		if(string.trim().equals("-")){
			return x - y;
		}
		if(string.trim().equals("*")){
			return x * y;
		}
		if(string.trim().equals("/")){  
			return x / y;
		}
		return (double) 0;
	}
	private static boolean checkNumber(String s){
		if(s.length()<=1&&s.charAt(0)>='0'&&s.charAt(0)<='9'){
			return true;
		}
		else if(s.length()>1&&s.charAt(1)>='0'&&s.charAt(1)<='9'){
			return true;
		}
		return false;
	}

}


