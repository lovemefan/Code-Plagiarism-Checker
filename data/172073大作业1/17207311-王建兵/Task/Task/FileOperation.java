import java.io.*;
import java.util.*;

public class FileOperation {
	//���ļ���һ��һ�еĶ�ȡ��Ϣ������Ϣ���ظ�������
	public String[] readLine(File f,String str[]) {
		int i=0;
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {
				str[i]=input.nextLine();;
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();//�쳣����֤��������쳣ʱ�ܼ������ж�������
		}
		str[i]=null;
		return str;
	}
	
	//���ļ���д��һ��һ�е����ۼ�¼
	public void writeFile(String s) {
		File f=new File("result.txt");
		try (FileWriter output=new FileWriter(f,true);){//�ڲ�����ԭ�ļ������¼���д��������
			output.write(s);
			output.write("\r\n");//����
			output.flush();//ˢ�»���������Ϣд���ļ�
		} catch (IOException e) {
			e.printStackTrace();//�쳣����֤��������쳣ʱ�ܼ������ж�������
		} 
	}
		
}
