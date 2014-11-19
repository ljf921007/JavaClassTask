package stock1;
import java.util.Scanner;



public class Main {
	
	public static void main (String[] args ){
		
		Scanner br = new Scanner(System.in );
		
		//股票一的参数输入和收益计算
		System.out.println("请输入第一支股票代码：");
		Stock stock1 = new Stock(br.next());
		System.out.println("请输入你购买了几次该只股票：");
		stock1.n = br.nextInt();
		for(int i = 0;i<stock1.n;i++){
			System.out.println("请输入第" + (i+1) +"次购买数量，购买价格（以空格区分）");
			stock1.amount[i] = br.nextInt();
			stock1.price[i] = br.nextDouble();
		}
		System.out.println("请输入当前该股票价格：");
		stock1.currentPrice = br.nextDouble();
		System.out.println("净收益亏损为：" + stock1.getIncome());
		
		//股票二的参数输入和收益计算
		System.out.println("请输入第二支股票代码：");
		Stock stock2 = new Stock(br.next());
		System.out.println("请输入你购买了几次该只股票：");
		stock2.n = br.nextInt();
		for(int i = 0;i<stock2.n;i++){
			System.out.println("请输入第" + (i+1) +"次购买数量，购买价格（以空格区分）");
			stock2.amount[i] = br.nextInt();
			stock2.price[i] = br.nextDouble();
		}
		System.out.println("请输入当前该股票价格：");
		stock2.currentPrice = br.nextDouble();
		System.out.println("净收益亏损为：" + stock2.getIncome());
		
		//比较两只股票的收益大小
		if(stock1.income > stock2.income){
			System.out.println(stock1.code + "收益更高");
		}else if(stock1.income == stock2.income){
			System.out.println(stock1.code + "和" + stock2.code + "收益一样高");
		}else{
			System.out.println(stock2.code + "收益更高");
		}
	}

}
