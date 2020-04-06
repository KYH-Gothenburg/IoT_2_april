package main.java;

class BackupSearch {
    public static int linearSearch(int arr[], int elementToSearch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elementToSearch) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int elementToSearch) {
        int first = 0;
        int last = arr.length - 1;

        while (first <= last) {
            int mid = (first + last) / 2;
            if (arr[mid] == elementToSearch) {
                return mid;
            }
            // elementToSearch is higher than value on index mid
            else if (arr[mid] < elementToSearch) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }

        }
        return -1;
    }

    private static int binarySearchRecursive(int[] arr, int first, int last, int elementToSearch) {
        if (first <= last) {
            int mid = (first + last) / 2;
            if (arr[mid] == elementToSearch) {
                return mid;
            }
            // elementToSearch is higher than value on index mid
            else if (arr[mid] < elementToSearch) {
                return binarySearchRecursive(arr, mid + 1, last, elementToSearch);
            } else {
                return binarySearchRecursive(arr, first, mid - 1, elementToSearch);
            }
        }
        return -1;
    }

    private static int interpolationSearch(int[] arr, int elementToSearch) {
        int first = 0;
        int last = arr.length - 1;
        while ((first <= last) && (elementToSearch >= arr[first]) && (elementToSearch <= arr[last])) {
            int pos = first + (((last - first) / (arr[last] - arr[first])) * (elementToSearch - arr[first]));
            if (arr[pos] == elementToSearch) {
                return pos;
            } else if (arr[pos] < elementToSearch) {
                first = pos + 1;
            } else {
                last = pos - 1;
            }
        }
        return -1;
    }

    public static void main2(String[] args) {
        int[] values = new int[1000000];

        for (int i = 0; i < 3000000; i += 3) {
            values[i / 3] = i;
        }
        System.out.println("Linear found " + linearSearch(values, 2760000)); // 920000
        System.out.println("Linear not found " + linearSearch(values, 2760001)); // -1
        System.out.println("Binary found " + binarySearch(values, 2760000)); // 920000
        System.out.println("Binary not found " + binarySearch(values, 2760001)); // -1
        System.out.println("Binary Recursive found " + binarySearchRecursive(values, 0, values.length - 1, 2760000)); // 920000
        System.out
                .println("Binary Recursive not found " + binarySearchRecursive(values, 0, values.length - 1, 2760001)); // -1
        System.out.println("Interpolation found " + interpolationSearch(values, 2760000)); // 920000
        System.out.println("Interpolation not found " + interpolationSearch(values, 2760001)); // -1
        // 2 760 000 -> 920000
        // 2 760 001 -> -1

    }

}