package work;

public class Stock {
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;
    Stock(String newSymbol,String newName, double newPreviousClosingPrice,double newCurrentPrice){
    	symbol=newSymbol;
    	name=newName;
    	previousClosingPrice=newPreviousClosingPrice;
    	currentPrice=newCurrentPrice;
    }
    public String getSymbol(){
    	
    	return symbol;
    }
    public String getName(){
    	return name;
    }
    public double getPreviousClosingPrice(){
    	return previousClosingPrice;
    }
    public double getCurrentPrice(){
    	return currentPrice;
    }
    double getChangePercent(){
    	return (currentPrice-previousClosingPrice)/previousClosingPrice;
    }
   
    }

