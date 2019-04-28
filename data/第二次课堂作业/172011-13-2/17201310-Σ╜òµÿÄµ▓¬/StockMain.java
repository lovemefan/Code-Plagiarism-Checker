import java.util.Scanner;

public class StockMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Stock stock = new Stock();
		System.out.println("company's name: " + stock.getName());
		System.out.println("company's symbol: " + stock.getSymbol());
		System.out.print("The price of previous stack is : ");
		stock.setPreviousClosingPrice(input.nextDouble());
		System.out.print("The price of current stack is : ");
		stock.setCurrentPrice(input.nextDouble());
		System.out.println("The change of stock is : " + stock.getChangePercent());

		input.close();
	}

}

class Stock {
	private String symbol;
	private String name;
	private double previousClosingPrice;
	private double currentPrice;

	public Stock() {
		previousClosingPrice = 0.0;
		currentPrice = 0.0;
		symbol = "01810";
		name = "小米集团-W";
	}

	public void setPreviousClosingPrice(double previousClosingPrice) {
		this.previousClosingPrice = previousClosingPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getChangePercent() {
		return  String.format("%.2f%%", (currentPrice - previousClosingPrice) / previousClosingPrice * 100);
	}
	
	public String getName() {
		return name;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
}