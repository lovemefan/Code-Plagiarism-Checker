package javaAssignment;
import java.io.*;

public class WriteFile {
	WriteFile(){
		
	}
	
	public  void write(String [] expression,String [] result){

		try{
			File writeName = new File("output.txt");//д���ļ���out.txt�����ļ����Ѵ��ڣ��򸲸ǣ��������½�
			writeName.createNewFile();
			try(FileWriter writer = new FileWriter(writeName);
				BufferedWriter file = new BufferedWriter(writer)){
				int i = 0;
				while(expression[i] != null){
					if(result[i].equals("ERROR\r\n"))//���ʽ����Ļ������ʽ��һ��
						file.write(result[i]+"#"+expression[i]+"\r\n");
					else
						file.write(expression[i]+result[i]+"\r\n");//�����ı����ʽ
					i++;
				}
				file.flush();
			}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}

}
