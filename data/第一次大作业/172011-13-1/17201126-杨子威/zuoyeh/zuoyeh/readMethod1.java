package shangKe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class readMethod1 {
	String[] a = new String[20];
	
	public  void readMethod2() {
		String fileName = "D:\\ccc.txt";
		String line = "";
		try {
			int i = 0;
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			line = in.readLine();
			while (line != null) {
				a[i] = line;
				line = in.readLine();
				i++;
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String[] x() {

		return a;
	}

}