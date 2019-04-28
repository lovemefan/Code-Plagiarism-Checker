package ccc;

public class Stock {
	public static void main(String[] args) {
		String symbol="ORCL";
		String name="Oracle Corporation";
		double previousClosingPrice=34.5;
		A gu=new A(34.35);
		System.out.println("Before: "+previousClosingPrice);
		gu.setCurrent(34.35);
		System.out.println("After: "+gu.currentPrice);
		System.out.println(gu.getChangePercent()*100+"%");
		
		
	}

}

class A {
	double currentPrice;
	
	A(double newCurrent){
		currentPrice=newCurrent;
	}
	double getChangePercent(){
		return (currentPrice-34.5)/34.5;
	}
	void setCurrent(double newCurrent){
		currentPrice=newCurrent;
	}
}

