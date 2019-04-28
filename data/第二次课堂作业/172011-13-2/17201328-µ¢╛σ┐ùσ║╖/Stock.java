
public class Stock {
	private String symbol;
	private String name;
	private double previousClosingPrice = 0;
	private double currentPrice = 0;
	public Stock(){
		
	}
	public String setName(){
		this.name = "Oracle Corporation";
		return name;
	}
	
	public String setSymbol(){
		this.symbol = "ORCL";
		return symbol;
	}
	
	public void setPrice(double previous, double current){
		this.previousClosingPrice = previous;
		this.currentPrice = current;
	}
	
	public double getChangePercent(){
		double change = 0;
		change = (currentPrice - previousClosingPrice) / currentPrice;
		return change;
	}
}
