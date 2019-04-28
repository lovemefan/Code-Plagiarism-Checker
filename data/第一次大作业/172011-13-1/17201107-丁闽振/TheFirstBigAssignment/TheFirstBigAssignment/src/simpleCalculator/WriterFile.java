package simpleCalculator;

import java.io.File;
import java.io.FileOutputStream;

import java.io.IOException;

public class WriterFile {
//构造函数
	WriterFile() {

	}
//写入文件
	public void StringBufferDemo(String string) throws IOException {
		File file = new File("./writerFile.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(file, true);
		StringBuffer sb = new StringBuffer();
		sb.append(string + "\n");
		out.write(sb.toString().getBytes("utf-8"));
		out.close();
	}

}
