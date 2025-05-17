// Weakest soldiers
// We are given an mxn binary matrix of 1's(soldiers) and 0's(civilians). 
// The soldiers are positioned in front of the civilians
// That is, all the 1;s will appear to the left of all th 0's in each row

// A row i is weaker than row j if one of the is true:
// i. The no of soldiers in row i < no of soldiers in  row j
// ii. Both rows have the same number of soldiers and i<j
// Find the k weakest rows-

// Ex: m=4, n=4, k=2
// 1 0 0 0
// 1 1 1 1
// 1 0 0 0 
// 1 0 0 0 

// ans: Row0, Row2

import java.util.*;
class WeakestSoldier{
         static class Row implements Comparable<Row>{
            int soldiers; //No of soldiers / row
            int idx; // Row no. / row

            public Row(int soldiers, int idx){
                this.soldiers = soldiers;
                this.idx = idx;
            }

            @Override
            public int compareTo(Row r2){
                if(this.soldiers == r2.soldiers){
                    return this.idx - r2.idx;
                }else{
                    return this.soldiers - r2.soldiers;
                }
            }
        }
    public static void main(String args[]){

        //Matrix of the Soldiers and civilians as 0 & 1
        int army[][] = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
        };
        //No of weakest rows to print

        int k = 2;
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i=0; i<army.length; i++){
            int soldiersCount = 0;

            //Counts the soldiers in each row
            for(int j=0; j<army[i].length; j++){
                soldiersCount += army[i][j] == 1 ? 1 : 0;
            }
            //Add (no.of soldiers and row no.) in the queue
            for(int j=0; j<army[i].length; j++){
                soldiersCount += army[i][j] == 1 ? 1 : 0;
            }

            pq.add(new Row(soldiersCount, i));
        }

        for(int i=0; i<k; i++){
            System.out.println("R"+pq.remove().idx);
        }
    }
}