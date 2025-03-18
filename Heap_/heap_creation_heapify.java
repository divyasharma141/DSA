public class heap_creation_heapify {
    /**
     * heapify is something when you olace the node at its correct position in order to creat e a heap 
     */

     public static void heapify(int[] heap,int val, int ind, int n){

        int leftChild= 2* ind;
        int rightChild= 2*ind+1;
        int largest= ind;

        if(leftChild<=n && heap[largest] < heap[leftChild]){
            largest= leftChild;
        }

        if(rightChild <= n && heap[largest]< heap[rightChild]){
            largest= rightChild;
        }

        if(largest!=ind){
            int temp= heap[largest];
            heap[largest]= heap[ind];
            heap[ind]= temp;

            // ind= largest updating ind = largest alone does not restart heapify, causing an incomplete heap.

            // now heapify the element which was found to be largest 
            heapify(heap, heap[largest], largest, n);
        }

        for(int i= 1;i<=n;i++){
            System.out.print(heap[i]+" ");
        }

        System.out.println();
     }



     public static void main(String[] args) {
        int[] heap= {0, 50,30,70,60,20,40,80,30,60,22,33};
        int n= heap.length-1;
        
        /**
         * why i did n/2 here ??
         * coz in CBT i.e Heap the leaf nodes are already keep on placing on right position that why we need not to 
         * heapify them again and again 
         * and in CBT leaf nodes exist from n/2+1 to n
         * they get already process while we are processing from 0 to n/2;
         */
        for(int i=n/2;i>0 ;i--){
            heapify(heap, heap[i], i, n);
        }
        
     }
}
// Heapify: O(log n) (if we swap all the way down to the leaf).

/**
 * Heapify **fixes violations of the heap property** by comparing a node with its children.
- Since the **leaf nodes don’t have children, there’s nothing to fix**.
- Instead, we apply **heapify on non-leaf nodes** from `n/2` down to `1`.

---

### **3. Starting from `n/2` Ensures All Subtrees Become Heaps**
- If we start heapifying from **the root (index `1`) first**, the children might still be invalid heaps.
- Instead, if we **fix the smaller heaps first**, then when we reach the root, all subtrees below it are already heaps.

 */



 /**
Why is ind = largest; Not Enough?
    Example Heap (Before heapify)
    We have this array (1-based index):

    makefile
    Copy
    Edit
    Index:  1   2   3   4   5   6   7
    Heap:  [50, 30, 70, 60, 20, 40, 80]
    Tree representation:

    markdown
    Copy
    Edit
            50
        /   \
        30     70
        /  \   /  \
    60  20 40  80
    Heapify starts at index 1 (value 50).

    Left child: heap[2] = 30
    Right child: heap[3] = 70
    Largest = 3 (because 70 > 50)
    ✅ Swap 50 and 70:

    makefile
    Copy
    Edit
    Index:  1   2   3   4   5   6   7
    Heap:  [70, 30, 50, 60, 20, 40, 80]
    Now 50 is at index 3, but it’s still in the wrong place (because 80 is greater).

    Mistake: Only Updating ind = largest;
    java
    Copy
    Edit
    if(largest != ind) {
        int temp = heap[largest];
        heap[largest] = heap[ind];
        heap[ind] = temp;

        ind = largest;  // ❌ Just updating ind does nothing, we need to continue heapify!
    }
    ❌ What happens here?
    We swap 50 with 70 ✅
    We update ind = 3 ✅
    But heapify does NOT continue, so 50 does NOT move down again.
    The heap remains incorrect.
  */