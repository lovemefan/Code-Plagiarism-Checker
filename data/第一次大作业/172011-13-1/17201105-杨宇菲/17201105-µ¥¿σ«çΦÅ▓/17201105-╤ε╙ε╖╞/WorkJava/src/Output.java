import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Output{
	public Output(){
		
	}
	
	public void outPut(String s) throws IOException{
		File file = new File("C:\\Users\\—Ó”Ó∑∆\\Desktop" + File.separator + "test2.txt");
		Writer writer = new FileWriter(file,true);
		List<String> expList = new ArrayList<String>();
		writer.write(s+"\r\n");
		writer.close();
	}
//	}
}