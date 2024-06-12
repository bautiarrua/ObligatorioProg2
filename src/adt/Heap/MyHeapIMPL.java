package adt.Heap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MyHeapIMPL<V,K extends Comparable<K>> implements  MyHeap<V,K>{
    int size;
    PriorityQueue<NodoH<V, K>> heap;

    public MyHeapIMPL() {
        this.heap = new PriorityQueue<>(Comparator.comparing(NodoH<V,K>::getKey));
    }

    @Override
    public V delete() {
        NodoH<V, K> node = heap.poll();
        return (node != null) ? node.getValue() : null;
    }

    @Override
    public V get() {
        NodoH<V, K> node = heap.peek();
        return (node != null) ? node.getValue() : null;
    }

    @Override
    public void insert(V value, K key) {
        NodoH<V,K> temp = new NodoH<V, K>(value, key);
        heap.add(temp);

    }

    @Override
    public int size() {
        return heap.size();
    }
    public MyHeap<V, K> clonar() {
        MyHeap<V, K> clonedHeap = new MyHeapIMPL<>();
        for (NodoH<V, K> node : this.heap) {
            clonedHeap.insert(node.value, node.key);
        }
        return clonedHeap;
    }
}
