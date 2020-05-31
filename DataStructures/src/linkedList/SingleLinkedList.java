package linkedList;

class Node{
	int value;
	Node next;
	
	Node(){
		this.value = -1;
		this.next = null;
	}
	
	Node (int value){
		this.value = value;
		this.next = null;
	}
}




public class SingleLinkedList {
	
	Node start;
	
	public void insert (int value) {
		Node newNode = start;
		while (newNode.next != null) {
			newNode = newNode.next;
		}
		Node insrt = new Node(value);
		newNode.next = insrt;
		insrt.next = null;
	}
	
	public void print() {
		Node newNode = start;
		while (newNode != null) {
			System.out.print(newNode.value+" --> ");
			newNode = newNode.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	public void removeFromLast() {
		Node firstNode = start.next;
		Node secondNode = start;
		while (firstNode.next != null) {
			secondNode = firstNode;
			firstNode = firstNode.next;
		}
		secondNode.next = null;
	}
	
	public void removeFromFirst() {
		Node secondNode = start.next;
		start.next = null;
		start = secondNode;	
	}
	
	public void deleteByValue(int value) {
		Node firstNode = start.next;
		Node secondNode = start;
		while(secondNode.value == value) {
			removeFromFirst();
			firstNode = start.next;
			secondNode = start;
		}			
		
		while (firstNode != null) {
			if((firstNode.value == value)) {
				secondNode.next = firstNode.next;
				firstNode.next = null;
			}			
			firstNode = secondNode.next;	
		}
	}
	
	
	public static void main(String[] args) {
		
		SingleLinkedList linkedlist = new SingleLinkedList();
		
		linkedlist.start = new Node(5);
		linkedlist.insert(5);
		linkedlist.insert(8);
		linkedlist.insert(10);
		linkedlist.insert(2);
		linkedlist.insert(7);
		linkedlist.insert(300);
		linkedlist.insert(5);
		linkedlist.insert(18);
		linkedlist.insert(25);
		linkedlist.insert(5);
		linkedlist.print();
		linkedlist.deleteByValue(300);
		linkedlist.print();

	}

	
	
	
	
}
	
	
	
	
	


