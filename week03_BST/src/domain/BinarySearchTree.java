package domain;

/*
Update the BinaryTree class in the domain folder with the BinaryTree of week 02
* */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}
			
	public BinarySearchTree(E data) {
		super(data);
	}

	public boolean lookup(E data) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public boolean addNode(E data) {
		if(this.data == null && this.leftTree == null && this.rightTree == null){
			this.data = data;
			return true;
		}
		else{
			if(data.compareTo(this.data) == 0){
				return false;
			}
			else{
				if(data.compareTo(this.data) < 0){
					if(this.leftTree == null){
						this.leftTree = new BinarySearchTree<>(data,null,null);
						return true;
					}
					else{
						return this.leftTree.addNode(data);
					}
				}
				else{
					if(this.rightTree == null){
						this.rightTree = new BinarySearchTree<>(data,null,null);
						return true;
					}
					else{
						return this.rightTree.addNode(data);
					}
				}
			}
		}
	}

	public boolean removeNode(E data){
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public E searchSmallest(){
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public E searchGreatest(){
		throw new UnsupportedOperationException("Not yet implemented");
	}
}


