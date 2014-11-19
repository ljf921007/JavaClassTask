package ArrayList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class CompareList {
	//将txt中的单词读取到list中
	public static ArrayList fileToList(String path) throws IOException{
		BufferedReader in1 =  new BufferedReader(
				new FileReader(path));
		ArrayList list = new ArrayList();
		String s = "";
		String data = in1.readLine();//一次读入一行，直到读入null为文件结束  
		while( data!=null){  
		    //System.out.println(data);  
		    for(int i = 0;i<data.length();i++){
		    	if(data.charAt(i)==' '){
		    		 list.add(s);
		    		 s = "";
		    	}else if((i+1) == data.length()){
		    		 s += data.charAt(i);
		    		 list.add(s);
		    		 s = "";
		    	}else{
		    		s += data.charAt(i);
		    	}
		    }
		    data = in1.readLine(); //接着读下一行  
		}
		//printList(list);
		return list;
	}
	//使用冒泡法对list进行排序
	public static void sortList(ArrayList list){
		String up ="";
		String down = "";
		for(int i = 0;i < list.size();i++){
			for(int j = 0;j < list.size();j++){
				up = (String)list.get(i);
				down = (String)list.get(j);
				if(up.compareTo(down)<0){
					list.set(i, down);
					list.set(j, up);
				}
			}
		}
		printList(list);
	}
	
	//删除list中的重复单词
	public static void deleteDuplication(List list){
		for(int i = 0;i < list.size()-1;i++){
			if(list.get(i).equals(list.get(i+1))){
				list.remove(i);
				i--;
			}
		}
		printList(list);
	}
	
	//计算两个list中的重叠单词
	public static ArrayList commonList(ArrayList list1,ArrayList list2){
		ArrayList commonList = new ArrayList();
		int i = 0;
		int j = 0;
		while(i<list1.size()&&j<list2.size()){
			String m = (String)list1.get(i);
			String n = (String)list2.get(j);
			if(m.compareToIgnoreCase(n)==0){
				commonList.add(m);
				i++;
				j++;
			}else if(m.compareToIgnoreCase(n)<0){
				i++;
			}else{
				j++;
			}
		}
		printList(commonList);
		System.out.println("重叠单词个数在第一个文件词汇表中所占的百分比："+ commonList.size() * 100.0 / list1.size() + "%"); 
		System.out.println("重叠单词个数在第二个文件词汇表中所占的百分比："+ commonList.size() * 100.0 / list2.size() + "%"); 
		return commonList;
	}
	//输出list中的单词
	public static void printList(List list){
		Iterator iterator = list.iterator();
		System.out.print("[单词个数:"+list.size()+"]");
		while (iterator.hasNext()) 
		{
			Object element = iterator.next();
			System.out.print(" " + element);
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException{
		
		//将单词读取到list中
		//System.out.println("List1:"); 
		ArrayList list1 = fileToList("src\\ArrayList\\1.txt");
		 
		//System.out.println("List2:"); 
		ArrayList list2 = fileToList("src\\ArrayList\\2.txt");
		
		//使用冒泡法将list排序
		System.out.println("对List1排序："); 
		sortList(list1);
		
		System.out.println("对List2排序："); 
		sortList(list2);
		
		//删除list中的重复单词
		System.out.println("List1中的单词（无重复）："); 
		deleteDuplication(list1);
		
		System.out.println("List2中的单词（无重复）："); 
		deleteDuplication(list2);
		
		//计算两个list中的相同单词
		System.out.println("两个list的重叠单词："); 
		ArrayList commonList = commonList(list1,list2);

	}
}
