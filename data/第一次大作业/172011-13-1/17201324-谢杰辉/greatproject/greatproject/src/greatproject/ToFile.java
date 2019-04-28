package greatproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ToFile {
	private String[] expre;

	public String[] getExpre() {
		File file = new File("text.txt"); // 事先创建好，并输入内容
		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));// 带有缓冲区的Reader
				String line;
				int i = 0;
				while ((line = br.readLine()) != null) {
					i++;
				}
				expre = new String[i];
				i = 0;
				br.close();// 一个指针只能读取一遍文件
				BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
				while ((line = b.readLine()) != null) {
					expre[i] = line;
					i++;
				}

				// 关闭输入流
				br.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("文件不存在，请创建一个名为text.txt的文件");
			System.exit(0);
		}
		return expre;

	}

}
