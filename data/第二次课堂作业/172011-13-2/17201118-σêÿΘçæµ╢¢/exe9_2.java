package test;

public class exe9_2 {
	public static void main(String[] args) {
	Stock ex1;
	ex1=new Stock("ORCL","Oracle Corporation");
	ex1.setPreviousClosingPrice(34.5);
	ex1.setCurrentPrice(34.35);
	System.out.println("The change percent is "+ex1.getChangePercent()*100);
	}
}

class Stock{
	String symbo1;
	String name;
	double previousClosingPrice;//前一日股票
	double currentPrice;   //当时股票值
    public Stock (String newSymbo1,String newName){
		symbo1=newSymbo1;
		name=newName;
	}
	public double getChangePercent() {
		double changepercent=currentPrice-previousClosingPrice;
		return changepercent;
	}
	public void setPreviousClosingPrice(double newPreviousClosingPrice) {
		previousClosingPrice=newPreviousClosingPrice;
	}
	public void setCurrentPrice(double newCurrentPrice) {
		currentPrice=newCurrentPrice;
	}
}