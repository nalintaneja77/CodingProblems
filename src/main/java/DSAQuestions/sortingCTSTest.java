package DSAQuestions;

public class sortingCTSTest {

    public static void main(String[] args) {

        int[] odd ={-3,3};
        int[] even = {2};

        int[] newarry = new int[odd.length+even.length];
        int index = 0;

        for(int i = 0;i<odd.length;i++)
        {
            newarry[index] = odd[i];
            index = index+1;
        }

        for(int j = 0;j<even.length;j++)
        {
            newarry[index] = even[j];
            index = index+1;
        }

        //{-3,3,2}
        //bubble sort

        for(int i = 0;i<newarry.length;i++)
        {
            for(int j = 0;j<newarry.length-i-1;j++)
            {
                if(newarry[j]>newarry[j+1])
                {
                    int temp = newarry[j];
                    newarry[j] = newarry[j+1];
                    newarry[j+1] = temp;
                }
            }
        }


        for (int j : newarry) {
            System.out.print(j + " ");
        }
    }
}
