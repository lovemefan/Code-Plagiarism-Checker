package tt;

import java.util.Scanner;
import java.io.File;
public class AllMain {
	private static Scanner input;

	public static void main(String[] args) throws Exception {
		ExpressionFile f = new ExpressionFile();
		String[] exps = new String[1000];//�����Ե��ļ������б��ʽ����һ������Ŀռ�
		File file = new File("src\\experission");//����һ��������Ҫ���ļ�
	
		input = new Scanner(file);
		int i = 0;
		while (input.hasNextLine()) {
			exps[i] = input.nextLine();//�ļ���ı��ʽȫ��һ��һ��������
			exps[i] = f.expsToAllexps(exps[i]);//�ѱ��ʽ�������ͱ��ʽһ��һ��һ����ԭ����
			System.out.println(exps[i]);//����ʾ̨��������б��ʽ�ͽ��
			i++;
		}
		f.write(exps);//�Ѳ��Ժ�ı��ʽһ��һ����д����һ���ļ���ȥ
	}
}
