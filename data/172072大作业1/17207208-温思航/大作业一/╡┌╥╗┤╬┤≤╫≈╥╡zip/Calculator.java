package ��һ�δ���ҵ;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class  Calculator{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s1=new String[100];
		String[] s2=new String[100];
		
		File f1 = new File("src\\\\dazuoye");
		File f2 = new File("src\\\\dazuoyejieguo");
		s1=Txt.readTxt1(f1);
		Txt.writeFile(s1,f2);	
	}
	//�ַ�������ת�����ַ��б�
	public static ArrayList<String> change(String s) {
		ArrayList<String> L=new ArrayList<>();
		String str="";
			for(int i=0;i<s.length();i++) {
				if(Character.isDigit(s.charAt(i))) {
						str=str+s.charAt(i);
					}
				else {  
					if(str!="") {
						L.add(str);
					}
						L.add(s.charAt(i)+"");
						str="";
				}
			}
			if(str!="")
				L.add(str);
			return L;
	}	
	//ת��Ϊ�沨��ʽ
	public static ArrayList<String> nibolanshi(ArrayList<String> L) {
		String chr;
		/*double d;
		double e;*/
	//	Stack<Integer> optr=new Stack<Integer>();
		Stack<String> opnd=new Stack<String>();
		ArrayList<String> List=new ArrayList<>();
		for(int i=0;i<L.size();) {
			chr=L.get(i);
			if(Character.isDigit(chr.charAt(0)))
			{
				List.add(chr);		
				i++;
			}
			else
			{
				if(!opnd.isEmpty()) {
					switch(Precede(opnd.peek(),chr))//�Ƚ�ջ���������͵�ǰ���������ȼ�
					{
						case'<':
								opnd.push(chr);
								i++;//ջ�����ȼ��ͣ�ѹ��ջ��
								break;
						case'=':
								opnd.pop();		
								i++;//���ȼ���ͬ��������				
								break;
						case'>':									
								List.add(opnd.pop());//ջ�����ȼ��ߣ�ջ��Ԫ�س�ջ���ٽ���Ԫ��ѹջ
								break;
					}
				}
				else
				{
					opnd.push(chr);	
					i++;
				}
			}
		}
					while(!opnd.empty()) {
						List.add(opnd.pop());
						}  
				return List;
		}
	
	//�Ƚ�����Ȩ
	public static char Precede(String a,String b) {
		int m=0,n=0;
		char operat[][]={
				{'>','>','<','<','<','>','>'},
				{'>','>','<','<','<','>','>'},
				{'>','>','>','>','<','>','>'},
				{'>','>','>','>','<','>','>'},
				{'<','<','<','<','<','=',' '},
				{'>','>','>','>',' ','>','>'},
				{'<','<','<','<','<',' ','='}};
	switch(a)
	{
		case"+":m=0;
				break;
		case"-":m=1;
				break;
		case"*":m=2;
				break;
		case"/":m=3;
				break;
		case"(":m=4;
				break;
		case")":m=5;
				break;
		case"#":m=6;
				break;
	}
	switch(b)
	{
		case"+":n=0;
				break;
		case"-":n=1;
				break;
		case"*":n=2;
				break;
		case"/":n=3;
				break;
		case"(":n=4;
				break;
		case")":n=5;
				break;
		case"#":n=6;
				break;
	}
	
		return operat[m][n];
	 }
	//���ʽ�����ж��Ƿ��ʽ��ȷ
	public static int judgmentexpression(String s){
				//���ʽΪ��
				if(s.length()==0) 
					return 1;
					
				else
				{
						/*test1(s);
						test2(s);
						test3(s);*/
						if(test1(s)!=0)
							return test1(s);
						else
							if(test2(s)!=0)
								return test2(s);
						else
							if(test3(s)!=0)
								return test3(s);								
				}			
		return 0;
		
	}
	public static int test1(String s) {
		for(int i=0;i<s.length();i++)
		{
				char chr =s.charAt(i);
				//�Ƿ��ַ�
				if(!Character.isDigit(chr)&&chr!='('&&chr!=')'&&chr!='+'&&chr!='-'&&chr!='*'&&chr!='/') 					
					return 3; 
				//���Ų�ƥ��
				else{
					Stack<Character> stack = new Stack<Character>();
					for(int j = 0; j < s.length(); j++){		
						char c = s.charAt(j);
						if(c == '('){
							stack.push('(');
						}
						else
							if(c == ')')
							{						
								if(!stack.isEmpty())
									stack.pop();
								else
									return 7;
							}
						}
							if(!stack.isEmpty())
								return 7;
					}							
			}
			return 0;
	}
	public static int test2(String s) {
		//���������			
		for(int i=0;i<s.length()-1;i++)
			if(!Character.isDigit(s.charAt(i)) && !Character.isDigit(s.charAt(i+1)) 
				&& s.charAt(i)!='(' && s.charAt(i)!=')'
				&& s.charAt(i+1)!='(' && s.charAt(i+1)!=')')			
				return 4;
		for(int i=0;i<s.length()-1;i++) {
			char chr=s.charAt(i);
			char chh=s.charAt(i+1);
			
			//��������Ϊ��	
			if(chr=='(' && chh==')')
				return 2;
			//�����ŷǵ�һ���ַ���֮���������
			 else
				 if(s.matches(".*[)][^+&&[^*&&[^-&&[^/&&[^)]]]]].*"))
				return 6;
			
		}
		return 0;
	}
	public static int test3(String s) {
		for(int i=1;i<s.length();i++) {
			char chr=s.charAt(i);
			char chq=s.charAt(i-1);
			char c=s.charAt(0);
			char chl=s.charAt(s.length()-1);
			//�����ŷǵ�һ���ַ���֮ǰ�������
			if(s.matches(".*[(][^+&&[^*&&[^-&&[^/&&[^(]]]]][(].*"))
				return 5;
			//�����ǰ��������
			else if((!Character.isDigit(chq)&&(chr=='+'||chr=='-'||chr=='/'||chr=='*')&&chq!=')')||(c=='+'||c=='-'||c=='/'||c=='*'))
				return 9;
			//���������������
			 else
				 if(chl=='+'||chl=='-'||chl=='/'||chl=='*')
				return 8;
		}
		return 0;
	}
	//�����沨��ʽ
	public static  String calculate(ArrayList<String> List) {
		double sum = 0;
		String result;
		char theta;
		Stack<String> stack=new Stack<String>();
		for(int i=0;i<List.size();i++) {
			if(Character.isDigit(List.get(i).charAt(0)))
				stack.push(List.get(i));
			else
			{
				double e=Double.parseDouble(stack.pop());
				double d=Double.parseDouble(stack.pop());
				theta=List.get(i).charAt(0);
				
				switch(theta)
				{
		
				case'+':sum=d+e;
						break;
				case'-':sum=d-e;
						break;
				case'*':sum=d*e;
						break;
				case'/':sum=d/e;
						break;
				}
				result=String.valueOf(sum);
				stack.push(result);
			}
		}
				return stack.pop();
	}
}	
class Txt{
	public static String[] readTxt1(File f1) {//������ʽ�ļ�
		String[] s=new String[100];
		int i=0;
		try (Scanner input = new Scanner(f1);){
			while(input.hasNextLine()) {//�������һ�������ִ��			
				s[i] = input.nextLine();
				s[i]=s[i].replace(" ", "");
				i++;
			}
		} catch (FileNotFoundException e) {//�����쳣ֵ
			e.printStackTrace();	
		}
		return s;
		
	}
	
