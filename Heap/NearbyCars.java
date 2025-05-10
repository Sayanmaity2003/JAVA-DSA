import java.util.*;
public class NearbyCars{
    public static class Point implements Comparable<Point>{
        int x;
        int y;
        int distance;
        int idx;

        Point(int x, int y, int distance, int idx){
         this.x = x;
         this.y = y;
         this.distance = distance;  
         this.idx = idx; 
        }

        // @override
        public int compareTo(Point p2){
            return this.distance - p2.distance; //ascending order sorting
        }

    }
    public static void main(String args[]){
        int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<pts.length; i++){
            int distance = (pts[i][0] * pts[i][0]) + (pts[i][1] * pts[i][1]);
            pq.add(new Point(pts[i][0], pts[i][1], distance, i));
        }
        //Nearest K cars
        for(int i=0; i<k; i++){
            System.out.println("C"+pq.remove().idx); //idx is used to print the value of the idx variable of each object
        }
    }
}