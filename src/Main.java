import adt.Heap.MyHeap;
import adt.Heap.MyHeapIMPL;
import adt.arbolbinario.Arbolbinario;
import adt.linkedlist.*;


public class Main {
    public static void main(String[] args) {
        Arbolbinario<Integer, Integer> oTree = new Arbolbinario<>();

        oTree.add(3, 3);
        oTree.add(21, 21);
        oTree.add(11, 11);
        oTree.add(-1, -1);
        oTree.add(4, 4);
        oTree.add(18, 18);


        MyList<Integer> ls = oTree.postOrder();
        for(int i = 0; i<ls.size(); i++){
            System.out.println(ls.get(i));
        }
    }
}