import java.util.Arrays;

public class MinimumSwap {

    public static void main(String [] args) {
        int arr[] = {2 ,3 ,4 ,1 ,5};
        System.out.println(minimumSwaps(arr));
    }

    public static int minimumSwaps(int[] arr) {

        int copy[] = arr.clone();
        Arrays.sort(copy);

        int minimumMoves = 0;

        for(int i=0; i< arr.length; i++) {
                if (copy[i] != arr[i]) {
                    minimumMoves++;
                    swap(arr, i, indexOf(arr, copy[i]));
                }
        }
        return minimumMoves;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int indexOf(int arr[], int element) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
