package dazuoye;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class write {
	String shuru;
    String fileName;
    
	public write() {
	}

	public write(String shuru,String FileName) {
		this.fileName=FileName;
		this.shuru = shuru;
	}

	public void writeMethod() {
		

		try {
			Writer ru = new FileWriter(fileName, true);
			BufferedWriter xie = new BufferedWriter(ru);

	        xie.write(shuru+"\r\n");

			xie.close();
			ru.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

