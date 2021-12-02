package com.solutions.leetcode.customs;

// if random access is an issue use BST instead. this is used for max value !!
public class CustomMaxHeap { // can say priorityQueue implementation of min heap
    private int[] heap;
    private int size;

    public CustomMaxHeap(int capacity) {
        this.heap = new int[capacity];
    }

    // O(n log n)
    public CustomMaxHeap(int[] array) {
        this.heap = new int[2 * array.length]; //when re-size use double common notation
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public int peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is empty");
        return heap[0];
    }

    public int poll() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is empty");
        int value = heap[size - 1];
        this.delete(0);
        return value;
    }

    // O(log n) -> heapify
    public void insert(int value) {
        if (isFull())
            throw new IndexOutOfBoundsException("Heap is full"); // can be resized
        this.heap[size] = value;
        this.fixHeapAbove(size);
        size++;
    }

    // O(n log n) -> n for loop, log n for fixHeapBelow
    // After sort this is not a heap
    public void sortAsc() {
        int lastHeapIndex = size - 1;
        for (int i = 0; i < lastHeapIndex; i++) {
            int tmp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = tmp;
            fixHeapBelow(0, lastHeapIndex - i - 1);
        }
    }

    // O(n log n) -> n for search, log n for delete
    public int deleteWithValue(int value) {
        for (int i = 0; i < size; i++) {
            if (heap[i] == value) {
                return this.delete(i);
            }
        }
        throw new IllegalArgumentException("Given value not found in heap");
    }

    // O(log n) -> heapify
    public int delete(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is empty");
        int deletedValue = this.heap[index];
        this.heap[index] = this.heap[size - 1];
        int parent = getParent(index);
        if (index == 0 || heap[index] < heap[parent]) {
            this.fixHeapBelow(index, size - 1);
        } else {
            this.fixHeapAbove(index);
        }
        size--;
        return deletedValue;
    }

    // O(log n)
    private void fixHeapAbove(int index) {
        int newValue = this.heap[index];
        while (index > 0 && newValue > this.heap[this.getParent(index)]) {
            heap[index] = this.heap[this.getParent(index)];
            index = this.getParent(index);
        }
        heap[index] = newValue;
    }

    // O(log n)
    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;
        while (index <= lastHeapIndex) {
            int leftChild = this.getLeftChild(index);
            int rightChild = this.getRightChild(index);
            if (leftChild <= lastHeapIndex) { // if there is no left child it is not possible to have right child
                if (rightChild >= lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
                }
                if (heap[index] <= heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    break;
                }
                index = childToSwap;
            } else {
                break;
            }
        }
    }

    public boolean isFull() {
        return size == this.heap.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public int getLeftChild(int index) {
        return (2 * index) + 1;
    }

    public int getRightChild(int index) {
        return (2 * index) + 2;
    }
}
