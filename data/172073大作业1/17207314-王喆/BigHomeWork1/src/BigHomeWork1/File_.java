package BigHomeWork1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class File_ {
	File file;
	// �޲ι���
	public File_(){
		
	}
	// ����һ���ļ� ����
	public File_(String newFile){
		file = new File(newFile);
	}
	// ���file
	public File getFile(){
		return file;
	}
	// ����file
	public void setFile(File newFile){
		file = newFile;
	}
	// ���ı���ȡ���ݣ� 
	public String[] readFile(File newFile) throws FileNotFoundException{
		Scanner input = new Scanner(newFile);
		int num = 0;
		String[] a = new String[500];
		while (input.hasNext()){
			a[num] = input.nextLine();
			num ++;
		}
		input.close();
		return a;
	}
	// ���ı������ı�����
	public void writeFile(String[] newStr,String[] newStr2,String newStr1) throws FileNotFoundException{
		File f = new File(newStr1);
		PrintWriter output = new PrintWriter(f);
		for(int i = 0;newStr[i] != null;i ++){
		    output.println(newStr[i] + "\n");
		    InputCheck b = new InputCheck(newStr2[i]);
		    if(b.judgeAll() == false){
		    	switch(b.getError()){
		    	case 0:
		    		break;
		    	case 1:
		    		output.println("ERROR\n#���ʽ�к��в��Ϸ��ַ�\n");
		    		break;
		    	case 2:
		    		output.println("ERROR\n#���ʽ�������������ʹ�ô���\n");
		    		break;
		    	case 3:
		    		output.println("ERROR\n#���ʽ������ƥ�����\n");
		    		break;
		    	case 4:
		    		output.println("ERROR\n#���ʽ�������ʹ�ô���\n");
		    		break;
		    	case 5:
		    		output.println("ERROR\n#���ʽβ�����ʹ�ô���\n");
		    		break;	
		    	}
		    }
		}
		output.close();
	}

}

