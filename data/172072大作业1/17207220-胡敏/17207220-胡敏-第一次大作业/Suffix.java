package ����ҵ;//�����ó��沨��ʽ��ջ,����������˳��,ջ�Ͷ��е�ʹ��,�����ǰû��������,�ļ����

import java.util.Queue;
import java.util.Stack;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.io.IOException;
//9+(3-1)*3+10/2
//(1-15+16)*90
//(15+5)*14-6*(3+32-5)

public class Suffix {
	public static void filetoexp(String a,File fw) throws IOException {
	Stack<String> exp=new Stack<String>();//
	Stack<String> dig=new Stack<String>();
	Queue<String> suff=new LinkedList<String>();
	
//	Scanner input=new Scanner(System.in);
//	String a=input.nextLine();//��ȡһ�����ʽ
//	System.out.println(a);
	if(a.isEmpty()) {
		System.out.println("ERROR\n#���ʽΪ��");
		return;
	}
	int left=0;
	int right=0;
	for(int i=0;i<a.length();i++) {
		char e=a.charAt(i);
		if(e=='(') {
			left++;
		}
		if(e==')') {
			right++;
		}
	}
	if(right!=left) {
		System.out.println("ERROR\n#���Ų�ƥ��\n");
		return;
	}
	
	for(int i=0;i<a.length();i++) {//���沨��ʽ
		
		char b=a.charAt(i);
		String str0=String.valueOf(b);
		
		if(b=='(') {
			exp.push(str0);
			//continue;
		}
		else if(b==')') {
			String c=(String)exp.pop();
			if(c.equals("(")) {
				System.out.println("ERROR\n#���ʽ���п�����\n");
				return;
			}
			while(!c.equals("(")&&!exp.isEmpty()) {
				suff.offer(c);
				c=(String)exp.pop();
						}
		//	suff.offer(c);
		}
		else 
		
		if(b>='0'&&b<='9'){//����������ʱ
	
			if(i+1!=a.length())//��Ҫ��������
			{
				dig=Linkdig(dig,str0,a,i,suff);
				
				if((a.charAt(i+1)<'0'||a.charAt(i+1)>'9')) {
					String str4=dig.pop();
					suff.offer(str4);
					}
			}
			else if(i+1==a.length())
			{//��������
				dig=Linkdig(dig,str0,a,i,suff);
				String str4=dig.pop();
				suff.offer(str4);
			}
		}
		//������������+������-������*������/�������ջ�е���ջԪ�ز������
		//ֱ���������ȼ����ͻ��ߡ�(����Ϊֹ������Ϊֹ����Ԫ�ز���ջ����
		else if(b=='+'||b=='-'||b=='/'||b=='*') {
			
			if(i+1!=a.length()) {
				if('+'==a.charAt(i+1)||a.charAt(i+1)=='-'
								||a.charAt(i+1)=='*'||a.charAt(i+1)=='/') {
					System.out.println("ERROR\n#���������\n");
					return;
				}
			}

//�����ǰû���������������֮ǰֻ��������������")"
			
			if(i==0) {
				System.out.println("ERROR\n#�����ǰ��������\n");
				return;
			}
			else 
			{
				String qian=String.valueOf(a.charAt(i-1));
				if(!qian.equals(")")&&(!qian.matches("[0-9.0]{1,}"))){
							System.out.println("ERROR\n#�����ǰ��������\n");
							return;
						}
			}
			
			if(i==a.length()-1) {
				System.out.println("ERROR\n#���������������\n");
				return;
			}
			else 
			{
				String hou=String.valueOf(a.charAt(i+1));
				if(!hou.equals("(")&&(!hou.matches("[0-9.0]{1,}"))){
							System.out.println("ERROR\n#���������������\n");
							return;
						}
			}
			
			if(exp.isEmpty()) {
				exp.push(str0);//ֻ�ڿ�ջʱ����һ��
			}
			else if(!exp.isEmpty()) 
			{
				String str7=exp.peek();
				while(!(
								(
									str0.equals("*")||str0.equals("/")
								)
								&
								(
									str7.equals("+")||str7.equals("-")
								)
						)
							&!str7.equals("(")) {
					if(!exp.isEmpty()) {
						suff.offer(exp.pop());
					}
					else {
						break;
					}
					if(!exp.isEmpty()) {
						str7=exp.peek();
					}
					else {
						break;
					}
				}
				exp.push(str0);
			}
		}
		else {//���Ƿ��ַ�
			System.out.println("ERROR\n#���ʽ�����Ƿ��ַ�\n");
			return;
		}
	}//forѭ������
	while(!exp.isEmpty()) {//Stack.peek��ջ��Ԫ��
		suff.offer(exp.pop());
	}
		int i=0;
		int size=suff.size();
		String[] p=new String[size];
		for(String q : suff){
			p[i]=q;
			i++;
//	        System.out.println(q);//չʾ�沨��ʽ
	    }
		
		String zy=Calculate.suffixtocal(p);
		String output=a.concat(zy);
		System.out.println(output);
		
//		fo.writeFile(f);//������д���ļ���������ԭ������
//		try (PrintWriter hzy= new PrintWriter(fw)){//�ı������ӡ�����ʽ����ʽ
//			hzy.println(output);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} 		
		
		FileWriter f= null;
		try {//����ļ����ڣ���׷�����ݣ�����ļ������ڣ��򴴽��ļ�
			f= new FileWriter(fw, true);
			} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(f);//pw
		pw.println(output);//��������
		pw.flush();
		try {
			f.flush();
			pw.close();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		File file=new File("src\\output");//д�ļ�
//		Writer out=new FileWriter(file);
//		out.write("");
//		out.close();
}

	private static  Stack<String> Linkdig(Stack<String> dig,String str0,String a,int i,Queue<String> suff) {
		if(dig.isEmpty())
		{
			dig.push(str0);
		}
			else if(!dig.isEmpty()) 
			{
				String str1=dig.pop();//(String)dig.pop();
				String str2=str1.concat(str0);
				dig.push(str2);
			}
		return dig;
		}
}