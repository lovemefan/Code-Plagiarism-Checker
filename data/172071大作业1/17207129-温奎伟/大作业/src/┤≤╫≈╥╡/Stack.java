package ����ҵ;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Stack {
	// ˳��ջ
		private String[] data;
		// ջ��
		private int top;

		// ָ��ջ�Ĵ�СΪ10000
		public Stack() {
			data = new String[10000];
			top = 0;
		}

		// ��ջ
		public void push(String data) {
			this.data[top++] = data;
		}

		// ��ջ
		public String pop() {
			return data[--top];
		}

		// ջ�Ƿ�Ϊ��
		public boolean isEmpty() {
			return top == 0;
		}

		// �鿴ջ��Ԫ��
		public String top() {
			return data[top - 1];
		}

}
class Calculate {
	// ջ
	Stack stack;
	// ��׺���ʽ
	ArrayList<String> infix;
	// ��׺���ʽ
	ArrayList<String> postfix;
	// ���ʽ�Ľ��
	double num = 0;
	// У����Ĵ���
	private Check check;

	public Calculate() {

	}

	// ���췽��
	// У���������
	public Calculate(Check check) {
		stack = new Stack();
		postfix = new ArrayList<>();
		infix = check.toInfix();
		this.check = check;
		toPostfix();
		compute();
	}

	// �����׺���ʽ�Ľ��
	public void compute() {
		stack = new Stack();
		for (String str : postfix) {
			if (str.matches("[\\+\\-\\*\\/]")) {
				double num2 = Double.valueOf(stack.pop());  //����ת��
				double num1 = Double.valueOf(stack.pop());  //����ת��
				switch (str) {
				case "+":
					num = num1 + num2;
					break;
				case "-":
					num = num1 - num2;
					break;
				case "*":
					num = num1 * num2;
					break;
				case "/":
					// ����Ϊ0�����
					if (Math.abs(num2) < 1e-8) {
						check.setLegal(false);
						check.setError("��������Ϊ0");
						return;
					}
					num = num1 / num2;
					break;
				}
				stack.push(String.valueOf(num));
			} else {
				stack.push(str);   //��ջ
			}
		}
	}

	// ��׺ת��׺
	private void toPostfix() {
		// ������׺���ʽ
		for (String str : infix) {
			// ���ȼ���ȫ����ջ����ջ�������������Ž���
			if (str.matches("[\\+\\-]")) {
				while (!stack.isEmpty() && !stack.top().equals("(")) {
					postfix.add(stack.pop());  
				}
				stack.push(str);     //��ջ
			} else if (str.matches("[\\*\\/]")) {
				while (!stack.isEmpty() && stack.top().equals("[\\*\\/]")) {
					postfix.add(stack.pop());   
				}
				stack.push(str);   //��ջ
			} else if (str.matches("\\(")) {
				stack.push(str);    //��ջ
			} else if (str.matches("\\)")) {
				while (!stack.top().matches("\\(")) {
					postfix.add(stack.pop());     
				}
				stack.pop();  //��ջ
			} else {
				num = Double.valueOf(str);
				postfix.add(str);
			}
		}
		// ��ջ�з��ŵ�������׺���ʽ��
		while (!stack.isEmpty()) {
			postfix.add(stack.pop());
		}
	}

	public ArrayList<String> getPostfix() {
		return postfix;
	}

	public double getNum() {
		return num;
	}
}
class Check {
	// ���ʽ
	private String expression;
	// ������Ϣ
	private String error;
	// ���ʽ��ȷ��true��ȷ��false����
	private boolean legal;
	// ������ʽ
	private String[] regex = { "^$", "\\(\\)", "[\\+\\-\\*\\/]{2,}", "[^0-9\\+\\-\\*\\/\\(\\)]",
			"\\([\\*\\/]", "\\d\\(", "\\)\\d", "[\\+\\-\\*\\/]\\)", "[\\+\\-\\*\\/]$|^[\\*\\/]" };
	//������Ϣ
	private String[] errorInformation = { "����","������", "���������", "���зǷ��ַ�", "�����ź�˳������", 
			                              "������ǰ����", "�����ź�����", "������ǰ�����", "��β���ŷǷ�" };
	Pattern pattern;
	
