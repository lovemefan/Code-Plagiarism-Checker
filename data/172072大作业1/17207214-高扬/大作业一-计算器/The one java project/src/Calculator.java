import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Calculator {
	
	public static final int EXPRESSION_LONGTH = 100;
	public static final int OPERATOR_COUNT = 50;
	
	static String[] exp = new String[100];
	static String[] ans = new String[100];
	static String Exp = new String();
	static String ipExp = new String();
	static FileOperation fo = new FileOperation();
	static int num = 0;
	
	public static void main(String[] args) {
		
		FileOperation fo = new FileOperation();
		File fileOne = new File("src\\ArithmeticExpression");
		File fileTwo = new File("src\\Results");
		fo.FileTest(fileOne);
		
		num = fo.Read(fileOne);
		
		for(int i = 0; i < num; i++) {
				
				if(exp[i].charAt(0) == 'E') {
					ans[i] = exp[i];
				}
				else {
					Exp = expressionInit(exp[i]);
					
					ipExp = InversePolishEX.exchange(Exp);
					
					ans[i] = exp[i] + "=" + Calculate.Operator(ipExp);
				}
				
				
				fo.writeFile(fileTwo);
				
				System.out.println(ans[i]);
		}
		
		
	}
	
	//����������ʽ�Ĵ洢
	static String  expressionInit(String exp) {
		
		exp = "#" + exp + "#";
		
		return exp;
	}

}

//������ʽ����������ʽ�ĺϷ���
class RegularExpressionDetection{
	
	static String judge;
	
	static int Judge(String data) {
		
		
		if(data == "") {
			judge = ("#���ʽΪ��");
			return -1;
		}
		
		for(int i = 1; i < data.length(); i++) {
			if(data.charAt(i) == ')' && data.charAt(i - 1) == '(') {

				judge = ("#���ʽ���п�����");
				return -1;
			}
		}
		
		int left = 0;
		for(int i = 0; i < data.length(); i++) {
			if(data.charAt(i) == '(') {
				left++;
			}
			else if(data.charAt(i) == ')') {
				if(left > 0)
					left--;
				else {
					judge = ("#���Ų�ƥ��");
					return -1;
				}
			}
			
			if(data.charAt(i) >= '0' && data.charAt(i) <= '9')
				continue;
			else if(data.charAt(i) == '+' || data.charAt(i) == '-' || data.charAt(i) == '*' || data.charAt(i) == '/' || data.charAt(i) == '(' || data.charAt(i) == ')')
				continue;
			else {
				judge = ("#���ʽ�����Ƿ��ַ�");
				return -1;
			}
		}
		if(left != 0) {
			judge = ("#���Ų�ƥ��");
			return -1;
		}
		
		if(data.charAt(0) == '+' || data.charAt(0) == '-' || data.charAt(0) == '*' || data.charAt(0) == '/') {
			if(data.charAt(1) == '(') {
				judge = ("#���ŷǵ�һ���ַ���֮ǰ��������");
				return -1;
			}
			else {
				judge = ("#�����ǰ��������");
				return -1;
			}
		}
		
		if(data.charAt(data.length() - 1) == '+' || data.charAt(data.length() - 1) == '-' || data.charAt(data.length() - 1) == '*' || data.charAt(data.length() - 1) == '/') {
			if(data.charAt(data.length() - 2) == ')') {
				judge = ("#С���ź��������������ŷ����һ���ַ�");
				return -1;
			}
			else {
				judge = ("#���������������");
				return -1;
			}
		}
		
		for(int i = 1; i < data.length(); i++) {
			if(data.charAt(i) == '+' || data.charAt(i) == '-' || data.charAt(i) == '*' || data.charAt(i) == '/') {
				if(data.charAt(i - 1) == '+' || data.charAt(i - 1) == '-' || data.charAt(i - 1) == '*' || data.charAt(i - 1) == '/') {
					judge = ("#���������");
					return -1;
				}
				else if(data.charAt(i - 1) < '0' && data.charAt(i - 1) != ')') {
					judge = ("#�����ǰ��������");
					return -1;
				}
				
			}
			
			if(data.charAt(i - 1) == '+' || data.charAt(i - 1) == '-' || data.charAt(i - 1) == '*' || data.charAt(i - 1) == '/') {
				if(data.charAt(i) < '0' && (data.charAt(i) != '(')) {
					judge = ("#���������������");
					return -1;
				}
			}
		}
		
		return 0;
	}
}

//���������ʽת��Ϊ�沨��ʽ
class InversePolishEX{
	
