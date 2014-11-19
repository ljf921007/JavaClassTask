package ArrayList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ArrayList {
	public static void main(String[] args){
		try {
			BufferedReader in1 =  new BufferedReader(
					new FileReader("F:\\test\\1.txt"));
			BufferedReader in2 =  new BufferedReader(
					new FileReader("F:\\test\\1.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
