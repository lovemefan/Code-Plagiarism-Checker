import java.io.File;//导入io包下的File类库文件
import java.io.PrintWriter;//导入io包下的PrintWriter类
import java.util.Scanner;//导入util包下的Scanner类
public class FileSet {
	public FileSet(){
		
	}
	public void writerFile(String[] str2) throws Exception//创建文件
	{
		File file = new File("expression2.txt");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(1);	
		}
		try(PrintWriter output = new PrintWriter(file))
		{
			for(int i=0; i < str2.length;i++)
			{
				output.println(str2[i]);
			}
			
		}
		
	}
	public String[] readFile() throws Exception{//读取文件的内容数据
		File file = new File("expression1.txt");
		String[] express = new String[numberOfline()];
		int i = 0;
		try(Scanner input = new Scanner(file))
		{
			while (input.hasNext())
			{
				express[i++]= input.nextLine();
			}
		}
		return express;
	}
	public int numberOfline()throws Exception{//获得文件有多少行
		int m =0;
		File file = new File("expression1.txt");
		try(Scanner input = new Scanner(file))
		{
			while(input.hasNext())
			{
				input.nextLine();
				m++;
			}
		}
		return m;
	}
}
