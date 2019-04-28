import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFileExample {
	public static void main(String[] args){
		File file =new File ("");
		StringBuffer contents=new StringBuffer();
		BufferedReader reader= null;
		try{
			reader=new BufferedReader(new FileReader(file));
			String text = null;
			while((text = reader.readLine())!=null){
				contents.append(text).append(System.getProperty("line.separator"));
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(reader!=null){
					reader.close();
				}
			}
		catch(IOException e){
			e.printStackTrace();
		}
		}
		System.out.println(contents.toString());
					
		}
		
	}

