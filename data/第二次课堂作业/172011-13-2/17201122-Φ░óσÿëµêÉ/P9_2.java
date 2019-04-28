package project2;

public class P9_2 {

	public static void main(String[] args) {
		Stock stock=new Stock("ORCL","Oracle Corporation",34.5,34.35);
		System.out.println("The price has changed "+stock.getChangePercent()+"%");

	}

}
class Stock{
	String symble;
	String name;
	double previousClosingPrice;
	double currentPrice;
	Stock(){
	}
	Stock(String symble,String name,double previousClosingPrice,double currentPrice){
		this.symble=symble;
		this.name=name;
		this.previousClosingPrice=previousClosingPrice;
		this.currentPrice=currentPrice;
	}
	double getChangePercent() {
		return 100*(currentPrice-previousClosingPrice)/previousClosingPrice;
	}
}