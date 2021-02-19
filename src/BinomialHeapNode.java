public class BinomialHeapNode<T> {
    private int key;
    private T data;
    private int order;
    private BinomialHeapNode<T> parent;
    private BinomialHeapNode<T> child;
    private BinomialHeapNode<T> sibling;
    public BinomialHeapNode(int key, T data){
        this.key = key;
        this.data = data;
    }
}
