package stock1;
import java.util.Scanner;



public class Main {
	
	public static void main (String[] args ){
		
		Scanner br = new Scanner(System.in );
		
		//��Ʊһ�Ĳ���������������
		System.out.println("�������һ֧��Ʊ���룺");
		Stock stock1 = new Stock(br.next());
		System.out.println("�������㹺���˼��θ�ֻ��Ʊ��");
		stock1.n = br.nextInt();
		for(int i = 0;i<stock1.n;i++){
			System.out.println("�������" + (i+1) +"�ι�������������۸��Կո����֣�");
			stock1.amount[i] = br.nextInt();
			stock1.price[i] = br.nextDouble();
		}
		System.out.println("�����뵱ǰ�ù�Ʊ�۸�");
		stock1.currentPrice = br.nextDouble();
		System.out.println("���������Ϊ��" + stock1.getIncome());
		
		//��Ʊ���Ĳ���������������
		System.out.println("������ڶ�֧��Ʊ���룺");
		Stock stock2 = new Stock(br.next());
		System.out.println("�������㹺���˼��θ�ֻ��Ʊ��");
		stock2.n = br.nextInt();
		for(int i = 0;i<stock2.n;i++){
			System.out.println("�������" + (i+1) +"�ι�������������۸��Կո����֣�");
			stock2.amount[i] = br.nextInt();
			stock2.price[i] = br.nextDouble();
		}
		System.out.println("�����뵱ǰ�ù�Ʊ�۸�");
		stock2.currentPrice = br.nextDouble();
		System.out.println("���������Ϊ��" + stock2.getIncome());
		
		//�Ƚ���ֻ��Ʊ�������С
		if(stock1.income > stock2.income){
			System.out.println(stock1.code + "�������");
		}else if(stock1.income == stock2.income){
			System.out.println(stock1.code + "��" + stock2.code + "����һ����");
		}else{
			System.out.println(stock2.code + "�������");
		}
	}

}
