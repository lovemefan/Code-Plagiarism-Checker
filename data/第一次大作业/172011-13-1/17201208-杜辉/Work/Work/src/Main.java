import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Main {
	public static void main(String[] args) {
		IO io = new IO();
		CheckRepect checkRepect = new CheckRepect();

		while (io.getHasNextLine()) {
			String post = io.getNextLine();

			if (post.equals("")) { // 判定是否是空字符串
				io.getAns("ERROR\n" + "#空字符串!");
				continue;
			}
			post = post.replaceAll(" ", ""); // 去除表达式中的空格
			CheckFormat checkFormat = new CheckFormat(post);
			String ansCheck = checkFormat.check(); // 表达式校验
			if (ansCheck != null) {
				io.getAns(ansCheck);
			} else {
				Init init = new Init(post);
				String now = init.handleNow();
				if (init.getTrue()) {
					io.getAns("ERROR\n" + "#有括号不匹配的情况!");
				} else {
					now = now.trim(); // 去除首位的空格
					Calc c = new Calc(now);
					Double ans = c.calculation();

					if (checkRepect.getAns(now) == null) {
						checkRepect.putAns(now, ans);
						io.getAns(post + " " + "= " + ans);
					} else
						io.getAns("ERROR\n" + "#输入的表达式之前输入过!");
				}
			}
		}
	}
}