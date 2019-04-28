import java.io.*;

public class FileOperate {
	public static String readFile() throws Exception {
        File file = new File("D:\\filename.txt");//创建一个新文件
        if (!file.exists()) {
    		file.createNewFile();//如果文件不存在，重新创建
    	}
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        StringBuilder s = new StringBuilder();
        String temp = "";
        while ((temp =bReader.readLine()) != null) {
            s.append(temp + "\n");//结尾加入换行字符方便分割字符
        }
        bReader.close();
        return s.toString();
    }
	
	//以附加的形式写入文件
	public static void writeFile(String file, String conent) throws IOException {
		BufferedWriter out = null;
		out = new BufferedWriter(new OutputStreamWriter(
		new FileOutputStream(file, true)));
		out.write(conent+"\r\n");
		out.close();
	
	   }
    }
