package calExpression;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calculate {
	public static void main(String[] args) throws IOException {
		LinkedList<Character> stack=new LinkedList<Character>();
		File file = new File("src\\Expression");
		Scanner input = new Scanner(file);
		if (file.exists()) {
			File file1 = new File("src\\Output");
			java.io.PrintWriter output = new java.io.PrintWriter(file1);
			//������������һ����������whileѭ���У����ֵ��������ļ����ֻ����ʾ�������ļ������һ��
	      	//�������棬ÿ�ν���whileѭ��ʱ�������ȴ����ļ��ٴ��ļ�������һ����ÿ�ζ���֮ǰ�ĵ��ļ����ǵ�
			//���ԲŻ����ֻ��ʾһ�е�����
			while (input.hasNext()) {// ʹ��has.Next()��ʾ�����Զ�ѭ������
				String str=input.next();
				String s=input.nextLine();
				s=s.replaceAll("\\s","");
				System.out.print(s);
				boolean flag=UnmatchBrackets(s);
				if(s.matches("")){
					System.out.println("\nERROR\r\n" + 
							"#���ʽΪ��\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#���ʽΪ��\n");
					continue;
				}
				else if(s.matches("\\(\\)[\\+\\-\\*\\/]+\\d")){
					System.out.println("\nERROR\r\n" + 
							"#���ʽ���п�����\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#���ʽ���п�����\n");
					continue;
				}
				else if(s.matches(".*[\\+\\-\\*\\/]{2,}.*")){
					System.out.println("\nERROR\r\n" + 
							"#���������\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#���������\n");
					continue;
				}
				else if(!s.matches("[0-9\\\\.+-/*()= ]+")){
					System.out.println("\nERROR\r\n" + 
							"#���ʽ�����Ƿ��ַ�\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#���ʽ�����Ƿ��ַ�\n");
					continue;
				}
				else if(flag==true){
					System.out.println("\nERROR\r\n" + 
							"#���Ų�ƥ��\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#���Ų�ƥ��\n");
					continue;
				}
				else if(s.matches("[\\+\\*\\/].*")){
					System.out.println("\nERROR\r\n" + 
							"#�����ǰ��������\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#�����ǰ��������\n");
					continue;
				}
				else if(s.matches(".*[\\+\\-\\*\\/]")){
					System.out.println("\nERROR\r\n" + 
							"#���������������\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#���������������\n");
					continue;
				}
				else if(s.matches(".*[^\\(\\+\\-\\*\\/\\)]\\(.*")){
					System.out.println("\nERROR\r\n" + 
							"#���ŷǵ�һ���ַ���֮ǰ�������\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#���ŷǵ�һ���ַ���֮ǰ�������\n");
					continue;
				}
				else if(s.matches(".*\\)[^\\+\\-\\*\\/\\)\\(].*")){
					System.out.println("\nERROR\r\n" + 
							"#С���ź�������������ŷ����һ���ַ�\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#С���ź�������������ŷ����һ���ַ�\n");
					continue;
				}
				else if(s.matches("\\d+[\\+\\-\\*\\/]\\d\\/0")){
					System.out.println("\nERROR\r\n" + 
							"#��������Ϊ0\n");
					output.println(s);
					output.println("ERROR\r\n" + 
							"#��������Ϊ0\n");
					continue;
				}
					
				else{
					char[] biaodashi = s.toCharArray();// �ؼ���һ�������ļ����ɼ��������ת��Ϊ�ַ�����System.out.print(biaodashi);
					String expression = getchangeExpression(biaodashi);// ��ȡת������ַ������ʽ�������з���
																		// ����getExpression()����
					// ��ת����ĺ�׺���ʽ�����expression��Ϊ�����������е�expression
					char[] s2 = expression.toCharArray();// ��ת����Ϊ��׺���ʽ���ַ���expressionת�����ַ����飬��������s2��
					ArrStack as = rpn(s2); // ���ַ�����s2���ó�����ջ as
											// ��ʼ�������ݽṹ�е�ջ�����ü������ľ���ʵ��
					as.listStack();//���þ���ƴ�� �����ս�����
					System.out.println();
					output.print(biaodashi);
					
					output.println("=" + as.stackPop());
					// +as.stackPop()
					//������ֵ�����������ļ���ʾ���ǵ�ַ������as��Ϊas.stackPop()�󣬽���ɹ���ʾ
					//���ʽ���ֵ������������ַ���⣬ԭ�����ַ�����biaodashi��֧��Java�е�+������
					// output.println(Arrays.toString(biaodashi)+"="+as.stackPop());//+as.stackPop()
					
					continue;
				}
				
			}
			output.close();// �ļ��������йرղ���
		}
}
	public static boolean UnmatchBrackets(String s) {// ������Ų�ƥ�䣬�򷵻� true;���򷵻�false
		int len = s.length();
		LinkedList<Character> stack = new LinkedList<Character>();
		// ѭ�������ַ���
		for (int i = 0; i < len; i++) {
			// ���������������ջ
			char  ch = (char) s.charAt(i);
			if (ch == '(') {
				stack.push(ch);
				// �����������
			} else if (ch == ')') {
				// ջ�գ���������û��ƥ��������ţ��򷵻�false
				if (stack.isEmpty()) {
					return true;
					// ջ���գ����ջ���Ƚ�
				} else if (stack.peek().equals(ch)) {
					return true;
				} else {
					stack.pop();
				}
			}
		}
		// ѭ��������ջ�ձ�ʾƥ�����ˣ����ձ�ʾ����������
		if (stack.isEmpty()) {
			return false;
		} else {
			return true;
		}
}
	public static String getchangeExpression(char[] s) {// ��׺���ʽת��׺���ʽ
		ArrStack as = new ArrStack();// �����µ�����ջ

		String arr = ""; // �����ַ����洢��׺���ʽ ���ַ�������arr��ʼ����ֵ
		for (int i = 0; i < s.length; i++){ // s���ַ�����
		
			if (isNumber(s[i]) || s[i] == '.') {// �ж��ַ�����s�е��ַ� ����� ���� ���� .
												// ��ôֱ�ӷ��봴�����ַ���arr��
				arr = arr + s[i];
				if (i != s.length - 1) { // �ж������Ƿ���ȫ����,���ȫ���������,���ں�����Ͽո�
					if (!isNumber(s[i + 1]) && s[i + 1] != '.'){ // �ж��ַ�����s�е����һλ�ַ�
																// ������� ���� ���� .
					
						arr = arr + " ";// ��ӿո�
					}
				} else { // ����ַ������һλ������,��ֱ�Ӽӿո�(������ջ��������ַ�����)
				

					arr = arr + " ";
				}
				// �����������ַ�,���жϺ���ջ
			}

			else if (s[i] == '+' || s[i] == '-' || s[i] == '*' || s[i] == '/'){ // ��֮ǰif���Ӧ
			
				// �����+ -���ж�ջ��Ԫ���Ƿ�Ϊ * / �����,�Ƚ�ջ��Ԫ�س�ջ������ջ ����,ֱ����ջ
				if (s[i] == '+' || s[i] == '-') {
					if (!as.isEmpty()) {// ���ջ��Ϊ��
					 // �ж�ջ�Ƿ�Ϊ��
						char r = as.getTop();// ��ȡ����ջas��ջ��Ԫ�ظ��ַ�r
						// gettop ��ջ�Ĳ�������˼�Ƕ�ȡջ��Ԫ�ص�ֵ�����ǲ�����ջԪ�أ�ջ��Ԫ�ظ�������
						while (r == '+' || r == '-' || r == '*' || r == '/') {
							r = as.stackPop();// �൱�ڰ�����ջasת��Ϊ�ַ���r,Ŀ���ǿ��Ժ�����arr����
							/*
							 * ����as.pop()��һ��Object���͵Ķ��󣬵�����String�ࡰ+��ʱ��
							 * ϵͳ���Զ�����Object��toString()��������ת��String��ʾ��
							 */
							arr = arr + r + " ";

							if (!as.isEmpty()) { // ���ջ��Ϊ��,�������r,Ȼ�������ʼԭѭ��
								r = as.getTop();
							} 
							else { // ���ջΪ��,��ֱ������ѭ��
								break;
							}
						}
					}
					as.stackPush(s[i]);// ��ջΪ�գ�����ѭ��֮�󣬰�����s�е�Ԫ�� ��ջ
				}
				else { // /ջΪ�� ������s�е�Ԫ�� ��ջ
					as.stackPush(s[i]);
				}
}
			// ����ַ��� �� ( �� ֱ����ջ, ����ǡ� ) �� ��ջ��Ԫ�����γ�ջ,ֱ����ջԪ���� �� ( ��Ϊֹ
			else if (s[i] == '(') {
				as.stackPush(s[i]);
			} else if (s[i] == ')') {
				char r = as.stackPop();
				while (r != '(') {
					arr = arr + r + " ";
					r = as.stackPop();
				}
			}
		}

		// ��ջ��ʣ���Ԫ�����δ����ַ�����
		while (!as.isEmpty()) {
			char r = as.stackPop();
			arr = arr + r + " ";
		}
			return arr;
	}

	// �沨�����ʽ��ֵ
	public static ArrStack rpn(char[] s) {// ����ջ rpn���� ���ַ�����s�е��ַ�����
		ArrStack as = new ArrStack();// ����һ������ջas
		int num = 0;
		// ������ַ��������ַ�
		String arr = "";// ��ʼ���ַ�����arr���ȴ����ֵ
		int a = 0;
		int b = 0;
		int result = 0;
		for (int i = 0; i < s.length; i++) {
			// ��������ֻ���.������ջ��
			if (isNumber(s[i]) || s[i] == '.') {
				arr = arr + s[i];
			} 
			else if (s[i] == ' ') {
				// �����ո�,������ȡ��ת��double��������ջ��
				if (arr == "") {
					continue;
				}
				else {
					num = Integer.valueOf(arr);// ���ַ�������arr�е�ֵת��Ϊdouble��
					as.stackPush(num);
					// �ַ����ÿ�
					arr = "";
				}

			} 
			else {
				// ����������ַ�,����ջ��ǰ�����������������ѹ��ջ��
				switch (s[i]) {
				case '+':
					a = as.stackPop();
					b = as.stackPop();
					result = b + a;
					as.stackPush(result);
					break;
				case '-':
					a = as.stackPop();
					b = as.stackPop();
					result = b - a;
					as.stackPush(result);
					break;
				case '*':
					a = as.stackPop();
					b = as.stackPop();
					result = b * a;
					as.stackPush(result);
					break;
				case '/':
					a = as.stackPop();
					b = as.stackPop();
					if (a == 0) {
						System.out.println("\n��������Ϊ0!");
						break;
					}
					result = b / a;
					as.stackPush(result);
					break;

				}
			}
		}
		return as;// ��������ջas
	}

	// �ж��ַ��Ƿ�Ϊ����
	public static boolean isNumber(char c) // ����ֵ�����ж��ַ��Ƿ�Ϊ����
	{
		if (c >= 48 && c <= 57) {
			return true;
		}
		return false;
	}

}