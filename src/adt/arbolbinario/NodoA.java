package adt.arbolbinario;
import adt.linkedlist.MyList;

    public class NodoA<K extends Comparable<K>, V> {

        private K key;

        private V value;

        private NodoA<K, V> left;

        private NodoA<K, V> right;

        public NodoA(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void add(K key, V value) {
            NodoA<K, V> elementToAdd = new NodoA<>(key, value);
            if (key.compareTo(this.key) > 0) {

                if (right == null) {

                    right = elementToAdd;

                } else {

                    right.add(key, value);

                }
            } else {
                if (left == null) {

                    left = elementToAdd;
                } else {

                    left.add(key, value);
                }
            }

        }

        public NodoA<K, V> remove(K key) {
            NodoA<K, V> elementToReturn = this;

            if (key.compareTo(this.key) > 0) {

                if (right != null) {

                    right = right.remove(key);

                }

            } else if (key.compareTo(this.key) < 0) {

                if (left != null) {

                    left = left.remove(key);

                }
            } else if (left != null && right != null) {

                // Encontre el elemento a eliminar

                NodoA<K, V> min = right.findMin();

                this.key = min.getKey();
                this.value = min.getValue();

                right = right.remove(min.getKey());

            } else {

                if (left != null) {

                    elementToReturn = left;

                } else {

                    elementToReturn = right;

                }

            }

            return elementToReturn;
        }

        public void inOrderTraverse(MyList<K> traverse) {
            if (left != null) {

                left.inOrderTraverse(traverse);

            }

            traverse.add(this.getKey());

            if (right != null) {

                right.inOrderTraverse(traverse);

            }
        }
        //postOrden
        public void postOrderTraverse(MyList<K> traverse) {
            if (left != null) {

                left.postOrderTraverse(traverse);

            }

            if (right != null) {

                right.postOrderTraverse(traverse);

            }
            traverse.add(this.getKey());
        }
        //preOrden
        public void preOrderTraverse(MyList<K> traverse) {
            traverse.add(this.getKey());

            if (left != null) {

                left.preOrderTraverse(traverse);

            }

            if (right != null) {

                right.preOrderTraverse(traverse);

            }
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public NodoA<K, V> getLeft() {
            return left;
        }

        public void setLeft(NodoA<K, V> left) {
            this.left = left;
        }

        public NodoA<K, V> getRight() {
            return right;
        }

        public void setRigth(NodoA<K, V> rigth) {
            this.right = rigth;
        }

        public NodoA<K, V> findMin() {
            NodoA<K, V> oReturn = this;

            if (left != null) {

                oReturn = left.findMin();

            }

            return oReturn;
        }
    }

