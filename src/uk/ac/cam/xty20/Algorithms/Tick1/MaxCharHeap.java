package uk.ac.cam.xty20.Algorithms.Tick1;

import uk.ac.cam.cl.tester.Algorithms.EmptyHeapException;
import uk.ac.cam.cl.tester.Algorithms.MaxCharHeapInterface;

import java.util.Arrays;

public class MaxCharHeap implements MaxCharHeapInterface {
    private char[] heap;
    public MaxCharHeap (char[] x) {
        heap = Arrays.copyOf(x, x.length);
        for(int y = (x.length)/2 - 1; y >= 0; y--) {
            int parent = y;
            while (2 * parent + 1 < heap.length) {
                int currMax = 2 * parent + 1;
                if(2*parent+2<heap.length){
                    if (heap[currMax] <= heap[currMax + 1]) {
                        currMax++;
                    }
                }
                if (heap[currMax] > heap[parent]) {
                    char temp = heap[currMax];
                    heap[currMax] = heap[parent];
                    heap[parent] = temp;
                    parent = currMax;
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public void insert(char e) {
        int size = heap.length;
        char[] newHeap = new char[size+1];
        System.arraycopy(heap, 0, newHeap, 0, size);
        newHeap[size] = e;
        heap = newHeap;
        for(int x = size; x >= 0; x--){
            if(heap[x] > heap[(x-1)/2]){
                char temp = heap[x];
                heap[x] = heap[(x-1)/2];
                heap[(x-1)/2] = temp;
            }
            else{
                break;
            }
        }
    }

    @Override
    public char popMax() throws EmptyHeapException {
        if (heap.length == 0){
            throw new EmptyHeapException();
        }
        else{
            char max = heap[0];
            heap[0] = heap[heap.length - 1];
            heap[heap.length - 1] = max;
            int parent = 0;
            heap = Arrays.copyOfRange(heap, 0,  heap.length - 1);
            while(2*parent + 1 < heap.length){
                int currMax = 2*parent+1;
                if(2*parent+2< heap.length){
                    if(heap[currMax] <= heap[currMax + 1]){
                        currMax++;
                    }
                }
                if(heap[currMax] > heap[parent]){
                    char temp = heap[currMax];
                    heap[currMax] = heap[parent];
                    heap[parent] = temp;
                    parent = currMax;
                }
                else{
                    break;
                }
            }
            return max;
        }
    }

    @Override
    public int getLength() {
        return heap.length;
    }

    public static void main(String[] args) {
        char[] notHeap = {'0','1','2','3','4','5','6', '7'};
        MaxCharHeap charHeap = new MaxCharHeap(notHeap);
        try{
            System.out.println(charHeap.popMax());
            System.out.println(charHeap.popMax());
            System.out.println(charHeap.popMax());
            System.out.println(charHeap.popMax());
            System.out.println(charHeap.popMax());
            System.out.println(charHeap.popMax());
            System.out.println(charHeap.popMax());
            System.out.println(charHeap.popMax());
            System.out.println(charHeap.popMax());
        }
        catch(EmptyHeapException e) {
            e.printStackTrace();
        }
        charHeap.insert('1');
        charHeap.insert('2');
        charHeap.insert('3');
        System.out.println(charHeap.heap);
    }
}
