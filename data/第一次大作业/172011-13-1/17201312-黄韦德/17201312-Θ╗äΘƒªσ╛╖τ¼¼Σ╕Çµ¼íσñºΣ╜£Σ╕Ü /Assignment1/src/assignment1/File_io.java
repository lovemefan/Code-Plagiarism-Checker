package assignment1;

import java.io.*;
import java.util.Scanner;
//�ļ����������
public class File_io {
	
	public File_io() {
		
	}
	
	//���ļ��е���Ϣ����������
	public String[] outputInformation() throws Exception{
		File f1 = new File("Informations.txt");
		Scanner input = new Scanner(f1);
		if (!f1.exists()) {
			f1.createNewFile();
		}
		String[] recv = new String[1000000];
		int i = 0;
		while (input.hasNextLine()) {
			recv[i] = input.nextLine();
			i++;
		}
		input.close();
		return recv;
	}
	
	//�������е���Ϣ�����ļ���
	public static void inputInformation(String[] str) throws Exception{
		File f2 = new File("output.txt");
		if (!f2.exists()) {
			f2.createNewFile();
		}
		FileWriter output = new FileWriter(f2);
		for (int i = 0; str[i] != null; i++) {
			if (str[i+1] != null) {
				output.write(str[i] + "\r\n");
			}
			else {
				output.write(str[i]);
			}
		}
		output.close();
	}
	
}
