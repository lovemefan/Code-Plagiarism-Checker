package calculate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class input<string> {
	@SuppressWarnings("resource")
	public static ArrayList<String> Input() throws FileNotFoundException{
		ArrayList<String> data = new ArrayList<>();
		java.io.File file = new java.io.File("E:DATA.txt");
		
		Scanner input = new Scanner(file);
		
		while(input.hasNext()){
			data.add((String) input.next());
		}
		
		return data;
	}
	
	public static void Output(String data) throws IOException{
		File file = new File("E:RESULT.txt");
		PrintWriter bw = null;
		
		try {
            bw = new PrintWriter(new FileWriter(file,true));
            bw.write(data+"\r\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		bw.close();
	}

}
