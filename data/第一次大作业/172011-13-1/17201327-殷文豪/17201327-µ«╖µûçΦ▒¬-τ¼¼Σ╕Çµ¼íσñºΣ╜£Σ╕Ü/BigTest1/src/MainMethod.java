import java.io.IOException;
import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫ��ȡ��.txt�ļ���·��������(����input.txt):");
		String inputName = input.nextLine();
		System.out.println("������Ҫ��ȡ�ı��ʽ����(����0������):");
		int n = input.nextInt();
		//��������
		while (n < 0) {
			System.out.println("�������,������Ҫ��ȡ�ı��ʽ����(����0������):");
			n = input.nextInt();
		}
		//�����������ͱ���\n����
		input.nextLine();
		System.out.println("������Ҫ�����.txt�ļ���·��������(����output.txt):");
		String outputName = input.nextLine();
		MyFile myFile = new MyFile(inputName,outputName,n);
		//���ļ���ȡ
		myFile.input();
		//������ļ�
		myFile.output();
		System.out.println("�����");
	}
	
}
