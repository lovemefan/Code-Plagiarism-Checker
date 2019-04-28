import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile {
	FileInputStream streamer1 = null;
	InputStreamReader streamer2 = null;
	BufferedReader streamer3 = null;
	String str = "";
	String str1[] = new String[200];
	String fileName;
	int i = 0;
	
	public ReadFile() {

	}

	public ReadFile(String fileName) {
		this.fileName = fileName;
	}

	private void readFile() {// 从所给地址读取数据存入字符串数组
		try {
			streamer1 = new FileInputStream(fileName);
			streamer2 = new InputStreamReader(streamer1);
			streamer3 = new BufferedReader(streamer2);
			while ((str = streamer3.readLine()) != null) {
				str1[i++] = str;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				streamer3.close();
				streamer2.close();
				streamer1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String[] getStr() {//return读取的字符串数组
		readFile();
		String str2[] =new String[i];
		for(int j=0;j<i;j++){
			str2[j] = str1[j];
		}
		return str2;
	}
	public int getNum(){
		return i;
	}
}