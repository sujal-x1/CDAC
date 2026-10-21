package day2_infix_Queues;

import java.util.Scanner;

public class Queue_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue_Class queue = new Queue_Class();
		queue.create_queue(5);
		
		Scanner scanner = new Scanner(System.in);
		
		int c = 0;
		
		do {
			
			System.out.println("\n----------Menu----------");
			System.out.println("1.Enqueue\n2.Dequeue\n3.PrintQueue");
			System.out.print("Enter Choice: ");
			
			c = scanner.nextInt();
			
			switch (c) {
			
			case 1: System.out.print("Enter element to enqueue: ");
			 		int el = scanner.nextInt();
			 		if(queue.isFull()) {
			 			System.out.println("Queue is full");
			 			break;
			 		}
			 		queue.enqueue(el);
			 		break;
			
			 case 2: if(queue.isEmpty()) {
				 	System.out.println("Queue is empty");
				 	break;
			 		}
			 		queue.dequeue();
			 		break;
			 		
			 case 3 : queue.printQueue();
			 		break;
			 		
			 default: System.out.println("Enter valid choice");
			 		break;
			}
				
			
			
			
		}while(c!=0);
		
	}

}
