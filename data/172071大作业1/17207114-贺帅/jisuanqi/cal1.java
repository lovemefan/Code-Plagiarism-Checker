package jisuanqi;
import jisuanqi.calcheck;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileOutputStream;
import jisuanqi.cal;
public class cal1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = null;
		File f = new File("src\\jisuanqi\\mianban");
		//��ȡ�ļ�����
		s=read(f,s);
		//��������Ƿ�淶
		if(f.length()==0) {	//�����ʽ�Ƿ�Ϊ��
			System.out.println("ERROR");
			System.out.println("#���ʽΪ��");
		}
		else {
			calcheck x=new calcheck(s);
			//����
			cal result=new cal(s);
			
			//���������
			writeFile(f,result.result);
		}
		
		
		
		
	}
	
	public static void writeFile(File f,String result) {
		try (PrintWriter output = new PrintWriter(new FileOutputStream(f,true));){
			output.println("���ļ�����Ϊ��"+result);					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	static String calculat(String s) {
		String result = null;
		return result;
		
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
	

}
