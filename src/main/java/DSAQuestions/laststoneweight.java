package DSAQuestions;

import java.util.PriorityQueue;

public class laststoneweight {

    public int lastStoneWeight(int[] stones) {


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));

        for(int stone:stones)
        {
            maxHeap.add(stone);
        }

        while(maxHeap.size()>1)
        {
            int largest = maxHeap.poll();
            int nextLargest = maxHeap.poll();

            if(largest!= nextLargest)
            {
                maxHeap.offer(largest-nextLargest);
            }
        }

        if(maxHeap.isEmpty())
        {
            return 0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {

        laststoneweight laststoneweightnn = new laststoneweight();
        int[] stones = {2,3,6,2,4};
        System.out.println(laststoneweightnn.lastStoneWeight(stones));

    }
}
