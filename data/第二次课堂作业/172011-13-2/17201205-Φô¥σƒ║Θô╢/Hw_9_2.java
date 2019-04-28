package HW;

import java.util.Scanner;

public class Hw_9_2 {
		public static void main (String[] atgs){
		Scanner input = new Scanner (System.in);
		
		Stock ORCL = new Stock("ORCL","Oracle Corporation",34.5,34.55);
		
		System.out.println("The change percent is " + ORCL.getChangePercent(ORCL.previousClosingPrice, ORCL.currentPrice));
		
		}
}
	class Stock  {
		
		String symbol = "";
		String name = "";
		double previousClosingPrice  = -1 ;
		double currentPrice = -1 ;
		
		Stock (){
			String symbol = "";
			String name = "";
			double previousClosingPrice  = -1 ;
			double currentPrice = -1 ;
		}
		Stock (String symbol,String name,double previousClosingPrice,double currentPrice){
			this.symbol = symbol;
			this.name = name ;
			this.previousClosingPrice  = previousClosingPrice ;
			this.currentPrice = currentPrice ;
		}
		
		double getChangePercent (double previousClosingPrice,double currentPrice) {
			return previousClosingPrice / currentPrice;
		}
	}