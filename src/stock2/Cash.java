package stock2;
//the subclass of Stock which has a new parameter--totalCash
public class Cash extends Stock{
	double totalCash;
	public Cash(String theSymbol) { 
      super(theSymbol);
      totalCash = 0.0;
	}
	// Returns the total marketValue of this stock,     
	// based on the given price per share.     
	// pre: currentPrice >= 0.0   
	public double getMarketValue(double currentPrice) {
		if (currentPrice < 0.0) {             
			throw new IllegalArgumentException();         
		}          
		return totalCash * currentPrice;   
	}
	// Returns the total profit or loss earned on this stock,     
	// based on the given price per share.     
	// pre: currentPrice >= 0.0     
	public double getProfit(double currentPrice) {         
		if (currentPrice < 0.0) {             
			throw new IllegalArgumentException();         
		}          
		double marketValue = totalCash * currentPrice;         
		return marketValue - super.getTotalCost();     
	}      
	// Records purchase of the given shares at the given price.     
	// pre: shares >= 0 && pricePerShare >= 0.0     
	public void purchase(double shares, double pricePerShare) {         
		if (totalCash + shares < 0.0 || pricePerShare < 0.0) {             
			throw new IllegalArgumentException();         
		}     
		totalCash += shares;   
		double totalCost = super.getTotalCost();
		totalCost += shares * pricePerShare;
		super.setTotalCost(totalCost);
	} 
}