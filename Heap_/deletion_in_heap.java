public class deletion_in_heap {

    public static int[] heap={0, 100, 50, 60, 20,40,45,60,5,10} ;
    public static int size=9;

    public static void deletion(int val){

        //find the node
        int ind=-1; 
        for(int i=1;i<=size;i++){
            if(heap[i]==val){
                ind= i;
                break;
            }            
        }

        if(ind==-1){
                System.out.println("Node is not present");
                return;
        }

        // replce the val node with the last node
        heap[ind]= heap[size];
        size--;

        //now place the replaced node at corrrect postition 
        while (ind<size) {
            int leftChild= 2*ind;
            int rightChild= 2*ind+1;
            int largest= ind; // Assume current node is largest

            if(leftChild <= size && heap[largest] < heap[leftChild]){
                largest= leftChild;
            }

            //no need of extra swapping in every step 
            // as left right greater smaller doesnt matter in haep 
            // its just that parent must be smaller/greater than children  
            //direclty swap with right

            if (rightChild<= size && heap[largest]<heap[rightChild]) {
                largest= rightChild;
            }

            if(largest== ind){
                //val at correct pos;
                break;
            }

            int temp= heap[ind];
            heap[ind]= heap[largest];
            heap[largest]= temp;

            // Move index down
            ind = largest;


        }


        for(int i=1;i<=size;i++){
            System.out.print(heap[i]+" ");
        }

        System.out.println();
    }

    public static void main(String[] args) {



        deletion(60);
        deletion(5);
        deletion(100);
        deletion(10);
        deletion(20);
        deletion(40);
        deletion(60);
    }
}