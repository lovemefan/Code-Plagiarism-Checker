package counter;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreateFile {
	//���췽��
	public CreateFile(){
		
	}
	
	//�����ļ��õ�Ŀ���ļ�
	public void plintFile(String[] sentence) throws Exception{
		java.io.File file = new java.io.File("counter2.txt");
		if(file.exists()){
			System.out.println("�ļ��Ѿ�����");
			System.exit(1);
		}
		//����һ���ļ�
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		for(int i = 0;i < line() ;i ++)
		 {
			output.println(sentence[i]);
		 }
		output.close();
	}
	
	//����ļ����ݵķ���
	public String[] scannerFlie() throws Exception{
		int i = 0;
		String[] expression = new String[line()];
		java.io.File file = new java.io.File("counter1.txt");
		if(!file.exists()){
			System.out.println("�ļ�������");
			System.exit(1);
		}
		//Ϊ�ļ�����һ��Scanner
		Scanner input = new Scanner(file);
		//���ļ�
		while (input.hasNext()){
			expression[i++] = input.nextLine();
		}
		//�ر��ļ���
		input.close();
		return expression;
	}
	
	//����ļ��ж����д���
	public int line() throws FileNotFoundException{
		int p = 0;
		java.io.File file = new java.io.File("counter1.txt");
		Scanner input = new Scanner(file);
		while (input.hasNext()){
			input.nextLine();
			p++;
		}
		input.close();
		return p;
	}
	
}
