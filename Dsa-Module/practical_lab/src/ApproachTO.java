public class ApproachTO {
    static int smallest = 9;
    static int largest = 0;
    static int secondSmallest = 9;
    static int secondLargest = 0;

    static void Bhendi(int arr[], int arr2[]) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }

            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            }
        }

        for (int j = 0; j < arr2.length; j++) {

            if (arr2[j] > largest) {
                secondLargest = largest;
                largest = arr2[j];
            }

            if (arr2[j] < smallest) {
                secondSmallest = smallest;
                smallest = arr2[j];
            }
        }

        System.out.println("largest " + largest);
        System.out.println("smallest " + smallest);
        System.out.println("second largest " + secondLargest);
        System.out.println("second smallest " + secondSmallest);
    }

    public static void main(String[] args) {
        int t[] = {6, 7, 8, 3, 2};
        int u[] = {5, 4, 1, 9};

        Bhendi(t, u);
    }
}