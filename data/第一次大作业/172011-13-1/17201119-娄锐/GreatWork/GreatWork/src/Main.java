import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.PrintStream;
public class Main {

	public static void main(String[] args) {
		
        PrintStream printffile = System.out;
		try {//尝试打开文件
			printffile = new PrintStream("expressionoutput.txt");
		} catch (Exception e) {
			System.err.println("ERROR\n#未找到文件.");
			System.exit(1);
		}
		for(String exp:Expression.getArrayLists()){
	        String obj =exp;
	        obj = obj.replaceAll(" ", "");
	        RegularExpression k = new RegularExpression(obj);
	        if (!RegularExpression.Checking()){
	        	printffile.println("ERROR\n#" + obj);
	        	continue;
	        }
	        ArrayList<String> arrayList = Expression.strFormat(obj);
            printffile.println(obj + "=" + Expression.calculator(arrayList));
	    	}
	    }
}
