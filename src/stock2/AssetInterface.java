package stock2;
//define the common methods of 4 assets
public interface AssetInterface {
	abstract double getMarketValue(double currentPrice);
	abstract double getProfit(double currentPrice);
}
