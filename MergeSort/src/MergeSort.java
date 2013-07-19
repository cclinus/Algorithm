import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] numberArray = { 2, 3, 1, 10, 4, 5, 0, 9, 11, -1 };
		int[] sortedArray = mergeSort(numberArray);
		System.out.println(Arrays.toString(sortedArray));
	}

	public static int[] mergeSort(int[] numberArray) {

		if (numberArray.length == 1) {
			return numberArray;
		}

		int aPivot, bPivot;
		if (numberArray.length % 2 == 0) {
			bPivot = numberArray.length / 2;
			aPivot = 0;
		} else {
			bPivot = numberArray.length / 2 + 1;
			aPivot = 0;
		}
		int[] aArrany = mergeSort(splitArray(numberArray, aPivot, bPivot - 1)); // 0-3
		int[] bArray = mergeSort(splitArray(numberArray, bPivot,
				numberArray.length - 1)); // 4-7
		return mergeArrays(aArrany, bArray);
	}

	public static int[] mergeArrays(int[] aArray, int[] bArray) {
		int[] newArray = new int[aArray.length + bArray.length];
		int a = 0, b = 0, c = 0;
		while (c != newArray.length) {

			if (a >= aArray.length) {
				for (int i = b; i < bArray.length; i++) {
					newArray[c] = bArray[i];
					c++;
				}
				return newArray;
			}

			if (b >= bArray.length) {
				for (int i = a; i < aArray.length; i++) {
					newArray[c] = aArray[i];
					c++;
				}
				return newArray;
			}

			if (aArray[a] < bArray[b]) {
				newArray[c] = aArray[a];
				a++;
			} else if (aArray[a] >= bArray[b]) {
				newArray[c] = bArray[b];
				b++;
			}
			c++;
		}
		return newArray;
	}

	public static int[] splitArray(int[] numberArray, int startPivot,
			int endPivot) {
		int length = (endPivot - startPivot) + 1;
		int[] newArray = new int[length];
		int j = 0;
		for (int i = startPivot; i <= endPivot; i++) {
			newArray[j] = numberArray[i];
			j++;
		}
		return newArray;
	}

}
