import java.io.*;

public class FileOperate {
	public static String readFile() throws Exception {
        File file = new File("D:\\filename.txt");//����һ�����ļ�
        if (!file.exists()) {
    		file.createNewFile();//����ļ������ڣ����´���
    	}
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        StringBuilder s = new StringBuilder();
        String temp = "";
        while ((temp =bReader.readLine()) != null) {
            s.append(temp + "\n");//��β���뻻���ַ�����ָ��ַ�
        }
        bReader.close();
        return s.toString();
    }
	
	//�Ը��ӵ���ʽд���ļ�
	public static void writeFile(String file, String conent) throws IOException {
		BufferedWriter out = null;
		out = new BufferedWriter(new OutputStreamWriter(
		new FileOutputStream(file, true)));
		out.write(conent+"\r\n");
		out.close();
	
	   }
    }
