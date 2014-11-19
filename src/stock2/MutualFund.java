package stock2;
//the subclass of Stock which has a new parameter--totalMutualFund
public class MutualFund extends Stock{
	double totalMutualFund;
	public MutualFund(String theSymbol) {
		super(theSymbol);
		totalMutualFund = 0.0;
	}
	// Returns the total marketValue of this stock,     
	// based on the given price per share.     
	// pre: currentPrice >= 0.0   
	public double getMarketValue(double currentPrice) {
		if (currentPrice < 0.0) {             
			throw new IllegalArgumentException();         
		}          
		return totalMutualFund * currentPrice;   
	}

	// Returns the total profit or loss earned on this stock,     
	// based on the given price per share.     
	// pre: currentPrice >= 0.0     
	public double getProfit(double currentPrice) {         
		if (currentPrice < 0.0) {             
			throw new IllegalArgumentException();         
		}          
		double marketValue = totalMutualFund * currentPrice;         
		return marketValue - super.getTotalCost();     
	}      
	// Records purchase of the given shares at the given price.     
	// pre: shares >= 0 && pricePerShare >= 0.0     
	public void purchase(double shares, double pricePerShare) {         
		if (shares < 0.0 || pricePerShare < 0.0) {             
			throw new IllegalArgumentException();         
		}          
		totalMutualFund += shares;   
		double totalCost = super.getTotalCost();
		totalCost += shares * pricePerShare;
		super.setTotalCost(totalCost);
	} 
}
