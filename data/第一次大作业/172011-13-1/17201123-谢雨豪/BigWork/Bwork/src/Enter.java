import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class Enter {
	private int time = 0;
	private String enterList[] = new String[1024];

	public Enter() {

	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTime() {
		return this.time;
	}

	public void setEnterList(String enterList[]) {
		this.enterList = enterList;
	}

	public String[] getEnterList() {
		return enterList;
	}

	public void enter() throws IOException {

		File file = new File("准备读入的文件的路径 反斜杠请\\");
		Reader reader = new FileReader(file);

		char cs[] = new char[(int) file.length()];//将文件中的 数据读入程序中的数组
		reader.read(cs, 0, (int) file.length());

		// System.out.println(cs);
		String enter = new String(cs);
		reader.close();

		String enterList[] = new String[4096];
		// System.out.println((int)file.length());
		int beg, end, time;
		beg = end = time = 0;
		for (int i = 0; i < (int) file.length();) {
			if (cs[i] == '\r') {//遇到换行 将表达式分离
				end = i;
				String s = enter.substring(beg, end);
				enterList[++time] = s;// 第一个String对象位置从1开始
				i += 2;
				beg = i;
			} else if (i == (int) file.length() - 1) {
				end = (int) file.length();
				String s = enter.substring(beg, end);
				enterList[++time] = s;//将分离的表达式存入enterList中
				break;
			} else
				i++;
		}

		this.time = time;
		this.enterList = enterList;
	}
}
