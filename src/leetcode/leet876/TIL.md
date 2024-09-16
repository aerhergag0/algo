## Singly Linked List

- 노드를 연결하여 리스트 처럼 만든 컬렉션
- LinkedList의 특징인 삽입,삭제에 빠르고 조회에 느린 성능
- 특히, 단방향 리스트는 리스트의 끝 요소 탐색시, 처음부터 끝까지 순회하며 탐색하기에 성능이 더욱 떨어진다.
- Singly Linked List는 자료 구조 한계상 탐색 성능이 떨어져 현업에서 잘 쓰이지 않는다.
  Java의 LinkedList도 Doubly Linked List로 구현되어 있다.

```JAVA
//node structure
class Node {
	int data;
	Node next;
};

class LinkedList {
	Node head;
	//constructor to create an empty LinkedList
	LinkedList(){
		head = null;
	}
};

// test the code 
public class Implementation {
	public static void main(String[] args) {
		//create an empty LinkedList 
		LinkedList MyList = new LinkedList();

		//Add first node.
		Node first = new Node();
		first.data = 10;
		first.next = null;
		//linking with head node
		MyList.head = first;

		//Add second node.
		Node second = new Node();
		second.data = 20;
		second.next = null;
		//linking with first node
		first.next = second;

		//Add third node.
		Node third = new Node();
		third.data = 30;
		third.next = null;
		//linking with second node
		second.next = third;
	}
}
```