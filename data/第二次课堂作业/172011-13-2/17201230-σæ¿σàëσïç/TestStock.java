package homework;

public class TestStock {
	public static void main(String[] args){
		Stock stock1=new Stock();
		stock1.currentPrice=34.35;
		System.out.println("The percentage of change in value is "+stock1.getChangePercent());
	}
}
class Stock{
	String symble="ORCL";
	String name="Oracle Corporation";
	double previousClosingPrice=34.5;
	double currentPrice=0;
	Stock(){
	}
	Stock(double newcurrentPrice){
		currentPrice=newcurrentPrice;
	}
	double getChangePercent(){
		return (previousClosingPrice-currentPrice)/previousClosingPrice;
	}
	void setStock(double newcurrentPrice){
		currentPrice=newcurrentPrice;
	}
}