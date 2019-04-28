package stock;

public class Stock {
	public static void main(String[] args){
		Stock stock1 = new Stock();
		System.out.println(stock1.symbol + "\n" +stock1.name + " \npreviousclosingprice is " + stock1.previousClosingPrice + " \ncurrentprice is " + stock1.currentPrice + " \nthe changepercent is " + stock1.getChangePercent());
		Stock stock2 = new Stock("ORCL","Oracle Corporation",34.5,34.35);
		System.out.println(stock2.symbol + "\n" +stock2.name + " \npreviousclosingprice is " + stock2.previousClosingPrice + " \ncurrentprice is " + stock2.currentPrice + " \nthe changepercent is " + stock2.getChangePercent());
		//setStock("ORCL","Oracle Corporation",34.5,34.35);
		//System.out.println(stock1.symbol + stock1.name + " previousclosingprice is " + stock1.previousClosingPrice + " currentprice is " + stock1.currentPrice + " ,the changepercent is " + stock1.getChangePercent());
	}
	String symbol,name;
	double previousClosingPrice, currentPrice;
	
	Stock(){
		symbol = "0";
		name = "0";
		previousClosingPrice = 1;
		currentPrice = 1;
	}
	
	Stock(String newSymbol,String newName,double newPreviousClosingPrice,double newCurrentPrice){
		this.symbol = newSymbol;
		this.name = newName;
		this.previousClosingPrice = newPreviousClosingPrice;
		this.currentPrice = newCurrentPrice;
	}
	
	double getChangePercent(){
		return currentPrice / previousClosingPrice - 1;
	}
	
	void setStock(String newSymbol,String newName,double newPreviousClosingPrice,double newCurrentPrice){
		this.symbol = newSymbol;
		this.name = newName;
		this.previousClosingPrice = newPreviousClosingPrice;
		this.currentPrice = newCurrentPrice;
	}
}
