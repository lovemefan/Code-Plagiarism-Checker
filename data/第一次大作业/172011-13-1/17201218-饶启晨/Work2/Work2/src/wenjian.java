import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class wenjian{
	static FileReader word;
	static BufferedReader br;
	private BufferedWriter bw;
	
	public wenjian() {
		
		try {
			word = new FileReader("res//word.txt");
			br = new BufferedReader(word);
			System.out.println("文件打开成功");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	public String array() throws IOException{ 
		String str = null;
		if((str = br.readLine()) != null) {
			return str;
		}
		return str;
		}
	public void input(String str) {
	FileWriter writer = null;
	try {
		writer = new FileWriter("res//wod1.txt",true);
		writer.write(str + "\r\n");
		
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if (writer != null) {
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

}
