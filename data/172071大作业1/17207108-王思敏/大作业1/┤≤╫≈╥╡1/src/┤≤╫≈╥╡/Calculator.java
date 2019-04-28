package ����ҵ;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator{
	public static void main(String[] args) {
		File f1 = new File("src\\expression");
		File f2 = new File("src\\result");
		char[] Exp_a = new char[50];
		String[] str = new String[50];//���ʽ����
		Test r1 = new Test();
		ExpWrong r2 = new ExpWrong();
		Arithmetic r3 = new Arithmetic();
		r1.FileRead(f1,str);//��ȡ���ʽ�ļ�
		r1.coverBlank(f2);//ˢ�½���ļ�
		str = expRepeat(str);
		for(int n=0;str[n]!=null;n++) {
			str[n] = absorbEmptyChar(str[n]);//���տ��ַ�
			if(r2.wrong(str[n])) {//�жϱ��ʽ�Ƿ��쳣
				Exp_a = str[n].toCharArray();//һ�����ʽ��ÿһ���ַ�����һ���ַ�������
				int result = r3.expressionEvaluation(Exp_a); //��ֵ
				r1.FileWrite(f2,result,str[n]);//�����д�����ļ�
				r1.readResult(f2);//ÿ�ζ�ȡ����ļ��е����һ��
			}
		}
	}
	
	static String absorbEmptyChar(String str) {//���տ��ַ�
		Pattern pattern = Pattern.compile("\\s*|\t|\r");
		Matcher match = pattern.matcher(str);
		String s = match.replaceAll("");
		return s;
	}
	
	static String[] expRepeat(String[] str) {//ȥ���ظ����ʽ
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;str[i]!=null;i++) {
			if(!list.contains(str[i]))
				list.add(str[i]);
				
		}
		return list.toArray(new String[50]);
	}
}

//���ʽ������
class Arithmetic{
	
	 boolean In(char c){//�ж��Ƿ�Ϊ�����
		if((c=='+')||(c=='-')||(c=='*')||(c=='/')||(c=='(')||(c==')')||(c=='='))
			return true;
		else
			return false;
	} 

	int Operate(int a,char theta,int b) {//���мӼ��˳�����
		int num = 0;
		switch((Character)theta)
		{
			case '+':
				num = a+b;break;
			case '-':
				num = a-b;break;
			case '*':
				num = a*b;break;
			case '/':
				num = a/b;break;
		}
		return num;
	}

	char Precede(char a,char b){//�ж�����������ȼ� 
		int m=0,n=0;
		char[][] Prior = {{'>','>','<','<','<','>','>'},
						  {'>','>','<','<','<','>','>'},                    
						  {'>','>','>','>','<','>','>'},				
						  {'>','>','>','>','<','>','>'},				
						  {'<','<','<','<','<','=',' '},				
						  {'>','>','>','>',' ','>','>'},			
						  {'<','<','<','<','<',' ','='}};//�����֮������ȹ�ϵ 
		m = Level(a);
		n = Level(b);
		return Prior[m][n];
	}
	
	int Level(char a) {//��������ȼ�
		int m=0;
		switch(a)
		{
			case '+':
				m = 0;break;
			case '-':
				m = 1;break;
			case '*':
				m = 2;break;
			case '/':
				m = 3;break;
			case '(':
				m = 4;break;
			case ')':
				m = 5;break;
			case '=':
				m = 6;break;
		}
		return m;
	}

	int expressionEvaluation(char[] Exp_a){//���ʽ��ֵ
		int i = 0;
		Stack<Character> OPTR = new Stack<Character>();//����һ��������ջ
		Stack<Integer> OPND = new Stack<Integer>();//����һ��������ջ
		OPTR.push('=');
		while(Exp_a[i]!='='||OPTR.peek()!='=')//�����ʽ�ַ���������ֵ��Ϊ��=���������ջ����Ϊ��=��ʱ
		{
			if(!In(Exp_a[i]))//���ǲ��������ǲ�������ѹ�������ջ 
			{
				String str = new String(new char[]{Exp_a[i]});//�ַ�ת��Ϊ�ַ���
				for(;i<Exp_a.length;i++) {
					if(!In(Exp_a[i+1])) 
						str = str.concat(new String(new char[]{Exp_a[i+1]}));
					else
						break;
				}
				OPND.push(Integer.parseInt(str));
				i++;
			}
			else//�ǲ���������OPTRջ��Ԫ�ؽ������ȼ��Ƚ� 
			{
				if(Exp_a[i]=='('&&Exp_a[i+1]=='-') {//����Ǹ���
					OPND.push(-(Exp_a[i+2]-'0'));
					i = i+2;
					Exp_a[i] = '(';
				}
				switch(Precede(OPTR.peek(),Exp_a[i]))
				{
					case '<':
						OPTR.push(Exp_a[i]);i++;//���ȼ���ջ��Ԫ�ظߣ���ջ 
						break;
					case '=':
						OPTR.pop();i++;//������ 
						break;
					case '>'://���ȼ���ջ��Ԫ�صͣ�����ջ����������������
						int b = OPND.pop();//�ֱ��OPND������ջջ���������������м���
						int a = OPND.pop();
						char theta = OPTR.pop();
						OPND.push(Operate(a,theta,b));//������ѹ��OPNDջ
						break;
				}
			}
		}
		return OPND.pop();
		
	}
}

