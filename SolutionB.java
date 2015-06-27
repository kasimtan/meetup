

public class SolutionB {
	
	public static Node rleEncodeList(Node head) {
		Node pointer = head;
		Node newHead = null;
		Node node = null;
		if (head != null) {
			node = new Node(head.value);
		}
		int count = 1;
		while (pointer.next != null) {
			if (pointer.next.value.equals(pointer.value)) {
				count++;
			}
			else {
				if (count > 1) {
					Node temp = new Node(count+"$"+pointer.value);
					node.addNext(temp);
					node = temp;
				}
				else {
					Node temp = new Node(pointer.value);
					node.addNext(temp);
					node = temp;
				}
				count = 1;
				if (newHead == null) {
					newHead = node;
				}
			}
			pointer = pointer.next;
		}
		if (count > 1) {
			Node temp = new Node(count+"$"+pointer.value);
			node.addNext(temp);
			node = temp;
		}
		else {
			Node temp = new Node(pointer.value);
			node.addNext(temp);
			node = temp;
			count = 1;
		}
		if (newHead == null) {
			newHead = node;
		}
		return newHead;
	}
	
	public static Node rleDecodeList(Node head) {
		Node node = null;
		return node;
	}

	public static void deleteFromRLEList(char key, Node list) {
		if (list != null) {
			// check the head node
			if (list.value.indexOf(key) == -1) {
				int index = list.value.indexOf("$");
				if (index == -1) {
					list = list.next;
					return;
				}
				else {
					int count = Integer.parseInt(list.value.substring(0,index));
					if (count == 2) {
						list.value = list.value.substring(index+1);
					}
					else {
						count--;
						list.value = count+list.value.substring(index);
					}
				}
			}
			// check the rest nodes
			/*while (list.next != null) {
				if (list.value
			}*/
		}
	}
	
	public static void main(String[] args) {
		Node head = SolutionA.createRandomList(2, 'A', 'B');
		SolutionA.printLinkedList(head);
		Node encodedList = rleEncodeList(head);
		SolutionA.printLinkedList(encodedList);
		//SolutionA.printLinkedList(rleDecodeList(encodedList));
		deleteFromRLEList('A', encodedList);
		SolutionA.printLinkedList(encodedList);
	}
}
