import java.util.*;

public class Stock {
	
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	

	
	public Stock(String symbol,String name,double previousClosingPrice,double currentPrice)
	{
		this.symbol = symbol;
		this.name = name;
		this.previousClosingPrice = previousClosingPrice;
		this.currentPrice = currentPrice;
	}
	
	double getChangePercent()
	{
		return (currentPrice-previousClosingPrice)/currentPrice;
	}
	
	public static void main(String[] args)
	{
		Stock test = new Stock("ORCL","Oracle Corporation",34.5,34.35);
		System.out.println("The symbol is :"+test.symbol);
		System.out.println();
		System.out.println("The name is :"+test.name);
		System.out.println();
		System.out.println("The change is :"+test.getChangePercent());
	}
}
