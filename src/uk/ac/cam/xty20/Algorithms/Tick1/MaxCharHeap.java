package uk.ac.cam.xty20.Algorithms.Tick1;

import uk.ac.cam.cl.tester.Algorithms.EmptyHeapException;
import uk.ac.cam.cl.tester.Algorithms.MaxCharHeapInterface;

public class MaxCharHeap implements MaxCharHeapInterface {
    private char[] heap;
    public MaxCharHeap (char[] x) {
        heap = x;
    }

    @Override
    public void insert(char e) {
        int size = heap.length;
        char[] newHeap = new char[size+1];
        for(int x = 0; x < size; x++){
            newHeap[x] = heap[x];
        }
        newHeap[size] = e;

    }

    @Override
    public char popMax() throws EmptyHeapException {
        return 0;
    }

    @Override
    public int getLength() {
        return 0;
    }
}
