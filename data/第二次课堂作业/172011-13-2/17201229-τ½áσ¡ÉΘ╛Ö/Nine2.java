import java.util.Scanner;

public class Nine2 {

	public static void main(String[] args) {
		
		Stock a;
		a = new Stock();
		a.setStock(34.5,34.35);
		
		System.out.println("Symbol: " + a.symbol +"    Name: " + a.name);
		System.out.println("PreviousClosingPrice: " + a.previousClosingPrice + " CurrentPrice: " + a.currentPrice );   
		System.out.println("Percent Variation: " + a.getChangePercent());

	}

}
 class Stock {

	String symbol = "ORCL";
	String name = "Oracle Corporation";
	double previousClosingPrice,currentPrice;
	
	Stock() {}
	
	public void setStock(double newPreviousClosingPrice,double newCurrentPrice){
		previousClosingPrice = newPreviousClosingPrice;
		currentPrice = newCurrentPrice;
	}
	
	double getChangePercent(){
		return (currentPrice-previousClosingPrice)*100/previousClosingPrice;
	}
	
}