//PROBLEM STATEMENT:
// Given are N ropes of diffrenet lengths, the task is to connect these ropes into one rope with minimum cost, 
// these ropes into one rope with minimum cost, 
// such that the cost to connect two ropes is equal to the sum of their lengths
// Given: ropes{4,3,2,6}
//         Rope(2,3) => 2+3 = 5
//         Rope(5,4) => 5+4 = 9
//         Rope(9,6) => 9+6 = 15
//         ---------------------
//               Total Cost = 29

// Approach:
// Step 1: Put all the array elements into the "PriorityQueue" to make it in "asc"
// Step 2: Remove  the first two minimum elements and add it's sum into the "PriorityQueue"
// Step 3: Add the sum in a "cost" variable in each iteration(To calculate the total cost)
// Step 4: Repeat "Step 2 & 3" until the remaining element in the "PriorityQueue" is 1


import java.util.PriorityQueue;
public class ConnectNRopes{
    public static void main(String args[]){
        //Given Rope lengths
        int ropes[] = {4, 3, 2, 6};
        int ropeSize = ropes.length;

        // Step 1:
        //PriorityQueue used to order the elements in "asc"
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //Put all the elements in the array into the queue
        for(int i=0; i<ropeSize; i++){
            pq.add(ropes[i]);
        }
        //This is cost variable(Calculates the total cost)
        int cost = 0;

        //Step 4:
        //Performs the opeartion of "Step 2 & 3" until only 1 element is left in the queue
        while(pq.size()>1){
            // Step 2:
            //Remove the first minimum element in the queue
            int min1 = pq.remove();
            //Remove the second minimum element in the queue
            int min2 = pq.remove();
            //Add the sum in the Queue
            pq.add(min1+min2);
            
            //Step 3:
            //Sum two minimum elements and store it's cost into the cost variable
            cost += (min1+min2);
        }
        System.out.print("Cost for connecting "+ropeSize+" ropes is: "+cost);
    }
}