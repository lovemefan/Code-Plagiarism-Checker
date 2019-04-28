package Zuoye;


public class TestStock {
	public static void main(String[] args) {
	Stock hhh=new Stock("ORCL","Oracle Corporation");
	hhh.setPreviousClosingPrice(34.5);
	hhh.setCurrentPrice(34.35);
	System.out.println("The change percent is "+hhh.getChangePercent()*100);
	}
}

class Stock{
	String symbo1;
	String name;
	double previousClosingPrice;
	double currentPrice;   
    public Stock (String newSymbo1,String newName){
		symbo1=newSymbo1;name=newName;
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