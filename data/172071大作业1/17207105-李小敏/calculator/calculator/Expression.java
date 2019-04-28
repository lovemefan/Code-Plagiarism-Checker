package bigAssignments.calculator;
import java.io.*;

/** ���ʽ�ݴ��ļ�*/
public class Expression {
	String Expression; // ����������ʽ
	
	void Initfile(File f) throws IOException {
		try(PrintWriter input = new PrintWriter(f)){
			input.print("");
		}
	}
	public Expression(String exp) {
		this.Expression = exp;	
	}
	// ��ʼ���ļ�
	public Expression(File f) throws IOException{
		Initfile(f);
	}
	// ���û��������������ļ�
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