package javaAssignment;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] expression = new String[100];//���ļ���ȡ�ı��ʽ�����ַ���������
		String [] expression1 = new String[100];
		String [] result = new String[100];//�������
		boolean [] tf= new boolean[100];//�����жϱ��ʽ�Ƿ���ȷ
		ReadFile read = new ReadFile();
		read.Read(expression);//���ļ�
		read.Read(expression1);
		Reapet reapet = new Reapet();
		reapet.stringReapet(expression, tf, result);//��ʼִ�в���
		WriteFile writer = new WriteFile();
		writer.write(expression1, result);//д����
	}

}
