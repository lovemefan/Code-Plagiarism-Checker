package exercise;

import java.io.ObjectInputStream.GetField;

public class Stock {
	public static void main (String[] args) {
		Stock stock1 = new Stock();
		System.out.println("The Stock's name is" + stock1.name);
		System.out.println("The Stock's symbol is" + stock1.symbol);
		stock1.setCurrentPrice(34.35);
		System.out.println("The percentage variation is " + String.format("%.2f", stock1.getChangePercent() * 100)  +"%");
	}
	private String symbol;
	private String name;
	private double previousClosingPrice;
	private double currentPrice;
	public Stock() {
		symbol = "ORCL";
		name = "oracle Corporation";
		previousClosingPrice = 34.5;
		currentPrice = 34.35;
	}
	public double getChangePercent() {
		return (currentPrice - previousClosingPrice) / previousClosingPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
}
