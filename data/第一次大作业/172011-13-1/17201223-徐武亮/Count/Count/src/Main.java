import java.io.*;
import java.util.*;

public class Main {
	static Operate ope = new Operate();


	public static void main(String[] args) throws Exception{
		String[] str=delete();//�õ�ɾ���ո���ظ����ʽ�ı��ʽ����
		Scanner input = new Scanner(System.in);
		System.out.println("�����뱣�����������ļ��ľ���·����");
		String path1 = input.nextLine();
		File file = new File(path1);
		PrintWriter output = new PrintWriter(file);
		ope.checkout();
		String[] resul = ope.getresult();//�õ����ʽ���
		boolean[] corre = ope.getcorrect();
		for (int i=0 ;i<str.length ; i++){//д���ļ���
			if (corre[i] ==  false){
				output.println(str[i]);
				output.println("ERROR");
				output.println("#"+resul[i]);
				output.println("========================================================================================================================================");
			}
			else{
				output.println(resul[i]);
				output.println("========================================================================================================================================");
			}	
			
		}
		output.close();
	}
	
	public static String[] in() throws Exception{//������ʽ�ļ�
		
		Scanner input = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		System.out.println("������Ҫ����ı��ʽ�ļ��ľ���·����");
		String path = input.nextLine();
		File file = new File(path);
		Scanner in = new Scanner(file);
		while (in.hasNextLine()){//��ȡ�ļ�
			String a = in.nextLine();
			String b = a.replace(" ","");//ȥ�����ʽ��Ŀո�
			list.add(b);//��ȥ���ո��ı��ʽ�ӵ��б���
		} 
		String[] str1 = new String[list.size()];
		str1 =  list.toArray(str1);
		in.close();  
		return str1;
	}  
	
	public static String[] delete()throws Exception{//����ȥ���ظ��ı��ʽ
		String[] str2=null ;
		str2 = in();
		TreeSet<String> tr = new TreeSet<String>();//TreeSet����û���ظ��ģ������ʽ�����ȥ�ظ�
		String[] str3=null;
		
		for (int i=0;i<str2.length;i++){
			tr.add(str2[i]);
		}
		str3 = new String[tr.size()];
		for (int j=0;j<str3.length;j++){//�õ�û���ظ����ʽ���ַ�������
			str3[j]=tr.pollFirst();
		}
		String[] str4 = new String[str3.length];
		for (int j=0;j<str3.length;j++){//��ÿ�����ʽ��#���ڼ���
		str4[j]=str3[j]+"#";
		}
		ope.set(str4);
		return str3;
	}
	

}
