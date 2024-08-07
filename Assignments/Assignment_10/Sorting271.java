public class Sorting271 {
    //RUN ME
    public static void main(String[] args){
    int[] a = {1,2,8,9};
    int[] b = {0,5,6,7};
    int[] c = merge(a,b);
    int[] a_unsorted = {9,8,2,1};
    int[] b_unsorted = {7,6,5,0};
    int[] c_unsorted = merge(a_unsorted,b_unsorted);
    
    System.out.println(toString(a));
    System.out.println(toString(b));
    System.out.println(toString(c));
    System.out.println("Merged \n");
    System.out.println(toString(sort(a_unsorted)));
    System.out.println(toString(sort(b_unsorted)));
    System.out.println("Sorted");
    System.out.println(toString(sort(c_unsorted)));
    System.out.println("Merged + Sorted");

    }
    /*
    I am still unsure why, but I had to write my own "toString" method
    for the int[] array to work. I based it off of previous toString method overwrites.
    It doesn't feel like the right solution but experimenting lead to this
    */

    public static String toString(int[] array) {
        //null case
        if (array == null) {
        return "null";
        }
        //Empty case
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');

        int counter = 0;
        while (counter < array.length) {
            b.append(array[counter]);
            counter++;
            if (counter < array.length) {
                b.append(", ");
            }
        }

        b.append(']');
        return b.toString();
    } // ToString method

    private static int[] merge(int[] left, int[] right) {
        //Create empty array that is the length of a and b
        int[] merged = new int[left.length + right.length];
        int left_position = 0, right_position = 0, merged_position = 0;

        // Merge the two arrays until one of them is empty
        while (left_position < left.length && right_position < right.length) {
            
            if (left[left_position] <= right[right_position]) {
                merged[merged_position++] = left[left_position++];
            
            } else {
                merged[merged_position++] = right[right_position++];
            }
        }

        // Copy any remaining elements from either array (left and right)
        while (left_position < left.length) {
            merged[merged_position++] = left[left_position++];
        }
        while (right_position < right.length) {
            merged[merged_position++] = right[right_position++];
        }
        
        return merged;
    } // Merge Method

    private static int[] sort(int[] array){
        if (array.length <= 1) {
            return array; // If the array is of length 1 or less, return (it's sorted!)
        }

        // Find the middle index
        int mid = array.length / 2;

        // Create the left and right subarrays
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Fill the left subarray
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        // Fill the right subarray
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        // Sort each half and merge the sorted halves
        return merge(sort(left), sort(right));
    }// Sort Method
}