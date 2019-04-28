package bigAssignments.calculator;
import java.io.*;

/** 表达式暂存文件*/
public class Expression {
	String Expression; // 接收输入表达式
	
	void Initfile(File f) throws IOException {
		try(PrintWriter input = new PrintWriter(f)){
			input.print("");
		}
	}
	public Expression(String exp) {
		this.Expression = exp;	
	}
	// 初始化文件
	public Expression(File f) throws IOException{
		Initfile(f);
	}
	// 将用户输入的请求存入文件
	void SaveExp(File f) {
		try {
			FileWriter fw = new FileWriter(f,true);
			fw.write(Expression + "\n");
			fw.close();
		}catch(IOException  e) {
			e.printStackTrace();
		}
	}
}