import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {	
	public static void writeToFile(String string) throws IOException {
//		File file = new File("D:" + File.separator + "output.txt");
		File file = new File("output.txt");
		if (!file.exists()) {
			try {
				// 如果文件找不到，就new一个
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileOutputStream out = new FileOutputStream(file, true);
		byte[] bs = (string + "\r\n").getBytes();
		try {
			//写入文件
			out.write(bs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.close();
	}
	
	//删除原文件中来删除已存在的数据
	public static void fileDel() throws IOException {
//		File file = new File("D:" + File.separator + "output.txt");
		File file = new File("output.txt");
		if (file.exists()) {
			file.delete();
		}
	}
}
