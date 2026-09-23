package DSAQuestions;

public class quicksort {
//{5,3,7,6,2};
    static int partition(int[] arr,int low,int high)
    {
     int pivot = arr[high];
     int i = low-1;

     for(int j = low;j<high;j++)
     {
         if(arr[j] < pivot)
         {
             i++;
             int temp = arr[i];
             arr[i] = arr[j];
             arr[j] = temp;
         }
     }

     int temp = arr[i+1];
     arr[i+1] = arr[high];
     arr[high] = temp;

     return i+1;

    }

    static void quickSort(int[] arr,int low,int high)
    {
        if(low<high)
        {
            int pivotIndex = partition(arr,low,high);

            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
        }
    }
    public static void main(String[] args) {

        //int[] arr = {5,3,7,6,2};
        int[] arr = {24,9,29,14,19,27};
        quickSort(arr,0,arr.length-1);

        for (int j : arr) {
            System.out.print(j + " ");
        }


    }
}
