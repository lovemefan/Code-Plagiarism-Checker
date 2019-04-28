import java.util.*;
public class Stock {
   private String symbol="symbol";
   private String name="name";
   private double previousClosingPrice=0;
   private double currentPrice=0;
   Scanner input=new Scanner (System.in);
   public double getChangePercent(){
	  return (currentPrice-previousClosingPrice)/previousClosingPrice*100;
   }
   public void getSymbolAndName(){
	    symbol=input.next();
	    name=input.next();
   }
   public void getPrice(){
	   previousClosingPrice=input.nextDouble();
	   currentPrice=input.nextDouble();
   }
   public String returnSymbol(){
	   return symbol;
   }
   public String returnName(){
	   return name;
   }
   
   
}
