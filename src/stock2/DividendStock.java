package stock2;
//the subclass of Stock which has a new method "getDividend"
public class DividendStock extends Stock{
	public DividendStock(String theSymbol) { 
        super(theSymbol);
	}
	// Returns the total dividend earned on this stock,     
	// based on the given dividend per share.     
	// pre: DividendPerStock >= 0.0    
	public double getDividend(double DividendPerStock){
		return super.getTotalShares()*DividendPerStock;
	}

}
