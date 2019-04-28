import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.script.ScriptException;
public class Write {

	public static void main(String[] args) throws IOException, ScriptException {
		// TODO Auto-generated method stub
//		caculate.Calculation("13+56*13");
		Write.read();
//		System.out.print(caculate.Calculation("(2+4)*2-38"));
	}
	public static void read() throws IOException {
		File f =new File("src/read.txt");
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {	
				String s = input.nextLine();
				judge.isLegal(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void write(String s) throws IOException {
		File f = new File("src/write.txt");
		try (PrintWriter output = new PrintWriter(new FileWriter(f,true))){			
			output.println(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}	
	public static void write(int s) throws IOException {
		File f = new File("src/write.txt");
		try (PrintWriter output = new PrintWriter(new FileWriter(f,true))){			
			output.println(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}	
}