//���ݲ�����
class Test{
	void FileRead(File f1,String[] str){//��ȡ���ʽ�ļ������ַ���������
		int i = 0;
		try (Scanner input = new Scanner(f1);){
			while(input.hasNextLine()) {
				str[i] = input.nextLine();
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void FileWrite(File f2,int result,String str) {//�����д�����ļ�
		FileWriter fileWiter = null;
		try {
			fileWiter = new FileWriter(f2,true);
			fileWiter.write(str+result+"\n");
			fileWiter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void coverBlank(File f2) {//�Խ���ļ�����ˢ�£����ÿհ׸���ԭ������
		try (PrintWriter output = new PrintWriter(f2);){
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void readResult(File f2) {//��ȡ����ļ������һ������
		String line = null;
		try (Scanner input = new Scanner(f2);){
			while(input.hasNextLine()&&(line=input.nextLine())!=null) {
				if(!input.hasNextLine())
					System.out.println(line+"\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

//�쳣������
class ExpWrong{
	
	boolean wrong(String str) {
		if(!exp_Empty(str)) {
			System.out.println(str+"\n"+"ERROR\n#���ʽΪ�գ�\n");
			return false;
		}
		if(!exp_Bracket(str)) {
			System.out.println(str+"\n"+"ERROR\n#���ʽ���п����ţ�\n");
			return false;
		}
		if(!exp_IllegalChar(str)) {
			System.out.println(str+"\n"+"ERROR\n#���ʽ�����Ƿ��ַ���\n");
			return false;
		}
		if(!exp_Mismatch(str)) {
			System.out.println(str+"\n"+"ERROR\n#���ʽ�����Ų�ƥ�䣡\n");
			return false;
		}
		if(!exp_OperContinuity(str)) {
			System.out.println(str+"\n"+"ERROR\n#���ʽ�������������\n");
			return false;
		}
		if(!exp_BeforeOperator(str)) {
			System.out.println(str+"\n"+"ERROR\n#���ʽ�������ǰ����������\n");
			return false;
		}
		if(!exp_AfterOperator(str)) {
			System.out.println(str+"\n"+"ERROR\n#���ʽ�������������������\n");
			return false;
		}
		if(!exp_AfterEqualSign(str)) {
			System.out.println(str+"\n"+"ERROR\n#���ʽ��=�������һ���ַ���\n");
			return false;
		}
		if(!exp_beforeLeftBracket(str)) {
			System.out.println(str+"\n"+"ERROR\n#���ʽ��(�ǵ�һ���ַ���(ǰ���������\n");
			return false;
		}
		if(!exp_afterRightBracket(str)) {
			System.out.println(str+"\n"+"ERROR\n#���ʽ��)�����������Ⱥţ�\n");
			return false;
		}
		return true;
	}
	
	boolean exp_Empty(String str){//�жϱ��ʽ�Ƿ�Ϊ��
		if(str.equals(""))
			return false;
		return true;
	}
	
	boolean exp_Bracket(String str) {//�жϱ��ʽ�Ƿ��п�����
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='('&&str.charAt(i+1)==')')
				return false;
		}
		return true;
	}
	
	boolean exp_IllegalChar(String str){//�жϱ��ʽ�Ƿ��зǷ��ַ�
		Pattern pattern = Pattern.compile("[^0-9\\+\\-\\*\\/\\(\\)\\=]");
		for(int i=0;i<str.length()-1;i++) {
			Matcher match = pattern.matcher(str.substring(i,i+1));
			if(match.matches())
				return false;
		}
		return true;
	}
	
	boolean exp_Mismatch(String str){//���ʽ�����Ų�ƥ��
		int num=0;
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c=='(')
				num++;
			else if(c==')') {
				if(num==0)//��������ȴ��һ��������
					return false;
				else
					num--;
			}
		}
		if(num!=0)
			return false;
		return true;
	}
	
	boolean exp_OperContinuity(String str){//���ʽ�����������
		Pattern pattern = Pattern.compile(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*");
			Matcher match = pattern.matcher(str);
			if(match.matches())
				return false;
		return true;
	}
	
	boolean exp_BeforeOperator(String str) {//�����ǰ��������
		Pattern pattern = Pattern.compile("^[\\+\\-\\*\\/].*||.*[(][\\+\\*\\/].*");
			Matcher match = pattern.matcher(str);
			if(match.matches())
				return false;
		return true;
	}
	
	boolean exp_AfterOperator(String str) {//���������������
		Pattern pattern = Pattern.compile(".*[\\+\\-\\*\\/][\\=]$||.*[\\+\\-\\*\\/][)].*");
			Matcher match = pattern.matcher(str);
			if(match.matches())
				return false;
		return true;
	}
	boolean exp_AfterEqualSign(String str) {//�Ⱥź��滹���ַ�
		Pattern pattern = Pattern.compile(".*[\\=]$");
			Matcher match = pattern.matcher(str);
			if(!match.matches())
				return false;
		return true;
	}
	
	boolean exp_beforeLeftBracket(String str) {//���ʽ��(�ǵ�һ���ַ���(ǰ�������
		Pattern pattern = Pattern.compile(".*[0-9][(].*");
		for(int i=0;i<str.length()-2;i++) {
			Matcher match = pattern.matcher(str);
			if(match.matches())
				return false;
		}
		return true;
	}
	
	boolean exp_afterRightBracket(String str) {//���ʽ��)�����������Ⱥţ�
		Pattern pattern = Pattern.compile(".*[)][0-9].*");
		for(int i=0;i<str.length()-2;i++) {
			Matcher match = pattern.matcher(str);
			if(match.matches())
				return false;
		}
		return true;
	}
}
