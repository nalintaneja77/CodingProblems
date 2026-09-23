package DSAQuestions;

public class mergesort {

    static void mergeSort(int[] arr,int left,int right){
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        // Sort left half
        mergeSort(arr, left, mid);

        // Sort right half
        mergeSort(arr, mid + 1, right);

        // Merge both halves
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {

        // Sizes of the two halves
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // Temporary arrays
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        // Copy left half
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = arr[left + i];
        }

        // Copy right half
        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        // Merge the two sorted arrays
        while (i < leftSize && j < rightSize) {

            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < leftSize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr ={5,3,8,4};
       // int[] arr = {42, 7, 19, 88, 3, 65, 12, 54, 21, 9};
        mergeSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }

    }
}
