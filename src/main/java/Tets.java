
public class Tets {

	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}

	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i; j < n; j++) {
				if (arr[j] < arr[minIndex])
					minIndex = j;
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

	public static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int nextEle = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > nextEle) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = nextEle;
		}

	}

	public static void mergeSortDriver(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			// Sort first and second halves
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);

		}
	}

	public static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;// plus
		int n2 = r - m;
		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			leftArray[i] = arr[l + i];
		}

		for (int i = 0; i < n2; i++) {
			rightArray[i] = arr[m + 1 + i];
		}

		int i = 0;
		int j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (leftArray[i] < rightArray[j])
				arr[k++] = leftArray[i++];
			else
				arr[k++] = rightArray[j++];
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}

	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			int p = partition(arr, l, r);

			quickSort(arr, l, p);
			quickSort(arr, p+1, r);

		}
	}

	private static int partition(int[] arr, int l, int r) {
		int p = l;
		int s = l;
		int e = r;

		while (s < e) {
			while (arr[p] >= arr[s]) {
				s++;
			}
			while (arr[p] < arr[e]) {
				e--;
			}
			if (s < e) {
				int temp = arr[s];
				arr[s] = arr[e];
				arr[e] = temp;
			}
		}
		int temp = arr[p];
		arr[p] = arr[e];
		arr[e] = temp;
		return e;

	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 1, 5, 10, 7, 9 };
		System.out.println("Unsorted-");
		print(arr);

//		bubbleSort(arr);
//		System.out.println("Bubble sorted-");
//		print(arr);

//		selectionSort(arr);
//		System.out.println("\nSelection sorted-");
//		print(arr);
//
//		insertionSort(arr);
//		System.out.println("\nInser sorted-");
//		print(arr);

//		mergeSortDriver(arr);
//		System.out.println("\nMerge sorted-");
//		print(arr);
		
		
		quickSort(arr, 0, arr.length-1);
		
		print(arr);

	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
