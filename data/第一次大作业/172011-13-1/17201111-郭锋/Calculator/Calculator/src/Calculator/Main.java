package Calculator;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Readfile m = new Readfile();
		m.readWay();//��ȡ�ļ�
		String[] a = new String[m.Geti()];//����һ���洢���������
		int i = 0;
		for (i = 0; i < m.Geti(); i++) {
			a[i] = m.p[i].replace(" ", "");//ȥ�ո�
			Check k = new Check();
			k.check(a[i]);//������������ʽ�жϱ��ʽ����ȷ��

			int q = 0;
			for (int j = 0; j < i; j++) {
				if (a[i].equals(a[j])) {
					q = 1;
				}
			}//����
			if (q == 1) {
				
			} 
			else {
				if (k.check(a[i])) {
					Writefile n = new Writefile(a[i] + " :  " + k.a);
					n.writeWay();//������ȷ�ı��ʽ����ĸ�ʽд���ļ�
				} else {
					Stack stack = new Stack(a.length);
					Transform infix = new Transform(stack, a[i]);
					infix.process();
					String post = infix.getPost();
					Stack stack_result = new Stack(post.length());
					Calculate ptr = new Calculate(post, stack_result);
					ptr.operate();
					Writefile n = new Writefile(a[i] + "=" + ptr.getResult());

					n.writeWay();
				}//����ȷ���ʽ�ļ�����д���ļ�
			}
		}
	}
}
