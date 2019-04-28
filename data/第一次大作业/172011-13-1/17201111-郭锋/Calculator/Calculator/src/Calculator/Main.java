package Calculator;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Readfile m = new Readfile();
		m.readWay();//读取文件
		String[] a = new String[m.Geti()];//创建一个存储结果的数组
		int i = 0;
		for (i = 0; i < m.Geti(); i++) {
			a[i] = m.p[i].replace(" ", "");//去空格
			Check k = new Check();
			k.check(a[i]);//利用正则表达表达式判断表达式的正确性

			int q = 0;
			for (int j = 0; j < i; j++) {
				if (a[i].equals(a[j])) {
					q = 1;
				}
			}//查重
			if (q == 1) {
				
			} 
			else {
				if (k.check(a[i])) {
					Writefile n = new Writefile(a[i] + " :  " + k.a);
					n.writeWay();//将不正确的表达式错误的格式写进文件
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
				}//将正确表达式的计算结果写进文件
			}
		}
	}
}
