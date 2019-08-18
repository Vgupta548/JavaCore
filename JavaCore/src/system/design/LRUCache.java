package system.design;

import java.util.HashMap;

public class LRUCache {
	Node head;
	Node tail;
	HashMap<Integer, Node> map = null;
	int cap = 0;
	
	public LRUCache(int capacity) {
		this.cap = capacity;
		this.map = new HashMap<Integer, Node>();
	}
	
	public int get(int key) {
		if(map.get(key) == null) {
			return -1;
		}
		
		Node node = map.get(key);
	
		//remove this node from list
		removeNode(node);
		
		//and add node to tail
		offerNode(node);
		
		return node.value;
	}
	
	public void put(int key, int value) {
		//if already exist then update the value and move in the last
		//cache hit
		if(map.containsKey(key)) {
			Node exisitngNode = map.get(key);
			exisitngNode.value = value;
			
			removeNode(exisitngNode);
			offerNode(exisitngNode);
		}else {
		//cache miss
			//otherwise 
			//if id size crossed then remove head
			if(map.size()>= cap) {
				map.remove(head.key);
				removeNode(head);
			}
			
			//add to tail
			Node node = new Node(key,value);
			offerNode(node);
			map.put(key, node);
		}
		
	}
	
	private void offerNode(Node node) {
		if(tail !=null) {
			tail.next = node;
		}
		
		node.prev = tail;
		node.next = null;
		tail = node;
		
		if(head == null) {
			head = tail;
		}
		
	}
	
	private void removeNode(Node node) {
		
		if(node.next != null) {
			node.next.prev = node.prev;
		}else {
			//remove tail node
			tail = node.prev;
		}
		
		if(node.prev != null) {
			node.prev.next = node.next;
		}else {
			//remove head node
			head = node.next;
		}
	}
	
	
	

}


class Node{
	int key;
	int value;
	Node prev;
	Node next;
	
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}