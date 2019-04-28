import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Operate {
	ArrayDeque<Double> stack = new ArrayDeque<Double> ();
	private String[] input;//��������ĺ�׺���ʽ 
	private String store = " ";//������ı��ʽ
	public String Error = "";//����Ĵ�����Ϣ
	public String Result = "";//�����Ľ��
	public Operate(){
		
	}
	
	//�ж��Ƿ�Ϊ����
	public boolean isDigit(String input){
		char[] charArr = input.toCharArray();
		int len = charArr.length;
		int temp = 0;
		if(len == 0){
			return false;
		}
		for(int i = 0;i < len;i ++){
			if(charArr[i] <= '9' && charArr[i] >= '0'){
				temp ++;
			}
		}
		return temp == len;
	}
	
	//�Ժ�׺���ʽ���м���
	public void Last(String input){
		String[] strArr = input.split(" ");
		for(int i = 0;i < strArr.length; i ++){
			String str = strArr[i];
			if(str.isEmpty()){
				continue;
			}
			else if (isDigit(str)){
				stack.push(Double.valueOf(str));
			}
			else{
				double sum = operate(str);
				stack.push(sum);
			}
		}
		String end = stack.peek() + "";
		if(end.equals("Infinity")){
			Error = "\r\nERROR\r\n#�ñ��ʽ����Ϊ��\r\n";
		}
		else{
			Result = stack.pop() + "";
		}
	}
	
	//ȡջ�е����ּ���
	public double operate(String str){
		
		double a = stack.pop();//ȡ��ջ���ĵ�һ������
		double b = stack.pop();//ȡ��ջ���ĵڶ�������
		double result = 0;//����Ľ��
		switch(str){
		case "+":
			result = b + a;
			break;
		case "-":
			result = b - a;
			break;
		case "*":
			result = b * a;
			break;
		case "/":
			result = b / a;
			break;
		default:
			break;
		}
		return result;
	}
}