	//�沨��ʽת��
	static String exchange(String exp) {
		
		StringBuilder ipexp = new StringBuilder();
		StringBuilder opera = new StringBuilder();
		
		opera.append('#');

		for(int i = 0; i < exp.length(); i++) {
			if(exp.charAt(i) >= '0' && exp.charAt(i) <= '9') {
				ipexp.append(exp.charAt(i));
			}
			else if(exp.charAt(i) >= '#' && exp.charAt(i) <= '/') {
				switch(JudgePriority(exp.charAt(i), opera.charAt(opera.length() - 1))) {
				case '<':{
					opera.append(exp.charAt(i));
					break;
				}
				case '>':{
					ipexp.append(opera.charAt(opera.length() - 1));
					opera.deleteCharAt(opera.length() - 1);
					i--;
					break;
				}
				case '=':{
					if(ParenthesesJudgment(opera, exp.charAt(i)) == 1) {
						opera.deleteCharAt(opera.length() - 1);
						break;
					}
				}
				}
			}
		}
		
		
		return ipexp.toString();
	}
	
	//�жϷ������ȼ�
	static char JudgePriority(char ch_before, char ch_after) {
		String opera = "+-*/()#";
		char ans = ' ';
		String prior[] = {">><<<>>",">><<<>>",">>>><>>",">>>><>>","<<<<<= ",">>>> >>","<<<<< ="};
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				if(ch_before == opera.charAt(j) && ch_after == opera.charAt(i)) {
					ans =  prior[i].charAt(j);
				}
			}
		}
		
		return ans;
	}
	
	//������Ų�������Ӧ�Ĳ���
	static int ParenthesesJudgment(StringBuilder opera, char key) {
		if(key == ')') {
			for(int i = 0; i < opera.length(); i++) {
				if(opera.charAt(i) == '(') {
					i++;
					for(int j = i; j < opera.length(); j++) {
						opera.setCharAt(j - 1, opera.charAt(j));
					}
				}
			}
			return 1;
		}
		else {
			return 0;
		}
	}
}

//�沨��ʽ������
class Calculate{
	
	
	//�沨��ʽ����
	static int Operator(String ipExp) {
		
		StringBuilder ipexp = new StringBuilder(ipExp);
		int ans = 0;
		
		for(int i = 0; i < ipexp.length(); i++) {
			if(ipexp.charAt(i) < '0') {
				int a = ipexp.charAt(i - 2) - '0';
				int b = ipexp.charAt(i - 1) - '0';
				ans = Compute(a, b, ipexp.charAt(i));

				ipexp.setCharAt(i - 2, (char)(ans + '0'));
				
				for(int j = i + 1; j < ipexp.length(); j++) {
					ipexp.setCharAt(j - 2, ipexp.charAt(j));
				}
				

				ipexp.deleteCharAt(ipexp.length() - 1);
				ipexp.deleteCharAt(ipexp.length() - 1);
				i = i - 2;
			}
			if(ipexp.length() == 1) {
				break;
			}
		}
		
		ans = ipexp.charAt(0) - '0';
		
		
		return ans;
	}
	
	
	//�������������
	static int Compute(int a, int b, char operator) {
		
		switch(operator) {
		case '+':{
			return a + b;
		}
		case '-':{
			return a - b;
		}
		case '*':{
			return a * b;
		}
		case '/':{
			return a / b;
		}
		default:{
			return 0;
		}
		}
		
	}
	
	
}

class FileOperation{
	
	public void FileTest(File file) {
		if(file.canRead() == false) {
			System.out.println("�ļ�������");
			System.exit(0);
		}
	}
	
	public int Read(File file) {
		int key = 0;

		try (Scanner input = new Scanner(file);){
			while(input.hasNextLine()) {
				String s = input.nextLine();
				StringBuilder str = new StringBuilder(s);
				for(int i = 0; i < str.length(); i++) {
					if(str.charAt(i) == ' ') {
						str.deleteCharAt(i);
					}
				}
				for(int i = 0; i < key; i++) {
					if(str.toString().equals(Calculator.exp[i])) {
						continue;
					}
				}
				
				if(str.length() == 0) {
					Calculator.exp[key] = "ERROR\n" + "#���ʽΪ��";
				}
				else if(RegularExpressionDetection.Judge(str.toString()) == -1) {
					Calculator.exp[key] = "ERROR\n" + RegularExpressionDetection.judge;
				}
				else {
					Calculator.exp[key] = str.toString();
				}
				key++;
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return key;
	}
	
	public void writeFile(File file) {
		try (PrintWriter output = new PrintWriter(file);){
			
			for(int i = 0; i < Calculator.num; i++)
				output.println(Calculator.ans[i]);				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}