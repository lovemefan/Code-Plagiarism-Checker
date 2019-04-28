   

public class Stock {
	public static void main(String[] agrs){
		 Stock stock1 = new Stock();
		 stock1.currentprice = 34.35;
		 stock1.previousClosingPrice = 34.5;
		 System.out.println("The stock of symbol:" + stock1.symbol + ", name:" + 
		 stock1.name + " is " + stock1.getChangePercent());
		          
	}
	String symbol;
	String name;
	double previousClosingPrice;
	double currentprice;
	
	Stock(){
		symbol = "Oracle Corporation";
		name = "ORCL";
	}
	
	double getChangePercent(){
		return currentprice / previousClosingPrice;
	}

}
