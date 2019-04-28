import java.io.*;

public class Files {
	public static String readFile() throws Exception {
        File file = new File("D:\\test.txt");
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String s = "";
        while ((s =bReader.readLine()) != null) {
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
        }
        bReader.close();
        return sb.toString();
    }
	public static void writeFile(String sb) {
		try {
			FileOutputStream fw = new FileOutputStream("D:\\out.txt");
			OutputStreamWriter bw = new OutputStreamWriter(fw,"UTF-8"); //输出编码为UTF-8编码格式
			bw.write(sb.toString());
			bw.close();
			fw.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
