package 大作业01;

import java.io.File;  
import java.util.Scanner;

/*测试主类*/
public class TestCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f1 = new File("src\\大作业01\\exp");
		File f2 = new File("src\\大作业01\\value");
		ExpFileOperate fo = new ExpFileOperate();
		
		System.out.println("**********数学表达式计算器**********");
		System.out.println("	1.正确输入表达式		");
		System.out.println("	2.异常输入表达式		");	
		System.out.print("请输入测试选项（1或2）：");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		System.out.print("请输入写入exp文件中内容的行数：");
		int n = input.nextInt();
		String[] infix = fo.readLine(f1,n);//读取文件每条内容并赋值
		int[] result = new int[n];//表达式结果记录数组
		
		switch(num) {
			case 1:			
				CalculateExpression exp = new CalculateExpression();//创建对象	
				for(int i=0; i<n; i++) { 
					exp.testExp(infix[i]);
					result[i] = exp.opnd.peek();//每个结果存到数组中		
				}
				fo.writeFile(f2,infix,result,n);//写入文件
				break;
			case 2:
				CheckExpression ckExp = new CheckExpression();//创建对象	
				for(int i=0; i<n; i++) {				
					ckExp.checkExp(infix[i]);					
				}
				break;
			default:
				break;
		}	
	}

}

