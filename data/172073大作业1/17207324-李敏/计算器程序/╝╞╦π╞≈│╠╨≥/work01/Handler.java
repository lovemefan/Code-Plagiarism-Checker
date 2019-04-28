package work01;
import java.io.IOException;
import java.util.Stack;

/**操作类
 * 
 *
 */
public class Handler 
{
	
	/**开始从文件中读取算式进行计算,然后见过结果写入文件中
	 * 
	 * @param 文件名
	 * @return void
	 * @throws IOException 
	 */
	public void startCompute(String filename) throws IOException
	{
		Calculator c=new Calculator();     
		Data data=new Data();
		Expression exp=data.read(filename);          //算式数组
		exp=removeSame(exp);                        //删除相同项
		Expression result=new Expression();  //存储结果的数组
		for(int i=0;i<exp.count;i++)		
		{		
			String isTrue=check(exp.content[i]);                           //正确为"true",错误为错误原因
			if(isTrue.equals("true"))		//算式正确
			{
				try
				{
					Double r=c.compute(exp.content[i]);
					result.content[result.count++]=exp.content[i]+"="+r;		//写入 算式=结果 的形式
				}
				catch(Exception e)
				{
					System.out.println("表达式有误");
					System.exit(0);
				}
			}
			else							//算式错误
			{
				result.content[result.count++]=exp.content[i]+" "+isTrue;    //写入 算式 错误原因
			}
		}
		data.write(filename,result);	                                                //数据写入文件
	}
	
	
	/**删除算式数组中的重复项
	 * 
	 * @param 原算式数组
	 * @return 无重复项的数组
	 */
	private Expression removeSame(Expression exp)
	{
		for(int i=0;i<exp.count;i++)
		{
			if(exp.content[i]!=null)
			{
				for(int j=i+1;j<exp.count;j++)
				{
					if(exp.content[j]!=null)
					if(exp.content[j].equals(exp.content[i]))    //删除相同项
						exp.content[j]=null;
				}
			}		
		}
		Expression exp2=new Expression();             //用新数组收集
		for(int i=0;i<exp.count;i++)
		{
			if(exp.content[i]!=null)
				exp2.content[exp2.count++]=exp.content[i];	
		}	
		return exp2;
	}
	
	
	/**校验算式
	 * 
	 * @param 算式字符串
	 * @return 算式正确返回"true",否则返回错误原因
	 */
	public String check(String exp)
	{
		if(isBlankExp(exp))             //空算式
			return "ERROR #表达式为空";
		
		else if(isBlankBrackets(exp))   //空括号
			return "ERROR #表达式中有空括号";
		
		else if(isillegalChar(exp))		//非法字符
			return "ERROR #表达式包含非法字符";
		
		else if(isMismatchingBrackets(exp))  //括号不匹配
			return "ERROR #表达式括号不匹配";
		
		else if(isContinuousOP(exp))    //运算符连续
			return "ERROR #运算符连续";
		
		return isEffectiveOP(exp);    
	}
	
	
	/**判断算式是否为空
	 * 
	 * @param 算式字符串
	 * @return 算式为空返回true,否则返回false
	 */
	private boolean isBlankExp(String exp)
	{
		String regex="\\s*";       //字符串中只允许出现空字符
		return exp.matches(regex);
	}
	
		
	/**判断算式是否含有空括号
	 * 
	 * @param 算式字符串
	 * @return 算式含有空括号返回true,否则返回false
	 */
	private boolean isBlankBrackets(String exp)
	{
		String regex=".*(\\(\\))+.*";         //字符串中出现()空括号的情况	
		return exp.matches(regex); 
	}
	
	
	
	/**判断算式是否含有非法字符
	 * 
	 * @param 算式字符串
	 * @return 算式含有含有非法字符返回true,否则返回false
	 */
	private boolean isillegalChar(String exp)
	{
		String regex="[0-9\\.\\+\\-\\*\\/\\(\\)]*";   //字符串只允许出现0~9.+-*/()或者为空	
		return !exp.matches(regex);
	}
	
	
	
