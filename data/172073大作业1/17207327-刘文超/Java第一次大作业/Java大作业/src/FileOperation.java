import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class FileOperation {//�ı�������
	String[] ss = new String[20];
	int i =0;
	public String[] readLine(File f) {//����Ϊ��λ��ȡ���ݲ����    �ļ���
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {//scanner��һ����û������
				String s = input.nextLine();//��scanner�ж�ȡһ�����ݣ��Ի��н���
				ss[i] = s;
				i++;
			}
		} catch (FileNotFoundException e) {//�쳣����
			e.printStackTrace();
		}
		return ss;
	}
	
	public void writeFile(File f,String expression, int T) {//д�����úõ�����  �ļ���
		try (PrintWriter output = new PrintWriter(f);){
			output.println(expression+"="+T);					
		} catch (FileNotFoundException e) {//�쳣����
			e.printStackTrace();
		} 
	}
//	
//	public static void main(String[] args) {
//		FileOperation fo = new FileOperation();//����FileOperation��
//		File f = new File("src\\Expression");//����File�࣬���ҷ�������ļ����ĵط�
//		File f2 = new File("src\\Result");//��Ϊ���������ļ�
//		fo.readLine(f);	
//		fo.writeFile(f2);
//	}
}
