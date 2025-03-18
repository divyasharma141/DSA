public class heap_sort {
    /**
    Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure to sort elements efficiently. It has a time complexity of O(n log n) and works in two main steps:

    Steps of Heap Sort
        1.Build a Max Heap (for ascending order sort):

            Convert the input array into a max heap (where the largest element is at the root).
            This is done by applying the heapify function from n/2 down to 1.

        2.Extract elements one by one:
            Swap the root (maximum element) with the last element.
            Reduce the heap size and apply heapify to restore the heap property.
            Repeat until all elements are sorted. 
    */

    public static void heapSort(int[] heap, int n){
        //swap with last element as we know our first ele will be the greatest ele 

        while (n!=1) {
            int temp=heap[1];
            heap[1]=heap[n];
            heap[n]= temp;
    
            //n0w heapify the remaining heap 
            n--;
            heapify(heap, 1, n); 
        }
        
    }

    public static void main(String[] args) {

        //Build Max Heap 
        //Heapify function 
        int[] heap= {0,80, 60, 70, 60, 33, 40, 50, 30, 30, 22, 20};

        
        heapSort(heap, heap.length-1);

        for(int i= 1;i<=heap.length-1;i++){
            System.out.print(heap[i]+" ");
        }

    }


public static void heapify(int[] heap, int ind, int n){

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
        heapify(heap, largest, n);
    }
}
}

// Heapify: O(log n)
// Building Heap: O(n)
// Sorting Process: O(n log n)
//Final Complexity: O(n log n)