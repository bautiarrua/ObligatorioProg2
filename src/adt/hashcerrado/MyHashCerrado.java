package adt.hashcerrado;

import adt.Exceptions.NoEsta;
import adt.Exceptions.YaExiste;
import adt.linkedlist.MyLinkedListImpl;


public class MyHashCerrado<K,V> implements MyHashCerradoI<K,V> {

    private int capacity;
    final double FactorDeCarga = 0.75;
    private Entry<K, V>[] table;
    MyLinkedListImpl<K> keys = new MyLinkedListImpl<>();
    MyLinkedListImpl<V> values = new MyLinkedListImpl<>();
    float size = 0;

    public MyHashCerrado() {
        this.capacity = 16;
        this.table = new Entry[capacity];
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setTable(Entry<K, V>[] table) {
        this.table = table;
    }

    private int hash(K key) {
        return key.hashCode();
    }

    public void put(K key, V value) throws YaExiste {
        int a = 0;
        boolean com = false;
        if (size / capacity >= FactorDeCarga) {
            resize();
            put(key,value);
        } else {
            int indice = hash(key) % capacity;
            Entry<K, V> nuevo = new Entry<>(key, value);
            while (!com) {
                a++;
                if (table[indice] == null || table[indice].isDeleted()) {
                    table[indice] = nuevo;
                    com = true;
                    size = size + 1;
                    keys.add(key);
                    values.add(value);
                } else if (table[indice].getKey() == key) {
                    throw new YaExiste();
                } else {
                    indice = (hash(key) + a) % capacity;
                }
            }
        }

    }

    public V get(K key) throws NoEsta {
        int a = 0;
        int indice = hash(key) % capacity;
        int cont = 0;
        if(table[indice] != null) {
            while (table[indice].getKey() != key) {
                a++;
                indice = (hash(key) + a) % capacity;
                cont = cont + 1;
                if (cont > capacity) {
                    throw new NoEsta();
                }
            }
            if (table[indice].isDeleted()) {
                throw new NoEsta();
            } else {
                return table[indice].getValue();
            }
        }else {
            throw new NoEsta();
        }
    }

    public Boolean contains(K key) {
        int a = 0;
        int indice = hash(key) % capacity;
        int cont = 0;
        if (table[indice] != null) {
            while (table[indice].getKey() != key) {
                a++;
                indice = (hash(key) + a) % capacity;
                cont = cont + 1;
                if (cont > capacity) {
                    return false;
                }
                if(table[indice] == null){
                    return false;
                }
            }
            if (table[indice].isDeleted()) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }

    public void remove(K key) throws NoEsta {
        int a = 0;
        int indice = hash(key)%capacity;
        int cont = 0;
        if(table[indice] != null) {
            while (table[indice].getKey() != key) {
                a++;
                indice = (hash(key) + a) % capacity;
                cont = cont + 1;
                if (cont > capacity) {
                    throw new NoEsta();
                }
            }
            table[indice].setDeleted(true);
            size = size - 1;
            K keyTemp = table[indice].getKey();
            V valueTemp = table[indice].getValue();
            keys.remove(keyTemp);
            values.remove(valueTemp);
            rehash(indice);
        }
        else {
            throw new NoEsta();
        }

    }

    public MyLinkedListImpl<K> Keys() {
        return keys;
    }

    public MyLinkedListImpl<V> Values() {
        return values;
    }

    public float size(){
        return size;
    }
    public int capacity(){
        return capacity;
    }


    public void rehash(int indice) {
            if(indice == capacity){
                indice = 0;
            }
            else {
                indice = indice +1;
            }
            if(table[indice]!=null) {
                if (!table[indice].isDeleted()) {
                    K keyTemp = table[indice].getKey();
                    V valueTemp = table[indice].getValue();
                    table[indice].setDeleted(true);
                    size--;
                    try {
                        this.put(keyTemp, valueTemp);
                    } catch (YaExiste e) {
                    }
                    rehash(indice);
                }
            }
    }
    public void resize() {
        setCapacity(capacity * 2);
        Entry<K, V>[] nuevatable = new Entry[capacity];
        setTable(nuevatable);
        for (int i = 0; i < Keys().size() ; i++) {
            boolean com = false;
            int a = 0;
            K keyTemp = Keys().get(i);
            V valueTemp = Values().get(i);
            int indice = hash(keyTemp) % capacity;
            Entry<K, V> nuevo = new Entry<>(keyTemp, valueTemp);
            while (!com) {
                a++;
                if (nuevatable[indice] == null) {
                    nuevatable[indice] = nuevo;
                    com = true;
                }
                else{
                    indice = (hash(keyTemp)+a)%capacity;
                }
            }
        }
    }

    public int indice(K key) throws NoEsta {
        int a = 0;
        int indice = hash(key) % capacity;
        int cont = 0;
        if (table[indice] != null) {
            while (table[indice].getKey() != key) {
                a++;
                indice = (hash(key) + a) % capacity;
                cont = cont + 1;
                if (cont > capacity) {
                    throw new NoEsta();
                }
            }
            return indice;
        }
        else{
            throw new NoEsta();
        }
    }

}
