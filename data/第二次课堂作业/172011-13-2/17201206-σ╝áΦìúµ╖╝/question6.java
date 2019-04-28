package class2;

import java.util.Scanner;

public class question6 {
	public static void main(String[] args){		
		Scanner input =new Scanner(System.in);
		Stock m1=new Stock("ORCL","Oracle Corporation",34.5,34.35);
		System.out.println(String.format("%.2f", m1.getChangePercent()*100)+"%");
    }
}
class Stock{
	String symbol="";
	String name=" ";
	double PreviousClosingPrice=0;
	double CurrentPrice=0;
	Stock(String newSymbol,String newName,double newPreviousClosingPrice,double newCurrentPrice){
		this.symbol=newSymbol;
		this.name=newName;
		this.PreviousClosingPrice=newPreviousClosingPrice;
		this.CurrentPrice=newCurrentPrice;
	}
	double getChangePercent(){
		return (PreviousClosingPrice-CurrentPrice)/CurrentPrice;
	}
	
}
