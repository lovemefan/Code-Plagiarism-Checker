package assignments1;

class Stock{
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	Stock(String symbol,String name,double pCP){
		this.symbol = symbol;
		this.name = name;
		this.previousClosingPrice = pCP;
	}
	void setcurrentPrice(double cP){
		this.currentPrice = cP;
	}
	double getChangePercent(){
		return (currentPrice-previousClosingPrice)/currentPrice*100;
	}
}
public class work9_2 {
	public static void main(String[] args){
		Stock stock = new Stock("ORCL","Oracle Corporation",34.5);
		stock.setcurrentPrice(34.35);
		System.out.println("The percentage is "+stock.getChangePercent()+"%");
	}
}
