package ui;

import domain.BinarySearchTree;
import domain.BinaryTree;

public class Week04Testing {
    public static void main(String[] args){
        BinarySearchTree<Integer> boom = new BinarySearchTree<Integer>(6);
        boom.addNode(4);
        boom.addNode(8);
        boom.addNode(3);
        boom.addNode(5);
        boom.addNode(7);
        boom.addNode(9);

        //System.out.println(boom.count(9));


        BinaryTree<String> nodeE = new BinaryTree<>("E");
        BinaryTree<String> nodeC = new BinaryTree<>("C",null,nodeE);
        BinaryTree<String> nodeH = new BinaryTree<>("H",nodeC,nodeE);
        BinaryTree<String> nodeA = new BinaryTree<>("A");
        BinaryTree<String> nodeHtop = new BinaryTree<>("H",nodeA,nodeH);
        BinaryTree<String> nodeHRight = new BinaryTree<>("H",null,nodeE);
        BinaryTree<String> nodeI = new BinaryTree<>("I",nodeHRight,nodeE);
        BinaryTree<String> nodeG = new BinaryTree<>("G",null,nodeI);
        BinaryTree<String> boom2 = new BinaryTree<>("A",nodeHtop,nodeG);

        /*System.out.println(boom2.count("I"));
        System.out.println(boom2.count("A"));
        System.out.println(boom2.count("H"));
        System.out.println(boom2.count("E"));
        System.out.println(boom2.count("Q"));*/

        System.out.println(boom2.getNodesAtDistance(2));
    }
}
