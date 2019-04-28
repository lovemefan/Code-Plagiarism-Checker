package No_error;

import java.io.IOException;
import java.io.LineNumberReader;


public class Expression {

	String expression = null;// 表达式
	boolean IsaExp = true;// 用于判断改表达式是否错误，如果没有错误，则值为true，如果有错误，则值为false
	String Error = null;// 用于输出错误类型
	int TypeOfError = 0;// 如果表达式没有错误的话，值为0，有错的话，根据错误的类型进行判断,用于文件的存入
	/*
	 * 0:表达式正确 1:表达式为空2：表达式中有空阔好 3：表达式含非法字符 4：括号不匹配 5：运算符连续 6：运算符无效（运算符前无运算数）
	 * 7：运算无效（运算符后无运算数）8：运算符无效（括号非第一个运算符，且之前无运算数） 9：运算符无效（小括号后无运算数，括号非最后一个字符）
	 */

	public void SetTypeOfError(int Type) {
		this.TypeOfError = Type;
		
	}
	public static void main(String[] args) throws IOException {

		int count = 0;// 用于循环计数
		
		/* 初始化三个对象 */
		FileOperation file = new FileOperation();
		Judge judge = new Judge();
		
		int length = 0;
		length = file.GetLine();
		
		
		Expression[] exp = new Expression[length];// 
		for( int j = 0;j<length;j++) {
			exp[j] = new Expression();
		}
		CalculateExpression cal = new CalculateExpression();
		for(count = 0;count<exp.length;count++) {
			exp[count] = new Expression();
		}

		/* 读取文件中的表达式 */
		try {
			file.ReadExpression(exp);
			System.out.println("读取完成");
		} catch (IOException ex) {
			System.out.println(ex.getLocalizedMessage());
		}

		/* 消除表达式中的相同的字符串 */
			judge.DelSameEXP(exp);
		
		/* 对读取的表达式进行判断 ,即改变错误的类型*/
			for( int count1 = 0;count1<length;count1++) {
				judge.JudgeType(exp[count1]);	
			}
			
		
		/* 判断完成后，对表达式进行求解 */
		
		for (count = 0; count < exp.length; count++) {

			cal.Calculate(exp[count]);
		}
		System.out.println("计算完成！");
		/* 计算完成后，将其再次存入文件中 */
		for (count = 0; count < exp.length; count++) {

			file.WriteTheResult(exp[count]);
		}
		System.out.println("存储完成！可以在“src\\\\No_error\\\\output”目录下查看");

	}
	public void SetExp(String string) {
		this.expression = string;
	}

}
