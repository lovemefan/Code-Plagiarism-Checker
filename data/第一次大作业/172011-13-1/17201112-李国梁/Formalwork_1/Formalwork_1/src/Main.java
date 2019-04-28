
public class Main {
	public static void main(String[] args) {
		String fileName = "d:\\test\\test.txt";
		String filename = "d:\\test\\result.txt";
		String str1 = "";

		ReadFile read = new ReadFile(fileName);
		String str[] =read.getStr();
		int n = read.getNum();// ����

		for (int i = 0; i < n; i++) {
			str[i] = str[i].replace(" ", "");
			int flag = 1;
			if (i > 0) {// �жϱ��ʽ�Ƿ��ظ�
				for (int j = 0; j < i; j++) {
					if (str[i].equals(str[j])) {
						flag = 0;
					}
				}
			}
			if (flag == 1) {
				String str2 = "";// ���淵�صĴ�����Ϣ

				Judge judge = new Judge();
				str2 += judge.detail(str[i]);

				if (judge.getflag() == 1) {// ������ʽû��
					Stack stack = new Stack(n);
					Transform infix = new Transform(stack, str[i]);
					String post = infix.getPost();
					Stack stack2 = new Stack(post.length());
					Calcu ptr = new Calcu(post, stack2);
					str1 += str[i] + "=" + ptr.getSum() + "\r\n";// ���±��л���Ϊ\r\n��д�ְ���Ա��\n����
				} else {
					str1 += str2 + str[i] + "\r\n";
				}
			}
		}
		SaveFile save = new SaveFile(filename, str1);
		save.save();
	}
}
