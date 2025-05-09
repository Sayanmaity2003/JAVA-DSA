public class HeapSort{
    public static void heapify(int arr[], int idx, int n){
        int root = idx;
        int left = 2*idx+1;
        int right = 2*idx+2;

        int maxIdx = root; //default

        //Calculate the max idx
        if(left<n && arr[left]>arr[maxIdx]){
            maxIdx = left;
        }
        if(right<n && arr[right]>arr[maxIdx]){
            maxIdx = right;
        }

        //Swap if default max changes
        if(maxIdx != root){
            //Swap(maxIdx, root)
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[root];
            arr[root] = temp;
            heapify(arr, maxIdx, n);
        }
        
    }
    public static void hSort(int arr[]){
        //Step1: convert the arr to maxHeap
        int arrSize = arr.length;
        for(int i=arrSize/2; i>=0; i--){
            heapify(arr, i, arrSize);
        }

        //Step2: 
        // for(int i=arrSize-1; i>0; i--){
        arrSize--;
        while(arrSize!=0){
        //i. Push Largest element to the end idx by swapping
        int temp = arr[arrSize];
        arr[arrSize] = arr[0];
        arr[0] = temp;

        //ii. Call heapify
        heapify(arr, 0, arrSize);

        //iii.Decrease the array or heap size
        arrSize--;
        
        }

    }
    public static void main(String args[]){
        int arr[] = {1, 2, 4, 5, 3};

        hSort(arr);
        
        for(int i=0; i<5; i++){
            System.out.println(arr[i]);
        }
    }
}