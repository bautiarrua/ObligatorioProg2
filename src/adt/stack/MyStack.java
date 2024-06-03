package adt.stack;


import adt.Exceptions.EmptyStackException;

public interface MyStack<T> {

	void push(T value);
	
	T pop() throws EmptyStackException;
	
	T peek();
	
	int size();
	
}
