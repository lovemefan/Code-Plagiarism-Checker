package allpackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Output {
	void outputAnswer(int num,String foundation,double answer) throws IOException {
		File f = new File("answer");
		PrintWriter output = new PrintWriter(new FileWriter(f,true));
		switch (num) {
			case 0: output.println(foundation + "=" + answer);
				break;
			case 1: output.println("ERROR");
					output.println("#表达式中有空括号");
				break;
			case 2: output.println("ERROR");
					output.println("#表达式包含非法字符");
				break;
			case 3: output.println("ERROR");
					output.println("#运算符连续");
				break;
			case 4: output.println("ERROR");
					output.println("#运算符前无运算数");	
				break;
			case 5: output.println("ERROR");
					output.println("#运算符后无运算数");	
				break;
			case 6: output.println("ERROR");
					output.println("#括号非第一个字符且之前无运算数");	
				break;
			case 7: output.println("ERROR");
					output.println("#小括号后无运算数，括号非最后一个字符");	
				break;
			case 8: output.println("ERROR");
					output.println("#括号不匹配");
				break;
			case 9: output.println("ERROR");
					output.println("#表达式为空");
				break;
			default: System.exit(0);
		}
		output.close();
	}
}
