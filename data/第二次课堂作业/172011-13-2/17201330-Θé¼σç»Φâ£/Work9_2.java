package lab2;

public class Work9_2 {

	public static void main(String[] args) {
		Stock stock = new Stock("ORCL","Oracle Corporation",34.5,34.35);
		System.out.println("Symbol:" + stock.symbol);
		System.out.println("Name:" + stock.name);
		System.out.println("PreviousClosingPrice:" + stock.previousClosingPrice);
		System.out.println("CurrentPrice:" + stock.currentPrice);
		System.out.println("ChangePercent:" + stock.getChangePercent() + '%');
	}

}
class Stock{
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	
	public Stock(){
		symbol = "ABCD";
		name = "123" ;
	 }
	
	public double getChangePercent() {
		return (int)(Math.abs(previousClosingPrice - currentPrice) / previousClosingPrice * 100 * 10000) / 10000.0;
	}
	
	public Stock(String symbol,String name,double previousClosingPrice,double currentPrice) {
        this.symbol=symbol;
        this.name=name;
        this.previousClosingPrice=previousClosingPrice;
        this.currentPrice=currentPrice;
    }
}
