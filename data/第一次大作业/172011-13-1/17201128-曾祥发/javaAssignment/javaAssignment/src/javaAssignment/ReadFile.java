package javaAssignment;
import java.io.*;

public class ReadFile {
	
	ReadFile(){
		
	}
	
	public  void Read( String [] expression){//��ȡ�ļ�
		try(FileReader reader = new FileReader("input.txt");
			BufferedReader file = new BufferedReader(reader)){
			String line;
			int i = 0;
			while((line = file.readLine()) != null){//���ж�ȡ�ļ�
				if(line.equals("")){//���в���
					continue;
				}
				expression[i] = line.replaceAll(" ", "");//����ȡ�������ַ������ո�ȥ��������ʽ����
				i++;
			}
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

}
