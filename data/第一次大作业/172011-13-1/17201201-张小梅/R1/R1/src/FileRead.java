import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRead {
	
	ArrayList<String> str = new ArrayList<String>();//����һ���ɱ䳤������
	
	//���ļ�input.txt��ȡ���е�����
	public FileRead() {  //�޲ι��캯��
		File file = new File("input.txt");
		Scanner input = null ;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(input.hasNext()){
		    str.add(input.nextLine());
		}		
		System.out.println("�ļ�input.txt�����е�����Ϊ:" + str); //�ڿ���̨��������������������str[]
	}
	
	public ArrayList<String> getStr() {	
		return str;		
	}

}
