package ui;

import domain.BinarySearchTree;

public class BinarySearchTreeDriver {

	public static void main(String[] args) {
		BinarySearchTree<Integer> boom = new BinarySearchTree<Integer>(6);
		boom.addNode(4);
		boom.addNode(8);
		boom.addNode(3);
		boom.addNode(5);
		boom.addNode(7);
		boom.addNode(9);

		System.out.println("Lookup: " + boom.lookup(7));

		printBoomInfo(boom);

		
	}

	private static void printBoomInfo(BinarySearchTree<Integer> boom) {
		if (boom == null) System.out.println("Lege boom");
		else {
			System.out.println("Preorder:");
			boom.printPreorder();
			System.out.println("\nInorder:");
			boom.printInorder();
			System.out.println("\nPostorder:");
			boom.printPostorder();

			System.out.println();
			System.out.println("De grootste waarde uit deze boom = " + boom.searchGreatest());
			System.out.println("De kleinste waarde uit deze boom = " + boom.searchSmallest());
		}


	}
}