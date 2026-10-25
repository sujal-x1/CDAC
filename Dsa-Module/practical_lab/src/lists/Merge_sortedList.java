package lists;

import java.util.LinkedList;

public class Merge_sortedList{
	public static LinkedList<Long> merge(LinkedList<Long>l1,LinkedList<Long>l2){
		
		LinkedList<Long>res = new LinkedList<>();
		int i=0;
		int j=0;
		while(i<l1.size()&&j<l2.size()) {
			if(l1.get(i)<l2.get(j)) {
				res.add(l1.get(i));
				i++;
			}
			else {
				res.add(l2.get(j));j++;
			}
		}
		while(i<l1.size()) {
			res.add(l1.get(i));
			i++;
		}
		
		while(j<l2.size()) {
			res.add(l2.get(j));
			j++;
		}
		
		return res;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList <Long>l1 = new LinkedList<>();
		l1.add(4l);
		l1.add(5l);
		l1.add(8l);
		l1.add(16l);
		
		LinkedList <Long>l2= new LinkedList<>();
		l2.add(1l);
		l2.add(2l);
		l2.add(7l);
		l2.add(9l);
		
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(merge(l1,l2));
		
	}

}
