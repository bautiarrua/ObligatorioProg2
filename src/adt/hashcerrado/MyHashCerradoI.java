package adt.hashcerrado;

import adt.Exceptions.NoEsta;
import adt.Exceptions.YaExiste;
import adt.linkedlist.MyLinkedListImpl;

public interface MyHashCerradoI<K, V> {

    void put(K key, V value) throws YaExiste;

    V get(K key) throws NoEsta;

    Boolean contains(K key);

    void remove (K key) throws NoEsta;

    MyLinkedListImpl<K> Keys();

    MyLinkedListImpl<V> Values();

    float size();
    int capacity();
    int indice(K key) throws NoEsta;

    void rehash(int indice);
    void resize();

}