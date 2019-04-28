package classtest;

public class test9_2 {
	public static void main(String[] args) {
		Stock stock = new Stock();
		System.out.println(stock.symbol + "   " + stock.name + "   " + stock.previousClosingPrice + "   " +stock.currentPrice + "   " + stock.getChangePercent());
   }
}

  class Stock{
	 double previousClosingPrice;
	 double currentPrice;
	 String symbol;
	 String name;
	public Stock(){
		symbol = "2018";
		name = "уехЩ";
		previousClosingPrice =12800;
		currentPrice = 15600.1;
	}
	public double getChangePercent(){
		return (currentPrice - previousClosingPrice) / previousClosingPrice;
	}
}