package yangyufei;
public class Stocks {
	public static void main(String[] args){
		Stock stock1 = new Stock("ORCL", "Oracle Corporation");
		stock1.setPreviousClosingPrice(34.5);
		stock1.setCurrentPrice(34.35);
		System.out.printf("The change percent is %5.2f%%\n", stock1.getChangePercent() * 100);
	}

	static class Stock {
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	Stock(String newSymbol, String newName){
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
}