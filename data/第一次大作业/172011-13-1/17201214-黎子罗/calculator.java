import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class calculator {
	
	static String[] flagArray = new String[100];  //����Ѿ�ͨ���ļ���ʽ
	static int flag = 0;  //��Ǽ���ʽ��flagArray��λ��
	
	public calculator() {
		// TODO Auto-generated constructor stub
	}
	
	//ö��
	public enum operatorEnum{
		PLUS(0, '+'), MINUS(0, '-'), MULTIPLY(1, '*'), DIVIDE(1, '/'),  LEFT_BRACKET(2, '('), RIGHT_BRACKET(2, ')');//ö�ٲ�����
		
		public Integer first;		//���ȼ�
		public Character opera;     	//������
			
		private operatorEnum(int first,char opera){
			this.first = first;
			this.opera = opera;
		}
			
		public String toString(){
			return String.valueOf(opera);
		}
				
	}
		
	//�ж��ַ��Ƿ�Ϊ������
	private operatorEnum isOperator(char c){
		for(operatorEnum p : operatorEnum.values()){
			if(c == p.opera){
				return p;
			}
		}
		return null;
	}
		
	//������ʽת��Ϊ��׺���ʽ
	public String toBack(String s1){
		//��������ַ�������
		char[] c = s1.trim().toCharArray(); //trim() �����Ƴ��ַ�������Ŀհ��ַ�������Ԥ�����ַ�
		 LinkedList<operatorEnum> stack = new LinkedList<operatorEnum>();
		 StringBuilder sb = new StringBuilder();
		 
		 operatorEnum opera = null;
		 
		 for(int i = 0; i < c.length; i++){
			 //����ÿ���ַ�������Ƿ�Ϊ������
			 if((opera = isOperator(c[i])) == null){
				 sb.append(c[i]);
			 }
			 //��������ջ��Ԫ��ֱ�������ţ��������
			 else if(opera.equals(operatorEnum.RIGHT_BRACKET)){
				 //������������ţ��������������
				 while(!stack.peek().equals(operatorEnum.LEFT_BRACKET)){
					 sb.append(stack.pop());
				 }
				 stack.pop();
			 }
			 else{
				 //������������и����ȼ�����ͬ�����ȼ���ֱ�����������ȼ�����������Ϊֹ
				 while(stack.size() > 0 && stack.peek().first >= opera.first && !stack.peek().equals(operatorEnum.LEFT_BRACKET)){
					 sb.append(stack.pop());
				 }
				 //��ջ
				 stack.push(opera);
			 }
		 }
		 //����ջ��ʣ�µ����в�����
		 while(stack.size() > 0){
			 sb.append(stack.pop());
		 }
		 return sb.toString();
	}
		
	//�����׺���ʽ
	public double compute(String toback){
		char[] c = toback.toCharArray();
		LinkedList<Double> stack = new LinkedList<Double>();
		operatorEnum opera = null;
		for(int i = 0; i < c.length; i++){
			//�ж��Ƿ�Ϊ��������������ջ
			if((opera = isOperator(c[i])) == null){
				stack.push(Double.parseDouble(String.valueOf(c[i])));
			}
			else{
				//���ǲ����������м���
				double m = stack.pop();
				double n = stack.pop();
				switch(opera){
					
				case PLUS:
					stack.push(n + m);//�ӷ�����
					break;
				case MINUS:
					stack.push(n - m);//��������
					break;
				case MULTIPLY:
					stack.push(n * m);//�˷�����
					break;
				case DIVIDE:
					stack.push(n / m);//��������
					break;
						
				default:
					break;
				}
			}
		}
		//���ص���ջ��
		return stack.pop();
	}
	
	//������ʽ��������
	public static void getArray(String s){
		flagArray[flag] = s;
		flag++;
	}

	//�Ƚ������Ԫ��������
	public static boolean repeat(String s){
		for(int i = flag-1; i > 0;i--){
			if(s.equals(flagArray[i-1])){
				return true;
			}
		}
		return false;
	}
	
	//������ʽ��У��
	public static String regularExpression(String s){
		
		char s_first = s.charAt(0);
		char s_end = s.charAt(s.length()-1);
		
		boolean a = s.matches("(.*)[\\*+-/][\\*+-/](.*)");
		boolean b = s.matches("(.*)\\([\\*+-/](.*)");
		boolean c = s.matches("[0-9\\+\\-\\(\\)\\*\\/]*");
		boolean d = s.matches("(.*)[\\*+-/]\\)(.*)");
		boolean e = s.matches("(.*)[0-9]\\((.*)");
		boolean f = s.matches("(.*)\\)[0-9](.*)");
		boolean g = s.matches("(.*)\\(\\)(.*)");
		
		
		if(a == true){
			return "          #���������";
		}
		else if(b == true){
			return "          #�����ź��������";
		}
		else if(c == false){
			return "          #���ʽ�ں��Ƿ��ַ�";
		}
		else if(d == true){
			return "          #������ǰ�������";
		}
		else if(e == true){
			return "          #������ǰ���������";
		}
		else if(f == true){
			return "          #�����ź��������";
		}
		else if(g == true){
			return "          #������";
		}
		else if(s_first == '+' || s_first == '/' ||s_first == '*' || s_first == '-'){
			return "          #�������������λ";
		}
		else if(s_end == '+' || s_end == '/' ||s_end == '*' || s_end== '-'){
			return "          #�����������ĩβ";
		}
		
		return s;
		
	}
	
	public static void main(String[] args) throws IOException{
	
		calculator my = new calculator();
		
		java.io.File file = new java.io.File("I:/experimentTest/test.txt");		//��ָ��·���´���file���󣬴�test.txt
		java.io.File file1 = new java.io.File("I:/experimentTest/testResult.txt");		//��ָ��·���´���file1���󣬴���testResult.txt
		
		Scanner input = new Scanner(file);
		java.io.PrintWriter p = new java.io.PrintWriter(file1);
		
		//��testResult.txt�ļ��Ѿ����ڣ���ɾ���ļ�
		if(file1.exists() && file1.isFile()){
			file1.delete();
		}
		
		//����ʽ�������
		while(input.hasNext()){
			String s1 = input.nextLine();
			String s1_quit = s1.replaceAll(" ","");  //replacAll���ȥ���ַ�����Ŀո�
			getArray(s1_quit);
			boolean check = repeat(s1_quit);
			if(check == true){
				continue;
			}
			else if(regularExpression(s1_quit) == s1_quit){
				String result = s1_quit+" = "+my.compute(my.toBack(s1_quit));
				p.println(result);		//����ȷ���д���ļ�
			}
			else{
				p.println(s1_quit);
				p.println("          ERROR");
				p.println(regularExpression(s1_quit));  //��������Ϣд���ļ�
			}
		}
		p.close();
		input.close();
		
	}

}
