package work01;
import java.io.*;
import java.util.*;


/**数据输入与输出类
 * 
 *
 */
public class Data 
{
	/**从文件中读数据
	 * @param 文件名
	 * @return 存储着多个算式的数组
	 * @throws IOException
	 */
	public Expression read(String fileName) throws IOException
	{
		Expression exp=new Expression();     //算式对象
		File file=new File(fileName);
		if(!file.exists())                  //文件不存在就新建文件
			file.createNewFile();
		try									 //该方法会自动关闭文件流
		(			
			Scanner input=new Scanner(file);	
		)
		{
			while(input.hasNextLine())
			{
				exp.content[exp.count]=input.nextLine();    //从文件中读入算式
				exp.content[exp.count]=exp.content[exp.count].replaceAll(" ","");  //过滤空格
				exp.count++;
			}
				
		}	
		return exp;
	}
	
	
	/**从文件中写数据
	 * 
	 * @param 文件名
	 * @param 算式=结果或错误原因的表达式
	 * @throws FileNotFoundException
	 */
	public void write(String fileName,Expression exp) throws FileNotFoundException
	{
		try
		(
			PrintWriter output=new PrintWriter( new FileOutputStream(fileName,false));	 //false会重写文件,true是追加内容,文件不存在则会新建文件
		)
		{
			for(int i=0;i<exp.count;i++)
				output.println(exp.content[i]);           //向文件中写入带结果的算式
		}		
	}
}