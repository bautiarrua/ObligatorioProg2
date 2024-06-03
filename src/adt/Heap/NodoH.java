package adt.Heap;

public class NodoH<V,K extends Comparable<K>> {
    K key;
    V value;

    public NodoH(V value, K key) {
        this.key = key;
        this.value = value;
    }


    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
