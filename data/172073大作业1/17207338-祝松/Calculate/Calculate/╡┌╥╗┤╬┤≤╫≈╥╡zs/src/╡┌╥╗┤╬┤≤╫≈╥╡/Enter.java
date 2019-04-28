package 第一次大作业;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Enter
{	

	public String[] enter()
	{
		FileOperation fo = new FileOperation();
		File f = new File("src\\Enter");
		
		int length = fo.readLine(f);
		String[] inputString=new String[length];//先创建一个够大的数组用来存用户输入的数
		
		int i = 0;
		try (Scanner sc = new Scanner(f);)
		{
			while (sc.hasNextLine())
			{
				String s = sc.nextLine();// 以回车符判断
				inputString[i] = s;
				i++;
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		return inputString;
	}
}
