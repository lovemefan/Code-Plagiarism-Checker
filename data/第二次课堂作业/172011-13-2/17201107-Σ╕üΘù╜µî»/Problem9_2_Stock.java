package dmz;

public class Problem9_2_Stock {
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	public static void main(String[] args) {//≤‚ ‘≥Ã–Ú
		Problem9_2_Stock stock = new Problem9_2_Stock("ORCL","Oracle Corporation");
		stock.previousClosingPrice = 34.5;
		stock.currentPrice = 34.35;
		System.out.println("The stock symbol " + stock.symbol + " " + stock.name + " changepercent is " + stock.getChangePercent() * 100 + "%");
	}
	Problem9_2_Stock(String symbol1,String name1){
		symbol = symbol1;
		name = name1;
	}
	double getChangePercent() {
		return Math.abs(1 - currentPrice/previousClosingPrice);
	}

}
