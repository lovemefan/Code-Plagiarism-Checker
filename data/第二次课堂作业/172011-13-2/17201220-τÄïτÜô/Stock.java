package two;

public class Stock {
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	Stock(String newSymbol,String newName,double newPreviousClosingPrice,double newCurrentPrice){
		symbol = newSymbol;
		name = newName;
		previousClosingPrice = newPreviousClosingPrice;
		currentPrice = newCurrentPrice;
	} 
	double getChangePrice(){
		return ((currentPrice-previousClosingPrice)/previousClosingPrice)*100;
	}
	void setSymbol(String newSymbol){
		symbol = newSymbol;
	}
	void setName(String newName){
		name = newName;
	}
	void setPreviousClosingPrice(double newPreviousClosingPrice){
		previousClosingPrice = newPreviousClosingPrice;
	}
	void setCurrentPrice(double newCurrentPrice){
		currentPrice = newCurrentPrice;
	}

}
