

public class SolutionA {
	
	public static void printLinkedList(Node head) {
		if (head != null) {
			System.out.print(head.value);
			while (head.next != null) {
				head = head.next;
				System.out.print("->"+head.value);
			}
			System.out.println();
		}
	}
	
	public static Node createRandomList(int numNodes, char minLetter, char maxLetter) {
		Node head = null;
		Node node = null;
		int range = (maxLetter - minLetter) + 1;
		for (int i = 0; i < numNodes; i++) {
			char c = (char)((int)(Math.random() * range) + minLetter);
			if (i == 0) {
				head = new Node(String.valueOf(c));
				node = head;
			}
			else {
				Node temp = new Node(String.valueOf(c));
				node.addNext(temp);
				node = temp;
			}
		}
		return head;
	}
	
	public static Node createPalindromeList(int numNodes, char minLetter, char maxLetter) {
		Node head = null;
		Node node = null;
		Node backNode = null;
		int range = (maxLetter - minLetter) + 1;
		int i = 0;
		for (i = 0; i < Math.round(numNodes / 2.0); i++) {
			char c = (char)((int)(Math.random() * range) + minLetter);
			if (i == 0) {
				head = new Node(String.valueOf(c));
				node = head;
			}
			else {
				Node temp = new Node(String.valueOf(c));
				node.addNext(temp);
				node = temp;
			}
		}
		if (numNodes % 2 == 0) {
			backNode = node;
		}
		else {
			backNode = node.prev;
		}
		while (backNode.prev != null) {
			Node temp = new Node(backNode.value);
			node.addNext(temp);
			node = temp;
			backNode = backNode.prev;
		}
		node.addNext(new Node(head.value));
		return head;
	}
	
	public static void main(String[] args) {
		/*Node head = new Node("Apple");
		head.addNext(new Node("Ball"));
		printLinkedList(head);*/
		//printLinkedList(createRandomList(2,'B','C'));
		printLinkedList(createPalindromeList(5,'F','R'));
	}
}

class Node {
	String value;
	Node next;
	Node prev;

	Node(String value) {
		this.value = value;
	}
	
	public void addNext(Node next) {
		this.next = next;
		next.prev = this;
	}
}