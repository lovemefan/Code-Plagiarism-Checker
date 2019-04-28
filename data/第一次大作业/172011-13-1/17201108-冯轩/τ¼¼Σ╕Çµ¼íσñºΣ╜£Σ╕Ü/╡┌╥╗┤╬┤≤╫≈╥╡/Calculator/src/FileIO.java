import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileIO {

	// 将文件里的内容输入到字符串中
		public static String fileInput(String path) throws IOException{
			File file = new File(path);
			if (!file.exists() || file.isDirectory()) { // 判断文件是否存在
				System.out.println("文件不存在或该路径为目录！");
				System.exit(-1);
			}
			FileInputStream fis = new FileInputStream(file);
			byte[] buf = new byte[1];
			StringBuffer sb = new StringBuffer();
			while ((fis.read(buf)) != -1) {
				sb.append(new String(buf));
				buf = new byte[1];// 重新生成，避免和上次读取的数据重复
			}
			fis.close();
			return sb.toString();
		}

		// 将字符串输出到文件
		public static void fileOutput(String path, String content) throws IOException{
			File file = new File(path);
			if (!file.exists() || file.isDirectory()) {
				System.out.println("文件不存在或该路径为目录！");
				System.exit(-1);
			}
			FileOutputStream fis = new FileOutputStream(file, true);
			PrintStream p = new PrintStream(fis);
			p.println(content);
			p.close();
			System.out.println("DONE!");
		}
}
