
public class Stock {
	private String stmbol;
	private String name;
	public double previousClosingPrice;
	public double currentPrice;
	
	public Stock(String stmbol,String name) {
		this.stmbol = stmbol;
		this.name = name;
	}
	
	public double getChangePercent(double previousClosingPrice,double currentPrice) {
		this.previousClosingPrice = previousClosingPrice;
		this.currentPrice = currentPrice;
		double percent = Math.abs(previousClosingPrice - currentPrice) / previousClosingPrice * 100;
		return percent;
	}
	
}
