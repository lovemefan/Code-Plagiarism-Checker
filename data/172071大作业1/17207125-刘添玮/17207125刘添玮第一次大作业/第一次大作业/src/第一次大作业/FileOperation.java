package 第一次大作业;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class FileOperation {
	public String[] readLine(File f) {
		String[] s=new String[3];
		int i=0;
		try (Scanner input = new Scanner(f);){
			while(i<3) {
				 s[i] = input.nextLine();
				 i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
	public void writeFile(File f,float ans) {
		try (PrintWriter output = new PrintWriter(f);){
			output.print(ans);	
			output.print("\r\n");
			output.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}	
