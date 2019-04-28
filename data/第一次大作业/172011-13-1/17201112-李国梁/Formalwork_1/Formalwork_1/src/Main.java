
public class Main {
	public static void main(String[] args) {
		String fileName = "d:\\test\\test.txt";
		String filename = "d:\\test\\result.txt";
		String str1 = "";

		ReadFile read = new ReadFile(fileName);
		String str[] =read.getStr();
		int n = read.getNum();// 长度

		for (int i = 0; i < n; i++) {
			str[i] = str[i].replace(" ", "");
			int flag = 1;
			if (i > 0) {// 判断表达式是否重复
				for (int j = 0; j < i; j++) {
					if (str[i].equals(str[j])) {
						flag = 0;
					}
				}
			}
			if (flag == 1) {
				String str2 = "";// 保存返回的错误信息

				Judge judge = new Judge();
				str2 += judge.detail(str[i]);

				if (judge.getflag() == 1) {// 如果表达式没错
					Stack stack = new Stack(n);
					Transform infix = new Transform(stack, str[i]);
					String post = infix.getPost();
					Stack stack2 = new Stack(post.length());
					Calcu ptr = new Calcu(post, stack2);
					str1 += str[i] + "=" + ptr.getSum() + "\r\n";// 记事本中换行为\r\n，写字板可以辨别\n换行
				} else {
					str1 += str2 + str[i] + "\r\n";
				}
			}
		}
		SaveFile save = new SaveFile(filename, str1);
		save.save();
	}
}
