import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception{
		String count = "";//�������Ϣ
		String Error = "";//�������Ϣ
		InputFile i;
		i = new InputFile();
		String[] part = i.inputFile();
		java.io.File file2 = new java.io.File("output.txt");//���
		java.io.PrintWriter output = new java.io.PrintWriter(file2);
		
		for(int j = 0;part[j] != null;j ++){//���ΰ��в����ļ��еı��ʽ
			count = part[j];
			MiddleC m;
			m = new MiddleC();
			count = m.process1(count);
			count = m.process2(count);
			Operate o;
			o = new Operate();
			o.Last(count);
			if(!o.Result.isEmpty()){
				Error += m.Result + "=" + o.Result + "\r\n";
			}
			Error += o.Error;
		}
		Error += i.Error;
		output.print(Error);//�����Ϣ
		output.close();
	}

}
