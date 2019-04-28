import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class file {
	
	
	//文件写入，输出结果
	public void outPut() throws IOException{
		File file = new File("GSR.txt");
		
		Scanner outPut = new Scanner(file);
		
		while(outPut.hasNext()){			//用循环写出每一个式子的结果
			String s = outPut.next();

			System.out.println(s);
		}

		
		outPut.close();


    }
	

}
