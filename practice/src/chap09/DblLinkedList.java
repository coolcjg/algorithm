package chap09;

public class DblLinkedList<E> {
	
	//노드
	class Node<E> {
		private E data;			//테이터
		private Node<E> prev;	//앞쪽 포인터
		private Node<E> next;	//뒤쪽 포인터
		
		Node(){
			data = null;
			prev = next = this;
		}
		
		Node(E obj, Node<E> prev, Node<E> next){
			data = obj;
			this.prev = prev;
			this.next = next;
		}
	}
	
	
	private Node<E> head;
	
	private Node<E> crnt;
	
	//생성자
	public DblLinkedList() {
		head = crnt = new Node<E>();
	}
	
	public boolean isEmpty() {
		return head.next == head;
	}

}
