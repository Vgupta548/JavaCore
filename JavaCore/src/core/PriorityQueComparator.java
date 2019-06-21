package core;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import system.design.vendingMachine_logic.helper.Pair;

public class PriorityQueComparator {

	public static void main(String[] args) {
		PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>(new Comparator<Pair<Integer, Integer>>() {
			public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
				return p1.v2().compareTo(p2.v2());
			}
		});
		
		pq.add(new Pair<Integer, Integer>(3, 2));
		pq.add(new Pair<Integer, Integer>(1, 4));
		pq.add(new Pair<Integer, Integer>(6, 1));
		pq.add(new Pair<Integer, Integer>(8, 6));
		pq.add(new Pair<Integer, Integer>(5, 5));
		
		Iterator<Pair<Integer, Integer>> it = pq.iterator();
		while(it.hasNext()) {
			Pair<Integer, Integer> p = it.next();
			System.out.println(p.v1() +" -> "+p.v2());
		}
		for(int i=0; i<5; i++) {
			Pair<Integer, Integer> p = pq.poll();
			System.out.println(p.v1() + " -> "+p.v2());
		}
		
		System.out.println("=====");
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(); 
		  
        // Use add() method to add elements into the Queue 
        queue.add(10); 
        queue.add(15); 
        queue.add(30); 
        queue.add(20); 
        queue.add(5); 
  
        // Displaying the PriorityQueue 
        System.out.println("PriorityQueue: " + queue); 
  
        // Creating an iterator 
        Iterator value = queue.iterator(); 
  
        // Displaying the values after iterating through the queue 
        System.out.println("The iterator values are: "); 
        while (value.hasNext()) { 
            System.out.println(value.next()); 
        } 

	}

}
