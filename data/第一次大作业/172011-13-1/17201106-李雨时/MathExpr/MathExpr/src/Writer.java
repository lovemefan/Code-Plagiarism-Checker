import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	
	private FileWriter writer;
	
	public Writer(String filename) throws IOException {
		writer = new FileWriter(filename);
	}
	
	public void writeLine(String line) throws IOException {
		writer.write(line+"\n");
	}
	
	public void close() throws IOException {
		writer.close();
	}
}
