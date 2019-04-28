package test1013;



public class Test92 {

	public static void main(String[] args) {
		Stock stock=new Stock("ORCL","Oracle Corporation");
		stock.previousClosingPrice=34.5;
		stock.currentPrice=34.35;
		System.out.println("Change percent is"+stock.getChangePercent());
		
	}

}
class Stock{
	double previousClosingPrice;
	double currentPrice;
	String symbol;
    String name;
	
	public double getChangePercent() {
		return (Math.max(previousClosingPrice , currentPrice )-Math .min(previousClosingPrice , currentPrice ))/previousClosingPrice*100;
	}


	public Stock (String symbol,String name) {
		this.symbol=symbol;
	}
}
