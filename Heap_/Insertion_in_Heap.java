public class Insertion_in_Heap {

    public static int[] heap= new int[10];
    public static int size=0;

    public static void insertion (int val){
        // place the value to end of the heap
        int ind= size;
        heap[ind]= val;
        size++;

        //check if its the coreect position 
        // in array represntation of heap the parent is at i and child is at 2*i, 2*i+1
       

        while (ind>0) {
            int parent= (ind - 1) / 2;
            if(heap[ind]> heap[parent]){
                //swap the node 
                int temp= heap[parent];
                heap[parent]= heap[ind];
                heap[ind]= temp;
    
                ind= parent ;// now the val is at parent index 
            }


            else break;
        }
        
        for (int i = 0; i <size; i++) {
            System.out.print(heap[i]+" ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // Insertion in Heap 

        /**
            You are given an integer N (representing the count of elements) and N integers
            You need to add these N integers in your heap
            You have to print the array after each insertion
        */
        insertion(2);
        insertion(8);
        insertion(2);
        insertion(20);
        insertion(92);


    }
}