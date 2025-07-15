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
    }
}