	/**判断算式是否含有不匹配的括号
	 * 
	 * @param 算式字符串
	 * @return 算式含有不匹配括号返回true,否则返回false 
	 */
	private boolean isMismatchingBrackets(String exp)
	{
		Stack<Character> OPTR = new Stack<Character>(); //字符栈,用于括号匹配
		OPTR.push('#');
		for(int i=0;i<exp.length();i++)
		{
			if(OPTR.isEmpty())   //栈空是因为'#'被弹出,出现了括号不匹配问题
				return true;     
			if(exp.charAt(i)=='(')
				OPTR.push('(');
			else if(exp.charAt(i)==')')            //括号配对
				OPTR.pop();		
		}	
		if(OPTR.isEmpty())
			return true;
		else if(OPTR.pop()!='#')            //正常配对是栈底是'#',不是说明不匹配
			return true;
		else		
			return false;
	}
	
	
	
	/**判断算式是否含有连续的运算符
	 * 
	 *  @param 算式字符串
	 * @return 算式含有连续的运算符返回true,否则返回false 
	 */
	private boolean isContinuousOP(String exp)
	{
		 String regex1=".*(\\+\\+)+.*";      //出现++连续
		 String regex2=".*[\\*\\/]{2,}.*"; 	//出现*/连续
		 String regex3=".*(\\*\\+)+.*";		//出现*+
		 String regex4=".*(\\/\\+)+.*";		//出现/+
		 String regex5=".*(\\+\\*)+.*";		//出现+*
		 String regex6=".*(\\-\\*)+.*";		//出现-*
		 String regex7=".*(\\-\\/)+.*";		//出现-/
		 String regex8=".*(\\+\\/)+.*";		//出现+/
		 String regex9=".*(\\-\\-)+.*";     //出现--连续
		 String regex10=".*(\\-\\+)+.*";    //出现-+连续
		 
		 boolean t1=exp.matches(regex1);
		 boolean t2=exp.matches(regex2);
		 boolean t3=exp.matches(regex3);
		 boolean t4=exp.matches(regex4);
		 boolean t5=exp.matches(regex5);
		 boolean t6=exp.matches(regex6);
		 boolean t7=exp.matches(regex7);
		 boolean t8=exp.matches(regex8);
		 boolean t9=exp.matches(regex9);
		 boolean t10=exp.matches(regex10);
		 return (t1||t2||t3||t4||t5||t6||t7||t8||t9||t10);
	}
	
	
	/**判断运算符是否有效
	 * 
	 * @param 算式字符串
	 * @return 有效返回"true",无效返回原因
	 */
	private String isEffectiveOP(String exp)
	{
		if(exp.matches("^\\+.*")||exp.matches("^\\*.*")||exp.matches("^\\/.*"))   //运算符放到最前,如 *8-6
			return "ERROR #运算符前无运算数";
		
		else if(exp.matches(".*\\+")||exp.matches(".*\\-")||exp.matches(".*\\*")||exp.matches(".*\\/"))  //运算符放到最后,如 9-8*
			return "ERROR #运算符后无运算数";
		
		else if(exp.matches(".*\\+\\).*")||exp.matches(".*\\-\\).*")||exp.matches(".*\\*\\).*")||exp.matches(".*\\/\\).*")) 
			return "ERROR #括号非第一个字符且之前无运算数";                       //左括号前没有数字,如 6+(9+)
		
		else if(exp.matches(".*\\(\\+.*")||exp.matches(".*\\(\\*.*")||exp.matches(".*\\(\\/.*"))
			return "ERROR #小括号后无运算数,括号非最后一个字符";                  //右括号后没有数字,如 6+(*8)
		
		else if(exp.matches(".*\\d\\(.*")||exp.matches(".*\\)\\d.*")||exp.matches(".*\\)\\(.*"))
			return "ERROR #括号前或后缺少运算符";                  					//括号内没有运算符,如 6+6(8)6
		
		else if(exp.matches(".*\\D\\..*")||exp.matches(".*\\.\\D.*")||exp.matches(".*\\.\\d*\\..*")||exp.matches("^\\..*")||exp.matches(".*\\.$"))
			return "ERROR #存在非法小数点";                                     //非法小数点 ,如6+6.6.6
		
		return "true";
	}
}
