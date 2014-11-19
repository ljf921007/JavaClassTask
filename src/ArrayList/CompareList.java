package ArrayList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class CompareList {
	//��txt�еĵ��ʶ�ȡ��list��
	public static ArrayList fileToList(String path) throws IOException{
		BufferedReader in1 =  new BufferedReader(
				new FileReader(path));
		ArrayList list = new ArrayList();
		String s = "";
		String data = in1.readLine();//һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
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
		    data = in1.readLine(); //���Ŷ���һ��  
		}
		//printList(list);
		return list;
	}
	//ʹ��ð�ݷ���list��������
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
	
	//ɾ��list�е��ظ�����
	public static void deleteDuplication(List list){
		for(int i = 0;i < list.size()-1;i++){
			if(list.get(i).equals(list.get(i+1))){
				list.remove(i);
				i--;
			}
		}
		printList(list);
	}
	
	//��������list�е��ص�����
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
		System.out.println("�ص����ʸ����ڵ�һ���ļ��ʻ������ռ�İٷֱȣ�"+ commonList.size() * 100.0 / list1.size() + "%"); 
		System.out.println("�ص����ʸ����ڵڶ����ļ��ʻ������ռ�İٷֱȣ�"+ commonList.size() * 100.0 / list2.size() + "%"); 
		return commonList;
	}
	//���list�еĵ���
	public static void printList(List list){
		Iterator iterator = list.iterator();
		System.out.print("[���ʸ���:"+list.size()+"]");
		while (iterator.hasNext()) 
		{
			Object element = iterator.next();
			System.out.print(" " + element);
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException{
		
		//�����ʶ�ȡ��list��
		//System.out.println("List1:"); 
		ArrayList list1 = fileToList("src\\ArrayList\\1.txt");
		 
		//System.out.println("List2:"); 
		ArrayList list2 = fileToList("src\\ArrayList\\2.txt");
		
		//ʹ��ð�ݷ���list����
		System.out.println("��List1����"); 
		sortList(list1);
		
		System.out.println("��List2����"); 
		sortList(list2);
		
		//ɾ��list�е��ظ�����
		System.out.println("List1�еĵ��ʣ����ظ�����"); 
		deleteDuplication(list1);
		
		System.out.println("List2�еĵ��ʣ����ظ�����"); 
		deleteDuplication(list2);
		
		//��������list�е���ͬ����
		System.out.println("����list���ص����ʣ�"); 
		ArrayList commonList = commonList(list1,list2);

	}
}
