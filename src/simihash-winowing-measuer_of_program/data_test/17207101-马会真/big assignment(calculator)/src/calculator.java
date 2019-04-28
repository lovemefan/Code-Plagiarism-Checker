import java.util.*;
import java.util.regex.*;


import java.io.*;
public class calculator {
	public static void main(String[] args) throws Exception {
		ArrayList<String> AllExpression = new ArrayList<>();
		ArrayList<String> Expression = new ArrayList<>();
		System.out.println("Please enter expressions in File of Expression:");
		AllExpression = Check(Read());
		for(int i=0;i<AllExpression.size();i++) {
			Expression = strFormat(AllExpression.get(i));
			System.out.println(calculator(Expression));
			Write(calculator(Expression),AllExpression.get(i));
		}
		
	}
	public static ArrayList<String> Read() throws Exception {//���ļ���ȡ���ʽ������ArrayList����
		File file = new File("src\\Expression");
		Scanner input = new Scanner(file);
		ArrayList<String> net = new ArrayList<>();
		while(input.hasNextLine()) {
			net.add(input.nextLine());
		}
		input.close();
		return net;	
	}
	public static void Write(int Answer,String Expression) throws IOException {//��ԭ���ʽ��������д���ļ���
		FileWriter fw = null;
		try {
			File file=new File("src\\Answer");
			fw = new FileWriter(file, true);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter output = new PrintWriter(fw);
		output.println(Expression + "=" + Answer);//������ʽ�ļ�����
		output.flush();
		try {
			fw.flush();
			output.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<String> Check(ArrayList<String> net) throws IOException{//��������ʽ�����ǽ���У�鲢��������ʽɾ��
		File file = new File("src\\Answer");
		PrintWriter output = new PrintWriter(file);
		String pattern = "(?:��|&|!|@|>|<|:|��|\\{|\\$)";
		String pattern1 = "(?:\\(\\))";
		String pattern2 = "(?:\\+\\+|\\-\\-|\\*\\*|\\/\\/)";
	    Pattern r = Pattern.compile(pattern);
	    Pattern r1 = Pattern.compile(pattern1);
	    Pattern r2 = Pattern.compile(pattern2);
	    String symbol;
		for(int i=0;i<net.size();i++) {
			symbol = net.get(i);
			Matcher m = r.matcher(symbol);
			Matcher m1 = r1.matcher(symbol);
			Matcher m2 = r2.matcher(symbol);
			if (m.find( )) {//�жϱ��ʽ�Ƿ�����Ƿ��ַ�
				output.println("ERROR");
				output.println("#���ʽ�����Ƿ��ַ�" );
				net.remove(i);
				i=i-1;
				}	
			else if (symbol.length() == 0) {//�жϱ��ʽ�Ƿ�Ϊ��
				output.println("ERROR");
				output.println("#���ʽΪ��" );
				net.remove(i);
				i=i-1;
				}
			else if(m1.find()){//�жϱ��ʽ���Ƿ��п�����
				output.println("ERROR");
				output.println("#���ʽ���п�����" );
				net.remove(i);
				i=i-1;
				}
			else if(m2.find()){//�жα��ʽ�Ƿ����������
				output.println("ERROR");
				output.println("#���������" );
				net.remove(i);
				i=i-1;
				}
			else{//�жϱ��ʽ�������Ƿ�ƥ��
				int length = symbol.length();
				int R=0;   //�����ŵ�����
				int L=0;   //�����ŵ�����
				for(int x=0;x<length;x++){
					char a = symbol.charAt(x);
					if(a=='(')
						R++;
					else if(a==')')
						L++;
				}
				if(R!=L){
					output.println("ERROR");
					output.println("#���Ų�ƥ��" );
					net.remove(i);
					i=i-1;
				}
			}
		}
		output.close();
		return net;
	}
	
	public static int calculator(ArrayList<String> obj) {//���ʽ������
		ArrayList<String> result = transform(obj);//��ȡ��ջ��ı��ʽ
		//System.out.println(result);
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < result.size(); i++) {
			String symbol = result.get(i);//��ȡһ���ַ�
			if (isDigital(symbol)) {//����ַ��������ͣ���ջ
				stack.push(Integer.parseInt(symbol));
			}
			else {//����ַ��Ƿ���ֵ�ͣ�����
				int num1, num2;
				num1 = stack.pop();
				num2 = stack.pop();
				switch (symbol) {
				case "+":
					stack.push(num2 + num1);
					break;
				case "-":
					stack.push(num2 - num1);
					break;
				case "*":
					stack.push(num2 * num1);
					break;
				case "/":
					stack.push(num2 / num1);
					break;
				default:
					break;
				}
			}
		}
		return stack.pop();//���ر��ʽ�ļ�����
	}
	public static ArrayList<String> transform(ArrayList<String> arrayList) {//��׺���ʽת��Ϊ��׺���ʽ
		Stack<String> stack = new Stack<>();//����һ��ջ
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < arrayList.size(); i++) {
			String symbol = arrayList.get(i);
			if (isDigital(symbol)) {//�ַ�����ֵ�;ͷ�������
				result.add(symbol);
			} 
			else if (symbol.equals(")")) {//�ַ���)ջ��Ԫ�ز���(�Ͱ�ջ��Ԫ�������ָ������(
				String temp;
				while (!(temp = stack.pop()).equals("(")) {
					result.add(temp);
				}
			} 
			else {
				if (stack.isEmpty()) {//���ջΪ�վͰ��ַ�ѹջ��Ȼ�����
					stack.push(symbol);
					continue;
				}
				String temp = stack.peek();
				while (outPriority(symbol) <= inPriority(temp)) {//���ַ������ȼ�����ջ��Ԫ�ص����ȼ������ջ��Ԫ��
					result.add(temp);
					stack.pop();
					if (stack.isEmpty()) {//ջΪ�վ�ֹͣ
						break;
					}
					temp = stack.peek();
				}//whileѭ������
				stack.push(symbol);//���ַ������ȼ�����ջ��Ԫ�ؾͰ��ַ�ѹջ
			}
		}

		while (!stack.isEmpty()) {//ջΪ�ǿվͰ�����ķ����������
			result.add(stack.pop());
		}
		return result;//���غ�׺���ʽ
	}
	public static ArrayList<String> strFormat(String s) {//���ʽ��ʽ��
		ArrayList<String> arrayList = new ArrayList<>();
		StringBuilder sExp = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ' ') {
				continue;
			}
			if (!Character.isDigit(ch)) {
				if (!sExp.toString().trim().equals("")) {
					arrayList.add(sExp.toString().trim());
					sExp.delete(0, sExp.length());
				}
				arrayList.add(ch + "");
				continue;
			}
			sExp.append(ch);
		}
		if (!sExp.toString().trim().equals("")) {
			arrayList.add(sExp.toString().trim());
		}
		return arrayList;
	}
	public static boolean isDigital(String symbol) {//�ж��ַ��Ƿ�Ϊ�������
		return !symbol.equals("+") && !symbol.equals("-") && !symbol.equals("*") && !symbol.equals("/")
				&& !symbol.equals("(") && !symbol.equals(")");
	}

	public static int inPriority(String ch) {//�жϷ������ȼ�
		switch (ch) {
		case "+":
		case "-":
			return 2;
		case "*":
		case "/":
			return 4;
		case ")":
			return 7;
		case "(":
			return 1;
		default:
			return 0;
		}
	}

	public static int outPriority(String ch) {//�жϷ������ȼ�
		switch (ch) {
		case "+":
		case "-":
			return 3;
		case "*":
		case "/":
			return 5;
		case ")":
			return 1;
		case "(":
			return 7;
		default:
			return 0;
		}
	}
}