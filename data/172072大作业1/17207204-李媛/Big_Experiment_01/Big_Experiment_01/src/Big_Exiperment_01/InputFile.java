package Big_Exiperment_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputFile {

	private String[] bds = new String[100];
	private int Length;
	
	//���캯��
	public InputFile(String[] bds){
		this.bds = bds;
	}
	public InputFile() {
		
	}
	
	//���ʽ�ĸ�ֵ�͵õ����������ʽ�ĸ����ĵõ�
	public int getLength() {
		return Length;
	}
	public void setLength(int length) {
		Length = length;
	}
	public String[] getBds() {
		return bds;
	}
	public void setBds(String[] bds) {
		this.bds = bds;
	}
	
	public static void InputBds(InputFile a) {
		try {
			Scanner input = new Scanner(System.in);
			String str = "";
			int i = 0;
			System.out.println("��������Ҫ������ַ���(���ʽ@��������)��");
			do{
				str = input.nextLine();
				if(str.charAt(0) != '@') {
					a.bds[i] = str;
					i++;
				}
			}while(str.charAt(0) != '@');
			a.Length = i;
			
		}catch(StringIndexOutOfBoundsException ex) {
			System.out.println("�����˿��ַ���"+"\n"+ "����Ϊ��" + ex.toString());
		}
	}
	
	public static void PrintWrite(File f,InputFile a) {
		try(PrintWriter output = new PrintWriter(f);){
			for(int i = 0; i < a.Length;i++) {
				output.println(a.bds[i]);
			}
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		File f = new File("src\\expression");
		File f1 = new File("src\\calculator");
		InputFile a = new InputFile();
		InputBds(a);
		PrintWrite(f,a);
		Calculator calculator = new Calculator();
		calculator.readFile(f,f1);
		
	}
}