	public static void writeFile(String[] s2,File f2) {//д����ʽ����ļ�
		try (PrintWriter output = new PrintWriter(f2);){
			String s="";
			int k=0;
			for(int i=0;i<s2.length;i++) {
				if(s2[i]!=null) {
			for(int j=0;j<i;j++) {
				if(s2[i].equals(s2[j])) {
					k++;
					}			
			}
				int x=Calculator.judgmentexpression(s2[i]);
				if(x==0&&k==0) {
					s=Calculator.calculate(Calculator.nibolanshi(Calculator.change(s2[i])));
					output.println(""+s2[i]+"="+s);
				}
				else if(x>=1)
				{
					switch(x) {
					case 1:
							output.println("ERROR");
							output.println("#���ʽΪ��");
							break;
					case 2:
							output.println("ERROR\r\n#���ʽ���п�����");
							break;
					case 3:
							output.println("ERROR\r\n#���ʽ�����Ƿ��ַ�");
							break;
					case 4:
							output.println("ERROR\r\n#���������");
							break;
					case 5:
							output.println("ERROR\r\n#���ŷǵ�һ���ַ���֮ǰ�������");
							break;
					case 6:
							output.println("ERROR\r\nС���ź�������������ŷ����һ���ַ�");
							break;
					case 7:
							output.println("ERROR\r\n#���Ų�ƥ��");
							break;
					case 8:
							output.println("ERROR\r\n#���������������");
							break;
					case 9:
							output.println("ERROR\r\n#�����ǰ��������");
							break;
						}
					}	
				}
			}																	
		}	catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}


