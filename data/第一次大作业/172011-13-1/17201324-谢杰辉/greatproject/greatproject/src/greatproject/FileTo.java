package greatproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileTo {
	String[] s = null;

	public FileTo(String[] s) {
		this.s = s;
	}

	public void wriResult() {
		File newfile = new File("result.txt");// ���贴����д��ʱϵͳ�Զ������ļ�
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile), "UTF-8"));
			for (int i = 0; i < s.length; i++) {
				if (s[i] != null) {
					bw.write(s[i] + "\r\n");
				}
			}
			bw.close();
			System.out.println("д����ɣ�");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
