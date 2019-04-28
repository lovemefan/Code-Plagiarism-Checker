package work;

public class Stock {
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	Stock(String newSymbol,String newName){
		symbol = newSymbol;
		name = newName;
	}
	public double getChangePercent(){
		double changePercent = (currentPrice - previousClosingPrice) / previousClosingPrice;
		return changePercent;
	}
	public void setCurrentPrice(double newCurrentPrice){
		currentPrice = newCurrentPrice;
	}
	public void setPreviousClosingPrice(double newPreviousClosingPrice){
		previousClosingPrice = newPreviousClosingPrice;
	}

}
