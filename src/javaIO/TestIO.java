package javaIO;

import java.io.*;  
public class TestIO{  
	public static void main(String[] args)  
			throws IOException{  
  
		File path=new File("F:/test");
		File dir=new File(path,"hello.txt");
		if(!dir.exists())
		dir.createNewFile(); 
		
		//1.以行为单位从一个文件读取数据  
		BufferedReader in =  new BufferedReader(
				new FileReader(dir));  
		String s, s2 = new String();  
		while((s = in.readLine()) != null)  
			s2 += s + "\n ";  
		in.close();  
		// 当读取文件时，先把文件内容读到缓存中，当调用in.readLine()时，再从缓存中以字符的方式读取数据（以下简称“缓存字节读取方式”）。 
		  
		//1b. 接收键盘的输入  
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in));  
		System.out.println( "Enter a line: ");  
		System.out.println(stdin.readLine());  
		// 由于想以缓存字节读取方式从标准IO（键盘）中读取数据，所以要先把标准IO（System.in）转换成字符导向的stream，再进行BufferedReader封装。 
		  
		//2. 从一个String对象中读取数据  
		StringReader in2 = new StringReader(s2);  
		int c;  
		while((c = in2.read()) != -1)  
			System.out.println((char)c);  
		in2.close();  
		// 要以字符的形式从一个String对象中读取数据，所以要产生一个StringReader类型的stream。 
		
		//3. 从内存取出格式化输入  
		try{  
			DataInputStream in3 =  
			new DataInputStream(  
			new ByteArrayInputStream(s2.getBytes()));  
			while(true)  
			System.out.println((char)in3.readByte());  
		}catch(EOFException e){  
			System.out.println( "End of stream ");  
		}  
		  
		//4. 输出到文件  
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
		// 对String对象s2读取数据时，先把对象中的数据存入缓存中，再从缓冲中进行读取；对TestIO.out文件进行操作时，先把格式化后的信息输出到缓存中，再把缓存中的信息输出到文件中。 
		  
		//5. 数据的存储和恢复  
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
		// 对Data.txt文件进行输出时，是先把基本类型的数据输出屋缓存中，再把缓存中的数据输出到文件中；对文件进行读取操作时，先把文件中的数据读取到缓存中，再从缓存中以基本类型的形式进行读取。注意in5.readDouble()这一行。因为写入第一个writeDouble()，所以为了正确显示。也要以基本类型的形式进行读取。  
		  
		//6. 通过RandomAccessFile操作文件  
		RandomAccessFile rf =  
				new RandomAccessFile( dir, "rw");  
		for(int i=0; i <10; i++)  
			rf.writeDouble(i*1.414);  
		rf.close();  
		  
		rf = new RandomAccessFile( dir, "r");  
		for(int i=0; i <10; i++)  
			System.out.println( "Value " + i + "： " + rf.readDouble());  
		rf.close();  
		  
		rf = new RandomAccessFile( dir, "rw");  
		rf.seek(5*8);  
		rf.writeDouble(47.0001);  
		rf.close();  
		  
		rf = new RandomAccessFile( dir, "r");  
		for(int i=0; i <10; i++)  
			System.out.println( "Value " + i + "： " + rf.readDouble());  
		rf.close();  
	}  
}  