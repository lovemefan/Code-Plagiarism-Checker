package 数学表达式计算器;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;
import java.util.EmptyStackException;

public class Calculation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("test2.txt");
		FileOutputStream filewrite = new FileOutputStream("test2.txt", true);//文件
		
		
		
		String[] tmp = new String[20];
		int i = 0;
		try(Scanner input = new Scanner(file))
		{
			while(input.hasNext())
			{
				String expression = input.nextLine();
				
				
				if(expression.contains("="))//读到写入字符串时停止读入
				{
					System.exit(0);
				}
				
				expression = expression.replaceAll(" ", "");//删除空格
				
				
				tmp[i] = expression;
				
				boolean a = true;
				
				if(expression.equals(""))
				{
					System.out.println("ERROR"+"\n"+"#表达式为空");
					a = false;
				}
				else
				{
				
					if(i != 0)//重复处理
					{
						int j = 0;
						for(j=0; j<i; j++)
						{
							if(tmp[j].equals(tmp[i]))
							{
								a = false;
								j = i-1;
							}
						}
					}
					if(a)
						a = Istrue.isTrue(expression);//异常输入处理
				}
				
				if(a)
				{
					transform.Stack(expression);//计算
				}
				
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}