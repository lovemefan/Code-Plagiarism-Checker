import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class file {
	
	
	//�ļ�д�룬������
	public void outPut() throws IOException{
		File file = new File("GSR.txt");
		
		Scanner outPut = new Scanner(file);
		
		while(outPut.hasNext()){			//��ѭ��д��ÿһ��ʽ�ӵĽ��
			String s = outPut.next();

			System.out.println(s);
		}

		
		outPut.close();


    }
	

}
