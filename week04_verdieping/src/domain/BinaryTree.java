package domain;

public class BinaryTree<E> {
	E data;
	BinaryTree<E> leftTree, rightTree;

	public BinaryTree(E data){
		this(data,null,null);
	}

	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data= data;
		this.leftTree= leftTree;
		this.rightTree= rightTree;
	}

	public void printPreorder(){
			System.out.print(this.data + " ");
			if (this.leftTree != null) this.leftTree.printPreorder();
			if (this.rightTree != null) this.rightTree.printPreorder();
	}

	public void printInorder(){
		if(this.leftTree != null){
			this.leftTree.printInorder();
		}
		System.out.print(this.data + " ");
		if(this.rightTree!=null){
			this.rightTree.printInorder();
		}
	}

	public void printPostorder(){
		if(this.leftTree != null){
			this.leftTree.printPostorder();
		}
		if(this.rightTree != null){
			this.rightTree.printPostorder();
		}
		System.out.print(this.data + " ");
	}

	public int countNodes(){
		int teller = 1;
		if(this.leftTree != null){
			teller += this.leftTree.countNodes();
		}
		if(this.rightTree != null){
			teller += this.rightTree.countNodes();
		}
		return teller;
	}

	public int getDepth(){
		int tellerLinks = 0;
		int tellerRechts = 0;
		int totaal = 1;
		if(this.leftTree != null){
			tellerLinks += this.leftTree.getDepth();
		}
		if(this.rightTree != null){
			tellerRechts += this.rightTree.getDepth();
		}
		totaal += Math.max(tellerLinks,tellerRechts);
		return totaal;
	}

	public boolean isLeaf(){
		return this.leftTree == null && this.rightTree == null;
	}

	public int countLeaves() {
		int teller = 0;
		if (this.isLeaf()) {
			return 1;
		} else {
			if (this.leftTree != null) {
				teller += this.leftTree.countLeaves();
			}
			if (this.rightTree != null) {
				teller += this.rightTree.countLeaves();
			}
		}
		return teller;
	}

	public void getDataLeaves(){
		if(this.isLeaf()){
			System.out.print(this.data + " ");
		}
		if (this.leftTree != null) {
			this.leftTree.getDataLeaves();
		}
		if (this.rightTree != null) {
			this.rightTree.getDataLeaves();
		}
	}

	public boolean lookup(E s){
		if(s == null){
			return false;
		}
		if(s.equals(this.data)){
			return true;
		}
		else {
			return (this.leftTree != null && this.leftTree.lookup(s)) ||
					(this.rightTree != null && this.rightTree.lookup(s));
		}
	}

	public int count(E data){
		if(data == null){
			return 0;
		}
		else{
			return (data.equals(this.data) ? 1 : 0) + (this.leftTree == null ? 0 : this.leftTree.count(data))
					+ (this.rightTree == null ? 0 : this.rightTree.count(data));
		}
	}

	public boolean addNode(E data) {
		throw new UnsupportedOperationException("Fake method");
	}

	public E searchGreatest(){
		throw new UnsupportedOperationException("Fake method");
	}

	public E searchSmallest(){
		throw new UnsupportedOperationException("Fake method");
	}
}