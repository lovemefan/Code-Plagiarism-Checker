package work01;

/**算式类
 * 
 *
 */
public class Expression  
{
	public int count;            //算式数量
	public String[] content;	 //算式数组
	public Expression()
	{
		count=0;
		content=new String[100000];             //最大可输入100000行算式
	}
}