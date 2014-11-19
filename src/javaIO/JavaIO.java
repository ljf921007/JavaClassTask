package javaIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaIO {

	public static void testFile(String filename) throws IOException{
		try{      
            FileInputStream rf=new  FileInputStream(filename);  
            int n=512;   
            byte  buffer[]=new byte[n];     
            while((rf.read(buffer,0,n)!=-1)&&(n>0)){  
                System.out.println(new String(buffer) );  
             }  
             System.out.println();  
             rf.close();  
	     } catch(IOException  IOe){        
	           System.out.println(IOe.toString());  
	     }  
	}
	
	public static void testStream(){
		String path = "C:\\my.txt";
		  InputStreamReader isr = new InputStreamReader(System.in);// 键盘输入
		  BufferedReader   input   =   new   BufferedReader(isr); 
		  System.out.println("请输入姓名，计算机成绩，JAVA成绩，每项以两个空格分开：");
		 // String text = input.readLine();
		  
	}
	
	public static void main(String args[]){
		//File类操作
		try {
			testFile("InputFromFile.java");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//字节流操作
		
	}	
}
