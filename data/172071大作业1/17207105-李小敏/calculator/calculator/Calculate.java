package bigAssignments.calculator;
import java.io.*;

public class Calculate {
	double result; // ���ʽ������
	// ���³�ʼ������ļ�
	void InitFile(File f) throws FileNotFoundException {
		try(PrintWriter output = new PrintWriter(f);){
			output.print("");
		}
	}
	// �ж����ȼ�
	int Index(char ch) {
			if(ch == '+')
				return 0;
			else if(ch == '-')
				return 1;
			else if(ch == '*')
				return 2;
			else if(ch == '/')
				return 3;
			else if(ch == '(')
				return 4;
			else if(ch == ')')
				return 5;
			else
				return 6;
	}
	// ��ȡ���ȼ�
	char Prior(int i,int j) {
		char[][] prior = {{'>','>','<','<','<','>','>'}, 
						  {'>','>','<','<','<','>','>'},
						  {'>','>','>','>','<','>','>'},
						  {'>','>','>','>','<','>','>'},
						  {'<','<','<','<','<','=',' '},
						  {'>','>','>','>',' ','>','>'},
						  {'<','<','<','<','<',' ','='}};
		return prior[i][j];
	}
	double Operate(double n1, char optr, double n2) {
		if(optr == '+')
			return n1+n2;
		else if(optr == '-')
			return n1-n2;
		else if(optr == '*')
			return n1*n2;
		else
			return n1/n2;
	}
	// ����
	void TakeResult(String exp) {
		exp = '#' + exp + '#';
		Stack stack = new Stack(exp); // ����ջ����
		stack.pushOPTR(exp.charAt(0));
		for(int i=1; i<exp.length(); i++) {
			char ch = exp.charAt(i);
			if(("" + ch).matches("[\\+\\-\\*\\/\\(\\)\\#]")) {
				int curr = Index(ch);
				int pre = Index(stack.peakOPTR());
				if(Prior(pre, curr) == '>') {
					i--;
					double num1 = stack.PopOPND();
					double num2 = stack.PopOPND();
					result = Operate(num2,stack.PopOPTR(),num1);
					stack.pushOPND(result);
				}else if(Prior(pre, curr) == '=')
					stack.PopOPTR();
				else if(Prior(pre, curr) == '<') {
					stack.pushOPTR(ch);
					}
			}
			else if(ch == '#' && i != 1)
				break;
			else {
				String number  = "" + ch;
				while(("" + exp.charAt(i+1)).matches("[^\\+\\-\\*\\/\\)\\#]")) 
					number += exp.charAt(++i);
				double num = Double.parseDouble(number);
				stack.pushOPND(num);
			}
		}
		
	}
	void GetResult(File f,String exp) {
		try {
			FileWriter fw = new FileWriter(f,true);
			TakeResult(exp);
			fw.write("=" + result + "\n\n"); // �����ʽд���ĵ�
			fw.close();
		}catch(IOException  e) {
			e.printStackTrace();
		}
	}
}
