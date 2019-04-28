package dazuoye;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class read {
	String filename;

	String[] duqu = new String[100];

	public read() {

	}

	public read(String filename) {
		this.filename = filename;
	}
	
	public void readMethod()
	{
		String fileName = "D:/ccc.txt";
		String line;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			//BufferedReader in2  = new BufferedReader(new FileReader("D:/ccc.text"));
			line = in.readLine();
			int i = 0;
			while (line != null) {
				duqu[i] = line;
				line = in.readLine();
				i++;
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] getreadMethod() {
		return duqu;
	}

}
