import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class FileInput {
	File file;
	public FileInput(){
		
	}
	public void fileInput(String filename,String[] s,int m) throws FileNotFoundException{
		file = new File(filename);
		try(
				PrintWriter output = new PrintWriter(file);
	){		int i = 0;
			while(i < m){
				output.println(s[i]);
				i++;
			}
		}
	}
}