package Calculator;
import Calculator.check;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileOutputStream;
import Calculator.calculat;
public class calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = null;
		File f = new File("src\\Calculator\\panel");
		//��ȡ�ļ�����
		s=read(f,s);
		//��������Ƿ�淶
		if(f.length()==0) {	//�����ʽ�Ƿ�Ϊ��
			System.out.println("ERROR");
			System.out.println("#���ʽΪ��");
		}
		else {
			boolean ch=true;
			check x=new check(s,ch);
			//����
			if(x.c) {
				calculat result=new calculat(s);
				System.out.println(result.result);
				//���������
				writeFile(f,result.result);
			}
		}
		
		
		
		
	}
	
	//��ȡ�ļ�����
	static String read(File f,String s) {
		try (Scanner input = new Scanner(f);){
			while(input.hasNext()) {
				 s = input.next();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public static void writeFile(File f,String result) {
		try (PrintWriter output = new PrintWriter(new FileOutputStream(f,true));){
			output.println("������Ϊ��"+result);
			output.println("������һ��������һ����ѧ���ʽ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
