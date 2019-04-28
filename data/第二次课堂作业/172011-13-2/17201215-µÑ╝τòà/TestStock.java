
public class TestStock {
	public static void main(String[] args) {
		Stock s = new Stock();
		s.symbol = "ORCL";
		s.name = "Oracle Corporation";
		s.previousClosingPrice = 34.5;
		s.currentPrice = 34.35;
		System.out.println("The stock's symbol is " + s.symbol);
		System.out.println("The stock's name is " + s.name);
		System.out.println("The stock's previousClosingPrice is " + s.previousClosingPrice);
		System.out.println("The stock's currentPrice is " + s.currentPrice);
		System.out.println("Percentage change in market value is " + s.getChangePercent() + "%");
	}

}

class Stock {
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	
	double getChangePercent() {
		return ((previousClosingPrice - currentPrice) / currentPrice) * 100;
	}
	
}
