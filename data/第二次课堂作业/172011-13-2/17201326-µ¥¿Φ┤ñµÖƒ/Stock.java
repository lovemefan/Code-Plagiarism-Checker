package test2;

public class Stock {
	private String symbol = new String("");
	private String name = new String("");
	private double previousClosingPrice = 0;
	private double currentPrice = 0;
	
	public Stock(String symbol, String name, double previousClosingPrice, double currentPrice){
		this.symbol = symbol;
		this.name = name;
		this.currentPrice = currentPrice;
		this.previousClosingPrice = previousClosingPrice;
	}
	
	public double getChangePercent(){
		double a = ((this.previousClosingPrice-this.currentPrice) / this.previousClosingPrice ) * 100;
		return a;
	}
}
