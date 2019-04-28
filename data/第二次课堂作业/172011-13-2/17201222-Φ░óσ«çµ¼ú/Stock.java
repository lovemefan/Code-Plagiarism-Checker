package nice;

public class Stock {
	public static void main(String[] args){
		Stock stock = new Stock(34.5,34.35,"Oracle Corporation","ORCL");
		System.out.println("The name of " + stock.name + " its code is " + stock.symbol
				+ " yesterday's price is " + stock.previousClosingPrice + " today's price is " 
				+ stock.currentPrice + " and its rate of change is " + stock.getChangePercent() );
	}
	double previousClosingPrice,currentPrice;
	String name,symbol;
	Stock(){
		previousClosingPrice = 1;
		currentPrice = 1;
		name = "Orc";
		symbol = "ORC";
	}
	Stock(double newPeviousClosingPrice, double newCurrentPrice,String newName,String newSymbol){
		previousClosingPrice =  newPeviousClosingPrice;
		currentPrice = newCurrentPrice;
		name = newName;
		symbol = newSymbol;
	}
	double getChangePercent(){
		return (previousClosingPrice-currentPrice)/previousClosingPrice;
	}
	void setPreviousClosingPrice(double newPeviousClosingPrice){
		previousClosingPrice =  newPeviousClosingPrice;
	}
	void setCurrentprice(double newCurrentPrice){
		currentPrice = newCurrentPrice;
	}

}
