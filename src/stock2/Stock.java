package stock2;

public class Stock extends Asset{
	public Stock(String theSymbol) { 
        super(theSymbol);
	}

	// Returns the total marketValue of this stock,     
	// based on the given price per share.     
	// pre: currentPrice >= 0.0   
	public double getMarketValue(double currentPrice) {
		if (currentPrice < 0.0) {             
			throw new IllegalArgumentException();         
		}          
		return super.getTotalShares() * currentPrice;   
	}
	// Returns the total profit or loss earned on this stock,     
	// based on the given price per share.     
	// pre: currentPrice >= 0.0     
	public double getProfit(double currentPrice) {         
		if (currentPrice < 0.0) {             
			throw new IllegalArgumentException();         
		}          
		double marketValue = super.getTotalShares() * currentPrice;         
		return marketValue - super.getTotalCost();     
	}
	// Records purchase of the given shares at the given price.     
	// pre: shares >= 0 && pricePerShare >= 0.0     
	public void purchase(int shares, double pricePerShare) {         
		if (shares < 0 || pricePerShare < 0.0) {             
			throw new IllegalArgumentException();         
		}
		super.setTotalShares(super.getTotalShares() + shares);
		super.setTotalCost(super.getTotalCost() + shares * pricePerShare);
	} 
}
