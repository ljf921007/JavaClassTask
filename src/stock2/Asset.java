package stock2;
 // A Stock object represents purchases of shares of a stock.  
abstract class Asset implements AssetInterface{
	private String symbol;        // stock symbol, e.g. "YHOO"     
	private int totalShares;      // total shares purchased     
	private double totalCost;     // total cost for all shares 
	// Initializes a new Stock with no shares purchased.     
	// Precondition: symbol != null
	public Asset(String theSymbol) {         
		if (theSymbol == null) {             
			throw new NullPointerException();         
			}          
		symbol = theSymbol;
		totalShares = 0;
		totalCost = 0.0;
	}
	
	//getter and setter methods of "totalCost"
	double getTotalCost(){
		return this.totalCost;
	}
	void setTotalCost(double totalCost){
		this.totalCost = totalCost;
	}
	
	//getter and setter methods of "totalShares"
	int getTotalShares(){
		return this.totalShares;
	}
	void setTotalShares(int totalShares){
		this.totalShares = totalShares;
	}
	

}
