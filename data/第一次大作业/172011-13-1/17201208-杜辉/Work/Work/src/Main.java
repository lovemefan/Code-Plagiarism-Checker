import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Main {
	public static void main(String[] args) {
		IO io = new IO();
		CheckRepect checkRepect = new CheckRepect();

		while (io.getHasNextLine()) {
			String post = io.getNextLine();

			if (post.equals("")) { // �ж��Ƿ��ǿ��ַ���
				io.getAns("ERROR\n" + "#���ַ���!");
				continue;
			}
			post = post.replaceAll(" ", ""); // ȥ�����ʽ�еĿո�
			CheckFormat checkFormat = new CheckFormat(post);
			String ansCheck = checkFormat.check(); // ���ʽУ��
			if (ansCheck != null) {
				io.getAns(ansCheck);
			} else {
				Init init = new Init(post);
				String now = init.handleNow();
				if (init.getTrue()) {
					io.getAns("ERROR\n" + "#�����Ų�ƥ������!");
				} else {
					now = now.trim(); // ȥ����λ�Ŀո�
					Calc c = new Calc(now);
					Double ans = c.calculation();

					if (checkRepect.getAns(now) == null) {
						checkRepect.putAns(now, ans);
						io.getAns(post + " " + "= " + ans);
					} else
						io.getAns("ERROR\n" + "#����ı��ʽ֮ǰ�����!");
				}
			}
		}
	}
}