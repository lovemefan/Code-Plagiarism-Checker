
public class Stock {
	private String symbol;
	private String name;
	private double previousClosePrice=0;
	private double currentPrice=0;
	public Stock(String symbol,String name){
		this.name=name;
		this.symbol=symbol;
	}
	public double getChangePercent(double previousClosePrice,double currentPrice){
		this.previousClosePrice=previousClosePrice;
		this.currentPrice=currentPrice;
		return 100*(this.currentPrice-this.previousClosePrice)/this.previousClosePrice;
	}
}
