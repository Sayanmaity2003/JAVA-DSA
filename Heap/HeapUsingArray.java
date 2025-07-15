import java.util.*;
public class HeapUsingArray{
    public static class maxHeap{
        int arr[];
        int size; //total elements in heap
        int total_size; //total size of array

        maxHeap(int n){
            arr = new int[n];
            this.size = 0;
            this.total_size = n;
        }

        //insert into the heap
        void insert(int val){
            //check if heap size is available or not
            if(size == total_size){
                System.out.println("Heap overflow");
                return;
            }

            //perform insert operation
            //step1: insert new value at last
            arr[size] = val;
            

            //step2: swap parent and child until child < parent
            int child = size;
            int par = (child-1)/2;
            while(arr[child] > arr[par]){
                int temp = arr[child];
                arr[child] = arr[par];
                arr[par] = temp;
                child = par;
                par = (child-1)/2;
            }
            size++;
            System.out.println(val+" is inserted into the heap");
        }

        void print(){
            for(int i=0; i<size; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }

        void delete(){
            if(size==0){
                System.out.println("Heap Underflow");
                return;
            }
            System.out.println(arr[0]+" is deleted from the heap");
            arr[0] = arr[size-1];
            size--;

            if(size==0){
                return;
            }else{
                heapify(0);
            }
        }

        private void heapify(int idx){
            int root = idx;
            int left = 2*idx + 1;
            int right = 2*idx + 2;
            int max = root;

            if(left < size && arr[left] > arr[max]){
                max = left;
            }
            if(right < size && arr[right] > arr[max]){
                max = right;
            }

            if(max!=root){
                int temp = arr[max];
                arr[max] = arr[root];
                arr[root] = temp;

                heapify(max);
            }


        }
        
    }
    public static void main(String args[]){
        maxHeap h1 = new maxHeap(6);
        h1.insert(4);
        h1.insert(14);
        h1.insert(11);
        // h1.insert(3);
        h1.print();
        h1.insert(114);
        h1.insert(24);
        h1.insert(1);
        h1.print();

        h1.delete();
        h1.delete();
    }
}