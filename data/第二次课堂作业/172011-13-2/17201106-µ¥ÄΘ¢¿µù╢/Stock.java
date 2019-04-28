package 第二次作业;

public class Stock {
	private String symbol;
	private String name;
	private double previousClosingPrice;
	private double currentPrice;
	
	public void setStock(String symbol,String name,double previousClosingPrice,double currentPrice){
		this.symbol=symbol;
		this.name=name;
		this.previousClosingPrice=previousClosingPrice;
		this.currentPrice=currentPrice;
	}
	
	public double getChangePercent(){
		double k=((currentPrice-previousClosingPrice)/previousClosingPrice)*100;
		return k;
	}
	
	public static void main(String args[]){
		Stock sto=new Stock();
		sto.setStock("ORCL", "Oracle Corporation", 34.5, 34.35);
		System.out.println(sto.getChangePercent()+"%");
	}
}