	public Check(){
		
	}

	public Check(String str) {
		expression = str;
		legal = true;
		process();
	}

	// ���˿հ׷�
	private void filterSpace() {
		expression = expression.replaceAll("\\s", "");
	}

	// ���Ÿ����Ƿ�ƥ��
	private void legalOfBrackets() {
		pattern = Pattern.compile("[\\(\\)]");
		Matcher matcher = pattern.matcher(expression);
		String tmp = "";
		// ��������
		while (matcher.find()) {
			tmp += matcher.group();
		}
		// ����������
		while(tmp.contains("()")){
			tmp = tmp.replaceAll("\\(\\)", "");
		}
		if (tmp.equals("") == false) {
			legal = false;
			error = "���Ų�ƥ��";
		}
	}

	// ����ַ���
	public void process() {
		// ���˿հ׷�
		filterSpace();
		// ���Ÿ���У��
		legalOfBrackets();
		// �����ʽ����ȷ��
		for (int i = 0; i < regex.length && legal; ++i) {
			pattern = Pattern.compile(regex[i]);
			Matcher matcher = pattern.matcher(expression);
			if (matcher.find()) {
				legal = false;
				error = errorInformation[i];
			}
		}
	}

	// ������תΪ0-��������ʽ
	private void transform() {
		expression = expression.replaceAll("\\(\\-", "(0-");
		expression = expression.replaceAll("\\(\\+", "(0+");
		expression = expression.replaceAll("^\\+", "0+");
		expression = expression.replaceAll("^\\-", "0-");
	}

	// תΪ��׺
	public ArrayList<String> toInfix() {
		transform();
		ArrayList<String> str = new ArrayList<>();
		pattern = Pattern.compile("[\\+\\-\\*\\/\\(\\)]|\\d+");
		Matcher matcher = pattern.matcher(expression);
		while (matcher.find()) {
			str.add(matcher.group());
		}
		return str;
	}

	//��ȡ���ʽ
	public String getExpression() {
		return expression;
	}

	//��ȡ������Ϣ
	public String getError() {
		return error;
	}

	//��ȡ���ʽ�Ƿ�Ϸ�
	public boolean getLegal() {
		return legal;
	}

	//���ñ��ʽ�Ƿ�Ϸ�
	public void setLegal(boolean legal) {
		this.legal = legal;
	}
	
	//���ô�����Ϣ
	public void setError(String error) {
		this.error = error;
	}
}
class FileToFile {
	// ���ݴ洢
	ArrayList<String> data = new ArrayList<>();

	public FileToFile() {

	}

	// ���ļ�д�ļ�
	public void inputFile() throws IOException {
		File file = new File("input.txt");
		File outputFile = new File("output.txt");
		//�ж��ļ��Ƿ����
		if (!file.exists()) {
			System.out.println("�ļ�������");
			System.exit(0);
		}
		Scanner input = new Scanner(file);
		PrintWriter output = new PrintWriter(outputFile);
		while (input.hasNextLine()) {
			String str = input.nextLine();
			Check check = new Check(str);
			str = check.getExpression();
			// ���ݲ���
			if (!data.contains(str)) {
				outputFile(check, output);
				data.add(str);
			}
		}
		output.close();
		System.out.println("�ɹ�");
		input.close();
	}

	// ������ļ�
	private void outputFile(Check check, PrintWriter output) {
		String str = check.getExpression();
		if (check.getLegal()) {
			Calculate c = new Calculate(check);
			// �ڼ���֮��֪������Ϊ0�����
			c.compute();
			if (check.getLegal()) {
				output.println(str + "=" + c.getNum());   //��������д���ļ�
			} else {
				output.println("ERROR\n#" + check.getError());  //��������Ϣд���ļ�
			}
		} else {
			output.println("ERROR\n#" + check.getError());  //��������Ϣд���ļ�
		}
	}
}



