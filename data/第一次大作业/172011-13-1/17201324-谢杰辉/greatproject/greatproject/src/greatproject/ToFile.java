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
		File file = new File("text.txt"); // ���ȴ����ã�����������
		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));// ���л�������Reader
				String line;
				int i = 0;
				while ((line = br.readLine()) != null) {
					i++;
				}
				expre = new String[i];
				i = 0;
				br.close();// һ��ָ��ֻ�ܶ�ȡһ���ļ�
				BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
				while ((line = b.readLine()) != null) {
					expre[i] = line;
					i++;
				}

				// �ر�������
				br.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("�ļ������ڣ��봴��һ����Ϊtext.txt���ļ�");
			System.exit(0);
		}
		return expre;

	}

}
