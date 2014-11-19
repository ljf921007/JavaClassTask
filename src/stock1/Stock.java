package stock1;

public class Stock {

	String code = "";
	double currentPrice = 0.00;
	int[] amount = new int[100]; 
	double[] price = new double[100]; 
	int n = 0;
	double income = 0.00;
	
	public Stock(String code){
		this.code = code;
	}
	
	public double getIncome(){
		for(int i=0;i<n;i++){
			income += amount[i] * (currentPrice - price[i]);
		}
		return income;
	}
}
