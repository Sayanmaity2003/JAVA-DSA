import java.util.*;

public class HeapStructure{
    public static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            //add at last idx
            arr.add(data);
            int x = arr.size()-1; //x is child idx
            int par = (x-1)/2; //par is parent idx

            while(arr.get(x) < arr.get(par)){
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }

    public int peek(){
        return arr.get(0);
    }
    private void heapify(int idx){
        int curr = idx;
        int left = 2*idx+1;
        int right = 2*idx+2;

        int minIdx = curr; //default

        //check wheather it is a leaf node
        //Find the minimum element
         if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

        //Check wheather the minIdx is same as the default, if not then swap
        if(minIdx!=curr){

        //Swap the min-element with the root
        int temp = arr.get(curr);
        arr.set(curr, arr.get(minIdx));
        arr.set(minIdx, temp);

        heapify(minIdx); //There may be case that by swapping the minIdx with root,
        // the below structure may affected, so call the below structure under heapify

        }

        


    }
    public void remove(){
        int data = arr.get(0);

        //Swap first and last;
        int firstIdx =arr.get(0);
        int lastIdx = arr.get(arr.size()-1);

        int temp = firstIdx;
        arr.set(0, lastIdx);
        arr.set((arr.size()-1), temp);


        //delete last idx
        arr.remove(arr.size()-1);

        //Heapify
        heapify(0);

        // return data;

    }
    public boolean isEmpty(){
        return arr.size() == 0;
    }
    }
    public static void main(String args[]){
        Heap h = new Heap();

        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}

//To make it print in reverse(large to small) make cmparison changes in line 13, 36, 39