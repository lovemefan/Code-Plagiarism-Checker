package Calculator;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Writefile {
	String p;

	public Writefile(String newP) {
		p = newP;
	}

	public void writeWay() {
		String fileName = "src\\Result.txt";

		try {
			Writer ter = new FileWriter(fileName, true);// 追加数据的写文件方法
			BufferedWriter bw = new BufferedWriter(ter);

			bw.write(p + "\r\n");

			bw.close();
			ter.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
         

         
