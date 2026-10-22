package day4_advanceList_Graphs;

import java.util.LinkedList;

public class Merge_lists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		LinkedList<Integer> mergedList = new LinkedList<>();
		
		for(int i=1;i<=4;i++) {
			list1.add(i);
		}
		for(int i=5;i<=9;i++) {
			list2.add(i);
		}
		
		mergedList.addAll(list1);
		mergedList.addAll(list2);
		System.out.println(mergedList);
	}

}
