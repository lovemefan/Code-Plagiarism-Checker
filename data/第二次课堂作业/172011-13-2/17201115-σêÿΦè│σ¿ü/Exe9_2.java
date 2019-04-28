package dame;

import java.util.Scanner;

public class Exe9_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the stock's name:");
        String name1 =input.nextLine();
        System.out.println("Enter the stock's symbol:");
        String symbol1 =input.nextLine();
        Stock c1;
        c1=new Stock();
        c1.getStock(symbol1, name1);
        System.out.println("Enter the stock last price and new price :");
        double a1 = input.nextDouble();
        double b1 = input.nextDouble();
        c1.getdatas(a1, b1);
        double Percentage = c1.getChangePercent()*100;
        System.out.println("The stock's name is"+name1+" symbol is "+symbol1+"and changing percentage is"+Percentage+"%");
	}

}
class Stock{
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	public void getStock(String Newsymbol,String Newname){                   //输入名字
		symbol=Newsymbol;
		name= Newname;
	}
	public void getdatas(double a,double b) {                                  //两项数据
		previousClosingPrice=a;
		currentPrice = b;	
	}
	public double getChangePercent(){                                         //求百分比
		double percentage =(currentPrice-previousClosingPrice)/currentPrice;
		return percentage;
	}
}