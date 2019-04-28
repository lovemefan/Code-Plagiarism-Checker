import java.util.Scanner;

public class Homework_9_2 {
	public static void main(String[] args) {
		Stock stock = new Stock("ORCL", "Oracke Corpoation");
		
		stock.setPreviousClosingPrice(34.5);
		stock.setCurrentPrice(34.35);
		
		System.out.println(stock.getChangePercent());
	}
}

class Stock {
	private String symbol, name;
	private double previousClosingPrice;
	private double currentPrice;
	
	Stock (String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}
	
	void setPreviousClosingPrice(double previousClosingPrice) {
		this.previousClosingPrice = previousClosingPrice;
	}
	
	void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	double getChangePercent() {
		return (currentPrice - previousClosingPrice) / currentPrice;
	}
}