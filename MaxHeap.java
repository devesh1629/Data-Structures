public class MaxHeap {

    private int currSize;
    private int maxSize;
    private int[] Heap;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.currSize = 0;
        Heap = new int[this.maxSize];
    }
    private int parent(int pos) { return (pos-1)/2; }

    private int leftChild(int pos) { return (2 * pos) + 1; }
 
    private int rightChild(int pos) { return (2 * pos) + 2; }

    private boolean isLeaf(int pos) {
        if (pos > (currSize / 2) && pos <= currSize)
            return true;
        return false;
    }
    private void swap(int fpos, int spos) {
        int tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
    // During deletion, root is removed and last element is placed in place of root
    // Heapify given tree (arranges the tree after deletion)
    private void maxHeapify(int pos) {
        if(isLeaf(pos))
            return;
        if((Heap[pos] < Heap[leftChild(pos)]) || (Heap[pos] < Heap[rightChild(pos)])) {
            if(Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
            else {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
        }
    }
    public void insert(int val) {
        Heap[currSize] = val;
        int current = currSize;
        while(Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        currSize++;
    }
    public int extractMax() {
        int popped = Heap[0];
        Heap[0] = Heap[currSize];
        currSize--;
        maxHeapify(0);
        return popped;
    }
    public void print() {
        for(int i=0; i<currSize; i++)
            System.out.print(Heap[i] + " ");
        System.out.println();
    }
    public void printSortedOrder() {
        while(currSize > 0)
            System.out.print(extractMax() + " ");
        System.out.println();
    }
    public static void main(String args[]) {
        MaxHeap maxHeap = new MaxHeap(15);
 
        // Inserting nodes
        // Custom inputs
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.print();
        maxHeap.printSortedOrder();
    }    
}