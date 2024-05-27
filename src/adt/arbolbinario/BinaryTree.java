/**
 * 
 */
package adt.arbolbinario;

import java.util.List;

public interface BinaryTree<T extends Comparable<T>> {

	void add(T oElement);

	void remove(T oElement);

	boolean contains(T oElement);

	T find(T oElement);
	
	List<T> preOrder();

	List<T> postOrder();

	List<T> inOrder();

}
