package binaryTree;


public class BTree<V extends Comparable<V>>  {
	Node<V> root;
	
	private class Node<V>{
		V value;
		int depth;
		Node<V> right,left;
		
		public Node(V value) {
			this.value = value;
			this.depth = 0;
			this.right = null;
			this.left = null;
		}
	}
	
	public BTree() {
		this.root = null;
	}
	
	public void put(V value) {
		root = put(root,value);
	}
	
	private Node<V> put(Node<V> node, V value){
		if(node==null)	return new Node<V>(value);
		
		int cmp = value.compareTo(node.value);
		if(cmp<0)
			node.left = put(node.left,value);
		else if (cmp>0)
			node.right = put(node.right,value);
		
		return node;	
	}
	
	public int size() {
		return treeSize(root);
	}
	
	private int treeSize(Node<V> node) {
		if(node==null)	return 0;
		
		return 1+ treeSize(node.left)+treeSize(node.right); 
	}
	
	public int height() {
		return treeHeight(root);
	}
	
	private int treeHeight(Node<V> node) {
		if(node==null) return 0;
		
		int leftH = 1+treeHeight(node.left);
		int rightH = 1+treeHeight(node.right);
		
		if(leftH<rightH)
			return rightH;
		return leftH;
		
	}
	
	public void setDepthField() {
		setDepthField(root,0);
	}
	
	private void setDepthField(Node<V> node, int depth) {
		if(node==null) return;
		
		node.depth=depth;
		setDepthField(node.left, depth+1);
		setDepthField(node.right, depth+1);
	}
	
	public int internalPathLength() {
		return internalPathLength(root);
	}
	
	private int internalPathLength(Node<V> node) {
		if(node==null) return 0;
		
		return node.depth+internalPathLength(node.left)+internalPathLength(node.right);
	}
	
	public String InOrder() {
		return InOrder(root);
	}
	
	private String InOrder(Node<V> node) {
		if(node==null)	return "";
		
		return InOrder(node.left)+" "+node.value+" "+InOrder(node.right);
	}
	
	public String PreOrder() {
		return PreOrder(root);
	}
	
	private String PreOrder(Node<V> node) {
		if(node==null)	return "";
		
		return node.value+" "+PreOrder(node.left)+" "+PreOrder(node.right);
	}
	
	public String PostOrder() {
		return PostOrder(root);
	}
	
	private String PostOrder(Node<V> node) {
		if(node==null)	return "";
		
		return PostOrder(node.left)+" "+PostOrder(node.right)+" "+node.value;		
	}
	
}
