
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Scanner;

public class InputData{

    public static void main(String[] args) throws IOException {
    	Scanner input = new Scanner(System.in);
    	String address = input.nextLine();
        File file = new File("C:" + address + ".txt");
        StackOfString stackOfString = new StackOfString(); 
        input = new Scanner(file);
        while (input.hasNext()){
        	stackOfString.push(input.nextLine());
        }
        input.close();
        file = new File("C:" + address + "result"+ ".txt");
        Writer writer = new FileWriter(file, true);
        Action action = new Action();      
        while(!stackOfString.endString()){
        	stackOfString.clearBlank();
        	action = new Action(stackOfString.pop());
        	writer.write(action.suma() + "\n");      	
        }
        writer.close();

    }
}
