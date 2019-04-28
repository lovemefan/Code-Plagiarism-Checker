package homework;

public class Stock {
	String symbol,name;
	double previousClosingPrice,currentPrice;
	public Stock(String newsymbol,String newname){
		symbol=newsymbol;
		name=newname;
	}
	public double getChangePercent(){
		return ((currentPrice-previousClosingPrice)*100/previousClosingPrice);
	}

}
