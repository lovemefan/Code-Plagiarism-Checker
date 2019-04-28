
public class Stock {
	String symbol = "ORCL";
	String name = "Oracle Corporation";
	double previousClosingPrice;
	double currentPrice;
	
	Stock(double newPreviousClosingPrice,double newCurrentPrice) {
		this.previousClosingPrice = newPreviousClosingPrice;
		this.currentPrice = newCurrentPrice;
	}
	
	double getChangePercent() {
		return (currentPrice - previousClosingPrice)/previousClosingPrice*100;
	}

}
