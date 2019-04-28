package Stock;//9.2

public class Stock {
	private String symbol,name;
	double previousClosingPrice = 0,currentPrice = 0;
	public Stock() {
		
	}
	public Stock(String symbol,String name) {
		this.symbol = symbol;
		this.name = name;
	}
	public void setPreviousClosingPrice( double previousClosingPrice) {
		this.previousClosingPrice = previousClosingPrice;
	}
	public void setCurrentPrice( double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public String getSymbol() {
		return symbol;
	}
	public String getName() {
		return name;
	}
	public double getPreviousClosingPrice() {
		return previousClosingPrice;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public double getChangePercent() {
		return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
	}
	
}
