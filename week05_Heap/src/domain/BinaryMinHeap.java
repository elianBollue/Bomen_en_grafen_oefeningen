package domain;

import java.util.ArrayList;

public class BinaryMinHeap<E extends Comparable<E>> {
    private ArrayList<E> values;

    private boolean isEmpty() {
        return values == null || values.size() == 0;
    }

    public void print() {
        if (this.isEmpty())
            System.out.println("De heap is leeg");
        else
            System.out.println(values);
    }

    public E getMin() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niet zoeken in een lege heap");
        else{
            return this.values.get(0);
        }
    }

    public boolean addValue(E value) {
        // geen null toevoegen aan de heap
        if (value == null) throw new IllegalArgumentException();
        // indien de heap leeg is: eerst initialiseren
        if (this.isEmpty())
            values = new ArrayList<E>();

        values.add(value);//achteraan toevoegen
        this.bubbleUp();//bubbleUp vanaf de laatste zie slides theorie
        return true;
    }

    private void bubbleUp() {
        int index = this.values.size() - 1;
        while(index >= 1){
            if(this.values.get(parent(index)).compareTo(this.values.get(index)) > 0){
                switchValues(index,parent(index));
            }
            index = parent(index);
        }
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    private int parent(int index){
        return (index - 1)/2;
    }

    private void switchValues(int x, int y){
        E saved = this.values.get(x);
        this.values.set(x,this.values.get(y));
        this.values.set(y,saved);
    }

    public E removeSmallest() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niets verwijderen uit een lege boom");
        E res = this.getMin();// res bevat de kleinste = eerste element van de lijst
        this.values.set(0, this.values.get(this.values.size() - 1));// verwissel eerste met de laatste
        this.values.remove(this.values.size() - 1); // verwijder de laatste
        this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
        return res;
    }

    private void bubbleDown() {
        boolean inBounds = true;
        int index = 0;
        while(inBounds && hasLeftChild(index)){
            int minChildIndex = leftChild(index);
            if(hasRightChild(index) && this.values.get(rightChild(index)).compareTo(this.values.get(minChildIndex)) < 0){
                minChildIndex = rightChild(index);
            }
            if(this.values.get(index).compareTo(this.values.get(minChildIndex)) > 0){
                switchValues(index,minChildIndex);
            } else {
                inBounds = false;
            }
            index = minChildIndex;
        }
    }

    private boolean hasLeftChild(int index){
        return leftChild(index) < this.values.size();
    }
    private boolean hasRightChild(int index){
        return rightChild(index) < this.values.size();
    }

    public ArrayList<E> getPath(E value) {
        int index = this.values.indexOf(value);
        if(index == -1){
            return null;
        }
        else{
            ArrayList<E> path = new ArrayList<>();
            path.add(value);
            while(index > 0){
                index = parent(index);
                path.add(0, this.values.get(index));
            }
            return path;
        }
    }
}
