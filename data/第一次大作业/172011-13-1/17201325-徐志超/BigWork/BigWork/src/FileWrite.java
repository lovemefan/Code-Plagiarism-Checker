
import java.io.*;
public class FileWrite {
	public void fileWrite(String[] result) throws IOException{
		File file = new File("result.txt");// 创建文件
		
		PrintWriter output = new PrintWriter(file);
		for(int i = 0;i < result.length;i ++){
			if(result[i] != null){ // 判断不为空
				output.println(result[i]);// 向文件写入信息
			}
		}
		output.close();// 关闭文件
	}
}

