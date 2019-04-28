
class Stock {
  String symbol;
  String name;
  double previousClosingPrice;
  double currentPrice;

  public Stock() {
  }

  public Stock(String newSymbol, String newName) {
    symbol = newSymbol;
    name = newName;
  }

  public double getChangePercent() {
    return (currentPrice - previousClosingPrice) /
      previousClosingPrice;
  }
  
  public double getPreviousClosingPrice() {
    return previousClosingPrice;
  }
  
  public double getCurrentPrice() {
    return currentPrice;
  }
  
  public void setCurrentPrice(double newCurrentPrice) {
    currentPrice = newCurrentPrice;
  }
  
  public void setPreviousClosingPrice(double newPreviousClosingPrice) {
    previousClosingPrice = newPreviousClosingPrice;
  }
}
