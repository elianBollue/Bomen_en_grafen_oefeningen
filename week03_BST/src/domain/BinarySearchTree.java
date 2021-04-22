package domain;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}
			
	public BinarySearchTree(E data) {
		super(data);
	}

	@Override
	public boolean lookup(E data) {
		if(data == null) {
			return false;
		}
		if(data.compareTo(this.data) == 0) {
			return true;
		} else {
			if(data.compareTo(this.data) < 0) {
				return this.leftTree != null && this.leftTree.lookup(data);
			} else {
				return this.rightTree != null && this.rightTree.lookup(data);
			}
		}
	}

	@Override
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

	@Override
	public E searchSmallest(){
		if(this.leftTree == null){
			return this.data;
		}
		else{
			return this.leftTree.searchSmallest();
		}
	}

	@Override
	public E searchGreatest(){
		if(this.rightTree == null){
			return this.data;
		}
		else{
			return this.rightTree.searchGreatest();
		}
	}
}


