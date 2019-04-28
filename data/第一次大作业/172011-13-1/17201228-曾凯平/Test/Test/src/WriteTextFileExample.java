import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
public class WriteTextFileExample {
	public static void main(String[] args){
		FileOutputStream fos= null;
		BufferedWriter bw= null;
		try{
			File file=new File("abc.txt");
			fos=new FileOutputStream(file);
			bw=new BufferedWriter(new OutputStreamWriter(fos));
		}
		catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		finally{
			try{
				if(bw!=null)
					fos.close();
			}
			catch(IOException ie){
			}
		}
		
	}

}
