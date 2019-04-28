package work01;
import java.io.IOException;

/**入口函数类
 * 
 *
 */
public class Main 
{
	/**入口函数
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{	
		String fileName="work01\\input.txt";
		Handler handler=new Handler();
		handler.startCompute(fileName);		
		System.out.println("Successfully completed,Please see your file which name is input.txt ! Thank you~");
	}

}
