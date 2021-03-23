package chap10;

import java.util.Comparator;

public class BinTree<K,V> {
	
	//노드
	static class Node<K, V>{
		private K key;
		private V data;
		private Node<K,V> left;
		private Node<K,V> right;
		
		//생성자
		Node(K key, V data, Node<K,V> left, Node<K,V> right){
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		//키 값을 반환
		K getKey() {
			return key;
		}
		
		//데이터를 반환
		V getValue() {
			return data;
		}
		
		//데이터를 출력
		void print() {
			System.out.println(data);
		}
		
		
	}
	
	private Node<K,V> root; //루트
	private Comparator<? super K> comparator = null; //비교자
	
	
	
	public BinTree() {
		root = null;
	}
	
	public BinTree(Comparator<? super K> c) {
		this();
		comparator = c;
	}
	
	private int comp(K key1, K key2) {
		return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1, key2);
	}
	
	public V search(K key) {
		Node<K,V> p = root;
		
		while(true) {
			if(p == null)
				return null;
			
			int cond = comp(key, p.getKey());
			if(cond == 0)
				return p.getValue();
			else if (cond< 0)
				p = p.left;
			else
				p= p.right;
		}
	}
	
	
	//node를 루트로 하는 서브트리에 노드<K,V>를 삽입
	private void addNode(Node<K, V> node, K key, V data) {
		
		int cond = comp(key, node.getKey());
		if(cond == 0)
			return;
		else if(cond<0) {
			if(node.left == null)
				node.left = new Node<K,V>(key, data, null, null);
			else
				addNode(node.left, key, data);
		}else {
			if(node.right == null)
				node.right = new Node<K,V>(key, data, null, null);
			else
				addNode(node.right, key, data);
		}
	}
	
	//노드를 삽입
	public void add(K key, V data) {
		if(root == null)
			root = new Node<K,V>(key, data, null, null);
		else
			addNode(root, key, data);
	}

}
