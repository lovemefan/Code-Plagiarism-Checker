import java.util.Scanner;//加载输入类
public class SumDigits//求一个整数各位数的和-2.6
{
	public static void main(String[] args) {
		System.out.println("Enter a number between 0 and 1000:");
		Scanner input=new Scanner(System.in);
		
		int number=input.nextInt();//输入数字
		int sum=0;//初始化sum
		
		for(int i=0;i<3;i++) {
			sum+=(number%10);//sum加上拆分掉的数字
			number=number/10;//number去掉拆分下来的数字
			if(number==0) {
				System.out.println("The sum of the digits is "+sum);
				break;
			}
		}
	}
}
