
import java.io.*;
public class FileWrite {
	public void fileWrite(String[] result) throws IOException{
		File file = new File("result.txt");// �����ļ�
		
		PrintWriter output = new PrintWriter(file);
		for(int i = 0;i < result.length;i ++){
			if(result[i] != null){ // �жϲ�Ϊ��
				output.println(result[i]);// ���ļ�д����Ϣ
			}
		}
		output.close();// �ر��ļ�
	}
}

