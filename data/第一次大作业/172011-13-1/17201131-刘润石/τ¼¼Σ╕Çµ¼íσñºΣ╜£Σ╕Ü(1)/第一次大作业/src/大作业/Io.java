package 大作业;
/**
 * 文件类,按字符串输入输出
 * @author 刘润石
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class Io {
	String[] str;
	StringBuilder s = new StringBuilder();
	Io(){
		
	}
	Io(String[] input) {
		this.str = input;
	}
	
	void fileWiter(){
		File file = new File("result.txt");
		try{
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bufw = new BufferedWriter(fw);
			for(int k=0;k<str.length;k++){
				bufw.write(str[k]);
				bufw.newLine();
			}
			bufw.close();
			fw.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	String fileReader(){
		File file = new File("infix.txt");
        FileInputStream is = null;
        StringBuilder stringBuilder = null;
        try {
            if (file.length() != 0) {
                /**
                 * 文件有内容才去读文件
                 */
                is = new FileInputStream(file);
                InputStreamReader streamReader = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(streamReader);
                String line;
                stringBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line+"\n");
                }
                reader.close();
                is.close();
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(stringBuilder);
    }

}
