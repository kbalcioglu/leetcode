package com.solutions.leetcode.customs;

import java.util.LinkedList;

public class CustomQueue <T> {
    // doubly linked list
    private LinkedList<T> queue;

    public CustomQueue(){
        this.queue = new LinkedList<>();
    }

    public void offer(T object){
        queue.offer(object);
    }

    public T peek(){
        return queue.peek();
    }

    public T poll(){
        return queue.poll();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int size(){
        return queue.size();
    }
}
