package com.solutions.leetcode.customs;

import java.util.LinkedList;

/**
 * LIFO - we only be able to use pop,push,peek
 */
public class CustomStack<T> {
    // doubly linked list
    private LinkedList<T> stack;

    public CustomStack(){
        this.stack = new LinkedList<>();
    }

    public void push(T object){
        stack.push(object);
    }

    public T peek(){
        return stack.peek();
    }

    public T poll(){
        return stack.poll();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int size(){
        return stack.size();
    }
}
