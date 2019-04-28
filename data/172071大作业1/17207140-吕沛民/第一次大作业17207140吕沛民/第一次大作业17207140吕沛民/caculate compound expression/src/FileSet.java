import java.io.File;//����io���µ�File����ļ�
import java.io.PrintWriter;//����io���µ�PrintWriter��
import java.util.Scanner;//����util���µ�Scanner��
public class FileSet {
	public FileSet(){
		
	}
	public void writerFile(String[] str2) throws Exception//�����ļ�
	{
		File file = new File("expression2.txt");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(1);	
		}
		try(PrintWriter output = new PrintWriter(file))
		{
			for(int i=0; i < str2.length;i++)
			{
				output.println(str2[i]);
			}
			
		}
		
	}
	public String[] readFile() throws Exception{//��ȡ�ļ�����������
		File file = new File("expression1.txt");
		String[] express = new String[numberOfline()];
		int i = 0;
		try(Scanner input = new Scanner(file))
		{
			while (input.hasNext())
			{
				express[i++]= input.nextLine();
			}
		}
		return express;
	}
	public int numberOfline()throws Exception{//����ļ��ж�����
		int m =0;
		File file = new File("expression1.txt");
		try(Scanner input = new Scanner(file))
		{
			while(input.hasNext())
			{
				input.nextLine();
				m++;
			}
		}
		return m;
	}
}
