public class TestStock {
    public static void main(String[] args) {
      Stock stock = new Stock("SUNW", "Sun MicroSystems Inc.");
      stock.setPreviousClosingPrice(100);

      // Set current price
      stock.setCurrentPrice(90);

      // Display stock info
      System.out.println("Previous Closing Price: " +
        stock.getPreviousClosingPrice());
      System.out.println("Current Price: " +
        stock.getCurrentPrice());
      System.out.println("Price Change: " +
        stock.getChangePercent() * 100 + "%");
    }
  }
