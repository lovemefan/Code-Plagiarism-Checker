import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
	private Scanner reader;
	
	public Reader(String filename) throws FileNotFoundException {
		reader = new Scanner(new File(filename));
	}
	
	public boolean hasNextLine() {
		return reader.hasNextLine();
	}
	
	public String nextLine() {
		return reader.nextLine();
	}
	
	public void close() {
		reader.close();
	}
}
