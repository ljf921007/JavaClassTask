package javaIO;

import java.io.*;  
public class TestIO{  
	public static void main(String[] args)  
			throws IOException{  
  
		File path=new File("F:/test");
		File dir=new File(path,"hello.txt");
		if(!dir.exists())
		dir.createNewFile(); 
		
		//1.����Ϊ��λ��һ���ļ���ȡ����  
		BufferedReader in =  new BufferedReader(
				new FileReader(dir));  
		String s, s2 = new String();  
		while((s = in.readLine()) != null)  
			s2 += s + "\n ";  
		in.close();  
		// ����ȡ�ļ�ʱ���Ȱ��ļ����ݶ��������У�������in.readLine()ʱ���ٴӻ��������ַ��ķ�ʽ��ȡ���ݣ����¼�ơ������ֽڶ�ȡ��ʽ������ 
		  
		//1b. ���ռ��̵�����  
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in));  
		System.out.println( "Enter a line: ");  
		System.out.println(stdin.readLine());  
		// �������Ի����ֽڶ�ȡ��ʽ�ӱ�׼IO�����̣��ж�ȡ���ݣ�����Ҫ�Ȱѱ�׼IO��System.in��ת�����ַ������stream���ٽ���BufferedReader��װ�� 
		  
		//2. ��һ��String�����ж�ȡ����  
		StringReader in2 = new StringReader(s2);  
		int c;  
		while((c = in2.read()) != -1)  
			System.out.println((char)c);  
		in2.close();  
		// Ҫ���ַ�����ʽ��һ��String�����ж�ȡ���ݣ�����Ҫ����һ��StringReader���͵�stream�� 
		
		//3. ���ڴ�ȡ����ʽ������  
		try{  
			DataInputStream in3 =  
			new DataInputStream(  
			new ByteArrayInputStream(s2.getBytes()));  
			while(true)  
			System.out.println((char)in3.readByte());  
		}catch(EOFException e){  
			System.out.println( "End of stream ");  
		}  
		  
		//4. ������ļ�  
		try{  
			BufferedReader in4 = new BufferedReader(new StringReader(s2));  
			PrintWriter out1 = new PrintWriter(
					new BufferedWriter(
							new FileWriter( dir)));  
			int lineCount = 1;  
			while((s = in4.readLine()) != null)  
				out1.println(lineCount++ + ":" + s);  
			out1.close();  
			in4.close();  
		}catch(EOFException ex){  
			System.out.println( "End of stream ");  
		}  
		// ��String����s2��ȡ����ʱ���ȰѶ����е����ݴ��뻺���У��ٴӻ����н��ж�ȡ����TestIO.out�ļ����в���ʱ���ȰѸ�ʽ�������Ϣ����������У��ٰѻ����е���Ϣ������ļ��С� 
		  
		//5. ���ݵĴ洢�ͻָ�  
		try{  
			DataOutputStream out2 = new DataOutputStream(  
					new BufferedOutputStream(  
							new FileOutputStream(dir)));  
			out2.writeDouble(3.1415926);  
			out2.writeChars( "Thas was pi:writeChars\n");  
			out2.writeBytes( "Thas was pi:writeByte\n");  
			out2.close();  
			DataInputStream in5 =  
					new DataInputStream(  
							new BufferedInputStream(  
									new FileInputStream( dir)));  
			BufferedReader in5br =  
					new BufferedReader(  
							new InputStreamReader(in5));  
			System.out.println(in5.readDouble());  
			System.out.println(in5br.readLine());  
			System.out.println(in5br.readLine());  
		}catch(EOFException e){  
			System.out.println( "End of stream ");  
		}  
		// ��Data.txt�ļ��������ʱ�����Ȱѻ������͵���������ݻ����У��ٰѻ����е�����������ļ��У����ļ����ж�ȡ����ʱ���Ȱ��ļ��е����ݶ�ȡ�������У��ٴӻ������Ի������͵���ʽ���ж�ȡ��ע��in5.readDouble()��һ�С���Ϊд���һ��writeDouble()������Ϊ����ȷ��ʾ��ҲҪ�Ի������͵���ʽ���ж�ȡ��  
		  
		//6. ͨ��RandomAccessFile�����ļ�  
		RandomAccessFile rf =  
				new RandomAccessFile( dir, "rw");  
		for(int i=0; i <10; i++)  
			rf.writeDouble(i*1.414);  
		rf.close();  
		  
		rf = new RandomAccessFile( dir, "r");  
		for(int i=0; i <10; i++)  
			System.out.println( "Value " + i + "�� " + rf.readDouble());  
		rf.close();  
		  
		rf = new RandomAccessFile( dir, "rw");  
		rf.seek(5*8);  
		rf.writeDouble(47.0001);  
		rf.close();  
		  
		rf = new RandomAccessFile( dir, "r");  
		for(int i=0; i <10; i++)  
			System.out.println( "Value " + i + "�� " + rf.readDouble());  
		rf.close();  
	}  
}  