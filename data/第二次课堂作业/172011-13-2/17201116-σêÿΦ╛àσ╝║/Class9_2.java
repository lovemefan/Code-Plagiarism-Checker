import java.util.Scanner;
public class Class9_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        Stock s1 = new Stock("ORCK","Oracle Corporation",34.5,34.35);
        System.out.println("The code, name ,previousClosingPrice,currentPrice and percentage of change are respectively:" + s1.symbol + " " + s1.name + " " + s1.previousClosingPrice + " " + s1.currentPrice + " %" + s1.getChangPercent());
	}
}
class Stock{
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	Stock(String symbol,String name,double previousClosingPrice,double currentPrice)
	{
		this.symbol=symbol;
		this.name=name;
		this.previousClosingPrice=previousClosingPrice;
		this.currentPrice=currentPrice;
	}
	double getChangPercent()
	{
		return (currentPrice-previousClosingPrice)/currentPrice*100;
	}
}
