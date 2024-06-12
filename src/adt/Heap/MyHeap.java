package adt.Heap;

public interface MyHeap<V,K extends Comparable<K>>{

    V delete();
    V get();
    void insert(V value, K key);
    int size();

    MyHeap<V,K> clonar();
}
