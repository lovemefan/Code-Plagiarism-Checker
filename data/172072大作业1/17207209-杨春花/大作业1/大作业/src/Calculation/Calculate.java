package Calculation;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Calculate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("src\\calcurator");	//\\��ת���
		File f2= new File("src\\calculrator");
		String[] read=read(f);
		String[] sulte=new String[read.length];
		for(int c=0;c<read.length;c++) {
			int k=check(read[c]);//�жϱ��ʽ�Ϸ���
			if(k==0) {
				read[c]=read[c].replaceAll(" ", "");//ȥ���հ׸�
				sulte[c]=calcuratorOfExpression(read[c]);//��ý��
				read[c]=read[c]+"=";
			}
			else {
				switch(k) {
				case 1:
					sulte[c]="error�����ʽΪ��";
					break;
				case 2:
					sulte[c]="error,���ʽ���Ƿ��ַ�";
					break;
				case 3:
					sulte[c]="error,���ʽ���п�����";
					break;
				case 4:
					sulte[c]="error,�����ǰ��������";
					break;
				case 5:
					sulte[c]="error,���������������";
					break;
				case 6:
					sulte[c]="error,���Ų�ƥ��";
					break;	
				case 7:
					sulte[c]="error,���������";
					break;	
				case 8:
					sulte[c]="error,���ŷǵ�һ���ַ���֮ǰ�������";
					break;	
				case 9:
					sulte[c]="error,���ŷ����һ���ַ���֮���������";
					break;	
				}
				read[c]="";
			}
		}
		try (PrintWriter output = new PrintWriter(f2);){
			for(int hu=0;hu<read.length;hu++) {
			output.println(read[hu]+sulte[hu]);	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static String[] transformation(String m) {//�ѱ��ʽ�ַ���ת��Ϊ����ַ���
		char[] a=m.toCharArray();
		char[] b=new char[a.length];
		int p1=0;
		int tax=0;
		int px=0;
		String[] n=new String[20];
		for(int i=0;i<a.length;i++) {
			if(!Character.isDigit(a[i])) {
				if(i!=tax) {
					n[p1]=m.substring(tax,i);
					tax=i+1;
					p1++;
				}else {
					tax=i+1;
				}
				n[p1]=""+a[i];
				p1++;
				px=i;
			}
		}
		if(a.length-1!=px) {
			n[p1]=m.substring(px+1);
			p1++;
		}
		n=Delete(n);
		return n;
	}
	
	public static int check(String m) {//���Ϸ���
		int a=0;
		m=m.replaceAll(" ", "");
		if(m.matches(".*[^0-9&&[^)]][+[-[*[/]]]].*"))//�����ǰ��������
			a=4;
		if(m.matches("[+[-[*[/]]]].*"))//�����ǰ��������
			a=4;
		if(m.equals(""))//���ʽΪ�� 
			a=1;
		if(m.matches(".*[(][)].*"))//������
			a=3;
		if(m.matches(".*[+[-[*[/]]]][^0-9&&[^(]].*")) //���������������
			a=5;
		if(m.matches(".*[+[-[*[/]]]]")) //���������������
			a=5;
		if(m.matches(".*[0-9[)]][(].*"))
			a=8;//System.out.println("error,���ŷǵ�һ���ַ���֮ǰ�������");
		if(m.matches(".*[)][0-9[(]].*"))
			a=9;//System.out.println("error,���ŷ����һ���ַ���֮���������");
		if(m.matches(".*[+[-[*[/]]]]{2}.*")) //���������
			a=7;
		
		String pip=m.replaceAll("[^()]", "");
		for(int n=0;n<10;n++) {
		pip=pip.replace("()","");
		}
		if(!pip.equals("")) {
			a=6;//System.out.println("error,���Ų�ƥ��");
		}	
		if(!m.matches("[([)[/[*[-[+[0-9]]]]]]]*"))//���Ƿ��ַ�
			a=2;
		return a;
		
	}
	public static String calcuratorOfExpression(String m) {//������ʽ
		String[] mm=transformation(m);
		String[] b=InversePolishType(mm);//ת��Ϊ�沨��ʽ
		String x=OperateSult(b);//�沨��ʽ��ֵ
		return x;
	}

	public static String[] read(File f) {//��ȡ�ļ�
		int i=0;
		String[] isReturn =new String[30];
		try (Scanner input = new Scanner(f);){
			while(input.hasNext()) {
				String s = input.nextLine();//s��һ�鸴�ϱ��ʽ
				isReturn[i]=s;
				i++;
				if(i>1) {
					for(int g=0;g<i-1;g++) {
						if(isReturn[i-1].equals(isReturn[g])) 
							i--;
					}
				}
				//System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		isReturn=Delete(isReturn);
		return isReturn;
	}	
	public static String operate(String m,String theat,String n) {//�򵥼���
		double f1,f2,total = 0;
		String ch;
		f1=Double.parseDouble(m);
		f2=Double.parseDouble(n);
		switch (theat)
			{
				case "+":
					total=f1+f2;
				break;
				case "-":
					total=f1-f2;
				break;
				case "*":
					total=f1*f2;
				break;
				case "/":
					total=f1/f2;
				break;
			}
			ch=""+total;
			return ch;
	}
public static String OperateSult(String[] b) {//�沨��ʽ��ֵ
		String theat,e = null;
		String m,n;
		int j=0;
		Stack stack=new Stack();//ջ
		while(j<b.length) {
			char[] ae=b[j].toCharArray();
			if(Character.isDigit(ae[0])) {//�ж��Ƿ�������
				int ka=Integer.parseInt(b[j]);
				stack.push(b[j]);
			}
			else {
				n=(String)stack.pop();
				m=(String)stack.pop();
				theat=b[j];
				stack.push(operate(m,theat,n));
				e=(String)stack.peek();
			}
			j++;
		}
		return e;
	}
	public static String[] InversePolishType(String a[]) {//ת�����沨��ʽ
		String[] inverse=new String[a.length];
		Stack stack=new Stack();
		a=Add(a);
		stack.push("#");
		int i=0;
		int j=0;
		String e=(String) stack.peek();
		i++;
		while(e!="#"||a[i]!="#") {
			char[] ae=a[i].toCharArray();
			if(Character.isDigit(ae[0])) {
				inverse[j]=a[i];
				i++;
				j++;
			}
			else {
			switch(Judge(e,ae[0])) {
			case '<':
				stack.push(a[i]);
				i++;
				break;
			case '=':
				stack.pop();
				i++;
				break;
			case '>':
				inverse[j]=e;
				j++;
				stack.pop();
				break;
			}
			e=(String) stack.peek();
			}
		}
		inverse=Delete(inverse);
		return inverse;
	}

	public static String[] Add(String[] add) {
		String[] newchar=new String[add.length+2];
		newchar[0]="#";
		newchar[add.length+1]="#";
		for(int i=0;i<add.length;i++) {
			newchar[i+1]=add[i];
		}
		return newchar;
	}
	public static String[] Delete(String[] del) {//ɾ������Ŀ�ֵ
		int b=0;
		for(int i=0;i<del.length;i++) {
			if(del[i]!=null) {
				b++;
			}
		}
		String[] a=new String[b];
		for(int j=0;j<b;j++) {
			a[j]=del[j];
		}
		return a;
		
	}
	public static int PD(char m) {//�ж����ȼ�
		int c=9;
	 	switch(m)
		{
			case '+':
				c=0;
				break;
			case '-':
				c=1;
				break;
				
			case '*':
				c=2;
				break;
			case '/':
				c=3;
				break;
			case '(':
				c=4;
				break;
			case ')':
				c=5;
				break;
			case '#':
				c=6;
				break;
			
		}
	 	return c;
	}
	public static char Judge(String e,char m) {
		int i,j;
		char c;
	 	char[][] Prior= { {'<','<','<','<','<','>','>'},
		 					{'>','<','<','<','<','>','>'},
		 					{'>','>','>','>','<','>','>'},
		 					{'>','>','>','>','<','>','>'},
		 					{'<','<','<','<','<','=',' '},
		 					{'>','>','>','>',' ','>','>'},
		 					{'<','<','<','<','<',' ','='}
		 				  };
	 	char[] al=e.toCharArray();
		i=PD(al[0]);
		j=PD(m);
		c=Prior[i][j]; 
		return c;
	}
}
