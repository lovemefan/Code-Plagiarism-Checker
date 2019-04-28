
public class TestStock {
public static void main(String[] args){
	Stock aStock=new Stock();
	System.out.println("Please enter the symbol and the name of the stock : ");
	aStock.getSymbolAndName();
	System.out.println("Symbol : "+aStock.returnSymbol());
	System.out.println("Name : "+aStock.returnName());
	System.out.println("Please enter the value of previousClosing Price and current price : ");
    aStock.getPrice();
	System.out.println("The percent of the stock is :"+aStock.getChangePercent()+"%");
}
}
