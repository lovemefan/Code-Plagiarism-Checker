import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		File f1 = new File("src\\Expression.txt"),f2 = new File("src\\result.txt");
		String[] e = readFile(f1);
		writeFile(f2,e);
	}
	
	public static String[] readFile(File f) {
		String[] s1 = new String[100];
		int i = 0;
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {				
				s1[i] = input.nextLine();
				i++;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] s2 = new String[i];
		System.arraycopy(s1, 0, s2, 0, i);
		return s2;
	}
	
	public static void writeFile(File f,String[] s) {
		try (PrintWriter output = new PrintWriter(f);){
			for(int i = 0;i < s.length;i++) {
				try{
					Expression e = new Expression(s[i]);
					output.println(e.getExpression() + "=" + e.calculateExpression());
					System.out.println(e.getExpression() + "=" + e.calculateExpression());
				}catch (NonstandardException ex) {
					output.println(ex);
					System.out.println(ex);
				}	
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
